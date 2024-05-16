package com.amaap.electionresult.service.io;

import com.amaap.electionresult.AppModule;
import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;
import com.amaap.electionresult.service.ResultDataService;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.amaap.electionresult.service.io.exception.InvalidVoteCountException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static com.amaap.electionresult.domain.model.entity.builder.ResultDataBuilder.getResultData;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileParserServiceTest {
    ResultDataService resultDataService;
    FileParserService fileParserService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        fileParserService = injector.getInstance(FileParserService.class);
        resultDataService = injector.getInstance(ResultDataService.class);
    }

    @Test
    void shouldBeAbleToParseResultDataFromInputLineAndStoreResultDataIntoDatabase() throws InvalidConstituencyNameException, FileNotFoundException, InvalidVoteCountException, InvalidPartyCodeException {
        // arrange
        List<ResultData> expected = getResultData();

        // act
        fileParserService.parseResultData("Bangalore, BJP, 11014, INC, 17803, CPI, 4923, NCP, 2069");
        fileParserService.parseResultData("Pune, INC, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309");
        List<ResultData> actual = resultDataService.getAllResultData();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidConstituencyNameIsPassed() {
        // arrange
        String line = "Pandharpur, BJP, 11014, INC, 17803, CPI, 4923, NCP, 2069";

        // act & assert
        assertThrows(InvalidConstituencyNameException.class, () -> fileParserService.parseResultData(line));
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidPartyCodeIsPassed() {
        // arrange
        String line = "Pune, BJP1, 11014, INC, 17803, CPI, 4923, NCP, 2069";

        // act & assert
        assertThrows(InvalidPartyCodeException.class, () -> fileParserService.parseResultData(line));
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidVoteCountIsPassed() {
        // arrange
        String line = "Pune, BJP, -11014, INC, 17803, CPI, 4923, NCP, 2069";

        // act & assert
        assertThrows(InvalidVoteCountException.class, () -> fileParserService.parseResultData(line));
    }
}