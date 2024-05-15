package com.amaap.electionresult.domain.model.entity;

import com.amaap.electionresult.domain.model.entity.exception.InvalidConstituencyNameException;

import java.util.Map;
import java.util.Objects;

import static com.amaap.electionresult.domain.model.entity.validator.ResultDataValidator.isValidConstituencyName;

public class ResultData {
    private int id;
    private final String constituencyName;
    private final Map<String, Integer> data;

    public ResultData(int id, String constituencyName, Map<String, Integer> data) {
        this.id = id;
        this.constituencyName = constituencyName;
        this.data = data;
    }

    public static ResultData create(int id, String constituencyName, Map<String, Integer> data) throws InvalidConstituencyNameException {
        if(!isValidConstituencyName(constituencyName)) throw new InvalidConstituencyNameException("Invalid constituency Name :"+constituencyName);
        return new ResultData(id,constituencyName,data);
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultData that = (ResultData) o;
        return id == that.id && Objects.equals(constituencyName, that.constituencyName) && Objects.equals(data, that.data);
    }
}
