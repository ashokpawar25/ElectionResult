package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.entity.ResultData;
import com.amaap.electionresult.domain.service.dto.WinnerDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.amaap.electionresult.domain.model.entity.builder.ResultDataBuilder.getResultData;
import static com.amaap.electionresult.domain.service.WinnerEvaluator.getWinner;
import static org.junit.jupiter.api.Assertions.*;

class WinnerEvaluatorTest {

    @Test
    void shouldBeAbleToGetWinnerFromTheResultData()
    {
        // arrange
        List<ResultData> resultData = getResultData();
        WinnerDto winner1 = new WinnerDto("Bangalore","INC",17803,49.0);
        WinnerDto winner2 = new WinnerDto("Pune","INC",9389,44.0);
        List<WinnerDto> expected = List.of(winner1,winner2);

        // act
        List<WinnerDto> actual = getWinner(resultData);

        // assert
        assertEquals(expected,actual);
    }
}