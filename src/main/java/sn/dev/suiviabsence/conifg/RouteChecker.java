package sn.dev.suiviabsence.conifg;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class RouteChecker {

    private final RequestMappingHandlerMapping handlerMapping;
    private Set<Pattern> validPathPatterns;
    private static final List<String> validPaths = List.of(
            "/app/auth/login",
            "/app/auth/logout",
            "/swagger-ui",        // ✅ Sans extension
            "/swagger-resources",
            "/webjars",
            "/v3/api-docs",      // ✅ Sans /**
            "/error",
            // ... autres chemins valides
            "/absences/mobiles/premiers",
            "/absences/mobiles/rechercher",
            "/absences/mobiles/pointer",
            // Nouveaux chemins avec préfixe /app
            "/app/absences/mobiles/premiers",
            "/app/absences/mobiles/rechercher",
            "/app/absences/mobiles/pointer",
            // Routes Swagger
            "/swagger-ui",
            "/swagger-ui/",
            "/swagger-ui/index.html",
            "/api-docs",
            "/api-docs/",
            "/v3/api-docs",
            "/v3/api-docs/",
            "/app/absences/mobiles/list",
            "/app/absences/list"
    );

    public RouteChecker(@Qualifier("requestMappingHandlerMapping") RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @PostConstruct
    public void init() {
        validPathPatterns = handlerMapping.getHandlerMethods().keySet().stream()
                .flatMap(info -> info.getPatternValues().stream())
                .map(this::convertToRegex)
                .distinct()
                .map(Pattern::compile)
                .collect(Collectors.toSet());

        System.out.println("---------> Compiled path regex patterns:");
        validPathPatterns.forEach(p -> System.out.println("  " + p.pattern()));
    }

    private String convertToRegex(String path) {
        // Convert /api/users/{id} => /api/users/[^/]+
        return path.replaceAll("\\{[^/]+}", "[^/]+");
    }

    public boolean isValidPath(String path) {
        return validPaths.stream().anyMatch(path::startsWith);
    }
}
