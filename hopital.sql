-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 05 avr. 2022 à 14:21
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hopital`
--

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
CREATE TABLE IF NOT EXISTS `consultation` (
  `Num_C` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `Matricule` varchar(10) DEFAULT NULL,
  `Num_P` int(11) DEFAULT NULL,
  PRIMARY KEY (`Num_C`),
  KEY `fk_Matricule_Medecin` (`Matricule`),
  KEY `fk_Numero_Patient` (`Num_P`)
) ENGINE=MyISAM AUTO_INCREMENT=134 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`Num_C`, `Date`, `Matricule`, `Num_P`) VALUES
(133, '2022-02-12', '10W23', 1);

-- --------------------------------------------------------

--
-- Structure de la table `examination`
--

DROP TABLE IF EXISTS `examination`;
CREATE TABLE IF NOT EXISTS `examination` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Matricule` varchar(10) NOT NULL,
  `Num_P` int(10) NOT NULL,
  `Maladie` varchar(30) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Matricule_medecin` (`Matricule`),
  KEY `fk_Num_P_patient` (`Num_P`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `examination`
--

INSERT INTO `examination` (`Id`, `Matricule`, `Num_P`, `Maladie`) VALUES
(1, '10W23', 1, 'Syphilis');

-- --------------------------------------------------------

--
-- Structure de la table `hospitalisation`
--

DROP TABLE IF EXISTS `hospitalisation`;
CREATE TABLE IF NOT EXISTS `hospitalisation` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `salle` varchar(8) NOT NULL,
  `Num_P` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Heure` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Numero_Patient` (`Num_P`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hospitalisation`
--

INSERT INTO `hospitalisation` (`Id`, `salle`, `Num_P`, `Date`, `Heure`) VALUES
(1, '4', 1, '2022-02-12', '11:20:08');

-- --------------------------------------------------------

--
-- Structure de la table `infirmier`
--

DROP TABLE IF EXISTS `infirmier`;
CREATE TABLE IF NOT EXISTS `infirmier` (
  `Matricule` varchar(10) CHARACTER SET armscii8 NOT NULL,
  `Nom` varchar(30) NOT NULL,
  PRIMARY KEY (`Matricule`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `infirmier`
--

INSERT INTO `infirmier` (`Matricule`, `Nom`) VALUES
('19H3426', 'MABA  Anie'),
('12L5643', 'MUKAM Patrice'),
('20W3267', 'MAKAMTCHUENG Dorine'),
('15D5643', 'MAGNE Blandine'),
('19Z3456', 'DJOUKA Germaine');

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
CREATE TABLE IF NOT EXISTS `medecin` (
  `Matricule` varchar(8) NOT NULL,
  `Nom_M` text CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`Matricule`, `Nom_M`) VALUES
('10W23', 'Aurelie manga'),
('11T3487', 'WAFO EZekiel '),
('12M547', 'DINABEL Thomas'),
('12T3453', 'ANA'),
('13T76', 'ANA'),
('15M003', 'FONO Jack'),
('15X1243', 'EDZOUGOU Yannick'),
('15Z436', 'AYEMELI Chritophe'),
('16M009', 'KANA Pierrette'),
('19K1198', 'AKONO Marthe'),
('2065T56', 'Anabele'),
('20G243', 'AMINATOU Nafi'),
('20J4356', 'FONKOU Aicha'),
('20T234', 'Moulen'),
('20T54328', 'Anabele');

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

DROP TABLE IF EXISTS `medicament`;
CREATE TABLE IF NOT EXISTS `medicament` (
  `Code_M` varchar(8) NOT NULL,
  `Libélé` text CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Code_M`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medicament`
--

INSERT INTO `medicament` (`Code_M`, `Libélé`) VALUES
('00M02', 'Paracétamol'),
('07M20', 'Efferalgang'),
('10M40', 'Quinine'),
('17M40', 'Arthémesia');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `Num_P` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_P` text NOT NULL,
  `Sexe` text NOT NULL,
  PRIMARY KEY (`Num_P`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`Num_P`, `Nom_P`, `Sexe`) VALUES
(1, 'Ruth-Hélène moulen', 'F'),
(2, 'Wafo Chirine', 'F'),
(3, 'Essomba Zack', 'M'),
(4, 'Ayissi Martin', 'M'),
(5, 'Mve Yannick', 'M'),
(6, 'OBALA Ange', 'F'),
(7, 'AFIAMBA GEOGE', 'M'),
(8, 'ONAMBELE Dorine', 'F'),
(9, 'OYONO Christian', 'M'),
(14, 'EDZOUGOU Yannick', 'M');

-- --------------------------------------------------------

--
-- Structure de la table `pharmacie`
--

DROP TABLE IF EXISTS `pharmacie`;
CREATE TABLE IF NOT EXISTS `pharmacie` (
  `Id` varchar(10) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Quartier` varchar(30) NOT NULL,
  `Code_M` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Code_Medicament` (`Code_M`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pharmacie`
--

INSERT INTO `pharmacie` (`Id`, `Nom`, `Quartier`, `Code_M`) VALUES
('O8967', 'Njohnjoh', 'Bonapriso', '00M02'),
('246799', 'Saint Nicolas', 'Bonadjo', '07M20'),
('98654', 'Larousse', 'Ange Rapahael', '10M40'),
('314268', 'Lenil', 'Village Ndogpassi', '17M40');

-- --------------------------------------------------------

--
-- Structure de la table `planingmedecin`
--

DROP TABLE IF EXISTS `planingmedecin`;
CREATE TABLE IF NOT EXISTS `planingmedecin` (
  `Id_M` int(11) NOT NULL AUTO_INCREMENT,
  `Matricule` varchar(10) DEFAULT NULL,
  `Jours` varchar(20) DEFAULT NULL,
  `HeureDebut` varchar(20) DEFAULT NULL,
  `HeureFin` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_M`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `planingmedecin`
--

INSERT INTO `planingmedecin` (`Id_M`, `Matricule`, `Jours`, `HeureDebut`, `HeureFin`) VALUES
(1, '10W23', 'Lundi', '06:55:37', '06:55:37');

-- --------------------------------------------------------

--
-- Structure de la table `prescrire`
--

DROP TABLE IF EXISTS `prescrire`;
CREATE TABLE IF NOT EXISTS `prescrire` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Code_M` varchar(8) NOT NULL,
  `Matricule` varchar(10) NOT NULL,
  `Num_P` int(11) DEFAULT NULL,
  `Libélé` varchar(30) DEFAULT NULL,
  `Pharmacie` varchar(30) DEFAULT NULL,
  `NbrePrise` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Matricule_Medecin` (`Matricule`),
  KEY `fk_Numero_Patient` (`Num_P`),
  KEY `fk_Code_Medicament` (`Code_M`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `prescrire`
--

INSERT INTO `prescrire` (`Id`, `Code_M`, `Matricule`, `Num_P`, `Libélé`, `Pharmacie`, `NbrePrise`) VALUES
(1, '00M45', '10W23', 1, 'Efferalgan', 'Njoh-Njoh', 2);

-- --------------------------------------------------------

--
-- Structure de la table `rendezvous`
--

DROP TABLE IF EXISTS `rendezvous`;
CREATE TABLE IF NOT EXISTS `rendezvous` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Matricule` varchar(10) NOT NULL,
  `Num_P` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Heure` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Matricule_Medecin` (`Matricule`),
  KEY `fk_Numero_Patient` (`Num_P`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rendezvous`
--

INSERT INTO `rendezvous` (`Id`, `Matricule`, `Num_P`, `Date`, `Heure`) VALUES
(1, '10W23', 1, '2022-02-12', '10:40:10');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `examination`
--
ALTER TABLE `examination`
  ADD CONSTRAINT `examination_ibfk_1` FOREIGN KEY (`Matricule`) REFERENCES `medecin` (`Matricule`),
  ADD CONSTRAINT `examination_ibfk_2` FOREIGN KEY (`Num_P`) REFERENCES `patient` (`Num_P`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
