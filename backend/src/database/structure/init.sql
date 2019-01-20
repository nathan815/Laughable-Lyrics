CREATE DATABASE `laughable_lyrics`;

CREATE TABLE `translations` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `song_id` int(11) unsigned DEFAULT NULL,
  `stages` int(11) DEFAULT NULL,
  `languages` varchar(400) DEFAULT NULL,
  `original_lyrics` text DEFAULT NULL,
  `translated_lyrics` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;