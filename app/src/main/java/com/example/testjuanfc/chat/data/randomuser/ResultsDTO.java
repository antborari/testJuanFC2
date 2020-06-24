package com.example.testjuanfc.chat.data.randomuser;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsDTO {

    @SerializedName("results")
    private List<UserDTO> results;

    public ResultsDTO(List<UserDTO> results) {
        this.results = results;
    }

    public List<UserDTO> getResults() {
        return results;
    }

    public void setResults(List<UserDTO> results) {
        this.results = results;
    }
}
