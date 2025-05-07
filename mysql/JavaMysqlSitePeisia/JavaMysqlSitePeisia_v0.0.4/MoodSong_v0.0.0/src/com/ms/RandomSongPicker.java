package com.ms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.database.DatabaseConnection;

public class RandomSongPicker {
	public static String getRandomSongByCategory(String moodCategory) {
		String query = "SELECT song_title FROM mood_songs WHERE mood_category = '" + moodCategory
				+ "' ORDER BY RAND() LIMIT 1";
		List<String> songs = new ArrayList<>();

		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {

			while (resultSet.next()) {
				songs.add(resultSet.getString("song_title"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return songs.isEmpty() ? "No songs available for this category" : songs.get(0);
	}
}