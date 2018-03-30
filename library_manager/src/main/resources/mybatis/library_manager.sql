/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : library_manager

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2018-03-30 13:51:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书编号',
  `type_id` int(11) DEFAULT NULL COMMENT '类别',
  `title` varchar(30) DEFAULT NULL COMMENT '书名',
  `publish` varchar(30) DEFAULT NULL COMMENT '出版社',
  `publish_year` int(11) DEFAULT NULL COMMENT '出版年份',
  `author` varchar(30) DEFAULT NULL COMMENT '作者',
  `price` double DEFAULT NULL COMMENT '价格',
  `number` int(11) DEFAULT NULL COMMENT '总藏书量',
  `url` varchar(500) DEFAULT NULL COMMENT '图片链接',
  `stocks` int(11) DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`book_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `book_type` (`type_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '1', 'c程序设计', '清华大学', '1992', '马云', '100', '10000', 'https://img3.doubanio.com/lpic/s1106934.jpg', '10000');
INSERT INTO `book` VALUES ('2', '1', '西游记', '中国', '1990', '吴承恩', '10', '1000', 'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=833841079,2416037243&fm=58', '10000');
INSERT INTO `book` VALUES ('3', '1', '数据结构', '清华大学', '1992', '雷军', '99.99', '10000', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=767745966,73567065&fm=27&gp=0.jpg', '10000');
INSERT INTO `book` VALUES ('4', '5', '红楼梦', '中国', '1991', '曹雪芹', '100', '10000', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2622465356,1440968412&fm=27&gp=0.jpg', '10000');
INSERT INTO `book` VALUES ('5', '1', '围城', '武汉', '2013', '韩寒', '100', '10000', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2323485779,636318993&fm=27&gp=0.jpg', '10000');
INSERT INTO `book` VALUES ('6', '4', '超级记忆术', '杭州', '1942', '未知', '10', '1000', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2764902253,74789273&fm=27&gp=0.jpg', '10000');
INSERT INTO `book` VALUES ('7', '5', '论语', '中国科技大学', '1999', '未知', '100', '1111', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1973831706,2304837641&fm=200&gp=0.jpg', '1111');
INSERT INTO `book` VALUES ('8', '5', '舍得宽心', '中国', '1888', '未知', '100', '10000', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=336967082,3526374407&fm=27&gp=0.jpg', '10000');

-- ----------------------------
-- Table structure for `book_logs`
-- ----------------------------
DROP TABLE IF EXISTS `book_logs`;
CREATE TABLE `book_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `book_id` int(11) DEFAULT NULL COMMENT '书籍ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `op_type` tinyint(2) DEFAULT '0' COMMENT '操作类型  0： 借书  1：还书',
  `message` varchar(50) DEFAULT NULL COMMENT '额外说明',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  PRIMARY KEY (`id`),
  KEY `book_logs_ibfk_1` (`book_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `book_logs_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `book_logs_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of book_logs
-- ----------------------------
INSERT INTO `book_logs` VALUES ('1', '1', '1', '0', '借书', '2018-03-29 19:33:14');

-- ----------------------------
-- Table structure for `book_type`
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL COMMENT '类别',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES ('1', '计算机');
INSERT INTO `book_type` VALUES ('2', '工学');
INSERT INTO `book_type` VALUES ('4', '心理学');
INSERT INTO `book_type` VALUES ('5', '文学');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL COMMENT '学号/用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `info` tinyint(2) DEFAULT '0' COMMENT '登录用户的类型 0：学生  1：教师',
  `is_valid` tinyint(2) DEFAULT '0' COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xiaosuda', 'aaascx521', '1', '1');
INSERT INTO `user` VALUES ('2', '1', '1', '0', '1');
