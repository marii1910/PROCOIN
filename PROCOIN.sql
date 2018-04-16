-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: procoin
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_country` varchar(50) NOT NULL,
  `address_city` varchar(50) NOT NULL,
  `address_street` varchar(100) NOT NULL,
  `address_ZIP` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (19,'b','b','b','b'),(20,'a','a','aa','a'),(21,'a','a','a','a'),(22,'hf','hf','h','hf');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` varchar(50) NOT NULL,
  `address_id` int(11) NOT NULL,
  `customer_cod` varchar(50) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `customer_phone` varchar(15) NOT NULL,
  `customer_contact` varchar(50) NOT NULL,
  `customer_position_contact` varchar(100) NOT NULL,
  `customer_email_contact` varchar(100) NOT NULL,
  `customer_web` varchar(100) DEFAULT NULL,
  `customer_money_type` varchar(10) NOT NULL,
  `customer_payment_type` varchar(10) NOT NULL,
  `customer_limit_credit` double NOT NULL,
  `customer_credit_term` int(11) NOT NULL,
  `customer_status` varchar(10) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `customer_create_date` date NOT NULL,
  `customer_modify_date` date NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `address_id` (`address_id`),
  KEY `user_name` (`user_name`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('h',22,'h','h','h','h','h','h','h','Dólares','Contado',5465,0,'Activo','admin','2018-04-07','2018-04-07');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exchange_rate`
--

DROP TABLE IF EXISTS `exchange_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exchange_rate` (
  `exchange_rate_id` int(11) NOT NULL AUTO_INCREMENT,
  `exchange_rate_value` double NOT NULL,
  `exchange_rate_date` date NOT NULL,
  PRIMARY KEY (`exchange_rate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exchange_rate`
--

LOCK TABLES `exchange_rate` WRITE;
/*!40000 ALTER TABLE `exchange_rate` DISABLE KEYS */;
INSERT INTO `exchange_rate` VALUES (1,562.07,'2018-04-14'),(2,562.07,'2018-04-14'),(3,562.07,'2018-04-15');
/*!40000 ALTER TABLE `exchange_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `inventory_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `product_value_unit` double NOT NULL,
  `product_taxes_unit` double NOT NULL,
  `product_price_unit` double NOT NULL,
  `product_value_sale` double NOT NULL,
  `product_taxes_sale` double NOT NULL,
  `product_price_sale` double NOT NULL,
  PRIMARY KEY (`inventory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory_input`
--

DROP TABLE IF EXISTS `inventory_input`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory_input` (
  `inventory_input_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_id` varchar(50) NOT NULL,
  `exchange_rate_id` int(11) NOT NULL,
  `inventory_input_document` varchar(50) NOT NULL,
  `inventory_input_num_document` varchar(50) NOT NULL,
  `inventory_input_date` date NOT NULL,
  PRIMARY KEY (`inventory_input_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_input`
--

LOCK TABLES `inventory_input` WRITE;
/*!40000 ALTER TABLE `inventory_input` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_input` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory_input_detail`
--

DROP TABLE IF EXISTS `inventory_input_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory_input_detail` (
  `inventory_input_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_input_id` int(11) NOT NULL,
  `inventory_id` int(11) NOT NULL,
  PRIMARY KEY (`inventory_input_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_input_detail`
--

LOCK TABLES `inventory_input_detail` WRITE;
/*!40000 ALTER TABLE `inventory_input_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_input_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` varchar(50) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_desc` varchar(200) NOT NULL,
  `prod_fam_id` int(11) NOT NULL,
  `prod_brand_id` int(11) NOT NULL,
  `product_measurement_unit` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `product_create_date` date NOT NULL,
  `product_modify_date` date NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `prod_fam_id` (`prod_fam_id`),
  KEY `prod_brand_id` (`prod_brand_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`prod_fam_id`) REFERENCES `product_family` (`prod_fam_id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`prod_brand_id`) REFERENCES `product_brand` (`prod_brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('g','g','h',4,2,'Litros','admin','2018-04-15','2018-04-15'),('h','j','j',3,5,'Metros','admin','2018-04-11','2018-04-11'),('t','t','t\n',4,2,'Gramos','admin','2018-04-15','2018-04-15');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_brand`
--

DROP TABLE IF EXISTS `product_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_brand` (
  `prod_brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_brand_name` varchar(100) NOT NULL,
  `prod_brand_desc` varchar(200) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `prod_brand_create_date` date NOT NULL,
  `prod_brand_modify_date` date NOT NULL,
  PRIMARY KEY (`prod_brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_brand`
--

LOCK TABLES `product_brand` WRITE;
/*!40000 ALTER TABLE `product_brand` DISABLE KEYS */;
INSERT INTO `product_brand` VALUES (2,'Cisco','Es bueno','Julia','2018-04-08','2018-04-08'),(5,'Linksys','Marca original','admin','2018-04-11','2018-04-11');
/*!40000 ALTER TABLE `product_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_family`
--

DROP TABLE IF EXISTS `product_family`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_family` (
  `prod_fam_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_fam_name` varchar(50) NOT NULL,
  `prod_fam_desc` varchar(100) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `prod_fam_create_date` date NOT NULL,
  `prod_fam_modify_date` date NOT NULL,
  PRIMARY KEY (`prod_fam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_family`
--

LOCK TABLES `product_family` WRITE;
/*!40000 ALTER TABLE `product_family` DISABLE KEYS */;
INSERT INTO `product_family` VALUES (3,'Servidor','Almacenamiento de información','admin','2018-04-11','2018-04-11'),(4,'Router','Dispositivo para la transmision de internet Wi-fi','admin','2018-04-11','2018-04-11');
/*!40000 ALTER TABLE `product_family` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `supplier_id` varchar(50) NOT NULL,
  `address_id` int(11) NOT NULL,
  `supplier_cod` varchar(50) NOT NULL,
  `supplier_name` varchar(100) NOT NULL,
  `supplier_phone` varchar(15) NOT NULL,
  `supplier_contact` varchar(50) NOT NULL,
  `supplier_position_contact` varchar(100) NOT NULL,
  `supplier_email_contact` varchar(100) NOT NULL,
  `supplier_web` varchar(100) DEFAULT NULL,
  `supplier_money_type` varchar(10) NOT NULL,
  `supplier_payment_type` varchar(10) NOT NULL,
  `supplier_limit_credit` double NOT NULL,
  `supplier_credit_term` int(11) NOT NULL,
  `supplier_status` varchar(10) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `supplier_create_date` date NOT NULL,
  `supplier_modify_date` date NOT NULL,
  PRIMARY KEY (`supplier_id`),
  KEY `address_id` (`address_id`),
  KEY `user_name` (`user_name`),
  CONSTRAINT `supplier_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `supplier_ibfk_2` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('a',20,'a','a','a','a','a','a','a','Colones','Contado',45435,0,'Activo','admin','2018-04-07','2018-04-07'),('b',22,'b','b','b','b','b','b','','Dólares','Contado',3434,0,'Activo','admin','2018-04-07','2018-04-07');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_type` varchar(15) NOT NULL,
  `user_status` varchar(10) NOT NULL,
  `user_create_date` date NOT NULL,
  `user_modify_date` date NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','[a, d, m, i, n]','Administrador','Activo','2018-04-07','2018-04-07'),('Julia','[a, d, m, i, n]','Estandar','Activo','2018-04-08','2018-04-08');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-15 22:47:19
