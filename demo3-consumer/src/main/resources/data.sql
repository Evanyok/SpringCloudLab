-- insert test product data
insert into tbProduct (id, name, cover_image, price) values (1, 'P001', '/products/cover/001.png', 100);
insert into tbProduct (id, name, cover_image, price) values (2, 'P002', '/products/cover/002.png', 200);
insert into tbProduct (id, name, cover_image, price) values (3, 'P003', '/products/cover/003.png', 300);
insert into tbProduct (id, name, cover_image, price) values (4, 'P004', '/products/cover/004.png', 400);
insert into tbProduct (id, name, cover_image, price) values (5, 'P005', '/products/cover/005.png', 500);

-- insert test product comment
insert into tbProductComment (id, product_id, author_id, content, created) values (1, 3, 1, 'very nice', CURRENT_TIMESTAMP());
insert into tbProductComment (id, product_id, author_id, content, created) values (2, 3, 3, 'very nice +1', CURRENT_TIMESTAMP());
insert into tbProductComment (id, product_id, author_id, content, created) values (3, 3, 4, 'very nice', CURRENT_TIMESTAMP());