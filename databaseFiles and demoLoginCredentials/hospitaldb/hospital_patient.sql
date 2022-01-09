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
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `registrationDate` date DEFAULT NULL,
  `pid` varchar(255) NOT NULL,
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
  `bloodGroup` varchar(5) DEFAULT NULL,
  `chronicDiseases` varchar(255) DEFAULT NULL,
  `medicineAllergy` varchar(255) DEFAULT NULL,
  `doctorId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `emailID` (`emailID`),
  UNIQUE KEY `adharNo` (`adharNo`),
  KEY `fk_assigned_doctorid` (`doctorId`),
  CONSTRAINT `fk_assigned_doctorid` FOREIGN KEY (`doctorId`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('2020-06-21','P101','ashlesha','atul','narkhede','1990-04-12','female','ashlesha@gmail.com',1989478593,901238756123,'india','maharashtra','nashik','bhabha nagar','bhabha nagar','A+','none','bluemox','EMP101'),('2020-06-21','P102','ritu','yuvraj','mahajan','1990-05-02','female','ritu@gmail.com',9823475901,109478563215,'india','maharashtra','nashik','uttam nagar','uttam nagar','B-','diabetes','none','EMP103'),('2020-06-21','P103','siddhi','pramod','patil','1991-05-17','female','siddhi@gmail.com',9847382091,823947610019,'india','maharashtra','nashik','happy house apartment','happy house apartment','O+','none','none','EMP102'),('2020-06-21','P104','kusum','pawan','hiray','1973-06-28','female','kusum@gmail.com',9478301834,728001823453,'india','maharashtra','nashik','panchavati, nashik','panchavati, nashik','AB+','diabetes','none','EMP101'),('2021-12-06','P105','anand','nitin','shirole','2000-08-10','male','anand123@gmail.com',9023710243,450123948572,'india','maharashtra','pune','bibewadi','bibewadi','AB+','none','none','EMP101');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
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
