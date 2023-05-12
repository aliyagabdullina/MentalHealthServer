package managers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static managers.NotionManager.howManyActions;
import static managers.NotionManager.percentageOfAction;

public class StatisticsManager {
    public static String getStatisticJson(String actionName) {
        int count = howManyActions(actionName);
        double percentage = percentageOfAction(actionName);

        // Создаем объект для JSON
        JSONObject statisticJson = new JSONObject();
        statisticJson.put("name", actionName);
        statisticJson.put("count", count);
        statisticJson.put("percentage", percentage);

        // Преобразуем объект в JSON
        String json = statisticJson.toJSONString();

        return json;
    }

    public static String getStatisticsJsonArray(List<String> actionNames) {
        JSONArray jsonArray = new JSONArray();
        for (String actionName : actionNames) {
            String json = getStatisticJson(actionName);
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(json);
                JSONObject jsonObject = (JSONObject) obj;
                jsonArray.add(jsonObject);
            } catch (ParseException e) {
                // Обработка ошибки
                e.printStackTrace();
            }
        }
        return jsonArray.toString();
    }

    public static String createJson(){
        List<String> stat = new ArrayList<>(Arrays.asList("Йога", "Медитация", "Благодарность", "Здоровый сон", "Хобби", "Уход"));
        return getStatisticsJsonArray(stat);

    }


}
