-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pokemon
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `attaques`
--

DROP TABLE IF EXISTS `attaques`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attaques` (
  `id_attaques` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) DEFAULT NULL,
  `puissance` int(11) DEFAULT NULL,
  `precis` int(11) DEFAULT NULL,
  `id_types` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_attaques`),
  KEY `FK_attaques_id_types` (`id_types`),
  CONSTRAINT `FK_attaques_id_types` FOREIGN KEY (`id_types`) REFERENCES `types` (`id_types`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attaques`
--

LOCK TABLES `attaques` WRITE;
/*!40000 ALTER TABLE `attaques` DISABLE KEYS */;
INSERT INTO `attaques` VALUES (1,'Corps Perdu',70,100,2),(2,'Cord\'Boue',20,100,14),(3,'Coud\'Krane',100,100,9),(4,'Coup Bas',80,100,16),(5,'Croc De Mort',80,90,9),(6,'Danse du Feu',80,100,6),(7,'Danse-Fleur',120,100,10),(8,'Danseflamme',15,70,6),(9,'Deflagration',120,85,6),(10,'Detritus',65,100,11),(11,'Devoreve',100,100,12),(12,'Double Pied',30,100,2),(13,'Double-Dard',25,100,8),(14,'Draco-Queue',60,90,3),(15,'Dracogriffe',80,100,3),(16,'Dracosouffle',60,100,3),(17,'Eclair',40,100,5),(18,'Elecanon',120,50,5),(19,'Etincelle',65,100,5),(20,'Explosion',250,100,9),(21,'Fatal-Foudre',120,70,5),(22,'Force',80,100,9),(23,'Griffe Acier',50,95,1),(24,'Griffe Ombre',70,100,16),(25,'Hydrocanon',120,80,4),(26,'Lame d\'Air',75,95,17),(27,'Lame-Feuille',90,100,10),(28,'Lance-Flamme',95,100,6),(29,'Lance-Soleil',120,100,10),(30,'Laser Glace',95,100,7),(31,'Lechouille',20,100,15),(32,'Lutte',50,100,NULL),(33,'Mach Punch',40,100,2),(34,'Machouille',80,100,16),(35,'Mania',90,100,9),(36,'Massd\'Os',65,85,14),(37,'Megacorne',120,85,8),(38,'Morsure',60,100,16),(39,'Onde Boreale',65,100,7),(40,'Picpic',35,100,17),(41,'Pince-Masse',90,85,4),(42,'Pouv.Antique',60,100,13),(43,'Psyko',90,100,12),(44,'Punition',1,100,16),(45,'Stalagtite',10,100,7),(46,'Taillade',10,95,8);
/*!40000 ALTER TABLE `attaques` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `badges`
--

DROP TABLE IF EXISTS `badges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `badges` (
  `id_badges` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  `id_dresseur_maitre` int(11) DEFAULT NULL,
  `id_zones` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_badges`),
  KEY `FK_badges_id_dresseur_maitre` (`id_dresseur_maitre`),
  KEY `FK_badges_id_zones` (`id_zones`),
  CONSTRAINT `FK_badges_id_dresseur_maitre` FOREIGN KEY (`id_dresseur_maitre`) REFERENCES `dresseurs` (`id_dresseur`),
  CONSTRAINT `FK_badges_id_zones` FOREIGN KEY (`id_zones`) REFERENCES `zones` (`id_zones`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `badges`
--

LOCK TABLES `badges` WRITE;
/*!40000 ALTER TABLE `badges` DISABLE KEYS */;
INSERT INTO `badges` VALUES (1,'foudre',1,NULL),(2,'roche',3,NULL);
/*!40000 ALTER TABLE `badges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dresseurs`
--

DROP TABLE IF EXISTS `dresseurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dresseurs` (
  `id_dresseur` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  `id_badges` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_dresseur`),
  KEY `FK_dresseurs_id_badges` (`id_badges`),
  CONSTRAINT `FK_dresseurs_id_badges` FOREIGN KEY (`id_badges`) REFERENCES `badges` (`id_badges`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dresseurs`
--

LOCK TABLES `dresseurs` WRITE;
/*!40000 ALTER TABLE `dresseurs` DISABLE KEYS */;
INSERT INTO `dresseurs` VALUES (1,'red',NULL),(2,'blue',NULL),(3,'yellow',NULL),(4,'purple',NULL),(5,'white',NULL),(6,'rené',NULL);
/*!40000 ALTER TABLE `dresseurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evolueen`
--

DROP TABLE IF EXISTS `evolueen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evolueen` (
  `id_type_pokemons` int(11) NOT NULL,
  `id_type_pokemons_evolution` int(11) NOT NULL,
  PRIMARY KEY (`id_type_pokemons`,`id_type_pokemons_evolution`),
  KEY `FK_evolueEn_id_type_pokemons_evolution` (`id_type_pokemons_evolution`),
  CONSTRAINT `FK_evolueEn_id_type_pokemons` FOREIGN KEY (`id_type_pokemons`) REFERENCES `typedepokemons` (`id_type_pokemons`),
  CONSTRAINT `FK_evolueEn_id_type_pokemons_evolution` FOREIGN KEY (`id_type_pokemons_evolution`) REFERENCES `typedepokemons` (`id_type_pokemons`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evolueen`
--

LOCK TABLES `evolueen` WRITE;
/*!40000 ALTER TABLE `evolueen` DISABLE KEYS */;
INSERT INTO `evolueen` VALUES (2,3),(3,4),(1,5);
/*!40000 ALTER TABLE `evolueen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faiblecontre`
--

DROP TABLE IF EXISTS `faiblecontre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faiblecontre` (
  `modificateur` decimal(4,2) DEFAULT NULL,
  `id_types_base` int(11) NOT NULL,
  `id_types_fort` int(11) NOT NULL,
  PRIMARY KEY (`id_types_base`,`id_types_fort`),
  KEY `FK_faibleContre_id_types_1` (`id_types_fort`),
  CONSTRAINT `FK_faibleContre_id_types` FOREIGN KEY (`id_types_base`) REFERENCES `types` (`id_types`),
  CONSTRAINT `FK_faibleContre_id_types_1` FOREIGN KEY (`id_types_fort`) REFERENCES `types` (`id_types`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faiblecontre`
--

LOCK TABLES `faiblecontre` WRITE;
/*!40000 ALTER TABLE `faiblecontre` DISABLE KEYS */;
INSERT INTO `faiblecontre` VALUES (0.50,1,2),(0.50,1,6),(0.50,1,14),(0.50,2,12),(0.50,2,17),(0.50,3,3),(0.50,3,7),(0.50,4,5),(0.50,4,10),(0.50,5,14),(0.50,6,4),(0.50,6,13),(0.50,6,14),(0.50,7,1),(0.50,7,2),(0.50,7,6),(0.50,7,13),(0.50,8,6),(0.50,8,13),(0.50,8,17),(0.50,9,2),(0.50,10,6),(0.50,10,7),(0.50,10,8),(0.50,10,11),(0.50,10,17),(0.50,11,12),(0.50,11,14),(0.50,12,8),(0.50,12,15),(0.50,12,16),(0.50,13,1),(0.50,13,2),(0.50,13,4),(0.50,13,10),(0.50,13,14),(0.50,14,4),(0.50,14,7),(0.50,14,10),(0.50,15,15),(0.50,16,2),(0.50,16,8),(0.50,17,5),(0.50,17,7),(0.50,17,13);
/*!40000 ALTER TABLE `faiblecontre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fortcontre`
--

DROP TABLE IF EXISTS `fortcontre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fortcontre` (
  `modificateur` decimal(4,2) DEFAULT NULL,
  `id_types_base` int(11) NOT NULL,
  `id_types_faible` int(11) NOT NULL,
  PRIMARY KEY (`id_types_base`,`id_types_faible`),
  KEY `FK_fortContre_id_types_faible` (`id_types_faible`),
  CONSTRAINT `FK_fortContre_id_types_base` FOREIGN KEY (`id_types_base`) REFERENCES `types` (`id_types`),
  CONSTRAINT `FK_fortContre_id_types_faible` FOREIGN KEY (`id_types_faible`) REFERENCES `types` (`id_types`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fortcontre`
--

LOCK TABLES `fortcontre` WRITE;
/*!40000 ALTER TABLE `fortcontre` DISABLE KEYS */;
INSERT INTO `fortcontre` VALUES (1.50,1,7),(1.50,1,13),(1.50,2,1),(1.50,2,7),(1.50,2,9),(1.50,2,13),(1.50,2,16),(1.50,3,3),(1.50,4,6),(1.50,4,13),(1.50,4,14),(1.50,5,4),(1.50,5,17),(1.50,6,1),(1.50,6,7),(1.50,6,8),(1.50,6,10),(1.50,7,3),(1.50,7,10),(1.50,7,14),(1.50,7,17),(1.50,8,10),(1.50,8,12),(1.50,8,16),(1.50,10,4),(1.50,10,13),(1.50,10,14),(1.50,11,10),(1.50,12,2),(1.50,12,11),(1.50,13,6),(1.50,13,7),(1.50,13,8),(1.50,13,17),(1.50,14,1),(1.50,14,5),(1.50,14,6),(1.50,14,11),(1.50,14,13),(1.50,15,12),(1.50,15,15),(1.50,16,12),(1.50,16,15),(1.50,17,2),(1.50,17,8),(1.50,17,10);
/*!40000 ALTER TABLE `fortcontre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gagne`
--

DROP TABLE IF EXISTS `gagne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gagne` (
  `obtention` date DEFAULT NULL,
  `id_dresseur` int(11) NOT NULL,
  `id_badges` int(11) NOT NULL,
  PRIMARY KEY (`id_dresseur`,`id_badges`),
  KEY `FK_gagne_id_badges` (`id_badges`),
  CONSTRAINT `FK_gagne_id_badges` FOREIGN KEY (`id_badges`) REFERENCES `badges` (`id_badges`),
  CONSTRAINT `FK_gagne_id_dresseur` FOREIGN KEY (`id_dresseur`) REFERENCES `dresseurs` (`id_dresseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gagne`
--

LOCK TABLES `gagne` WRITE;
/*!40000 ALTER TABLE `gagne` DISABLE KEYS */;
/*!40000 ALTER TABLE `gagne` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemons`
--

DROP TABLE IF EXISTS `pokemons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pokemons` (
  `id_pokemons` int(11) NOT NULL,
  `surnom` varchar(25) NOT NULL,
  `niveau` int(11) DEFAULT NULL,
  `capture` date NOT NULL,
  `id_dresseur` int(11) DEFAULT NULL,
  `id_attaques_1` int(11) DEFAULT NULL,
  `id_attaques_2` int(11) DEFAULT NULL,
  `id_attaques_3` int(11) DEFAULT NULL,
  `id_attaques_4` int(11) DEFAULT NULL,
  `id_type_pokemons` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pokemons`),
  KEY `FK_pokemons_id_attaques_1` (`id_attaques_1`),
  KEY `FK_pokemons_id_attaques_2` (`id_attaques_2`),
  KEY `FK_pokemons_id_attaques_3` (`id_attaques_3`),
  KEY `FK_pokemons_id_attaques_4` (`id_attaques_4`),
  KEY `FK_pokemons_id_dresseur` (`id_dresseur`),
  KEY `FK_pokemons_id_type_pokemons` (`id_type_pokemons`),
  CONSTRAINT `FK_pokemons_id_attaques_1` FOREIGN KEY (`id_attaques_1`) REFERENCES `attaques` (`id_attaques`),
  CONSTRAINT `FK_pokemons_id_attaques_2` FOREIGN KEY (`id_attaques_2`) REFERENCES `attaques` (`id_attaques`),
  CONSTRAINT `FK_pokemons_id_attaques_3` FOREIGN KEY (`id_attaques_3`) REFERENCES `attaques` (`id_attaques`),
  CONSTRAINT `FK_pokemons_id_attaques_4` FOREIGN KEY (`id_attaques_4`) REFERENCES `attaques` (`id_attaques`),
  CONSTRAINT `FK_pokemons_id_dresseur` FOREIGN KEY (`id_dresseur`) REFERENCES `dresseurs` (`id_dresseur`),
  CONSTRAINT `FK_pokemons_id_type_pokemons` FOREIGN KEY (`id_type_pokemons`) REFERENCES `typedepokemons` (`id_type_pokemons`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemons`
--

LOCK TABLES `pokemons` WRITE;
/*!40000 ALTER TABLE `pokemons` DISABLE KEYS */;
INSERT INTO `pokemons` VALUES (1,'Pikachu',10,'2015-11-19',6,17,18,19,29,1),(2,'Sulfura',15,'2015-11-19',6,28,40,26,6,6);
/*!40000 ALTER TABLE `pokemons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS `positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `positions` (
  `id_positions` int(11) NOT NULL AUTO_INCREMENT,
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `id_zones` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_positions`),
  KEY `FK_positions_id_zones` (`id_zones`),
  CONSTRAINT `FK_positions_id_zones` FOREIGN KEY (`id_zones`) REFERENCES `zones` (`id_zones`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `possedelestypes`
--

DROP TABLE IF EXISTS `possedelestypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `possedelestypes` (
  `id_type_pokemons` int(11) NOT NULL,
  `id_types` int(11) NOT NULL,
  PRIMARY KEY (`id_type_pokemons`,`id_types`),
  KEY `FK_possedeLesTypes_id_types` (`id_types`),
  CONSTRAINT `FK_possedeLesTypes_id_types` FOREIGN KEY (`id_types`) REFERENCES `types` (`id_types`),
  CONSTRAINT `FK_possedeLesTypes_id_type_pokemons` FOREIGN KEY (`id_type_pokemons`) REFERENCES `typedepokemons` (`id_type_pokemons`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `possedelestypes`
--

LOCK TABLES `possedelestypes` WRITE;
/*!40000 ALTER TABLE `possedelestypes` DISABLE KEYS */;
INSERT INTO `possedelestypes` VALUES (1,5),(5,5),(6,6),(2,10),(3,10),(4,10),(2,11),(3,11),(4,11),(7,12),(6,17);
/*!40000 ALTER TABLE `possedelestypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typedepokemons`
--

DROP TABLE IF EXISTS `typedepokemons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typedepokemons` (
  `id_type_pokemons` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  `attaque` int(11) DEFAULT NULL,
  `attaque_spe` int(11) DEFAULT NULL,
  `defence` int(11) DEFAULT NULL,
  `defence_spe` int(11) DEFAULT NULL,
  `vitesse` int(11) DEFAULT NULL,
  `pv` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_type_pokemons`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typedepokemons`
--

LOCK TABLES `typedepokemons` WRITE;
/*!40000 ALTER TABLE `typedepokemons` DISABLE KEYS */;
INSERT INTO `typedepokemons` VALUES (1,'Pikachu',55,50,30,40,90,35),(2,'Chétiflor',75,70,35,30,40,50),(3,'Boustiflor',90,85,50,45,55,65),(4,'Empiflor',105,100,65,60,70,80),(5,'Raichu',90,90,55,80,100,60),(6,'Sulfura',100,125,90,85,90,90),(7,'Mewtwo',110,154,90,90,130,106);
/*!40000 ALTER TABLE `typedepokemons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `types` (
  `id_types` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  PRIMARY KEY (`id_types`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` VALUES (1,'acier'),(2,'combat'),(3,'dragon'),(4,'eau'),(5,'electrik'),(6,'feu'),(7,'galce'),(8,'insecte'),(9,'normal'),(10,'plante'),(11,'poison'),(12,'psy'),(13,'roche'),(14,'sol'),(15,'spectre'),(16,'tenebres'),(17,'vol');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viedans`
--

DROP TABLE IF EXISTS `viedans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viedans` (
  `id_zones` int(11) NOT NULL,
  `id_type_pokemons` int(11) NOT NULL,
  PRIMARY KEY (`id_zones`,`id_type_pokemons`),
  KEY `FK_vieDans_id_type_pokemons` (`id_type_pokemons`),
  CONSTRAINT `FK_vieDans_id_type_pokemons` FOREIGN KEY (`id_type_pokemons`) REFERENCES `typedepokemons` (`id_type_pokemons`),
  CONSTRAINT `FK_vieDans_id_zones` FOREIGN KEY (`id_zones`) REFERENCES `zones` (`id_zones`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viedans`
--

LOCK TABLES `viedans` WRITE;
/*!40000 ALTER TABLE `viedans` DISABLE KEYS */;
/*!40000 ALTER TABLE `viedans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zones`
--

DROP TABLE IF EXISTS `zones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zones` (
  `id_zones` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  `id_badges` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_zones`),
  KEY `FK_zones_id_badges` (`id_badges`),
  CONSTRAINT `FK_zones_id_badges` FOREIGN KEY (`id_badges`) REFERENCES `badges` (`id_badges`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zones`
--

LOCK TABLES `zones` WRITE;
/*!40000 ALTER TABLE `zones` DISABLE KEYS */;
/*!40000 ALTER TABLE `zones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-24 18:00:42
