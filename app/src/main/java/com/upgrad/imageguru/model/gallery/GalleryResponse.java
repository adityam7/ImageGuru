package com.upgrad.imageguru.model.gallery;

public class GalleryResponse {
    private String status;
    private GalleryData data;
    private boolean success;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GalleryData getData() {
        return data;
    }

    public void setData(GalleryData data) {
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
