# Suivi Absence Backend - ISM

Ce projet est le service backend pour une application de suivi des absences, développé avec Spring Boot. Il gère les entités liées aux utilisateurs, étudiants, cours, modules, classes et absences à l'ISM.

## Technologies Utilisées

- Spring Boot
- Java 17
- Maven (pour la gestion des dépendances et la construction)
- Base de données: MongoDB

## Structure du Projet

```
.
├── .mvn/                      # Fichiers wrapper Maven
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── sn/dev/suiviabsence/
│   │   │       ├── core/             # Domain, Services, Mappers
│   │   │       ├── infrastructure/   # Persistence, External Services
│   │   │       ├── presentation/     # API Controllers, DTOs
│   │   │       └── shared/           # Utils, Common Code
│   │   ├── resources/          # Configuration de l'application
│   └── test/                  # Tests unitaires et d'intégration
├── .gitignore                 # Fichiers/dossiers à ignorer par Git
├── Dockerfile                 # Configuration Docker
├── mvnw                      # Script Wrapper Maven (Linux/macOS)
├── mvnw.cmd                  # Script Wrapper Maven (Windows)
└── README.md                 # Ce fichier
```

## Configuration et Lancement Local

### Prérequis

- JDK 17 installé
- Maven installé
- MongoDB installé et configuré
- Une base de données configurée (ajuster `src/main/resources/application.properties` en conséquence)

### Étapes de Lancement

1. **Cloner le dépôt :**
```bash
git clone https://github.com/mamadbah2/suivi-absence-backend.git
cd suivi-absence-backend
```

2. **Construire le projet :**
```bash
mvn clean install -DskipTests
```

3. **Lancer l'application :**
```bash
java -jar target/suivi-absence-backend-0.0.1-SNAPSHOT.jar
```
L'application sera disponible sur http://localhost:8080 (par défaut).

## API Endpoints

Les endpoints de l'API sont définis dans le package `presentation/api/`. Voici les principales ressources exposées :

- `/api/users` - Gestion des utilisateurs
- `/api/etudiants` - Gestion des étudiants
- `/api/absences` - Gestion des absences
- `/api/cours` - Gestion des cours
- `/api/modules` - Gestion des modules
- `/api/classes` - Gestion des classes

Consulte le code dans `src/main/java/sn/dev/suiviabsence/presentation/api/` pour la liste complète des endpoints et leurs méthodes HTTP (GET, POST, PUT, DELETE).

## Base de données

Le projet utilise MongoDB comme base de données. Assurez-vous que MongoDB est installé et en cours d'exécution sur votre machine.

Configuration par défaut dans `application.properties` :
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/suivi-absence
```

## Contribution

1. Fork le projet
2. Créez votre branche de fonctionnalité (`git checkout -b feature/AmazingFeature`)
3. Committez vos changements (`git commit -m 'Add some AmazingFeature'`)
4. Push vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrez une Pull Request
