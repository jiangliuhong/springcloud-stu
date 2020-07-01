create schema db_base;
create table db_base.t_route(
	c_id char(32) primary key not null,
	c_name varchar(300) not null,
	c_path varchar(300) not null,
	c_url varchar(900) not null
);