package sn.dev.suiviabsence.data.mock;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sn.dev.suiviabsence.data.entities.*;
import sn.dev.suiviabsence.data.entities.Module;
import sn.dev.suiviabsence.data.enums.Filiere;
import sn.dev.suiviabsence.data.enums.Niveau;
import sn.dev.suiviabsence.data.enums.Role;
import sn.dev.suiviabsence.data.enums.Status;
import sn.dev.suiviabsence.data.repositories.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final UserRepository userRepository;
    private final EtudiantRepository etudiantRepository;
    private final ClasseRepository classeRepository;
    private final AbsenceRepository absenceRepository;
    private final ModuleRepository moduleRepository;
    private final CoursRepository coursRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        userRepository.deleteAll();
        etudiantRepository.deleteAll();
        classeRepository.deleteAll();
        absenceRepository.deleteAll();
        moduleRepository.deleteAll();
        coursRepository.deleteAll();

        //user vigile

        User vigile1 = new User();
        vigile1.setNom("Sow");
        vigile1.setPrenom("Ibrahima");
        vigile1.setEmail("ibrahima.sow@groupeism.sn");
        vigile1.setPassword(passwordEncoder.encode("vigile1"));
        vigile1.setRole(Role.VIGILE);
        userRepository.save(vigile1);


        User admin = new User();
        admin.setNom("Sow");
        admin.setPrenom("Ibrahim");
        admin.setEmail("ibrahim.sow@groupeism.sn");
        admin.setPassword(passwordEncoder.encode("admin1"));
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);

        User vigile2 = new User();
        vigile2.setNom("Diallo");
        vigile2.setPrenom("Aissatou");
        vigile2.setEmail("aissatou.diallo@groupeism.sn");
        vigile2.setPassword(passwordEncoder.encode("vigile2"));
        vigile2.setRole(Role.VIGILE);
        userRepository.save(vigile2);


        // Classes
        Classe classe1 = new Classe();
        classe1.setNom("GLRS_L3");
        classe1.setFiliere(Filiere.GLRS);
        classe1.setNiveau(Niveau.L3);
        classeRepository.save(classe1);

        Classe classe2 = new Classe();
        classe2.setNom("IAGE_L2");
        classe2.setFiliere(Filiere.IAGE);
        classe2.setNiveau(Niveau.L2);
        classeRepository.save(classe2);

        Classe classe3 = new Classe();
        classe3.setNom("MAI_L1");
        classe3.setFiliere(Filiere.MAI);
        classe3.setNiveau(Niveau.L1);
        classeRepository.save(classe3);

        Classe classe4 = new Classe();
        classe4.setNom("CPD_L3");
        classe4.setFiliere(Filiere.CPD);
        classe4.setNiveau(Niveau.L3);
        classeRepository.save(classe4);

        Classe classe5 = new Classe();
        classe5.setNom("CDSD_L2");
        classe5.setFiliere(Filiere.CDSD);
        classe5.setNiveau(Niveau.L2);
        classeRepository.save(classe5);

        //Etudiants
        Etudiant e1 = new Etudiant();
        e1.setNom("Fall");
        e1.setPrenom("Aminata");
        e1.setEmail("aminata.fall@ism.edu.sn");
        e1.setPassword(passwordEncoder.encode("password1"));
        e1.setRole(Role.ETUDIANT);
        e1.setMatricule("ETD001");
        e1.setClasse(classe1);
        etudiantRepository.save(e1);

        Etudiant e2 = new Etudiant();
        e2.setNom("Diop");
        e2.setPrenom("Moussa");
        e2.setEmail("moussa.diop@@ism.edu.sn");
        e2.setPassword(passwordEncoder.encode("password2"));
        e2.setRole(Role.ETUDIANT);
        e2.setMatricule("ETD002");
        e2.setClasse(classe2);
        etudiantRepository.save(e2);

        Etudiant e3 = new Etudiant();
        e3.setNom("Keita");
        e3.setPrenom("Fatima");
        e3.setEmail("fatima.keita@ism.edu.sn");
        e3.setPassword(passwordEncoder.encode("password3"));
        e3.setRole(Role.ETUDIANT);
        e3.setMatricule("ETD003");
        e3.setClasse(classe3);
        etudiantRepository.save(e3);

        Etudiant e4 = new Etudiant();
        e4.setNom("Ndiaye");
        e4.setPrenom("Anna");
        e4.setEmail("anna.Ndiaye@ism.edu.sn");
        e4.setPassword(passwordEncoder.encode("password4"));
        e4.setRole(Role.ETUDIANT);
        e4.setMatricule("ETD004");
        e4.setClasse(classe4);
        etudiantRepository.save(e4);

        Etudiant e5 = new Etudiant();
        e5.setNom("Bah");
        e5.setPrenom("Bobo");
        e5.setEmail("bobo.bah@ism.edu.sn");
        e5.setPassword(passwordEncoder.encode("password5"));
        e5.setRole(Role.ETUDIANT);
        e5.setMatricule("ETD005");
        e5.setClasse(classe5);
        etudiantRepository.save(e5);
        
        // Ajouter plus d'étudiants pour avoir plus d'absences/présences
        Etudiant e6 = new Etudiant();
        e6.setNom("Seck");
        e6.setPrenom("Oumar");
        e6.setEmail("oumar.seck@ism.edu.sn");
        e6.setPassword(passwordEncoder.encode("password6"));
        e6.setRole(Role.ETUDIANT);
        e6.setMatricule("ETD006");
        e6.setClasse(classe1);
        etudiantRepository.save(e6);

        Etudiant e7 = new Etudiant();
        e7.setNom("Gueye");
        e7.setPrenom("Aida");
        e7.setEmail("aida.gueye@ism.edu.sn");
        e7.setPassword(passwordEncoder.encode("password7"));
        e7.setRole(Role.ETUDIANT);
        e7.setMatricule("ETD007");
        e7.setClasse(classe1);
        etudiantRepository.save(e7);

        Etudiant e8 = new Etudiant();
        e8.setNom("Mbaye");
        e8.setPrenom("Cheikh");
        e8.setEmail("cheikh.mbaye@ism.edu.sn");
        e8.setPassword(passwordEncoder.encode("password8"));
        e8.setRole(Role.ETUDIANT);
        e8.setMatricule("ETD008");
        e8.setClasse(classe2);
        etudiantRepository.save(e8);

        Etudiant e9 = new Etudiant();
        e9.setNom("Sarr");
        e9.setPrenom("Mariama");
        e9.setEmail("mariama.sarr@ism.edu.sn");
        e9.setPassword(passwordEncoder.encode("password9"));
        e9.setRole(Role.ETUDIANT);
        e9.setMatricule("ETD009");
        e9.setClasse(classe3);
        etudiantRepository.save(e9);

        Etudiant e10 = new Etudiant();
        e10.setNom("Faye");
        e10.setPrenom("Abdoulaye");
        e10.setEmail("abdoulaye.faye@ism.edu.sn");
        e10.setPassword(passwordEncoder.encode("password10"));
        e10.setRole(Role.ETUDIANT);
        e10.setMatricule("ETD010");
        e10.setClasse(classe4);
        etudiantRepository.save(e10);

        // Module
        Module module1 = new Module();
        module1.setNom("Programmation Web");
        module1.setNomProf("Baila Wane");
        module1.setClasse(classe1);
        moduleRepository.save(module1);

        Module module2 = new Module();
        module2.setNom("Droit du travail");
        module2.setNomProf("Mr Diouf");
        module2.setClasse(classe2);
        moduleRepository.save(module2);

        Module module3 = new Module();
        module3.setNom("flask");
        module3.setNomProf("Aly Niang");
        module3.setClasse(classe1);
        moduleRepository.save(module3);

        Module module4 = new Module();
        module4.setNom("Management du processus");
        module4.setNomProf("Mr Diallo");
        module4.setClasse(classe2);
        moduleRepository.save(module4);

        Module module5 = new Module();
        module5.setNom("CMS");
        module5.setNomProf("Mr Sekou");
        module5.setClasse(classe3);
        moduleRepository.save(module5);

        Module module6 = new Module();
        module6.setNom("Gestion");
        module6.setNomProf("Mr Faye");
        module6.setClasse(classe3);
        moduleRepository.save(module6);

        Module module7 = new Module();
        module7.setNom("Windows");
        module7.setNomProf("Mr Lo");
        module7.setClasse(classe4);
        moduleRepository.save(module7);

        Module module8 = new Module();
        module8.setNom("Maths");
        module8.setNomProf("Mr Diaby");
        module8.setClasse(classe4);
        moduleRepository.save(module8);

        Module module9 = new Module();
        module9.setNom("Electricité");
        module9.setNomProf("Mr Mbaye");
        module9.setClasse(classe5);
        moduleRepository.save(module9);

        Module module10 = new Module();
        module10.setNom("Base de données sous Oracle");
        module10.setNomProf("Mr Kara Samb");
        module10.setClasse(classe5);
        moduleRepository.save(module10);

        // Cours
        Cours cours1 = new Cours();
        cours1.setDate("2024-05-25");
        cours1.setHeureDebut("08:00");
        cours1.setHeureFin("12:00");
        cours1.setModule(module1);
        cours1.setClasse(classe1);
        coursRepository.save(cours1);

        Cours cours2 = new Cours();
        cours2.setDate("2025-06-01");
        cours2.setHeureDebut("08:00");
        cours2.setHeureFin("10:00");
        cours2.setModule(module2);
        cours2.setClasse(classe2);
        coursRepository.save(cours2);

        Cours cours3 = new Cours();
        cours3.setDate("2024-05-27");
        cours3.setHeureDebut("10:00");
        cours3.setHeureFin("13:00");
        cours3.setModule(module3);
        cours3.setClasse(classe1);
        coursRepository.save(cours3);

        Cours cours4 = new Cours();
        cours4.setDate("2024-06-01");
        cours4.setHeureDebut("08:00");
        cours4.setHeureFin("11:00");
        cours4.setModule(module4);
        cours4.setClasse(classe2);
        coursRepository.save(cours4);

        Cours cours5 = new Cours();
        cours5.setDate("2024-06-03");
        cours5.setHeureDebut("13:00");
        cours5.setHeureFin("17:00");
        cours5.setModule(module5);
        cours5.setClasse(classe3);
        coursRepository.save(cours5);

        Cours cours6 = new Cours();
        cours6.setDate("2024-06-05");
        cours6.setHeureDebut("15:00");
        cours6.setHeureFin("17:00");
        cours6.setModule(module6);
        cours6.setClasse(classe3);
        coursRepository.save(cours6);

        Cours cours7 = new Cours();
        cours7.setDate("2024-06-07");
        cours7.setHeureDebut("09:00");
        cours7.setHeureFin("11:00");
        cours7.setModule(module7);
        cours7.setClasse(classe4);
        coursRepository.save(cours7);

        Cours cours8 = new Cours();
        cours8.setDate("2024-06-06");
        cours8.setHeureDebut("08:00");
        cours8.setHeureFin("12:00");
        cours8.setModule(module8);
        cours8.setClasse(classe4);
        coursRepository.save(cours8);

        Cours cours9 = new Cours();
        cours9.setDate("2024-06-10");
        cours9.setHeureDebut("09:00");
        cours9.setHeureFin("11:00");
        cours9.setModule(module9);
        cours9.setClasse(classe5);
        coursRepository.save(cours9);

        Cours cours10 = new Cours();
        cours10.setDate("2024-06-25");
        cours10.setHeureDebut("15:00");
        cours10.setHeureFin("18:00");
        cours10.setModule(module10);
        cours10.setClasse(classe5);
        coursRepository.save(cours10);

        // Absences
        Absence a1 = new Absence();
        a1.setDate("2025-06-01");
        a1.setHeure("08:40");
        a1.setStatus(Status.ABSENT);
        a1.setJustification("Retard de transport");
        a1.setEtudiant(e1);
        a1.setCours(cours1);
        absenceRepository.save(a1);

        Absence a2 = new Absence();
        a2.setDate("2024-05-27");
        a2.setHeure("13:00");
        a2.setStatus(Status.RETARD);
        a2.setJustification(null);
        a2.setEtudiant(e1);
        a2.setCours(cours3);
        absenceRepository.save(a2);
        
        // Ajouter des cours pour la date actuelle (1 juin 2025)
        String today = "2025-06-01"; // Date fixe pour les tests
        LocalDate todayDate = LocalDate.parse(today);
        
        // Cours pour aujourd'hui (2025-06-01)
        Cours coursToday1 = new Cours();
        coursToday1.setDate(today);
        coursToday1.setHeureDebut("08:00");
        coursToday1.setHeureFin("12:00");
        coursToday1.setModule(module1);
        coursToday1.setClasse(classe1);
        coursRepository.save(coursToday1);
        
        Cours coursToday2 = new Cours();
        coursToday2.setDate(today);
        coursToday2.setHeureDebut("09:00");
        coursToday2.setHeureFin("11:00");
        coursToday2.setModule(module2);
        coursToday2.setClasse(classe2);
        coursRepository.save(coursToday2);
        
        Cours coursToday3 = new Cours();
        coursToday3.setDate(today);
        coursToday3.setHeureDebut("13:00");
        coursToday3.setHeureFin("15:00");
        coursToday3.setModule(module5);
        coursToday3.setClasse(classe3);
        coursRepository.save(coursToday3);

        Cours coursToday4 = new Cours();
        coursToday4.setDate(today);
        coursToday4.setHeureDebut("15:30");
        coursToday4.setHeureFin("17:30");
        coursToday4.setModule(module7);
        coursToday4.setClasse(classe4);
        coursRepository.save(coursToday4);
        
        // Ajouter des absences avec les statuts PRESENT, RETARD et ABSENT pour aujourd'hui
        
        // Format des heures pour simuler les pointages à différentes heures
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        // PRÉSENCES
        // Étudiant 1 - PRESENT (arrivé avant le début du cours)
        Absence absenceToday1 = new Absence();
        absenceToday1.setDate(today);
        absenceToday1.setHeure(LocalTime.of(7, 55).format(timeFormatter));
        absenceToday1.setStatus(Status.PRESENT);
        absenceToday1.setJustification(null);
        absenceToday1.setEtudiant(e1);
        absenceToday1.setCours(coursToday1);
        absenceRepository.save(absenceToday1);
        
        // Étudiant 2 - PRESENT (arrivé avant le début du cours)
        Absence absenceToday2 = new Absence();
        absenceToday2.setDate(today);
        absenceToday2.setHeure(LocalTime.of(8, 50).format(timeFormatter));
        absenceToday2.setStatus(Status.PRESENT);
        absenceToday2.setJustification(null);
        absenceToday2.setEtudiant(e2);
        absenceToday2.setCours(coursToday2);
        absenceRepository.save(absenceToday2);
        
        // Étudiant 6 - PRESENT (arrivé juste à l'heure)
        Absence absenceToday3 = new Absence();
        absenceToday3.setDate(today);
        absenceToday3.setHeure(LocalTime.of(8, 0).format(timeFormatter));
        absenceToday3.setStatus(Status.PRESENT);
        absenceToday3.setJustification(null);
        absenceToday3.setEtudiant(e6);
        absenceToday3.setCours(coursToday1);
        absenceRepository.save(absenceToday3);
        
        // Étudiant 7 - PRESENT
        Absence absenceToday4 = new Absence();
        absenceToday4.setDate(today);
        absenceToday4.setHeure(LocalTime.of(7, 58).format(timeFormatter));
        absenceToday4.setStatus(Status.PRESENT);
        absenceToday4.setJustification(null);
        absenceToday4.setEtudiant(e7);
        absenceToday4.setCours(coursToday1);
        absenceRepository.save(absenceToday4);
        
        // RETARDS
        // Étudiant 3 - RETARD (arrivé après le début du cours)
        Absence absenceToday5 = new Absence();
        absenceToday5.setDate(today);
        absenceToday5.setHeure(LocalTime.of(13, 10).format(timeFormatter));
        absenceToday5.setStatus(Status.RETARD);
        absenceToday5.setJustification("Transport en commun");
        absenceToday5.setEtudiant(e3);
        absenceToday5.setCours(coursToday3);
        absenceRepository.save(absenceToday5);
        
        // Étudiant 8 - RETARD 
        Absence absenceToday6 = new Absence();
        absenceToday6.setDate(today);
        absenceToday6.setHeure(LocalTime.of(9, 15).format(timeFormatter));
        absenceToday6.setStatus(Status.RETARD);
        absenceToday6.setJustification("Problème de santé");
        absenceToday6.setEtudiant(e8);
        absenceToday6.setCours(coursToday2);
        absenceRepository.save(absenceToday6);
        
        // Étudiant 9 - RETARD
        Absence absenceToday7 = new Absence();
        absenceToday7.setDate(today);
        absenceToday7.setHeure(LocalTime.of(13, 20).format(timeFormatter));
        absenceToday7.setStatus(Status.RETARD);
        absenceToday7.setJustification("Panne de voiture");
        absenceToday7.setEtudiant(e9);
        absenceToday7.setCours(coursToday3);
        absenceRepository.save(absenceToday7);
        
        // ABSENTS
        // Étudiant 4 - ABSENT
        Absence absenceToday8 = new Absence();
        absenceToday8.setDate(today);
        absenceToday8.setHeure(coursToday4.getHeureDebut());
        absenceToday8.setStatus(Status.ABSENT);
        absenceToday8.setJustification(null);
        absenceToday8.setEtudiant(e4);
        absenceToday8.setCours(coursToday4);
        absenceRepository.save(absenceToday8);
        
        // Étudiant 5 - ABSENT
        Absence absenceToday9 = new Absence();
        absenceToday9.setDate(today);
        absenceToday9.setHeure(coursToday1.getHeureDebut());
        absenceToday9.setStatus(Status.ABSENT);
        absenceToday9.setJustification(null);
        absenceToday9.setEtudiant(e5);
        absenceToday9.setCours(coursToday1);
        absenceRepository.save(absenceToday9);
        
        // Étudiant 10 - PRESENT (arrivé très tôt)
        Absence absenceToday10 = new Absence();
        absenceToday10.setDate(today);
        absenceToday10.setHeure(LocalTime.of(15, 15).format(timeFormatter));
        absenceToday10.setStatus(Status.PRESENT);
        absenceToday10.setJustification(null);
        absenceToday10.setEtudiant(e10);
        absenceToday10.setCours(coursToday4);
        absenceRepository.save(absenceToday10);
        
        // Ajout supplémentaire de PRESENT et RETARD pour tester la limite de 5
        Absence absenceToday11 = new Absence();
        absenceToday11.setDate(today);
        absenceToday11.setHeure(LocalTime.of(8, 5).format(timeFormatter));
        absenceToday11.setStatus(Status.RETARD);
        absenceToday11.setJustification("Trafic");
        absenceToday11.setEtudiant(e5);
        absenceToday11.setCours(coursToday2);
        absenceRepository.save(absenceToday11);
    }
}
