/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-01-28 11:23:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bbs_comment_info
-- ----------------------------
DROP TABLE IF EXISTS `bbs_comment_info`;
CREATE TABLE `bbs_comment_info` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论编码',
  `postCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子编码',
  `userAccount` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论人',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论内容',
  `commentTime` datetime NOT NULL COMMENT '评论时间',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `modifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=473 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='记录评论帖子内容的表格';

-- ----------------------------
-- Table structure for bbs_complain_info
-- ----------------------------
DROP TABLE IF EXISTS `bbs_complain_info`;
CREATE TABLE `bbs_complain_info` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '投诉编码',
  `typeCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '投诉类型编码',
  `postCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '投诉帖子编码',
  `postTitle` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '投诉帖子标题',
  `message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '投诉内容描述',
  `complainant` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '投诉者',
  `status` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '00' COMMENT '阅读状态: 00-未读, 01-已读',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
  `createDate` datetime NOT NULL COMMENT '创建日期',
  `motifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `motifyDate` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户举报信息';

-- ----------------------------
-- Table structure for bbs_complain_type
-- ----------------------------
DROP TABLE IF EXISTS `bbs_complain_type`;
CREATE TABLE `bbs_complain_type` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '投诉类型编码',
  `typer` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '投诉类型',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
  `createDate` datetime NOT NULL COMMENT '创建日期',
  `motifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `motifyDate` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='举报类型（常量）';

-- ----------------------------
-- Table structure for bbs_module_info
-- ----------------------------
DROP TABLE IF EXISTS `bbs_module_info`;
CREATE TABLE `bbs_module_info` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '板块编码',
  `moduleName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '板块名称',
  `userAccount` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '版主账号',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改人',
  `modifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='版块信息';

-- ----------------------------
-- Table structure for bbs_post_class
-- ----------------------------
DROP TABLE IF EXISTS `bbs_post_class`;
CREATE TABLE `bbs_post_class` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `moduleCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '板块编码',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类别编码',
  `className` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类别名',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'admin' COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `modifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=355 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='帖子类别';

-- ----------------------------
-- Table structure for bbs_post_info
-- ----------------------------
DROP TABLE IF EXISTS `bbs_post_info`;
CREATE TABLE `bbs_post_info` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子编码',
  `moduleCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子板块',
  `postClassCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子类别',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子标题',
  `hostAccount` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '发帖人账号',
  `publishDate` date NOT NULL COMMENT '发帖日期',
  `article` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子内容',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '帖子的展示图片',
  `readingAmount` bigint(20) NOT NULL DEFAULT '0' COMMENT '帖子阅读数',
  `praiseAmount` bigint(20) NOT NULL DEFAULT '0' COMMENT '帖子点赞数',
  `replyAmount` bigint(20) NOT NULL DEFAULT '0' COMMENT '帖子回复数',
  `status` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '01' COMMENT '帖子状态: 01-帖子正常; 00-帖子关闭',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'admin' COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `modifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=961 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='帖子信息';

-- ----------------------------
-- Table structure for bbs_reply_info
-- ----------------------------
DROP TABLE IF EXISTS `bbs_reply_info`;
CREATE TABLE `bbs_reply_info` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '回复编码',
  `replier` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '回复人',
  `commentCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '回复的评论编码',
  `replyComment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '回复内容',
  `replyDate` datetime NOT NULL COMMENT '回复时间',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `modifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='记录回复帖子评论的表格';

-- ----------------------------
-- Table structure for bbs_sumdata_table
-- ----------------------------
DROP TABLE IF EXISTS `bbs_sumdata_table`;
CREATE TABLE `bbs_sumdata_table` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `day` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '日期',
  `moduleId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sumPost` bigint(20) NOT NULL COMMENT '日总帖子数',
  `sumPraise` bigint(20) NOT NULL COMMENT '日总点赞数',
  `maxPraisePostName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '点赞最多的帖子名字',
  `bestActiviteUsername` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '每周最活跃的用户昵称',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `modifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=1173 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='报表数据显示';

-- ----------------------------
-- Table structure for bbs_user_info
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_info`;
CREATE TABLE `bbs_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号',
  `userName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '性别(0-暂未设置性别；1-男；2-女)',
  `roleName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户角色(0-管理员；1-版主；2-普通用户)',
  `newMessage` int(11) NOT NULL DEFAULT '0',
  `createDate` datetime DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for bbs_user_liveness
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_liveness`;
CREATE TABLE `bbs_user_liveness` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userTid` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '登陆用户账户',
  `loginDate` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '登陆日期',
  `loginModuleId` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `loginTimes` bigint(20) NOT NULL,
  `publishTimes` bigint(20) NOT NULL,
  `userLiveness` bigint(20) NOT NULL,
  `createDate` datetime NOT NULL COMMENT '创建日期',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改日期',
  `modifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=1195 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户登录次数和发帖次数（包括删除帖）';

-- ----------------------------
-- Table structure for bbs_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_permission`;
CREATE TABLE `bbs_user_permission` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色编码',
  `roleName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `roleLevel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色等级',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
  `createDate` datetime NOT NULL COMMENT '创建日期',
  `motifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `motifyDate` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色';

-- ----------------------------
-- Table structure for bbs_user_private_message
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_private_message`;
CREATE TABLE `bbs_user_private_message` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '私信编码',
  `sendPersonAccount` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '私信发送人',
  `recievePersonAccount` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '私信接收人',
  `aboutPostCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '相关的帖子编码(即记录从哪个帖子发私信的)',
  `message` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '私信内容',
  `privateKey` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '加密公钥',
  `messageStatus` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '私信状态(未读;已读;回收站状态)',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'admin' COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `modifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户私信(创建人：chenhuayang)';

-- ----------------------------
-- Table structure for bbs_user_status
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user_status`;
CREATE TABLE `bbs_user_status` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态编码',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户状态',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
  `createDate` datetime NOT NULL COMMENT '创建日期',
  `motifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `motifyDate` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户状态';

-- ----------------------------
-- Table structure for spring_boot_test_cat
-- ----------------------------
DROP TABLE IF EXISTS `spring_boot_test_cat`;
CREATE TABLE `spring_boot_test_cat` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'cat名字',
  `catAge` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '私信编码',
  `sendPersonAccount` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '私信发送人',
  `recievePersonAccount` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '私信接收人',
  `aboutPostCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '相关的帖子编码(即记录从哪个帖子发私信的)',
  `message` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '私信内容',
  `privateKey` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '加密公钥',
  `messageStatus` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '私信状态(未读;已读;回收站状态)',
  `createDate` datetime NOT NULL COMMENT '创建时间',
  `createBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'admin' COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `modifyBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for test_user_photo
-- ----------------------------
DROP TABLE IF EXISTS `test_user_photo`;
CREATE TABLE `test_user_photo` (
  `id` int(11) NOT NULL,
  `imageUserId` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `imagePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
