package com.amaap.electionresult.domain.model.entity.validator;

public class ResultDataValidator {

    public static boolean isInvalidConstituencyName(String constituencyName) {
        return constituencyName == null || constituencyName.isEmpty() || !constituencyName.matches("^\\w+$");
    }
}
