package ma.ens.security.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Page d'accueil — publique
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Page de login — affiche les options de connexion
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Profil utilisateur — extrait les infos du ID Token OAuth2
    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal OAuth2User user) {
        if (user != null) {
            model.addAttribute("name",    user.getAttribute("name"));
            model.addAttribute("email",   user.getAttribute("email"));
            model.addAttribute("picture", user.getAttribute("picture"));
            model.addAttribute("locale",  user.getAttribute("locale"));
            // Tous les attributs disponibles (pour debug)
            model.addAttribute("attributes", user.getAttributes());
        }
        return "profile";
    }
}
