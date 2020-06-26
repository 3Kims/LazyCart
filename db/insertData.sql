insert into customer values('id01', '1234', 'img/person.png', 'Lee', 'Seoul', '010-0000-0001');
insert into customer values('id02', '1234', 'img/person.png', 'Kim', 'Busan', '010-0000-0002');
insert into customer values('id03', '1234', 'img/person.png', 'Song', 'Jeju', '010-0000-0003');
insert into customer values('id04', '1234', 'img/person.png', 'Park', 'Kangwon', '010-0000-0004');
insert into customer values('id05', '1234', 'img/person.png', 'Kwon', 'River', '010-0000-0005');

insert into product(id, name, price, shop, url, category, img) values(1, null,null,null,null,null,null);
insert into product(name, price, shop, url, category, img) values("Desk", 23440, "Coupang", "url1", "furniture", "img01");
insert into product(name, price, shop, url, category, img) values("Chair", 15000, "Coupang", "url2", "furniture", "img02");
insert into product(name, price, shop, url, category, img) values("Pencil", 1000, "NaverShopping", "url3", "furniture", "img03");


insert into cart(customer_id, product_id, quantity, date) values('id01', 1, 123, '2020-10-23');
insert into cart(customer_id, product_id, quantity, date) values('id01', 2, 12, '2020-10-24');
insert into cart(customer_id, product_id, quantity, date) values('id02', 1, 1, '2020-10-10');
insert into cart(customer_id, product_id, quantity, date) values('id02', 3, 55, '2020-09-23');
