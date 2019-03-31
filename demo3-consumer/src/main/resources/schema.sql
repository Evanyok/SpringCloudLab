-- spring boot will run schema.sql first
-- then run data.sql

drop table if exists tbProduct;
drop table if exists tbProductComment;

-- create tbProduct
create table tbProduct
(
    id              int unsigned not null auto_increment comment 'primary key',
    name            varchar(100) comment 'product name',
    cover_image     varchar(100) comment 'product cover image',
    price           int not null default 0 comment 'product price(cent)',
    primary key (id)
);

-- create tbProductComment
create table tbProductComment
(
    id              int unsigned not null auto_increment comment 'primary key',
    product_id      int unsigned comment 'product id',
    author_id       int unsigned comment 'author id',
    content         varchar(200) comment 'comment content',
    created         TIMESTAMP comment 'create time',
    primary key (id)
);