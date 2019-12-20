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
INSERT INTO `business_license` VALUES ('1', '撒大声地所的多多', 'M', NULL, NULL, '嘿嘿嘿嘻嘻啦', NULL);
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
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='组织单位';

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (1, 0, 1, '好的呀', NULL, 0, '2019-12-19 09:51:27');
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
  `is_editable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可改',
  `is_deletable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可删',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_directory` (`type`,`item_value`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of dictionary
-- ----------------------------
BEGIN;
INSERT INTO `dictionary` VALUES (1, 0, 'GENDER', '性别', NULL, '', NULL, 99, 1, 0, 0, '2019-12-19 09:33:45');
INSERT INTO `dictionary` VALUES (2, 1, 'GENDER', '男', 'M', NULL, NULL, 99, 1, 0, 0, '2019-12-19 09:33:45');
INSERT INTO `dictionary` VALUES (3, 1, 'GENDER', '女', 'F', NULL, NULL, 99, 1, 0, 0, '2019-12-19 09:33:45');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
