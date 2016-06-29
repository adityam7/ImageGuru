package com.upgrad.imageguru.model;

public class GalleryResponse {
    private String status;

    private Data data;

    private boolean success;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "GalleryResponse [status = " + status +
                ", data = " + data +
                ", success = " + success +
                "]";
    }
}
