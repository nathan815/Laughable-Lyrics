CREATE TABLE `translations` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `song_id` int(11) unsigned DEFAULT NULL,
  `stages` int(11) DEFAULT NULL,
  `languages` varchar(400) DEFAULT NULL,
  `translated_lyrics` text DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `translation_song_id` (`song_id`),
  CONSTRAINT `translation_song_id` FOREIGN KEY (`song_id`) REFERENCES `songs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;