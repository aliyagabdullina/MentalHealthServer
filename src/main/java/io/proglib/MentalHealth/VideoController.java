package io.proglib.MentalHealth;

import models.Video;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static managers.VideoYoutubeManager.getVideos;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @GetMapping
    public ArrayList<Video> videolist() {
        System.out.println("Got server conn");
        return getVideos();
    }
    public String video(@RequestParam("index") int index){
        return getVideos().get(index).getUrl();
    }

}