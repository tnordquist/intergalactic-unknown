---
title: DDL Diagram
subtitle: "DDL Diagram"
menu: DDL
order: 60
---


```sqlite
CREATE TABLE IF NOT EXISTS `Game`
(
    `game_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `pool`    TEXT,
    `user_id` INTEGER                           NOT NULL,
    `ship_id` INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`ship_id`) REFERENCES `Ship` (`ship_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE UNIQUE INDEX IF NOT EXISTS `index_Game_user_id` ON `Game` (`user_id`);
CREATE UNIQUE INDEX IF NOT EXISTS `index_Game_ship_id` ON `Game` (`ship_id`);

CREATE TABLE IF NOT EXISTS `PlanetData`
(
    `planet_data_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `visited`        INTEGER                           NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS `RandomEvent`
(
    `random_event_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`            TEXT                              NOT NULL,
    `ship`            INTEGER                           NOT NULL DEFAULT false,
    `planet_type`     INTEGER                           NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS `Ship`
(
    `ship_id`                 INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `ship_status`             INTEGER                           NOT NULL DEFAULT false,
    `ship_health`             INTEGER                           NOT NULL,
    `ship_fuel`               INTEGER                           NOT NULL,
    `ship_damage_buffer`      INTEGER                           NOT NULL DEFAULT false,
    `random_event_protection` INTEGER                           NOT NULL DEFAULT false,
    `planetDamage`            TEXT,
    `random_event_ship`       INTEGER                           NOT NULL,
    FOREIGN KEY (`random_event_ship`) REFERENCES `RandomEvent` (`random_event_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);
CREATE UNIQUE INDEX IF NOT EXISTS `index_Ship_random_event_ship` ON `Ship` (`random_event_ship`);

CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `oauth_key` TEXT                              NOT NULL,
    `user_name` TEXT                              NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS `index_User_oauth_key` ON `User` (`oauth_key`);

```

## [ddl.sql](sql/ddl.sql)
## [erd.md](erd.md)
## [wireframe.md](wireframe.md)