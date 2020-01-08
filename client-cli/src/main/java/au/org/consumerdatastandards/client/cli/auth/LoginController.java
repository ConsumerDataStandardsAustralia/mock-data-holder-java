package au.org.consumerdatastandards.client.cli.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String auth() {
        return "login";
    }
}
