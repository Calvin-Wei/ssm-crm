/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-13 19:02:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL COMMENT '客户id',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `position` varchar(20) DEFAULT NULL COMMENT '职务',
  `tel` varchar(20) DEFAULT NULL COMMENT '固话',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `qq` varchar(20) DEFAULT NULL,
  `weixin` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('1', '1', '张三', '经理', '110110110110', '11111111111', '905891467', '9058weixin', 'walk_hai@163.com');
INSERT INTO `contact` VALUES ('2', '1', '李四', '主任', '2232323', '454345324534', '909090909', 'sssweinxin', 'lisi@163.com');
INSERT INTO `contact` VALUES ('3', '2', '刘德华', '总经理', '121321', '78787878', '888888', 'aksdfsadf', 'sdfsdf@163.com');
INSERT INTO `contact` VALUES ('4', '2', '李胜基', '助理', '1132413', '123423423', '222222', 'asdweixin', 'asdfsdf@163.com');
INSERT INTO `contact` VALUES ('5', '2', '戴安琪', '秘书', '132132', '787878', '8787878', 'ssssweinxi', 'asdfadf@163.com');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '名称',
  `address` varchar(200) NOT NULL COMMENT '地址',
  `zipcode` varchar(20) DEFAULT NULL COMMENT '邮编',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '单位1', '地址1', '1000000', '12345678');
INSERT INTO `customer` VALUES ('2', '单位2', '地址2', '1000001', '22222222');
INSERT INTO `customer` VALUES ('3', '单位3', '地址3', '1000002', '33333333');
INSERT INTO `customer` VALUES ('4', '单位4', '地址4', '1000003', '44444444');
INSERT INTO `customer` VALUES ('5', '单位55555', '地址5', '1000004', '55555555');
INSERT INTO `customer` VALUES ('6', '啊啊啊啊', '八佰伴八佰伴', '1313', '2352435345');
INSERT INTO `customer` VALUES ('7', '保存处处长2', '啊都是法师打发斯蒂芬2', '1111000', '222222000');
INSERT INTO `customer` VALUES ('8', '1', '2', '33', '3');
INSERT INTO `customer` VALUES ('9', '呀呀呀呀呀呀', '谁谁谁', '1212', '1312');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `menu_id` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='权限关联表';

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '2');
INSERT INTO `role_menu` VALUES ('2', '1', '3');
INSERT INTO `role_menu` VALUES ('3', '1', '201');
INSERT INTO `role_menu` VALUES ('4', '1', '202');
INSERT INTO `role_menu` VALUES ('5', '1', '301');
INSERT INTO `role_menu` VALUES ('6', '2', '2');
INSERT INTO `role_menu` VALUES ('7', '2', '201');
INSERT INTO `role_menu` VALUES ('8', '2', '202');
INSERT INTO `role_menu` VALUES ('9', '1', '101');
INSERT INTO `role_menu` VALUES ('10', '2', '101');
INSERT INTO `role_menu` VALUES ('11', '1', '1');
INSERT INTO `role_menu` VALUES ('12', '2', '1');
INSERT INTO `role_menu` VALUES ('13', '1', '4');
INSERT INTO `role_menu` VALUES ('14', '1', '5');
INSERT INTO `role_menu` VALUES ('15', '1', '401');
INSERT INTO `role_menu` VALUES ('16', '1', '402');
INSERT INTO `role_menu` VALUES ('17', '1', '403');
INSERT INTO `role_menu` VALUES ('18', '1', '501');
INSERT INTO `role_menu` VALUES ('19', '1', '6');
INSERT INTO `role_menu` VALUES ('20', '1', '7');
INSERT INTO `role_menu` VALUES ('21', '1', '8');
INSERT INTO `role_menu` VALUES ('22', '1', '9');
INSERT INTO `role_menu` VALUES ('23', '1', '601');
INSERT INTO `role_menu` VALUES ('24', '1', '701');
INSERT INTO `role_menu` VALUES ('25', '1', '801');
INSERT INTO `role_menu` VALUES ('26', '1', '901');
INSERT INTO `role_menu` VALUES ('27', '1', '302');
INSERT INTO `role_menu` VALUES ('28', '1', '102');
INSERT INTO `role_menu` VALUES ('29', '1', '404');

-- ----------------------------
-- Table structure for sysmenu
-- ----------------------------
DROP TABLE IF EXISTS `sysmenu`;
CREATE TABLE `sysmenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `parentid` int(11) NOT NULL DEFAULT '0' COMMENT '父级菜单ID 0表示根节点',
  `sequence` int(6) NOT NULL DEFAULT '0' COMMENT '菜单顺序',
  `iconCls` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单图标样式',
  `url` varchar(255) NOT NULL DEFAULT '' COMMENT '菜单链接地址 总是以‘/’开头，相对于项目根路径',
  `enable` int(1) NOT NULL DEFAULT '1' COMMENT '是否可用 1:正常，0：禁用',
  PRIMARY KEY (`id`),
  KEY `parentId` (`parentid`),
  KEY `sequence` (`sequence`)
) ENGINE=InnoDB AUTO_INCREMENT=902 DEFAULT CHARSET=utf8 COMMENT='后台菜单表';

-- ----------------------------
-- Records of sysmenu
-- ----------------------------
INSERT INTO `sysmenu` VALUES ('1', '菜单管理', '0', '1', 'icon-bottom', '', '1');
INSERT INTO `sysmenu` VALUES ('2', '客户管理', '0', '2', 'icon-bottom', '', '1');
INSERT INTO `sysmenu` VALUES ('3', '用户管理', '0', '3', 'icon-bottom', '', '1');
INSERT INTO `sysmenu` VALUES ('4', '系统设置', '0', '4', 'icon-bottom', '', '1');
INSERT INTO `sysmenu` VALUES ('5', '报表统计', '0', '5', 'icon-bottom', '', '1');
INSERT INTO `sysmenu` VALUES ('6', '合同管理', '0', '6', 'icon-bottom', '', '1');
INSERT INTO `sysmenu` VALUES ('7', '资源管理', '0', '7', 'icon-bottom', '', '1');
INSERT INTO `sysmenu` VALUES ('8', '考评管理', '0', '8', 'icon-bottom', '', '1');
INSERT INTO `sysmenu` VALUES ('9', '差旅管理', '0', '9', 'icon-bottom', '', '1');
INSERT INTO `sysmenu` VALUES ('101', '资源管理', '1', '101', 'icon-nav', '/menu/list', '1');
INSERT INTO `sysmenu` VALUES ('102', '菜单树', '1', '102', 'icon-set', '/menu/listtree', '1');
INSERT INTO `sysmenu` VALUES ('201', '客户管理', '2', '201', 'icon-role', '/customer/list', '1');
INSERT INTO `sysmenu` VALUES ('202', '联系人管理', '2', '202', 'icon-person', 'http://www.baidu.com', '0');
INSERT INTO `sysmenu` VALUES ('301', '用户管理', '3', '301', 'icon-log', '/user/list', '1');
INSERT INTO `sysmenu` VALUES ('302', '员工管理', '3', '302', 'icon-person', '/user/listtree', '1');
INSERT INTO `sysmenu` VALUES ('401', '权限管理', '4', '401', 'icon-msg', '/menu/list', '1');
INSERT INTO `sysmenu` VALUES ('402', '角色管理', '4', '402', 'icon-set', '/menu/list', '1');
INSERT INTO `sysmenu` VALUES ('403', '系统通知', '4', '403', 'icon-help', '/menu/list', '1');
INSERT INTO `sysmenu` VALUES ('404', '部门管理', '4', '404', 'icon-role', '/systemdef/listtree', '1');
INSERT INTO `sysmenu` VALUES ('501', '系统报表', '5', '501', 'icon-email', '/menu/list', '1');
INSERT INTO `sysmenu` VALUES ('601', '合同查询', '6', '601', 'icon-ht', '/menu/list', '1');
INSERT INTO `sysmenu` VALUES ('701', '资源查询', '7', '701', 'icon-tongji', '/menu/list', '1');
INSERT INTO `sysmenu` VALUES ('801', '绩效查询', '8', '801', 'icon-bb', '/menu/list', '1');
INSERT INTO `sysmenu` VALUES ('901', '差旅查询', '9', '901', 'icon-money', '/menu/list', '1');

-- ----------------------------
-- Table structure for sysrole
-- ----------------------------
DROP TABLE IF EXISTS `sysrole`;
CREATE TABLE `sysrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL DEFAULT '' COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='后台角色表';

-- ----------------------------
-- Records of sysrole
-- ----------------------------
INSERT INTO `sysrole` VALUES ('1', '超级管理员');
INSERT INTO `sysrole` VALUES ('2', '员工');

-- ----------------------------
-- Table structure for systemdef
-- ----------------------------
DROP TABLE IF EXISTS `systemdef`;
CREATE TABLE `systemdef` (
  `id` int(11) NOT NULL COMMENT '部门编号',
  `name` char(20) NOT NULL COMMENT '部门名称',
  `parentid` int(11) NOT NULL DEFAULT '0' COMMENT '所属二级部门【父类（上级部门）】',
  `iconCls` varchar(20) DEFAULT NULL COMMENT '样式',
  `ptopid` int(11) NOT NULL COMMENT '所属一级部门【顶级父类】',
  `pthird` int(11) DEFAULT NULL COMMENT '所属三级部门【扩展备用】',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemdef
-- ----------------------------
INSERT INTO `systemdef` VALUES ('1', '上海总部', '0', null, '0', null);
INSERT INTO `systemdef` VALUES ('2', '北京分公司', '0', null, '0', null);
INSERT INTO `systemdef` VALUES ('3', '成都分公司', '0', null, '0', null);
INSERT INTO `systemdef` VALUES ('4', '广州分公司', '0', null, '0', null);
INSERT INTO `systemdef` VALUES ('101', '总裁办', '1', null, '1', null);
INSERT INTO `systemdef` VALUES ('102', '行政部', '1', null, '1', null);
INSERT INTO `systemdef` VALUES ('103', '销售部', '1', null, '1', null);
INSERT INTO `systemdef` VALUES ('104', '产品部', '1', null, '1', null);
INSERT INTO `systemdef` VALUES ('105', '研发部', '1', null, '1', null);
INSERT INTO `systemdef` VALUES ('106', '运维部', '2', null, '2', null);
INSERT INTO `systemdef` VALUES ('201', '行政部', '2', null, '2', null);
INSERT INTO `systemdef` VALUES ('202', '销售部', '2', null, '2', null);
INSERT INTO `systemdef` VALUES ('203', '运维部', '2', null, '2', null);
INSERT INTO `systemdef` VALUES ('301', '行政部', '3', '', '3', null);
INSERT INTO `systemdef` VALUES ('302', '销售部', '3', null, '3', null);
INSERT INTO `systemdef` VALUES ('303', '运维部', '3', null, '3', null);
INSERT INTO `systemdef` VALUES ('401', '行政部', '4', null, '4', null);
INSERT INTO `systemdef` VALUES ('402', '销售部', '4', null, '4', null);
INSERT INTO `systemdef` VALUES ('403', '运维部', '4', null, '4', null);
INSERT INTO `systemdef` VALUES ('10201', '管理部', '102', null, '1', null);
INSERT INTO `systemdef` VALUES ('10202', '后勤部', '102', null, '1', null);
INSERT INTO `systemdef` VALUES ('10301', '销售1部', '103', null, '1', null);
INSERT INTO `systemdef` VALUES ('10302', '销售2部', '103', null, '1', null);
INSERT INTO `systemdef` VALUES ('10303', '销售3部', '103', null, '1', null);
INSERT INTO `systemdef` VALUES ('10501', '研发1部', '105', null, '1', null);
INSERT INTO `systemdef` VALUES ('10502', '研发2部', '105', null, '1', null);
INSERT INTO `systemdef` VALUES ('30201', '销售1部', '302', null, '3', null);
INSERT INTO `systemdef` VALUES ('30202', '销售2部', '302', null, '3', null);

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL DEFAULT '' COMMENT '登录名（匿名）',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '登录密码',
  `sysid` int(11) NOT NULL COMMENT '所属部门',
  `email` varchar(50) DEFAULT NULL COMMENT '邮件',
  `name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `idcard` varchar(20) NOT NULL COMMENT '身份证',
  `gender` varchar(2) NOT NULL DEFAULT '男' COMMENT '性别1男2女',
  `qq` varchar(20) DEFAULT NULL COMMENT 'qq',
  `weixin` varchar(50) DEFAULT NULL,
  `regtime` date NOT NULL COMMENT '入职日期',
  PRIMARY KEY (`id`,`idcard`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES ('1', 'admin', 'admin', '101', null, null, '1', '男', '905891460', null, '2015-05-01');
INSERT INTO `sysuser` VALUES ('2', 'tony', '123456', '101', null, null, '2', '男', '123456784', null, '2015-05-02');
INSERT INTO `sysuser` VALUES ('3', 'test1', '123456', '101', null, null, '3', '女', null, null, '0000-00-00');
INSERT INTO `sysuser` VALUES ('4', 'test2', '123456', '101', null, null, '4', '女', null, null, '0000-00-00');
INSERT INTO `sysuser` VALUES ('5', 'test3', '123456', '101', 'sdasda@163.com', null, '5', '男', '7777777', null, '2015-05-03');
INSERT INTO `sysuser` VALUES ('6', 'test4', '123456', '104', '322@qq.com', null, '6', '女', '8888888', null, '2015-05-03');
INSERT INTO `sysuser` VALUES ('7', 'test5', '123456', '104', null, null, '7', '女', '6666666', null, '2015-05-03');
INSERT INTO `sysuser` VALUES ('8', 'test6', '123456', '104', null, null, '8', '男', null, null, '0000-00-00');
INSERT INTO `sysuser` VALUES ('9', 'test7', '123456', '104', 'walk_hai@163.com', null, '9', '女', null, null, '0000-00-00');
INSERT INTO `sysuser` VALUES ('13', 'asdasdsa', '123456', '10201', '11@qq.com', null, '10', '女', null, null, '0000-00-00');
INSERT INTO `sysuser` VALUES ('14', 'test10', '', '10201', 'walk_hai@163.com', null, '11', '男', '333333', null, '2015-05-04');
INSERT INTO `sysuser` VALUES ('15', 'aaa', '', '10201', null, null, '12', '女', null, null, '0000-00-00');
INSERT INTO `sysuser` VALUES ('16', 'a', '', '10201', null, null, '13', '男', '444444', null, '2015-05-04');
INSERT INTO `sysuser` VALUES ('17', 'ttt', '', '10201', 'ttt@sss.com', null, '14', '女', null, null, '0000-00-00');
INSERT INTO `sysuser` VALUES ('18', 'aaa', 'aaa', '10201', 'adf@sdfa.com', null, '23413245', '女', '89898989', 'adfadad', '2015-05-06');
INSERT INTO `sysuser` VALUES ('19', '1', '1', '10201', null, null, '15', '1', null, null, '2015-05-05');
INSERT INTO `sysuser` VALUES ('20', '1', '1', '30201', null, null, '16', '1', null, null, '2015-01-01');
INSERT INTO `sysuser` VALUES ('21', '1', '1', '30201', 'wa@ads.com', null, '17', '男', '888888', 'sssss', '2015-05-09');
INSERT INTO `sysuser` VALUES ('22', 'aaaa', 'aaaa', '30201', 'adsfadsf@asdf.com', null, '123123123123', '男', '132423', 'adsfasdfadffsdfadfadsf', '2015-04-05');
INSERT INTO `sysuser` VALUES ('23', 'ahahhaha', '123456', '301', 'sdfadsf@aa.com', null, '23111111111111', '男', '7979798', 'dasdgads', '2015-05-12');
INSERT INTO `sysuser` VALUES ('24', 'ddd', 'ddd', '301', '1@qq.com', null, '12', '男', '111', '122', '2015-07-13');
INSERT INTO `sysuser` VALUES ('25', 'dddss', 'dddss', '10501', '1@qq.com', '', '12', '男', '111', '122', '2015-07-13');
INSERT INTO `sysuser` VALUES ('26', 'ddddff', 'dddfff', '10501', '1@qq.com', '', '12', '男', '111', '122', '2015-07-13');
INSERT INTO `sysuser` VALUES ('27', 'dddgg', 'dddgg', '10502', '1@qq.com', '', '12', '男', '111', '122', '2015-07-13');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='后台角色与用户关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for visitlog
-- ----------------------------
DROP TABLE IF EXISTS `visitlog`;
CREATE TABLE `visitlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL COMMENT '客户id',
  `idcard` varchar(20) DEFAULT NULL,
  `vdate` date DEFAULT NULL COMMENT '拜访日期',
  `vtype` varchar(20) DEFAULT NULL COMMENT '拜访方式',
  `vremark` varchar(300) DEFAULT NULL COMMENT '拜访记录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitlog
-- ----------------------------
