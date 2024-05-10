package com.amaap.electionresult.domain.model.entity;

import java.util.Map;
import java.util.Objects;

public class ResultData {
    private final int id;
    private final String constituencyName;
    private final Map<String, Integer> data;

    public ResultData(int id, String constituencyName, Map<String, Integer> data) {
        this.id = id;
        this.constituencyName = constituencyName;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultData that = (ResultData) o;
        return id == that.id && Objects.equals(constituencyName, that.constituencyName) && Objects.equals(data, that.data);
    }

}
