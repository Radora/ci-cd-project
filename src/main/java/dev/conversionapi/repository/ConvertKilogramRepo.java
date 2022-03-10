package dev.conversionapi.repository;

import dev.conversionapi.model.ConversionRestResponseModel;
import dev.conversionapi.model.UnitConversionRequestModel;
import dev.conversionapi.strategy.ConversionStrategy;

public class ConvertKilogramRepo implements ConversionStrategy {
    @Override
    public boolean requestIsValid(UnitConversionRequestModel request) {
        if (toTypeIsValid(request.getToType())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean toTypeIsValid(String toType) {
        if (toType.equals("g") || toType.equals("G")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public float getConvertedValue(float value) {
        return value * 1000;
    }
}