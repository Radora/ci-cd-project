package dev.conversionapi.strategy;

import dev.conversionapi.model.ConversionRestResponseModel;
import dev.conversionapi.model.UnitConversionRequestModel;

public interface ConversionStrategy {

    boolean requestIsValid(UnitConversionRequestModel conversionRequest);

    boolean toTypeIsValid(String toType);

    float getConvertedValue(float value);

}
