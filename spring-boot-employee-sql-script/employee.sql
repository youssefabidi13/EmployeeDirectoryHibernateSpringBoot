CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Youssef','ABIDI','youssef.abidi@etu.uae.com'),
	(2,'Zakaria','AITALI','zakaria.aitali@etu.uae.com'),
	(3,'Leo','MESSI','leo.messi@etu.uae.com'),
	(4,'Yuri','Petrov','yuri@etu.uae.com'),
	(5,'Juan','Vega','juan@etu.uae.com');

