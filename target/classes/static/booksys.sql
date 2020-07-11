/*
Navicat MySQL Data Transfer

Source Server         : CYT
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : booksys

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-07-10 20:35:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `backlog`
-- ----------------------------
DROP TABLE IF EXISTS `backlog`;
CREATE TABLE `backlog` (
  `back_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `book_id` int(10) NOT NULL,
  `back_date` date NOT NULL,
  PRIMARY KEY (`back_id`),
  KEY `b1` (`user_id`),
  KEY `b2` (`book_id`),
  CONSTRAINT `b1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `b2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backlog
-- ----------------------------
INSERT INTO `backlog` VALUES ('1', '1', '1', '2020-07-09');
INSERT INTO `backlog` VALUES ('2', '1', '2', '2020-07-09');
INSERT INTO `backlog` VALUES ('3', '2', '1', '2020-07-09');
INSERT INTO `backlog` VALUES ('4', '2', '2', '2020-07-09');
INSERT INTO `backlog` VALUES ('5', '2', '4', '2020-07-09');
INSERT INTO `backlog` VALUES ('6', '1', '1', '2020-07-09');
INSERT INTO `backlog` VALUES ('8', '3', '1', '2020-07-10');
INSERT INTO `backlog` VALUES ('9', '2', '4', '2020-07-10');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `num` int(10) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '山海经', '远古幻想生物图鉴', '玄幻', '48');
INSERT INTO `book` VALUES ('2', '诛仙', '修仙佳作之一', '修真', '5');
INSERT INTO `book` VALUES ('4', '求魔', '耳根3部曲第二部', '修真', '1');

-- ----------------------------
-- Table structure for `borrowlog`
-- ----------------------------
DROP TABLE IF EXISTS `borrowlog`;
CREATE TABLE `borrowlog` (
  `borrow_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `book_id` int(10) NOT NULL,
  `borrow_date` date NOT NULL,
  PRIMARY KEY (`borrow_id`),
  KEY `a1` (`user_id`),
  KEY `a2` (`book_id`),
  CONSTRAINT `a1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `a2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowlog
-- ----------------------------
INSERT INTO `borrowlog` VALUES ('2', '2', '2', '2020-07-09');
INSERT INTO `borrowlog` VALUES ('4', '1', '2', '2020-07-09');
INSERT INTO `borrowlog` VALUES ('7', '2', '1', '2020-07-10');
INSERT INTO `borrowlog` VALUES ('8', '2', '1', '2020-07-10');
INSERT INTO `borrowlog` VALUES ('9', '2', '2', '2020-07-10');
INSERT INTO `borrowlog` VALUES ('10', '2', '4', '2020-07-10');
INSERT INTO `borrowlog` VALUES ('11', '2', '2', '2020-07-10');
INSERT INTO `borrowlog` VALUES ('12', '2', '2', '2020-07-10');
INSERT INTO `borrowlog` VALUES ('13', '2', '1', '2020-07-10');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `regtime` date NOT NULL,
  `role` varchar(255) NOT NULL DEFAULT '',
  `borrow_num` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', '2020-07-08', '管理员', '1');
INSERT INTO `user` VALUES ('2', 'cyt', '123', '2020-07-08', '普通用户', '8');
INSERT INTO `user` VALUES ('3', 'cyt2', '123', '2020-07-10', '普通用户', '1');
INSERT INTO `user` VALUES ('4', 'cyt12', '123', '2020-07-10', '普通用户', '0');
