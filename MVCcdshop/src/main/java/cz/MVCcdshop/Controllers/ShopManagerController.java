package cz.MVCcdshop.Controllers;

import cz.MVCcdshop.Entities.Album;
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
    
    /**
     *
     */
    protected static Logger log = Logger.getLogger("Controller");
    
    @Resource(name ="genreService")
    private GenreModel genreModel;
    
    @Resource(name ="artistService")
    private ArtistModel artistModel;
    
    @Resource(name="albumService")
    private AlbumModel albumModel;
    
    /**
     * mapuje stránku StoreManager 
     * @param request
     * @param session
     * @param model
     * @return 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getStoreManagerPage(HttpServletRequest request, 
            HttpSession session, ModelMap model) {
        
        log.debug("obdržena Store Manager Page");
        
        List<Album> albumList = albumModel.findAllAlbums();
        
        model.put("albumList", albumList);
        return new ModelAndView("StoreManager","albumModel",albumModel);
    }
    
    /**
     * mapuje AlbumDetails pro StoreManager
     * @param detailsAlbumId
     * @param model
     * @return 
     */
    @RequestMapping(value = "/DetailsAlbum", method = RequestMethod.GET)
    public String getDetailsAlbumPage(@RequestParam("detailsAlbumId")Integer detailsAlbumId,ModelMap model){
        
        log.debug("obdržena Details Album Page");
        Album myAlbum = albumModel.findAlbumById(detailsAlbumId);
        
        model.put("detailsAlbumId", detailsAlbumId);
        model.put("detailsAlbum", myAlbum);
        
        return "DetailsAlbum";
    }
}
