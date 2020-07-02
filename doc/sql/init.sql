create schema db_base;
create table db_base.t_route(
	c_id varchar(300) primary key not null,
	c_name varchar(300) not null,
	c_predicates varchar(900) not null,
	c_url varchar(900) not null,
	c_filters varchar(900)
);