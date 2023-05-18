package io.proglib.MentalHealth;

import models.Notion;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static managers.NotionManager.*;
import static io.proglib.MentalHealth.StatisticsController.*;
import static managers.StatisticsManager.createJson;

@RestController

public class NotionController {
    String jsonString;

    @PutMapping("/notion")
    public void putNotionRequest(@RequestBody String notion) {
        System.out.println("Request body: " + notion);
        jsonString = notion;
        parseNotionJson(jsonString);
        System.out.println(getNotions());
        sendStatistics();
    }
    @GetMapping("/statistics")
    public String sendStatistics() {
        System.out.println("Sent");
        return createJson();
    }

}
