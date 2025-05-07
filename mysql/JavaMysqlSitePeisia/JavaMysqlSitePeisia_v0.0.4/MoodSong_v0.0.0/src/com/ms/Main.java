package com.ms;

import com.database.DatabaseSetup;

public class Main {

	public static void main(String[] args) {
		DatabaseSetup.setupDatabase();

		// 1 = 우울할 때 듣는 노래, 2 = 신나는 노래, 3 = 드라이브 할 때 듣는 노래
		String randomSong = RandomSongPicker.getRandomSongByCategory("3");
		System.out.println(randomSong);
	}
}
