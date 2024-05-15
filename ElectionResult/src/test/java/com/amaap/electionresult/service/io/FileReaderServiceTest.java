package com.amaap.electionresult.service.io;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.electionresult.repository.impl.InMemoryResultDataRepository;
import com.amaap.electionresult.service.ElectionManagerService;
import com.amaap.electionresult.service.ResultDataService;
import com.amaap.electionresult.service.exception.InvalidFilePathException;
import com.amaap.electionresult.service.exception.InvalidInputFileDataException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.amaap.electionresult.domain.model.entity.builder.ResultDataBuilder.getResultData;
import static org.junit.jupiter.api.Assertions.*;

class FileReaderServiceTest {
    ResultDataService resultDataService = new ResultDataService(new InMemoryResultDataRepository(new FakeInMemoryDatabase()));
    FileParserService fileParserService = new FileParserService(resultDataService);
    FileReaderService fileReaderService = new FileReaderService(fileParserService);

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
    void shouldBeAbleToThrowExceptionWhenInvalidFilePathIsPassed()
    {
        // arrange
        String filePath = "src/main/java/com/amaap/electionresult/resource/Unavailable.txt";

        // act & assert
        assertThrows(RuntimeException.class,()->fileReaderService.readFile(filePath));
    }

}