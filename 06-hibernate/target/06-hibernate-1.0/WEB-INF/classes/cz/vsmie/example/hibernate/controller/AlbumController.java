/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.controller;

import cz.vsmie.example.hibernate.command.AlbumCommand;
import cz.vsmie.example.hibernate.service.AlbumService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Grant
 */
@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /**
     * Browse page
     *
     * @param genreName
     * @param model
     * @return
     */
    @RequestMapping(value = "/Browse", method = RequestMethod.GET)
    public String getShopBrowsePage(@RequestParam(value = "genre", required = false) String genreName, ModelMap model) {
        List<AlbumCommand> albums = albumService.findAll();
        List<AlbumCommand> foundAlbums = new ArrayList<AlbumCommand>();

        for (AlbumCommand alb : albums) {
            if (alb.getGenre().getName().equals(genreName)) {
                foundAlbums.add(alb);
            }
        }

        model.put("genreCount", 1000);
        model.put("foundAlbum", albums);

        return "Browse";
    }

}
