package cz.MVCcdshop.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Shop")
public class ShopController {
		
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String getShopIndexPage(ModelMap model){
		return "shopindex";
	}
	
	@RequestMapping(value = "/Browse" , method = RequestMethod.GET)
	public String getShopBrowsePage(ModelMap model){
		return "Browse";
	}
	
	@RequestMapping(value = "/Details" , method = RequestMethod.GET)
	public String getShopDetailsPage(ModelMap model){
		return "Details";
	}
}
