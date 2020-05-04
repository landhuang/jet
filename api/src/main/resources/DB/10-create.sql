
drop table if exists `t_login`;
CREATE TABLE `t_login` (
	`id` BIGINT NOT NULL comment '雪花ID' ,
	`username` CHAR(32) NOT NULL comment '账号，唯一' ,
	`password` CHAR(32) NOT NULL comment '密码,md5',
	`status` CHAR(1) NOT NULL comment '状态：有效-E Effective',
	`remark` CHAR(32) comment '备注',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `index_unique_1_account` (`username`)
) comment='登陆';

insert into `t_login`(`id`,`username`,`password`,`status`,`remark`) values('0','admin','21232f297a57a5a743894a0e4a801fc3','E','密码：admin');
