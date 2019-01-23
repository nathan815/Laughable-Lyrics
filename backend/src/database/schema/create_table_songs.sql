CREATE TABLE `songs` (
  `id` int(30) unsigned NOT NULL,
  `lyrics` text DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `release_date` varchar(100) DEFAULT NULL,
  `media` text DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;