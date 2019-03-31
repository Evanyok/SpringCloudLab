-- spring boot will run schema.sql first
-- then run data.sql

drop table if exists tbUser;

-- create tbUser
create table tbUser
(
    id              int unsigned not null auto_increment comment 'primary key',
    nickname        varchar(50) comment 'user nickname',
    avatar          varchar(255) comment 'user avatar',
    primary key (id)
);
