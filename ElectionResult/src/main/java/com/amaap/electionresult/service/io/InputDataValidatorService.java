package com.amaap.electionresult.service.io;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class InputDataValidatorService {
    public static boolean validatePartyCode(String partyCode) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/com/amaap/electionresult/config/ValidData.yml");
        Map<String, List<String>> validData = yaml.load(fileInputStream);
        List<String> PartyCodes = validData.get("PartyCodes");
        return PartyCodes.contains(partyCode);
    }

    public static boolean validateConstituencyName(String constituencyName) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/com/amaap/electionresult/config/ValidData.yml");
        Map<String, List<String>> validData = yaml.load(fileInputStream);
        List<String> constituencies = validData.get("Constituencies");
        return constituencies.contains(constituencyName);
    }
}
