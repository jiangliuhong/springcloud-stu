create schema db_base;
create table db_base.t_route(
	c_id varchar(300) primary key not null,
	c_name varchar(300) not null,
	c_predicates varchar(1200),
	c_url varchar(900) not null,
	c_filters varchar(1200)
);

INSERT INTO "db_base"."t_route"("c_id", "c_name", "c_predicates", "c_url", "c_filters") VALUES ('scs-test', '测试', '["Path=/test/**"]', 'http://ityouknow.com/', '["RewritePath=/test(?<segment>/?.*), $\\{segment}"]');
