
drop table if exists `t_login`;
CREATE TABLE `t_login` (
	`id` BIGINT NOT NULL comment '雪花ID' ,
	`username` CHAR(16) NOT NULL comment '用户名，唯一' ,
	`password` CHAR(32) NOT NULL comment '密码,md5',
	`avatar` VARCHAR(256) comment '头像',
	`status` CHAR(1) NOT NULL comment '状态：有效-E Effective',
	`telphone` CHAR(16) COMMENT '电话号码，唯一',
	`email` CHAR(32) COMMENT '邮箱，唯一',
	`wxopenid` CHAR(32) COMMENT '微信 openid，如：o6_bmjrPTlm6_2sgVt7hMZOPfL2M，唯一',
	`wxunionid` CHAR(32) COMMENT '微信 unionid，如：o6_bmasdasdsad6_2sgVt7hMZOPfL，唯一',
	`remark` VARCHAR(32) comment '备注',
	`createid` BIGINT COMMENT '插入用户信息主键ID',
	`createtime` BIGINT COMMENT '数据插入时间戳',
	`updateid` BIGINT COMMENT '更新用户信息主键ID',
	`updatetime` BIGINT COMMENT '数据更新时间戳',
	UNIQUE INDEX `index_unique_1_username` (`username`),
	UNIQUE INDEX `index_unique_2_telphone` (`telphone`),
	UNIQUE INDEX `index_unique_3_email` (`email`),
	UNIQUE INDEX `index_unique_4_wxopenid` (`wxopenid`),
	UNIQUE INDEX `index_unique_5_wxunionid` (`wxunionid`),
	PRIMARY KEY (`id`)
) comment='登陆';
insert into `t_login`(`id`,`username`,`password`,`status`,`remark`) values('0','admin','21232f297a57a5a743894a0e4a801fc3','E','密码：admin');

drop table if exists `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `id` BIGINT NOT NULL comment '雪花ID' ,
  `loginid` BIGINT NOT NULL comment '登陆ID' ,
	`fullname` VARCHAR(16)  COMMENT '全名',
	`namecn` VARCHAR(16) COMMENT '中文名',
	`nameen` VARCHAR(16) COMMENT '英文名',
	`telphone` VARCHAR(16) COMMENT '电话号码',
	`birthday` CHAR(10) COMMENT '生日',
	`gender` CHAR(1) COMMENT '性别 F 女 M 男',
	`remark` VARCHAR(32) COMMENT '备注',
	`createid` BIGINT COMMENT '插入用户信息主键ID',
	`createtime` BIGINT COMMENT '数据插入时间戳',
	`updateid` BIGINT COMMENT '更新用户信息主键ID',
	`updatetime` BIGINT COMMENT '数据更新时间戳',
	PRIMARY KEY (`id`)
)comment='用户信息表';

drop table if exists `t_login_log`;
CREATE TABLE `t_login_log` (
  `id` BIGINT NOT NULL comment '雪花ID' ,
  `loginid` BIGINT NOT NULL comment '登陆用户ID' ,
  `last_login_ip` VARCHAR(16) NOT NULL comment '登陆IP' ,
  `last_login_time` BIGINT NOT NULL comment '登陆时间' ,
  `createid` BIGINT COMMENT '插入用户信息主键ID',
	`createtime` BIGINT COMMENT '数据插入时间戳',
	PRIMARY KEY (`id`)
)comment='登陆日志';

