/*
SQLyog Community Edition- MySQL GUI v5.22a
Host - 5.0.13-rc-nt : Database - hibernate_example
*********************************************************************
Server version : 5.0.13-rc-nt
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `hibernate_example`;

USE `hibernate_example`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `address_many2one` */

DROP TABLE IF EXISTS `address_many2one`;

CREATE TABLE `address_many2one` (
  `ADDRESS_ID` bigint(20) NOT NULL,
  `ADDRESS_STREET` varchar(255) default NULL,
  `ADDRESS_CITY` varchar(255) default NULL,
  `ADDRESS_STATE` varchar(255) default NULL,
  `ADDRESS_ZIPCODE` varchar(255) default NULL,
  PRIMARY KEY  (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `address_misc` */

DROP TABLE IF EXISTS `address_misc`;

CREATE TABLE `address_misc` (
  `ADDRESS_ID` bigint(20) NOT NULL auto_increment,
  `ADDRESS_STREET` varchar(255) default NULL,
  `ADDRESS_CITY` varchar(255) default NULL,
  `ADDRESS_STATE` varchar(255) default NULL,
  `ADDRESS_ZIPCODE` varchar(255) default NULL,
  PRIMARY KEY  (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `addresses` */

DROP TABLE IF EXISTS `addresses`;

CREATE TABLE `addresses` (
  `id` int(11) NOT NULL auto_increment,
  `state` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `street` varchar(250) default NULL,
  `zipcode` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `audit_log` */

DROP TABLE IF EXISTS `audit_log`;

CREATE TABLE `audit_log` (
  `auditLog_id` bigint(20) NOT NULL auto_increment,
  `action` varchar(255) default NULL,
  `detail_msg` varchar(255) default NULL,
  `created_at` datetime default NULL,
  `entity_id` bigint(20) default NULL,
  `entity_name` varchar(255) default NULL,
  PRIMARY KEY  (`auditLog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `book_compsite_key` */

DROP TABLE IF EXISTS `book_compsite_key`;

CREATE TABLE `book_compsite_key` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `category` varchar(255) default NULL,
  `price` double default NULL,
  PRIMARY KEY  (`book_id`,`book_name`,`author`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `courses` */

DROP TABLE IF EXISTS `courses`;

CREATE TABLE `courses` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `courses_misc` */

DROP TABLE IF EXISTS `courses_misc`;

CREATE TABLE `courses_misc` (
  `COURSE_ID` bigint(20) NOT NULL,
  `COURSE_NAME` varchar(255) NOT NULL,
  PRIMARY KEY  (`COURSE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `department_one2many` */

DROP TABLE IF EXISTS `department_one2many`;

CREATE TABLE `department_one2many` (
  `DEPARTMENT_ID` bigint(20) NOT NULL auto_increment,
  `DEPT_NAME` varchar(255) default NULL,
  PRIMARY KEY  (`DEPARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL auto_increment,
  `first_name` varchar(255) default NULL,
  `last_name` varchar(255) default NULL,
  `salary` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `employee_3` */

DROP TABLE IF EXISTS `employee_3`;

CREATE TABLE `employee_3` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `employee_contract_3` */

DROP TABLE IF EXISTS `employee_contract_3`;

CREATE TABLE `employee_contract_3` (
  `id` int(11) NOT NULL,
  `name` varchar(255) default NULL,
  `pay_per_hour` float default NULL,
  `contract_duration` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `employee_misc` */

DROP TABLE IF EXISTS `employee_misc`;

CREATE TABLE `employee_misc` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) default NULL,
  `last_name` varchar(255) default NULL,
  `salary` int(11) default NULL,
  `date_of_birth` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `employee_one2many` */

DROP TABLE IF EXISTS `employee_one2many`;

CREATE TABLE `employee_one2many` (
  `EMPLOYEE_ID` bigint(20) NOT NULL auto_increment,
  `firstname` varchar(255) default NULL,
  `lastname` varchar(255) default NULL,
  `birth_date` date default NULL,
  `cell_phone` varchar(255) default NULL,
  `department_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`EMPLOYEE_ID`),
  KEY `FK73F4FD5CE1DE2125` (`department_id`),
  CONSTRAINT `FK73F4FD5CE1DE2125` FOREIGN KEY (`department_id`) REFERENCES `department_one2many` (`DEPARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `employee_regular_3` */

DROP TABLE IF EXISTS `employee_regular_3`;

CREATE TABLE `employee_regular_3` (
  `id` int(11) NOT NULL,
  `name` varchar(255) default NULL,
  `salary` float default NULL,
  `bonus` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `payment_cheque_2` */

DROP TABLE IF EXISTS `payment_cheque_2`;

CREATE TABLE `payment_cheque_2` (
  `cheque_payment_id` int(11) default NULL,
  `cheque_type` varchar(55) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `payment_cheque_3` */

DROP TABLE IF EXISTS `payment_cheque_3`;

CREATE TABLE `payment_cheque_3` (
  `payment_id` int(11) NOT NULL auto_increment,
  `amount` double default NULL,
  `cheque_type` varchar(55) default NULL,
  PRIMARY KEY  (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `payment_creditcard_2` */

DROP TABLE IF EXISTS `payment_creditcard_2`;

CREATE TABLE `payment_creditcard_2` (
  `cc_payment_id` int(11) default NULL,
  `cctype` varchar(55) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `payment_creditcard_3` */

DROP TABLE IF EXISTS `payment_creditcard_3`;

CREATE TABLE `payment_creditcard_3` (
  `payment_id` int(11) NOT NULL auto_increment,
  `amount` double default NULL,
  `cctype` varchar(55) default NULL,
  PRIMARY KEY  (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `payments_1` */

DROP TABLE IF EXISTS `payments_1`;

CREATE TABLE `payments_1` (
  `id` int(11) NOT NULL auto_increment,
  `PAYMENT_TYPE` varchar(55) default NULL,
  `CCTYPE` varchar(55) default NULL,
  `cash_details` varchar(255) default NULL,
  `cheque_type` varchar(55) default NULL,
  `AMOUNT` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `payments_2` */

DROP TABLE IF EXISTS `payments_2`;

CREATE TABLE `payments_2` (
  `id` int(11) NOT NULL auto_increment,
  `AMOUNT` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `payments_3` */

DROP TABLE IF EXISTS `payments_3`;

CREATE TABLE `payments_3` (
  `id` int(11) default NULL,
  `PAYMENT_TYPE` varchar(55) default NULL,
  `CCTYPE` varchar(55) default NULL,
  `cash_details` varchar(255) default NULL,
  `cheque_type` varchar(55) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `phone` */

DROP TABLE IF EXISTS `phone`;

CREATE TABLE `phone` (
  `id` int(11) NOT NULL auto_increment,
  `type` varchar(10) default NULL,
  `number` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `phone_misc` */

DROP TABLE IF EXISTS `phone_misc`;

CREATE TABLE `phone_misc` (
  `PHONE_ID` bigint(20) NOT NULL,
  `PHONE_TYPE` varchar(255) default NULL,
  `PHONE_NUMBER` varchar(255) default NULL,
  PRIMARY KEY  (`PHONE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `stock_detail_one2one` */

DROP TABLE IF EXISTS `stock_detail_one2one`;

CREATE TABLE `stock_detail_one2one` (
  `STOCK_ID` int(11) NOT NULL,
  `COMP_NAME` varchar(100) NOT NULL,
  `COMP_DESC` varchar(255) NOT NULL,
  `REMARK` varchar(255) NOT NULL,
  `LISTED_DATE` date NOT NULL,
  PRIMARY KEY  (`STOCK_ID`),
  KEY `FK8476FAB58FA0F2EE` (`STOCK_ID`),
  CONSTRAINT `FK8476FAB58FA0F2EE` FOREIGN KEY (`STOCK_ID`) REFERENCES `stock_one2one` (`STOCK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `stock_one2one` */

DROP TABLE IF EXISTS `stock_one2one`;

CREATE TABLE `stock_one2one` (
  `STOCK_ID` int(11) NOT NULL auto_increment,
  `STOCK_CODE` varchar(10) NOT NULL,
  `STOCK_NAME` varchar(20) NOT NULL,
  PRIMARY KEY  (`STOCK_ID`),
  UNIQUE KEY `STOCK_CODE` (`STOCK_CODE`),
  UNIQUE KEY `STOCK_NAME` (`STOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(250) default NULL,
  `address_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `student_course_misc` */

DROP TABLE IF EXISTS `student_course_misc`;

CREATE TABLE `student_course_misc` (
  `STUDENT_ID` bigint(20) NOT NULL,
  `COURSE_ID` bigint(20) NOT NULL,
  PRIMARY KEY  (`STUDENT_ID`,`COURSE_ID`),
  KEY `FK86127E6C85230E16` (`STUDENT_ID`),
  KEY `FK86127E6CA52B761E` (`COURSE_ID`),
  CONSTRAINT `FK86127E6CA52B761E` FOREIGN KEY (`COURSE_ID`) REFERENCES `courses_misc` (`COURSE_ID`),
  CONSTRAINT `FK86127E6C85230E16` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student_misc` (`STUDENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `student_many2one` */

DROP TABLE IF EXISTS `student_many2one`;

CREATE TABLE `student_many2one` (
  `STUDENT_ID` bigint(20) NOT NULL,
  `STUDENT_NAME` varchar(255) default NULL,
  `STUDENT_ADDRESS` bigint(20) NOT NULL,
  PRIMARY KEY  (`STUDENT_ID`),
  KEY `FK9E5CF977A79F2601` (`STUDENT_ADDRESS`),
  CONSTRAINT `FK9E5CF977A79F2601` FOREIGN KEY (`STUDENT_ADDRESS`) REFERENCES `address_many2one` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `student_misc` */

DROP TABLE IF EXISTS `student_misc`;

CREATE TABLE `student_misc` (
  `STUDENT_ID` bigint(20) NOT NULL,
  `STUDENT_NAME` varchar(255) default NULL,
  `STUDENT_ADDRESS` bigint(20) NOT NULL,
  PRIMARY KEY  (`STUDENT_ID`),
  KEY `FK8ACF6890D48F0020` (`STUDENT_ADDRESS`),
  CONSTRAINT `FK8ACF6890D48F0020` FOREIGN KEY (`STUDENT_ADDRESS`) REFERENCES `address_misc` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `student_phone_mapping` */

DROP TABLE IF EXISTS `student_phone_mapping`;

CREATE TABLE `student_phone_mapping` (
  `id` int(11) NOT NULL auto_increment,
  `STUDENT_ID` int(11) default NULL,
  `phone_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `student_phone_misc` */

DROP TABLE IF EXISTS `student_phone_misc`;

CREATE TABLE `student_phone_misc` (
  `STUDENT_ID` bigint(20) NOT NULL,
  `PHONE_ID` bigint(20) NOT NULL,
  PRIMARY KEY  (`STUDENT_ID`,`PHONE_ID`),
  UNIQUE KEY `PHONE_ID` (`PHONE_ID`),
  KEY `FKFC9DB1E1D7F1BC36` (`PHONE_ID`),
  KEY `FKFC9DB1E185230E16` (`STUDENT_ID`),
  CONSTRAINT `FKFC9DB1E185230E16` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student_misc` (`STUDENT_ID`),
  CONSTRAINT `FKFC9DB1E1D7F1BC36` FOREIGN KEY (`PHONE_ID`) REFERENCES `phone_misc` (`PHONE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
