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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `joiningDate` date DEFAULT NULL,
  `eid` varchar(255) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `middleName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `birthdate` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `emailID` varchar(255) DEFAULT NULL,
  `mobileno` bigint(20) DEFAULT NULL,
  `adharNo` bigint(20) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `residentialAddress` varchar(255) DEFAULT NULL,
  `permanentAddress` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  UNIQUE KEY `emailID` (`emailID`),
  UNIQUE KEY `adharNo` (`adharNo`),
  UNIQUE KEY `mobileno` (`mobileno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('2020-06-21','EMP101','neelima','arun','pawar','1975-01-07','female','neelima@gmail.com',9013456893,143590034912,'india','maharashtra','nashik','vandana apartment, nashik','vandana apartment, nashik','doctor','mbbs, md','gynacologist',1),('2020-06-21','EMP102','arun','nanaji','pawar','1978-05-12','male','arun@gmail.com',9800274565,409285671923,'india','maharashtra','nashik','kamod nagar','kamod nagar','doctor','mbbs','none',0),('2020-06-21','EMP103','jagannath','yadav','suryawanshi','1990-03-07','male','jagannath@gmail.com',9028823456,103758492134,'india','maharashtra','aurangabad','gajanan banglow nashik','rushika niwas','doctor','ms','surgery',1),('2020-06-21','EMP104','riddhi','arun','pawar','1990-03-09','female','riddhi@gmail.com',9567834245,345600189345,'india','maharashtra','pune','damodar heights','damodar heights','administrator','be','computer science',1),('2020-06-21','EMP105','neha','ravindra','kothawade','1992-02-14','female','neha@gmail.com',1234567890,920385967123,'india','maharashtra','nashik','narayani bunglow','narayani bunglow','receptionist','be','computer',1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
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
