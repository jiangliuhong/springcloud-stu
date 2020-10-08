
create table db_base.t_route(
	c_id varchar(300) primary key not null comment 'id',
	c_name varchar(300) not null comment '名称',
	c_predicates varchar(1200) comment '断言',
	c_url varchar(900) not null comment 'url',
	c_filters varchar(1200) comment '过滤器',
	dt_create_time timestamp DEFAULT CURRENT_TIMESTAMP comment '创建时间',
	dt_update_time timestamp DEFAULT CURRENT_TIMESTAMP comment '修改时间'
) COMMENT '路由信息';

-- 初始化一条测试数据
INSERT INTO db_base.t_route(c_id, c_name, c_predicates, c_url, c_filters) VALUES ('scs-blog', '我的博客', '["Path=/blog/**"]', 'https://jiangliuhong.top/', '["RewritePath=/blog(?<segment>/?.*), $\\{segment}"]');

create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
) comment '认证信息';


