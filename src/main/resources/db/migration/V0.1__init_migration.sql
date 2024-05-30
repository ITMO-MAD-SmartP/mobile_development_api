CREATE TABLE IF NOT EXISTS users
(
    id INT,
    name varchar,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS homes
(
    id INT,
    owner_id varchar,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS rooms
(
    id INT,
    home_id varchar,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sensors
(
    id INT,
    name varchar,
    state boolean,
    value numeric,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sensors_in_room
(
    sensor_id INT,
    room_id INT,
    PRIMARY KEY (sensor_id, room_id)
);

CREATE TABLE IF NOT EXISTS owned_homes
(
    user_id INT,
    home_id INT,
    PRIMARY KEY (user_id, home_id)
);

