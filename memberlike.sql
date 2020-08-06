-- MySQL dump 10.16  Distrib 10.2.31-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: aqua
-- ------------------------------------------------------
-- Server version	10.2.31-MariaDB

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
-- Table structure for table `memberlike`
--

DROP TABLE IF EXISTS `memberlike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memberlike` (
  `LIKE_ID` varchar(20) DEFAULT NULL,
  `LIKE_BOARD_NUM` int(11) DEFAULT NULL,
  `LIKE_OK` int(11) DEFAULT NULL,
  KEY `LIKE_BOARD_NUM` (`LIKE_BOARD_NUM`),
  CONSTRAINT `memberlike_ibfk_1` FOREIGN KEY (`LIKE_BOARD_NUM`) REFERENCES `memberboard` (`BOARD_NUM`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberlike`
--

LOCK TABLES `memberlike` WRITE;
/*!40000 ALTER TABLE `memberlike` DISABLE KEYS */;
INSERT INTO `memberlike` VALUES ('aaa',168,1),('ccc',168,1),('tyranno',161,1),('tyranno',166,1),('tyranno',169,1),('tyranno',170,1),('tyranno',168,1),('enk0206',170,1),('enk0206',169,1),('enk0206',168,1),('enk0206',167,1),('enk0206',166,1),('ccc',171,1),('ccc',166,1),('aaa',169,1),('aaa',170,1),('testid',171,1),('tyranno',172,1),('tyranno',171,1),('tyranno',167,1),('tyranno',180,1),('tyranno',179,1),('tyranno',178,1),('tyranno',177,1),('tyranno',176,1),('tyranno',175,1),('tyranno',174,1),('tyranno',173,1),('aaa',180,1),('aaa',179,1),('aaa',178,1),('aaa',177,1),('aaa',173,1),('aaa',171,1),('testId',180,1),('testId',187,1),('testId',186,1),('tyranno',186,1),('aaa',187,1),('tyranno',187,1);
/*!40000 ALTER TABLE `memberlike` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-26 14:27:46
