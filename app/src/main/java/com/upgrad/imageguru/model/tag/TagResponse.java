package com.upgrad.imageguru.model.tag;

/**
 * Created by rachitgoyal on 6/29/16.
 */
public class TagResponse {
    private int status;
    private TagData data;
    private boolean success;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public TagData getData() {
        return data;
    }

    public void setData(TagData data) {
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
        return "ClassPojo [status = " + status +
                ", data = " + data +
                ", success = " + success +
                "]";
    }
}
