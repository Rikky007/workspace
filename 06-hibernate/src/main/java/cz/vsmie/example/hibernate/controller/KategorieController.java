package cz.vsmie.example.hibernate.controller;

import cz.vsmie.example.hibernate.command.KategorieCommand;
import cz.vsmie.example.hibernate.service.KategorieService;
import cz.vsmie.example.hibernate.validation.KategorieValidator;
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
 * Kontroler, ktery obstarava veskerou praci s kategoriemi
 * 
 * @author Ing. Jiří Franc
 */
@Controller
public class KategorieController {
    //pomoci anotace autowired se nam pri deployi aplikace nastavi instance validatoru do teto promenne
    @Autowired private KategorieValidator kategorieValidator;
    @Autowired private KategorieService kategorieService;
    
    
    /**
     * metoda obstarava obrazovku s vypisem kategorii a to pomoci url adresy /kategorie-seznam.htm
     * 
     * @param model pomoci nejz predavame promenne do jsp stranek
     * @return string, ktery musi odpovidat tiles definici nebo ceste k nejake jsp strance viz viewResolver v dispatcher-servlet.xml
     */
    @RequestMapping(method = RequestMethod.GET, value="/kategorie-seznam.htm")
    public String seznamKategorii(Model model) {
        model.addAttribute("kategorie", kategorieService.findAll());
        return "kategorie-list";
    }

    /**
     * metoda obstarava obrazovku s formularem pro vytvoreni nove kategorie a to pomoci url adresy /kategorie-nova.htm
     * 
     * @param model pomoci nejz predavame promenne do jsp stranek
     * @return string, ktery musi odpovidat tiles definici nebo ceste k nejake jsp strance viz viewResolver v dispatcher-servlet.xml
     */
    @RequestMapping(method = RequestMethod.GET, value="/kategorie-nova.htm")
    public String novaKategorie(Model model) {
        //Predavame command object. Jmeno promenne musi odpovidat jmenu v jsp strance v tagu form:form atribut commandName
        model.addAttribute("kategorieCommand", new KategorieCommand());
        return "kategorie-edit";
    }

    /**
     * metoda obstarava obrazovku s formularem pro upravu stavajici kategorie a to pomoci url adresy /kategorie-upravit.htm
     * 
     * @param model pomoci nejz predavame promenne do jsp stranek
     * @param idKategorie IDecko kategorie, podle ktereho budeme kategorii v budoucnu hledat v DB. Nyni podstrcime jen novou instanci
     * @return string, ktery musi odpovidat tiles definici nebo ceste k nejake jsp strance viz viewResolver v dispatcher-servlet.xml
     */
    @RequestMapping(method = RequestMethod.GET, value="/kategorie-upravit.htm")
    public String editKategorie(Model model,
                                @RequestParam("id") Long idKategorie) {
        //Predavame command object. Jmeno promenne musi odpovidat jmenu v jsp strance v tagu form:form atribut commandName
        model.addAttribute("kategorieCommand",  kategorieService.findById(idKategorie));
        return "kategorie-edit";
    }

    /**
     * metoda obstarava akci pro smazani kategorie a pak provadi redirect na seznam kategorii
     * 
     * @param idKategorie IDecko kategorie, podle ktere kategorii v budoucnu smazeme v DB. Nyni se nic neprovede
     * @return string, ktery musi odpovidat ceste k nejake jsp strance obalene prefixem a suffixem viz viewResolver v dispatcher-servlet.xml
     */
    @RequestMapping(method = RequestMethod.GET, value="/kategorie-smazat.htm")
    public String smazatKategorii(@RequestParam("id") Long idKategorie) {
        kategorieService.delete(idKategorie);
        return "redirect:kategorie-seznam.htm";
    }

    /**
     * metoda obstarava zpracovani odeslaneho formulare s kategorii a to na adrese /kategorie-save.html
     * 
     * @param model pomoci nejz predavame promenne do jsp stranek
     * @param command object reprezentujici formular. Jeho instance potazmo data se ziskavaji z postu 
     * @param errors object, do ktereho budeme ukladat chyby formulare
     * @return string, ktery musi odpovidat tiles definici nebo ceste k nejake jsp strance viz viewResolver v dispatcher-servlet.xml
     */
    @RequestMapping(method = RequestMethod.POST, value="/kategorie-save.htm")
    public String saveKategorie(Model model,
            @Valid @ModelAttribute("kategorieCommand") KategorieCommand command,
            BindingResult errors) {

        //zvalidujeme formular 
        kategorieValidator.validate(command, errors);
        
        //pokud jsou nejake chyby, zobrazime formular a vypiseme chyby
        if (errors.hasErrors()) {
            model.addAttribute("kategorieCommand", command);
            return "kategorie-edit";
        }
        
         //pokud nejsou chyby, tak ulozime pomoci servisni tridy a pote provedeme redirect na seznam kategorii
        kategorieService.saveOrUpdate(command);

        return "redirect:kategorie-seznam.htm";
    }
}
