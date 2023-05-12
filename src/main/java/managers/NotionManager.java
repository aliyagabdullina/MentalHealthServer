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
        int count = Collections.frequency(notions, actionName);
        return count;
    }
    public static double percentageOfAction(String actionName){
        double percentage = (double)howManyActions(actionName)/(double)(notions.size())*100;
        return percentage;
    }

}
