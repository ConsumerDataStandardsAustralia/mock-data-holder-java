package au.org.consumerdatastandards.client.cli.auth;

import au.org.consumerdatastandards.client.cli.support.ApiUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/auth")
    public String auth() throws InterruptedException {
        ApiUtil.browserMutex.put(this);
        return "auth";
    }
}
