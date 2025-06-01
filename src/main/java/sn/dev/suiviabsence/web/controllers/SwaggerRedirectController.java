package sn.dev.suiviabsence.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Contrôleur simple qui redirige les utilisateurs vers la documentation Swagger.
 */
@Controller
public class SwaggerRedirectController {
    
    /**
     * Redirige l'URL racine vers la documentation Swagger UI.
     * @return La redirection vers Swagger UI
     */
    @GetMapping("/docs")
    public String redirectToSwaggerUi() {
        // Utiliser le bon chemin pour la version actuelle de SpringDoc
        return "redirect:/swagger-ui/index.html";
    }
}