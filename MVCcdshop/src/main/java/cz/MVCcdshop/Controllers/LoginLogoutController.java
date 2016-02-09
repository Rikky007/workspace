package cz.MVCcdshop.Controllers;

import cz.MVCcdshop.Entities.Users;
import cz.MVCcdshop.Models.UsersModel;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Grant
 */
/**
 * Obsluhuje zobrazuje login
 *
 * @author Grant
 */
@Controller
@RequestMapping("/Account")
public class LoginLogoutController {

    @Resource(name = "userService")
    private UsersModel usersModel;

    /**
     * obsluhuje JSP stránku s loginem
     *
     * @param error
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value = "error", required = false) String error, ModelMap model) {
        Users tempusers = new Users();

        model.addAttribute("login, tempUsers");
        return "loginpage";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyAccount(@RequestParam(value = "error", required = false) boolean error, @ModelAttribute("login") Users loginUser, ModelMap model) {
        boolean checkLoginUser = false;
        String destination = "";

        checkLoginUser = usersModel.verifyLoginUser(loginUser.getUsername(), loginUser.getPassword());

        if (checkLoginUser == false) {
            model.put("error", "Zadali jste nesprávný login nebo heslo");
            destination = "loginpage";
        } else {
            destination = "CheckOut";
        }
        return destination;
    }
}
