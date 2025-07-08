CREATE TABLE `gift` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `feature` varchar(10000) NOT NULL,
  `addr` varchar(1000) NOT NULL,
  `tel` varchar(100) NOT NULL,
  `picurl` varchar(1000) NOT NULL,
  `city` varchar(100) NOT NULL,
  `town` varchar(100) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
