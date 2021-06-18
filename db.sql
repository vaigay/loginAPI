-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: login_api
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `total_product_amount` double NOT NULL,
  `cart_id` bigint DEFAULT NULL,
  `crate_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK96cqdvvmplxou72492ggoveyi` (`cart_id`),
  CONSTRAINT `FK96cqdvvmplxou72492ggoveyi` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (14,'La Khê, Hà Đông',133500000,20,'2021-05-22'),(15,'Vĩnh Phúc',12650000,21,'2021-05-22'),(16,'Vĩnh Phúc',48850023,22,'2021-05-22'),(17,'Vĩnh Phúc',44700000,24,'2021-05-22'),(18,'Thái Nguyên',150000000,25,'2021-05-22'),(19,'Trung quick\n',110250000,23,'2021-05-23'),(20,'oke',34000000,26,'2021-05-24'),(21,'soc',9750000,30,'2021-05-24'),(22,'su 111',172350000,32,'2021-06-17');
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` bit(1) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl70asp4l4w0jmbm1tqyofho4o` (`user_id`),
  CONSTRAINT `FKl70asp4l4w0jmbm1tqyofho4o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (20,_binary '',2),(21,_binary '',2),(22,_binary '',4),(23,_binary '',2),(24,_binary '',4),(25,_binary '',4),(26,_binary '',2),(27,_binary '\0',7),(28,_binary '\0',1),(29,_binary '\0',2),(30,_binary '',8),(31,_binary '\0',8),(32,_binary '',9),(33,_binary '\0',9);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `madein` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'nokia','FlQZx.nokia-c300-xanh.jpg','America','nokia C3',6450000,'a11x'),(2,'Apple','HeYpT.ip12pro-max.jpg','USA','Iphone 12 pro max',37500000,'Iphone 12 đẳng cấp thế giới, màn hình tuyệt vời, pin siêu trâu chiến game liên tục'),(3,'Apple','CLixT.iphone12-mini.jpg','USA','Iphone 12 mini',21000000,'Iphone 12 mini nhỏ gọn, giá cả phải chăng mà cũng rất cao cấp, sử dụng oke'),(4,'Samsung','XJRUt.s20.jpg','Koreanxxx','Samsung Galaxy S20',2350000,'SS S20 mang đến những công nghệ hàng đầu của dòng điện thoại Androi, sản phẩm rất đáng mua trong năm 2021'),(5,'Samsung','HuDtI.note20.jpg','Korean','Samsung Note 20',34000000,'Note 20 là sản phẩm mũi nhọn của tập đoàn Samsung với hiệu năng mạnh mẽ, giá thành hợp lý cho phân khúc cao cấp'),(6,'Vinsmart','VkmNg.aris.jpg','Việt Nam','Aris Pro',4500000,'Đây là sản phẩm hàng đầu trong phân khúc giá rẻ. Lượng pin 5000mAh phù hợp để chiến game'),(7,'BKAV','JGBOZ.Bphone3.jpg','Việt Nam','Bphone3',5200000,'Sản phẩm chủ lực của tập đoàn BKAV. Sản phẩm có camera chất đến không thể tin được'),(8,'Xiaomi','Xddyb.redmi8.jpg','China','RedMi Note 8',4300000,'Sản phẩm giá rẻ được sự tin dùng của nhiều khách hàng'),(9,'Xiaomi','Vkcfp.Mi-Note10.jpg','China','Redmi 10',7250000,'Chiếc điện thoại của năm'),(20,'Vin','PqwoZ.download.jpg','VietNam','Vin x',45000000,'Cũng được');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_in_cart`
--

DROP TABLE IF EXISTS `product_in_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_in_cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `madein` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `cart_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq5fiqoevrmlirjqjxs0kvlnqq` (`cart_id`),
  KEY `FKmbb9ii8dfmagbt971nh30ikcm` (`product_id`),
  CONSTRAINT `FKmbb9ii8dfmagbt971nh30ikcm` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKq5fiqoevrmlirjqjxs0kvlnqq` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_in_cart`
--

LOCK TABLES `product_in_cart` WRITE;
/*!40000 ALTER TABLE `product_in_cart` DISABLE KEYS */;
INSERT INTO `product_in_cart` VALUES (12,'Apple','HeYpT.ip12pro-max.jpg','USA','Iphone 12 pro max',37500000,3,20,2),(14,'Apple','CLixT.iphone12-mini.jpg','USA','Iphone 12 mini',21000000,1,20,3),(15,'Samsung','XJRUt.s20.jpg','Korean','Samsung Galaxy S20',2350000,1,21,4),(16,'madein','rMAvG.download.jpg','USA','Nokia C2',3250000,3,21,1),(17,'Vinsmart','VkmNg.aris.jpg','Việt Nam','Aris Pro',4500000,3,23,6),(18,'Xiaomi','Vkcfp.Mi-Note10.jpg','China','Redmi 10',7250000,3,23,9),(19,'Vinsmart','VkmNg.aris.jpg','Việt Nam','Aris Pro',4500000,3,22,6),(20,'Apple','CLixT.iphone12-mini.jpg','USA','Iphone 12 mini',21000000,2,22,3),(21,'x123123123',NULL,'1ss','xxx',23,1,22,9),(22,'Samsung','XJRUt.s20.jpg','Korean','Samsung Galaxy S20',2350000,1,22,4),(23,'Xiaomi','Xddyb.redmi8.jpg','China','RedMi Note 8',4300000,4,24,8),(24,'madein','rMAvG.download.jpg','USA','Nokia C2',3250000,3,24,1),(25,'Apple','CLixT.iphone12-mini.jpg','USA','Iphone 12 mini',21000000,1,24,3),(26,'Apple','HeYpT.ip12pro-max.jpg','USA','Iphone 12 pro max',37500000,4,25,2),(27,'Apple','HeYpT.ip12pro-max.jpg','USA','Iphone 12 pro max',37500000,2,23,2),(28,'Samsung','HuDtI.note20.jpg','Korean','Samsung Note 20',34000000,5,26,5),(29,'madein','rMAvG.download.jpg','USA','Nokia C2',3250000,3,30,1),(30,'Samsung','XJRUt.s20.jpg','Koreanxxx','Samsung Galaxy S20',2350000,1,32,4),(32,'Samsung','HuDtI.note20.jpg','Korean','Samsung Note 20',34000000,5,32,5),(33,NULL,NULL,NULL,NULL,0,1,33,3),(34,NULL,NULL,NULL,NULL,0,2,33,20);
/*!40000 ALTER TABLE `product_in_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `non_block` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'x',_binary '','$2a$10$C0BsH1I8K9iHACUZFB3HGeFXJpvXPEZIAC7JBokOuU8uj4C2sORV6','admin','123445566'),(2,'TiTi',_binary '','$2a$10$oJwmTBtQxjj5S2JEEq7.aOycP1HjfsIrzjB.alstf67oCu/CmZq2y','user','982492312'),(3,'x',_binary '','$2a$10$fbv57MEGRKKzGzvEPdjNXOptZ6rhg/hpt2vXgNJZIsi9vvJ.ZS6l6','bb','783023911'),(4,'testx111',_binary '','$2a$10$rqbeNij1eAjHt3/rNJKFkO7sj.jKUv0V41695z.AkqTac5zlA7uwK','1','962325123'),(7,'serah',_binary '','$2a$10$Xf6iAuD69T/OVEk9F4mZrOb2CTGi1NCk6s/IBzZXqGfxRiAvAQVfS','hai123','123123'),(8,'qq',_binary '','$2a$10$MF2RFU6mm7a5Rb3GBY9.9encwhQgQMtcx0dMgIYUQe.VgbCBscahq','12','123123'),(9,'xqq',_binary '','$2a$10$dLxIyJtxa0B5cwNBcxVpr.dbd3DevsZK8vwbf1uQI75bSEWZXve1O','1xa','09887283133');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2),(3,2),(4,2),(7,2),(8,2),(9,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-18  9:50:13
