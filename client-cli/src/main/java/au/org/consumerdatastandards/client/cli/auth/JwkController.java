package au.org.consumerdatastandards.client.cli.auth;

import com.nimbusds.jose.jwk.JWK;
import org.mitre.jwt.signer.service.JWTSigningAndValidationService;
import org.mitre.openid.connect.view.JWKSetView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class JwkController {
    @Autowired
    private JWTSigningAndValidationService signingAndValidationService;

    @GetMapping("/jwk")
    public ModelAndView jwk() {
        Map<String, JWK> keys = signingAndValidationService.getAllPublicKeys();
        return new ModelAndView(JWKSetView.VIEWNAME, "keys", keys);
    }
}
