/*
 Navicat Premium Data Transfer

 Source Server         : SIT
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 101.132.105.140:3306
 Source Schema         : mxc_uat

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 20/01/2021 10:13:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createTime` datetime(0) NOT NULL,
  `roleName` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `creatorId` bigint(20) NULL DEFAULT NULL,
  `status` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `isOrg` int(11) NULL DEFAULT 0 COMMENT '是否是机构端、默认0耕子端，1是机构端',
  `updateTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '2018-02-26 20:22:13', '超级管理员', '超级管理员拥有所有权限', 1, 'NORMAL', 0, '2021-01-13 15:45:16');
INSERT INTO `role` VALUES (2, '2018-02-26 20:28:06', '课程运营', '师资管理相关权限', 1, 'NORMAL', 0, '2021-01-12 14:27:41');
INSERT INTO `role` VALUES (3, '2018-02-27 09:10:54', '课程老师', '直播授课老师', 1, 'NORMAL', 0, '2021-01-14 12:22:11');
INSERT INTO `role` VALUES (4, '2018-03-02 10:15:13', '运营人员', '提供运营需要访问的权限', 1, 'NORMAL', 0, '2020-08-26 00:02:36');
INSERT INTO `role` VALUES (5, '2018-03-23 15:32:28', '客服人员', '400,微信公众号等渠道有疑问的用户，进行初版解答', 1, 'NORMAL', 0, '2020-12-23 15:16:09');
INSERT INTO `role` VALUES (6, '2018-04-03 09:35:37', '课程顾问管理员', '课程顾问管理员', 17, 'NORMAL', 0, '2020-12-07 15:39:14');
INSERT INTO `role` VALUES (7, '2018-04-03 09:36:15', '课程顾问组长', '课程顾问组长', 17, 'NORMAL', 0, '2020-12-18 18:14:33');
INSERT INTO `role` VALUES (8, '2018-04-03 09:36:51', '课程顾问组员', '课程顾问组员', 17, 'NORMAL', 0, '2020-12-07 15:38:26');
INSERT INTO `role` VALUES (9, '2018-04-10 09:29:49', '流量型课程运营', '流量型课程运营', 1, 'NORMAL', 0, '2020-11-24 20:15:44');
INSERT INTO `role` VALUES (10, '2018-05-05 11:31:43', '运维人员', '', 1, 'NORMAL', 0, '2020-12-07 15:38:13');
INSERT INTO `role` VALUES (11, '2018-05-20 14:16:48', '作品管理', '修改作品热度、推荐等', 1, 'NORMAL', 0, '2019-09-03 15:56:10');
INSERT INTO `role` VALUES (12, '2018-06-12 21:23:38', 'B端销售组员', 'B端销售组员', 1, 'NORMAL', 0, '2019-07-11 17:04:51');
INSERT INTO `role` VALUES (13, '2018-06-12 21:24:09', 'B端销售组长', 'B端销售组长', 1, 'NORMAL', 0, '2019-07-11 17:05:00');
INSERT INTO `role` VALUES (14, '2018-06-12 21:24:45', 'B端销售管理员', 'B端销售管理员', 1, 'NORMAL', 0, '2020-09-03 14:32:51');
INSERT INTO `role` VALUES (15, '2018-06-20 14:46:27', '合作渠道', '给合作渠道开通相应的渠道Leads查看权限', 1, 'NORMAL', 0, '2020-09-30 15:50:33');
INSERT INTO `role` VALUES (16, '2018-06-27 15:47:05', '市场部组员', '导入市场部leads', 1, 'NORMAL', 0, '2020-09-03 14:34:38');
INSERT INTO `role` VALUES (17, '2018-06-27 19:26:03', '市场部管理员', '拥有市场部所有权限', 1, 'NORMAL', 0, '2020-10-25 16:19:13');
INSERT INTO `role` VALUES (18, '2018-07-20 12:44:56', '商城订单查看', '商城订单查看权限', 101, 'NORMAL', 0, '2019-09-10 10:07:39');
INSERT INTO `role` VALUES (19, '2018-07-25 14:48:11', '商城商品类', '商城商品类所有权限', 101, 'NORMAL', 0, '2019-10-28 10:25:21');
INSERT INTO `role` VALUES (20, '2018-08-20 09:47:12', '新闻管理', '管理新闻类CRM角色', 101, 'NORMAL', 0, '2019-05-28 17:53:47');
INSERT INTO `role` VALUES (21, '2018-08-20 14:08:16', 's市场部leads', '查看市场部leads权限角色', 101, 'NORMAL', 0, '2019-04-11 16:48:39');
INSERT INTO `role` VALUES (22, '2018-08-23 16:42:58', '人事行政', '人事行政', 23, 'NORMAL', 0, '2019-07-19 16:49:20');
INSERT INTO `role` VALUES (23, '2018-08-28 18:30:17', '财务', '财务相关', 23, 'NORMAL', 0, '2020-08-11 16:53:48');
INSERT INTO `role` VALUES (24, '2018-09-03 10:19:00', '市场部TMK', '查看L0leads', 1, 'NORMAL', 0, '2019-08-13 09:22:47');
INSERT INTO `role` VALUES (25, '2018-09-27 17:49:58', '奖励权限', 'crm内奖励的权限', 101, 'NORMAL', 0, '2019-03-05 14:50:59');
INSERT INTO `role` VALUES (26, '2018-10-09 15:21:45', '渠道权限', '渠道来源以及渠道编码', 101, 'NORMAL', 0, '2019-08-19 19:28:36');
INSERT INTO `role` VALUES (27, '2018-11-13 14:17:20', 'VP', '销售部VP', 101, 'NORMAL', 0, '2019-06-25 22:00:28');
INSERT INTO `role` VALUES (28, '2018-12-04 15:02:29', '市场部运营BD', NULL, 101, 'NORMAL', 0, '2019-01-18 15:45:29');
INSERT INTO `role` VALUES (29, '2018-12-08 10:25:00', 'CC大区助理', '修改cc信息', 1, 'NORMAL', 0, '2019-06-25 21:40:20');
INSERT INTO `role` VALUES (30, '2018-12-13 18:05:29', '录播课总监', NULL, 101, 'NORMAL', 0, '2019-07-29 09:59:59');
INSERT INTO `role` VALUES (31, '2018-12-18 20:23:28', '课程顾问区长', '课程顾问区长', 801, 'NORMAL', 0, '2020-12-07 15:39:01');
INSERT INTO `role` VALUES (32, '2018-12-18 20:24:03', '课程顾问大组长', '课程顾问大组长', 801, 'NORMAL', 0, '2020-12-07 15:38:49');
INSERT INTO `role` VALUES (33, '2018-12-25 16:39:13', '测试组', '测试人员', 498, 'NORMAL', 0, '2018-12-29 17:10:00');
INSERT INTO `role` VALUES (34, '2019-01-10 18:52:10', '班主任组长', NULL, 498, 'NORMAL', 0, '2020-12-07 15:39:26');
INSERT INTO `role` VALUES (35, '2019-01-10 18:54:28', '班主任', '班主任', 498, 'NORMAL', 0, '2020-12-07 15:40:03');
INSERT INTO `role` VALUES (36, '2019-01-16 14:44:01', '质检专员', '检查CC跟进备注录音', 498, 'NORMAL', 0, '2019-08-27 16:38:12');
INSERT INTO `role` VALUES (37, '2019-02-13 10:34:58', '课程教研', '教研部门权限', 101, 'NORMAL', 0, '2019-08-05 13:31:12');
INSERT INTO `role` VALUES (38, '2019-02-13 10:56:19', '课程教务', '教务权限相关', 101, 'NORMAL', 0, '2020-09-23 16:34:09');
INSERT INTO `role` VALUES (39, '2019-03-01 16:05:45', '课程顾问管理员-财务', NULL, 148, 'NORMAL', 0, '2020-07-23 10:34:13');
INSERT INTO `role` VALUES (40, '2019-03-05 15:36:29', '课消统计业务逻辑测试', '测试专用，禁止随意改动', 148, 'NORMAL', 0, '2019-03-05 15:46:37');
INSERT INTO `role` VALUES (41, '2019-03-07 15:26:56', '录播课市场投放', '处理录播课市场投放等相关事宜', 640, 'NORMAL', 0, '2019-05-31 11:33:18');
INSERT INTO `role` VALUES (42, '2019-03-08 18:46:45', '卡密维护管理员', NULL, 498, 'NORMAL', 0, '2019-03-15 14:41:21');
INSERT INTO `role` VALUES (43, '2019-04-01 14:50:59', 'L0 Leads管理', '管理录播课的Leads', 459, 'NORMAL', 0, '2019-05-31 11:34:19');
INSERT INTO `role` VALUES (44, '2019-04-25 02:36:15', '班主任区长', NULL, 498, 'NORMAL', 0, '2020-12-07 15:39:42');
INSERT INTO `role` VALUES (45, '2019-04-25 14:39:46', '班主任管理员', NULL, 498, 'NORMAL', 0, '2020-12-07 15:39:53');
INSERT INTO `role` VALUES (46, '2019-04-26 13:45:45', 'B端市场', NULL, 101, 'NORMAL', 0, '2019-07-11 17:05:08');
INSERT INTO `role` VALUES (47, '2019-05-16 23:24:54', '机构管理员', '机构管理员', 1, 'NORMAL', 1, '2019-07-26 15:55:11');
INSERT INTO `role` VALUES (48, '2019-05-16 23:24:54', '机构监管', '机构监管', 1, 'NORMAL', 1, '2020-10-10 18:24:09');
INSERT INTO `role` VALUES (49, '2019-05-16 23:24:54', '机构老师', '机构老师', 1, 'NORMAL', 1, '2019-08-23 18:50:59');
INSERT INTO `role` VALUES (59, '2019-05-21 11:35:27', '网安管理', NULL, 101, 'NORMAL', 0, '2019-05-22 22:50:43');
INSERT INTO `role` VALUES (60, '2019-06-12 17:38:07', '赠品审核员', '赠品审核角色', 640, 'NORMAL', 0, '2020-03-21 21:11:52');
INSERT INTO `role` VALUES (61, '2019-06-17 15:53:03', '数据库质检专员', '数据库质检专员', 101, 'NORMAL', 0, '2020-02-19 16:38:43');
INSERT INTO `role` VALUES (62, '2019-06-17 16:46:32', '数据支持负责人', NULL, 101, 'NORMAL', 0, '2019-06-17 17:18:20');
INSERT INTO `role` VALUES (63, '2019-06-26 13:22:42', '试听课活动功能--测试专用', NULL, 101, 'NORMAL', 0, '2019-06-26 13:22:42');
INSERT INTO `role` VALUES (64, '2019-08-06 11:41:03', '市场实习--积分充值', NULL, 101, 'NORMAL', 0, '2019-09-11 10:19:51');
INSERT INTO `role` VALUES (65, '2019-08-21 13:37:57', '课程老师--组长--订单查询', NULL, 101, 'NORMAL', 0, '2021-01-12 14:30:37');
INSERT INTO `role` VALUES (66, '2019-09-04 17:35:51', '机构管理中心', '机构管理中心', 1, 'NORMAL', 1, '2019-09-09 11:44:19');
INSERT INTO `role` VALUES (67, '2019-09-09 11:25:32', '城市经理', NULL, 101, 'NORMAL', 0, '2019-09-09 11:25:32');
INSERT INTO `role` VALUES (68, '2019-09-17 10:23:29', '订单管理--导出权限', '订单管理--导出权限', 101, 'NORMAL', 0, '2019-09-19 10:38:13');
INSERT INTO `role` VALUES (69, '2019-09-18 13:44:43', '课程信息--教室查看', NULL, 101, 'NORMAL', 0, '2019-09-18 13:44:43');
INSERT INTO `role` VALUES (70, '2019-10-10 21:35:00', '活动课管理', '活动课管理', 1, 'NORMAL', 0, '2019-10-10 21:35:00');
INSERT INTO `role` VALUES (71, '2019-10-13 12:01:11', 'CC数据检查员', '检查组员撞单&重复注册等数据信息', 1, 'NORMAL', 0, '2019-10-13 12:03:48');
INSERT INTO `role` VALUES (72, '2020-02-07 00:03:26', '用户运营经理', NULL, 1, 'NORMAL', 0, '2020-12-23 15:14:33');
INSERT INTO `role` VALUES (73, '2020-02-25 21:39:12', '兼职课程老师', NULL, 1, 'NORMAL', 0, '2020-02-25 21:39:12');
INSERT INTO `role` VALUES (74, '2020-04-03 21:35:05', '师资管理（临时）', '临时用于查看CC的关单和跟进情况', 1, 'NORMAL', 0, '2020-04-03 21:37:00');
INSERT INTO `role` VALUES (75, '2020-04-11 00:02:20', '课程组长', NULL, 1, 'NORMAL', 0, '2020-04-11 00:02:20');
INSERT INTO `role` VALUES (76, '2020-08-17 18:13:15', '老班主任', NULL, 1, 'NORMAL', 0, '2020-12-18 11:52:47');
INSERT INTO `role` VALUES (77, '2020-08-18 12:02:34', '产品技术', 'cc生成', 3098, 'NORMAL', 0, '2020-12-07 15:38:01');
INSERT INTO `role` VALUES (80, '2020-12-18 14:22:49', '测试', NULL, NULL, 'DELETE', 0, '2020-12-18 14:24:04');

SET FOREIGN_KEY_CHECKS = 1;
