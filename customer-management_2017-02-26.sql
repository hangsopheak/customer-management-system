# ************************************************************
# Sequel Pro SQL dump
# Version 4135
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.42)
# Database: customer-management
# Generation Time: 2017-02-26 15:58:27 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE TABLE `td_customer` (
  `cus_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cus_firstname` varchar(50) NOT NULL DEFAULT '',
  `cus_lastname` varchar(50) NOT NULL DEFAULT '',
  `cus_gender` varchar(1) DEFAULT NULL COMMENT 'M: Male, F: Female',
  `cus_email_address` varchar(150) DEFAULT NULL,
  `cus_DOB` datetime DEFAULT NULL,
  `cus_address` mediumtext,
  `cus_phoneNumber` varchar(11) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

# Dump of table td_customer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `td_customer`;

CREATE TABLE `td_customer` (
  `cus_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cus_firstname` varchar(50) NOT NULL DEFAULT '',
  `cus_lastname` varchar(50) NOT NULL DEFAULT '',
  `cus_gender` varchar(1) DEFAULT NULL COMMENT 'M: Male, F: Female',
  `cus_email_address` varchar(150) DEFAULT NULL,
  `cus_DOB` datetime DEFAULT NULL,
  `cus_address` mediumtext,
  `cus_phoneNumber` varchar(11) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `td_customer` WRITE;
/*!40000 ALTER TABLE `td_customer` DISABLE KEYS */;

INSERT INTO `td_customer` (`cus_id`, `cus_firstname`, `cus_lastname`, `cus_gender`, `cus_email_address`, `cus_DOB`, `cus_address`, `cus_phoneNumber`, `date_created`, `date_updated`)
VALUES
	(1,'Sopheak','Hang','M','hangsopheak@gmail.com','1992-06-29 00:00:00','Phnom Penh, Cambodia','092228595','2017-02-26 11:00:00',NULL);

/*!40000 ALTER TABLE `td_customer` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
