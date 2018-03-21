-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Dumping data for table `Autor`
--

LOCK TABLES `Autor` WRITE;
/*!40000 ALTER TABLE `Autor` DISABLE KEYS */;
INSERT INTO `Autor` VALUES (1,'Comentario','Corea del sur','Leandro Cezuago Arranz'),(2,'Comentario','Suazilandia','Rossana Ojea Ingueros'),(3,'Comentario','Afganistán','Cihua Capa Coloma'),(4,'Comentario','Mozambique','Jenny Goyo Alarcon'),(5,'Comentario','Seychelles','Bethsy Naveira Murcia'),(6,'Comentario','Tanzania','Evangelina Traspalacios AgÜero'),(7,'Comentario','Hungría','Andoni Aro Fonelleda'),(8,'Comentario','Bangladesh','Asunción Pineda Corton');
/*!40000 ALTER TABLE `Autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Direccion`
--

LOCK TABLES `Direccion` WRITE;
/*!40000 ALTER TABLE `Direccion` DISABLE KEYS */;
INSERT INTO `Direccion` VALUES (1,'Plaza Abscindeix',15884,257,'Vallecas','Madrid'),(2,'Cañada Atardarem encaboriessis llenço',12547,146,'Getafe','Madrid'),(3,'C. Comercial Enemistat arremolinaré, 233 11ºD',2564,12,'San Sebastian','Madrid'),(4,'Carrer Enllatades urpires malmirin',12464,13,'Alcalá de Henares','Madrid'),(5,'Plaza Gangrenessen infirmat consternassis afortunat ',1266,12,'Azuqueca de Henares','Guadalajara'),(6,'Cañada Tibés agullats gelatinitzarà, 250 10ºH',1266,12,'Torrejon de Ardoz','Madrid'),(7,'Carrer Bernac obligués, ',0,0,'Torrelaguna','Ciudad Real');
/*!40000 ALTER TABLE `Direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Editorial`
--

LOCK TABLES `Editorial` WRITE;
/*!40000 ALTER TABLE `Editorial` DISABLE KEYS */;
INSERT INTO `Editorial` VALUES (1,'1','Editorial 1',7),(2,'2','Editorial 2',3),(3,'3','Editorial 3',4),(4,'4','Editorial 4',5),(5,'5','Editorial 5',6),(6,'6','Editorial 6',1),(7,'7','Editorial 7',2);
/*!40000 ALTER TABLE `Editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Libro`
--

LOCK TABLES `Libro` WRITE;
/*!40000 ALTER TABLE `Libro` DISABLE KEYS */;
INSERT INTO `Libro` VALUES (1,'Descipcion','1',0,0,'La conclusión neoreligiosa tras el Top Manta: una crítica neofuturista',1),(2,'Descipcion','2',0,0,'El análisis modernista, la inferencia postreligiosa y la Revolución Industrial',2),(3,'Descipcion','3',0,0,'La decadencia racionalista frente a Karl Marx (una desintegración masoquista)',3),(4,'Descipcion','4',0,0,'La disgregación postfuturista tras la Revolución Francesa: ¿una conspiración concurrente?',4),(5,'Descipcion','5',0,0,'La apostasía cyberpunk frente a las teorías de Freud: una génesis neoimpresionista',4),(6,'Descipcion','5',0,0,'El complot postrevolucionario contra la segunda epístola a los Corintios: ¿una metástasis neoreaccionaria?',5),(7,'Descipcion','7',0,0,'La revolución neoanarquista, la simbiosis postrevolucionaria y la pipa de Gandalf',6),(8,'Descipcion','8',0,0,'La retractación dadaísta ante Juan Tamariz (una deducción cyberpunk)',7),(9,'Descipcion','9',0,0,'La abjuración postimpresionista, la yuxtaposición postdistópica y las telenovelas venezolanas',6),(10,'Descipcion','10',0,0,'La reflexión generacionista ante Kierkegaard (una relación prenihilista)',6),(11,'Descipcion','11',0,0,'El destino modernista y un señor de Cuenca: una dialéctica constructivista',6),(12,'Descipcion','12',0,0,'La dispersión distópica, la conjetura postimpresionista y la Empanada Gallega',1);
/*!40000 ALTER TABLE `Libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `LibroAutor`
--

LOCK TABLES `LibroAutor` WRITE;
/*!40000 ALTER TABLE `LibroAutor` DISABLE KEYS */;
INSERT INTO `LibroAutor` VALUES (2,8);
/*!40000 ALTER TABLE `LibroAutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1,'ROLE_ADMIN');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,1,'$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u','user',1),(2,1,'$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u','user2',1);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-20 11:55:18
