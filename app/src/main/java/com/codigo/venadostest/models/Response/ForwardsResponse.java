package com.codigo.venadostest.models.Response;

import com.codigo.venadostest.models.Data.DataForwards;
import com.google.gson.annotations.SerializedName;

public class ForwardsResponse {

    @SerializedName("data")
    private DataForwards data;

    @SerializedName("success")
    private boolean success;

    public DataForwards getData() {
        return data;
    }

    public void setData(DataForwards data) {
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
        return "ForwardsResponse{" +
                "data=" + data +
                ", success=" + success +
                '}';
    }
}
