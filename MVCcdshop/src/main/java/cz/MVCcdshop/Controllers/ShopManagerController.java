package cz.MVCcdshop.Controllers;

import cz.MVCcdshop.Entities.Album;
import cz.MVCcdshop.Entities.Artist;
import cz.MVCcdshop.Entities.Genre;
import cz.MVCcdshop.Models.AlbumModel;
import cz.MVCcdshop.Models.ArtistModel;
import cz.MVCcdshop.Models.GenreModel;
import java.util.List;

import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Grant
 */


@Controller
@RequestMapping("/ShopManager")
public class ShopManagerController {
    
    //protected static Logger log = Logger.getLogger("Controller");
    
    @Resource(name ="genreService")
    private GenreModel genreModel;
    
    @Resource(name ="artistService")
    private ArtistModel artistModel;
    
    @Resource(name="albumService")
    private AlbumModel albumModel;
    
    /**
     * Mapuje stránku StoreManager 
     * @param request
     * @param session
     * @param model
     * @return 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getShopManagerPage(HttpServletRequest request, 
            HttpSession session, ModelMap model) {
        
        //log.debug("obdržena Store Manager Page");
        
        List<Album> albumList = albumModel.findAllAlbums();
        
        model.put("albumList", albumList);
        return new ModelAndView("ShopManager","albumModel",albumModel);
    }
    
    /**
     * Mapuje AlbumDetails pro StoreManager
     * @param detailsAlbumId
     * @param model
     * @return 
     */
    @RequestMapping(value = "/DetailsAlbum", method = RequestMethod.GET)
    public String getDetailsAlbumPage(@RequestParam("detailsAlbumId")Integer detailsAlbumId,ModelMap model){
        
        //log.debug("obdržena Details Album Page");
        Album myAlbum = albumModel.findAlbumById(detailsAlbumId);
        
        model.put("detailsAlbumId", detailsAlbumId);
        model.put("detailsAlbum", myAlbum);
        
        return "DetailsAlbum";
    }
    
    /**
     * Načtení info o albu
     * @param editAlbumId
     * @param model
     * @return 
     */
    @RequestMapping(value = "/EditAlbum", method = RequestMethod.GET)
    public String getEditAlbumPage(@RequestParam("editAlbumId") Integer editAlbumId, ModelMap model){
        Album myAlbum = albumModel.findAlbumById(editAlbumId);
        
        List<Genre> genreList = genreModel.findAllGenres();
        List<Artist> artistList = artistModel.findAllArtists();
        
        model.put("genres", genreList);
        model.put("selectedGenre", myAlbum.getGenreid().getName());
        
        model.put("artists",artistList);
        model.put("selectedArtist", myAlbum.getArtistid().getName());
        model.addAttribute("editAlbum", myAlbum);
        
        return "EditAlbum";
    }   
    
    /**
     * Update info o albu
     * @param albuarturl
     * @param price
     * @param txtTitle
     * @param genreSelected
     * @param artistSelected
     * @param editAlbumId
     * @param editAlbum
     * @return 
     */
    @RequestMapping(value = "/EditAlbum", method = RequestMethod.POST)
    public String setEditAlbumPage(@RequestParam("albumarturl") String albuarturl, @RequestParam("price") String price, @RequestParam("title") String txtTitle, @RequestParam("genreSelected") Integer genreSelected, @RequestParam("artistSelected") Integer artistSelected, @RequestParam("editAlbumId") Integer editAlbumId,@ModelAttribute Album editAlbum){
        
        Album myAlbum = albumModel.findAlbumById(editAlbumId);
        Genre myGenre = genreModel.findGenreById(genreSelected);
        Artist myArtist = artistModel.findArtistById(artistSelected);
        
        myAlbum.setGenreid(myGenre);
        myAlbum.setArtistid(myArtist);
        myAlbum.setTitle(txtTitle);
        myAlbum.setPrice(Double.parseDouble(price));
        myAlbum.setAlbumart(albuarturl);
        
        albumModel.edit(myAlbum);
        
        return "redirect:";
    
    }
}