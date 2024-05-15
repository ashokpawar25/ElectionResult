package com.amaap.electionresult.controller;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.service.dto.WinnerDto;
import com.amaap.electionresult.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.electionresult.repository.impl.InMemoryResultDataRepository;
import com.amaap.electionresult.service.ElectionManagerService;
import com.amaap.electionresult.service.ResultDataService;
import com.amaap.electionresult.service.exception.InvalidFilePathException;
import com.amaap.electionresult.service.exception.InvalidInputFileDataException;
import com.amaap.electionresult.service.io.FileParserService;
import com.amaap.electionresult.service.io.FileReaderService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.amaap.electionresult.domain.model.entity.builder.ResultDataBuilder.getResultData;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionManagerControllerTest {

    ResultDataService resultDataService = new ResultDataService(new InMemoryResultDataRepository(new FakeInMemoryDatabase()));
    FileParserService fileParserService = new FileParserService(resultDataService);
    FileReaderService fileReaderService = new FileReaderService(fileParserService);
    ElectionManagerService electionManagerService = new ElectionManagerService(fileReaderService,resultDataService);
    ElectionManagerController electionManagerController = new ElectionManagerController(electionManagerService);

    @Test
    void shouldBeAbleToReadFileAndStoreResultDataIntoDatabase() throws InvalidFilePathException, InvalidInputFileDataException {
        // arrange
        List<ResultData> expected = getResultData();
        String filePath = "src/main/java/com/amaap/electionresult/resource/ResultData.txt";

        // act
        electionManagerController.readFile(filePath);
        List<ResultData> actual = resultDataService.getAllResultData();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToProcessDataAndGetWinnerOfConstituency() throws InvalidInputFileDataException, InvalidFilePathException {
        // arrange
        String filePath = "src/main/java/com/amaap/electionresult/resource/ResultData.txt";
        WinnerDto winner1 = new WinnerDto("Bangalore","INC",17803,49.0);
        WinnerDto winner2 = new WinnerDto("Pune","INC",9389,44.0);
        List<WinnerDto> expected = List.of(winner1,winner2);

        // act
        electionManagerController.readFile(filePath);
        List<WinnerDto> actual = electionManagerController.getWinner();

        // assert
        assertEquals(expected,actual);
    }
}
