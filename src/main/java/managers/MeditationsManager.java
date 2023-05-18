package managers;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.PlaylistItem;
import models.Video;

import static DataBases.MeditationTable.createMeditationTable;
import static DataBases.MeditationTable.insertMeditations;
import static DataBases.VideoTable.insertVideo;

public class MeditationsManager {
    private static final String API_KEY = "AIzaSyDJeMkfh4W7M5xMhSjyzhLiJ1k5akgbbDU";
    private static List<PlaylistItem> videos = new ArrayList<>();
    private static ArrayList<Video> videosMy = new ArrayList<>();
    public static ArrayList<Video> getMeditations(){
        return videosMy;
    }
    public static void dataBaseAllMed() {
        try {
            // Установка соединения с базой данных
            // Создание таблицы для хранения информации о видео
            createMeditationTable();
            System.out.println("Таблица для хранения информации о медитациях успешно создана.");
            fillVideoList("PLabNcXka-NY6dXkO92Iljr_sJf_kvpxDl");
            System.out.println("Лист видео заполнен");
            ArrayList<Integer> durations = new ArrayList<>();
            durations.add(5);
            durations.add(5);
            durations.add(12);
            durations.add(12);
            durations.add(10);
            durations.add(8);
            durations.add(8);
            durations.add(8);
            durations.add(5);
            durations.add(5);
            durations.add(10);
            durations.add(8);
            durations.add(5);
            durations.add(5);
            durations.add(10);
            durations.add(13);
            durations.add(17);
            durations.add(10);
            durations.add(15);
            durations.add(10);
            durations.add(6);
            durations.add(10);
            durations.add(8);
            durations.add(13);
            durations.add(10);
            durations.add(13);
            durations.add(20);
            durations.add(13);
            durations.add(12);
            durations.add(9);
            durations.add(9);
            durations.add(10);
            durations.add(9);
            durations.add(8);
            durations.add(7);
            durations.add(6);
            durations.add(5);
            durations.add(7);
            durations.add(11);
            durations.add(10);
            durations.add(9);
            durations.add(7);
            durations.add(7);
            durations.add(1);
            durations.add(6);
            durations.add(7);
            durations.add(5);
            durations.add(14);
            durations.add(9);
            durations.add(19);
            durations.add(5);
            durations.add(7);
            durations.add(11);
            durations.add(10);
            durations.add(5);
            durations.add(9);
            durations.add(8);

            for (int i = 1; i <= videos.size() ; i++) {
                PlaylistItem video = videos.get(i-1);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertMeditations( i, videoUrl,  durations.get(i-1), "Morning meditations", "beginner");
                Video vid = new Video(i - 1, videoUrl, durations.get(i-1), "Morning meditations", "beginner");
                videosMy.add(vid);
            }
            System.out.println("данные занесены");

            fillVideoList("PLabNcXka-NY6g0w6aqOFHQcDV3wcvrji-");
            System.out.println("Лист медитаций заполнен");
            durations = new ArrayList<Integer>();
            durations.add(7);
            durations.add(11);
            durations.add(60);
            durations.add(60);
            durations.add(15);
            durations.add(5);
            durations.add(20);
            durations.add(30);
            durations.add(6);
            durations.add(20);
            durations.add(10);
            durations.add(70);
            durations.add(70);
            durations.add(15);
            durations.add(14);
            durations.add(15);
            durations.add(6);
            durations.add(10);
            durations.add(21);

            for (int i = 60; i < videos.size() + 60 ; i++) {
                PlaylistItem video = videos.get(i-60);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertMeditations(i, videoUrl,  durations.get(i-60), "Night meditations", "beginner" );
                Video vid = new Video(i-1, videoUrl, durations.get(i-60), "Night meditations", "beginner");
                videosMy.add(vid);
            }
            System.out.println("данные занесены");

            fillVideoList("PLabNcXka-NY7PNUM26qzQFFLYRpHFE5t8");
            System.out.println("Лист медитаций заполнен");
            durations = new ArrayList<Integer>();
            durations.add(70);
            durations.add(70);
            durations.add(60);
            durations.add(60);
            for (int i = 79; i < videos.size() + 79 ; i++) {
                PlaylistItem video = videos.get(i-79);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertMeditations( i, videoUrl,  durations.get(i-79), "Relax", "medium");
                Video vid = new Video(i-1, videoUrl, durations.get(i-79), "Relax", "medium");
                videosMy.add(vid);
            }
            System.out.println("данные занесены");
            fillVideoList("PLabNcXka-NY7-dF__zOkXGr3vBm2XVp5J");
            System.out.println("Лист видео заполнен");
            durations = new ArrayList<Integer>();
            durations.add(30);
            durations.add(9);
            durations.add(5);
            durations.add(3);
            durations.add(10);
            durations.add(3);
            durations.add(8);
            for (int i = 83; i < videos.size() + 83 ; i++) {
                PlaylistItem video = videos.get(i-83);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertMeditations( i, videoUrl,  durations.get(i-83), "Affirmation", "medium" );
                Video vid = new Video(i-1, videoUrl, durations.get(i-83), "Affirmation", "medium");
                videosMy.add(vid);
            }
            System.out.println("данные занесены");
            fillVideoList("PLabNcXka-NY4QtN-HYMlzlDmmoD78PNxk");
            System.out.println("Лист видео заполнен");
            durations = new ArrayList<Integer>();
            durations.add(22);
            durations.add(17);
            durations.add(15);
            durations.add(25);
            durations.add(19);
            durations.add(15);
            durations.add(25);
            durations.add(14);
            for (int i = 90; i < videos.size() + 90 ; i++) {
                PlaylistItem video = videos.get(i-90);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertMeditations(i, videoUrl,  durations.get(i-90), "Advanced meditations", "advanced" );
                Video vid = new Video(i-1, videoUrl, durations.get(i-90), "Advanced meditations", "advanced");
                videosMy.add(vid);
            }
            System.out.println("данные занесены");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // Закрытие соединения с базой данных

        }
    }
    public static void fillVideoList(String url) throws GeneralSecurityException, IOException {
        YouTube youtube = getService();
        videos = getChannelVideos(youtube, url);
    }
    private static List<PlaylistItem> getChannelVideos(YouTube youtube, String channelId) throws IOException {
        PlaylistItemListResponse response= youtube.playlistItems()
                .list(Collections.singletonList("snippet,contentDetails"))
                .setPlaylistId(channelId)
                .setKey(API_KEY)
                .setMaxResults(200L)
                .execute();
        return response.getItems();
    }
    private static YouTube getService() throws GeneralSecurityException, IOException {
        final HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = new JacksonFactory();
        return new YouTube.Builder(httpTransport, jsonFactory, getRequestInitializer())
                .setApplicationName("YoutubeChannelVideos")
                .build();
    }
    private static HttpRequestInitializer getRequestInitializer() {
        return request -> request.setParser(new JsonObjectParser(new JacksonFactory()));
    }

}
