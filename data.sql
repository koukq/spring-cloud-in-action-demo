/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.24-log : Database - cloud_demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cloud_demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cloud_demo`;

/*Table structure for table `basic_employee` */

DROP TABLE IF EXISTS `basic_employee`;

CREATE TABLE `basic_employee` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `employeeCode` varchar(32) DEFAULT NULL COMMENT '员工编号',
  `employeeName` varchar(32) DEFAULT NULL COMMENT '员工姓名',
  `phoneNumber` varchar(32) DEFAULT NULL COMMENT '手机号',
  `userImage` varchar(256) DEFAULT NULL COMMENT '用户头像',
  `deleteStatus` int(1) DEFAULT '0' COMMENT '删除状态（0：正常，1：删除）',
  `creator` bigint(16) DEFAULT NULL COMMENT '创建人',
  `modifier` bigint(16) DEFAULT NULL COMMENT '修改人',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `workEmail` varchar(20) DEFAULT NULL COMMENT '公司邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='员工表';

/*Data for the table `basic_employee` */

insert  into `basic_employee`(`id`,`employeeCode`,`employeeName`,`phoneNumber`,`userImage`,`deleteStatus`,`creator`,`modifier`,`createTime`,`modifyTime`,`workEmail`) values (6,'0001','dawa','15201459900','http://192.168.30.153:8888/group1/M00/00/00/wKgemVwHkSmATO8MAAAyb1oqI3g097.png',0,1,1,'2018-11-29 20:45:56','2018-12-05 16:49:45',NULL),(7,'0002','asd','15201459901',NULL,0,1,1,'2018-11-30 14:31:21','2018-12-02 11:51:19',NULL),(8,'0003','沙师弟','18888888888',NULL,0,1,1,'2018-12-03 10:01:26','2018-12-03 10:01:26',NULL),(9,'0004','老四','19999323232',NULL,0,1,1,'2018-12-04 16:59:56','2018-12-04 16:59:56',NULL),(10,'123456',NULL,NULL,NULL,0,NULL,NULL,'2019-04-26 16:48:24','2019-04-26 16:48:24',NULL),(11,'123456',NULL,NULL,NULL,0,NULL,NULL,'2019-04-26 16:50:27','2019-04-26 16:50:27',NULL),(12,'123456',NULL,NULL,NULL,0,NULL,NULL,'2019-04-26 16:51:04','2019-04-26 16:51:04',NULL),(13,'123456',NULL,NULL,NULL,0,NULL,NULL,'2019-04-26 16:52:15','2019-04-26 16:52:15',NULL),(14,'123456',NULL,NULL,NULL,0,NULL,NULL,'2019-04-26 16:53:26','2019-04-26 16:53:26',NULL),(15,'1234','1234',NULL,NULL,1,NULL,NULL,'2015-12-12 23:34:12','2019-04-26 17:16:27',NULL),(16,'1234','1234',NULL,NULL,1,NULL,NULL,'2015-12-12 00:00:00','2019-04-26 17:16:47',NULL),(17,'1234','1234',NULL,NULL,1,NULL,NULL,'2015-12-12 00:00:00','2019-04-26 17:17:34',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
