# Étape de construction (utilise un JDK complet pour la compilation)
FROM maven:3.9.6-openjdk-17 AS build

# Copie le code de ton application dans le conteneur
COPY . /app
WORKDIR /app

# Exécute la construction Maven
# -DskipTests pour sauter les tests et accélérer le build (ajuste si tu veux lancer les tests)
RUN mvn clean package -DskipTests

# Étape d'exécution (utilise une image JDK plus légère pour la production)
FROM openjdk:17-jdk-slim

# Expose le port par défaut de Spring Boot
EXPOSE 8080

# Copie le JAR généré par Maven depuis l'étape de construction
# Assure-toi que le nom du JAR est correct (remplace 'ton-app-0.0.1-SNAPSHOT.jar' par le vrai nom)
COPY --from=build /app/target/suivi-absence-0.0.1-SNAPSHOT.jar app.jar

# Commande pour démarrer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]