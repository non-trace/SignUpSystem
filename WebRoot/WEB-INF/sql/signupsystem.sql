/*
MySQL Data Transfer
Source Host: localhost
Source Database: signupsystem
Target Host: localhost
Target Database: signupsystem
Date: 2014/5/4 0:54:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT '' COMMENT '真实姓名',
  `user_code` varchar(30) DEFAULT '' COMMENT '登陆名',
  `user_password` varchar(50) DEFAULT '' COMMENT '密码',
  `sex` varchar(10) DEFAULT '' COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `Email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `idcard` varchar(20) DEFAULT '' COMMENT '身份证号',
  `mobile` varchar(15) DEFAULT '' COMMENT '手机号',
  `age` int(3) DEFAULT '0' COMMENT '年龄',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_user` VALUES ('25', '啊', 'aaa', '875F26FDB1CECF20CEB4CA028263DEC6', 'man', '2014-05-14', 'a@b.com', '132201198908144579', '18611111111', '12');
