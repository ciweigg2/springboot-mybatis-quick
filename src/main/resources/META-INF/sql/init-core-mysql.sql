SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business_license
-- ----------------------------
DROP TABLE IF EXISTS `business_license`;
CREATE TABLE `business_license` (
                                    `bl_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '系统授权码',
                                    `ent_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
                                    `un_is_cid` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '统一社会信用代码',
                                    `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '法定代表人',
                                    `oper` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '经办人',
                                    `auth_term` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '授权书截止日期',
                                    `image_url` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电子营业执照授权书下载地址',
                                    PRIMARY KEY (`bl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='电子营业执照表';

-- ----------------------------
-- Records of business_license
-- ----------------------------
BEGIN;
INSERT INTO `business_license` VALUES ('10001', '测试', 'BJ', NULL, NULL, '嘿嘿嘿嘻嘻啦', NULL);
INSERT INTO `business_license` VALUES ('10002', '测试', 'BJ', NULL, NULL, '嘿嘿嘿嘻嘻啦', NULL);
INSERT INTO `business_license` VALUES ('10003', '测试', 'SH', NULL, NULL, '嘿嘿嘿嘻嘻啦', NULL);
INSERT INTO `business_license` VALUES ('10004', '测试', 'SH', NULL, NULL, '嘿嘿嘿嘻嘻啦', NULL);
INSERT INTO `business_license` VALUES ('10005', '测试', 'SH', NULL, NULL, '嘿嘿嘿嘻嘻啦', NULL);
COMMIT;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
                              `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
                              `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '上级部门ID',
                              `org_id` bigint(20) NOT NULL COMMENT '单位ID',
                              `name` varchar(50) NOT NULL COMMENT '名称',
                              `extdata` varchar(100) DEFAULT NULL COMMENT '扩展字段',
                              `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '已删除',
                              `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='组织单位';

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (10001, 0, 100001, '产品部', NULL, 0, '2019-12-20 14:32:05');
INSERT INTO `department` VALUES (10002, 10001, 100001, '研发组', NULL, 0, '2019-12-20 14:32:05');
INSERT INTO `department` VALUES (10003, 10001, 100001, '测试组', NULL, 0, '2019-12-20 14:32:05');
COMMIT;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
                              `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
                              `parent_id` int(10) unsigned NOT NULL COMMENT '父ID',
                              `type` varchar(50) NOT NULL COMMENT '字典类型',
                              `item_name` varchar(100) NOT NULL COMMENT '显示名',
                              `item_value` varchar(100) DEFAULT NULL COMMENT '存储值',
                              `description` varchar(100) DEFAULT NULL COMMENT '描述说明',
                              `extdata` varchar(200) DEFAULT NULL COMMENT '扩展JSON',
                              `sort_id` smallint(6) NOT NULL DEFAULT '99' COMMENT '排序号',
                              `is_editable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可改',
                              `is_deletable` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否可删',
                              `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记',
                              `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              PRIMARY KEY (`id`),
                              KEY `idx_directory` (`type`,`item_value`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of dictionary
-- ----------------------------
BEGIN;
INSERT INTO `dictionary` VALUES (1, 0, 'GENDER', '性别', NULL, '', NULL, 99, 1, 0, 0, '2019-12-20 14:33:44');
INSERT INTO `dictionary` VALUES (2, 1, 'GENDER', '男', 'M', NULL, NULL, 99, 1, 0, 0, '2019-12-20 14:33:44');
INSERT INTO `dictionary` VALUES (3, 1, 'GENDER', '女', 'F', NULL, NULL, 99, 1, 0, 0, '2019-12-20 14:33:44');
INSERT INTO `dictionary` VALUES (13, 0, 'CODE', '统一社会信用代码', NULL, '', NULL, 99, 1, 0, 0, '2019-12-19 09:33:45');
INSERT INTO `dictionary` VALUES (14, 13, 'CODE', '北京', 'BJ', NULL, NULL, 99, 1, 0, 0, '2019-12-19 09:33:45');
INSERT INTO `dictionary` VALUES (15, 13, 'CODE', '上海', 'SH', NULL, NULL, 99, 1, 0, 0, '2019-12-19 09:33:45');
COMMIT;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
                                `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '上级单位ID',
                                `name` varchar(100) NOT NULL COMMENT '名称',
                                `telphone` varchar(20) DEFAULT NULL COMMENT '电话',
                                `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否有效',
                                `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100002 DEFAULT CHARSET=utf8mb4 COMMENT='组织单位';

-- ----------------------------
-- Records of organization
-- ----------------------------
BEGIN;
INSERT INTO `organization` VALUES (100001, 0, '苏州帝博', '0512-62988949', 0, '2019-12-20 14:33:44');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                        `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `code` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `is_deleted` tinyint(4) DEFAULT '0',
                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (101, '管理员', 'ADMIN', 0, '2019-12-20 14:33:44');
INSERT INTO `role` VALUES (102, '操作员', 'OPERATOR', 0, '2019-12-20 14:33:44');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                        `department_id` int(11) NOT NULL DEFAULT '0',
                        `username` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `gender` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `is_deleted` tinyint(4) DEFAULT '0',
                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1001, 10002, '张三', 'M', 0, '2019-12-20 14:33:44');
INSERT INTO `user` VALUES (1002, 10002, '李四', 'F', 0, '2019-12-20 14:33:44');
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
                             `user_id` int(11) NOT NULL COMMENT '用户ID',
                             `role_id` int(11) NOT NULL COMMENT '角色ID',
                             PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES (1001, 101);
INSERT INTO `user_role` VALUES (1001, 102);
INSERT INTO `user_role` VALUES (1002, 102);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
