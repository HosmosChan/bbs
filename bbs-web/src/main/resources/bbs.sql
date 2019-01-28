/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-01-28 11:21:05
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
-- Records of bbs_comment_info
-- ----------------------------

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
-- Records of bbs_complain_info
-- ----------------------------

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
-- Records of bbs_complain_type
-- ----------------------------
INSERT INTO `bbs_complain_type` VALUES ('1', '0000', '广告信息', 'Admin', '2018-07-23 11:46:26', null, null);
INSERT INTO `bbs_complain_type` VALUES ('2', '0001', '恶意灌水', 'Admin', '2018-07-23 11:47:06', null, null);
INSERT INTO `bbs_complain_type` VALUES ('3', '0002', '违规内容', 'Admin', '2018-07-23 11:47:28', null, null);
INSERT INTO `bbs_complain_type` VALUES ('4', '0003', '恶意辱骂', 'Admin', '2018-07-23 11:47:48', null, null);
INSERT INTO `bbs_complain_type` VALUES ('5', '0004', '欺骗信息', 'Admin', '2018-07-23 11:48:10', null, null);
INSERT INTO `bbs_complain_type` VALUES ('6', '0005', '重复发帖', 'Admin', '2018-07-23 16:05:54', null, null);
INSERT INTO `bbs_complain_type` VALUES ('7', '0006', '版区归类', 'Admin', '2018-07-23 16:06:28', null, null);
INSERT INTO `bbs_complain_type` VALUES ('8', '0007', '过期资料', 'Admin', '2018-07-23 16:07:13', null, null);

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
-- Records of bbs_module_info
-- ----------------------------
INSERT INTO `bbs_module_info` VALUES ('1', '0', '超级版块', '', '2018-08-23 08:50:26', '', null, '');
INSERT INTO `bbs_module_info` VALUES ('111', '5f0c1e8945b74c7889c0874e6302d6d3', '享系列', '13725479392', '2018-09-14 10:06:57', '', null, '');
INSERT INTO `bbs_module_info` VALUES ('113', '82e49fab0458446cbd8218eb4ce649b8', '智能家居', '15083532061', '2018-09-14 10:08:01', '', null, '');
INSERT INTO `bbs_module_info` VALUES ('115', '97ca74066e0943eb96a7bddff25280a2', '收费系统', '18392024472', '2018-09-14 10:08:49', '', null, '');
INSERT INTO `bbs_module_info` VALUES ('117', '761f41bef1db4fd8ab7d0db2bad423bf', '阅读文艺', '18392024473', '2018-09-14 10:10:05', '', null, '');
INSERT INTO `bbs_module_info` VALUES ('119', 'ffcb27b3e7744b45a30266c6118ac244', '娱乐时尚', '18392024475', '2018-09-14 10:11:24', '', null, '');
INSERT INTO `bbs_module_info` VALUES ('121', 'f396e474d53945ad9cd5cbba2d9e090f', '运动社团', '18392024476', '2018-09-14 10:12:27', '', null, '');
INSERT INTO `bbs_module_info` VALUES ('123', '37a5a0925a7f4207b2481c5f94680b40', '摄影音乐', '18392024477', '2018-09-14 10:13:14', '', null, '');
INSERT INTO `bbs_module_info` VALUES ('125', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '情感交友', '18392024478', '2018-09-14 10:14:01', '', null, '');

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
-- Records of bbs_post_class
-- ----------------------------
INSERT INTO `bbs_post_class` VALUES ('265', '5f0c1e8945b74c7889c0874e6302d6d3', '77a9d295f3904e25a8059d6c4f33c7aa', '技术交流', '2018-09-14 10:07:13', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('267', '5f0c1e8945b74c7889c0874e6302d6d3', '516ee22946fc45c49493d510e2369f40', '侃大山', '2018-09-14 10:07:26', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('269', '82e49fab0458446cbd8218eb4ce649b8', 'd4d46d53dab2449f969e39381951a1a2', '技术交流', '2018-09-14 10:08:27', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('271', '82e49fab0458446cbd8218eb4ce649b8', '59a4d00f894647eca39c40b788302ec3', '侃大山', '2018-09-14 10:08:36', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('273', '97ca74066e0943eb96a7bddff25280a2', '528156fc21684f34a89f6e8a6073cdd1', '技术交流', '2018-09-14 10:09:15', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('275', '97ca74066e0943eb96a7bddff25280a2', 'e09cc606fcb24d5e94070448a11044e8', '侃大山', '2018-09-14 10:09:23', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('284', '761f41bef1db4fd8ab7d0db2bad423bf', 'a3a693592ada4979b80c4df44c39a5b2', '书香艺趣', '2018-09-14 10:10:22', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('286', '761f41bef1db4fd8ab7d0db2bad423bf', 'd65215a8d208461ba1615370aca640d3', '绘画书法', '2018-09-14 10:10:34', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('288', '761f41bef1db4fd8ab7d0db2bad423bf', '9d601d924a2d473a8e1896b643c78409', '历史长河', '2018-09-14 10:10:55', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('290', 'ffcb27b3e7744b45a30266c6118ac244', 'd6e010ae6fdb4a2aa543b017da4f0783', '娱乐八卦', '2018-09-14 10:11:37', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('292', 'ffcb27b3e7744b45a30266c6118ac244', 'dd4848efe1bc48008351fcd314e0bc84', '电脑数码', '2018-09-14 10:11:44', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('294', 'ffcb27b3e7744b45a30266c6118ac244', 'c64512b855c74f50b83befc60266b4f0', '时尚潮流', '2018-09-14 10:11:54', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('296', 'ffcb27b3e7744b45a30266c6118ac244', '32ac498429e348d5b4350e1f934d445b', '游戏频道', '2018-09-14 10:12:01', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('298', 'f396e474d53945ad9cd5cbba2d9e090f', '603d470030954c56b93025d71ff5434a', '羽毛球协会', '2018-09-14 10:12:43', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('300', 'f396e474d53945ad9cd5cbba2d9e090f', '7ada6da1b0b04a89ae071d5e274e165f', '篮球协会', '2018-09-14 10:12:52', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('302', 'f396e474d53945ad9cd5cbba2d9e090f', '9231686dc5504ac2a160300fe8c367d8', '嗨跑协会', '2018-09-14 10:13:02', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('304', '37a5a0925a7f4207b2481c5f94680b40', '2d77500d91094dcc9fb508319d43d958', '摄影沙龙', '2018-09-14 10:13:24', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('306', '37a5a0925a7f4207b2481c5f94680b40', 'bb00e3fef31340408420815dd8812eed', '影音贴吧', '2018-09-14 10:13:39', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('308', '37a5a0925a7f4207b2481c5f94680b40', 'e91b324c96b846b0851ed6eb385b4f9f', '美图一族', '2018-09-14 10:13:49', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('310', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '92ee4f2191134101a04e60f13797954a', '心情故事', '2018-09-14 10:14:12', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('312', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '4dcac7c9a2b74bceba141bbf355de009', '似水流年', '2018-09-14 10:14:20', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('314', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '824a22fcebb8485ab77d9a5f04d0d8fb', '友缘天地', '2018-09-14 10:14:28', '小磊子', null, '');
INSERT INTO `bbs_post_class` VALUES ('316', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '824a22fcebb8485ab77d9a5f04d0d8fb', '友缘天地', '2018-09-14 10:14:28', '小磊子', null, null);

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
-- Records of bbs_post_info
-- ----------------------------
INSERT INTO `bbs_post_info` VALUES ('937', 'ac6ee85443054d0e88bb37e6b73c92e4', 'f396e474d53945ad9cd5cbba2d9e090f', '9231686dc5504ac2a160300fe8c367d8', '测试1测试2测试3测试4测试5测试6测试7测试8测试9测试10测试11', '18965782261', '2018-10-10', '', null, '36', '0', '1', '01', '2018-10-10 10:00:12', 'Admin', null, null);
INSERT INTO `bbs_post_info` VALUES ('939', 'ab2f0975b98d49d8be019ed97e97113c', '761f41bef1db4fd8ab7d0db2bad423bf', '9d601d924a2d473a8e1896b643c78409', '测试1', '18965782261', '2018-10-16', '<p>测试1</p>', '20181016/d98bfb21dd2d4041acd7f7b80326f272', '15', '0', '0', '01', '2018-10-16 09:46:42', 'Admin', null, null);
INSERT INTO `bbs_post_info` VALUES ('941', '6b795fe6301b4de6840cf6d549847452', '761f41bef1db4fd8ab7d0db2bad423bf', 'd65215a8d208461ba1615370aca640d3', '测试2', '18965782261', '2018-10-16', '<p>测试2</p>', '20181016/0841474d052e4d799e070e34061b4221', '8', '0', '0', '01', '2018-10-16 09:46:58', 'Admin', null, null);
INSERT INTO `bbs_post_info` VALUES ('943', 'aab8fc1a84d44faaaff8c4ebbd120c2c', '97ca74066e0943eb96a7bddff25280a2', '528156fc21684f34a89f6e8a6073cdd1', '测试3', '18965782261', '2018-10-16', '<p>测试3</p>', '20181016/073fe99f60904457b3f7144c64d87537', '161', '0', '0', '01', '2018-10-16 09:57:25', 'Admin', null, null);
INSERT INTO `bbs_post_info` VALUES ('945', 'b4e1e95b07784122a766f194be06274b', '37a5a0925a7f4207b2481c5f94680b40', 'bb00e3fef31340408420815dd8812eed', '测试4', '18965782261', '2018-10-16', '<p>测试4</p>', '20181016/4e22e18397cb4b06bebe1bd2f00c8440', '30', '0', '0', '01', '2018-10-16 09:57:44', 'Admin', null, null);
INSERT INTO `bbs_post_info` VALUES ('947', '5fd1528a92ac48a6abcefb005af75105', '82e49fab0458446cbd8218eb4ce649b8', 'd4d46d53dab2449f969e39381951a1a2', '测试5', '18965782261', '2018-10-16', '<p>测试5</p>', '20181016/bfbf48d2d4eb4e2cb01ba7dc98cfcbf2', '62', '0', '0', '01', '2018-10-16 09:58:00', 'Admin', null, null);
INSERT INTO `bbs_post_info` VALUES ('951', '9634ff807e1d4f5bb999db7cf60c7bc2', '37a5a0925a7f4207b2481c5f94680b40', '2d77500d91094dcc9fb508319d43d958', '测试6', '18965782261', '2018-10-16', '<p>测试6</p>', null, '4', '0', '0', '01', '2018-10-16 09:58:54', 'Admin', null, null);
INSERT INTO `bbs_post_info` VALUES ('953', '7499e4ad698e40e3a57583ce746543f9', 'ffcb27b3e7744b45a30266c6118ac244', 'c64512b855c74f50b83befc60266b4f0', '请编辑帖子内容', '18965782261', '2018-10-22', '<p>请编辑帖子内容大师傅</p>', null, '5', '0', '0', '01', '2018-10-22 14:33:56', 'Admin', null, null);
INSERT INTO `bbs_post_info` VALUES ('955', '24baa42d3b314e84978d9bf4b0937c85', '5f0c1e8945b74c7889c0874e6302d6d3', '516ee22946fc45c49493d510e2369f40', '请编辑帖子内容', '18965782261', '2018-10-22', '', null, '1', '0', '0', '01', '2018-10-22 14:34:04', 'Admin', null, null);
INSERT INTO `bbs_post_info` VALUES ('957', 'de0f61b1b9004f76af29bd602e9d0c25', '37a5a0925a7f4207b2481c5f94680b40', 'e91b324c96b846b0851ed6eb385b4f9f', '请编辑帖子内容', '18965782261', '2018-10-22', '', null, '4', '0', '0', '01', '2018-10-22 14:34:10', 'Admin', null, null);
INSERT INTO `bbs_post_info` VALUES ('959', 'b2cdc5e205b94cbda30eabe90c75ff2a', 'ffcb27b3e7744b45a30266c6118ac244', 'dd4848efe1bc48008351fcd314e0bc84', '请编辑帖子内容', '18965782261', '2018-10-22', '', null, '10', '0', '0', '01', '2018-10-22 14:34:17', 'Admin', null, null);

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
-- Records of bbs_reply_info
-- ----------------------------

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
-- Records of bbs_sumdata_table
-- ----------------------------
INSERT INTO `bbs_sumdata_table` VALUES ('533', '2018-09-14', '5f0c1e8945b74c7889c0874e6302d6d3', '8', '2', '好好学习', '', '2018-09-14 12:39:09', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('535', '2018-09-14', '82e49fab0458446cbd8218eb4ce649b8', '3', '0', '奥术大师', '', '2018-09-14 12:39:09', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('537', '2018-09-14', '97ca74066e0943eb96a7bddff25280a2', '7', '0', '阿斯达四大', '', '2018-09-14 12:39:09', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('539', '2018-09-14', '761f41bef1db4fd8ab7d0db2bad423bf', '1', '0', '测试', '', '2018-09-14 12:39:09', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('541', '2018-09-14', 'ffcb27b3e7744b45a30266c6118ac244', '1', '0', 'WSX测试2', '', '2018-09-14 12:39:09', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('543', '2018-09-14', 'f396e474d53945ad9cd5cbba2d9e090f', '1', '0', '今日暂无发帖', '', '2018-09-14 12:39:09', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('545', '2018-09-14', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今日暂无发帖', '', '2018-09-14 12:39:09', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('547', '2018-09-14', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今日暂无发帖', '', '2018-09-14 12:39:09', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('549', '2018-09-15', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-15 02:25:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('551', '2018-09-15', '82e49fab0458446cbd8218eb4ce649b8', '1', '0', 'asdfasdf', '', '2018-09-15 02:25:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('553', '2018-09-15', '97ca74066e0943eb96a7bddff25280a2', '1', '0', '915', '', '2018-09-15 02:25:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('555', '2018-09-15', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-15 02:25:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('557', '2018-09-15', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-15 02:25:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('559', '2018-09-15', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-15 02:25:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('561', '2018-09-15', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-15 02:25:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('563', '2018-09-15', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-15 02:25:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('565', '2018-09-16', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-16 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('567', '2018-09-16', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-16 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('569', '2018-09-16', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-16 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('571', '2018-09-16', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-16 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('573', '2018-09-16', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-16 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('575', '2018-09-16', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-16 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('577', '2018-09-16', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('579', '2018-09-16', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('581', '2018-09-17', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-17 12:19:51', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('583', '2018-09-17', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-17 12:19:51', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('585', '2018-09-17', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-17 12:19:51', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('587', '2018-09-17', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-17 12:19:51', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('589', '2018-09-17', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-17 12:19:51', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('591', '2018-09-17', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-17 12:19:51', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('593', '2018-09-17', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-17 12:19:51', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('595', '2018-09-17', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-17 12:19:51', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('597', '2018-09-18', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-18 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('599', '2018-09-18', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-18 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('601', '2018-09-18', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-18 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('603', '2018-09-18', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-18 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('605', '2018-09-18', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-18 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('607', '2018-09-18', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-18 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('609', '2018-09-18', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-18 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('611', '2018-09-18', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-18 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('613', '2018-09-19', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-19 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('615', '2018-09-19', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-19 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('617', '2018-09-19', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-19 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('619', '2018-09-19', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-19 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('621', '2018-09-19', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-19 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('623', '2018-09-19', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-19 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('625', '2018-09-19', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-19 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('627', '2018-09-19', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-19 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('629', '2018-09-20', '5f0c1e8945b74c7889c0874e6302d6d3', '1', '0', '测试1', '', '2018-09-20 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('631', '2018-09-20', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-20 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('633', '2018-09-20', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-20 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('635', '2018-09-20', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-20 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('637', '2018-09-20', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-20 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('639', '2018-09-20', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-20 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('641', '2018-09-20', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-20 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('643', '2018-09-20', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-20 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('645', '2018-09-21', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-21 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('647', '2018-09-21', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-21 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('649', '2018-09-21', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-21 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('651', '2018-09-21', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-21 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('653', '2018-09-21', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-21 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('655', '2018-09-21', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-21 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('657', '2018-09-21', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-21 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('659', '2018-09-21', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-21 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('661', '2018-09-28', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '吃鸡小能手', '2018-09-28 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('663', '2018-09-28', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '吃鸡小能手', '2018-09-28 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('665', '2018-09-28', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '吃鸡小能手', '2018-09-28 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('667', '2018-09-28', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '吃鸡小能手', '2018-09-28 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('669', '2018-09-28', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '吃鸡小能手', '2018-09-28 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('671', '2018-09-28', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '吃鸡小能手', '2018-09-28 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('673', '2018-09-28', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '吃鸡小能手', '2018-09-28 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('675', '2018-09-28', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '吃鸡小能手', '2018-09-28 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('677', '2018-09-29', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-29 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('679', '2018-09-29', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-29 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('681', '2018-09-29', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-29 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('683', '2018-09-29', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-29 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('685', '2018-09-29', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-29 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('687', '2018-09-29', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-29 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('689', '2018-09-29', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-29 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('691', '2018-09-29', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-09-29 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('693', '2018-09-30', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-09-30 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('695', '2018-09-30', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-09-30 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('697', '2018-09-30', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-09-30 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('699', '2018-09-30', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-09-30 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('701', '2018-09-30', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-09-30 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('703', '2018-09-30', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-09-30 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('705', '2018-09-30', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-09-30 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('707', '2018-09-30', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-09-30 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('709', '2018-10-04', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-04 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('711', '2018-10-04', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-04 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('713', '2018-10-04', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-04 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('715', '2018-10-04', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-04 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('717', '2018-10-04', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-04 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('719', '2018-10-04', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-04 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('721', '2018-10-04', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-04 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('723', '2018-10-04', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-04 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('725', '2018-10-05', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-05 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('727', '2018-10-05', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-05 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('729', '2018-10-05', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-05 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('731', '2018-10-05', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-05 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('733', '2018-10-05', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-05 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('735', '2018-10-05', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-05 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('737', '2018-10-05', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-05 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('739', '2018-10-05', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-05 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('741', '2018-10-09', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-09 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('743', '2018-10-09', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-09 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('745', '2018-10-09', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-09 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('747', '2018-10-09', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-09 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('749', '2018-10-09', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-09 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('751', '2018-10-09', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-09 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('753', '2018-10-09', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-09 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('755', '2018-10-09', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-09 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('757', '2018-10-10', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-10 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('759', '2018-10-10', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-10 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('761', '2018-10-10', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-10 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('763', '2018-10-10', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-10 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('765', '2018-10-10', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-10 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('767', '2018-10-10', 'f396e474d53945ad9cd5cbba2d9e090f', '1', '0', '测试1测试2测试3测试4测试5测试6测试7测试8测试9测试10测试11', '', '2018-10-10 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('769', '2018-10-10', '37a5a0925a7f4207b2481c5f94680b40', '1', '0', '测试abcdefghijklmnopqrstuvwxyz', '', '2018-10-10 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('771', '2018-10-10', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-10 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('773', '2018-10-11', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-11 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('775', '2018-10-11', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-11 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('777', '2018-10-11', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-11 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('779', '2018-10-11', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-11 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('781', '2018-10-11', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-11 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('783', '2018-10-11', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-11 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('785', '2018-10-11', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-11 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('787', '2018-10-11', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-11 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('789', '2018-10-12', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-12 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('791', '2018-10-12', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-12 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('793', '2018-10-12', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-12 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('795', '2018-10-12', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-12 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('797', '2018-10-12', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-12 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('799', '2018-10-12', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-12 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('801', '2018-10-12', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-12 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('803', '2018-10-12', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-12 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('805', '2018-10-13', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-13 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('807', '2018-10-13', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-13 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('809', '2018-10-13', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-13 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('811', '2018-10-13', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-13 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('813', '2018-10-13', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-13 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('815', '2018-10-13', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-13 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('817', '2018-10-13', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-13 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('819', '2018-10-13', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-13 00:00:07', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('821', '2018-10-14', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-14 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('823', '2018-10-14', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-14 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('825', '2018-10-14', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-14 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('827', '2018-10-14', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-14 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('829', '2018-10-14', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-14 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('831', '2018-10-14', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-14 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('833', '2018-10-14', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-14 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('835', '2018-10-14', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-14 00:00:06', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('837', '2018-10-15', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-15 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('839', '2018-10-15', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-15 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('841', '2018-10-15', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-15 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('843', '2018-10-15', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-15 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('845', '2018-10-15', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-15 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('847', '2018-10-15', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-15 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('849', '2018-10-15', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-15 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('851', '2018-10-15', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-15 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('853', '2018-10-16', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('855', '2018-10-16', '82e49fab0458446cbd8218eb4ce649b8', '1', '0', '测试5', '', '2018-10-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('857', '2018-10-16', '97ca74066e0943eb96a7bddff25280a2', '1', '0', '测试3', '', '2018-10-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('859', '2018-10-16', '761f41bef1db4fd8ab7d0db2bad423bf', '2', '0', '测试2', '', '2018-10-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('861', '2018-10-16', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('863', '2018-10-16', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('865', '2018-10-16', '37a5a0925a7f4207b2481c5f94680b40', '2', '0', '测试6', '', '2018-10-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('867', '2018-10-16', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '1', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('869', '2018-10-17', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-17 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('871', '2018-10-17', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-17 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('873', '2018-10-17', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-17 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('875', '2018-10-17', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-17 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('877', '2018-10-17', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-17 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('879', '2018-10-17', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-17 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('881', '2018-10-17', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-17 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('883', '2018-10-17', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-17 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('885', '2018-10-18', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-18 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('887', '2018-10-18', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-18 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('889', '2018-10-18', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-18 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('891', '2018-10-18', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-18 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('893', '2018-10-18', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-18 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('895', '2018-10-18', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-18 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('897', '2018-10-18', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-18 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('899', '2018-10-18', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-18 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('901', '2018-10-19', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-19 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('903', '2018-10-19', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-19 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('905', '2018-10-19', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-19 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('907', '2018-10-19', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-19 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('909', '2018-10-19', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-19 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('911', '2018-10-19', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-19 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('913', '2018-10-19', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-19 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('915', '2018-10-19', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-19 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('917', '2018-10-21', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-21 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('919', '2018-10-21', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-21 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('921', '2018-10-21', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-21 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('923', '2018-10-21', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-21 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('925', '2018-10-21', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-21 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('927', '2018-10-21', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-21 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('929', '2018-10-21', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-21 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('931', '2018-10-21', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-21 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('933', '2018-10-22', '5f0c1e8945b74c7889c0874e6302d6d3', '1', '0', '请编辑帖子内容', '', '2018-10-22 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('935', '2018-10-22', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-22 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('937', '2018-10-22', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-22 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('939', '2018-10-22', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-22 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('941', '2018-10-22', 'ffcb27b3e7744b45a30266c6118ac244', '2', '0', '请编辑帖子内容', '', '2018-10-22 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('943', '2018-10-22', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-22 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('945', '2018-10-22', '37a5a0925a7f4207b2481c5f94680b40', '1', '0', '请编辑帖子内容', '', '2018-10-22 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('947', '2018-10-22', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-22 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('949', '2018-10-23', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-23 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('951', '2018-10-23', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-23 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('953', '2018-10-23', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-23 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('955', '2018-10-23', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-23 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('957', '2018-10-23', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-23 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('959', '2018-10-23', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-23 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('961', '2018-10-23', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-23 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('963', '2018-10-23', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-23 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('965', '2018-10-24', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-24 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('967', '2018-10-24', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-24 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('969', '2018-10-24', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-24 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('971', '2018-10-24', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-24 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('973', '2018-10-24', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-24 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('975', '2018-10-24', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-24 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('977', '2018-10-24', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-24 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('979', '2018-10-24', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-24 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('981', '2018-10-25', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-25 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('983', '2018-10-25', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-25 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('985', '2018-10-25', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-25 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('987', '2018-10-25', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-25 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('989', '2018-10-25', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-25 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('991', '2018-10-25', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-25 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('993', '2018-10-25', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-25 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('995', '2018-10-25', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-25 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('997', '2018-10-26', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-26 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('999', '2018-10-26', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-26 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1001', '2018-10-26', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-26 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1003', '2018-10-26', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-26 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1005', '2018-10-26', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-26 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1007', '2018-10-26', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-26 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1009', '2018-10-26', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-26 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1011', '2018-10-26', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-26 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1013', '2018-10-27', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-27 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1015', '2018-10-27', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-27 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1017', '2018-10-27', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-27 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1019', '2018-10-27', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-27 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1021', '2018-10-27', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-27 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1023', '2018-10-27', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-27 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1025', '2018-10-27', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-27 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1027', '2018-10-27', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-27 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1029', '2018-10-28', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-28 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1031', '2018-10-28', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-28 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1033', '2018-10-28', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-28 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1035', '2018-10-28', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-28 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1037', '2018-10-28', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-28 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1039', '2018-10-28', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-28 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1041', '2018-10-28', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-28 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1043', '2018-10-28', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', 'Hosmos', '2018-10-28 00:00:10', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1045', '2018-10-29', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-29 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1047', '2018-10-29', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-29 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1049', '2018-10-29', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-29 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1051', '2018-10-29', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-29 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1053', '2018-10-29', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-29 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1055', '2018-10-29', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-29 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1057', '2018-10-29', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-29 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1059', '2018-10-29', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-29 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1061', '2018-10-30', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-30 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1063', '2018-10-30', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-30 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1065', '2018-10-30', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-30 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1067', '2018-10-30', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-30 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1069', '2018-10-30', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-30 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1071', '2018-10-30', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-30 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1073', '2018-10-30', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-30 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1075', '2018-10-30', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-30 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1077', '2018-10-31', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-31 00:11:27', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1079', '2018-10-31', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-31 00:11:27', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1081', '2018-10-31', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-31 00:11:27', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1083', '2018-10-31', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-31 00:11:27', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1085', '2018-10-31', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-31 00:11:27', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1087', '2018-10-31', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-31 00:11:27', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1089', '2018-10-31', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-31 00:11:27', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1091', '2018-10-31', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-10-31 00:11:27', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1093', '2018-11-01', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-01 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1095', '2018-11-01', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-01 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1097', '2018-11-01', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-01 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1099', '2018-11-01', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-01 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1101', '2018-11-01', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-01 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1103', '2018-11-01', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-01 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1105', '2018-11-01', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-01 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1107', '2018-11-01', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-01 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1109', '2018-11-02', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-02 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1111', '2018-11-02', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-02 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1113', '2018-11-02', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-02 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1115', '2018-11-02', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-02 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1117', '2018-11-02', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-02 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1119', '2018-11-02', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-02 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1121', '2018-11-02', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-02 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1123', '2018-11-02', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-02 00:00:00', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1125', '2018-11-16', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1126', '2018-11-16', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1127', '2018-11-16', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1128', '2018-11-16', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1129', '2018-11-16', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1130', '2018-11-16', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1131', '2018-11-16', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-16 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1132', '2018-11-16', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2018-11-16 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1133', '2019-01-11', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-11 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1134', '2019-01-11', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-11 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1135', '2019-01-11', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-11 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1136', '2019-01-11', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-11 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1137', '2019-01-11', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-11 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1138', '2019-01-11', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-11 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1139', '2019-01-11', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-11 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1140', '2019-01-11', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-11 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1141', '2019-01-24', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-24 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1142', '2019-01-24', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-24 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1143', '2019-01-24', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-24 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1144', '2019-01-24', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-24 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1145', '2019-01-24', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-24 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1146', '2019-01-24', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-24 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1147', '2019-01-24', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-24 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1148', '2019-01-24', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-24 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1149', '2019-01-26', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-26 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1150', '2019-01-26', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-26 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1151', '2019-01-26', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-26 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1152', '2019-01-26', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-26 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1153', '2019-01-26', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-26 00:00:01', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1154', '2019-01-26', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-26 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1155', '2019-01-26', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-26 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1156', '2019-01-26', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-26 00:00:02', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1157', '2019-01-27', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-27 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1158', '2019-01-27', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-27 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1159', '2019-01-27', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-27 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1160', '2019-01-27', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-27 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1161', '2019-01-27', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-27 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1162', '2019-01-27', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-27 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1163', '2019-01-27', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-27 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1164', '2019-01-27', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-27 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1165', '2019-01-28', '5f0c1e8945b74c7889c0874e6302d6d3', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-28 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1166', '2019-01-28', '82e49fab0458446cbd8218eb4ce649b8', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-28 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1167', '2019-01-28', '97ca74066e0943eb96a7bddff25280a2', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-28 00:00:03', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1168', '2019-01-28', '761f41bef1db4fd8ab7d0db2bad423bf', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-28 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1169', '2019-01-28', 'ffcb27b3e7744b45a30266c6118ac244', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-28 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1170', '2019-01-28', 'f396e474d53945ad9cd5cbba2d9e090f', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-28 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1171', '2019-01-28', '37a5a0925a7f4207b2481c5f94680b40', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-28 00:00:04', 'admin', null, null);
INSERT INTO `bbs_sumdata_table` VALUES ('1172', '2019-01-28', '5c4530bcb6244befb6f3e5e4a7fe1bcb', '0', '0', '今天没人觉得有帖子很赞呦', '', '2019-01-28 00:00:04', 'admin', null, null);

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
-- Records of bbs_user_info
-- ----------------------------
INSERT INTO `bbs_user_info` VALUES ('139', '18392024474', '小磊子', '529f7e4923b35483585f81f1b126d4b0', '1', '管理员', '0', '2018-09-13 10:23:33', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('141', '13725479392', '吃鸡小能手', '529f7e4923b35483585f81f1b126d4b0', '0', '版主', '0', '2018-09-14 09:50:30', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('143', '15083532061', '司铜', '529f7e4923b35483585f81f1b126d4b0', '1', '版主', '0', '2018-09-14 09:55:08', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('145', '18099483996', '天生丽质', '529f7e4923b35483585f81f1b126d4b0', '2', '管理员', '0', '2018-09-14 09:55:17', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('147', '18392024472', '无敌小磊子', '529f7e4923b35483585f81f1b126d4b0', '0', '版主', '0', '2018-09-14 09:59:27', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('149', '13513961715', '勇猛神武', '529f7e4923b35483585f81f1b126d4b0', '0', '普通用户', '0', '2018-09-14 09:59:02', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('151', '18392024473', '无敌小磊子二号', '529f7e4923b35483585f81f1b126d4b0', '0', '版主', '0', '2018-09-14 10:00:26', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('153', '18392024475', '小磊子三号', '529f7e4923b35483585f81f1b126d4b0', '0', '版主', '0', '2018-09-14 10:03:14', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('155', '18392024476', '小磊子四号', '529f7e4923b35483585f81f1b126d4b0', '0', '版主', '0', '2018-09-14 10:04:26', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('157', '18392024477', '小磊子5号', '529f7e4923b35483585f81f1b126d4b0', '0', '版主', '0', '2018-09-14 10:05:27', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('159', '18392024478', '小磊子6号', '529f7e4923b35483585f81f1b126d4b0', '0', '版主', '0', '2018-09-14 10:06:21', '2018-09-30 12:31:45');
INSERT INTO `bbs_user_info` VALUES ('215', '18965782261', 'Hosmos', 'd996f1158ee5aa47e656e63108940bae', '1', '管理员', '0', '2018-10-18 15:30:53', '2019-01-25 11:37:48');

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
-- Records of bbs_user_liveness
-- ----------------------------
INSERT INTO `bbs_user_liveness` VALUES ('1029', '18392024474', '2018-09-14', '0', '25', '0', '34', '2018-09-14 09:48:23', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1031', '13725479392', '2018-09-14', '0', '6', '0', '15', '2018-09-14 09:50:49', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1033', '15083532061', '2018-09-14', '0', '7', '0', '16', '2018-09-14 09:55:25', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1035', '18099483996', '2018-09-14', '0', '1', '0', '10', '2018-09-14 09:55:36', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1037', '12345678901', '2018-09-14', '0', '6', '0', '15', '2018-09-14 10:14:17', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1039', '12345678901', '2018-09-14', 'e91b324c96b846b0851ed6eb385b4f9f', '0', '1', '5', '2018-09-14 10:21:26', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1043', '15083532061', '2018-09-14', '528156fc21684f34a89f6e8a6073cdd1', '0', '3', '15', '2018-09-14 11:22:59', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1044', '12345678901', '2018-09-14', '32ac498429e348d5b4350e1f934d445b', '0', '3', '15', '2018-09-14 11:27:26', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1045', '18392024474', '2018-09-14', '2d77500d91094dcc9fb508319d43d958', '0', '6', '30', '2018-09-14 11:30:02', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1046', '12345678901', '2018-09-14', '603d470030954c56b93025d71ff5434a', '0', '2', '10', '2018-09-14 11:30:33', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1047', '12345678901', '2018-09-14', 'd6e010ae6fdb4a2aa543b017da4f0783', '0', '5', '25', '2018-09-14 11:39:04', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1048', '15083532061', '2018-09-14', 'e09cc606fcb24d5e94070448a11044e8', '0', '1', '5', '2018-09-14 11:42:22', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1049', '13725479392', '2018-09-14', '528156fc21684f34a89f6e8a6073cdd1', '0', '1', '5', '2018-09-14 11:47:11', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1050', '18392024474', '2018-09-14', 'bb00e3fef31340408420815dd8812eed', '0', '3', '15', '2018-09-14 11:49:17', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1051', '12345678901', '2018-09-14', 'dd4848efe1bc48008351fcd314e0bc84', '0', '3', '15', '2018-09-14 11:51:07', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1052', '15083532061', '2018-09-14', '94d78b084e5b45c1a3c8f03cdfb4e46a', '0', '1', '5', '2018-09-14 11:51:22', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1053', '13725479392', '2018-09-14', 'dd4848efe1bc48008351fcd314e0bc84', '0', '1', '5', '2018-09-14 11:55:32', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1054', '15083532061', '2018-09-14', 'a3a693592ada4979b80c4df44c39a5b2', '0', '1', '5', '2018-09-14 11:57:29', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1055', '18392024474', '2018-09-14', 'e91b324c96b846b0851ed6eb385b4f9f', '0', '3', '15', '2018-09-14 11:58:16', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1056', '15083532061', '2018-09-14', '9d601d924a2d473a8e1896b643c78409', '0', '2', '10', '2018-09-14 12:33:29', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1057', '12345678901', '2018-09-14', 'c64512b855c74f50b83befc60266b4f0', '0', '2', '10', '2018-09-14 14:04:05', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1058', '18392024474', '2018-09-14', '92ee4f2191134101a04e60f13797954a', '0', '3', '15', '2018-09-14 14:18:52', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1059', '15083532061', '2018-09-14', 'd65215a8d208461ba1615370aca640d3', '0', '1', '5', '2018-09-14 14:22:57', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1060', '18392024474', '2018-09-14', '4dcac7c9a2b74bceba141bbf355de009', '0', '3', '15', '2018-09-14 14:28:05', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1061', '15083532061', '2018-09-14', '59a4d00f894647eca39c40b788302ec3', '0', '1', '5', '2018-09-14 14:36:06', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1062', '18392024474', '2018-09-14', '824a22fcebb8485ab77d9a5f04d0d8fb', '0', '3', '15', '2018-09-14 14:38:58', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1063', '18392024474', '2018-09-14', '77a9d295f3904e25a8059d6c4f33c7aa', '0', '3', '15', '2018-09-14 17:18:06', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1064', '15602902667', '2018-09-14', '0', '2', '0', '11', '2018-09-14 19:39:58', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1065', '15602902667', '2018-09-14', 'd4d46d53dab2449f969e39381951a1a2', '0', '2', '10', '2018-09-14 19:40:53', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1066', '15602902667', '2018-09-14', '528156fc21684f34a89f6e8a6073cdd1', '0', '1', '5', '2018-09-14 20:04:57', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1067', '12345678901', '2018-09-15', '0', '5', '0', '14', '2018-09-15 13:10:03', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1068', '12345678901', '2018-09-15', 'e91b324c96b846b0851ed6eb385b4f9f', '0', '3', '15', '2018-09-15 13:55:57', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1069', '13725479392', '2018-09-15', '0', '3', '0', '12', '2018-09-15 16:47:43', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1070', '13725479392', '2018-09-15', '94d78b084e5b45c1a3c8f03cdfb4e46a', '0', '1', '5', '2018-09-15 17:12:45', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1071', '13824275661', '2018-09-15', '0', '1', '0', '10', '2018-09-15 17:22:08', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1072', '13824275661', '2018-09-15', '92ee4f2191134101a04e60f13797954a', '0', '1', '5', '2018-09-15 17:25:24', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1073', '13513961715', '2018-09-15', '0', '1', '0', '10', '2018-09-15 17:29:00', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1074', '12345678901', '2018-09-17', '0', '8', '0', '17', '2018-09-17 13:18:21', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1075', '12345678901', '2018-09-17', 'e91b324c96b846b0851ed6eb385b4f9f', '0', '2', '10', '2018-09-17 13:23:27', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1076', '12345678911', '2018-09-17', '0', '1', '0', '10', '2018-09-17 16:18:07', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1077', '18392024474', '2018-09-17', '0', '6', '0', '15', '2018-09-17 16:35:07', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1078', '18392024474', '2018-09-17', '824a22fcebb8485ab77d9a5f04d0d8fb', '0', '1', '5', '2018-09-17 17:45:15', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1079', '15602902667', '2018-09-17', '0', '3', '0', '12', '2018-09-17 17:45:44', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1080', '13725479392', '2018-09-18', '0', '1', '0', '10', '2018-09-18 14:45:44', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1081', '17679107218', '2018-09-18', '0', '1', '0', '10', '2018-09-18 15:47:22', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1082', '12345678901', '2018-09-19', '0', '1', '0', '10', '2018-09-19 16:56:00', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1083', '15083532061', '2018-09-20', '0', '14', '0', '23', '2018-09-20 08:27:49', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1084', '15083532061', '2018-09-20', 'd4d46d53dab2449f969e39381951a1a2', '0', '1', '5', '2018-09-20 08:35:12', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1085', '12345678901', '2018-09-20', '0', '8', '0', '17', '2018-09-20 08:56:08', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1086', '13725479392', '2018-09-20', '0', '5', '0', '14', '2018-09-20 09:01:59', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1087', '13725479392', '2018-09-20', '77a9d295f3904e25a8059d6c4f33c7aa', '0', '3', '15', '2018-09-20 09:07:03', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1088', '12345678918', '2018-09-20', '0', '3', '0', '12', '2018-09-20 10:13:52', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1089', '15938029687', '2018-09-20', '0', '1', '0', '10', '2018-09-20 10:17:35', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1090', '15938029687', '2018-09-20', '59a4d00f894647eca39c40b788302ec3', '0', '1', '5', '2018-09-20 10:20:20', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1091', '18392024474', '2018-09-20', '0', '4', '0', '13', '2018-09-20 10:23:41', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1092', '15083532061', '2018-09-21', '0', '1', '0', '10', '2018-09-21 08:29:25', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1093', '15083532061', '2018-09-25', '0', '5', '0', '14', '2018-09-25 09:21:55', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1094', '12345678918', '2018-09-25', '0', '1', '0', '10', '2018-09-25 09:23:20', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1095', '12345678918', '2018-09-25', '59a4d00f894647eca39c40b788302ec3', '0', '1', '5', '2018-09-25 09:24:05', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1096', '13725479392', '2018-09-25', '0', '1', '0', '10', '2018-09-25 09:25:53', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1097', '13725479392', '2018-09-26', '0', '1', '0', '10', '2018-09-26 10:23:52', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1098', '15083532061', '2018-09-26', '0', '1', '0', '10', '2018-09-26 14:12:04', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1099', '12345678901', '2018-09-26', '0', '16', '0', '25', '2018-09-26 15:09:17', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1100', '12345678901', '2018-09-27', '0', '2', '0', '11', '2018-09-27 11:53:07', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1101', '13725479392', '2018-09-28', '0', '1', '0', '10', '2018-09-28 16:51:53', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1102', '15083532061', '2018-09-29', '0', '4', '0', '13', '2018-09-29 08:34:34', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1103', '15083532061', '2018-09-29', 'a3a693592ada4979b80c4df44c39a5b2', '0', '1', '5', '2018-09-29 09:16:54', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1104', '13725479392', '2018-09-29', '0', '1', '0', '10', '2018-09-29 09:22:11', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1105', '13725479392', '2018-09-29', '603d470030954c56b93025d71ff5434a', '0', '2', '10', '2018-09-29 09:41:44', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1106', '18392024474', '2018-09-29', '0', '3', '0', '12', '2018-09-29 09:56:26', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1107', '18392024474', '2018-09-29', '32ac498429e348d5b4350e1f934d445b', '0', '3', '15', '2018-09-29 10:09:46', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1108', '13725479392', '2018-09-29', '7ada6da1b0b04a89ae071d5e274e165f', '0', '1', '5', '2018-09-29 10:25:28', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1109', '12345678912', '2018-09-29', '0', '1', '0', '10', '2018-09-29 10:28:15', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1110', '18682358962', '2018-09-29', '0', '1', '0', '10', '2018-09-29 10:28:16', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1111', '13824275661', '2018-09-29', '0', '6', '0', '15', '2018-09-29 10:29:05', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1112', '12345678901', '2018-09-29', '0', '3', '0', '12', '2018-09-29 10:47:49', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1113', '12345678901', '2018-09-29', '4dcac7c9a2b74bceba141bbf355de009', '0', '1', '5', '2018-09-29 10:48:28', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1114', '13725479392', '2018-09-29', '77a9d295f3904e25a8059d6c4f33c7aa', '0', '1', '5', '2018-09-29 11:05:13', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1115', '18099483996', '2018-09-29', '0', '2', '0', '11', '2018-09-29 11:22:10', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1116', '18392024474', '2018-09-29', 'e91b324c96b846b0851ed6eb385b4f9f', '0', '1', '5', '2018-09-29 14:25:23', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1117', '13725479392', '2018-09-30', '0', '1', '0', '10', '2018-09-30 09:42:55', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1118', '18392024474', '2018-09-30', '0', '1', '0', '10', '2018-09-30 09:52:46', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1119', '12345678901', '2018-09-30', '0', '1', '0', '10', '2018-09-30 09:53:32', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1120', '13725479392', '2018-09-30', '77a9d295f3904e25a8059d6c4f33c7aa', '0', '1', '5', '2018-09-30 09:59:16', 'sitong', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1121', '15083532061', '2018-09-30', '0', '2', '0', '11', '2018-09-30 10:13:43', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1122', '12345678901', '2018-10-01', '0', '1', '0', '10', '2018-10-01 23:27:33', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1123', '12345678901', '2018-10-03', '0', '1', '0', '10', '2018-10-03 18:10:49', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1124', '18392024474', '2018-10-08', '0', '1', '0', '10', '2018-10-08 10:26:47', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1125', '15083532061', '2018-10-08', '0', '3', '0', '12', '2018-10-08 11:08:58', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1126', '12345678901', '2018-10-08', '0', '1', '0', '10', '2018-10-08 11:12:14', 'admin', null, '');
INSERT INTO `bbs_user_liveness` VALUES ('1127', '12345678901', '2018-10-10', '0', '7', '0', '16', '2018-10-10 09:39:03', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1129', '12345678901', '2018-10-10', 'bb00e3fef31340408420815dd8812eed', '0', '1', '5', '2018-10-10 09:59:43', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1131', '12345678901', '2018-10-10', '9231686dc5504ac2a160300fe8c367d8', '0', '1', '5', '2018-10-10 10:00:12', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1133', '15083532061', '2018-10-15', '0', '1', '0', '10', '2018-10-15 09:55:53', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1135', '12345678901', '2018-10-15', '0', '3', '0', '12', '2018-10-15 15:59:51', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1137', '12345678901', '2018-10-16', '0', '3', '0', '12', '2018-10-16 09:46:00', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1139', '12345678901', '2018-10-16', '9d601d924a2d473a8e1896b643c78409', '0', '1', '5', '2018-10-16 09:46:42', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1141', '12345678901', '2018-10-16', 'd65215a8d208461ba1615370aca640d3', '0', '1', '5', '2018-10-16 09:46:58', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1143', '12345678901', '2018-10-16', '528156fc21684f34a89f6e8a6073cdd1', '0', '1', '5', '2018-10-16 09:57:25', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1145', '12345678901', '2018-10-16', 'bb00e3fef31340408420815dd8812eed', '0', '1', '5', '2018-10-16 09:57:44', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1147', '12345678901', '2018-10-16', 'd4d46d53dab2449f969e39381951a1a2', '0', '1', '5', '2018-10-16 09:58:00', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1149', '12345678901', '2018-10-16', '824a22fcebb8485ab77d9a5f04d0d8fb', '0', '1', '5', '2018-10-16 09:58:18', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1151', '12345678901', '2018-10-16', '2d77500d91094dcc9fb508319d43d958', '0', '1', '5', '2018-10-16 09:58:54', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1153', '12345678901', '2018-10-18', '0', '1', '0', '10', '2018-10-18 12:21:33', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1155', '12345678901', '2018-10-18', '0', '1', '0', '10', '2018-10-18 12:21:33', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1157', '15083532061', '2018-10-18', '0', '2', '0', '11', '2018-10-18 15:18:03', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1159', '18392024474', '2018-10-18', '0', '1', '0', '10', '2018-10-18 15:28:00', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1161', '18965782261', '2018-10-18', '0', '11', '0', '20', '2018-10-18 15:31:14', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1163', '18392024472', '2018-10-18', '0', '2', '0', '11', '2018-10-18 15:34:18', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1165', '18965782261', '2018-10-19', '0', '4', '0', '13', '2018-10-19 09:50:00', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1167', '18965782261', '2018-10-20', '0', '3', '0', '12', '2018-10-20 11:31:22', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1169', '18965782261', '2018-10-21', '0', '2', '0', '11', '2018-10-21 12:45:27', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1171', '18965782261', '2018-10-22', '0', '15', '0', '24', '2018-10-22 09:16:46', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1173', '18965782261', '2018-10-22', 'c64512b855c74f50b83befc60266b4f0', '0', '1', '5', '2018-10-22 14:33:56', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1175', '18965782261', '2018-10-22', '516ee22946fc45c49493d510e2369f40', '0', '1', '5', '2018-10-22 14:34:04', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1177', '18965782261', '2018-10-22', 'e91b324c96b846b0851ed6eb385b4f9f', '0', '1', '5', '2018-10-22 14:34:10', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1179', '18965782261', '2018-10-22', 'dd4848efe1bc48008351fcd314e0bc84', '0', '1', '5', '2018-10-22 14:34:17', 'sitong', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1181', '18965782261', '2018-10-23', '0', '2', '0', '11', '2018-10-23 10:38:26', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1183', '18965782261', '2018-11-01', '0', '1', '0', '10', '2018-11-01 17:22:08', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1185', '15083532061', '2018-11-01', '0', '3', '0', '12', '2018-11-01 17:26:27', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1187', '18965782261', '2018-11-02', '0', '1', '0', '10', '2018-11-02 09:33:55', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1189', '18965782261', '2018-11-15', '0', '2', '0', '11', '2018-11-15 16:29:26', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1191', '18965782261', '2019-01-23', '0', '2', '0', '11', '2019-01-23 16:46:56', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1192', '18965782261', '2019-01-24', '0', '13', '0', '22', '2019-01-24 09:14:30', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1193', '18965782261', '2019-01-25', '0', '19', '0', '28', '2019-01-25 09:43:46', 'admin', null, null);
INSERT INTO `bbs_user_liveness` VALUES ('1194', '18965782261', '2019-01-28', '0', '8', '0', '17', '2019-01-28 08:30:52', 'admin', null, null);

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
-- Records of bbs_user_permission
-- ----------------------------

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
-- Records of bbs_user_private_message
-- ----------------------------

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
-- Records of bbs_user_status
-- ----------------------------
INSERT INTO `bbs_user_status` VALUES ('1', '01', '注销', '', '2018-09-14 08:47:54', null, null);
INSERT INTO `bbs_user_status` VALUES ('2', '02', '未注销', '', '2018-09-14 08:47:57', null, null);

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
-- Records of spring_boot_test_cat
-- ----------------------------
INSERT INTO `spring_boot_test_cat` VALUES ('1', 'tom', '2');

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
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', '18');
INSERT INTO `tbl_user` VALUES ('3', 'e0208', '18');
INSERT INTO `tbl_user` VALUES ('5', '5f0ea', '18');
INSERT INTO `tbl_user` VALUES ('7', '5ffb7', '18');
INSERT INTO `tbl_user` VALUES ('9', '1c8ef', '18');
INSERT INTO `tbl_user` VALUES ('11', '6963c', '18');
INSERT INTO `tbl_user` VALUES ('15', '058d6', '18');

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
-- Records of test
-- ----------------------------

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

-- ----------------------------
-- Records of test_user_photo
-- ----------------------------
INSERT INTO `test_user_photo` VALUES ('1', '15083532061', 'bf096b63f6246b60e80de547e9f81a4c510fa286.jpg');
