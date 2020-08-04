/*
 Navicat MySQL Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : douyin

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 28/02/2020 10:48:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for audio
-- ----------------------------
DROP TABLE IF EXISTS `audio`;
CREATE TABLE `audio`  (
  `audio_id` int(9) NOT NULL AUTO_INCREMENT,
  `audio_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audio_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audio_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audio_status` int(9) NULL DEFAULT NULL,
  `business_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`audio_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `business_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `business_status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`business_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES (1, 'han', NULL);
INSERT INTO `business` VALUES (2, 'abc', NULL);
INSERT INTO `business` VALUES (3, '1323', NULL);
INSERT INTO `business` VALUES (4, 'www', NULL);
INSERT INTO `business` VALUES (5, 'qqq', NULL);
INSERT INTO `business` VALUES (6, 'aaaa', NULL);
INSERT INTO `business` VALUES (7, 'sss', NULL);

-- ----------------------------
-- Table structure for businessinfo
-- ----------------------------
DROP TABLE IF EXISTS `businessinfo`;
CREATE TABLE `businessinfo`  (
  `business_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_info_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `business_info_legal_persion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `business_info_legal_persion_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `business_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`business_info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of businessinfo
-- ----------------------------
INSERT INTO `businessinfo` VALUES (1, 'qq', 'qq', 'qq', 1);
INSERT INTO `businessinfo` VALUES (2, 'abc', 'abc', 'sdf', 2);
INSERT INTO `businessinfo` VALUES (3, 'abc', 'abc', 'sdf', 3);
INSERT INTO `businessinfo` VALUES (4, 'abc', 'abc', 'sdf', 4);
INSERT INTO `businessinfo` VALUES (5, 'abc', 'abc', 'sdf', 5);
INSERT INTO `businessinfo` VALUES (6, 'abc', 'abc', 'sdf', 6);
INSERT INTO `businessinfo` VALUES (7, 'abc', 'abc', 'sdf', 7);

-- ----------------------------
-- Table structure for businesspass
-- ----------------------------
DROP TABLE IF EXISTS `businesspass`;
CREATE TABLE `businesspass`  (
  `business_pass_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_pass_word` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `business_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`business_pass_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of businesspass
-- ----------------------------
INSERT INTO `businesspass` VALUES (1, '123', 1);
INSERT INTO `businesspass` VALUES (2, '123', 2);
INSERT INTO `businesspass` VALUES (3, 'eee', 3);
INSERT INTO `businesspass` VALUES (4, '123', 4);
INSERT INTO `businesspass` VALUES (5, '123', 5);
INSERT INTO `businesspass` VALUES (6, '123', 6);
INSERT INTO `businesspass` VALUES (7, '123', 7);

-- ----------------------------
-- Table structure for loginpass
-- ----------------------------
DROP TABLE IF EXISTS `loginpass`;
CREATE TABLE `loginpass`  (
  `login_pass_id` int(9) NOT NULL AUTO_INCREMENT,
  `login_pass_word` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_user_id` int(9) NULL DEFAULT NULL,
  PRIMARY KEY (`login_pass_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loginpass
-- ----------------------------
INSERT INTO `loginpass` VALUES (1, '123', 1);
INSERT INTO `loginpass` VALUES (2, '123', 2);

-- ----------------------------
-- Table structure for loginuser
-- ----------------------------
DROP TABLE IF EXISTS `loginuser`;
CREATE TABLE `loginuser`  (
  `login_user_id` int(9) NOT NULL AUTO_INCREMENT,
  `login_user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_user_status` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`login_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loginuser
-- ----------------------------
INSERT INTO `loginuser` VALUES (1, 'lisi', NULL);
INSERT INTO `loginuser` VALUES (2, 'abc', NULL);

-- ----------------------------
-- Table structure for systemuser
-- ----------------------------
DROP TABLE IF EXISTS `systemuser`;
CREATE TABLE `systemuser`  (
  `user_id` int(9) NOT NULL AUTO_INCREMENT,
  `user_true_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_tel` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_sex` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_user_id` int(9) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of systemuser
-- ----------------------------
INSERT INTO `systemuser` VALUES (1, '小红', '2222222', '女', 1);
INSERT INTO `systemuser` VALUES (2, '小明', '214324', '女', 2);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `video_id` int(9) NOT NULL AUTO_INCREMENT,
  `video_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `video_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `video_date` datetime(0) NULL DEFAULT NULL,
  `video_status` int(9) NULL DEFAULT NULL,
  `business_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`video_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (3, '你好', '/vedio/4ca53baea33e7f92c7a5b53df2ab54aa.mp4', '2020-02-27 10:49:31', NULL, 1);
INSERT INTO `video` VALUES (4, '666', '/vedio/5e22d30d4d731bbc12f873ffde8534f1.mp4', '2020-02-27 10:49:57', NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
