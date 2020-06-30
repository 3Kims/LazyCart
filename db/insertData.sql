insert into customer values('id01', '1234', 'img/default.png', 'Lee', 'Seoul', '010-0000-0001');
insert into customer values('id02', '1234', 'img/default.png', 'Kim', 'Busan', '010-0000-0002');
insert into customer values('id03', '1234', 'img/default.png', 'Song', 'Jeju', '010-0000-0003');
insert into customer values('id04', '1234', 'img/default.png', 'Park', 'Kangwon', '010-0000-0004');
insert into customer values('id05', '1234', 'img/default.png', 'Kwon', 'River', '010-0000-0005');

insert into product(id, name, price, shop, url, category, img) values(1, null,null,null,null,null,null);
insert into product(name, price, shop, url, category, img) values("Desk", 23440, "Coupang", "url1", "furniture", "img01");
insert into product(name, price, shop, url, category, img) values("Chair", 15000, "Coupang", "url2", "furniture", "img02");
insert into product(name, price, shop, url, category, img) values("Pencil", 1000, "NaverShopping", "url3", "furniture", "img03");

insert into cart(customer_id, product_id, quantity, date) values('id01', 1, null, null);
insert into cart(customer_id, product_id, quantity, date) values('id01', 2, 12, '2020-10-24');
insert into cart(customer_id, product_id, quantity, date) values('id01', 3, 24, '2020-01-12');
insert into cart(customer_id, product_id, quantity, date) values('id02', 1, null, null);
insert into cart(customer_id, product_id, quantity, date) values('id02', 3, 55, '2020-09-23');
insert into cart(customer_id, product_id, quantity, date) values('id02', 4, 10, '2020-07-12');
insert into cart(customer_id, product_id, quantity, date) values('id03', 1, null, null);
insert into cart(customer_id, product_id, quantity, date) values('id04', 1, null, null);
insert into cart(customer_id, product_id, quantity, date) values('id05', 1, null, null);
