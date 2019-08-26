package au.org.consumerdatastandards.holder.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Home redirection to OpenAPI api documentation
 */
@Controller
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
