package ru.itmo.mobile_development_api.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.mobile_development_api.dto.ChangeGadgetStateRequest;
import ru.itmo.mobile_development_api.dto.HomeDto;
import ru.itmo.mobile_development_api.dto.RoomDto;
import ru.itmo.mobile_development_api.dto.UserDto;
import ru.itmo.mobile_development_api.entity.GadgetEntity;
import ru.itmo.mobile_development_api.enums.Action;
import ru.itmo.mobile_development_api.enums.GadgetType;
import ru.itmo.mobile_development_api.redis.RedisMessagePublisher;
import ru.itmo.mobile_development_api.repository.GadgetRepository;
import ru.itmo.mobile_development_api.repository.HomesRepository;
import ru.itmo.mobile_development_api.repository.OwnedHomesRepository;
import ru.itmo.mobile_development_api.repository.RoomsRepository;
import ru.itmo.mobile_development_api.repository.SensorsInRoomRepository;
import ru.itmo.mobile_development_api.repository.UsersRepository;
import ru.itmo.mobile_development_api.util.ObjectParser;

@RestController
@Slf4j
@RequestMapping("")
@RequiredArgsConstructor
public class MobileController {


    private final RedisMessagePublisher redisMessagePublisher;
    private final GadgetRepository gadgetRepository;

    private final HomesRepository homesRepository;
    private final OwnedHomesRepository ownedHomesRepository;
    private final RoomsRepository roomsRepository;
    private final SensorsInRoomRepository sensorsInRoomRepository;
    private final UsersRepository usersRepository;


    @PostMapping(value = "/changeGadgetState")
    public ResponseEntity<Void> changeGadgetState(@RequestHeader(value = "session") String session,
                                                  @RequestHeader(value = "homeId") Integer homeId,
                                                  @RequestHeader(value = "gadgetId") Integer gadgetId,
                                                  @RequestHeader(value = "gadgetType") GadgetType gadgetType,
                                                  @RequestHeader(value = "action") Action action,
                                                  @RequestHeader(value = "value", required = false) String value) {
        log.info("changeGadgetState request with params session {}, homeId {}, gadgetId {}, gadgetType {}, action {}, value {}",
                session, homeId, gadgetId, gadgetType, action, value);
        var dto = new ChangeGadgetStateRequest(session, homeId, gadgetId, gadgetType, action, value);
        var parsedDto = ObjectParser.parse(dto);
        redisMessagePublisher.lpush("changeGadgetState", parsedDto);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping(value = "getGadgetState")
    public ResponseEntity<GadgetEntity> getGadgetStatus(@RequestHeader(value = "session") String session,
                                                        @RequestHeader(value = "gadgetId") Integer gadgetId) {
        log.info("getGadgetStatus request with params session {}, gadgetId {}", session, gadgetId);
        var gadgetOptional = gadgetRepository.findById(gadgetId);
        if (gadgetOptional.isEmpty())
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));

        return new ResponseEntity<>(gadgetOptional.get(), HttpStatusCode.valueOf(200));
    }


    @GetMapping(value = "getUserById")
    public ResponseEntity<UserDto> getUserById(@RequestHeader(value = "userId") Integer userId){
        log.info("getUserById for id {}", userId);
        var userDto = createUserDto(userId);
        if (userDto == null)
            return new ResponseEntity<>( HttpStatusCode.valueOf(404));

        return new ResponseEntity<>(userDto, HttpStatusCode.valueOf(200));
    }

    @GetMapping(value = "getHomeById")
    public ResponseEntity<HomeDto> getHomeById(@RequestHeader(value = "homeId") Integer homeId){
        log.info("getHomeById for id {}", homeId);
        var homeDto = getHomeDtoByHomeId(homeId);
        if (homeDto == null)
            return new ResponseEntity<>( HttpStatusCode.valueOf(404));

        return new ResponseEntity<>(homeDto, HttpStatusCode.valueOf(200));
    }

    private UserDto createUserDto(Integer userId){
        var usersEntityOptional = usersRepository.findById(userId);
        if (usersEntityOptional.isEmpty())
            return null;

        var userEntity = usersEntityOptional.get();
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .homes(getHomeListByUserId(userEntity.getId()))
                .build();
    }

    private List<HomeDto> getHomeListByUserId(Integer userId){
        var homeEntityList = homesRepository.findAllByOwnerId(userId);
        List<HomeDto> homeDtoList = new ArrayList<>();
        for (var homeEntity: homeEntityList){
            homeDtoList.add(getHomeDtoByHomeId(homeEntity.getId()));
        }

        return homeDtoList;
    }


    private HomeDto getHomeDtoByHomeId(Integer homeId){
        var homesEntityOptional = homesRepository.findById(homeId);
        if (homesEntityOptional.isEmpty())
            return null;

        var homeEntity = homesEntityOptional.get();

        return HomeDto.builder()
                .id(homeEntity.getId())
                .ownerId(homeEntity.getOwnerId())
                .rooms(getRoomsByHomeId(homeId))
                .build();
    }

    private List<RoomDto> getRoomsByHomeId(Integer homeId){
        var rooms = roomsRepository.findAllByHomeId(homeId);
        List<RoomDto> roomDtoList = new ArrayList<>();
        for (var room: rooms){
            var roomDto = RoomDto.builder()
                    .id(room.getId())
                    .gadgets(getGadgetByRoomId(room.getId()))
                    .build();
            roomDtoList.add(roomDto);
        }

        return roomDtoList;
    }

    private List<GadgetEntity> getGadgetByRoomId(Integer roomId){
        return gadgetRepository.findAllByRoomId(roomId);
    }

}