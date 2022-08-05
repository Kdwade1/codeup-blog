package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Anime;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.AnimeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
public class AnimeController {
    private final AnimeRepository animeDao;

    public AnimeController(AnimeRepository animeDao) {
        this.animeDao = animeDao;
    }

    @GetMapping("/anime")
    public String all(Model model){
        List<Anime> animeList = animeDao.findAll();
        model.addAttribute("anime",animeList);
        return "anime/index";

    }

    @GetMapping("/anime/show/{id}")
            public String animes(@PathVariable long id,Model model) {
        Anime anime = animeDao.getById(id);
        ArrayList<Anime> manga = new ArrayList<>();
        manga.add(new Anime("Attack on titan","aot",false));
        model.addAttribute("animation",anime);
        return "anime/show";
    }
    @GetMapping("/anime/create")

    public String postAnime(){
return "/anime/create";
    }

    @PostMapping("/anime/create")
    public String createAnime( @RequestParam(name="title") String title, @RequestParam(name="description")String description ,@RequestParam(name="sucks") String sucks){
        Anime anime= new Anime(title,description);


        if(sucks.equals("true")){
            anime.setSucks(true);
        } else {
            anime.setSucks(false);
        }

        animeDao.save(anime);

        return "redirect:/anime";
    }

}
