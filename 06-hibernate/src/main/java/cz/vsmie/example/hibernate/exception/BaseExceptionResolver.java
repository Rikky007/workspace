package cz.vsmie.example.hibernate.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Trida odchytava vyjimky nadefinovane parametrem exceptionMappings.
 * Jako reakci na vyjimku uzivateli zobrazi info stranku, odesle email a vse zaloguje do logu serveru. * 
 * 
 * @author Ing. Jiří Franc
 */
public class BaseExceptionResolver implements HandlerExceptionResolver {

    private static final Logger log = Logger.getLogger(BaseExceptionResolver.class.getName());

    public static final String PACKAGE = "cz.vsmie.";

    private Properties exceptionMappings;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) {
        //zalogovani do logu serveru    
        log.log(Level.WARNING, "object = {0}", object);
        log.log(Level.WARNING, "properties = {0}", exceptionMappings);
        log.log(Level.WARNING, "Zachycena vyjimka v aplikaci :{0}", exception.getMessage());
        log.log(Level.WARNING, "URI : {0}", request.getRequestURL() + "?" + request.getQueryString());

        //vypis stacktrasu na standartni vystup
        exception.printStackTrace(System.err);
        
        //nastaveni promenne pro JSP stranku        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        request.setAttribute ("exceptionstr", sw.toString());
        
        //nastaveni statusu responsu na chybovy
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        
        //vraceni viecka s exceptionou
        return new ModelAndView("exception");
    }

    public void setExceptionMappings(Properties exceptionMappings) {
        this.exceptionMappings = exceptionMappings;
    }
}
