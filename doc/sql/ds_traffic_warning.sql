/*
Navicat MySQL Data Transfer

Source Server         : daison-197
Source Server Version : 50734
Source Host           : daison:3306
Source Database       : daison_cloud

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2021-09-01 15:10:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ds_traffic_warning
-- ----------------------------
DROP TABLE IF EXISTS `ds_traffic_warning`;
CREATE TABLE `ds_traffic_warning` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `road_code_id` bigint(20) DEFAULT NULL COMMENT '道路id',
  `road_section_id` bigint(20) DEFAULT NULL COMMENT '道路分段id',
  `device_type` tinyint(10) DEFAULT '1' COMMENT '设备类型(1-信标；2-雷达；3-相机；99-其他)',
  `level` tinyint(10) DEFAULT NULL COMMENT '拥堵等级(1-严重；2-轻微；3-畅通)',
  `event_type` int(11) DEFAULT NULL COMMENT '事件类型(0-未知 1-事故 2-逆行或倒车 3-超速 4-拥堵 5-缓行 6-停车 7-变道 8-跟车太近)',
  `vehicle_Ids` varchar(3000) DEFAULT NULL COMMENT '产生事件车辆id',
  `deveui` varchar(255) DEFAULT NULL COMMENT '产生事件开始计算设备deveui',
  `event_num` int(11) DEFAULT NULL COMMENT '拥堵事件数据量',
  `dev_list` varchar(5000) DEFAULT NULL COMMENT '闪灯设备devEUI,多个以逗号分隔',
  `light_range` int(11) DEFAULT NULL COMMENT '拥堵闪灯范围',
  `status` tinyint(255) DEFAULT NULL COMMENT '拥堵状态(1-拥堵；2-不拥堵)',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(255) DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_traffic_warning
-- ----------------------------
