CREATE DATABASE `laughable_lyrics`;

CREATE TABLE `translations` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `song_id` int(11) unsigned DEFAULT NULL,
  `stages` int(11) DEFAULT NULL,
  `languages` varchar(400) DEFAULT NULL,
  `original_lyrics` text DEFAULT NULL,
  `translated_lyrics` text DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `songs` (
  `id` int(30) unsigned NOT NULL,
  `lyrics` text DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `release_date` varchar(100) DEFAULT NULL,
  `media` text DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;