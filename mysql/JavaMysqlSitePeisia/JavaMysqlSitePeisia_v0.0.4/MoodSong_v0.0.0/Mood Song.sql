use my_cat;

CREATE DATABASE IF NOT EXISTS mood_songs_db;
USE mood_songs_db;

CREATE TABLE IF NOT EXISTS mood_songs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mood_category VARCHAR(100) NOT NULL,
    song_title VARCHAR(100) NOT NULL
);

-- 1 = 우울할 때 듣는 노래, 2 = 신나는 노래, 3 = 드라이브 할 때 듣는 노래

INSERT INTO mood_songs (mood_category, song_title) VALUES
('1', 'Someone Like You - Adele'),
('1', 'Fix You - Coldplay'),
('1', 'Hurt - Johnny Cash'),
('1', '바람이 분다 - 이소라'),
('1', '오래전 그날 - 폴킴'),
('1', '길 - god'),
('1', '시계 - browneyed soul'),
('1', '한계 - 백예린'),
('2', 'Uptown Funk - Mark Ronson ft. Bruno Mars'),
('2', 'Can’t Stop the Feeling! - Justin Timberlake'),
('2', 'Happy - Pharrell Williams'),
('2', 'Gloomy stars - 공기남'),
('2', 'Super Nova - Aespa'),
('2', '고민중독 - Qwer'),
('2', 'Magnetic - 아일릿'),
('2', 'Drama - 에스파'),
('3', 'Shut Up and Dance - WALK THE MOON'),
('3', 'Ride - Twenty One Pilots'),
('3', 'Peaches - Justin Bieber'),
('3', '한페이지가 될 수 있게 - DAY6'),
('3', 'Movie - Junny'),
('3', 'Square - 백예린'),
('3', 'Gradation - 10cm'),
('3', 'Sweet Child O’ Mine - Guns N’ Roses');


SELECT song_title
FROM mood_songs
WHERE mood_category = '3'
ORDER
 BY RAND()
LIMIT 1;
