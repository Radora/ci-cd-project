package dev.conversionapi.model;

public class ConversionAPI {

    private boolean valid;
    private String fromType;
    private String toType;
    private float fromValue;
    private float result;


    public ConversionAPI() {
    }

    public ConversionAPI(String fromType, String toType, float fromValue) {
        this.fromType = fromType;
        this.toType = toType;
        this.fromValue = fromValue;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setResult(float result){
        this.result = result;
    }
}
