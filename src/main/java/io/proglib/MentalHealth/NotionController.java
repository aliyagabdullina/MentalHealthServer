package io.proglib.MentalHealth;

import models.Notion;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static managers.NotionManager.*;

@RestController

public class NotionController {
    String jsonString;

    @PutMapping("/notion")
    public void putNotionRequest(@RequestBody String notion) {
        System.out.println("Request body: " + notion);
        jsonString = notion;
        parseNotionJson(jsonString);
        sendStatistics();

    }

    private void sendStatistics() {
        // Отправить статистику на сервер
        // Ваш код для отправки статистики здесь
        System.out.println("Statistics sent");
    }


    @GetMapping("/notion")
    public void getNotionRequest() {
        System.out.println("Got body: ");
    }

}
