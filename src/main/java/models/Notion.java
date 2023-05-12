package models;

import java.util.ArrayList;

public class Notion {
    String emoji;

    String date;

    String noteText;
    ArrayList<String> activityTextsList;

    public Notion(String emoji, String date, String noteText, ArrayList<String> activityTextsList) {
        this.emoji = emoji;
        this.date = date;
        this.noteText = noteText;
        this.activityTextsList = activityTextsList;
    }

    public ArrayList<String> getActivityTextsList() {
        return activityTextsList;
    }

    public void setActivityTextsList(ArrayList<String> activityTextsList) {
        this.activityTextsList = activityTextsList;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }
}
