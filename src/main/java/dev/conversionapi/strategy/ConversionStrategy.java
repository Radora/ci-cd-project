package dev.conversionapi.strategy;

import dev.conversionapi.model.ConversionRestResponseModel;
import dev.conversionapi.model.UnitConversionRequestModel;

public interface ConversionStrategy {

    ConversionRestResponseModel convert(UnitConversionRequestModel conversionRequest);

}
