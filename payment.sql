-------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.50 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for pocdb
CREATE DATABASE IF NOT EXISTS `payment` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `payment`;


-- Dumping structure for table pocdb.accessories
CREATE TABLE IF NOT EXISTS `t_card` (
  `CARD_NUMBER` bigint(12) NOT NULL,
  `EXPIRATION_MONTH` int(2) NOT NULL,
  `EXPIRATION_YEAR` int(4) NOT NULL,
  `CVV` int(3) NOT NULL,
  PRIMARY KEY (`CARD_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `t_payment_details` (
  `ID` int(100) NOT NULL AUTO_INCREMENT,
  `AMOUNT` int(20) NOT NULL,
  `CURRENCY` varchar(30) NOT NULL,
  `CARD_TYPE` varchar(10) NOT NULL,
   `CARD_NUMBER` bigint(12) NOT NULL,
  PRIMARY KEY (`ID`),
   KEY `T_CARD_FK0` (`CARD_NUMBER`),
  CONSTRAINT `T_CARD_FK0` FOREIGN KEY (`CARD_NUMBER`) REFERENCES `t_card` (`CARD_NUMBER`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;





