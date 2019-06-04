-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 04 juin 2019 à 12:33
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `id_annee` bigint(20) NOT NULL,
  PRIMARY KEY (`id_annee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `anneescolaire`
--

INSERT INTO `anneescolaire` (`id_annee`) VALUES
(100);

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id_bulletin` bigint(20) NOT NULL,
  `id_trimestre` bigint(20) NOT NULL,
  `id_inscription` bigint(20) NOT NULL,
  `appreciation_globale` varchar(100) NOT NULL,
  PRIMARY KEY (`id_bulletin`),
  KEY `cntrnt9` (`id_inscription`),
  KEY `cntrnt10` (`id_trimestre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id_classe` bigint(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `id_niveau` bigint(20) NOT NULL,
  `id_annee` bigint(20) NOT NULL,
  PRIMARY KEY (`id_classe`),
  KEY `cntrnt2` (`id_annee`),
  KEY `cntrnt3` (`id_niveau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id_detail` bigint(20) NOT NULL,
  `id_bulletin` bigint(20) NOT NULL,
  `id_enseignement` bigint(20) NOT NULL,
  `appreciation` varchar(150) NOT NULL,
  PRIMARY KEY (`id_detail`),
  KEY `cntrnt11` (`id_bulletin`),
  KEY `cntrnt12` (`id_enseignement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id_discipline` bigint(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id_discipline`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `id_enseignement` bigint(20) NOT NULL,
  `id_classe` bigint(20) NOT NULL,
  `id_discipline` bigint(20) NOT NULL,
  `id_personne` bigint(20) NOT NULL,
  PRIMARY KEY (`id_enseignement`),
  KEY `cntrnt4` (`id_classe`),
  KEY `cntrnt5` (`id_discipline`),
  KEY `cntrnt6` (`id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id_evaluation` bigint(20) NOT NULL,
  `id_detail` bigint(20) NOT NULL,
  `note` int(11) NOT NULL,
  `appreciation` varchar(50) NOT NULL,
  PRIMARY KEY (`id_evaluation`),
  KEY `cntrnt13` (`id_detail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id_inscription` bigint(20) NOT NULL,
  `id_classe` bigint(20) NOT NULL,
  `id_personne` bigint(20) NOT NULL,
  PRIMARY KEY (`id_inscription`),
  KEY `cntrnt7` (`id_classe`),
  KEY `cntrnt8` (`id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id_niveau` bigint(20) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_niveau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id_personne` bigint(20) NOT NULL,
  `type` varchar(15) NOT NULL DEFAULT 'élève',
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  PRIMARY KEY (`id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id_trimestre` bigint(20) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `id_annee` bigint(20) NOT NULL,
  PRIMARY KEY (`id_trimestre`),
  KEY `cntrnt1` (`id_annee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `cntrnt10` FOREIGN KEY (`id_trimestre`) REFERENCES `trimestre` (`id_trimestre`),
  ADD CONSTRAINT `cntrnt9` FOREIGN KEY (`id_inscription`) REFERENCES `inscription` (`id_inscription`);

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `cntrnt2` FOREIGN KEY (`id_annee`) REFERENCES `anneescolaire` (`id_annee`),
  ADD CONSTRAINT `cntrnt3` FOREIGN KEY (`id_niveau`) REFERENCES `niveau` (`id_niveau`);

--
-- Contraintes pour la table `detailbulletin`
--
ALTER TABLE `detailbulletin`
  ADD CONSTRAINT `cntrnt11` FOREIGN KEY (`id_bulletin`) REFERENCES `bulletin` (`id_bulletin`),
  ADD CONSTRAINT `cntrnt12` FOREIGN KEY (`id_enseignement`) REFERENCES `enseignement` (`id_enseignement`);

--
-- Contraintes pour la table `enseignement`
--
ALTER TABLE `enseignement`
  ADD CONSTRAINT `cntrnt4` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`),
  ADD CONSTRAINT `cntrnt5` FOREIGN KEY (`id_discipline`) REFERENCES `discipline` (`id_discipline`),
  ADD CONSTRAINT `cntrnt6` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`);

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `cntrnt13` FOREIGN KEY (`id_detail`) REFERENCES `detailbulletin` (`id_detail`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `cntrnt7` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`),
  ADD CONSTRAINT `cntrnt8` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`);

--
-- Contraintes pour la table `trimestre`
--
ALTER TABLE `trimestre`
  ADD CONSTRAINT `cntrnt1` FOREIGN KEY (`id_annee`) REFERENCES `anneescolaire` (`id_annee`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
