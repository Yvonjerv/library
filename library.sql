/*
Navicat MySQL Data Transfer

Source Server         : mysql_connect
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2020-03-28 09:06:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `Book_id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Author` varchar(50) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Book_id`),
  KEY `fk_Category_id` (`Category_id`),
  CONSTRAINT `fk_Category_id` FOREIGN KEY (`Category_id`) REFERENCES `categories` (`Category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', 'Black Mirror', 'Jon James', '3', '1');
INSERT INTO `books` VALUES ('2', 'Heroes of tomorrow', 'Chen Wang', '11', '3');
INSERT INTO `books` VALUES ('3', 'Tours', 'Sam James', '4', '2');
INSERT INTO `books` VALUES ('4', 'Hello World', 'Java', '11', '4');
INSERT INTO `books` VALUES ('5', 'Globe', 'Global G', '6', '8');
INSERT INTO `books` VALUES ('6', 'Pies', 'Peter Fils', '5', '9');
INSERT INTO `books` VALUES ('7', 'Visits', 'Molly Brown', '5', '1');
INSERT INTO `books` VALUES ('8', 'Swimming', 'Micheal Phelps', '2', '2');
INSERT INTO `books` VALUES ('9', 'HDHDH', 'YRYR', '4', '5');

-- ----------------------------
-- Table structure for `borrows`
-- ----------------------------
DROP TABLE IF EXISTS `borrows`;
CREATE TABLE `borrows` (
  `Borrow_id` int(11) NOT NULL AUTO_INCREMENT,
  `Student_id` int(11) DEFAULT NULL,
  `Book_id` int(11) DEFAULT NULL,
  `Start_Date` datetime DEFAULT NULL,
  `End_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`Borrow_id`),
  KEY `fk_book_id` (`Book_id`),
  KEY `fk_student_id` (`Student_id`),
  CONSTRAINT `fk_book_id` FOREIGN KEY (`Book_id`) REFERENCES `books` (`Book_id`),
  CONSTRAINT `fk_student_id` FOREIGN KEY (`Student_id`) REFERENCES `students` (`Student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrows
-- ----------------------------
INSERT INTO `borrows` VALUES ('1', '1', '2', '2019-08-13 19:28:29', '2019-10-03 00:00:00');
INSERT INTO `borrows` VALUES ('2', '1', '1', '2019-10-02 23:15:47', '2019-10-03 09:21:00');
INSERT INTO `borrows` VALUES ('3', '1', '2', '2019-10-02 23:16:06', '2019-10-03 10:20:58');
INSERT INTO `borrows` VALUES ('4', '1', '2', '2019-10-04 21:08:30', '2019-10-04 21:08:56');
INSERT INTO `borrows` VALUES ('5', '1', '1', '2019-10-26 21:54:08', '2019-10-26 21:54:56');

-- ----------------------------
-- Table structure for `categories`
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `Category_id` int(11) NOT NULL AUTO_INCREMENT,
  `Category_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES ('1', 'Politics');
INSERT INTO `categories` VALUES ('2', 'Science');
INSERT INTO `categories` VALUES ('3', 'Design');
INSERT INTO `categories` VALUES ('4', 'Technology');
INSERT INTO `categories` VALUES ('5', 'Business');
INSERT INTO `categories` VALUES ('6', 'Literature');
INSERT INTO `categories` VALUES ('7', 'Demography');
INSERT INTO `categories` VALUES ('8', 'Administration');
INSERT INTO `categories` VALUES ('9', 'Education');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `LogID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`LogID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', 'yvon', '1234');
INSERT INTO `login` VALUES ('2', 'jervis', '1234');
INSERT INTO `login` VALUES ('3', '1234', '1234');

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `Student_id` int(11) NOT NULL AUTO_INCREMENT,
  `First_name` varchar(50) DEFAULT NULL,
  `Last_name` varchar(50) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Dob` date DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Phone_number` varchar(12) DEFAULT NULL,
  `Student_Reference` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('1', 'Yvon', 'Yvon', 'Male', '2000-02-02', 'something', '12345678', '12345678');
INSERT INTO `students` VALUES ('2', 'Jacob', 'Cross', 'Male', '2019-06-03', 'wqertrewq', '2345321', '123456321');
INSERT INTO `students` VALUES ('3', 'Name', 'Name', 'Male', '2002-02-04', 'address', '533121212323', '12313213');

-- ----------------------------
-- Function structure for `fun_max`
-- ----------------------------
DROP FUNCTION IF EXISTS `fun_max`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fun_max`(a int, b int) RETURNS int(11)
    NO SQL
BEGIN

declare c int;

if (a<b) then 
set c=b;
ELSE set c=a;
end if;

RETURN c;
end
;;
DELIMITER ;
