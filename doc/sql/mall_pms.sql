-- 数据库：mall_pms

-- 相册表：创建数据表
drop table if exists pms_album;
create table pms_album
(
    id           bigint unsigned auto_increment comment '记录id',
    name         varchar(50)      default null comment '相册名称',
    description  varchar(255)     default null comment '相册简介',
    sort         tinyint unsigned default 0 comment '自定义排序序号',
    gmt_create   datetime         default null comment '数据创建时间',
    gmt_modified datetime         default null comment '数据最后修改时间',
    primary key (id)
) comment '相册' charset utf8mb4;

-- 相册表：为相册名称字段添加索引
create index idx_album_name on pms_album (name);

-- 图片表：创建数据表
drop table if exists pms_picture;
create table pms_picture
(
    id           bigint unsigned auto_increment comment '记录id',
    album_id     bigint unsigned   default null comment '相册id',
    url          varchar(255)      default null comment '图片url',
    description  varchar(255)      default null comment '图片简介',
    width        smallint unsigned default null comment '图片宽度，单位：px',
    height       smallint unsigned default null comment '图片高度，单位：px',
    is_cover     tinyint unsigned  default 0 comment '是否为封面图片，1=是，0=否',
    sort         tinyint unsigned  default 0 comment '自定义排序序号',
    gmt_create   datetime          default null comment '数据创建时间',
    gmt_modified datetime          default null comment '数据最后修改时间',
    primary key (id)
) comment '图片' charset utf8mb4;

-- 品牌表：创建数据表
drop table if exists pms_brand;
create table pms_brand
(
    id                     bigint unsigned auto_increment comment '记录id',
    name                   varchar(50)      default null comment '品牌名称',
    pinyin                 varchar(50)      default null comment '品牌名称的拼音',
    logo                   varchar(255)     default null comment '品牌logo的URL',
    description            varchar(255)     default null comment '品牌简介',
    keywords               varchar(255)     default null comment '关键词列表，各关键词使用英文的逗号分隔',
    sort                   tinyint unsigned default 0 comment '自定义排序序号',
    sales                  int unsigned     default 0 comment '销量（冗余）',
    product_count          int unsigned     default 0 comment '商品种类数量总和（冗余）',
    comment_count          int unsigned     default 0 comment '买家评论数量总和（冗余）',
    positive_comment_count int unsigned     default 0 comment '买家好评数量总和（冗余）',
    enable                 tinyint unsigned default 0 comment '是否启用，1=启用，0=未启用',
    gmt_create             datetime         default null comment '数据创建时间',
    gmt_modified           datetime         default null comment '数据最后修改时间',
    primary key (id)
) comment '品牌' charset utf8mb4;

-- 品牌表：为品牌名称字段添加索引
create index idx_brand_name on pms_brand (name);

-- 类别表：创建数据表
drop table if exists pms_category;
create table pms_category
(
    id           bigint unsigned auto_increment comment '记录id',
    name         varchar(50)      default null comment '类别名称',
    parent_id    bigint unsigned  default 0 comment '父级类别id，如果无父级，则为0',
    depth        tinyint unsigned default 1 comment '深度，最顶级类别的深度为1，次级为2，以此类推',
    keywords     varchar(255)     default null comment '关键词列表，各关键词使用英文的逗号分隔',
    sort         tinyint unsigned default 0 comment '自定义排序序号',
    icon         varchar(255)     default null comment '图标图片的URL',
    enable       tinyint unsigned default 0 comment '是否启用，1=启用，0=未启用',
    is_parent    tinyint unsigned default 0 comment '是否为父级（是否包含子级），1=是父级，0=不是父级',
    is_display   tinyint unsigned default 0 comment '是否显示在导航栏中，1=启用，0=未启用',
    gmt_create   datetime         default null comment '数据创建时间',
    gmt_modified datetime         default null comment '数据最后修改时间',
    primary key (id)
) comment '类别' charset utf8mb4;

-- 类别表：为类别名称字段添加索引
create index idx_category_name on pms_category (name);

-- 品牌类别关联表：创建数据表
drop table if exists pms_brand_category;
create table pms_brand_category
(
    id           bigint unsigned auto_increment comment '记录id',
    brand_id     bigint unsigned default null comment '品牌id',
    category_id  bigint unsigned default null comment '类别id',
    gmt_create   datetime        default null comment '数据创建时间',
    gmt_modified datetime        default null comment '数据最后修改时间',
    primary key (id)
) comment '品牌与类别关联' charset utf8mb4;

-- 属性表：创建数据表
drop table if exists pms_attribute;
create table pms_attribute
(
    id                 bigint unsigned auto_increment comment '记录id',
    template_id        bigint unsigned  default null comment '所属属性模版id',
    name               varchar(50)      default null comment '属性名称',
    description        varchar(255)     default null comment '简介（某些属性名称可能相同，通过简介补充描述）',
    type               tinyint unsigned default 0 comment '属性类型，1=销售属性，0=非销售属性',
    input_type         tinyint unsigned default 0 comment '输入类型，0=手动录入，1=单选，2=多选，3=单选（下拉列表），4=多选（下拉列表）',
    value_list         varchar(255)     default null comment '备选值列表',
    unit               varchar(50)      default null comment '计量单位',
    sort               tinyint unsigned default 0 comment '自定义排序序号',
    is_allow_customize tinyint unsigned default 0 comment '是否允许自定义，1=允许，0=禁止',
    gmt_create         datetime         default null comment '数据创建时间',
    gmt_modified       datetime         default null comment '数据最后修改时间',
    primary key (id)
) comment '属性' charset utf8mb4;

-- 属性模版表：创建数据表
drop table if exists pms_attribute_template;
create table pms_attribute_template
(
    id           bigint unsigned auto_increment comment '记录id',
    name         varchar(50)      default null comment '属性模版名称',
    pinyin       varchar(50)      default null comment '属性模版名称的拼音',
    keywords     varchar(255)     default null comment '关键词列表，各关键词使用英文的逗号分隔',
    sort         tinyint unsigned default 0 comment '自定义排序序号',
    gmt_create   datetime         default null comment '数据创建时间',
    gmt_modified datetime         default null comment '数据最后修改时间',
    primary key (id)
) comment '属性模版' charset utf8mb4;

-- 属性模版表：为属性模版名称字段添加索引
create index idx_attribute_template_name on pms_attribute_template (name);

-- 类别与属性模版关联表：创建数据表
drop table if exists pms_category_attribute_template;
create table pms_category_attribute_template
(
    id                    bigint unsigned auto_increment comment '记录id',
    category_id           bigint unsigned default null comment '类别id',
    attribute_template_id bigint unsigned default null comment '属性模版id',
    gmt_create            datetime        default null comment '数据创建时间',
    gmt_modified          datetime        default null comment '数据最后修改时间',
    primary key (id)
) comment '类别与属性模版关联' charset utf8mb4;

-- SPU（Standard Product Unit）表：创建数据表
drop table if exists pms_spu;
create table pms_spu
(
    id                     bigint unsigned not null comment '记录id',
    name                   varchar(50)      default null comment 'SPU名称',
    type_number            varchar(50)      default null comment 'SPU编号',
    title                  varchar(255)     default null comment '标题',
    description            varchar(255)     default null comment '简介',
    list_price             decimal(10, 2)   default null comment '价格（显示在列表中）',
    stock                  int unsigned     default 0 comment '当前库存（冗余）',
    stock_threshold        int unsigned     default 0 comment '库存预警阈值（冗余）',
    unit                   varchar(50)      default null comment '计件单位',
    brand_id               bigint unsigned  default null comment '品牌id',
    brand_name             varchar(50)      default null comment '品牌名称（冗余）',
    category_id            bigint unsigned  default null comment '类别id',
    category_name          varchar(50)      default null comment '类别名称（冗余）',
    attribute_template_id  bigint unsigned  default null comment '属性模版id',
    album_id               bigint unsigned  default null comment '相册id',
    pictures               varchar(500)     default null comment '组图URLs，使用JSON数组表示',
    keywords               varchar(255)     default null comment '关键词列表，各关键词使用英文的逗号分隔',
    tags                   varchar(255)     default null comment '标签列表，各标签使用英文的逗号分隔，原则上最多3个',
    sales                  int unsigned     default 0 comment '销量（冗余）',
    comment_count          int unsigned     default 0 comment '买家评论数量总和（冗余）',
    positive_comment_count int unsigned     default 0 comment '买家好评数量总和（冗余）',
    sort                   tinyint unsigned default 0 comment '自定义排序序号',
    is_deleted             tinyint unsigned default 0 comment '是否标记为删除，1=已删除，0=未删除',
    is_published           tinyint unsigned default 0 comment '是否上架（发布），1=已上架，0=未上架（下架）',
    is_new_arrival         tinyint unsigned default 0 comment '是否新品，1=新品，0=非新品',
    is_recommend           tinyint unsigned default 0 comment '是否推荐，1=推荐，0=不推荐',
    is_checked             tinyint unsigned default 0 comment '是否已审核，1=已审核，0=未审核',
    check_user             varchar(50)      default null comment '审核人（冗余）',
    gmt_check              datetime         default null comment '审核通过时间（冗余）',
    gmt_create             datetime         default null comment '数据创建时间',
    gmt_modified           datetime         default null comment '数据最后修改时间',
    primary key (id)
) comment 'SPU（Standard Product Unit）' charset utf8mb4;

-- SPU详情表：创建数据表
drop table if exists pms_spu_detail;
create table pms_spu_detail
(
    id           bigint unsigned auto_increment comment '记录id',
    spu_id       bigint unsigned default null comment 'SPU id',
    detail       text            default null comment 'SPU详情，应该使用HTML富文本，通常内容是若干张图片',
    gmt_create   datetime        default null comment '数据创建时间',
    gmt_modified datetime        default null comment '数据最后修改时间',
    primary key (id)
) comment 'SPU详情' charset utf8mb4;

-- SKU（Stock Keeping Unit）表：创建数据表
drop table if exists pms_sku;
create table pms_sku
(
    id                     bigint unsigned not null comment '记录id',
    spu_id                 bigint unsigned  default null comment 'SPU id',
    title                  varchar(255)     default null comment '标题',
    bar_code               varchar(255)     default null comment '条型码',
    attribute_template_id  bigint unsigned  default null comment '属性模版id',
    specifications         varchar(2500)    default null comment '全部属性，使用JSON格式表示（冗余）',
    album_id               bigint unsigned  default null comment '相册id',
    pictures               varchar(500)     default null comment '组图URLs，使用JSON格式表示',
    price                  decimal(10, 2)   default null comment '单价',
    stock                  int unsigned     default 0 comment '当前库存',
    stock_threshold        int unsigned     default 0 comment '库存预警阈值',
    sales                  int unsigned     default 0 comment '销量（冗余）',
    comment_count          int unsigned     default 0 comment '买家评论数量总和（冗余）',
    positive_comment_count int unsigned     default 0 comment '买家好评数量总和（冗余）',
    sort                   tinyint unsigned default 0 comment '自定义排序序号',
    gmt_create             datetime         default null comment '数据创建时间',
    gmt_modified           datetime         default null comment '数据最后修改时间',
    primary key (id)
) comment 'SKU（Stock Keeping Unit）' charset utf8mb4;

-- SKU规格参数表（存储各SKU的属性与值，即规格参数）：创建数据表
drop table if exists pms_sku_specification;
create table pms_sku_specification
(
    id              bigint unsigned auto_increment comment '记录id',
    sku_id          bigint unsigned  default null comment 'SKU id',
    attribute_id    bigint unsigned  default null comment '属性id',
    attribute_name  varchar(50)      default null comment '属性名称',
    attribute_value varchar(50)      default null comment '属性值',
    unit            varchar(10)      default null comment '自动补充的计量单位',
    sort            tinyint unsigned default 0 comment '自定义排序序号',
    gmt_create      datetime         default null comment '数据创建时间',
    gmt_modified    datetime         default null comment '数据最后修改时间',
    primary key (id)
) comment 'SKU数据' charset utf8mb4;

-- -------------------------- --
-- 以下是插入测试数据及一些测试访问 --
-- -------------------------- --

-- 品牌表：插入测试数据
insert into pms_brand (name, pinyin, description, keywords, enable)
values ('华为', 'huawei', '华为专注网络设备三十年', '华为,huawei,mate,magicbook', 1),
       ('小米', 'xiaomi', '小米，为发烧而生', '小米,xiaomi,发烧', 1),
       ('苹果', 'pingguo', '苹果，全球知名品牌', '苹果,apple,pingguo,iphone,mac', 1);

-- 类别表：插入测试数据
insert into pms_category (name, parent_id, depth, is_parent, keywords, enable, is_display)
values ('手机 / 运营商 / 数码', 0, 1, 1, null, 1, 1),
       ('手机通讯', 1, 2, 1, '手机,电话', 1, 1),
       ('智能手机', 2, 3, 0, null, 1, 1),
       ('非智能手机', 2, 3, 0, null, 1, 1),
       ('电脑 / 办公', 0, 1, 1, null, 1, 1),
       ('电脑整机', 5, 2, 1, '电脑,计算机,微机,服务器,工作站', 1, 1),
       ('电脑配件', 5, 2, 1, '配件,组装,CPU,内存,硬盘', 1, 1),
       ('笔记本', 6, 3, 0, '电脑,笔记本,微机,便携', 1, 1),
       ('台式机 / 一体机', 6, 3, 0, '台式机,一体机', 1, 1);

-- 品牌类别表：插入测试数据
insert into pms_brand_category (brand_id, category_id)
values (1, 3),
       (2, 3),
       (3, 3),
       (1, 8),
       (2, 8),
       (3, 8),
       (1, 9),
       (3, 9);

-- 关联测试查询：各品牌有哪些类别的产品
select pms_brand_category.id, pms_brand.name, pms_category.name
from pms_brand_category
         left join pms_brand
                   on pms_brand_category.brand_id = pms_brand.id
         left join pms_category
                   on pms_brand_category.category_id = pms_category.id
order by pms_brand.pinyin;

-- 属性表：插入测试数据
insert into pms_attribute (name, description, type, input_type, value_list, unit, is_allow_customize)
values ('屏幕尺寸', '智能手机屏幕尺寸', 0, 1, '6.1,6.3', '英寸', 1),
       ('屏幕尺寸', '笔记本电脑屏幕尺寸', 0, 1, '14,15', '英寸', 1),
       ('颜色', '智能手机颜色', 0, 1, '黑色,金色,白色', null, 1),
       ('颜色', '衬衣颜色', 0, 1, '白色,蓝色,灰色,黑色', null, 1),
       ('运行内存', '智能手机运行内存', 0, 1, '4,8,16', 'GB', 1),
       ('CPU型号', '智能手机CPU型号', 0, 1, '骁龙870,骁龙880', null, 1),
       ('机身毛重', '智能手机机身毛重', 0, 0, null, 'g', 0),
       ('机身存储', '智能手机机身存储', 0, 1, '64,128,256,512', 'GB', 0),
       ('操作系统', '智能手机操作系统', 0, 1, 'Android,iOS', null, 0),
       ('操作系统', '电脑操作系统', 0, 1, '无,Windows 7,Windows 10,Ubuntu,Mac OS', null, 0);

-- 属性模版表：插入测试数据
insert into pms_attribute_template (name, pinyin, keywords)
values ('智能手机', 'zhinengshouji', '手机'),
       ('服装-上身', 'fuzhuang', '服装,上衣'),
       ('服装-裤子', 'fuzhuang', '服装,裤'),
       ('笔记本电脑', 'bijibendiannao', '电脑,笔记本'),
       ('台式电脑', 'taishidiannao', '电脑,台式电脑,台式机');

-- 相册表：插入测试数据
insert into pms_album (name, description)
values ('iPhone 13', null),
       ('Mi 11 Ultra', null);

-- 图片表：插入测试数据
insert into pms_picture (album_id, url, description, width, height)
values (1, '模拟数据：iPhone 13图片URL-1', null, 1024, 768),
       (1, '模拟数据：iPhone 13图片URL-2', null, 1024, 768),
       (1, '模拟数据：iPhone 13图片URL-3', null, 1024, 768),
       (1, '模拟数据：iPhone 13图片URL-4', null, 1024, 768),
       (1, '模拟数据：iPhone 13图片URL-5', null, 1024, 768),
       (2, '模拟数据：Mi 11 Ultra图片URL-1', null, 1024, 768),
       (2, '模拟数据：Mi 11 Ultra图片URL-2', null, 1024, 768),
       (2, '模拟数据：Mi 11 Ultra图片URL-3', null, 1024, 768),
       (2, '模拟数据：Mi 11 Ultra图片URL-4', null, 1024, 768),
       (2, '模拟数据：Mi 11 Ultra图片URL-5', null, 1024, 768);

-- SPU表：插入测试数据
insert into pms_spu (id, name, type_number, title, description, list_price, stock, stock_threshold, unit, brand_id,
                     brand_name, category_id, category_name, keywords, tags)
values (202112010000001, 'iPhone 13', 'A2404', '苹果手机iPhone 13（A2404）', '2021年新款，全网首发',
        5199.99, 5000, 20, '部', 3, '苹果', 3, '智能手机', 'ip13,iPhone13,苹果13', '20w快充,NFC,无线充电'),
       (202112010000002, '小米11 Ultra', 'M112021', '小米11 Ultra（M112021）', '2021年最新旗舰机',
        5899.99, 8000, 20, '部', 2, '小米', 3, '智能手机', 'mi11,xiaomi11,ultra', '67w快充,1亿像素,5000毫安电池');

-- SPU详情表：插入测试数据
insert into pms_spu_detail (spu_id, detail)
values (1, '<div>iPhone 13的详情HTML</div>'),
       (2, '<div>小米11 Ultra的详情HTML</div>');

-- SKU（Stock Keeping Unit）表：插入测试数据
insert into pms_sku (id, spu_id, title, attribute_template_id, specifications, price, stock, stock_threshold)
values (202112010000001, 2, '2021年新款，小米11 Ultra黑色512G，16G超大内存120Hz高刷67w快充', 1,
        '{"attributes":[{"id":1,"name":"屏幕尺寸","value":"6.1寸"},{"id":3,"name":"颜色","value":"黑色"},{"id":5,"name":"运行内存","value":"16GB"}]}',
        6999.99, 3000, 50),
       (202112010000002, 2, '2021年新款，小米11 Ultra白色512G，8G超大内存120Hz高刷67w快充', 1,
        '{"attributes":[{"id":1,"name":"屏幕尺寸","value":"6.1寸"},{"id":3,"name":"颜色","value":"白色"},{"id":5,"name":"运行内存","value":"8GB"}]}',
        6499.99, 3000, 50);

-- SKU规格参数表（存储各SKU的属性与值，即规格参数）：插入测试数据
insert into pms_sku_specification (sku_id, attribute_id, attribute_name, attribute_value, unit)
values (1, 1, '屏幕尺寸', '6.1', '寸'),
       (1, 3, '颜色', '黑色', null),
       (1, 5, '运行内存', '16', 'GB'),
       (2, 1, '屏幕尺寸', '6.1', '寸'),
       (2, 3, '颜色', '白色', null),
       (2, 5, '运行内存', '8', 'GB');

-- 查看数据表结构
desc pms_album;
desc pms_picture;
desc pms_category;
desc pms_brand;
desc pms_brand_category;
desc pms_attribute;
desc pms_attribute_template;
desc pms_spu;
desc pms_spu_detail;
desc pms_sku;
desc pms_sku_specification;