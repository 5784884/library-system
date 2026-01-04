create table sys_book
(
    id     int auto_increment comment '主键'
        primary key,
    name   varchar(255)   null comment '书名',
    author varchar(255)   null comment '作者',
    price  decimal(10, 2) null comment '价格',
    status int default 1  null comment '状态 1在库 0借出'
);

create table sys_borrow_record
(
    id          int auto_increment
        primary key,
    user_id     int                                null comment '借阅人ID',
    book_id     int                                null comment '图书ID',
    borrow_time datetime default CURRENT_TIMESTAMP null comment '借出时间',
    return_time datetime                           null comment '归还时间'
);

create table sys_user
(
    id       int auto_increment
        primary key,
    username varchar(50)                   null comment '用户名',
    password varchar(50)                   null comment '密码',
    role     varchar(20) default 'student' null comment '角色: admin/student'
);


