package sn.dev.suiviabsence.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import sn.dev.suiviabsence.service.MockDataService;

/**
 * Initialise automatiquement les données mock au démarrage de l'application
 * Activé seulement si la propriété mock.data.auto-init=true
 */
@Component
@ConditionalOnProperty(
        value = "mock.data.auto-init",
        havingValue = "true",
        matchIfMissing = false
)
public class DataLoader implements CommandLineRunner {

    @Autowired
    private MockDataService mockDataService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 Initialisation automatique des données mock...");

        try {
            // Vérifier si des données existent déjà
            long totalRecords = mockDataService.countTotalRecords();

            if (totalRecords == 0) {
                mockDataService.initializeMockData();
                System.out.println("✅ Données mock initialisées avec succès!");
                mockDataService.printStatistics();
            } else {
                System.out.println("ℹ️  Données déjà présentes (" + totalRecords + " enregistrements)");
            }

        } catch (Exception e) {
            System.err.println("❌ Erreur lors de l'initialisation des données mock: " + e.getMessage());
        }
    }
}