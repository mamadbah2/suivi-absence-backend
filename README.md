# 📚 Suivi Absence Backend - Student Attendance Tracking System

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.0-6DB33F?logo=spring-boot&logoColor=white)
![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?logo=mongodb&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white)

**A comprehensive RESTful API for managing student attendance at ISM (Institut Supérieur de Management)**

[Features](#-features) • [Tech Stack](#-tech-stack) • [Architecture](#-architecture) • [Getting Started](#-getting-started) • [API Documentation](#-api-documentation)

</div>

---

## 📋 About The Project

**Suivi Absence Backend** is a learning-focused Spring Boot project designed to master backend development with modern Java technologies. This REST API manages the complete lifecycle of student attendance tracking, including absence recording, justification validation, and reporting for educational institutions.

### 🎯 Learning Objectives

- ✅ **Master Spring Boot**: Build production-ready REST APIs
- ✅ **NoSQL Database**: Work with MongoDB for flexible data modeling
- ✅ **RESTful Design**: Implement clean API architecture
- ✅ **Spring Security**: Secure endpoints with authentication
- ✅ **Docker**: Containerize applications for deployment
- ✅ **DTO Pattern**: Separate data transfer objects from entities
- ✅ **Service Layer**: Implement proper business logic separation

---

## ✨ Features

### 👨‍🎓 Student Management
- **Student Profiles**: Manage student information with matriculation numbers
- **Class Assignment**: Organize students by classes
- **Absence History**: Track complete absence records per student

### 📅 Attendance Tracking
- **Absence Recording**: Record student absences with date and time
- **Justification System**: Students can submit absence justifications
- **Status Management**: Track absence status (pending, validated, rejected)
- **Filter by Status**: View absences by presence status and class

### 👨‍🏫 Course Management
- **Module Management**: Organize courses by academic modules
- **Class Scheduling**: Define course schedules with start/end times
- **Teacher Assignment**: Associate teachers with modules

### 📊 Reporting & Analytics
- **Absence Reports**: Generate reports by class, module, or student
- **Real-time Statistics**: View absence counts and trends
- **Justification Validation**: Administrative approval workflow

### 🔐 Security & Authentication
- **User Authentication**: Secure login system
- **Role-based Access**: Different access levels (Admin, Teacher, Student)
- **JWT Ready**: Architecture prepared for token-based auth

### 📱 Multi-Platform Support
- **Web API**: Dedicated endpoints for web applications
- **Mobile API**: Optimized endpoints for mobile apps
- **Swagger Documentation**: Interactive API documentation

---

## 🛠️ Tech Stack

### Core Technologies

| Technology | Version | Purpose |
|------------|---------|---------|
| ![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk) | 17 | Primary language (96.5%) |
| ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.0-6DB33F?logo=spring-boot) | 3.5.0 | Application framework |
| ![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?logo=apache-maven) | 3.8+ | Build & dependency management |

### Spring Ecosystem

| Component | Purpose |
|-----------|---------|
| **Spring Web** | RESTful web services |
| **Spring Data MongoDB** | Database abstraction layer |
| **Spring Security** | Authentication & authorization |
| **Spring Boot DevTools** | Development productivity |
| **Spring Boot Actuator** | Application monitoring |

### Database & Storage

- **MongoDB**: NoSQL database for flexible document storage
- Ideal for managing complex student-course-absence relationships

### Additional Tools

- **Lombok**: Reduce boilerplate code with annotations
- **Docker**: Containerization (3.5% Dockerfile)
- **Swagger/OpenAPI**: API documentation
- **JUnit 5**: Unit and integration testing

---

## 🏗️ Architecture

### Domain Model

```
┌─────────────┐
│    User     │
└──────┬──────┘
       │
       ├─────────────┬─────────────┐
       │             │             │
┌──────▼──────┐ ┌───▼────┐   ┌────▼────┐
│  Etudiant   │ │ Teacher │   │  Admin  │
│ (Student)   │ └─────────┘   └─────────┘
│             │
│ - matricule │
│ - absences  │◄──────────┐
│ - classe    │           │
└─────────────┘           │
                          │
                    ┌─────▼─────┐
                    │  Absence  │
                    │           │
                    │ - date    │
                    │ - heure   │
                    │ - status  │
                    │ - justif  │
                    └─────┬─────┘
                          │
                          │
                    ┌─────▼─────┐
                    │   Cours   │
                    │ (Course)  │
                    │           │
                    │ - module  │
                    │ - classe  │
                    │ - horaire │
                    └─────┬─────┘
                          │
                 ┌────────┴────────┐
                 │                 │
           ┌─────▼─────┐     ┌────▼────┐
           │  Module   │     │ Classe  │
           │           │     │         │
           │ - nom     │     │ - nom   │
           │ - prof    │     │         │
           └───────────┘     └─────────┘
```

### Layered Architecture

```
┌─────────────────────────────────────────┐
│         Controllers Layer               │
│  (web/ & mobile/ REST endpoints)        │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│           Services Layer                │
│      (Business Logic)                   │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│        Data Access Layer                │
│  (Repositories + MongoDB)               │
└─────────────────────────────────────────┘
```

---

## 📦 Project Structure

```
suivi-absence-backend/
├── src/
│   ├── main/
│   │   ├── java/sn/dev/suiviabsence/
│   │   │   ├── SuiviAbsenceApplication.java  # Main entry point
│   │   │   ├── data/
│   │   │   │   ├── entities/           # Domain models
│   │   │   │   │   ├── User.java
│   │   │   │   │   ├── Etudiant.java
│   │   │   │   │   ├── Absence.java
│   │   │   │   │   ├── Cours.java
│   │   │   │   │   ├── Module.java
│   │   │   │   │   └── Classe.java
│   │   │   │   ├── repositories/       # MongoDB repositories
│   │   │   │   │   └── AbsenceRepository.java
│   │   │   │   └── enums/             # Status enumerations
│   │   │   ├── services/              # Business logic layer
│   │   │   │   ├── AbsenceService.java
│   │   │   │   └── impl/
│   │   │   ├── web/                   # Web API endpoints
│   │   │   │   ├── controllers/
│   │   │   │   │   ├── UserController.java
│   │   │   │   │   └── SwaggerRedirectController.java
│   │   │   │   └── dto/
│   │   │   │       ├── requests/      # Request DTOs
│   │   │   │       └── response/      # Response DTOs
│   │   │   ├── mobile/                # Mobile API endpoints
│   │   │   │   ├── controllers/
│   │   │   │   └── dto/
│   │   │   └── utils/
│   │   │       └── mappers/           # DTO mappers
│   │   └── resources/
│   │       └── application.properties
│   └── test/                          # Unit & integration tests
├── Dockerfile                         # Docker configuration
├── pom.xml                            # Maven dependencies
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- **JDK 17** or higher
- **Maven 3.8+** 
- **MongoDB 4.0+** (local or Atlas)
- **Docker** (optional, for containerization)

### Installation

#### 1. Clone the repository

```bash
git clone https://github.com/mamadbah2/suivi-absence-backend.git
cd suivi-absence-backend
```

#### 2. Configure MongoDB

**Option A: Local MongoDB**
```bash
# Start MongoDB
mongod --dbpath /path/to/data/directory
```

**Option B: MongoDB Atlas**

Update `src/main/resources/application.properties`:
```properties
spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/suiviabsence
```

#### 3. Build the project

```bash
# Using Maven
mvn clean install -DskipTests

# Or using Maven Wrapper
./mvnw clean install -DskipTests
```

#### 4. Run the application

```bash
# Using Maven
mvn spring-boot:run

# Or run the JAR directly
java -jar target/suivi-absence-0.0.1-SNAPSHOT.jar
```

The application will start on **http://localhost:8080**

---

## 🐳 Docker Deployment

### Build Docker Image

```bash
docker build -t suivi-absence-backend:latest .
```

### Run with Docker

```bash
docker run -p 8080:8080 \
  -e SPRING_DATA_MONGODB_URI=mongodb://host.docker.internal:27017/suiviabsence \
  suivi-absence-backend:latest
```

### Docker Compose (Optional)

Create `docker-compose.yml`:

```yaml
version: '3.8'
services:
  mongodb:
    image: mongo:7.0
    ports:
      - "27017:27017"
    volumes:
      - mongodb_data:/data/db

  backend:
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATA_MONGODB_URI=mongodb://mongodb:27017/suiviabsence
    depends_on:
      - mongodb

volumes:
  mongodb_data:
```

Run with:
```bash
docker-compose up -d
```

---

## 📖 API Documentation

### Swagger UI

Access interactive API documentation at:
- **Swagger UI**: http://localhost:8080/swagger-ui/index.html
- **API Docs**: http://localhost:8080/docs

### Main API Endpoints

#### 🔐 Authentication

```
POST   /users/auth                 # User login
```

#### 👨‍🎓 Students (Web API)

```
GET    /api/etudiants              # Get all students
GET    /api/etudiants/{id}         # Get student by ID
POST   /api/etudiants              # Create new student
PUT    /api/etudiants/{id}         # Update student
DELETE /api/etudiants/{id}         # Delete student
```

#### 📅 Absences (Web API)

```
GET    /api/absences               # Get all absences
GET    /api/absences/{id}          # Get absence by ID
POST   /api/absences               # Record new absence
PUT    /api/absences/{id}          # Update absence
DELETE /api/absences/{id}          # Delete absence
```

#### 📱 Mobile API

```
GET    /absences-mobiles/          # Get all absences (mobile)
GET    /absences-mobiles/filtre/{presence}/{classe}  # Filter absences
POST   /absences-mobiles/validate  # Validate justification
GET    /absences-mobiles/absent/{classe}  # Get absences by class
PUT    /absences-mobiles/update/jutification  # Update justification
```

#### 📚 Courses & Modules

```
GET    /api/cours                  # Get all courses
GET    /api/modules                # Get all modules
GET    /api/classes                # Get all classes
```

### Request/Response Examples

#### Create Absence

**Request:**
```json
POST /api/absences
Content-Type: application/json

{
  "matricule": "ETD001",
  "nom": "Fall",
  "prenom": "Aminata",
  "classe": "GLRS_L3",
  "module": "Architecture Logicielle",
  "date": "2025-10-16",
  "heure": "08:00",
  "status": "pending"
}
```

**Response:**
```json
{
  "id": "67301a2f8b3d4e5f6a7b8c9d",
  "matricule": "ETD001",
  "nom": "Fall",
  "prenom": "Aminata",
  "classe": "GLRS_L3",
  "module": "Architecture Logicielle",
  "date": "2025-10-16",
  "heure": "08:00",
  "justification": null,
  "status": "pending"
}
```

#### Student Absences Response (Mobile)

```json
{
  "matricule": "ETD001",
  "nom": "Fall",
  "prenom": "Aminata",
  "classe": "GLRS_L3",
  "absences": [
    {
      "module": "Architecture Logicielle",
      "dateDebut": "08:00",
      "dateFin": "10:00",
      "justification": "Visite médicale",
      "status": "validated"
    }
  ]
}
```

---

## 🔧 Configuration

### Application Properties

Edit `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080

# MongoDB Configuration
spring.data.mongodb.uri=mongodb://localhost:27017/suiviabsence
spring.data.mongodb.database=suiviabsence

# Application Name
spring.application.name=suivi-absence

# Logging
logging.level.sn.dev.suiviabsence=DEBUG

# Security (if enabled)
spring.security.user.name=admin
spring.security.user.password=password
```

---

## 🧪 Testing

Run tests with Maven:

```bash
# Run all tests
mvn test

# Run specific test
mvn test -Dtest=SuiviAbsenceApplicationTests

# Run with coverage
mvn clean verify
```

---

## 🎓 Key Learning Concepts

### 1. Spring Boot Application Structure

```java
@SpringBootApplication
public class SuiviAbsenceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuiviAbsenceApplication.class, args);
    }
}
```

### 2. MongoDB Document Mapping

```java
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Absence {
    String id;
    String heure;
    String date;
    String justification;
    Etudiant etudiant;
    Cours cours;
    String status;
}
```

### 3. Repository Pattern

```java
@Repository
public interface AbsenceRepository extends MongoRepository<Absence, String> {
    // Spring Data MongoDB provides CRUD operations automatically
}
```

### 4. Service Layer

```java
public interface AbsenceService {
    List<Absence> getAbsentOuRetard(String filtre);
    void validateJustification(Absence absence);
    List<Absence> getAbsentByClasse(String nomClasse);
}
```

### 5. REST Controllers

```java
@Controller
@RequestMapping("/users")
public interface UserController {
    @PostMapping("/auth")
    ResponseEntity<Map<String, Object>> authentification(@RequestBody UserLoginDto userLoginDto);
}
```

### 6. DTO Pattern

**Separation of concerns** between entities and API contracts:
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceSimpleResponseDto {
    private String matricule;
    private String nom;
    private String prenom;
    private String classe;
    private String module;
    private String justification;
    private String status;
}
```

---

## 🌟 Best Practices Implemented

✅ **Layered Architecture**: Clear separation of concerns  
✅ **DTO Pattern**: Separate data transfer from domain models  
✅ **Repository Pattern**: Abstraction over data access  
✅ **Dependency Injection**: Spring-managed beans  
✅ **RESTful API Design**: Standard HTTP methods and status codes  
✅ **Lombok Usage**: Reduced boilerplate with annotations  
✅ **Exception Handling**: Proper error responses  
✅ **API Documentation**: Swagger/OpenAPI integration  

---

## 🚧 Future Enhancements

### Planned Features

- [ ] 📧 Email notifications for absence alerts
- [ ] 📊 Advanced analytics dashboard
- [ ] 📱 Real-time notifications (WebSocket)
- [ ] 📄 PDF report generation
- [ ] 🔐 JWT authentication implementation
- [ ] 🌐 Multi-language support
- [ ] 📅 Calendar integration
- [ ] 📈 Absence trend analysis
- [ ] 🔔 Parent notification system
- [ ] 🎯 Attendance percentage tracking

---

## 🤝 Contributing

This is a learning project, but contributions are welcome!

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📚 Learning Resources

### Official Documentation
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb)
- [MongoDB Documentation](https://docs.mongodb.com/)

### Tutorials
- [Building REST APIs with Spring Boot](https://spring.io/guides/tutorials/rest/)
- [Spring Boot with MongoDB](https://www.baeldung.com/spring-data-mongodb-tutorial)

---

## 📄 License

This project is available for educational purposes.

---

## 📧 Contact

**Mamadou Bah** - [@mamadbah2](https://github.com/mamadbah2)

Project Link: [https://github.com/mamadbah2/suivi-absence-backend](https://github.com/mamadbah2/suivi-absence-backend)

---

<div align="center">

**🎓 Built to Learn Spring Boot & REST API Development 🎓**

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white&style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.0-6DB33F?logo=spring-boot&logoColor=white&style=for-the-badge)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?logo=mongodb&logoColor=white&style=for-the-badge)

**⭐ If this project helped you learn Spring Boot, please give it a star! ⭐**

</div>
