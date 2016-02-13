/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.controller;

import cz.vsmie.example.hibernate.command.AlbumCommand;
import cz.vsmie.example.hibernate.service.AlbumService;
import cz.vsmie.example.hibernate.service.ArtistService;
import cz.vsmie.example.hibernate.service.GenreService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Grant
 */
@Controller
public class AlbumController {

    @Autowired private AlbumService albumService;
    @Autowired private ArtistService artistService;
    @Autowired private GenreService genreService;

    @RequestMapping(method = RequestMethod.GET, value = "/album-list.htm")
    public String seznamKategorii(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "album-list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/album-edit.htm")
    public String editAlbum(Model model, @RequestParam("id") Integer albumid) {
        model.addAttribute("albumCommand", albumService.findById(albumid));
        model.addAttribute("artists", artistService.findAll());
//        model.addAttribute("genres",   genreService.findAll());
        return "album-edit";
    }

  
    @RequestMapping(method = RequestMethod.POST, value = "/album-save.htm")
    public String saveAlbums(Model model,
            @Valid @ModelAttribute("albumCommand") AlbumCommand command,
            BindingResult errors) {

        //zvalidujeme formular 
        //kategorieValidator.validate(command, errors);
        //pokud jsou nejake chyby, zobrazime formular a vypiseme chyby
        if (errors.hasErrors()) {
            model.addAttribute("albumCommand", command);
            return "album-edit";
        }

        //pokud nejsou chyby, tak ulozime pomoci servisni tridy a pote provedeme redirect na seznam kategorii
        albumService.saveOrUpdate(command);

        return "redirect:album-list.htm";
    }
}
