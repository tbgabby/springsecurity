package com.tb.directoryapp.enumeration;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Oyebanji Gabriel
 *
 * Here, a Map has been added to cache "Types-of-Role" for faster lookup.
 */
public enum RoleType {

    PORTAL_USER("PORTAL USER"),
    RESELLER_AFFILIATES("RESELLER_AFFILIATES"),
    AGENT("AGENT"),
    ADMINISTRATOR("ADMINISTRATOR"),
    DATAENTRY("DATAENTRY"),
    FINANCE_OFFICER("FINANCE_OFFICER"),
    VISA_DEPARTMENT("VISA_DEPARTMENT"),
    SUPER_ADMIN("SUPER_ADMIN"),
    RESELLER_TRAVEL_CONSULTANTS("RESELLER_TRAVEL_CONSULTANTS"),
    PRICING_OFFICER("PRICING_OFFICER"),
    TRAVEL_CONSULTANT_SUPERVISOR("TRAVEL CONSULTANT SUPERVISOR"),
    ONLINE_REQUEST_TRAVEL_CONSULTANT("ONLINE REQUEST TRAVEL CONSULTANT"),
    CUSTOMER_SUPPORT("CUSTOMER SUPPORT"),
    TRAVELBETA_MANAGEMENT("TRAVELBETA_MANAGEMENT"),
    AFFLIATE_OFFICER("AFFLIATE OFFICER"),
    TICKETING_OFFICER("TICKETING OFFICER");
    private static final Map<String, RoleType> NAME = new HashMap<>();


    static {
        for (RoleType type : values()) {
            NAME.put(type.name, type);
         }
    }

    @Getter
    private final String name;

    RoleType(String name) {
        this.name = name;
    }

    public static RoleType valueOfName(String name) {
        return NAME.get(name);
    }

    @Override
    public String toString() {
        return this.name;
    }

}

//////////////////////////////////////////////////////////////////////////////
//    @Getter
//    private String name;
//
//    private RoleName(String name) {
//      this.name = name;
//    }
//
//    public static RoleName getRoleName(String name) {
//        return Stream.of(RoleType.values()).filter(roleType ->
//                roleType.getName().equalsIgnoreCase(name)
//        ).findFirst().get();
//    }
//
//////////////////////////////////////////////////////////////////////////////