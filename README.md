Voici une proposition de `README.md` pour ton projet Spring Boot "suivi-absence-backend" :


Ce projet est le service backend pour une application de suivi des absences, développé avec Spring Boot. Il gère les entités liées aux utilisateurs, étudiants, cours, modules, classes et absences.

## Technologies Utilisées

* **Spring Boot**
* **Java 17**
* **Maven** (pour la gestion des dépendances et la construction)
* **Base de données** MongoDB

## Structure du Projet

```bash
.
├── .mvn/                      # Fichiers wrapper Maven
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── sn/dev/suiviabsence/
│   │   │       ├── data/             # Entités, Enums, Repositories
│   │   │       ├── services/         # Logique métier des services
│   │   │       ├── utils/mappers/    # Mappers DTO
│   │   │       └── web/              # Contrôleurs REST (API)
│   │   ├── resources/          # Configuration de l'application (application.properties/yml)
│   └── test/                  # Tests unitaires et d'intégration
├── .gitignore                 # Fichiers/dossiers à ignorer par Git
├── Dockerfile                 # Configuration Docker
├── mvnn                       # Script Wrapper Maven (Linux/macOS)
├── mvnn.cmd                   # Script Wrapper Maven (Windows)
└── README.md                  # Ce fichier
```

## Configuration et Lancement Local

### Prérequis

* JDK 17 installé
* Maven installé
* Une base de données configurée (ajuster `src/main/resources/application.properties` en conséquence).

### Étapes de Lancement

1.  **Cloner le dépôt :**
    ```bash
    git clone https://github.com/mamadbah2/suivi-absence-backend.git
    cd suivi-absence-backend
    ```
2.  **Construire le projet :**
    ```bash
    mvn clean install -DskipTests
    ```
3.  **Lancer l'application :**
    ```bash
    java -jar target/suivi-absence-backend-0.0.1-SNAPSHOT.jar # Ajuste le nom du JAR si différent
    ```
    (Le nom du JAR peut varier légèrement, vérifie le contenu de ton dossier `target/` après le build).

L'application sera disponible sur `http://localhost:8080` (par défaut).

## API Endpoints (Exemples)

Les endpoints de l'API sont définis dans le package `web/`.
Voici quelques exemples de ressources exposées :

* `/api/users`
* `/api/etudiants`
* `/api/absences`
* `/api/cours`
* `/api/modules`
* `/api/classes`

Consulte le code dans `src/main/java/sn/dev/suiviabsence/web` pour la liste complète des endpoints et leurs méthodes HTTP (GET, POST, PUT, DELETE).
