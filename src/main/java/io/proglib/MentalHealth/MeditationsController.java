package io.proglib.MentalHealth;

import models.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static managers.MeditationsManager.getMeditations;

@RestController
@RequestMapping("/meditations")
public class MeditationsController {
    @GetMapping
    public ArrayList<Video> videoMedlist() {
        System.out.println("Got server conn");
        return getMeditations();
    }
    public String videoMed(@RequestParam("index") int index){
        return getMeditations().get(index).getUrl();
    }
}