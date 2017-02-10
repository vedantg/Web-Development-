-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: bestdealdatabase
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `productstab`
--

DROP TABLE IF EXISTS `productstab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productstab` (
  `key_nm` varchar(40) DEFAULT NULL,
  `prod_id` varchar(40) NOT NULL,
  `prod_name` varchar(40) DEFAULT NULL,
  `prod_retailer` varchar(40) DEFAULT NULL,
  `prod_condition` varchar(40) DEFAULT NULL,
  `prod_price` int(11) DEFAULT NULL,
  `prod_image` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productstab`
--

LOCK TABLES `productstab` WRITE;
/*!40000 ALTER TABLE `productstab` DISABLE KEYS */;
INSERT INTO `productstab` VALUES ('Laptop','L002','Dell360','Dell','Refurbished',299,'\'images/lp_02.jpg\''),('Laptop','L003','Samsung80','Samsung','Refurbished',299,'\'images/lp_03.png\''),('Laptop','L004','Lenovo80','Lenovo','Refurbished',299,'\'images/lp_04.jpg\''),('Laptop','L005','HCL90','HCL','Refurbished',299,'\'images/lp_05.jpg\''),('SmartPhone','S001','MotoG2','MotoG','New',399,'\'images/s_01.jpg\''),('SmartPhone','S002','OnePlus3','OnePlus','Refurbished',299,'\'images/s_02.jpg\''),('SmartPhone','S003','SonyWalkman','Sony','New',399,'\'images/s_03.jpg\''),('SmartPhone','S004','OnePlus2','OnePlus','Refurbished',299,'\'images/s_04.jpg\''),('SmartPhone','S005','LG92','LG','Refurbished',299,'\'images/s_05.jpg\''),('Tablet','T001','Sony01','Sony','New',399,'\'images/tab_01.jpg\''),('Tablet','T002','Dell360','Dell','Refurbished',299,'\'images/tab_02.jpg\''),('Tablet','T003','LG021','LG','New',399,'\'images/tab_03.jpg\''),('Tablet','T004','Moto360','Motorola','Refurbished',299,'\'images/tab_04.png\''),('Tablet','T005','AppleTab','Apple','Refurbished',299,'\'images/tab_05.jpg\''),('TV','V001','SonyHawkEye','Sony','New',399,'\'images/tv_1.jpg\''),('TV','V002','Toshiba360','Toshiba','Refurbished',299,'\'images/tv_2.jpg\''),('TV','V003','LGSmooth','LG','New',399,'\'images/tv_3.jpg\''),('TV','V004','Samsung360','Samsung','Refurbished',299,'\'images/tv_4.jpg\''),('TV','V005','Samsung01','Samsung','Refurbished',299,'\'images/tv_5.jpg\''),('TV','V006','Sony110','Sony','Good',777,'\'images/tv_5.jpg\'');
/*!40000 ALTER TABLE `productstab` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-31 17:24:33
