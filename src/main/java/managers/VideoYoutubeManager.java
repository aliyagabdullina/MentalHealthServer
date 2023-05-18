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

import static DataBases.VideoTable.createVideoTable;
import static DataBases.VideoTable.insertVideo;

public class VideoYoutubeManager {
    private static final String API_KEY = "AIzaSyDJeMkfh4W7M5xMhSjyzhLiJ1k5akgbbDU";
    private static List<PlaylistItem> videos = new ArrayList<>();
    private static ArrayList<Video> videosMy = new ArrayList<>();
    public static ArrayList<Video> getVideos(){
        return videosMy;
    }
    public static void dataBaseAll() {
        try {
            // Установка соединения с базой данных
            // Создание таблицы для хранения информации о видео
            createVideoTable();
            System.out.println("Таблица для хранения информации о видео успешно создана.");
            fillVideoList("PLvdtJBo5Y2LNrCXANwG2oKo4RUKia9EjC");
            System.out.println("Лист видео заполнен");
            ArrayList<Integer> durations = new ArrayList<>();
            durations.add(20);
            durations.add(30);
            durations.add(50);
            durations.add(50);
            durations.add(10);
            durations.add(15);
            durations.add(20);
            durations.add(15);
            for (int i = 1; i <= videos.size() ; i++) {
                PlaylistItem video = videos.get(i-1);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertVideo( i, videoUrl,  durations.get(i-1), "Hatha Yoga", "beginner");
                Video vid = new Video(i - 1, videoUrl, durations.get(i-1), "Hatha Yoga", "beginner");
                videosMy.add(vid);
            }
            System.out.println("данные занесены");
            fillVideoList("PLvdtJBo5Y2LP0sqsW3lBX_xaKv0hSGS7n");
            System.out.println("Лист видео заполнен");
            durations = new ArrayList<Integer>();
            durations.add(30);
            durations.add(40);
            durations.add(20);
            durations.add(20);
            durations.add(15);
            durations.add(5);
            durations.add(10);
            durations.add(30);
            durations.add(30);
            for (int i = 9; i < videos.size() + 9 ; i++) {
                PlaylistItem video = videos.get(i-9);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertVideo(i, videoUrl,  durations.get(i-9), "Wellness yoga", "beginner" );
                Video vid = new Video(i-1, videoUrl, durations.get(i-9), "Wellness yoga", "beginner");
                videosMy.add(vid);
            }
            System.out.println("данные занесены");
            fillVideoList("PLvdtJBo5Y2LNd4hustnlwukHAxeZ1P2SE");
            System.out.println("Лист видео заполнен");
            durations = new ArrayList<Integer>();
            durations.add(15);
            durations.add(30);
            durations.add(10);
            durations.add(30);
            durations.add(20);
            for (int i = 18; i < videos.size() + 18 ; i++) {
                PlaylistItem video = videos.get(i-18);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertVideo( i, videoUrl,  durations.get(i-18), "Yoga nidra", "medium");
                Video vid = new Video(i-1, videoUrl, durations.get(i-18), "Yoga nidra", "medium");
                videosMy.add(vid);
            }
            System.out.println("данные занесены");
            fillVideoList("PLvdtJBo5Y2LNEEgJO1yYWpH01Kau1fnpc");
            System.out.println("Лист видео заполнен");
            durations = new ArrayList<Integer>();
            durations.add(30);
            durations.add(30);
            durations.add(30);
            durations.add(30);
            for (int i = 23; i < videos.size() + 23 ; i++) {
                PlaylistItem video = videos.get(i-23);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertVideo( i, videoUrl,  durations.get(i-23), "Fitness yoga", "advanced" );
                Video vid = new Video(i-1, videoUrl, durations.get(i-23), "Fitness yoga", "advanced");
                videosMy.add(vid);
            }
            System.out.println("данные занесены");
            fillVideoList("PLvdtJBo5Y2LMw4uMma4Gzkr9yo8ersB3f");
            System.out.println("Лист видео заполнен");
            durations = new ArrayList<Integer>();
            durations.add(15);
            durations.add(25);
            durations.add(10);
            durations.add(15);
            durations.add(20);
            durations.add(50);
            durations.add(5);
            durations.add(20);
            durations.add(30);
            for (int i = 27; i < videos.size() + 27 ; i++) {
                PlaylistItem video = videos.get(i-27);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertVideo(i, videoUrl,  durations.get(i-27), "Stretching yoga", "medium" );
                Video vid = new Video(i-1, videoUrl, durations.get(i-27), "Stretching yoga", "medium");
                videosMy.add(vid);
            }
            System.out.println("данные занесены");
            fillVideoList("PLvdtJBo5Y2LP6ZKgSgbW8cVTaOkct-ZNk");
            System.out.println("Лист видео заполнен");
            durations = new ArrayList<Integer>();
            durations.add(20);
            durations.add(50);
            durations.add(40);
            durations.add(50);
            durations.add(30);
            durations.add(15);
            durations.add(20);
            durations.add(50);
            durations.add(5);
            for (int i = 36; i < videos.size() + 36 ; i++) {
                PlaylistItem video = videos.get(i-36);
                String videoUrl = video.getSnippet().getResourceId().getVideoId();
                insertVideo( i, videoUrl,  durations.get(i-36), "Sivananda yoga", "advanced" );
                Video vid = new Video(i-1, videoUrl, durations.get(i-36), "Sivananda yoga", "advanced");
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
