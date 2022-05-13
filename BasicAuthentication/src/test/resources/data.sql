
BEGIN;
insert into customer_date
VALUES (1, 'Valodik', 1);

insert into  car_table
values (1, 'BMW', 'e67',  '2020-04-10', 100000, 1);
values (2, 'Nissan', 'Fuga',  '2022-01-10', 1000, 1);

insert into customer_details
values (1, 'aaa', 'valod', false, false, false, false, 'ROLE_ADMIN, ROLE_USER');

insert into customer_date
VALUES (2, 'Gvenik', 2);

insert into car_table
values (3, 'Mercedes', 'E500',  '2010-05-10', 55500, 2);
values (4, 'Niva', '4x4',  '2002-06-11', 880000, 2);

insert into customer_details
values (2, 'aaa', 'valod', false, false, false, false, 'ROLE_ADMIN, ROLE_USER');
COMMIT