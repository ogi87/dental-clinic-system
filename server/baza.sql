/*
SQLyog Community v13.3.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - stomatoloska_ordinacija
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stomatoloska_ordinacija` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `stomatoloska_ordinacija`;

/*Table structure for table `kategorija_klijenta` */

DROP TABLE IF EXISTS `kategorija_klijenta`;

CREATE TABLE `kategorija_klijenta` (
  `id_kategorija` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `popust` double NOT NULL,
  PRIMARY KEY (`id_kategorija`),
  UNIQUE KEY `naziv` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `kategorija_klijenta` */

insert  into `kategorija_klijenta`(`id_kategorija`,`naziv`,`popust`) values 
(1,'Standard',0),
(2,'Premium',10),
(3,'VIP',20);

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `id_klijent` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) NOT NULL,
  `prezime` varchar(100) NOT NULL,
  `kontakt` varchar(100) NOT NULL,
  `id_kategorija` int(11) NOT NULL,
  PRIMARY KEY (`id_klijent`),
  KEY `fk_klijent_kategorija` (`id_kategorija`),
  CONSTRAINT `fk_klijent_kategorija` FOREIGN KEY (`id_kategorija`) REFERENCES `kategorija_klijenta` (`id_kategorija`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `klijent` */

insert  into `klijent`(`id_klijent`,`ime`,`prezime`,`kontakt`,`id_kategorija`) values 
(1,'Ognjen','Tomic','0691611945',1),
(2,'Jovana','Jovanovic','0652222222',2),
(4,'pera','mika','069163232',3),
(11,'jared','butler','333555',3),
(12,'Cody','Mctyre','67',3),
(16,'nikola','kalinic','33222',2),
(17,'nikola','kalinic','1111',1),
(19,'Jovana','Jovanovic','06522222',2),
(20,'dada','dada','222',2);

/*Table structure for table `kvalifikacija` */

DROP TABLE IF EXISTS `kvalifikacija`;

CREATE TABLE `kvalifikacija` (
  `id_kvalifikacija` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  PRIMARY KEY (`id_kvalifikacija`),
  UNIQUE KEY `naziv` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `kvalifikacija` */

insert  into `kvalifikacija`(`id_kvalifikacija`,`naziv`) values 
(5,'Deciji'),
(10,'novo'),
(1,'Opsta stomatologija'),
(2,'Oralna hirurgija'),
(3,'Ortodontija'),
(7,'pomocni'),
(9,'pomocnik'),
(6,'proteticar'),
(8,'sestra'),
(4,'Tehnicar'),
(12,'test10000'),
(11,'test67');

/*Table structure for table `materijal` */

DROP TABLE IF EXISTS `materijal`;

CREATE TABLE `materijal` (
  `id_materijal` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `cena` double NOT NULL,
  PRIMARY KEY (`id_materijal`),
  UNIQUE KEY `naziv` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `materijal` */

insert  into `materijal`(`id_materijal`,`naziv`,`cena`) values 
(1,'Kompozit',2500),
(2,'Anestezija',800),
(3,'Plomba',1500);

/*Table structure for table `stavka_usluge` */

DROP TABLE IF EXISTS `stavka_usluge`;

CREATE TABLE `stavka_usluge` (
  `id_usluga` int(11) NOT NULL,
  `rb` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL,
  `cena` double NOT NULL,
  `iznos` double NOT NULL,
  `id_materijal` int(11) NOT NULL,
  PRIMARY KEY (`id_usluga`,`rb`),
  KEY `fk_stavka_usluge_materijal` (`id_materijal`),
  CONSTRAINT `fk_stavka_usluge_materijal` FOREIGN KEY (`id_materijal`) REFERENCES `materijal` (`id_materijal`) ON UPDATE CASCADE,
  CONSTRAINT `fk_stavka_usluge_usluga` FOREIGN KEY (`id_usluga`) REFERENCES `usluga` (`id_usluga`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `stavka_usluge` */

insert  into `stavka_usluge`(`id_usluga`,`rb`,`kolicina`,`cena`,`iznos`,`id_materijal`) values 
(1,1,1,2500,2500,1),
(2,1,1,2000,2000,3),
(3,1,1,800,800,2),
(3,2,1,1500,1500,3),
(4,1,1,1500,1500,3),
(4,2,1,800,800,2),
(6,1,3,800,2400,2),
(6,2,1,800,800,2),
(17,1,3,800,2400,2),
(21,1,3,800,2400,2),
(22,1,5,800,4000,2),
(23,1,4,800,3200,2);

/*Table structure for table `usluga` */

DROP TABLE IF EXISTS `usluga`;

CREATE TABLE `usluga` (
  `id_usluga` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `ukupan_iznos` double NOT NULL,
  `popust` double NOT NULL,
  `ukupan_iznos_sa_popustom` double NOT NULL,
  `id_zubar` int(11) NOT NULL,
  `id_klijent` int(11) NOT NULL,
  PRIMARY KEY (`id_usluga`),
  KEY `fk_usluga_zubar` (`id_zubar`),
  KEY `fk_usluga_klijent` (`id_klijent`),
  CONSTRAINT `fk_usluga_klijent` FOREIGN KEY (`id_klijent`) REFERENCES `klijent` (`id_klijent`) ON UPDATE CASCADE,
  CONSTRAINT `fk_usluga_zubar` FOREIGN KEY (`id_zubar`) REFERENCES `zubar` (`id_zubar`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `usluga` */

insert  into `usluga`(`id_usluga`,`naziv`,`ukupan_iznos`,`popust`,`ukupan_iznos_sa_popustom`,`id_zubar`,`id_klijent`) values 
(1,'Popravka zuba',2500,5,2375,2,4),
(2,'Ciscenje kamenca',2000,10,1800,1,1),
(3,'Vadjenje zivca',3800,5,3610,1,1),
(4,'Revitalizacija',2300,5,2185,2,2),
(6,'Vadjenje leka',3200,5,3040,1,1),
(17,'sadasdasdasd',2400,2,2352,1,1),
(21,'konacno',2400,2,2352,1,1),
(22,'testpostotiput',4000,2,3920,2,11),
(23,'test1000',3200,1,3168,2,4);

/*Table structure for table `zubar` */

DROP TABLE IF EXISTS `zubar`;

CREATE TABLE `zubar` (
  `id_zubar` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) NOT NULL,
  `prezime` varchar(100) NOT NULL,
  `korisnicko_ime` varchar(100) NOT NULL,
  `sifra` varchar(100) NOT NULL,
  PRIMARY KEY (`id_zubar`),
  UNIQUE KEY `korisnicko_ime` (`korisnicko_ime`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `zubar` */

insert  into `zubar`(`id_zubar`,`ime`,`prezime`,`korisnicko_ime`,`sifra`) values 
(1,'Ana','Anic','ana','123'),
(2,'Marko','Markovic','marko','123');

/*Table structure for table `zubar_kvalifikacija` */

DROP TABLE IF EXISTS `zubar_kvalifikacija`;

CREATE TABLE `zubar_kvalifikacija` (
  `id_zubar` int(11) NOT NULL,
  `id_kvalifikacija` int(11) NOT NULL,
  `datum_sticanja` date NOT NULL,
  PRIMARY KEY (`id_zubar`,`id_kvalifikacija`),
  KEY `fk_zk_kvalifikacija` (`id_kvalifikacija`),
  CONSTRAINT `fk_zk_kvalifikacija` FOREIGN KEY (`id_kvalifikacija`) REFERENCES `kvalifikacija` (`id_kvalifikacija`) ON UPDATE CASCADE,
  CONSTRAINT `fk_zk_zubar` FOREIGN KEY (`id_zubar`) REFERENCES `zubar` (`id_zubar`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `zubar_kvalifikacija` */

insert  into `zubar_kvalifikacija`(`id_zubar`,`id_kvalifikacija`,`datum_sticanja`) values 
(1,1,'2020-06-15'),
(1,2,'2022-09-01'),
(2,1,'2021-03-10');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
