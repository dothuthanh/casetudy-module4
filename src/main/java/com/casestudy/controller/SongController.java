package com.casestudy.controller;

import com.casestudy.model.Song;
import com.casestudy.service.song.ISongService;
import com.casestudy.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;
//    @GetMapping("list")
//    public ModelAttribute showListSong(){
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("song", song);
//    }
}
