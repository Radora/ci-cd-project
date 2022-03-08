package dev.conversionapi.model;

public class ConversionRest {

    private boolean valid;
    private String fromType;
    private String toType;
    private float fromValue;
    private float result;


    public ConversionRest() {
    }

    public ConversionRest(String fromType, String toType, float fromValue) {
        this.fromType = fromType;
        this.toType = toType;
        this.fromValue = fromValue;
        this.valid = true;
        this.result = 0.993f;
        // logic?
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getToType() {
        return toType;
    }

    public void setToType(String toType) {
        this.toType = toType;
    }

    public float getFromValue() {
        return fromValue;
    }

    public void setFromValue(float fromValue) {
        this.fromValue = fromValue;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}

