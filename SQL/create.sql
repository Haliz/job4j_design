create table role (
	id serial primary key,
	role varchar(100)
);

create table rules (
	id serial primary key,
	rule varchar(100)
);

create table role_rules (
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table users (
	id serial primary key,
	username varchar(100),
	role_id int references role(id)
);

create table state(
	id serial primary key,
	state varchar(100)
);

create table category(
	id serial primary key,
	category varchar(100)
);

create table item (
	id serial primary key,
	item varchar(100),
	user_id int references users(id),
	state_id int references state(id),
	category_id int references category(id)
);

create table comments (
	id serial primary key,
	comment varchar(250),
	item_id int references item(id)
);

create table attachs(
	id serial primary key,
	attach varchar(100),
	item_id int references item(id)
);