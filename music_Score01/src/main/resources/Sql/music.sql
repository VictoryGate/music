/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.24 : Database - music
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `music`;

/*Table structure for table `app_authority` */

DROP TABLE IF EXISTS `app_authority`;

CREATE TABLE `app_authority` (
  `authority_id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `app_authority` */

insert  into `app_authority`(`authority_id`,`name`) values ('1','sys:eidit'),('2','sys:config'),('3','sys:onlyRead'),('4','sys:add'),('5','sys:delete');

/*Table structure for table `app_role` */

DROP TABLE IF EXISTS `app_role`;

CREATE TABLE `app_role` (
  `role_id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `app_role` */

insert  into `app_role`(`role_id`,`name`) values ('1','系统管理员'),('2','普通用户');

/*Table structure for table `app_role_authority` */

DROP TABLE IF EXISTS `app_role_authority`;

CREATE TABLE `app_role_authority` (
  `Role_id` varchar(50) DEFAULT NULL,
  `authority_id` varchar(50) DEFAULT NULL,
  KEY `Role_id` (`Role_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `app_role_authority_ibfk_1` FOREIGN KEY (`Role_id`) REFERENCES `app_role` (`role_id`),
  CONSTRAINT `app_role_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `app_authority` (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `app_role_authority` */

insert  into `app_role_authority`(`Role_id`,`authority_id`) values ('1','1'),('1','2'),('1','3'),('1','4'),('1','5'),('2','3'),('2','4');

/*Table structure for table `app_user` */

DROP TABLE IF EXISTS `app_user`;

CREATE TABLE `app_user` (
  `id` varchar(50) NOT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `register_time` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `app_user` */

insert  into `app_user`(`id`,`nick_name`,`telephone`,`register_time`,`password`) values ('081f1feb-139f-4f37-876b-98f8667b1b71','gavin','18659675624','2017-04-02 15:11:10.256','e10adc3949ba59abbe56e057f20f883e'),('6054dc25-6bd1-4f25-80d6-e01cb6781ffa','admin','13022221111','2017-04-02 00:01:39.137','e10adc3949ba59abbe56e057f20f883e'),('9f8f4692-e8b1-47ad-bb3c-f00b99300b69','root','18659675624','2017-04-02 15:00:25.769','e10adc3949ba59abbe56e057f20f883e'),('d2c88023-6a96-49c3-af93-5932a8ea79d3','account','13022221111','2017-04-02 00:02:02.547','e10adc3949ba59abbe56e057f20f883e');

/*Table structure for table `app_user_role` */

DROP TABLE IF EXISTS `app_user_role`;

CREATE TABLE `app_user_role` (
  `user_id` varchar(50) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `app_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `app_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `app_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `app_user_role` */

insert  into `app_user_role`(`user_id`,`role_id`) values ('d2c88023-6a96-49c3-af93-5932a8ea79d3','1'),('d2c88023-6a96-49c3-af93-5932a8ea79d3','2'),('9f8f4692-e8b1-47ad-bb3c-f00b99300b69','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

DROP TABLE IF EXISTS `APP_STAVE_LIST`;
CREATE TABLE `APP_STAVE_LIST` (
  `uuid` VARCHAR(64) NOT NULL,
  `stave_name` VARCHAR(64) DEFAULT NULL,
  `creater` VARCHAR(64) DEFAULT NULL,
  `user_id` VARCHAR(64) DEFAULT NULL,
  `stave_type` VARCHAR(32) DEFAULT NULL,
  `creat_time` VARCHAR(32) DEFAULT NULL,
  `last_update_time` VARCHAR(32) DEFAULT NULL,
  `remark` VARCHAR(64) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
