package cz.MVCcdshop.Controllers;

import cz.MVCcdshop.Entities.Album;
import cz.MVCcdshop.Entities.Genre;
import cz.MVCcdshop.Models.AlbumModel;
import cz.MVCcdshop.Models.GenreModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Shop")
public class ShopController {
	
	@Resource(name="gnreService")
        private GenreModel genreModel;
	/**
	 * CDshop Root 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String getShopIndexPage(ModelMap model){
            
            List<Genre>myGenreList = genreModel.findAllGenres();
            model.put("genreList", myGenreList);
            model.put("genreCount", myGenreList.size());
            
            return "shopindex";
	}
	
	/**
	 * Details page
	 * @param albumID
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Details" , method = RequestMethod.GET)
	public String getShopDetailsPage(@RequestParam(value="albumId", required=false)Integer albumID, ModelMap model){
		
		model.addAttribute("albumId",albumID);
		return "Details";
	}
	
	/**
	 * Browse page
	 * @param genreName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Browse" , method = RequestMethod.GET)
	public String getShopBrowsePage(@RequestParam(value="genre", required=false)String genreName, ModelMap model){
		List<Album> foundAlbum = new ArrayList<Album>();
                if (genreName == null){
                    model.put("genre", "Empty");
                }else{
                    List<Album> myAlbum = AlbumModel.findAllAlbums();
                    for(Album tempAlbum: myAlbum){
                        if(tempAlbum.getGenreid().getName().equals(genreName)){
                            foundAlbum.add(tempAlbum);
                        }
                    }
                    model.put("genre", genreName);
                    model.put("foundAlbum", foundAlbum);
                }
		
		return "Browse";
	}
	
}
