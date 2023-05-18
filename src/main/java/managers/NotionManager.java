package managers;

import models.Notion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import static DataBases.NotionTable.insertNotion;

public class NotionManager {
    static ArrayList<Notion> notions = new ArrayList<Notion>();
    static ArrayList<String> notionsActions = new ArrayList<>();

    public static ArrayList<Notion> getNotions() {
        return notions;
    }

    public static void parseNotionJson(String jsonString) {
        JSONParser parser = new JSONParser();
        try {
            // Распарсить JSON-строку в объект JSONObject
            JSONObject json = (JSONObject) parser.parse(jsonString);

            // Получить значения полей
            String image = (String) json.get("image");
            String date = (String) json.get("date");
            String noteText = (String) json.get("noteText");
            JSONArray activityTexts = (JSONArray) json.get("activityTexts");
            ArrayList<String> activityTextsList = new ArrayList<>();

            // Проход по списку activityTexts
            for (Object obj : activityTexts) {
                String activityText = (String) obj;
                activityTextsList.add(activityText);
                notionsActions.add(activityText);
            }
            Notion notion = new Notion(image, date, noteText, activityTextsList);

            notions.add(notion);
            insertNotion(notion);
            System.out.println(notions);

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int howManyActions(String actionName){
        // System.out.println(notions.get(0).getActivityTextsList());
        int count = Collections.frequency(notionsActions, actionName);
        return count;
    }
    public static int percentageOfAction(String actionName){
        int percentage = (int)((double)howManyActions(actionName)/(double)(notions.size())*100);
        return percentage;
    }
}
