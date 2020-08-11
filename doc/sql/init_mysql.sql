
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

-- 创建认证信息表
create table db_base.t_client_details(
	c_id char(32) primary key not null comment 'id',
	c_client_id varchar(300) comment '应用标识',
	c_resource_ids varchar(300) comment '资源限定串(逗号分割)',
	c_client_secret varchar(300) comment '应用密钥(bcyt) 加密',
	c_client_secret_str varchar(300) comment '应用密钥(明文)',
	c_scope varchar(300) comment '范围',
	c_grant_types varchar(300) comment '5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)',
	c_redirect_url varchar(900) comment '回调地址',
	c_authorities varchar(300) comment '权限',
	n_access_token_validity int comment 'access_token有效期',
	n_refresh_token_validity int comment 'refresh_token有效期',
	c_auto_approve varchar(300) comment '是否自动授权 1 是 2 否',
  j_ext text comment '扩展属性',
	dt_create_time timestamp DEFAULT CURRENT_TIMESTAMP comment '创建时间',
	dt_update_time timestamp DEFAULT CURRENT_TIMESTAMP comment '修改时间'
) comment '认证信息';

