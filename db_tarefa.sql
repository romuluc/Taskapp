-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: db_tarefa
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Table structure for table `tarefa`
--

DROP TABLE IF EXISTS `tarefa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarefa` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'CÓDIGO DA TAREFA',
  `descricao` varchar(200) NOT NULL COMMENT 'DESCRICAO DA TAREFA',
  `resposta` varchar(200) DEFAULT NULL COMMENT 'RESPOSTA DA TAREFA',
  `data_criacao` datetime NOT NULL COMMENT 'DATA DE CRIAÇÃO DA TAREFA',
  `data_conclusao` datetime DEFAULT NULL COMMENT 'DATA DE CONCLUSÃO DA TAREFA',
  `concluida` char(1) NOT NULL DEFAULT 'N' COMMENT 'TAREFA CONCLUÍDA',
  `id_usuario_atrib` int(11) DEFAULT NULL COMMENT 'USUÁRIO LOGADO QUE PEGOU A TAREFA',
  PRIMARY KEY (`id`),
  KEY `id_usuario_atrib` (`id_usuario_atrib`),
  CONSTRAINT `tarefa_ibfk_1` FOREIGN KEY (`id_usuario_atrib`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarefa`
--

LOCK TABLES `tarefa` WRITE;
/*!40000 ALTER TABLE `tarefa` DISABLE KEYS */;
INSERT INTO `tarefa` VALUES (1,'Colocar máscara CPF no formulário de Registro',NULL,'2017-06-15 16:55:56',NULL,'N',1),(2,'Atualizar a base de homologação',NULL,'2017-06-15 16:56:19',NULL,'N',NULL),(3,'Criar inteface para Cadastro de Uusários no ssistema','Já realizado e enviado para homologação.','2017-06-15 16:57:09','2017-06-15 16:59:52','S',1),(4,'Criar tabelas para arquivamento de processos.',NULL,'2017-06-15 16:57:44',NULL,'N',1),(5,'Criar a pré-proposta no sistema de pedidos do cliente.','Formulário de pré-proposta criado','2017-06-15 16:58:49','2017-06-15 17:01:32','S',2),(6,'Cadastrar os usuários do departamento no sistema.',NULL,'2017-06-15 16:59:20',NULL,'N',2),(7,'Excluir a área de texto de comentários no formulário de pedido.',NULL,'2017-06-15 17:00:29',NULL,'N',NULL),(8,'Criar outros gráficos na aplicação','Gráficos criados usando Angular','2017-06-15 17:28:13','2017-06-15 17:28:51','S',2);
/*!40000 ALTER TABLE `tarefa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'CÓDIGO DO USUÁRIO',
  `usuario` varchar(30) NOT NULL COMMENT 'LOGIN DO USUÁRIO PARA ACESSO AO SISTEMA',
  `nome` varchar(50) NOT NULL COMMENT 'NOME DO USUÁRIO',
  `senha` varchar(30) NOT NULL COMMENT 'SENHA DO USUÁRIO PARA ACESSO AO SISTEMA',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'romulo','Rômulo Lucio Vale de Moraes','123456'),(2,'pedro','Pedro Oliveira Cavalcante','123456');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_tarefa'
--

--
-- Dumping routines for database 'db_tarefa'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-15 19:09:35
