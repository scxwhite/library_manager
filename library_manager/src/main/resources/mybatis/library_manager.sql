/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost
 Source Database       : library_manager

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 04/29/2018 10:09:13 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `book`
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
  `introduce` varchar(1000) DEFAULT '' COMMENT '简介',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`book_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `book_type` (`type_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `book`
-- ----------------------------
BEGIN;
INSERT INTO `book` VALUES ('1', '1', 'c程序设计', '中国', '1992', '谭浩强', '100', '10001', 'https://img3.doubanio.com/lpic/s1106934.jpg', '10001', '为了使初学者易于接受，能尽快地学会用C语言编写程序并上机实践，在第一部分中只介绍了整数中的int类型和浮点数float，double类型；介绍了对这三种类型数据的输入和输出，从而暂时避开了C语言中繁多的整数类型和整数的各种表示方式、避开了烦琐的输入、输出的各种规则。', '2018-04-05 21:34:25'), ('2', '1', '西游记', '中国', '1990', '吴承恩', '10', '1000', 'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=833841079,2416037243&fm=58', '999', '《西游记》是中国古代一部浪漫主义长篇神魔小说，主要描写了唐僧、孙悟空、猪八戒猪悟能、沙僧沙悟净师徒四人去西天取经，历经九九八十一难最后终于取得真经的故事。《西游记》内容分为三大部分：第一部分（一到七回）介绍孙悟空的神通广大，大闹天宫；第二部分（八到十二回）叙三藏取经的缘由；第三部分（十三到一百回）是全书故事的主体，写悟空等降伏妖魔，最终到达西天取回真经。《西游记》书中孙悟空这个形象，以其鲜明的个性特征，在中国文学史上立起了一座不朽的艺术丰碑。', '2018-04-01 21:34:25'), ('3', '1', '数据结构', '清华大学', '1992', '雷军', '99.99', '9999', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=767745966,73567065&fm=27&gp=0.jpg', '9999', '数据结构是计算机存储、组织数据的方式。数据结构是指相互之间存在一种或多种特定关系的数据元素的集合。通常情况下，精心选择的数据结构可以带来更高的运行或者存储效率。数据结构往往同高效的检索算法和索引技术有关。', '2018-04-05 21:34:25'), ('4', '5', '红楼梦', '中国', '1991', '曹雪芹', '100', '10000', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2622465356,1440968412&fm=27&gp=0.jpg', '9999', '《红楼梦》，中国古典四大名著之首，清代作家曹雪芹创作的章回体长篇小说 [1]  ，又名《石头记》《金玉缘》。此书分为120回“程本”和80回“脂本”两种版本系统，程本为程伟元排印的印刷本，脂本为脂砚斋在不同时期抄评的早期手抄本，脂本是程本的底本。', '2018-04-03 21:34:25'), ('5', '1', '围城', '武汉', '2013', '钱钟书', '100', '10001', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2323485779,636318993&fm=27&gp=0.jpg', '10001', '围城》是钱钟书所著的长篇小说，是中国现代文学史上一部风格独特的讽刺小说。被誉为“新儒林外史”。第一版于1947年由上海晨光出版公司出版。故事主要写抗战初期知识分子的群相。', '2018-03-22 21:34:25'), ('6', '4', '超级记忆术', '杭州', '1942', '未知', '10', '10000', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2764902253,74789273&fm=27&gp=0.jpg', '10000', '超级记忆术是一门综合科学，是涉及到心理学，教育学，神经学，脑科学的交叉学科。有“英国记忆之父”“世界大脑先生”之称的东尼博赞在哥伦比亚大学毕业时就获得了心理学，英语语言学、数学和普通科学等多种学位。 他是世界记忆力锦标赛的创始人，世界快速阅读锦标赛的创始人，思维奥林匹克运动会的创始人。', '2018-04-04 21:34:25'), ('7', '5', '论语', '中国科技大学', '1999', '未知', '100', '1110', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1973831706,2304837641&fm=200&gp=0.jpg', '1110', '《论语》由孔子弟子及再传弟子编写而成，至战国前期成书。主要记录孔子及其弟子的言行，较为集中地反映了孔子的思想，是儒家学派的经典著作之一。以语录体为主，叙事体为辅，集中体现了孔子的政治主张、伦理思想、道德观念及教育原则等。与《大学》《中庸》《孟子》并称“四书”，与《诗经》等“五经”，总称“四书五经”。全书共20章、492篇，首创 “语录体” 。是中国现代传扬并学习的古代著作之一', '2018-04-07 21:34:25'), ('8', '5', '舍得宽心', '中国', '1888', '未知', '100', '10001', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=336967082,3526374407&fm=27&gp=0.jpg', '10001', '《舍得。宽心》，分上下两册，书中星云大师以佛教精义为根底，对世俗社会万千的人和事，即人生观、财富观、爱情婚姻、家庭教育、人际交往、成功励志等诸方面进行阐释，帮助人们勘破纷扰表象，指向自省自在的人生幸福。', '2018-04-07 21:34:25'), ('9', '5', '艺林', '中国', '1999', '无', '100', '1000', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3669663368,431297969&fm=27&gp=0.jpg', '1000', '这个是好书', '2018-04-07 22:13:21'), ('10', '5', '巴黎的黎爪', '中国', '1999', '无', '199', '1000', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1427381025,308338532&fm=27&gp=0.jpg', '1000', '巴黎', '2018-04-07 22:15:33'), ('11', '4', '意境', '中国', '1888', '无', '100', '1000', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3194507965,2438366219&fm=27&gp=0.jpg', '999', '意境', '2018-04-07 22:18:00');
COMMIT;

-- ----------------------------
--  Table structure for `book_type`
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL COMMENT '类别',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `book_type`
-- ----------------------------
BEGIN;
INSERT INTO `book_type` VALUES ('1', '计算机'), ('2', '工学'), ('4', '心理学'), ('5', '文学');
COMMIT;

-- ----------------------------
--  Table structure for `borrow_logs`
-- ----------------------------
DROP TABLE IF EXISTS `borrow_logs`;
CREATE TABLE `borrow_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `book_id` int(11) DEFAULT NULL COMMENT '书籍ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `message` varchar(50) DEFAULT NULL COMMENT '额外说明',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  PRIMARY KEY (`id`),
  KEY `book_logs_ibfk_1` (`book_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `borrow_logs_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `borrow_logs_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `borrow_logs`
-- ----------------------------
BEGIN;
INSERT INTO `borrow_logs` VALUES ('1', '1', '1', '借书', '2018-03-29 19:33:14'), ('2', '4', '1', null, '2018-04-02 14:46:34'), ('3', '8', '1', null, '2018-04-02 14:47:56'), ('4', '1', '1', null, '2018-04-02 14:52:14'), ('5', '5', '1', null, '2018-04-02 17:04:25'), ('6', '6', '1', null, '2018-04-02 18:54:41'), ('7', '5', '1', null, '2018-04-04 18:03:31'), ('8', '5', '1', null, '2018-04-04 18:11:34'), ('9', '1', '1', null, '2018-04-04 18:16:47'), ('10', '8', '1', null, '2018-04-04 18:37:02'), ('11', '5', '1', null, '2018-04-04 18:37:16'), ('12', '3', '1', null, '2018-04-04 19:05:54'), ('13', '7', '1', null, '2018-04-01 21:28:07'), ('14', '8', '1', null, '2018-04-04 22:38:09'), ('15', '5', '1', null, '2018-04-07 09:22:12'), ('16', '7', '1', null, '2018-04-07 10:26:43'), ('17', '1', '1', null, '2018-04-07 10:28:42'), ('18', '3', '1', null, '2018-04-07 10:30:42'), ('19', '4', '2', null, '2018-04-07 11:28:07'), ('20', '7', '2', null, '2018-04-07 11:28:32'), ('21', '2', '1', null, '2018-04-07 22:09:36'), ('22', '11', '2', null, '2018-04-07 22:41:48');
COMMIT;

-- ----------------------------
--  Table structure for `return_logs`
-- ----------------------------
DROP TABLE IF EXISTS `return_logs`;
CREATE TABLE `return_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `message` varchar(50) DEFAULT NULL,
  `borrow_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `borrow_id` (`borrow_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `return_logs_ibfk_1` FOREIGN KEY (`borrow_id`) REFERENCES `borrow_logs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `return_logs_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `return_logs`
-- ----------------------------
BEGIN;
INSERT INTO `return_logs` VALUES ('11', '2018-04-04 22:25:10', null, '2', '1'), ('12', '2018-04-04 22:25:13', null, '1', '1'), ('13', '2018-04-04 22:25:58', null, '11', '1'), ('14', '2018-04-04 22:26:46', null, '7', '1'), ('15', '2018-04-04 22:29:16', null, '3', '1'), ('16', '2018-04-04 22:38:15', null, '4', '1'), ('17', '2018-04-04 22:39:25', null, '8', '1'), ('18', '2018-04-04 22:39:31', null, '5', '1'), ('19', '2018-04-04 22:40:13', null, '13', '1'), ('20', '2018-04-04 22:40:17', null, '9', '1'), ('21', '2018-04-07 09:02:39', null, '10', '1'), ('22', '2018-04-07 09:22:28', null, '6', '1'), ('23', '2018-04-07 10:27:05', null, '16', '1'), ('24', '2018-04-07 10:29:00', null, '12', '1'), ('25', '2018-04-07 10:29:10', null, '17', '1'), ('26', '2018-04-07 10:29:20', null, '14', '1'), ('27', '2018-04-07 10:29:23', null, '15', '1'), ('28', '2018-04-07 10:30:54', null, '18', '1'), ('29', '2018-04-07 22:42:27', null, '20', '2');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL COMMENT '学号/用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `info` tinyint(2) DEFAULT '0' COMMENT '登录用户的类型 0：学生  1：教师',
  `is_valid` tinyint(2) DEFAULT '0' COMMENT '是否有效',
  `sex` tinyint(4) DEFAULT '0' COMMENT '性别： 0:男生 1：女生',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'xiaosuda', 'aaascx521', '1', '1', '0'), ('2', '1', '1', '0', '1', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
