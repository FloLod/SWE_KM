CREATE DATABASE  IF NOT EXISTS `waterfall` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `waterfall`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: waterfall
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `actvityID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `duration` int(11) NOT NULL,
  PRIMARY KEY (`actvityID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'tag1',2),(2,'tag2',2),(3,'tag3',2),(4,'tag4',2),(5,'tag5',2);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `user_userID` int(11) DEFAULT NULL,
  PRIMARY KEY (`adminID`),
  KEY `FK_4qv1lwx6bmvma70d9jox04t4b` (`user_userID`),
  CONSTRAINT `FK_4qv1lwx6bmvma70d9jox04t4b` FOREIGN KEY (`user_userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,4);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `AppointmentID` int(11) NOT NULL AUTO_INCREMENT,
  `end` datetime DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `appointmentType_appointmentTypeID` int(11) DEFAULT NULL,
  `content_contentID` int(11) DEFAULT NULL,
  `text_textID` int(11) DEFAULT NULL,
  PRIMARY KEY (`AppointmentID`),
  KEY `FK_l9rhoe2i4sfg0qe20a1lkhwm7` (`appointmentType_appointmentTypeID`),
  KEY `FK_plwktr3knl6ec9iq6jggnjn8x` (`content_contentID`),
  KEY `FK_i977tenae5nq7rcdo9oa2em1l` (`text_textID`),
  CONSTRAINT `FK_i977tenae5nq7rcdo9oa2em1l` FOREIGN KEY (`text_textID`) REFERENCES `text` (`textID`),
  CONSTRAINT `FK_l9rhoe2i4sfg0qe20a1lkhwm7` FOREIGN KEY (`appointmentType_appointmentTypeID`) REFERENCES `appointmenttype` (`appointmentTypeID`),
  CONSTRAINT `FK_plwktr3knl6ec9iq6jggnjn8x` FOREIGN KEY (`content_contentID`) REFERENCES `content` (`contentID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,'2017-02-13 16:45:00','2017-02-13 13:30:00',1,2,1);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointmenttype`
--

DROP TABLE IF EXISTS `appointmenttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointmenttype` (
  `appointmentTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`appointmentTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointmenttype`
--

LOCK TABLES `appointmenttype` WRITE;
/*!40000 ALTER TABLE `appointmenttype` DISABLE KEYS */;
INSERT INTO `appointmenttype` VALUES (1,'Veranstalungen rund ums Studium','Studienveranstaltung');
/*!40000 ALTER TABLE `appointmenttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blocklist`
--

DROP TABLE IF EXISTS `blocklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blocklist` (
  `blockListID` int(11) NOT NULL AUTO_INCREMENT,
  `endDate` datetime DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `student_studentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`blockListID`),
  KEY `FK_ms0pyb73p7wdqo0l4y0elfchr` (`student_studentID`),
  CONSTRAINT `FK_ms0pyb73p7wdqo0l4y0elfchr` FOREIGN KEY (`student_studentID`) REFERENCES `student` (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blocklist`
--

LOCK TABLES `blocklist` WRITE;
/*!40000 ALTER TABLE `blocklist` DISABLE KEYS */;
INSERT INTO `blocklist` VALUES (1,'2017-03-31 00:00:00','trolling',2);
/*!40000 ALTER TABLE `blocklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  `text_textID` int(11) DEFAULT NULL,
  PRIMARY KEY (`categoryID`),
  KEY `FK_pqrlb05eqdi1oi9oq9k3djcb5` (`text_textID`),
  CONSTRAINT `FK_pqrlb05eqdi1oi9oq9k3djcb5` FOREIGN KEY (`text_textID`) REFERENCES `text` (`textID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,3);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content` (
  `contentID` int(11) NOT NULL AUTO_INCREMENT,
  `canged` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `contentType_contentTypeID` int(11) DEFAULT NULL,
  `creatorStudent_studentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`contentID`),
  KEY `FK_qxmpbuxxk0pyirf5d186osmcc` (`contentType_contentTypeID`),
  KEY `FK_jh3gey9uqwt22jri77v5ygt0h` (`creatorStudent_studentID`),
  CONSTRAINT `FK_jh3gey9uqwt22jri77v5ygt0h` FOREIGN KEY (`creatorStudent_studentID`) REFERENCES `student` (`studentID`),
  CONSTRAINT `FK_qxmpbuxxk0pyirf5d186osmcc` FOREIGN KEY (`contentType_contentTypeID`) REFERENCES `contenttype` (`contentTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
INSERT INTO `content` VALUES (1,'2017-01-30 00:00:00','2017-02-05 00:00:00',1,1),(2,'2017-02-11 00:00:00','2017-02-11 00:00:00',2,1),(3,'2015-02-11 00:00:00','2017-02-11 00:00:00',3,1),(4,'2017-02-11 00:00:00','2017-02-11 00:00:00',4,1),(5,'2017-02-11 00:00:00','2017-02-11 00:00:00',5,1);
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenttype`
--

DROP TABLE IF EXISTS `contenttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contenttype` (
  `contentTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `KarmaReward` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `studentClass_classID` int(11) DEFAULT NULL,
  PRIMARY KEY (`contentTypeID`),
  KEY `FK_3i5mx43q97b9bw71omoae1wvm` (`studentClass_classID`),
  CONSTRAINT `FK_3i5mx43q97b9bw71omoae1wvm` FOREIGN KEY (`studentClass_classID`) REFERENCES `studentclass` (`classID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenttype`
--

LOCK TABLES `contenttype` WRITE;
/*!40000 ALTER TABLE `contenttype` DISABLE KEYS */;
INSERT INTO `contenttype` VALUES (1,10,'Nachweiß',1),(2,5,'Termin',1),(3,50,'Stundenplan',1),(4,15,'Frage',1),(5,20,'Antwort',1);
/*!40000 ALTER TABLE `contenttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educationdiary`
--

DROP TABLE IF EXISTS `educationdiary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educationdiary` (
  `educationDiaryID` int(11) NOT NULL AUTO_INCREMENT,
  `endDate` datetime DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `weeek` int(11) NOT NULL,
  `content_contentID` int(11) DEFAULT NULL,
  `list_EducationDiaryList` int(11) DEFAULT NULL,
  `studentClass_classID` int(11) DEFAULT NULL,
  PRIMARY KEY (`educationDiaryID`),
  KEY `FK_slj5wbcpfd3824eow3ykp93cu` (`content_contentID`),
  KEY `FK_n681lvtuun23m735pox8fut2m` (`list_EducationDiaryList`),
  KEY `FK_d5gm8va6a3tie4h3g6x7su6b5` (`studentClass_classID`),
  CONSTRAINT `FK_d5gm8va6a3tie4h3g6x7su6b5` FOREIGN KEY (`studentClass_classID`) REFERENCES `studentclass` (`classID`),
  CONSTRAINT `FK_n681lvtuun23m735pox8fut2m` FOREIGN KEY (`list_EducationDiaryList`) REFERENCES `educationdiarylist` (`EducationDiaryList`),
  CONSTRAINT `FK_slj5wbcpfd3824eow3ykp93cu` FOREIGN KEY (`content_contentID`) REFERENCES `content` (`contentID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educationdiary`
--

LOCK TABLES `educationdiary` WRITE;
/*!40000 ALTER TABLE `educationdiary` DISABLE KEYS */;
INSERT INTO `educationdiary` VALUES (1,'2017-01-30 00:00:00','2017-02-05 00:00:00',2,1,1,1);
/*!40000 ALTER TABLE `educationdiary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educationdiaryday`
--

DROP TABLE IF EXISTS `educationdiaryday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educationdiaryday` (
  `day` int(11) NOT NULL,
  `educationDiaryID_educationDiaryID` int(11) NOT NULL,
  PRIMARY KEY (`day`,`educationDiaryID_educationDiaryID`),
  KEY `FK_b5dt3eeurxvfx9q414cj0cq3u` (`educationDiaryID_educationDiaryID`),
  CONSTRAINT `FK_b5dt3eeurxvfx9q414cj0cq3u` FOREIGN KEY (`educationDiaryID_educationDiaryID`) REFERENCES `educationdiary` (`educationDiaryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educationdiaryday`
--

LOCK TABLES `educationdiaryday` WRITE;
/*!40000 ALTER TABLE `educationdiaryday` DISABLE KEYS */;
INSERT INTO `educationdiaryday` VALUES (1,1);
/*!40000 ALTER TABLE `educationdiaryday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educationdiaryday_activity`
--

DROP TABLE IF EXISTS `educationdiaryday_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educationdiaryday_activity` (
  `EducationDiaryDay_day` int(11) NOT NULL,
  `EducationDiaryDay_educationDiaryID_educationDiaryID` int(11) NOT NULL,
  `activity_actvityID` int(11) NOT NULL,
  UNIQUE KEY `UK_qj0cpdpy2ogum6gan9ur4swms` (`activity_actvityID`),
  KEY `FK_qj0cpdpy2ogum6gan9ur4swms` (`activity_actvityID`),
  KEY `FK_m1bcgt1eyo5ciu6cqef479on2` (`EducationDiaryDay_day`,`EducationDiaryDay_educationDiaryID_educationDiaryID`),
  CONSTRAINT `FK_m1bcgt1eyo5ciu6cqef479on2` FOREIGN KEY (`EducationDiaryDay_day`, `EducationDiaryDay_educationDiaryID_educationDiaryID`) REFERENCES `educationdiaryday` (`day`, `educationDiaryID_educationDiaryID`),
  CONSTRAINT `FK_qj0cpdpy2ogum6gan9ur4swms` FOREIGN KEY (`activity_actvityID`) REFERENCES `activity` (`actvityID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educationdiaryday_activity`
--

LOCK TABLES `educationdiaryday_activity` WRITE;
/*!40000 ALTER TABLE `educationdiaryday_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `educationdiaryday_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educationdiarylist`
--

DROP TABLE IF EXISTS `educationdiarylist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educationdiarylist` (
  `EducationDiaryList` int(11) NOT NULL AUTO_INCREMENT,
  `studentClass_classID` int(11) DEFAULT NULL,
  `studentResponsible_studentID` int(11) DEFAULT NULL,
  `classID` int(11) DEFAULT NULL,
  PRIMARY KEY (`EducationDiaryList`),
  KEY `FK_lfe2nrgjju02wx5v6x7f5txe2` (`studentClass_classID`),
  KEY `FK_a4yw2b3npa651onoqjerq7p1c` (`studentResponsible_studentID`),
  KEY `FK_pbxc1738g1asw1acw30sio4sr` (`classID`),
  CONSTRAINT `FK_a4yw2b3npa651onoqjerq7p1c` FOREIGN KEY (`studentResponsible_studentID`) REFERENCES `student` (`studentID`),
  CONSTRAINT `FK_lfe2nrgjju02wx5v6x7f5txe2` FOREIGN KEY (`studentClass_classID`) REFERENCES `studentclass` (`classID`),
  CONSTRAINT `FK_pbxc1738g1asw1acw30sio4sr` FOREIGN KEY (`classID`) REFERENCES `studentclass` (`classID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educationdiarylist`
--

LOCK TABLES `educationdiarylist` WRITE;
/*!40000 ALTER TABLE `educationdiarylist` DISABLE KEYS */;
INSERT INTO `educationdiarylist` VALUES (1,1,1,NULL);
/*!40000 ALTER TABLE `educationdiarylist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educationdiarylist_educationdiary`
--

DROP TABLE IF EXISTS `educationdiarylist_educationdiary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educationdiarylist_educationdiary` (
  `EducationDiaryList_EducationDiaryList` int(11) NOT NULL,
  `educationDiary_educationDiaryID` int(11) NOT NULL,
  UNIQUE KEY `UK_ms4pbtmydso4gchd78hq353v2` (`educationDiary_educationDiaryID`),
  KEY `FK_ms4pbtmydso4gchd78hq353v2` (`educationDiary_educationDiaryID`),
  KEY `FK_m3favjdpfjb0u96hh3qlrxlxs` (`EducationDiaryList_EducationDiaryList`),
  CONSTRAINT `FK_m3favjdpfjb0u96hh3qlrxlxs` FOREIGN KEY (`EducationDiaryList_EducationDiaryList`) REFERENCES `educationdiarylist` (`EducationDiaryList`),
  CONSTRAINT `FK_ms4pbtmydso4gchd78hq353v2` FOREIGN KEY (`educationDiary_educationDiaryID`) REFERENCES `educationdiary` (`educationDiaryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educationdiarylist_educationdiary`
--

LOCK TABLES `educationdiarylist_educationdiary` WRITE;
/*!40000 ALTER TABLE `educationdiarylist_educationdiary` DISABLE KEYS */;
INSERT INTO `educationdiarylist_educationdiary` VALUES (1,1);
/*!40000 ALTER TABLE `educationdiarylist_educationdiary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `fileID` int(11) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) DEFAULT NULL,
  `content_contentID` int(11) DEFAULT NULL,
  `text_textID` int(11) DEFAULT NULL,
  PRIMARY KEY (`fileID`),
  KEY `FK_b2a5myp4ri01at8v5t6rcrbo7` (`content_contentID`),
  KEY `FK_i1cje971gadwxcewhcfxkbav0` (`text_textID`),
  CONSTRAINT `FK_b2a5myp4ri01at8v5t6rcrbo7` FOREIGN KEY (`content_contentID`) REFERENCES `content` (`contentID`),
  CONSTRAINT `FK_i1cje971gadwxcewhcfxkbav0` FOREIGN KEY (`text_textID`) REFERENCES `text` (`textID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,'Stundenplan Klasse1',3,2);
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `likes` (
  `likesID` int(11) NOT NULL AUTO_INCREMENT,
  `student_studentID` int(11) NOT NULL,
  `content_contentID` int(11) NOT NULL,
  PRIMARY KEY (`likesID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,1,1);
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `notificationID` int(11) NOT NULL AUTO_INCREMENT,
  `notificationType_notificationTypeID` int(11) DEFAULT NULL,
  `student_userID` int(11) DEFAULT NULL,
  `text_textID` int(11) DEFAULT NULL,
  PRIMARY KEY (`notificationID`),
  KEY `FK_c0iweher512l6s0w5rydisusq` (`notificationType_notificationTypeID`),
  KEY `FK_kpv4w2fa7k6394fd3s01v8k68` (`student_userID`),
  KEY `FK_5vb6jg2vh7oqc0p0sft2dcgtt` (`text_textID`),
  CONSTRAINT `FK_5vb6jg2vh7oqc0p0sft2dcgtt` FOREIGN KEY (`text_textID`) REFERENCES `text` (`textID`),
  CONSTRAINT `FK_c0iweher512l6s0w5rydisusq` FOREIGN KEY (`notificationType_notificationTypeID`) REFERENCES `notificationtype` (`notificationTypeID`),
  CONSTRAINT `FK_kpv4w2fa7k6394fd3s01v8k68` FOREIGN KEY (`student_userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,1,1,6);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificationtype`
--

DROP TABLE IF EXISTS `notificationtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notificationtype` (
  `notificationTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`notificationTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificationtype`
--

LOCK TABLES `notificationtype` WRITE;
/*!40000 ALTER TABLE `notificationtype` DISABLE KEYS */;
INSERT INTO `notificationtype` VALUES (1,'Nachweiß fällig');
/*!40000 ALTER TABLE `notificationtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `questionID` int(11) NOT NULL AUTO_INCREMENT,
  `category_categoryID` int(11) DEFAULT NULL,
  `content_contentID` int(11) DEFAULT NULL,
  `text_textID` int(11) DEFAULT NULL,
  PRIMARY KEY (`questionID`),
  KEY `FK_l3f98x1dlxxtefctyfc8kkdoi` (`category_categoryID`),
  KEY `FK_3cb4ybec2ep9cgigsw2nab5bf` (`content_contentID`),
  KEY `FK_2r5xxsygao6e3wx74douryyu5` (`text_textID`),
  CONSTRAINT `FK_2r5xxsygao6e3wx74douryyu5` FOREIGN KEY (`text_textID`) REFERENCES `text` (`textID`),
  CONSTRAINT `FK_3cb4ybec2ep9cgigsw2nab5bf` FOREIGN KEY (`content_contentID`) REFERENCES `content` (`contentID`),
  CONSTRAINT `FK_l3f98x1dlxxtefctyfc8kkdoi` FOREIGN KEY (`category_categoryID`) REFERENCES `category` (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,1,4,4);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply` (
  `replyID` int(11) NOT NULL AUTO_INCREMENT,
  `content_contentID` int(11) DEFAULT NULL,
  `question_questionID` int(11) DEFAULT NULL,
  `text_textID` int(11) DEFAULT NULL,
  PRIMARY KEY (`replyID`),
  KEY `FK_nfv1rituag93d0lavuotttlub` (`content_contentID`),
  KEY `FK_allhbm712arhjbmb715dil1bp` (`question_questionID`),
  KEY `FK_e8av2jdrl0uxj1cgmksrlouun` (`text_textID`),
  CONSTRAINT `FK_allhbm712arhjbmb715dil1bp` FOREIGN KEY (`question_questionID`) REFERENCES `question` (`questionID`),
  CONSTRAINT `FK_e8av2jdrl0uxj1cgmksrlouun` FOREIGN KEY (`text_textID`) REFERENCES `text` (`textID`),
  CONSTRAINT `FK_nfv1rituag93d0lavuotttlub` FOREIGN KEY (`content_contentID`) REFERENCES `content` (`contentID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,5,1,5);
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `studentID` int(11) NOT NULL AUTO_INCREMENT,
  `classSpeaker` tinyint(1) NOT NULL,
  `karma` int(11) NOT NULL,
  `companyPicture_fileID` int(11) DEFAULT NULL,
  `studentClass_classID` int(11) DEFAULT NULL,
  `user_userID` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentID`),
  KEY `FK_3cqxj15pv0ym0o4rxs7acvhli` (`companyPicture_fileID`),
  KEY `FK_ki8a4pvvffegbeyppi658pdix` (`studentClass_classID`),
  KEY `FK_5r8celocd77gttrg7wdpkuhhl` (`user_userID`),
  CONSTRAINT `FK_3cqxj15pv0ym0o4rxs7acvhli` FOREIGN KEY (`companyPicture_fileID`) REFERENCES `file` (`fileID`),
  CONSTRAINT `FK_5r8celocd77gttrg7wdpkuhhl` FOREIGN KEY (`user_userID`) REFERENCES `user` (`userID`),
  CONSTRAINT `FK_ki8a4pvvffegbeyppi658pdix` FOREIGN KEY (`studentClass_classID`) REFERENCES `studentclass` (`classID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,1,100,NULL,1,1),(2,1,3200,NULL,1,2),(3,0,10,NULL,1,3);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentappointment`
--

DROP TABLE IF EXISTS `studentappointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentappointment` (
  `StudentAppointmentID` int(11) NOT NULL AUTO_INCREMENT,
  `appointment_AppointmentID` int(11) DEFAULT NULL,
  `student_studentID` int(11) DEFAULT NULL,
  `studentClass_classID` int(11) DEFAULT NULL,
  PRIMARY KEY (`StudentAppointmentID`),
  KEY `FK_fqj35dhhhh6aaswoilwmvyx8m` (`appointment_AppointmentID`),
  KEY `FK_ldqo727pdt5fdaj0jaudh6gxy` (`student_studentID`),
  KEY `FK_qdd63cnxxdbqktmj2imyxclsm` (`studentClass_classID`),
  CONSTRAINT `FK_fqj35dhhhh6aaswoilwmvyx8m` FOREIGN KEY (`appointment_AppointmentID`) REFERENCES `appointment` (`AppointmentID`),
  CONSTRAINT `FK_ldqo727pdt5fdaj0jaudh6gxy` FOREIGN KEY (`student_studentID`) REFERENCES `student` (`studentID`),
  CONSTRAINT `FK_qdd63cnxxdbqktmj2imyxclsm` FOREIGN KEY (`studentClass_classID`) REFERENCES `studentclass` (`classID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentappointment`
--

LOCK TABLES `studentappointment` WRITE;
/*!40000 ALTER TABLE `studentappointment` DISABLE KEYS */;
INSERT INTO `studentappointment` VALUES (1,1,1,1);
/*!40000 ALTER TABLE `studentappointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentclass`
--

DROP TABLE IF EXISTS `studentclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentclass` (
  `classID` int(11) NOT NULL AUTO_INCREMENT,
  `educationPath` varchar(255) DEFAULT NULL,
  `year` datetime DEFAULT NULL,
  PRIMARY KEY (`classID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentclass`
--

LOCK TABLES `studentclass` WRITE;
/*!40000 ALTER TABLE `studentclass` DISABLE KEYS */;
INSERT INTO `studentclass` VALUES (1,'FS',NULL),(2,'FI',NULL);
/*!40000 ALTER TABLE `studentclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `text`
--

DROP TABLE IF EXISTS `text`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `text` (
  `textID` int(11) NOT NULL AUTO_INCREMENT,
  `heading` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`textID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `text`
--

LOCK TABLES `text` WRITE;
/*!40000 ALTER TABLE `text` DISABLE KEYS */;
INSERT INTO `text` VALUES (1,'SWE','Erstellung einer Webapp'),(2,'Studenplan','Stundenplan im ersten Ausbildungsjahr in der Berufsschule'),(3,'Webentwicklung','Java Webentwicklung'),(4,'Sollte Java Properties unterstützen?','Die Alternative C# besitzt Properties, diese gibt es jedoch nicht in Java, wie fändet ihr eine Umsetzung diese Konzeptes?'),(5,'Troll','STRG + F'),(6,'Du bis mit dem nächstne Nachweiß dran','Bitte schreibe den nächsten Nachweiß und lade ihn hoch');
/*!40000 ALTER TABLE `text` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetable` (
  `timeTableID` int(11) NOT NULL AUTO_INCREMENT,
  `endDate` datetime DEFAULT NULL,
  `startingDate` datetime DEFAULT NULL,
  `file_fileID` int(11) DEFAULT NULL,
  `studentClass_classID` int(11) DEFAULT NULL,
  PRIMARY KEY (`timeTableID`),
  KEY `FK_1cf8am1k698g5g51ie8q1o49u` (`file_fileID`),
  KEY `FK_8ng0i14m0sqncxjylf5tahroe` (`studentClass_classID`),
  CONSTRAINT `FK_1cf8am1k698g5g51ie8q1o49u` FOREIGN KEY (`file_fileID`) REFERENCES `file` (`fileID`),
  CONSTRAINT `FK_8ng0i14m0sqncxjylf5tahroe` FOREIGN KEY (`studentClass_classID`) REFERENCES `studentclass` (`classID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
INSERT INTO `timetable` VALUES (1,'2017-08-31 00:00:00','2016-09-01 00:00:00',1,1);
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unlockedcontent`
--

DROP TABLE IF EXISTS `unlockedcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unlockedcontent` (
  `content_contentID` int(11) NOT NULL,
  `userID_userID` int(11) NOT NULL,
  PRIMARY KEY (`content_contentID`,`userID_userID`),
  KEY `FK_o139e25rup7645onga5q7m9id` (`content_contentID`),
  KEY `FK_r4iuop6sc1q0upfo9lbijnawm` (`userID_userID`),
  CONSTRAINT `FK_o139e25rup7645onga5q7m9id` FOREIGN KEY (`content_contentID`) REFERENCES `content` (`contentID`),
  CONSTRAINT `FK_r4iuop6sc1q0upfo9lbijnawm` FOREIGN KEY (`userID_userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unlockedcontent`
--

LOCK TABLES `unlockedcontent` WRITE;
/*!40000 ALTER TABLE `unlockedcontent` DISABLE KEYS */;
/*!40000 ALTER TABLE `unlockedcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `eMail` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastLogin` datetime DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test@test.com','Max',NULL,'Mustermann','Geheim'),(2,'blocked@education-siemens.com','Timo',NULL,'Böse','Geheim'),(3,'short@short.com','Short',NULL,'Short','Geheim'),(4,'admin@education-siemens.com','Armin',NULL,'Admin','Geheim');
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

-- Dump completed on 2017-02-02 20:12:47
