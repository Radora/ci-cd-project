package dev.conversionapi.repository;


import dev.conversionapi.model.ConversionRestResponseModel;
import dev.conversionapi.model.InvalidRequestResponseModel;
import dev.conversionapi.model.UnitConversionRequestModel;
import dev.conversionapi.strategy.ConversionStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ConversionApiRepository {

    public ConversionApiRepository() {
    }

    public ConversionRestResponseModel readRequest(UnitConversionRequestModel request) {

        ConversionStrategy converter;

        switch (request.getFromType()) {
            case "g":
            case "G":
                converter = new ConvertGramRepo();
                break;
            case "kg":
            case "KG":
            case "Kg":
            case "kG":
                converter = new ConvertKilogramRepo();
                break;
            case "c":
            case "C":
                converter = new ConvertCelsiusRepo();
                break;
            case "f":
            case "F":
                converter = new ConvertFahrenheitRepo();
                break;
            default:
                return new InvalidRequestResponseModel(request);
        }

        if (converter.requestIsValid(request)) {
            float result = converter.getConvertedValue(request.getFromValue());
            ConversionRestResponseModel response = new ConversionRestResponseModel(request);
            response.setValid(true);
            response.setResult(result);
            return response;

        } else {
            return new InvalidRequestResponseModel(request);
        }
    }

}


