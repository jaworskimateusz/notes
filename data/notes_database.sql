DROP DATABASE  IF EXISTS `notes_database`;

CREATE DATABASE  IF NOT EXISTS `notes_database`;
USE `notes_database`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `users` (name, email, password)
VALUES 
('mateusz','mateusz@email.com', 'mateusz'),
('don', 'don.joe@email.com', 'don');

DROP TABLE IF EXISTS `notes`;

CREATE TABLE `notes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` TEXT DEFAULT NULL,
  `modification_date` TIMESTAMP NOT NULL,
  `priority` varchar(1) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USER_idx` (`user_id`),
  CONSTRAINT `FK_INSTRUCTOR`
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `notes` (title, content, modification_date, priority, user_id)
VALUES 
('Do the workout', 'Chest, shoulders, back...', now(), null, 1);

