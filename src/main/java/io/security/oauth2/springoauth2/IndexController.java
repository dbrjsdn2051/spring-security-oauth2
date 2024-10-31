package io.security.oauth2.springoauth2;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/user")
    public OAuth2User user(Authentication authentication) {
        OAuth2AuthenticationToken authentication1 = (OAuth2AuthenticationToken) authentication;
        return authentication1.getPrincipal();
    }

    @GetMapping("/oauth2User")
    public OAuth2User oAuth2User(@AuthenticationPrincipal OAuth2User oAuth2User) {
        System.out.println("oAuth2User = " + oAuth2User);
        return oAuth2User;
    }

    @GetMapping("/oidcUser")
    public OidcUser oidcUser(@AuthenticationPrincipal OidcUser oidcUser) {
        System.out.println("oidcUser = " + oidcUser);
        return oidcUser;
    }
}
