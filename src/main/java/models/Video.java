package models;

import java.util.ArrayList;

public class Video {
    int id;
    String url;
    int duration;
    String workout_type;
    String difficulty;
    public Video(int id, String url, int duration, String workout_type, String difficulty){
        this.id = id;
        this.url = url;
        this.duration = duration;
        this.workout_type = workout_type;
        this.difficulty = difficulty;
    }
    public Video(){

    }
    public String getUrl() {
        return url;
    }

    public int getDuration() {
        return duration;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getWorkout_type() {
        return workout_type;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWorkout_type(String workout_type) {
        this.workout_type = workout_type;
    }
}

