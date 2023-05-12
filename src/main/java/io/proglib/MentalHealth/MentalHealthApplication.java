package io.proglib.MentalHealth;

import models.Video;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.ArrayList;

import static DataBases.NotionTable.createNotionTable;
import static managers.VideoYoutubeManager.dataBaseAll;
import static managers.VideoYoutubeManager.getVideos;

@SpringBootApplication
public class MentalHealthApplication {

	public static void main(String[] args) throws SQLException {
		dataBaseAll();
		createNotionTable();

		SpringApplication.run(MentalHealthApplication.class, args);
	}

}
