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
            validResponse.setResult(222.2f);
            return validResponse;

        } else {
            ConversionRestResponseModel invalidResponse = new ConversionRestResponseModel(conversionRequest);
            invalidResponse.setValid(false);
            invalidResponse.setResult(0.00f);
            return invalidResponse;
        }
    }

    private boolean requestIsValid(String fromType, String toType) {
        if (valueIsValid(fromType) && valueIsValid(toType)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean valueIsValid(String value) {
        if (value.equals("g") || value.equals("kg") || value.equals("c") || value.equals("f")) {
            return true;
        } else {
            return false;
        }
    }


}


