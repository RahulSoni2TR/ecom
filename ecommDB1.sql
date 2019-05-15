/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.5.48 : Database - ecomm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`ecomm` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ecomm`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `Category_ID` int(11) NOT NULL,
  `Category_Name` varchar(30) DEFAULT NULL,
  `Cat_Picture` blob,
  PRIMARY KEY (`Category_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`Category_ID`,`Category_Name`,`Cat_Picture`) values (1,'Fashion',NULL),(2,'Watches',NULL),(3,'Books',NULL);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `Customer_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Address` varchar(255) DEFAULT NULL,
  `Email_Id` varchar(255) DEFAULT NULL,
  `Customer_Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Customer_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`Customer_Id`,`Address`,`Email_Id`,`Customer_Name`) values (1,'whitefield','customer@customer.com','Samrat kapoor'),(2,'Hope Farm','smrat@smrat.com','Manu Kapoor');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `Item_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Avaiable` varchar(255) DEFAULT NULL,
  `Category_ID` int(11) DEFAULT NULL,
  `Item_Description` varchar(255) DEFAULT NULL,
  `Item_Name` varchar(255) DEFAULT NULL,
  `Item_Price` int(11) DEFAULT NULL,
  PRIMARY KEY (`Item_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `item` */

insert  into `item`(`Item_Id`,`Avaiable`,`Category_ID`,`Item_Description`,`Item_Name`,`Item_Price`) values (2,'20',1,'SHIRT','FM',1100),(3,'20',1,'efgh','abcd',0);

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `OrderId` int(11) NOT NULL,
  `Order_Price` double DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Order_Date` datetime DEFAULT NULL,
  `TX_TimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Customer_ID` int(11) DEFAULT NULL,
  `EmailId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`OrderId`),
  KEY `FK_order` (`Customer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `order` */

insert  into `order`(`OrderId`,`Order_Price`,`Quantity`,`Order_Date`,`TX_TimeStamp`,`Customer_ID`,`EmailId`) values (1,1000,1,'2019-05-15 00:00:00','2019-05-15 00:50:22',1,'abc@gmail.com'),(2,1500,2,'2019-05-15 00:00:00','2019-05-15 00:52:50',2,'shanky@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
