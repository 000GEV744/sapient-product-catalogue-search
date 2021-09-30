CREATE DATABASE  IF NOT EXISTS `sp_product-catalogue_tracker`;
USE `sp_product-catalogue_tracker`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `seller`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `seller_name` varchar(45) DEFAULT NULL,
     PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `category`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`category_name` varchar(45) DEFAULT NULL,
     PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`category_id`)
  REFERENCES `category` (`id`),
  CONSTRAINT `FK_DETAIL_S` FOREIGN KEY (`seller_id`)
  REFERENCES `seller` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;