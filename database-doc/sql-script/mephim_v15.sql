CREATE DATABASE  IF NOT EXISTS `mephim` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mephim`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: mephim
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor` (
  `actor_id` int NOT NULL AUTO_INCREMENT,
  `actor_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`actor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` VALUES (1,'Trần Anh Hùng'),(2,'Vũ Ngọc Đãng'),(3,'Nguyễn Quang Dũng'),(4,'Charlie Nguyễn');
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `time` varchar(255) DEFAULT NULL,
  `booking_status_id` int DEFAULT NULL,
  `seat_id` int DEFAULT NULL,
  `ticket_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `point` int DEFAULT NULL,
  `point_of_use` int DEFAULT NULL,
  `reward_point` int DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FKm3d0q9s1hos02eamx9wrsupaq` (`booking_status_id`),
  KEY `FK7ryitbom1ln9okwlj2t9tt9ym` (`seat_id`),
  KEY `FKte7386dwsq1v3bgg8bbfe9nuq` (`ticket_id`),
  KEY `FK7udbel7q86k041591kj6lfmvw` (`user_id`),
  CONSTRAINT `FK7ryitbom1ln9okwlj2t9tt9ym` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`seat_id`),
  CONSTRAINT `FK7udbel7q86k041591kj6lfmvw` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKm3d0q9s1hos02eamx9wrsupaq` FOREIGN KEY (`booking_status_id`) REFERENCES `booking_status` (`booking_status_id`),
  CONSTRAINT `FKte7386dwsq1v3bgg8bbfe9nuq` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`ticket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (3,'2023-03-06 10:17:56',1,236,17,7,20,NULL,NULL),(4,'2023-03-06 10:17:56',1,235,17,7,20,NULL,NULL),(5,'2023-03-06 10:18:17',1,234,17,7,20,NULL,NULL),(6,'2023-03-06 10:18:17',1,233,17,7,20,NULL,NULL),(7,'2023-03-06 10:18:51',1,229,17,7,20,NULL,NULL),(8,'2023-03-06 10:18:51',1,230,17,7,20,NULL,NULL),(9,'2023-03-06 10:18:51',1,231,17,7,20,NULL,NULL),(10,'2023-03-06 14:39:16',1,221,17,8,20,NULL,NULL),(11,'2023-03-06 14:39:16',1,222,17,8,20,NULL,NULL),(12,'2023-03-06 14:39:16',1,223,17,8,20,NULL,NULL),(13,'2023-03-17 15:18:11',1,221,15,7,20,NULL,NULL),(14,'2023-03-17 15:18:11',1,222,15,7,20,NULL,NULL),(15,'2023-03-17 15:18:11',1,223,15,7,20,NULL,NULL),(16,'2023-03-17 15:18:11',1,224,15,7,20,NULL,NULL),(17,'2023-03-17 15:20:37',1,1,4,7,20,NULL,NULL),(18,'2023-03-17 15:20:37',1,2,4,7,20,NULL,NULL),(19,'2023-03-17 15:20:37',1,3,4,7,20,NULL,NULL),(20,'2023-04-05 15:03:42',1,221,8,7,NULL,0,7700),(21,'2023-04-05 15:03:42',1,222,8,7,NULL,0,7700),(22,'2023-04-05 15:03:42',1,223,8,7,NULL,0,7700),(23,'2023-04-05 16:24:48',1,101,44,7,NULL,0,5235),(24,'2023-04-05 16:24:48',1,102,44,7,NULL,0,5235),(25,'2023-04-05 17:10:19',1,113,44,7,NULL,0,5235),(26,'2023-04-05 17:10:19',1,114,44,7,NULL,0,5235),(27,'2023-04-05 17:12:40',1,103,44,7,NULL,52355,0),(28,'2023-04-05 17:12:40',1,127,44,7,NULL,52355,0),(29,'2023-04-05 17:13:57',1,138,44,7,NULL,52355,-47120),(30,'2023-04-05 17:13:57',1,151,44,7,NULL,52355,-47120),(31,'2023-04-05 17:13:57',1,209,44,7,NULL,52355,-47120),(32,'2023-04-05 17:16:34',1,105,44,7,NULL,52355,-47120),(33,'2023-04-05 17:16:34',1,106,44,7,NULL,52355,-47120),(34,'2023-04-27 14:17:15',1,107,44,7,NULL,0,5235),(35,'2023-04-27 14:17:15',1,108,44,7,NULL,0,5235),(36,'2023-05-04 09:46:36',1,197,22,7,NULL,0,5235),(37,'2023-05-04 09:46:36',1,198,22,7,NULL,0,5235),(38,'2023-05-04 09:46:36',1,199,22,7,NULL,0,5235),(39,'2023-05-04 09:46:36',1,200,22,7,NULL,0,5235);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_status`
--

DROP TABLE IF EXISTS `booking_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_status` (
  `booking_status_id` int NOT NULL AUTO_INCREMENT,
  `booking_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`booking_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_status`
--

LOCK TABLES `booking_status` WRITE;
/*!40000 ALTER TABLE `booking_status` DISABLE KEYS */;
INSERT INTO `booking_status` VALUES (1,'PENDING'),(2,'APPROVAL');
/*!40000 ALTER TABLE `booking_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  `last_modify` varchar(255) DEFAULT NULL,
  `modify_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Tình cảm',NULL,NULL),(2,'Kinh dị',NULL,NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movie_id` int NOT NULL AUTO_INCREMENT,
  `movie_description` varchar(255) DEFAULT NULL,
  `movie_director` varchar(255) DEFAULT NULL,
  `movie_length` int DEFAULT NULL,
  `movie_name` varchar(255) DEFAULT NULL,
  `movie_poster` varchar(255) DEFAULT NULL,
  `movie_trailer_url` varchar(255) DEFAULT NULL,
  `movie_actor` varchar(255) DEFAULT NULL,
  `last_modify` varchar(255) DEFAULT NULL,
  `modify_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Phim việt nam','Lê Công Hậu',102,'GIAI ĐIỆU NÀO ANH CŨNG BIẾT TUỐT','https://firebasestorage.googleapis.com/v0/b/mephim-cf569.appspot.com/o/images%2F%E2%80%94Pngtree%E2%80%94cloud_3554581.png68d35f98-3fdb-40b2-a842-264b7b7f6311?alt=media&token=3ab44bb4-ec8a-4c91-b835-1e45cccecb79','https://firebasestorage.googleapis.com/v0/b/mephim-cf569.appspot.com/o/videos%2Ffile_example_MP4_480_1_5MG.mp4a60a9593-2a4d-4f3b-ab8d-b49a55f418a4?alt=media&token=54f9b577-cb9e-46fc-9b1a-d30e69be6551','Minh Hằng, Ngọc Trinh,..',NULL,NULL),(2,'không có mô tả','Hậu lê',190,'THẾ THÂN','https://metiz.vn/media/poster_film/teaser_poster_1-other_child.jpg','https://ew',NULL,NULL,NULL),(3,'wwwww','Haauj',114,'CHIẾN BINH BÁO ĐEN','https://metiz.vn/media/poster_film/black.jpg','http:/sss',NULL,NULL,NULL),(4,'grgregerg','fweefewe',120,'HẠNH PHÚC MÁU','https://metiz.vn/media/poster_film/310360121_476517321189270_8975759243198345669_n.jpg','qffefe',NULL,NULL,NULL),(5,'gwegwegwe','hau',120,'hau','https://metiz.vn/media/poster_film/310360121_476517321189270_8975759243198345669_n.jpg','https://123441',NULL,NULL,NULL),(6,'Phim avartar 2','fewghwh',100,'Avatar 2','https://firebasestorage.googleapis.com/v0/b/mephim-cf569.appspot.com/o/images%2FMicrosoftTeams-image.png72e80525-fe98-462a-82f2-6ec02a7f804c?alt=media&token=338ec51f-c105-4925-b747-8312988a527d','https://firebasestorage.googleapis.com/v0/b/mephim-cf569.appspot.com/o/videos%2Ffile_example_MP4_480_1_5MG.mp45a33af20-a3d0-4c37-82d3-195cd322b14e?alt=media&token=cc4ccde6-1666-4533-b742-8342e34189a9',NULL,NULL,NULL),(7,'fewf','ewq',12,'efwfwef','https://firebasestorage.googleapis.com/v0/b/mephim-cf569.appspot.com/o/images%2FOrders%20pending.pnge4c0addc-054a-4f6f-a4ec-138e92443798?alt=media&token=0d4bd483-8e55-4bf9-abfb-4c313138263c','https://firebasestorage.googleapis.com/v0/b/mephim-cf569.appspot.com/o/videos%2Ffile_example_MP4_480_1_5MG.mp4896df3dd-c542-4b67-ac8f-69586cead861?alt=media&token=ec243d7d-442f-4472-8891-a44d24990617',NULL,NULL,NULL),(8,'rwqrwq','534',3252,'212421fewg','https://firebasestorage.googleapis.com/v0/b/mephim-cf569.appspot.com/o/images%2Fqz2.png4e67755f-27b8-42f3-a515-6dca039e966d?alt=media&token=dfd14aa5-7722-4a1b-b194-d1827e916479','https://firebasestorage.googleapis.com/v0/b/mephim-cf569.appspot.com/o/videos%2Ffile_example_MP4_480_1_5MG.mp451e6e149-7414-4160-bf46-8afe49a0ac67?alt=media&token=2b0c8a26-8517-4cc6-9208-5c051d9f90f3',NULL,NULL,NULL),(9,'ewwtewtw','rewrew',120,'Lê Tuấn Anh','https://firebasestorage.googleapis.com/v0/b/mephim-cf569.appspot.com/o/images%2FMicrosoftTeams-image%20(6).png5f4eb47e-8c18-43b7-bc50-0b500e04d195?alt=media&token=19e316bf-f046-468c-9eda-a473f2fe6492','https://firebasestorage.googleapis.com/v0/b/mephim-cf569.appspot.com/o/videos%2Ffile_example_MP4_480_1_5MG.mp453a0981f-f7a1-412b-93ce-0917225b6496?alt=media&token=7e253a03-b7be-42c6-a4bb-b1ac499424fd',NULL,NULL,NULL);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_actor`
--

DROP TABLE IF EXISTS `movie_actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_actor` (
  `movie_actor_id` int NOT NULL AUTO_INCREMENT,
  `actor_id` int DEFAULT NULL,
  `movie_id` int DEFAULT NULL,
  PRIMARY KEY (`movie_actor_id`),
  KEY `FK69qnqd5hnjn2aykvxcj72r9i5` (`actor_id`),
  KEY `FKhedvt8u16luotgyoel4fqy7t1` (`movie_id`),
  CONSTRAINT `FK69qnqd5hnjn2aykvxcj72r9i5` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`actor_id`),
  CONSTRAINT `FKhedvt8u16luotgyoel4fqy7t1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_actor`
--

LOCK TABLES `movie_actor` WRITE;
/*!40000 ALTER TABLE `movie_actor` DISABLE KEYS */;
INSERT INTO `movie_actor` VALUES (1,1,1),(2,1,2),(3,1,5),(4,1,6),(5,2,6),(6,3,7),(7,1,8),(8,3,8),(9,1,9),(10,2,9);
/*!40000 ALTER TABLE `movie_actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_category`
--

DROP TABLE IF EXISTS `movie_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_category` (
  `movie_category_id` int NOT NULL AUTO_INCREMENT,
  `category_id` int DEFAULT NULL,
  `movie_id` int DEFAULT NULL,
  PRIMARY KEY (`movie_category_id`),
  KEY `FKhkem46gi7yq1019e1j8hlvp9y` (`category_id`),
  KEY `FKdhlw8bp2rx2bhkp1orkg12lor` (`movie_id`),
  CONSTRAINT `FKdhlw8bp2rx2bhkp1orkg12lor` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  CONSTRAINT `FKhkem46gi7yq1019e1j8hlvp9y` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_category`
--

LOCK TABLES `movie_category` WRITE;
/*!40000 ALTER TABLE `movie_category` DISABLE KEYS */;
INSERT INTO `movie_category` VALUES (2,1,2),(3,1,5),(4,2,5),(5,1,6),(6,2,6),(7,1,7),(8,1,8),(9,1,9),(10,2,9),(11,2,4),(17,1,1);
/*!40000 ALTER TABLE `movie_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_theater`
--

DROP TABLE IF EXISTS `movie_theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_theater` (
  `movie_theater_id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `theater_id` int DEFAULT NULL,
  PRIMARY KEY (`movie_theater_id`),
  KEY `FK4iu5m1w1sbkrb40kleje7d2yi` (`movie_id`),
  KEY `FKa73254j4n90a4emh301u7juwj` (`theater_id`),
  CONSTRAINT `FK4iu5m1w1sbkrb40kleje7d2yi` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  CONSTRAINT `FKa73254j4n90a4emh301u7juwj` FOREIGN KEY (`theater_id`) REFERENCES `theater` (`theater_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_theater`
--

LOCK TABLES `movie_theater` WRITE;
/*!40000 ALTER TABLE `movie_theater` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate` (
  `rate_id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `num_rate` int DEFAULT NULL,
  `movie_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `is_liked` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  PRIMARY KEY (`rate_id`),
  UNIQUE KEY `UniqueUserAndMovie` (`user_id`,`movie_id`),
  KEY `FKhr60xnk86b63dsdy7as98fms2` (`movie_id`),
  CONSTRAINT `FKhr60xnk86b63dsdy7as98fms2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  CONSTRAINT `FKkkc94w4qh1lbimfym26iwhhnf` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
INSERT INTO `rate` VALUES (1,'rgregergre',5,9,7,_binary '\0',NULL),(2,'',5,1,7,_binary '\0',NULL),(3,'phim hay lắm',4,6,7,_binary '',_binary '\0'),(6,'Phim hay',5,2,7,_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refresh_token`
--

DROP TABLE IF EXISTS `refresh_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refresh_token` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `expiry_date` datetime(6) NOT NULL,
  `token` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r4k4edos30bx9neoq81mdvwph` (`token`),
  KEY `FKjtx87i0jvq2svedphegvdwcuy` (`user_id`),
  CONSTRAINT `FKjtx87i0jvq2svedphegvdwcuy` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refresh_token`
--

LOCK TABLES `refresh_token` WRITE;
/*!40000 ALTER TABLE `refresh_token` DISABLE KEYS */;
INSERT INTO `refresh_token` VALUES (26,'2023-01-02 22:14:30.156000','e71ef3a6-2e16-47bc-aa54-99998215022c',6),(27,'2023-01-02 22:15:24.583000','079d2d99-2d41-4ca7-9260-ea6d873122aa',6),(28,'2023-01-02 22:15:49.678000','4f1de91c-6e60-4b29-b5ad-f066d54bf338',6),(30,'2023-01-03 22:31:55.871000','9e539a6a-7eec-4345-88bc-8b1c28ed5543',6),(31,'2023-01-03 22:33:19.665000','44ac2199-3f3b-4a10-b9a1-00b3eb58f46a',6),(32,'2023-01-04 18:23:59.354000','1df39629-0f6f-4500-bdcb-4ac1ab7180ea',6),(33,'2023-01-04 18:31:14.242000','64a1a702-eda9-4005-bdad-328826dd0627',6),(34,'2023-01-04 18:42:31.074000','8df70336-0715-4fd8-873e-d4b2c5500f7a',6),(35,'2023-01-04 18:44:23.212000','3ee85a1f-da9f-4042-8307-a9555c260c24',6),(36,'2023-01-04 18:47:01.575000','4df340bd-7d29-4bef-8d53-0966fd520424',6),(37,'2023-01-04 18:48:18.782000','dd016c1c-608a-466b-8533-380976300f05',6),(38,'2023-05-13 06:14:13.667000','72e7b9e7-6003-4de5-a381-d547ff138d1a',6),(40,'2023-01-09 23:51:54.289000','1f213648-4870-426c-89a6-8c84aaf26d42',6),(41,'2023-01-09 23:52:18.823000','b4c17025-39ec-4ff0-bc67-0d093e56a0c7',6),(43,'2023-03-03 15:44:57.186843','02b4f629-a841-46c6-83a0-dd334356e4b7',6),(44,'2023-03-03 15:52:35.557989','d10d6ffb-286a-4cbb-8e4d-d3965aec9f40',7),(48,'2023-03-16 16:09:24.316981','7b310595-546d-450f-8b9c-59d14e013ee9',7),(49,'2023-03-16 17:43:51.730705','4bd5700a-fc1b-4227-a0d4-356012c5cddb',7),(50,'2023-03-17 15:21:15.470218','28b97e57-53dd-4f67-b281-c86c898ffb52',7),(51,'2023-03-22 16:38:07.066000','61e04ec7-0e87-499b-a418-82cdf0c860a9',7),(52,'2023-03-22 17:00:16.762000','daf4037c-fa1b-401c-ae53-1d0186dd6493',7),(53,'2023-03-23 13:47:52.942000','0afa1a9c-349a-4af1-ba3f-8f7ddf01826a',7),(54,'2023-04-05 15:13:40.046000','c65cb7ff-f9ba-4d55-ac2c-38043aa46896',7),(55,'2023-04-05 15:34:00.183000','d9cfbfc9-73f7-417b-a846-cb36a8975a02',7),(56,'2023-04-05 15:35:47.337000','f1d3a858-70b0-42db-9e3f-f39c95b2d0ed',7),(57,'2023-04-05 15:47:27.541000','d62cb6fc-efee-4de2-b03a-acaee6caf85e',7),(58,'2023-04-05 15:48:10.927000','3eaff351-a3a8-4fac-868a-1d0c7085ee3c',7),(59,'2023-04-05 16:35:33.931000','f2e92c16-f1d8-465e-b3e0-f05b8f1e0ff5',7),(60,'2023-04-05 17:22:00.706000','1e627e4e-40ec-487b-9900-9ed25aefe533',7),(61,'2023-04-05 17:26:22.676000','22b338af-3437-405f-9530-5cce3676a0ba',7),(62,'2023-04-05 17:28:44.907000','0b67cdaf-3666-4e41-8534-e0ab86e4b42c',7),(64,'2023-04-27 14:28:06.994000','f99990d2-32d1-43ba-8d41-0f8ab83bb845',7),(65,'2023-05-04 09:57:51.663000','0e62d12a-40f9-4fc7-9ae4-f85059904290',7),(66,'2023-05-09 09:29:59.575000','2fb4c693-efcc-4b5e-9917-b081c6e21fca',7),(67,'2023-05-09 16:58:55.357000','c44590e9-d0ae-4857-877f-a3b4f39d9b6d',7),(68,'2023-05-11 14:44:00.161000','901aaa5e-18fe-4a15-9b57-8e4ba9e4d4c6',7);
/*!40000 ALTER TABLE `refresh_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_MODERATOR'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `room_id` int NOT NULL AUTO_INCREMENT,
  `room_name` varchar(255) DEFAULT NULL,
  `total_column` int DEFAULT NULL,
  `total_row` int DEFAULT NULL,
  `is_enable` bit(1) DEFAULT NULL,
  `rowvip` varchar(255) DEFAULT NULL,
  `last_modify` varchar(255) DEFAULT NULL,
  `modify_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'R01',10,10,_binary '',NULL,NULL,NULL),(2,'R02',12,10,_binary '',NULL,NULL,NULL),(3,'R03',4,4,_binary '',NULL,NULL,NULL),(4,'R04',NULL,NULL,_binary '\0',NULL,NULL,NULL),(5,'R05',NULL,NULL,_binary '\0',NULL,NULL,NULL),(6,'R06',NULL,NULL,_binary '\0',NULL,NULL,NULL),(10,'Phòng 234',7,5,_binary '',NULL,NULL,NULL),(11,'Phòng 234',7,5,_binary '',NULL,NULL,NULL),(12,'Phòng hahaha',9,6,_binary '',NULL,NULL,NULL),(13,'phòng hihihi',10,4,_binary '',NULL,NULL,NULL),(14,'phong4144',3,3,_binary '','2',NULL,NULL),(15,'phong4144',3,3,_binary '','2-1',NULL,NULL),(16,'phong4144',3,3,_binary '','2-1-0',NULL,NULL),(17,'gggg',6,6,_binary '','2-3-4',NULL,NULL),(18,'rrr',6,6,_binary '','4-5-6',NULL,NULL),(19,'phòng A',6,10,_binary '','',NULL,NULL);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_ticket`
--

DROP TABLE IF EXISTS `room_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_ticket` (
  `room_ticket_id` int NOT NULL AUTO_INCREMENT,
  `room_id` int DEFAULT NULL,
  `ticket_id` int DEFAULT NULL,
  PRIMARY KEY (`room_ticket_id`),
  KEY `FKgcod7f4j2rhvmy755dsfriprn` (`room_id`),
  KEY `FKnhuqgolkqsja9rqm0tgco5qwn` (`ticket_id`),
  CONSTRAINT `FKgcod7f4j2rhvmy755dsfriprn` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `FKnhuqgolkqsja9rqm0tgco5qwn` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`ticket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_ticket`
--

LOCK TABLES `room_ticket` WRITE;
/*!40000 ALTER TABLE `room_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `room_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `seat_id` int NOT NULL AUTO_INCREMENT,
  `room_id` int DEFAULT NULL,
  `seat_column_id` int DEFAULT NULL,
  `seat_row_id` int DEFAULT NULL,
  `seat_type_id` int DEFAULT NULL,
  PRIMARY KEY (`seat_id`),
  KEY `FKd7f42843rt05tt66t6vcb7s9u` (`room_id`),
  KEY `FKss8kc7nly5fpmqeuorje3p93` (`seat_column_id`),
  KEY `FKjtoxyj4hlk5gtsaojyskf5wh8` (`seat_row_id`),
  KEY `FKd4mx49q62bd2apkk2rfkl8l9w` (`seat_type_id`),
  CONSTRAINT `FKd4mx49q62bd2apkk2rfkl8l9w` FOREIGN KEY (`seat_type_id`) REFERENCES `seat_type` (`seat_type_id`),
  CONSTRAINT `FKd7f42843rt05tt66t6vcb7s9u` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `FKjtoxyj4hlk5gtsaojyskf5wh8` FOREIGN KEY (`seat_row_id`) REFERENCES `seat_row` (`row_id`),
  CONSTRAINT `FKss8kc7nly5fpmqeuorje3p93` FOREIGN KEY (`seat_column_id`) REFERENCES `seat_column` (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=560 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,1,1,1,1),(2,1,1,2,1),(3,1,1,3,1),(4,1,1,4,1),(5,1,1,5,1),(6,1,1,6,1),(7,1,1,7,1),(8,1,1,8,1),(9,1,1,9,1),(10,1,1,10,1),(11,1,2,1,1),(12,1,2,2,1),(13,1,2,3,1),(14,1,2,4,1),(15,1,2,5,1),(16,1,2,6,1),(17,1,2,7,1),(18,1,2,8,1),(19,1,2,9,1),(20,1,2,10,1),(21,1,3,1,1),(22,1,3,2,1),(23,1,3,3,1),(24,1,3,4,1),(25,1,3,5,1),(26,1,3,6,1),(27,1,3,7,1),(28,1,3,8,1),(29,1,3,9,1),(30,1,3,10,1),(31,1,4,1,1),(32,1,4,2,1),(33,1,4,3,1),(34,1,4,4,1),(35,1,4,5,1),(36,1,4,6,1),(37,1,4,7,1),(38,1,4,8,1),(39,1,4,9,1),(40,1,4,10,1),(41,1,5,1,1),(42,1,5,2,1),(43,1,5,3,1),(44,1,5,4,1),(45,1,5,5,1),(46,1,5,6,1),(47,1,5,7,1),(48,1,5,8,1),(49,1,5,9,1),(50,1,5,10,1),(51,1,6,1,1),(52,1,6,2,1),(53,1,6,3,1),(54,1,6,4,1),(55,1,6,5,1),(56,1,6,6,1),(57,1,6,7,1),(58,1,6,8,1),(59,1,6,9,1),(60,1,6,10,1),(61,1,7,1,1),(62,1,7,2,1),(63,1,7,3,1),(64,1,7,4,1),(65,1,7,5,1),(66,1,7,6,1),(67,1,7,7,1),(68,1,7,8,1),(69,1,7,9,1),(70,1,7,10,1),(71,1,8,1,1),(72,1,8,2,1),(73,1,8,3,1),(74,1,8,4,1),(75,1,8,5,1),(76,1,8,6,1),(77,1,8,7,1),(78,1,8,8,1),(79,1,8,9,1),(80,1,8,10,1),(81,1,9,1,1),(82,1,9,2,1),(83,1,9,3,1),(84,1,9,4,1),(85,1,9,5,1),(86,1,9,6,1),(87,1,9,7,1),(88,1,9,8,1),(89,1,9,9,1),(90,1,9,10,1),(91,1,10,1,2),(92,1,10,2,2),(93,1,10,3,2),(94,1,10,4,2),(95,1,10,5,2),(96,1,10,6,2),(97,1,10,7,2),(98,1,10,8,2),(99,1,10,9,2),(100,1,10,10,2),(101,2,1,1,1),(102,2,1,2,1),(103,2,1,3,1),(104,2,1,4,1),(105,2,1,5,1),(106,2,1,6,1),(107,2,1,7,1),(108,2,1,8,1),(109,2,1,9,1),(110,2,1,10,1),(111,2,1,11,1),(112,2,1,12,1),(113,2,2,1,1),(114,2,2,2,1),(115,2,2,3,1),(116,2,2,4,1),(117,2,2,5,1),(118,2,2,6,1),(119,2,2,7,1),(120,2,2,8,1),(121,2,2,9,1),(122,2,2,10,1),(123,2,2,11,1),(124,2,2,12,1),(125,2,3,1,1),(126,2,3,2,1),(127,2,3,3,1),(128,2,3,4,1),(129,2,3,5,1),(130,2,3,6,1),(131,2,3,7,1),(132,2,3,8,1),(133,2,3,9,1),(134,2,3,10,1),(135,2,3,11,1),(136,2,3,12,1),(137,2,4,1,1),(138,2,4,2,1),(139,2,4,3,1),(140,2,4,4,1),(141,2,4,5,1),(142,2,4,6,1),(143,2,4,7,1),(144,2,4,8,1),(145,2,4,9,1),(146,2,4,10,1),(147,2,4,11,1),(148,2,4,12,1),(149,2,5,1,1),(150,2,5,2,1),(151,2,5,3,1),(152,2,5,4,1),(153,2,5,5,1),(154,2,5,6,1),(155,2,5,7,1),(156,2,5,8,1),(157,2,5,9,1),(158,2,5,10,1),(159,2,5,11,1),(160,2,5,12,1),(161,2,6,1,1),(162,2,6,2,1),(163,2,6,3,1),(164,2,6,4,1),(165,2,6,5,1),(166,2,6,6,1),(167,2,6,7,1),(168,2,6,8,1),(169,2,6,9,1),(170,2,6,10,1),(171,2,6,11,1),(172,2,6,12,1),(173,2,7,1,1),(174,2,7,2,1),(175,2,7,3,1),(176,2,7,4,1),(177,2,7,5,1),(178,2,7,6,1),(179,2,7,7,1),(180,2,7,8,1),(181,2,7,9,1),(182,2,7,10,1),(183,2,7,11,1),(184,2,7,12,1),(185,2,8,1,1),(186,2,8,2,1),(187,2,8,3,1),(188,2,8,4,1),(189,2,8,5,1),(190,2,8,6,1),(191,2,8,7,1),(192,2,8,8,1),(193,2,8,9,1),(194,2,8,10,1),(195,2,8,11,1),(196,2,8,12,1),(197,2,9,1,1),(198,2,9,2,1),(199,2,9,3,1),(200,2,9,4,1),(201,2,9,5,1),(202,2,9,6,1),(203,2,9,7,1),(204,2,9,8,1),(205,2,9,9,1),(206,2,9,10,1),(207,2,9,11,1),(208,2,9,12,1),(209,2,10,1,2),(210,2,10,2,2),(211,2,10,3,2),(212,2,10,4,2),(213,2,10,5,2),(214,2,10,6,2),(215,2,10,7,2),(216,2,10,8,2),(217,2,10,9,2),(218,2,10,10,2),(219,2,10,11,2),(220,2,10,12,2),(221,3,1,1,1),(222,3,1,2,1),(223,3,1,3,1),(224,3,1,4,1),(225,3,2,1,1),(226,3,2,2,1),(227,3,2,3,1),(228,3,2,4,1),(229,3,3,1,1),(230,3,3,2,1),(231,3,3,3,1),(232,3,3,4,1),(233,3,4,1,1),(234,3,4,2,1),(235,3,4,3,1),(236,3,4,4,1),(237,10,1,1,1),(238,10,1,2,1),(239,10,1,3,1),(240,10,1,4,1),(241,10,1,5,1),(242,10,1,6,1),(243,10,1,7,1),(244,10,2,1,1),(245,10,2,2,1),(246,10,2,3,1),(247,10,2,4,1),(248,10,2,5,1),(249,10,2,6,1),(250,10,2,7,1),(251,10,3,1,1),(252,10,3,2,1),(253,10,3,3,1),(254,10,3,4,1),(255,10,3,5,1),(256,10,3,6,1),(257,10,3,7,1),(258,10,4,1,2),(259,10,4,2,2),(260,10,4,3,2),(261,10,4,4,2),(262,10,4,5,2),(263,10,4,6,2),(264,10,4,7,2),(265,10,5,1,1),(266,10,5,2,1),(267,10,5,3,1),(268,10,5,4,1),(269,10,5,5,1),(270,10,5,6,1),(271,10,5,7,1),(272,11,1,1,1),(273,11,1,2,1),(274,11,1,3,1),(275,11,1,4,1),(276,11,1,5,1),(277,11,1,6,1),(278,11,1,7,1),(279,11,2,1,1),(280,11,2,2,1),(281,11,2,3,1),(282,11,2,4,1),(283,11,2,5,1),(284,11,2,6,1),(285,11,2,7,1),(286,11,3,1,1),(287,11,3,2,1),(288,11,3,3,1),(289,11,3,4,1),(290,11,3,5,1),(291,11,3,6,1),(292,11,3,7,1),(293,11,4,1,2),(294,11,4,2,2),(295,11,4,3,2),(296,11,4,4,2),(297,11,4,5,2),(298,11,4,6,2),(299,11,4,7,2),(300,11,5,1,1),(301,11,5,2,1),(302,11,5,3,1),(303,11,5,4,1),(304,11,5,5,1),(305,11,5,6,1),(306,11,5,7,1),(361,13,1,1,1),(362,13,1,2,1),(363,13,1,3,1),(364,13,1,4,1),(365,13,1,5,1),(366,13,1,6,1),(367,13,1,7,1),(368,13,1,8,1),(369,13,1,9,1),(370,13,1,10,1),(371,13,2,1,1),(372,13,2,2,1),(373,13,2,3,1),(374,13,2,4,1),(375,13,2,5,1),(376,13,2,6,1),(377,13,2,7,1),(378,13,2,8,1),(379,13,2,9,1),(380,13,2,10,1),(381,13,3,1,1),(382,13,3,2,1),(383,13,3,3,1),(384,13,3,4,1),(385,13,3,5,1),(386,13,3,6,1),(387,13,3,7,1),(388,13,3,8,1),(389,13,3,9,1),(390,13,3,10,1),(391,13,4,1,2),(392,13,4,2,2),(393,13,4,3,2),(394,13,4,4,2),(395,13,4,5,2),(396,13,4,6,2),(397,13,4,7,2),(398,13,4,8,2),(399,13,4,9,2),(400,13,4,10,2),(401,14,1,1,1),(402,14,1,2,1),(403,14,1,3,1),(404,14,2,1,1),(405,14,2,2,1),(406,14,2,3,1),(407,14,3,1,2),(408,14,3,2,2),(409,14,3,3,2),(410,15,1,1,1),(411,15,1,2,1),(412,15,1,3,1),(413,15,2,1,2),(414,15,2,2,2),(415,15,2,3,2),(416,15,3,1,2),(417,15,3,2,2),(418,15,3,3,2),(419,16,1,1,2),(420,16,1,2,2),(421,16,1,3,2),(422,16,2,1,2),(423,16,2,2,2),(424,16,2,3,2),(425,16,3,1,2),(426,16,3,2,2),(427,16,3,3,2),(428,17,1,1,1),(429,17,1,2,1),(430,17,1,3,1),(431,17,1,4,1),(432,17,1,5,1),(433,17,1,6,1),(434,17,2,1,2),(435,17,2,2,2),(436,17,2,3,2),(437,17,2,4,2),(438,17,2,5,2),(439,17,2,6,2),(440,17,3,1,2),(441,17,3,2,2),(442,17,3,3,2),(443,17,3,4,2),(444,17,3,5,2),(445,17,3,6,2),(446,17,4,1,2),(447,17,4,2,2),(448,17,4,3,2),(449,17,4,4,2),(450,17,4,5,2),(451,17,4,6,2),(452,17,5,1,1),(453,17,5,2,1),(454,17,5,3,1),(455,17,5,4,1),(456,17,5,5,1),(457,17,5,6,1),(458,17,6,1,1),(459,17,6,2,1),(460,17,6,3,1),(461,17,6,4,1),(462,17,6,5,1),(463,17,6,6,1),(464,18,1,1,1),(465,18,1,2,1),(466,18,1,3,1),(467,18,1,4,1),(468,18,1,5,1),(469,18,1,6,1),(470,18,2,1,1),(471,18,2,2,1),(472,18,2,3,1),(473,18,2,4,1),(474,18,2,5,1),(475,18,2,6,1),(476,18,3,1,1),(477,18,3,2,1),(478,18,3,3,1),(479,18,3,4,1),(480,18,3,5,1),(481,18,3,6,1),(482,18,4,1,2),(483,18,4,2,2),(484,18,4,3,2),(485,18,4,4,2),(486,18,4,5,2),(487,18,4,6,2),(488,18,5,1,2),(489,18,5,2,2),(490,18,5,3,2),(491,18,5,4,2),(492,18,5,5,2),(493,18,5,6,2),(494,18,6,1,2),(495,18,6,2,2),(496,18,6,3,2),(497,18,6,4,2),(498,18,6,5,2),(499,18,6,6,2),(500,19,1,1,1),(501,19,1,2,1),(502,19,1,3,1),(503,19,1,4,1),(504,19,1,5,1),(505,19,1,6,1),(506,19,2,1,1),(507,19,2,2,1),(508,19,2,3,1),(509,19,2,4,1),(510,19,2,5,1),(511,19,2,6,1),(512,19,3,1,1),(513,19,3,2,1),(514,19,3,3,1),(515,19,3,4,1),(516,19,3,5,1),(517,19,3,6,1),(518,19,4,1,1),(519,19,4,2,1),(520,19,4,3,1),(521,19,4,4,1),(522,19,4,5,1),(523,19,4,6,1),(524,19,5,1,1),(525,19,5,2,1),(526,19,5,3,1),(527,19,5,4,1),(528,19,5,5,1),(529,19,5,6,1),(530,19,6,1,1),(531,19,6,2,1),(532,19,6,3,1),(533,19,6,4,1),(534,19,6,5,1),(535,19,6,6,1),(536,19,7,1,1),(537,19,7,2,1),(538,19,7,3,1),(539,19,7,4,1),(540,19,7,5,1),(541,19,7,6,1),(542,19,8,1,1),(543,19,8,2,1),(544,19,8,3,1),(545,19,8,4,1),(546,19,8,5,1),(547,19,8,6,1),(548,19,9,1,1),(549,19,9,2,1),(550,19,9,3,1),(551,19,9,4,1),(552,19,9,5,1),(553,19,9,6,1),(554,19,10,1,1),(555,19,10,2,1),(556,19,10,3,1),(557,19,10,4,1),(558,19,10,5,1),(559,19,10,6,1);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_column`
--

DROP TABLE IF EXISTS `seat_column`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_column` (
  `column_id` int NOT NULL AUTO_INCREMENT,
  `column_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_column`
--

LOCK TABLES `seat_column` WRITE;
/*!40000 ALTER TABLE `seat_column` DISABLE KEYS */;
INSERT INTO `seat_column` VALUES (1,'1'),(2,'2'),(3,'3'),(4,'4'),(5,'5'),(6,'6'),(7,'7'),(8,'8'),(9,'9'),(10,'10'),(11,'11'),(12,'12'),(13,'13'),(14,'14'),(15,'15');
/*!40000 ALTER TABLE `seat_column` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_row`
--

DROP TABLE IF EXISTS `seat_row`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_row` (
  `row_id` int NOT NULL AUTO_INCREMENT,
  `row_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_row`
--

LOCK TABLES `seat_row` WRITE;
/*!40000 ALTER TABLE `seat_row` DISABLE KEYS */;
INSERT INTO `seat_row` VALUES (1,'A'),(2,'B'),(3,'C'),(4,'D'),(5,'E'),(6,'F'),(7,'G'),(8,'H'),(9,'I'),(10,'J'),(11,'J'),(12,'K'),(13,'L'),(14,'M'),(15,'N'),(16,'O');
/*!40000 ALTER TABLE `seat_row` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_type`
--

DROP TABLE IF EXISTS `seat_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_type` (
  `seat_type_id` int NOT NULL AUTO_INCREMENT,
  `seat_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seat_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_type`
--

LOCK TABLES `seat_type` WRITE;
/*!40000 ALTER TABLE `seat_type` DISABLE KEYS */;
INSERT INTO `seat_type` VALUES (1,'STANDARD'),(2,'VIP');
/*!40000 ALTER TABLE `seat_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `show_date`
--

DROP TABLE IF EXISTS `show_date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `show_date` (
  `show_date_id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`show_date_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `show_date`
--

LOCK TABLES `show_date` WRITE;
/*!40000 ALTER TABLE `show_date` DISABLE KEYS */;
INSERT INTO `show_date` VALUES (1,'2023-05-10'),(2,'2023-05-11'),(3,'2023-05-12'),(4,'2023-05-13'),(5,'2023-05-14'),(6,'2023-05-15');
/*!40000 ALTER TABLE `show_date` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `show_time`
--

DROP TABLE IF EXISTS `show_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `show_time` (
  `show_time_id` int NOT NULL AUTO_INCREMENT,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`show_time_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `show_time`
--

LOCK TABLES `show_time` WRITE;
/*!40000 ALTER TABLE `show_time` DISABLE KEYS */;
INSERT INTO `show_time` VALUES (1,'07:00'),(2,'08:00'),(3,'09:00'),(4,'10:00'),(5,'11:00'),(6,'12:00'),(7,'13:00'),(8,'14:00'),(9,'15:00'),(10,'16:00'),(11,'17:00'),(12,'18:00'),(13,'19:00'),(14,'20:00'),(15,'21:00'),(16,'22:00');
/*!40000 ALTER TABLE `show_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater`
--

DROP TABLE IF EXISTS `theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater` (
  `theater_id` int NOT NULL AUTO_INCREMENT,
  `theater_address` varchar(255) DEFAULT NULL,
  `theater_description` varchar(255) DEFAULT NULL,
  `theater_name` varchar(255) DEFAULT NULL,
  `theater_group_id` int DEFAULT NULL,
  PRIMARY KEY (`theater_id`),
  KEY `FKo4n1rkianiepvw56yvoyph2hq` (`theater_group_id`),
  CONSTRAINT `FKo4n1rkianiepvw56yvoyph2hq` FOREIGN KEY (`theater_group_id`) REFERENCES `theater_group` (`theater_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater`
--

LOCK TABLES `theater` WRITE;
/*!40000 ALTER TABLE `theater` DISABLE KEYS */;
INSERT INTO `theater` VALUES (1,'Đà Nẵng',NULL,'Galaxy đà nẵng',1),(2,'Quảng Ngãi',NULL,'Galaxy quảng ngãi',1);
/*!40000 ALTER TABLE `theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater_group`
--

DROP TABLE IF EXISTS `theater_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater_group` (
  `theater_group_id` int NOT NULL AUTO_INCREMENT,
  `theater_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`theater_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater_group`
--

LOCK TABLES `theater_group` WRITE;
/*!40000 ALTER TABLE `theater_group` DISABLE KEYS */;
INSERT INTO `theater_group` VALUES (1,'GALAXY CINEMA'),(2,'LOTTE CINEMA');
/*!40000 ALTER TABLE `theater_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `ticket_id` int NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `ticket_price` bigint DEFAULT NULL,
  `movie_id` int DEFAULT NULL,
  `show_date_id` int DEFAULT NULL,
  `show_time_id` int DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  `last_modify` varchar(255) DEFAULT NULL,
  `modify_by` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `FK76th994c74fm9ohowlu53yfpx` (`movie_id`),
  KEY `FKmqtp9rsodoshkl8tsnn4mkfns` (`show_date_id`),
  KEY `FKsbhsari8771yntnvt3x9aws8b` (`show_time_id`),
  KEY `FKs8pj7bey0vnj1rf9tk5689pbt` (`room_id`),
  CONSTRAINT `FK76th994c74fm9ohowlu53yfpx` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  CONSTRAINT `FKmqtp9rsodoshkl8tsnn4mkfns` FOREIGN KEY (`show_date_id`) REFERENCES `show_date` (`show_date_id`),
  CONSTRAINT `FKs8pj7bey0vnj1rf9tk5689pbt` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `FKsbhsari8771yntnvt3x9aws8b` FOREIGN KEY (`show_time_id`) REFERENCES `show_time` (`show_time_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,_binary '',60000,1,1,1,1,NULL,NULL,_binary '\0'),(2,_binary '',55000,2,1,1,1,NULL,NULL,_binary '\0'),(3,_binary '',45000,2,1,5,1,NULL,NULL,_binary '\0'),(4,_binary '',88000,2,2,1,1,NULL,NULL,_binary '\0'),(5,_binary '',44666,2,5,1,3,NULL,NULL,_binary '\0'),(6,_binary '',52355,2,1,1,2,NULL,NULL,_binary '\0'),(7,_binary '',44000,1,3,2,2,NULL,NULL,_binary '\0'),(8,_binary '',77000,1,2,6,3,NULL,NULL,_binary '\0'),(9,_binary '',22000,1,2,15,3,NULL,NULL,_binary '\0'),(10,_binary '',33000,1,2,8,3,NULL,NULL,_binary '\0'),(11,_binary '',70000,1,2,10,3,NULL,NULL,_binary '\0'),(12,_binary '',34000,2,2,5,1,NULL,NULL,_binary '\0'),(13,_binary '',40000,2,3,5,1,NULL,NULL,_binary '\0'),(14,_binary '',4000,1,1,4,3,NULL,NULL,_binary '\0'),(15,_binary '',4000,1,3,4,3,NULL,NULL,_binary '\0'),(16,_binary '',4000,1,3,7,3,NULL,NULL,_binary '\0'),(17,_binary '',4000,1,4,7,3,NULL,NULL,_binary '\0'),(18,_binary '',4000,2,4,7,6,NULL,NULL,_binary '\0'),(19,_binary '',4000,4,1,6,2,NULL,NULL,_binary '\0'),(20,_binary '',4000,5,1,6,3,NULL,NULL,_binary '\0'),(21,_binary '',4000,5,3,1,3,NULL,NULL,_binary '\0'),(22,_binary '',52355,6,5,3,2,NULL,NULL,_binary '\0'),(23,_binary '',52355,6,5,6,2,NULL,NULL,_binary '\0'),(24,_binary '',52355,6,5,10,1,NULL,NULL,_binary '\0'),(25,_binary '',52355,6,5,12,3,NULL,NULL,_binary '\0'),(36,_binary '',52355,6,6,1,2,NULL,NULL,_binary ''),(37,_binary '',52355,1,6,1,3,NULL,NULL,_binary '\0'),(38,_binary '',52355,4,6,7,3,NULL,NULL,_binary '\0'),(39,_binary '',52355,6,6,7,2,NULL,NULL,_binary ''),(40,_binary '',52355,5,6,7,1,NULL,NULL,_binary '\0'),(41,_binary '',52355,7,6,7,4,NULL,NULL,_binary ''),(42,_binary '',52355,8,6,7,5,NULL,NULL,_binary ''),(43,_binary '',52355,3,6,7,6,NULL,NULL,_binary '\0'),(44,_binary '',52355,9,6,11,2,NULL,NULL,_binary '\0'),(45,_binary '',50000,9,6,1,11,NULL,NULL,_binary ''),(46,_binary '',60000,9,6,5,12,NULL,NULL,_binary ''),(47,_binary '',70000,9,6,8,13,NULL,NULL,_binary '\0'),(48,_binary '',80000,9,6,14,18,NULL,NULL,_binary '\0');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `transaction_date` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FKanjpo5tiapru7an6cw4cu37y4` (`user_id`),
  CONSTRAINT `FKanjpo5tiapru7an6cw4cu37y4` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (5,1),(7,1),(8,1),(6,3);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `is_enable` bit(1) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `phone` varchar(9) DEFAULT NULL,
  `provider` varchar(20) DEFAULT NULL,
  `register_date` datetime(6) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `verification_code` varchar(500) DEFAULT NULL,
  `available_point` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (5,'leconghau905@gmail.com',_binary '\0','$2a$10$7dTVKPQYAUFeJZsXm03aduId6hj6v178.kjacI4fQgBNPil5a9IXe',NULL,'REGISTER','2023-01-02 20:55:02.109000','leconghau905','Doh7mSpSAgSMTC8qQPZZEWlTTH79WaIlKRZH7r2vdYMFzXLCzM',NULL,NULL),(6,'leconghau095@gmail.com',_binary '','$2a$10$yOhbMlB/w3V4ya9ECJTVLOKdV3Lo0RQQoqAKN03V2gelVJa84YKpS',NULL,'REGISTER','2023-01-02 20:55:23.113000','leconghau095','9MnyDbUQQN847Ya4EIt20pVrmOUZC4bTNCHWbnGUNvmCGsvBW3',NULL,NULL),(7,'lchau3@yopmail.com',_binary '','$2a$10$.MTYfKlZ1uGsT3hdB9orVeeJfJ1QTjiJJOwMTquJAy0pm8VgzPrx2','099333333','REGISTER','2023-03-03 15:39:28.514868','lchau3@yopmail.com',NULL,58320,'hậu đây'),(8,'lchau4@yopmail.com',_binary '','$2a$10$0oQW5y3xZhlqV8HCO1GuB.NZXX1vsloJgP8GRknAByA7PUXxhVLRi',NULL,'REGISTER','2023-03-06 14:37:10.530178','lchau4@yopmail.com',NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mephim'
--
/*!50003 DROP PROCEDURE IF EXISTS `getCategoryStatisBy1WeeksAgo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCategoryStatisBy1WeeksAgo`(
    daysAgo int)
BEGIN
    DROP TEMPORARY TABLE IF EXISTS table2;
    CREATE TEMPORARY TABLE table2 AS (SELECT category.*,
                                             count(category.category_id) as 'num_of_booking'
                                      from booking
                                               inner join ticket
                                               inner join movie
                                               inner join movie_category
                                               inner join category
                                                          on movie_category.category_id = category.category_id
                                                              and booking.ticket_id = ticket.ticket_id
                                                              and ticket.movie_id = movie.movie_id
                                                              and movie_category.movie_id = movie.movie_id
                                                              and booking.time >= DATE(NOW() - INTERVAL daysAgo DAY)
                                      group by category.category_id
                                      order by num_of_booking desc);
    DROP TEMPORARY TABLE IF EXISTS table3;
    CREATE TEMPORARY TABLE table3(select category_id
                                  from table2);
    select table2.*
    from table2
    union
    select category.*, 0
    from category
    where category.category_id not in (select category_id from table3);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-11 16:35:00
