package sn.dev.suiviabsence.conifg;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@Order(0)
public class UnknownURI extends OncePerRequestFilter {

    private final RouteChecker routeChecker;

    public UnknownURI(RouteChecker routeChecker) {
        this.routeChecker = routeChecker;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("\n---------------- New request ------------------\nuri: " + request.getRequestURI()
                + "\nmethode: " + request.getMethod() + "\n");

        String path = request.getRequestURI();

        // Only block if it's NOT a valid route
        if (!routeChecker.isValidPath(path)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No such endpoint");
            return;
        }

        filterChain.doFilter(request, response); // Continue with the chain if matched
    }
}
