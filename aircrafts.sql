create table aircrafts(
	id serial primary key,
	aircraft_code character(3),
	model text,
	range integer
);
insert into aircrafts(aircraft_code,
	model,
	range)
	values ('SU9','Сухой Суперджет-100',3500);
select * from aircrafts;
update aircrafts set range = 3000;
delete from aircrafts;