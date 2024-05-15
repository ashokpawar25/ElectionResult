package com.amaap.electionresult;

import com.amaap.electionresult.controller.ElectionManagerController;
import com.amaap.electionresult.controller.ResultDataController;
import com.amaap.electionresult.domain.service.dto.WinnerDto;
import com.amaap.electionresult.service.exception.InvalidFilePathException;
import com.amaap.electionresult.service.exception.InvalidInputFileDataException;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidInputFileDataException, InvalidFilePathException {
        Injector injector = Guice.createInjector(new AppModule());
        ElectionManagerController electionManagerController = injector.getInstance(ElectionManagerController.class);
        String filePath = "src/main/java/com/amaap/electionresult/resource/ResultData.txt";
        electionManagerController.readFile(filePath);
        List<WinnerDto> winners = electionManagerController.getWinner();
        System.out.println(electionManagerController.displayWinners(winners));
    }
}
