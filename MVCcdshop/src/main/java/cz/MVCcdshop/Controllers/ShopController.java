package cz.MVCcdshop.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Shop")
public class ShopController {
	
	
	/**
	 * CDshop Root 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String getShopIndexPage(ModelMap model){
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
		
		model.addAttribute("genre",genreName);
		return "Browse";
	}
	
}
