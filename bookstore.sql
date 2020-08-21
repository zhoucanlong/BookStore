/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.20 : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore`;

/*Table structure for table `bs_book` */

DROP TABLE IF EXISTS `bs_book`;

CREATE TABLE `bs_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` decimal(11,2) NOT NULL,
  `sales` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `img_path` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `bs_book` */

insert  into `bs_book`(`id`,`title`,`author`,`price`,`sales`,`stock`,`img_path`) values (1,'java从入门到放弃','帅哥','80.00',9999,9,'static/img/default.jpg'),(2,'数据结构与算法','靓女','78.50',6,13,'static/img/default.jpg'),(3,'深入浅出wpf','好人','68.00',99999,52,'static/img/default.jpg'),(4,'大话数据结构','程老师','16.00',1000,50,'static/img/default.jpg'),(5,'C++编程思想','刚哥','45.50',14,95,'static/img/default.jpg'),(6,'蛋炒饭','周星星','9.90',12,53,'static/img/default.jpg'),(7,'赌神','周润发','66.50',125,535,'static/img/default.jpg'),(8,'Java编程思想','阳哥','99.50',47,36,'static/img/default.jpg'),(9,'JavaScript从入门到精通','婷姐','9.90',85,95,'static/img/default.jpg'),(10,'cocos2d-x游戏编程入门','国哥','49.00',52,62,'static/img/default.jpg'),(11,'C语言程序设计','谭浩强','28.00',52,74,'static/img/default.jpg'),(12,'Lua语言程序设计','雷丰阳','51.50',48,82,'static/img/default.jpg'),(13,'西游记','罗贯中','12.00',19,9999,'static/img/default.jpg'),(14,'水浒传','施耐庵','33.05',22,88,'static/img/default.jpg'),(15,'操作系统原理','程依依','133.05',122,188,'static/img/default.jpg'),(16,'数据结构 java版','封大神','173.15',21,81,'static/img/default.jpg'),(17,'UNIX高级环境编程','乐天','99.15',210,810,'static/img/default.jpg'),(18,'javaScript高级编程','牛人','69.15',210,810,'static/img/default.jpg'),(19,'大话设计模式','牛人','89.15',20,10,'static/img/default.jpg'),(20,'人月神话','牛人','88.15',20,80,'static/img/default.jpg');

/*Table structure for table `bs_order` */

DROP TABLE IF EXISTS `bs_order`;

CREATE TABLE `bs_order` (
  `order_id` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `total_money` decimal(11,2) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bs_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `bs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_order` */

insert  into `bs_order`(`order_id`,`create_date`,`total_money`,`status`,`user_id`) values ('15980225514761','2020-08-21 15:09:11','208.00',0,1);

/*Table structure for table `bs_order_item` */

DROP TABLE IF EXISTS `bs_order_item`;

CREATE TABLE `bs_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_price` decimal(11,2) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `order_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `bs_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `bs_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `bs_order_item` */

insert  into `bs_order_item`(`id`,`title`,`price`,`total_price`,`count`,`order_id`) values (1,'数据结构与算法','78.50','78.50',1,'15980225514761'),(2,'怎样拐跑别人的媳妇','68.00','68.00',1,'15980225514761'),(3,'木虚肉盖饭','16.00','16.00',1,'15980225514761'),(4,'C++编程思想','45.50','45.50',1,'15980225514761');

/*Table structure for table `bs_user` */

DROP TABLE IF EXISTS `bs_user`;

CREATE TABLE `bs_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `bs_user` */

insert  into `bs_user`(`id`,`username`,`password`,`email`) values (1,'admin','admin','admin@atguigu.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
