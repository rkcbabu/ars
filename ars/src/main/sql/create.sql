DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `stateName` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `apartment`;
CREATE TABLE IF NOT EXISTS `apartment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `facilities` varchar(255) DEFAULT NULL,
  `rate` varchar(255) DEFAULT NULL,
  `roomCount` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `apartment_filenames`;
CREATE TABLE IF NOT EXISTS `apartment_filenames` (
  `Apartment_id` int(11) NOT NULL,
  `fileNames` varchar(255) DEFAULT NULL
) ;

DROP TABLE IF EXISTS `rentalinfo`;
CREATE TABLE IF NOT EXISTS `rentalinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `rentalDate` datetime DEFAULT NULL,
  `apartment_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)  ;


DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `profileImage` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `verificationCode` varchar(255) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `users_apartment`;
CREATE TABLE IF NOT EXISTS `users_apartment` (
  `USERS_id` int(11) NOT NULL,
  `apartments_id` int(11) NOT NULL
);
