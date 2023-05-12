package io.proglib.MentalHealth;

import models.Video;
import org.springframework.web.bind.annotation.*;

import static managers.StatisticsManager.createJson;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @PutMapping
    public String statisticsList() {
        System.out.println("Statistics sent put");
        System.out.println(createJson());
        return createJson();
    }
    @GetMapping
    public String statisticsListShow() {
        System.out.println("Statistics sent get");
        return createJson();
    }
}
