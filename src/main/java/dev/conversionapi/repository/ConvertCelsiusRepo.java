package dev.conversionapi.repository;

import dev.conversionapi.model.ConversionRestResponseModel;
import dev.conversionapi.model.UnitConversionRequestModel;
import dev.conversionapi.strategy.ConversionStrategy;

public class ConvertCelsiusRepo implements ConversionStrategy {
    @Override
    public boolean requestIsValid(UnitConversionRequestModel request) {
        if (toTypeIsValid(request.getToType())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean toTypeIsValid(String toType) {
        if (toType.equals("F") || toType.equals("f")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public float getConvertedValue(float fromValue) {
        return fromValue * 9 / 5 + 32;
    }
}
