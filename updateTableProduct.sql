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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'madein','rMAvG.download.jpg','USA','Nokia C2',3250000,'Điện thoại vừa đẹp, vừa bền'),(2,'Apple','HeYpT.ip12pro-max.jpg','USA','Iphone 12 pro max',37500000,'Iphone 12 đẳng cấp thế giới, màn hình tuyệt vời, pin siêu trâu chiến game liên tục'),(3,'Apple','CLixT.iphone12-mini.jpg','USA','Iphone 12 mini',21000000,'Iphone 12 mini nhỏ gọn, giá cả phải chăng mà cũng rất cao cấp, sử dụng oke'),(4,'Samsung','XJRUt.s20.jpg','Korean','Samsung Galaxy S20',2350000,'SS S20 mang đến những công nghệ hàng đầu của dòng điện thoại Androi, sản phẩm rất đáng mua trong năm 2021'),(5,'Samsung','HuDtI.note20.jpg','Korean','Samsung Note 20',34000000,'Note 20 là sản phẩm mũi nhọn của tập đoàn Samsung với hiệu năng mạnh mẽ, giá thành hợp lý cho phân khúc cao cấp'),(6,'Vinsmart','VkmNg.aris.jpg','Việt Nam','Aris Pro',4500000,'Đây là sản phẩm hàng đầu trong phân khúc giá rẻ. Lượng pin 5000mAh phù hợp để chiến game'),(7,'BKAV','JGBOZ.Bphone3.jpg','Việt Nam','Bphone3',5200000,'Sản phẩm chủ lực của tập đoàn BKAV. Sản phẩm có camera chất đến không thể tin được'),(8,'Xiaomi','Xddyb.redmi8.jpg','China','RedMi Note 8',4300000,'Sản phẩm giá rẻ được sự tin dùng của nhiều khách hàng'),(9,'Xiaomi','okuyr.Mi-Note10.jpg','China','RedMi Note 10',6000000,'Sản phẩm ở phâm khúc trung cấp, cận cao cấp nhưng được rất nhiều khách hàng ủng hộ');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-19  9:44:39
