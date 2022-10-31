-- 数据库：mall_ams

-- 权限表：创建数据表
drop table if exists ams_permission;
create table ams_permission (
                                id bigint unsigned auto_increment,
                                name varchar(50) default null comment '名称',
                                value varchar(255) default null comment '值',
                                description varchar(255) default null comment '描述',
                                sort tinyint unsigned default 0 comment '自定义排序序号',
                                gmt_create datetime default null comment '数据创建时间',
                                gmt_modified datetime default null comment '数据最后修改时间',
                                primary key (id)
) comment '权限表' charset utf8mb4;

-- 权限表：插入测试数据
insert into ams_permission (name, value, description) values
('商品-商品管理-读取', '/pms/product/read', '读取商品数据，含列表、详情、查询等'),
('商品-商品管理-编辑', '/pms/product/update', '修改商品数据'),
('商品-商品管理-删除', '/pms/product/delete', '删除商品数据'),
('后台管理-管理员-读取', '/ams/admin/read', '读取管理员数据，含列表、详情、查询等'),
('后台管理-管理员-编辑', '/ams/admin/update', '编辑管理员数据'),
('后台管理-管理员-删除', '/ams/admin/delete', '删除管理员数据');

-- 角色表：创建数据表
drop table if exists ams_role;
create table ams_role (
                          id bigint unsigned auto_increment,
                          name varchar(50) default null comment '名称',
                          description varchar(255) default null comment '描述',
                          sort tinyint unsigned default 0 comment '自定义排序序号',
                          gmt_create datetime default null comment '数据创建时间',
                          gmt_modified datetime default null comment '数据最后修改时间',
                          primary key (id)
) comment '角色表' charset utf8mb4;

-- 角色表：插入测试数据
insert into ams_role (name) values
('超级管理员'), ('系统管理员'), ('商品管理员'), ('订单管理员');

-- 角色权限关联表：创建数据表
drop table if exists ams_role_permission;
create table ams_role_permission (
                                     id bigint unsigned auto_increment,
                                     role_id bigint unsigned default null comment '角色id',
                                     permission_id bigint unsigned default null comment '权限id',
                                     gmt_create datetime default null comment '数据创建时间',
                                     gmt_modified datetime default null comment '数据最后修改时间',
                                     primary key (id)
) comment '角色权限关联表' charset utf8mb4;

-- 角色权限关联表：插入测试数据
insert into ams_role_permission (role_id, permission_id) values
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6),
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6),
(3, 1), (3, 2), (3, 3);

-- 管理员表：创建数据表
drop table if exists ams_admin;
create table ams_admin (
                           id bigint unsigned auto_increment,
                           username varchar(50) default null comment '用户名',
                           password char(64) default null comment '密码（密文）',
                           nickname varchar(50) default null comment '昵称',
                           avatar varchar(255) default null comment '头像URL',
                           phone varchar(50) default null comment '手机号码',
                           email varchar(50) default null comment '电子邮箱',
                           description varchar(255) default null comment '描述',
                           enable tinyint unsigned default 0 comment '是否启用，1=启用，0=未启用',
                           last_login_ip varchar(50) default null comment '最后登录IP地址（冗余）',
                           login_count int unsigned default 0 comment '累计登录次数（冗余）',
                           gmt_last_login datetime default null comment '最后登录时间（冗余）',
                           gmt_create datetime default null comment '数据创建时间',
                           gmt_modified datetime default null comment '数据最后修改时间',
                           primary key (id)
) comment '管理员表' charset utf8mb4;

-- 管理员表：插入测试数据
insert into ams_admin (username, password, nickname, email, description, enable) values
('root', '1234', 'root', 'root@tedu.cn', '最高管理员', 1),
('super_admin', '1234', 'administrator', 'admin@tedu.cn', '超级管理员', 1),
('nobody', '1234', '无名', 'liucs@tedu.cn', null, 0);

-- 管理员角色关联表：创建数据表
drop table if exists ams_admin_role;
create table ams_admin_role (
                                id bigint unsigned auto_increment,
                                admin_id bigint unsigned default null comment '管理员id',
                                role_id bigint unsigned default null comment '角色id',
                                gmt_create datetime default null comment '数据创建时间',
                                gmt_modified datetime default null comment '数据最后修改时间',
                                primary key (id)
) comment '管理员角色关联表' charset utf8mb4;

-- 管理员角色关联表：插入测试数据
insert into ams_admin_role (admin_id, role_id) values
(1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (2, 4), (3, 3);

-- 查询示例：查询id=1的管理员的权限
select distinct ams_permission.value from ams_permission
                                              left join ams_role_permission on ams_role_permission.permission_id=ams_permission.id
                                              left join ams_role on ams_role_permission.role_id=ams_role.id
                                              left join ams_admin_role on ams_admin_role.role_id=ams_role.id
                                              left join ams_admin on ams_admin_role.admin_id=ams_admin.id
where ams_admin.id=1
order by ams_permission.value;

-- 管理员登录日志表：创建数据表
drop table if exists ams_login_log;
create table ams_login_log (
                               id bigint unsigned auto_increment,
                               admin_id bigint unsigned default null comment '管理员id',
                               username varchar(50) default null comment '管理员用户名（冗余）',
                               nickname varchar(50) default null comment '管理员昵称（冗余）',
                               ip varchar(50) default null comment '登录IP地址',
                               user_agent varchar(255) default null comment '浏览器内核',
                               gmt_login datetime default null comment '登录时间',
                               gmt_create datetime default null comment '数据创建时间',
                               gmt_modified datetime default null comment '数据最后修改时间',
                               primary key (id)
) comment '管理员登录日志表' charset utf8mb4;

-- 管理员登录日志表：插入测试数据
insert into ams_login_log (admin_id, username, nickname, ip, user_agent, gmt_login) values
(1, 'root', 'root', '127.0.0.1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.0 Safari/605.1.15', DATE_SUB(NOW(), interval 1 day)),
(2, 'root', 'root', '127.0.0.1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.0 Safari/605.1.15', DATE_SUB(NOW(), interval 12 hour)),
(3, 'root', 'root', '127.0.0.1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.0 Safari/605.1.15', NOW());

-- 查看数据表结构
desc ams_permission; desc ams_role; desc ams_role_permission; desc ams_admin; desc ams_admin_role; desc ams_login_log;