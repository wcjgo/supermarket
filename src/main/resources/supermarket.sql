/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : supermarket

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 30/12/2020 20:48:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for superbill
-- ----------------------------
DROP TABLE IF EXISTS `superbill`;
CREATE TABLE `superbill`  (
  `billid` int(10) NOT NULL AUTO_INCREMENT,
  `productname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productdesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productcount` int(10) NOT NULL,
  `totalprice` decimal(10, 0) NOT NULL,
  `ispayment` int(10) NOT NULL,
  `providerid` int(10) NOT NULL,
  `creator` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`billid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1005 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of superbill
-- ----------------------------
INSERT INTO `superbill` VALUES (1001, 'hhhh订单', '66666666666', 20, 500000, 1, 1, 'java', '1999/01/02');
INSERT INTO `superbill` VALUES (1002, '中华香烟', '好抽的烟', 10, 7000, 1, 2, 'c', '2020/06/01');
INSERT INTO `superbill` VALUES (1004, '超声电子', '电子设备', 20, 60000, 0, 2, 'java', '2020/06/10');

-- ----------------------------
-- Table structure for superproviders
-- ----------------------------
DROP TABLE IF EXISTS `superproviders`;
CREATE TABLE `superproviders`  (
  `providerid` int(10) NOT NULL AUTO_INCREMENT,
  `providername` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `providerdesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `providertel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `provideraddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`providerid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of superproviders
-- ----------------------------
INSERT INTO `superproviders` VALUES (1, '北京三木堂商贸有限公司', '长期合作伙伴，主营产品:茅台、五粮液、郎酒、酒鬼酒、泸州老窖、赖茅酒、法国红酒等', '13255889966', '北京市丰台区育芳园北路', 'java', '2020/01/02');
INSERT INTO `superproviders` VALUES (2, 'abc有限公司', '长期合作伙伴，主营产品:可口可乐等11111111', '19200010002', '深圳市南山区', 'php', '2020/02/02');
INSERT INTO `superproviders` VALUES (3, 'java有限公司', '长期合作伙伴，主营产品:方便面等', '15100020003', '沈阳市和平区', 'java', '2020/03/03');

-- ----------------------------
-- Table structure for superusers
-- ----------------------------
DROP TABLE IF EXISTS `superusers`;
CREATE TABLE `superusers`  (
  `userid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ubirthday` date NULL DEFAULT NULL,
  `role` int(255) NOT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of superusers
-- ----------------------------
INSERT INTO `superusers` VALUES ('aaa', '甄姬', '123123', '16600050009', '上海', '2020-05-07', 1);
INSERT INTO `superusers` VALUES ('c', '上官婉儿', '12345', '19800050009', '北京市', '2016-02-05', 1);
INSERT INTO `superusers` VALUES ('java', '老虎', '123456', '18800010002', '深圳市南山区', '2020-06-01', 0);

SET FOREIGN_KEY_CHECKS = 1;
