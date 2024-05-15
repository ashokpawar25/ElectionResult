package com.amaap.electionresult.domain.model.entity.builder;

import com.amaap.electionresult.domain.model.entity.ResultData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultDataBuilder {
    public static List<ResultData> getResultData() {
        List<ResultData> resultData = new ArrayList<>();
        Map<String, Integer> data1 = new HashMap<>();
        data1.put("BJP",11014);
        data1.put("INC",17803);
        data1.put("CPI",4923);
        data1.put("NCP",2069);
        resultData.add(new ResultData(1,"Bangalore",data1));
        Map<String, Integer> data2 = new HashMap<>();
        data2.put("INC",9389);
        data2.put("CPI",4829);
        data2.put("BJP",3375);
        data2.put("NCP",3371);
        data2.put("BSP",309);
        resultData.add(new ResultData(2,"Pune",data2));
        return resultData;
    }
}
