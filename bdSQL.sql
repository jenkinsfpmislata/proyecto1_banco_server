-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.13 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para proyecto1_banco_servidor
CREATE DATABASE IF NOT EXISTS `proyecto1_banco_servidor` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `proyecto1_banco_servidor`;


-- Volcando estructura para tabla proyecto1_banco_servidor.cuentabancaria
CREATE TABLE IF NOT EXISTS `cuentabancaria` (
  `idCuentaBancaria` int(10) NOT NULL AUTO_INCREMENT,
  `idSucursalBancaria` int(10) DEFAULT NULL,
  `numeroCuenta` varchar(50) DEFAULT NULL,
  `dc` varchar(50) DEFAULT NULL,
  `saldo` decimal(20,2) DEFAULT NULL,
  `cif` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCuentaBancaria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla proyecto1_banco_servidor.cuentabancaria: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `cuentabancaria` DISABLE KEYS */;
INSERT INTO `cuentabancaria` (`idCuentaBancaria`, `idSucursalBancaria`, `numeroCuenta`, `dc`, `saldo`, `cif`) VALUES
	(1, 1, '0001', '01', 4800.00, '67676789b'),
	(2, 1, '0002', '02', 3476.00, '43728591x'),
	(3, 2, '0003', '04', 8750.00, '76438591x'),
	(4, 3, '0004', '05', 4978.00, '68786524c'),
	(5, 3, '0005', '06', 4978.00, '61124624r');
/*!40000 ALTER TABLE `cuentabancaria` ENABLE KEYS */;


-- Volcando estructura para tabla proyecto1_banco_servidor.entidadbancaria
CREATE TABLE IF NOT EXISTS `entidadbancaria` (
  `idEntidad` int(10) NOT NULL AUTO_INCREMENT,
  `codigoEntidadBancaria` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `cif` varchar(50) DEFAULT NULL,
  `tipoEntidadBancaria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idEntidad`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla proyecto1_banco_servidor.entidadbancaria: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `entidadbancaria` DISABLE KEYS */;
INSERT INTO `entidadbancaria` (`idEntidad`, `codigoEntidadBancaria`, `nombre`, `cif`, `tipoEntidadBancaria`) VALUES
	(1, 'b001', 'Bankia', '11201', 'COOPERATIVACREDITO'),
	(2, 'b002', 'La Caixa', '1145001', 'CAJAAHORRO'),
	(3, 'b003', 'Sabadell', '11240', 'BANCO'),
	(4, 'b004', 'Caja Madrid', '009333', 'CAJAAHORRO'),
	(5, 'b005', 'BBVA', '4545000', 'BANCO'),
	(6, 'b006', 'Cofidis', '55401', 'ESTFINANCIERO');
/*!40000 ALTER TABLE `entidadbancaria` ENABLE KEYS */;


-- Volcando estructura para tabla proyecto1_banco_servidor.movimientobancario
CREATE TABLE IF NOT EXISTS `movimientobancario` (
  `idMovimientoBancario` int(10) NOT NULL AUTO_INCREMENT,
  `idCuentaBancaria` int(10) DEFAULT NULL,
  `tipoMovimientoBancario` varchar(50) DEFAULT NULL,
  `importe` decimal(10,0) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `concepto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idMovimientoBancario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla proyecto1_banco_servidor.movimientobancario: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `movimientobancario` DISABLE KEYS */;
INSERT INTO `movimientobancario` (`idMovimientoBancario`, `idCuentaBancaria`, `tipoMovimientoBancario`, `importe`, `fecha`, `concepto`) VALUES
	(1, 1, 'Debe', 500, '2014-01-07', 'prueba3'),
	(2, 1, 'Haber', 200, '2014-01-14', 'prueba2'),
	(3, 1, 'Haber', 600, '2014-01-21', 'prueba3');
/*!40000 ALTER TABLE `movimientobancario` ENABLE KEYS */;


-- Volcando estructura para tabla proyecto1_banco_servidor.sucursalbancaria
CREATE TABLE IF NOT EXISTS `sucursalbancaria` (
  `idSucursalBancaria` int(10) NOT NULL AUTO_INCREMENT,
  `idEntidadBancaria` int(10) NOT NULL DEFAULT '0',
  `codigoSucursal` varchar(50) DEFAULT NULL,
  `nombreSucursal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idSucursalBancaria`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla proyecto1_banco_servidor.sucursalbancaria: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `sucursalbancaria` DISABLE KEYS */;
INSERT INTO `sucursalbancaria` (`idSucursalBancaria`, `idEntidadBancaria`, `codigoSucursal`, `nombreSucursal`) VALUES
	(1, 1, 'br001', 'Bankia Xirivella'),
	(2, 1, 'br002', 'Bankia Alaquás'),
	(3, 2, 'br003', 'La Caixa Mislata'),
	(4, 3, 'br004', 'Sabadell Xirivella'),
	(5, 3, 'br006', 'Sabadell Aldaia'),
	(6, 3, 'br007', 'Sabadell Picanya'),
	(7, 4, 'br008', 'Caja Madrid Madrid'),
	(8, 5, 'br009', 'BBVA Valencia'),
	(9, 5, 'br010', 'BBVA Burjassot'),
	(10, 6, 'br011', 'Cofidis General'),
	(11, 1, '987987', '98798');
/*!40000 ALTER TABLE `sucursalbancaria` ENABLE KEYS */;


-- Volcando estructura para tabla proyecto1_banco_servidor.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` int(10) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido1` varchar(50) DEFAULT NULL,
  `apellido2` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `correoelectronico` varchar(50) DEFAULT NULL,
  `tipoUsuario` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla proyecto1_banco_servidor.usuarios: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`idUsuario`, `nombre`, `apellido1`, `apellido2`, `direccion`, `correoelectronico`, `tipoUsuario`, `username`, `password`) VALUES
	(1, 'root', 'root', 'root', 'Palleter 3A', 'root@gmail.com', 'EMPLEADO', 'root', 'JBMCQxKxNGh+lr27qFBgn3ha8kBBlAw7'),
	(2, 'pepe', 'martinez', 'collado', NULL, 'pmartinezcollado@gmail.com', NULL, 'pepe', 'pepe');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
