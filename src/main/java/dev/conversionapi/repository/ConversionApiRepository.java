package dev.conversionapi.repository;


import dev.conversionapi.model.ConversionRestResponseModel;
import dev.conversionapi.model.UnitConversionRequestModel;
import dev.conversionapi.strategy.ConversionStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConversionApiRepository implements ConversionStrategy {

    // Save history maybe?
    //private List<ConversionRestResponseModel> conversions;

    public ConversionApiRepository() {
        //this.conversions = new ArrayList<>();
    }

    @Override
    public ConversionRestResponseModel convert(UnitConversionRequestModel conversionRequest) {

        if (requestIsValid(conversionRequest.getFromType(), conversionRequest.getToType())) {

            ConversionRestResponseModel validResponse = new ConversionRestResponseModel(conversionRequest);
            validResponse.setValid(true);
            validResponse.setResult(convert(conversionRequest.getFromType(), conversionRequest.getToType(), conversionRequest.getFromValue()));
            return validResponse;

        } else {
            ConversionRestResponseModel invalidResponse = new ConversionRestResponseModel(conversionRequest);
            invalidResponse.setValid(false);
            invalidResponse.setResult(0.00f);
            return invalidResponse;
        }
    }

    private float convert(String fromType, String toType, float fromValue) {
        float result = 0;
        // Extend with different toTypes ?
        if (fromType.equals("g")) {
            result = convertGramToKilogram(fromValue);
        } else if (fromType.equals("kg")) {
            result = convertKilogramToGram(fromValue);
        } else if (fromType.equals("c")) {
            result = convertCelsiusToFahrenheit(fromValue);
        } else if (fromType.equals("f")) {
            result = convertFahrenheitToCelsius(fromValue);
        }

        return result;
    }

    private float convertFahrenheitToCelsius(float fromValue) {
        return (fromValue - 32) * 5 / 9;
    }


    private float convertCelsiusToFahrenheit(float fromValue) {
        return fromValue * 9 / 5 + 32;
    }

    private float convertKilogramToGram(float fromValue) {
        return fromValue * 1000;
    }

    private float convertGramToKilogram(float fromValue) {
        return fromValue / 1000;
    }

    private boolean requestIsValid(String fromType, String toType) {
        if (valueIsValid(fromType) && valueIsValid(toType)) {
            if (valuesAreConvertable(fromType, toType)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean valuesAreConvertable(String fromType, String toType) {
        if (fromType.equals("kg") && toType.equals("g")) {
            return true;
        } else if (fromType.equals("g") && toType.equals("kg")) {
            return true;
        } else if (fromType.equals("c") && toType.equals("f")) {
            return true;
        } else if (fromType.equals("f") && toType.equals("c")) {
            return true;
        }
        return false;
    }

    private boolean valueIsValid(String value) {
        if (value.equals("g") || value.equals("kg") || value.equals("c") || value.equals("f")) {
            return true;
        } else {
            return false;
        }
    }


}


