package ru.itmo.mobile_development_api.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisMessagePublisher {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisMessagePublisher(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publishMessage(String channel, Object message) {
        redisTemplate.convertAndSend(channel, message);
    }

    public void lpush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }
}
