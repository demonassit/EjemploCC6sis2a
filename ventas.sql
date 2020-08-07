-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.22


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sistemaventas
--

CREATE DATABASE IF NOT EXISTS ventas;
USE ventas;

--
-- Definition of table `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `producto_Codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `producto_Nombre` varchar(45) NOT NULL,
  `producto_Precio` varchar(45) NOT NULL,
  `producto_Stock` varchar(45) NOT NULL,
  PRIMARY KEY (`producto_Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `producto`
--

/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`producto_Codigo`,`producto_Nombre`,`producto_Precio`,`producto_Stock`) VALUES 
 (1,'lapiz','3','18'),
 (2,'sacapuntas','6','27'),
 (3,'cuaderno','10','80'),
 (4,'goma','4','60'),
 (5,'pluma','6','38');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `usuario_Codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usuario_Nombre` varchar(45) NOT NULL,
  `usuario_Apellido` varchar(45) NOT NULL,
  `usuario_User` varchar(45) NOT NULL,
  `usuario_Clave` varchar(45) NOT NULL,
  `usuario_Privilegio` int(10) unsigned NOT NULL,
  PRIMARY KEY (`usuario_Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`usuario_Codigo`,`usuario_Nombre`,`usuario_Apellido`,`usuario_User`,`usuario_Clave`,`usuario_Privilegio`) VALUES 
 (1,'Jaime','Minor Gomez','jaime','jaime',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
