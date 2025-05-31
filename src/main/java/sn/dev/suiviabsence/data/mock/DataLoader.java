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
        cours2.setDate("2024-05-26");
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
        a1.setDate("2024-05-25");
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
        
        // Ajouter des cours pour la date actuelle (31 mai 2025)
        String today = LocalDate.now().toString(); // "2025-05-31"
        
        // Cours d'aujourd'hui pour la classe 1
        Cours coursAujourdhui1 = new Cours();
        coursAujourdhui1.setDate(today);
        coursAujourdhui1.setHeureDebut("08:00");
        coursAujourdhui1.setHeureFin("12:00");
        coursAujourdhui1.setModule(module1);
        coursAujourdhui1.setClasse(classe1);
        coursRepository.save(coursAujourdhui1);
        
        // Cours d'aujourd'hui pour la classe 2
        Cours coursAujourdhui2 = new Cours();
        coursAujourdhui2.setDate(today);
        coursAujourdhui2.setHeureDebut("09:00");
        coursAujourdhui2.setHeureFin("11:00");
        coursAujourdhui2.setModule(module2);
        coursAujourdhui2.setClasse(classe2);
        coursRepository.save(coursAujourdhui2);
        
        // Ajouter des absences pour les cours d'aujourd'hui
        // Étudiant 1 absent au cours d'aujourd'hui
        Absence absenceAujourdhui1 = new Absence();
        absenceAujourdhui1.setDate(today);
        absenceAujourdhui1.setHeure(coursAujourdhui1.getHeureDebut());
        absenceAujourdhui1.setStatus(Status.ABSENT);
        absenceAujourdhui1.setJustification(null);
        absenceAujourdhui1.setEtudiant(e1);
        absenceAujourdhui1.setCours(coursAujourdhui1);
        absenceRepository.save(absenceAujourdhui1);
        
        // Étudiant 2 absent au cours d'aujourd'hui
        Absence absenceAujourdhui2 = new Absence();
        absenceAujourdhui2.setDate(today);
        absenceAujourdhui2.setHeure(coursAujourdhui2.getHeureDebut());
        absenceAujourdhui2.setStatus(Status.ABSENT);
        absenceAujourdhui2.setJustification(null);
        absenceAujourdhui2.setEtudiant(e2);
        absenceAujourdhui2.setCours(coursAujourdhui2);
        absenceRepository.save(absenceAujourdhui2);
        
        // Étudiant 3 absent au cours d'aujourd'hui (ajoutez d'autres étudiants si nécessaire)
        Absence absenceAujourdhui3 = new Absence();
        absenceAujourdhui3.setDate(today);
        absenceAujourdhui3.setHeure(coursAujourdhui1.getHeureDebut());
        absenceAujourdhui3.setStatus(Status.ABSENT);
        absenceAujourdhui3.setJustification(null);
        absenceAujourdhui3.setEtudiant(e3);
        absenceAujourdhui3.setCours(coursAujourdhui1);
        absenceRepository.save(absenceAujourdhui3);
    }
}
