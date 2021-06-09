insert into role(role) values ('guest');
insert into role(role) values ('admin');
insert into role(role) values ('user');

insert into rules(rule) values ('Read');
insert into rules(rule) values ('Write');
insert into rules(rule) values ('Delete');

insert into role_rules (role_id, rules_id) values (1, 1);
insert into role_rules (role_id, rules_id) values (2, 1);
insert into role_rules (role_id, rules_id) values (2, 2);
insert into role_rules (role_id, rules_id) values (2, 3);
insert into role_rules (role_id, rules_id) values (3, 1);
insert into role_rules (role_id, rules_id) values (3, 2);

insert into users (username, role_id) values ('Вася', 1);
insert into users (username, role_id) values ('Ваня', 2);
insert into users (username, role_id) values ('Игорь', 3);

insert into state(state) values ('Новая');
insert into state(state) values ('В работе');
insert into state(state) values ('Выполнена');

insert into category(category) values ('Срочная');
insert into category(category) values ('Обычная');

insert into item (item, user_id, state_id, category_id) values ('Установка системы', 1, 2, 1);
insert into item (item, user_id, state_id, category_id) values ('Подключение принтера', 2, 1, 2);

insert into comments (comment, item_id) values ('Пожалуйста, сделайте поскорее', 1);

insert into attachs (attach, item_id) values ('screenshot.jpg', 2);