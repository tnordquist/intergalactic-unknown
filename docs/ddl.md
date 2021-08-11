---
title: Data Definition Language
subtitle: "DDL Diagram"
menu: DDL
order: 60
---


```sqlite
CREATE TABLE IF NOT EXISTS `Trip`
(
    `trip_id`               INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `started`               INTEGER                           NOT NULL,
    `preferred_destination` INTEGER                           NOT NULL,
    `augmented_resource`    INTEGER                           NOT NULL,
    `user_id`               INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);
CREATE INDEX IF NOT EXISTS `index_trip_started` ON `Trip` (`started`);
CREATE INDEX IF NOT EXISTS `index_trip_preferred_destination` ON `Trip` (`preferred_destination`);
CREATE INDEX IF NOT EXISTS `index_trip_augmented_resource` ON `Trip` (`augmented_resource`);
CREATE INDEX IF NOT EXISTS `index_trip_user_id` ON `Trip` (`user_id`);


CREATE TABLE IF NOT EXISTS `Landing`
(
    `landing_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `landing_order` INTEGER                           NOT NULL,
    `planet_type`   INTEGER                           NOT NULL,
    `planet_name`   TEXT                              NOT NULL,
    `trip_id`       INTEGER                           NOT NULL,
    FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);
CREATE UNIQUE INDEX IF NOT EXISTS `index_landing_trip_id_landing_order` ON `Landing` (`trip_id`, `landing_order`);
CREATE INDEX IF NOT EXISTS `index_landing_planet_type` ON `Landing` (`planet_type`);
CREATE INDEX IF NOT EXISTS `index_landing_trip_id` ON `Landing` (`trip_id`);


CREATE TABLE IF NOT EXISTS `Delta`
(
    `delta_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `trip_id`       INTEGER,
    `landing_id`    INTEGER,
    `resource_type` INTEGER                           NOT NULL,
    `amount`        INTEGER                           NOT NULL,
    `mining`        INTEGER                           NOT NULL,
    FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`landing_id`) REFERENCES `landing` (`landing_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);
CREATE INDEX IF NOT EXISTS `index_delta_trip_id` ON `Delta` (`trip_id`);
CREATE INDEX IF NOT EXISTS `index_delta_landing_id` ON `Delta` (`landing_id`);
CREATE INDEX IF NOT EXISTS `index_delta_resource_type` ON `Delta` (`resource_type`);


CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `oauth_key` TEXT                              NOT NULL,
    `user_name` TEXT                              NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS `index_User_oauth_key` ON `User` (`oauth_key`);
CREATE TABLE IF NOT EXISTS room_master_table
(
    id            INTEGER PRIMARY KEY,
    identity_hash TEXT
);

```

## [DDL.SQL](sql/ddl.sql)

