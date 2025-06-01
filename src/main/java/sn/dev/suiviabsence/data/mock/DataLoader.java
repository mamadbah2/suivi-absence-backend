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
        
        // Ajout de nouveaux étudiants
        Etudiant e11 = new Etudiant();
        e11.setNom("Diallo");
        e11.setPrenom("Ramatoulaye");
        e11.setEmail("ramatoulaye.diallo@ism.edu.sn");
        e11.setPassword(passwordEncoder.encode("password11"));
        e11.setRole(Role.ETUDIANT);
        e11.setMatricule("ETD011");
        e11.setClasse(classe1);
        etudiantRepository.save(e11);
        
        Etudiant e12 = new Etudiant();
        e12.setNom("Sene");
        e12.setPrenom("Moustapha");
        e12.setEmail("moustapha.sene@ism.edu.sn");
        e12.setPassword(passwordEncoder.encode("password12"));
        e12.setRole(Role.ETUDIANT);
        e12.setMatricule("ETD012");
        e12.setClasse(classe2);
        etudiantRepository.save(e12);
        
        Etudiant e13 = new Etudiant();
        e13.setNom("Wade");
        e13.setPrenom("Coumba");
        e13.setEmail("coumba.wade@ism.edu.sn");
        e13.setPassword(passwordEncoder.encode("password13"));
        e13.setRole(Role.ETUDIANT);
        e13.setMatricule("ETD013");
        e13.setClasse(classe3);
        etudiantRepository.save(e13);
        
        Etudiant e14 = new Etudiant();
        e14.setNom("Thiam");
        e14.setPrenom("Seydina");
        e14.setEmail("seydina.thiam@ism.edu.sn");
        e14.setPassword(passwordEncoder.encode("password14"));
        e14.setRole(Role.ETUDIANT);
        e14.setMatricule("ETD014");
        e14.setClasse(classe4);
        etudiantRepository.save(e14);
        
        Etudiant e15 = new Etudiant();
        e15.setNom("Niang");
        e15.setPrenom("Fatou");
        e15.setEmail("fatou.niang@ism.edu.sn");
        e15.setPassword(passwordEncoder.encode("password15"));
        e15.setRole(Role.ETUDIANT);
        e15.setMatricule("ETD015");
        e15.setClasse(classe5);
        etudiantRepository.save(e15);

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
        
        // Nouveaux modules
        Module module11 = new Module();
        module11.setNom("Java Avancé");
        module11.setNomProf("Mme Dieng");
        module11.setClasse(classe1);
        moduleRepository.save(module11);
        
        Module module12 = new Module();
        module12.setNom("Sécurité Informatique");
        module12.setNomProf("Mr Diagne");
        module12.setClasse(classe2);
        moduleRepository.save(module12);
        
        Module module13 = new Module();
        module13.setNom("Réseaux et Protocoles");
        module13.setNomProf("Mme Touré");
        module13.setClasse(classe3);
        moduleRepository.save(module13);

        // Cours
        Cours cours1 = new Cours();
        cours1.setDate(LocalDate.now().toString());
        cours1.setHeureDebut("08:00");
        cours1.setHeureFin("12:00");
        cours1.setModule(module1);
        cours1.setClasse(classe1);
        coursRepository.save(cours1);

        Cours cours2 = new Cours();
        cours2.setDate(LocalDate.now().toString());
        cours2.setHeureDebut("08:00");
        cours2.setHeureFin("10:00");
        cours2.setModule(module2);
        cours2.setClasse(classe2);
        coursRepository.save(cours2);

        Cours cours3 = new Cours();
        cours3.setDate(LocalDate.now().toString());
        cours3.setHeureDebut("10:00");
        cours3.setHeureFin("13:00");
        cours3.setModule(module3);
        cours3.setClasse(classe1);
        coursRepository.save(cours3);

        Cours cours4 = new Cours();
        cours4.setDate(LocalDate.now().toString());
        cours4.setHeureDebut("08:00");
        cours4.setHeureFin("11:00");
        cours4.setModule(module4);
        cours4.setClasse(classe2);
        coursRepository.save(cours4);

        Cours cours5 = new Cours();
        cours5.setDate(LocalDate.now().toString());
        cours5.setHeureDebut("13:00");
        cours5.setHeureFin("17:00");
        cours5.setModule(module5);
        cours5.setClasse(classe3);
        coursRepository.save(cours5);

        Cours cours6 = new Cours();
        cours6.setDate(LocalDate.now().toString());
        cours6.setHeureDebut("15:00");
        cours6.setHeureFin("17:00");
        cours6.setModule(module6);
        cours6.setClasse(classe3);
        coursRepository.save(cours6);

        Cours cours7 = new Cours();
        cours7.setDate(LocalDate.now().toString());
        cours7.setHeureDebut("09:00");
        cours7.setHeureFin("11:00");
        cours7.setModule(module7);
        cours7.setClasse(classe4);
        coursRepository.save(cours7);

        Cours cours8 = new Cours();
        cours8.setDate(LocalDate.now().toString());
        cours8.setHeureDebut("08:00");
        cours8.setHeureFin("12:00");
        cours8.setModule(module8);
        cours8.setClasse(classe4);
        coursRepository.save(cours8);

        Cours cours9 = new Cours();
        cours9.setDate(LocalDate.now().toString());
        cours9.setHeureDebut("09:00");
        cours9.setHeureFin("11:00");
        cours9.setModule(module9);
        cours9.setClasse(classe5);
        coursRepository.save(cours9);

        Cours cours10 = new Cours();
        cours10.setDate(LocalDate.now().toString());
        cours10.setHeureDebut("15:00");
        cours10.setHeureFin("18:00");
        cours10.setModule(module10);
        cours10.setClasse(classe5);
        coursRepository.save(cours10);

        // Absences
        Absence a1 = new Absence();
        a1.setDate(LocalDate.now().toString());
        a1.setHeure("08:40");
        a1.setStatus(Status.ABSENT);
        a1.setJustification("Retard de transport");
        a1.setEtudiant(e1);
        a1.setCours(cours1);
        absenceRepository.save(a1);

        Absence a2 = new Absence();
        a2.setDate(LocalDate.now().toString());
        a2.setHeure("13:00");
        a2.setStatus(Status.RETARD);
        a2.setJustification(null);
        a2.setEtudiant(e1);
        a2.setCours(cours3);
        absenceRepository.save(a2);
        
        // Ajouter des cours pour la date actuelle (1 juin 2025)
        String today = LocalDate.now().toString(); // Date fixe pour les tests
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
        
        // Nouveaux cours pour aujourd'hui
        Cours coursToday5 = new Cours();
        coursToday5.setDate(today);
        coursToday5.setHeureDebut("10:00");
        coursToday5.setHeureFin("12:30");
        coursToday5.setModule(module11);
        coursToday5.setClasse(classe1);
        coursRepository.save(coursToday5);
        
        Cours coursToday6 = new Cours();
        coursToday6.setDate(today);
        coursToday6.setHeureDebut("14:00");
        coursToday6.setHeureFin("16:00");
        coursToday6.setModule(module12);
        coursToday6.setClasse(classe2);
        coursRepository.save(coursToday6);
        
        Cours coursToday7 = new Cours();
        coursToday7.setDate(today);
        coursToday7.setHeureDebut("16:00");
        coursToday7.setHeureFin("18:30");
        coursToday7.setModule(module13);
        coursToday7.setClasse(classe3);
        coursRepository.save(coursToday7);
        
        Cours coursToday8 = new Cours();
        coursToday8.setDate(today);
        coursToday8.setHeureDebut("08:30");
        coursToday8.setHeureFin("11:30");
        coursToday8.setModule(module9);
        coursToday8.setClasse(classe5);
        coursRepository.save(coursToday8);
        
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
        
        // Nouvelles absences pour aujourd'hui
        
        // Étudiant 11 - PRESENT
        Absence absenceToday12 = new Absence();
        absenceToday12.setDate(today);
        absenceToday12.setHeure(LocalTime.of(7, 45).format(timeFormatter));
        absenceToday12.setStatus(Status.PRESENT);
        absenceToday12.setJustification(null);
        absenceToday12.setEtudiant(e11);
        absenceToday12.setCours(coursToday1);
        absenceRepository.save(absenceToday12);
        
        // Étudiant 11 - PRESENT (second cours)
        Absence absenceToday13 = new Absence();
        absenceToday13.setDate(today);
        absenceToday13.setHeure(LocalTime.of(10, 0).format(timeFormatter));
        absenceToday13.setStatus(Status.PRESENT);
        absenceToday13.setJustification(null);
        absenceToday13.setEtudiant(e11);
        absenceToday13.setCours(coursToday5);
        absenceRepository.save(absenceToday13);
        
        // Étudiant 12 - RETARD
        Absence absenceToday14 = new Absence();
        absenceToday14.setDate(today);
        absenceToday14.setHeure(LocalTime.of(9, 20).format(timeFormatter));
        absenceToday14.setStatus(Status.RETARD);
        absenceToday14.setJustification("Rendez-vous médical");
        absenceToday14.setEtudiant(e12);
        absenceToday14.setCours(coursToday2);
        absenceRepository.save(absenceToday14);
        
        // Étudiant 12 - PRESENT (second cours)
        Absence absenceToday15 = new Absence();
        absenceToday15.setDate(today);
        absenceToday15.setHeure(LocalTime.of(14, 0).format(timeFormatter));
        absenceToday15.setStatus(Status.PRESENT);
        absenceToday15.setJustification(null);
        absenceToday15.setEtudiant(e12);
        absenceToday15.setCours(coursToday6);
        absenceRepository.save(absenceToday15);
        
        // Étudiant 13 - PRESENT
        Absence absenceToday16 = new Absence();
        absenceToday16.setDate(today);
        absenceToday16.setHeure(LocalTime.of(12, 55).format(timeFormatter));
        absenceToday16.setStatus(Status.PRESENT);
        absenceToday16.setJustification(null);
        absenceToday16.setEtudiant(e13);
        absenceToday16.setCours(coursToday3);
        absenceRepository.save(absenceToday16);
        
        // Étudiant 13 - RETARD (second cours)
        Absence absenceToday17 = new Absence();
        absenceToday17.setDate(today);
        absenceToday17.setHeure(LocalTime.of(16, 15).format(timeFormatter));
        absenceToday17.setStatus(Status.RETARD);
        absenceToday17.setJustification("Transport en commun");
        absenceToday17.setEtudiant(e13);
        absenceToday17.setCours(coursToday7);
        absenceRepository.save(absenceToday17);
        
        // Étudiant 14 - ABSENT
        Absence absenceToday18 = new Absence();
        absenceToday18.setDate(today);
        absenceToday18.setHeure(coursToday4.getHeureDebut());
        absenceToday18.setStatus(Status.ABSENT);
        absenceToday18.setJustification("Maladie");
        absenceToday18.setEtudiant(e14);
        absenceToday18.setCours(coursToday4);
        absenceRepository.save(absenceToday18);
        
        // Étudiant 15 - PRESENT
        Absence absenceToday19 = new Absence();
        absenceToday19.setDate(today);
        absenceToday19.setHeure(LocalTime.of(8, 25).format(timeFormatter));
        absenceToday19.setStatus(Status.PRESENT);
        absenceToday19.setJustification(null);
        absenceToday19.setEtudiant(e15);
        absenceToday19.setCours(coursToday8);
        absenceRepository.save(absenceToday19);
        
        // Des pointages très récents pour aujourd'hui (que l'API premiers devrait renvoyer)
        
        // Étudiant 1 - PRESENT pour son deuxième cours
        Absence absenceToday20 = new Absence();
        absenceToday20.setDate(today);
        absenceToday20.setHeure(LocalTime.of(10, 5).format(timeFormatter));
        absenceToday20.setStatus(Status.PRESENT);
        absenceToday20.setJustification(null);
        absenceToday20.setEtudiant(e1);
        absenceToday20.setCours(coursToday5);
        absenceRepository.save(absenceToday20);
        
        // Étudiant 2 - RETARD pour son deuxième cours
        Absence absenceToday21 = new Absence();
        absenceToday21.setDate(today);
        absenceToday21.setHeure(LocalTime.of(14, 10).format(timeFormatter));
        absenceToday21.setStatus(Status.RETARD);
        absenceToday21.setJustification("Problème de transport");
        absenceToday21.setEtudiant(e2);
        absenceToday21.setCours(coursToday6);
        absenceRepository.save(absenceToday21);
        
        // Étudiant 3 - PRESENT pour son deuxième cours
        Absence absenceToday22 = new Absence();
        absenceToday22.setDate(today);
        absenceToday22.setHeure(LocalTime.of(16, 0).format(timeFormatter));
        absenceToday22.setStatus(Status.PRESENT);
        absenceToday22.setJustification(null);
        absenceToday22.setEtudiant(e3);
        absenceToday22.setCours(coursToday7);
        absenceRepository.save(absenceToday22);
    }
}
