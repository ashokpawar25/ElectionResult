package com.amaap.electionresult.domain.model.valueobject;

public enum Party {
    BJP("Bhartiya Janta Party"),
    INC("Indian National Congress"),
    BSP("Bahujan Samaj Party"),
    CPI("Communist Party of India"),
    NCP("Nationalist Congress Party"),
    IND("Independent"),
    AAP("Aam Adami Party");

    private final String fullName;

    Party(String fullName) {
        this.fullName = fullName;
    }

    public static String getFullName(String code) {
        for (Party party : values()) {
            if (party.name().equalsIgnoreCase(code)) {
                return party.getFullName();
            }
        }
        return "Invalid";
    }

    public String getFullName() {
        return fullName;
    }
}
