package dev.conversionapi.repository;


import dev.conversionapi.model.UnitConversionRequestModel;
import dev.conversionapi.strategy.ConversionStrategy;

public class ConvertFahrenheitRepo implements ConversionStrategy {
    @Override
    public boolean requestIsValid(UnitConversionRequestModel request) {
        if (toTypeIsValid(request.getToType())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean toTypeIsValid(String toType) {
        if (toType.equals("C") || toType.equals("c")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public float getConvertedValue(float fromValue) {
        return ((fromValue - 32.0f) * 5.0f / 9.0f);
    }
}