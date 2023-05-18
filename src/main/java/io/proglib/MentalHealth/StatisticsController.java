package io.proglib.MentalHealth;

import models.Video;
import org.springframework.web.bind.annotation.*;

import static managers.StatisticsManager.createJson;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @PutMapping
    public String statisticsList() {
        return createJson();
    }
}
