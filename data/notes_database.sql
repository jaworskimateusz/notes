DROP DATABASE  IF EXISTS `notes_database`;

CREATE DATABASE  IF NOT EXISTS `notes_database`;
USE `notes_database`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `users` (username, email, password)
VALUES 
('Mateusz','mateusz@email.com', '$2a$10$wnTAd4mvHizJnqPGVAJZJ.AT193MeEnrX1NuftHZl5scly43tHSlu');

DROP TABLE IF EXISTS `notes`;

CREATE TABLE `notes` (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` TEXT NOT NULL,
  `modification_date` DATE NOT NULL,
  `priority` varchar(4) DEFAULT 'low',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`note_id`),
  KEY `FK_USER_idx` (`user_id`),
  CONSTRAINT `FK_USER`
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `notes` (title, content, modification_date, priority, user_id)
VALUES 
('Workout', 'Chest & shoulders progress with weights.', now(), 'high', 1),
('Diet', 'My diet for chrismas is 3300 kcal per day, 180 grams of protein.', '2019-01-01', 'low', 1),
('Java', 'Spend more time for programming.', '2019-01-05', 'low', 1),
('Rest API', 'Gain your knowledge, learn about microservices.', now(), 'high', 1),
('TDD', 'Find nice course, learn and write tests for application.', now(), 'high', 1);

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT "USER",
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `roles` (name)
VALUES ("USER"),("ADMIN");

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),

  CONSTRAINT `FK_USER_01` FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `roles` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 1),
(1, 2);
