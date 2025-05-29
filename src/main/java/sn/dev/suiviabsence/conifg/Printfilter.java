package sn.dev.suiviabsence.conifg;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.stereotype.Component;

@Component
public class Printfilter {

    @Autowired
    private FilterChainProxy filterChainProxy;

    @PostConstruct
    public void printFilters() {
        filterChainProxy.getFilterChains().forEach(chain -> {
            System.out.println();
            System.out.println("=== Filter Chain ===");
            chain.getFilters().forEach(filter -> System.out.println(filter.getClass().getName()));
            System.out.println();
        });
    }
}
