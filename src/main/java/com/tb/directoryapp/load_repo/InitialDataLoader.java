//package com.tb.directoryapp.loadDatabase;
//
//
//import com.tb.directoryapp.enumeration.RoleType;
//import com.tb.directoryapp.model.Role;
//import com.tb.directoryapp.model.Travelbetadmin;
//import com.tb.directoryapp.repositories.RoleRepository;
//import com.tb.directoryapp.repositories.TravelbetadminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import javax.transaction.Transactional;
//
//
//@Component
//public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
//
//    private boolean alreadySetup = false;
//
//    private TravelbetadminRepository travelbetadminRepository;
//    private RoleRepository roleRepository;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public InitialDataLoader(TravelbetadminRepository travelbetadminRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        this.travelbetadminRepository = travelbetadminRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        if (alreadySetup)
//            return;
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////   METHOD 1: Load 'RoleTypes' into "Role" DB /////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////
////        Role ADMINISTRATOR = new Role(RoleType.ADMINISTRATOR);
////        Role AGENT = new Role(RoleType.AGENT);
////        Role DATAENTRY = new Role(RoleType.DATAENTRY);
////        Role FINANCE_OFFICER = new Role(RoleType.FINANCE_OFFICER);
////        Role VISA_DEPARTMENT = new Role(RoleType.VISA_DEPARTMENT);
////        Role SUPER_ADMIN = new Role(RoleType.SUPER_ADMIN);
////        Role PORTAL_USER = new Role(RoleType.PORTAL_USER);
////        Role RESELLER_AFFILIATES = new Role(RoleType.RESELLER_AFFILIATES);
////        Role RESELLER_TRAVEL_CONSULTANTS = new Role(RoleType.RESELLER_TRAVEL_CONSULTANTS);
////        Role PRICING_OFFICER = new Role(RoleType.PRICING_OFFICER);
////        Role ONLINE_REQUEST_TRAVEL_CONSULTANT = new Role(RoleType.ONLINE_REQUEST_TRAVEL_CONSULTANT);
////        Role TRAVEL_CONSULTANT_SUPERVISOR = new Role(RoleType.TRAVEL_CONSULTANT_SUPERVISOR);
////        Role CUSTOMER_SUPPORT = new Role(RoleType.CUSTOMER_SUPPORT);
////        Role TRAVELBETA_MANAGEMENT = new Role(RoleType.TRAVELBETA_MANAGEMENT);
////        Role AFFLIATE_OFFICER = new Role(RoleType.AFFLIATE_OFFICER);
////        Role TICKETING_OFFICER = new Role(RoleType.TICKETING_OFFICER);
////
////        roleRepository.save(ADMINISTRATOR);
////        roleRepository.save(AGENT);
////        roleRepository.save(DATAENTRY);
////        roleRepository.save(FINANCE_OFFICER);
////        roleRepository.save(VISA_DEPARTMENT);
////        roleRepository.save(SUPER_ADMIN);
////        roleRepository.save(PORTAL_USER);
////        roleRepository.save(RESELLER_AFFILIATES);
////        roleRepository.save(RESELLER_TRAVEL_CONSULTANTS);
////        roleRepository.save(PRICING_OFFICER);
////        roleRepository.save(ONLINE_REQUEST_TRAVEL_CONSULTANT);
////        roleRepository.save(TRAVEL_CONSULTANT_SUPERVISOR);
////        roleRepository.save(CUSTOMER_SUPPORT);
////        roleRepository.save(TRAVELBETA_MANAGEMENT);
////        roleRepository.save(AFFLIATE_OFFICER);
////        roleRepository.save(TICKETING_OFFICER);
////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////   METHOD 2: Search "Role" DB for RoleType in argument passed ////////////////////////////////////////////////////////
////  if Found, set RoleType as 'Role' for "Tbsuperadmin" user-account below. ////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    Role SUPER_ADMIN = roleRepository.getRoleByName(RoleType.SUPER_ADMIN.getName());
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    Travelbetadmin superAdmin = new Travelbetadmin();
//        superAdmin.setTitle("Engr.");
//        superAdmin.setFirstname("Gabriel");
//        superAdmin.setLastname("Oyebanji");
//        superAdmin.setGender("MALE");
//        superAdmin.setPhoneNumber(Long.valueOf("07038662402"));
//        superAdmin.setUsername("gabby");
//        superAdmin.setEmail("igabriel.oyebanji@travelbeta.com");
//        superAdmin.setPassword(passwordEncoder.encode("london"));
//        superAdmin.setPasswordHashAlgorithm("Bcrypt");
//        superAdmin.setPasswordSalt(passwordEncoder.encode("london"));
//        superAdmin.setDateOfBirth(superAdmin.getDateOfBirth());
//        superAdmin.setDateCreated(superAdmin.getDateCreated());
//        superAdmin.setLastUpdate(superAdmin.getLastUpdate());
//        superAdmin.setStatus("ACTIVATED");
//        superAdmin.setPasswordReset(false);
//        superAdmin.setEnabled(true);
//        superAdmin.setRole(SUPER_ADMIN);
//    travelbetadminRepository.save(superAdmin);
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//        alreadySetup = true;
//
//    }
//}
