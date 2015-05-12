-- MySQL dump 10.15  Distrib 10.0.13-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: bibliotecaLp3
-- ------------------------------------------------------
-- Server version	10.0.13-MariaDB

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
-- Table structure for table `assunto`
--

DROP TABLE IF EXISTS `assunto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assunto` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assunto`
--

LOCK TABLES `assunto` WRITE;
/*!40000 ALTER TABLE `assunto` DISABLE KEYS */;
INSERT INTO `assunto` VALUES (1,'Português'),(2,'Matemática'),(3,'Física'),(4,'Química');
/*!40000 ALTER TABLE `assunto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Arthur Carvalho'),(2,'Guilherme Azevedo'),(3,'Carol Penha'),(4,'Izaldir Bezerra');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Financeiro'),(2,'Manutenção'),(3,'Balcão');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editora`
--

DROP TABLE IF EXISTS `editora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `editora` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editora`
--

LOCK TABLES `editora` WRITE;
/*!40000 ALTER TABLE `editora` DISABLE KEYS */;
INSERT INTO `editora` VALUES (1,'Scipione','Rua 1° de Maio'),(2,'Vegas','Tv. Dhalsin nº 47'),(3,'LaCorte','Rua Aparecida nº 187');
/*!40000 ALTER TABLE `editora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emprestimo`
--

DROP TABLE IF EXISTS `emprestimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emprestimo` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `exemplar` int(15) NOT NULL,
  `dtaEmprestimo` datetime NOT NULL,
  `usuario` int(15) NOT NULL,
  `funcEmprestimo` int(15) NOT NULL,
  `dtaDevolucao` datetime DEFAULT NULL,
  `funcDevolucao` int(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Exemplar_Emprestimo` (`exemplar`),
  KEY `fk_Usuario_Emprestimo` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emprestimo`
--

LOCK TABLES `emprestimo` WRITE;
/*!40000 ALTER TABLE `emprestimo` DISABLE KEYS */;
/*!40000 ALTER TABLE `emprestimo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exemplar`
--

DROP TABLE IF EXISTS `exemplar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exemplar` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `obra` int(15) NOT NULL,
  `dtaAquisicao` datetime NOT NULL,
  `emprestado` int(11) DEFAULT '0',
  `reservado` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_Obra_Exemplar` (`obra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exemplar`
--

LOCK TABLES `exemplar` WRITE;
/*!40000 ALTER TABLE `exemplar` DISABLE KEYS */;
/*!40000 ALTER TABLE `exemplar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `matricula` varchar(50) NOT NULL,
  `departamento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_funcionario_departamento1_idx` (`departamento`),
  CONSTRAINT `fk_funcionario_departamento` FOREIGN KEY (`departamento`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Fernando Oliveira','1232',2),(2,'Gabriella Diniz','98465',1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obra`
--

DROP TABLE IF EXISTS `obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obra` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(25) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `ano` varchar(25) NOT NULL,
  `editora` int(15) NOT NULL,
  `tipo` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Obra_Editora` (`editora`),
  KEY `fk_Obra_Tipo` (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obra`
--

LOCK TABLES `obra` WRITE;
/*!40000 ALTER TABLE `obra` DISABLE KEYS */;
/*!40000 ALTER TABLE `obra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obraAssunto`
--

DROP TABLE IF EXISTS `obraAssunto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obraAssunto` (
  `obra` int(15) NOT NULL,
  `assunto` int(15) NOT NULL,
  KEY `fk_Assunto_Obra` (`assunto`),
  KEY `fk_Obra_Assunto` (`obra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obraAssunto`
--

LOCK TABLES `obraAssunto` WRITE;
/*!40000 ALTER TABLE `obraAssunto` DISABLE KEYS */;
/*!40000 ALTER TABLE `obraAssunto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obraAutor`
--

DROP TABLE IF EXISTS `obraAutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obraAutor` (
  `obra` int(15) NOT NULL,
  `autor` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obraAutor`
--

LOCK TABLES `obraAutor` WRITE;
/*!40000 ALTER TABLE `obraAutor` DISABLE KEYS */;
/*!40000 ALTER TABLE `obraAutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obraTipo`
--

DROP TABLE IF EXISTS `obraTipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obraTipo` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obraTipo`
--

LOCK TABLES `obraTipo` WRITE;
/*!40000 ALTER TABLE `obraTipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `obraTipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `exemplar` int(15) NOT NULL,
  `usuario` int(15) NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Exemplar_Reserva` (`exemplar`),
  KEY `fk_Usuario_Reserva` (`usuario`),
  CONSTRAINT `fk_Usuario_Reserva` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Maria José','rua sobe e desce','3232-3232'),(2,'Bruno Pereira','Rua da Conceição','3216-9466'),(3,'Sergio Irineu','Tv. 32 Qd 22','3265-3285'),(4,'Alex da Silva','Av. dos Anjos 32',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-12 17:20:42
