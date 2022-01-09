-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `opddetails`
--

DROP TABLE IF EXISTS `opddetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opddetails` (
  `opdid` int(11) DEFAULT NULL,
  `symptoms` varchar(255) DEFAULT NULL,
  `diagnosis` varchar(255) DEFAULT NULL,
  `medicinesDose` varchar(255) DEFAULT NULL,
  `dos` varchar(255) DEFAULT NULL,
  `donts` varchar(255) DEFAULT NULL,
  `investigations` varchar(255) DEFAULT NULL,
  `followupDate` varchar(255) DEFAULT NULL,
  `fees` varchar(255) DEFAULT NULL,
  KEY `fk_opdid` (`opdid`),
  CONSTRAINT `fk_opdid` FOREIGN KEY (`opdid`) REFERENCES `opd` (`opdid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opddetails`
--

LOCK TABLES `opddetails` WRITE;
/*!40000 ALTER TABLE `opddetails` DISABLE KEYS */;
INSERT INTO `opddetails` VALUES (1,'#headache #bodypain','weakness','#crocin@2 #neutrolin-B@3','#drink warm water','#junk food','none','2020-06-20','200'),(13,'# high fever #nausea #headache #weakness','viral fever','#crocin-500@2 #neutrolin-B@1','#drink warm water ','#avoid fried or cool food item','none','2021-12-16','300'),(14,'#weakness #nausea','fever','#meftal spas@2','#rest','#cold food items','none','2021-12-23','700'),(7,'#abdominal pain #fever #nausea','typhoid','#crocin500@2  #meftal spas@2 #ofloxine500@1','#rest #eat dal-chaval #warm water','#oily food #cold drinks','blood test','2020-06-26','500');
/*!40000 ALTER TABLE `opddetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-09 16:07:30
