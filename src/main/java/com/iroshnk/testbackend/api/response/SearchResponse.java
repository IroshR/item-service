package com.iroshnk.testbackend.api.response;

import com.iroshnk.testbackend.util.Status;

import java.util.List;

public class SearchResponse {
    private int status = Status.RESPONSE_STATUS_FAIL;
    private String message;
    private List data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
