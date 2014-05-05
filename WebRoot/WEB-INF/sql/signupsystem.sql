/*
MySQL Data Transfer
Source Host: localhost
Source Database: signupsystem
Target Host: localhost
Target Database: signupsystem
Date: 2014/5/6 1:34:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_class
-- ----------------------------
CREATE TABLE `t_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(50) DEFAULT NULL,
  `teacher` varchar(50) DEFAULT NULL,
  `class_hour` int(50) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_class_rel
-- ----------------------------
CREATE TABLE `t_user_class_rel` (
  `user_class_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`user_class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_class` VALUES ('1', 'java开发', '高老师', '30');
INSERT INTO `t_class` VALUES ('2', 'C语言开发', '王老师', '30');
INSERT INTO `t_class` VALUES ('3', '高等数学', '李老师', '30');
INSERT INTO `t_class` VALUES ('4', '英语', '李老师', '30');
INSERT INTO `t_user` VALUES ('25', '啊', 'aaa', '875F26FDB1CECF20CEB4CA028263DEC6', 'man', '2014-05-14', 'a@b.com', '132201198908144579', '18611111111', '12');
INSERT INTO `t_user` VALUES ('27', '张三', 'zhangsan', '875F26FDB1CECF20CEB4CA028263DEC6', '男', '2014-05-13', 'a@b.com', '132201198908144579', '18900898827', '2');
INSERT INTO `t_user` VALUES ('28', '李四', 'lisi', '875F26FDB1CECF20CEB4CA028263DEC6', '男', '2014-05-15', 'a@b.com', '132201198908144579', '18900898827', '2');
INSERT INTO `t_user_class_rel` VALUES ('1', '25', '2');
INSERT INTO `t_user_class_rel` VALUES ('2', '25', '3');
INSERT INTO `t_user_class_rel` VALUES ('3', '25', '1');
INSERT INTO `t_user_class_rel` VALUES ('4', '25', '4');
