package com.amaap.electionresult.service.io;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.service.ResultDataService;
import com.amaap.electionresult.service.exception.InvalidFilePathException;
import com.amaap.electionresult.service.exception.InvalidInputFileDataException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.amaap.electionresult.domain.model.entity.builder.ResultDataBuilder.getResultData;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderServiceTest {
    ResultDataService resultDataService;
    FileReaderService fileReaderService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        resultDataService = injector.getInstance(ResultDataService.class);
        fileReaderService = injector.getInstance(FileReaderService.class);
    }

    @Test
    void shouldBeAbleToReadFileAndStoreResultDataIntoDatabase() throws InvalidFilePathException, InvalidInputFileDataException {
        // arrange
        List<ResultData> expected = getResultData();
        String filePath = "src/main/java/com/amaap/electionresult/resource/ResultData.txt";

        // act
        fileReaderService.readFile(filePath);
        List<ResultData> actual = resultDataService.getAllResultData();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidFilePathIsPassed() {
        // arrange
        String filePath = "src/main/java/com/amaap/electionresult/resource/Unavailable.txt";

        // act & assert
        assertThrows(RuntimeException.class, () -> fileReaderService.readFile(filePath));
    }

}