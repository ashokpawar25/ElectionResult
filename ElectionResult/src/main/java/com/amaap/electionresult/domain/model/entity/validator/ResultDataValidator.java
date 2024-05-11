package com.amaap.electionresult.domain.model.entity.validator;

public class ResultDataValidator {

    public static boolean isValidConstituencyName(String constituencyName) {
        return constituencyName != null && !constituencyName.isEmpty() && constituencyName.matches("^[a-zA-Z]{3,}$");
    }
}
