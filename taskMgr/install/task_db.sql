/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : task_db

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-05-11 09:22:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `board`
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `board_id` int(255) NOT NULL AUTO_INCREMENT,
  `board_name` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `board_color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('1', '练习板', '1', '#223344');
INSERT INTO `board` VALUES ('2', '工作板', '1', '#332244');

-- ----------------------------
-- Table structure for `job_info`
-- ----------------------------
DROP TABLE IF EXISTS `job_info`;
CREATE TABLE `job_info` (
  `job_id` int(255) NOT NULL AUTO_INCREMENT,
  `job_title` varchar(255) DEFAULT NULL,
  `job_desc` varchar(255) DEFAULT NULL,
  `job_color` varchar(255) DEFAULT NULL,
  `job_end_date` date DEFAULT NULL,
  `job_sort` int(11) DEFAULT NULL,
  `list_id` int(255) DEFAULT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_info
-- ----------------------------
INSERT INTO `job_info` VALUES ('1', '设计', 'UI设计', '0,2,3', '2017-03-11', '0', '1');
INSERT INTO `job_info` VALUES ('2', '开发', 'coding', '1,2', '2017-03-13', '4', '2');
INSERT INTO `job_info` VALUES ('3', '测试', 'testing', '2,3', '2017-03-22', '0', '2');
INSERT INTO `job_info` VALUES ('4', '验收', '领导验收', '3', '2017-03-30', '5', '2');
INSERT INTO `job_info` VALUES ('24', '工作', '测试2', null, null, '3', '2');
INSERT INTO `job_info` VALUES ('34', '这是标题哦', '新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作新工作', null, null, '1', '2');
INSERT INTO `job_info` VALUES ('35', '444', '4444', null, null, '1', '1');
INSERT INTO `job_info` VALUES ('36', '', 'test', null, null, '2', '2');
INSERT INTO `job_info` VALUES ('37', '22222', '222', null, null, '2', '1');
INSERT INTO `job_info` VALUES ('38', '', '新的', null, null, '2', '3');
INSERT INTO `job_info` VALUES ('39', '', '旧的', null, null, '0', '3');
INSERT INTO `job_info` VALUES ('40', '', '33333', null, null, '1', '3');

-- ----------------------------
-- Table structure for `job_list`
-- ----------------------------
DROP TABLE IF EXISTS `job_list`;
CREATE TABLE `job_list` (
  `list_id` int(255) NOT NULL AUTO_INCREMENT,
  `list_title` varchar(255) DEFAULT NULL,
  `list_sort` int(11) DEFAULT NULL,
  `board_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_list
-- ----------------------------
INSERT INTO `job_list` VALUES ('1', '第一天', '1', '1');
INSERT INTO `job_list` VALUES ('2', '第二天', '2', '1');
INSERT INTO `job_list` VALUES ('3', '下周', null, '2');
INSERT INTO `job_list` VALUES ('12', '新列表', '3', '1');
INSERT INTO `job_list` VALUES ('13', '哦', '0', '1');
INSERT INTO `job_list` VALUES ('14', '人才', '4', '1');
INSERT INTO `job_list` VALUES ('15', '123', null, '15');
INSERT INTO `job_list` VALUES ('16', '333', null, '15');
INSERT INTO `job_list` VALUES ('17', '新加的', null, '15');
INSERT INTO `job_list` VALUES ('18', '222', null, '15');
INSERT INTO `job_list` VALUES ('19', '123', '1', '14');
INSERT INTO `job_list` VALUES ('32', 'im', null, '2');

-- ----------------------------
-- Table structure for `sys_color`
-- ----------------------------
DROP TABLE IF EXISTS `sys_color`;
CREATE TABLE `sys_color` (
  `color_id` int(11) NOT NULL DEFAULT '0',
  `color_desc` varchar(255) DEFAULT NULL,
  `color_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_color
-- ----------------------------
INSERT INTO `sys_color` VALUES ('0', '绿色', '#519839');
INSERT INTO `sys_color` VALUES ('1', '黄色', '#D9B51C');
INSERT INTO `sys_color` VALUES ('2', '橙色', '#D29034');
INSERT INTO `sys_color` VALUES ('3', '红色', '#B04632');
INSERT INTO `sys_color` VALUES ('4', '紫色', '#89609E');
INSERT INTO `sys_color` VALUES ('5', '蓝色', '#055A8C');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(255) NOT NULL DEFAULT '',
  `user_name` varchar(255) DEFAULT NULL,
  `user_account` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '张三', 'acc1', '1');
INSERT INTO `sys_user` VALUES ('2', '李四', 'acc2', '1');

-- ----------------------------
-- Table structure for `sys_user_copy`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_copy`;
CREATE TABLE `sys_user_copy` (
  `user_id` varchar(255) NOT NULL DEFAULT '',
  `user_name` varchar(255) DEFAULT NULL,
  `user_account` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_copy
-- ----------------------------
INSERT INTO `sys_user_copy` VALUES ('1', '张三', 'acc1', '1');
INSERT INTO `sys_user_copy` VALUES ('2', '李四', 'acc2', '1');
