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

SET FOREIGN_KEY_CHECKS = 1;