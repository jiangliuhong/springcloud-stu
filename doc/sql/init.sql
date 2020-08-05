
create schema db_base;
-- 创建路由表
create table db_base.t_route(
	c_id varchar(300) primary key not null,
	c_name varchar(300) not null,
	c_predicates varchar(1200),
	c_url varchar(900) not null,
	c_filters varchar(1200),
	dt_create_time timestamp,
	dt_update_time timestamp
);
COMMENT ON COLUMN db_base.t_route.c_name IS '名称';
COMMENT ON COLUMN db_base.t_route.c_predicates IS '断言';
COMMENT ON COLUMN db_base.t_route.c_url IS 'url';
COMMENT ON COLUMN db_base.t_route.c_filters IS '过滤器';

-- 初始化一条测试数据
INSERT INTO "db_base"."t_route"("c_id", "c_name", "c_predicates", "c_url", "c_filters") VALUES ('scs-blog', '我的博客', '["Path=/blog/**"]', 'https://jiangliuhong.top/', '["RewritePath=/blog(?<segment>/?.*), $\\{segment}"]');

-- 创建认证信息表
create table db_base.t_client_details(
	c_id varchar(300) primary key not null,
	c_client_id varchar(300),
	c_resource_ids varchar(300),
	c_client_secret varchar(300),
	c_client_secret_str varchar(300),
	c_scope varchar(300),
	c_grant_types varchar(300),
	c_redirect_url varchar(900),
	c_authorities varchar(300),
	n_access_token_validity int,
	n_refresh_token_validity int,
	c_auto_approve varchar(300),
    j_ext text,
	dt_create_time timestamp,
	dt_update_time timestamp
);

COMMENT ON COLUMN db_base.t_client_details.c_client_id IS '应用标识';
COMMENT ON COLUMN db_base.t_client_details.c_resource_ids IS '资源限定串(逗号分割)';
COMMENT ON COLUMN db_base.t_client_details.c_client_secret IS '应用密钥(bcyt) 加密';
COMMENT ON COLUMN db_base.t_client_details.c_client_secret_str IS '应用密钥(明文)';
COMMENT ON COLUMN db_base.t_client_details.c_scope IS '范围';
COMMENT ON COLUMN db_base.t_client_details.c_grant_types IS '5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)';
COMMENT ON COLUMN db_base.t_client_details.c_redirect_url IS '回调地址';
COMMENT ON COLUMN db_base.t_client_details.c_authorities IS '权限';
COMMENT ON COLUMN db_base.t_client_details.n_access_token_validity IS 'access_token有效期';
COMMENT ON COLUMN db_base.t_client_details.n_refresh_token_validity IS 'refresh_token有效期';
COMMENT ON COLUMN db_base.t_client_details.c_auto_approve IS '是否自动授权 1 是 2 否';
COMMENT ON COLUMN db_base.t_client_details.j_ext IS '扩展属性';

