package dev.conversionapi.controller;

import dev.conversionapi.model.ConversionRestResponseModel;
import dev.conversionapi.model.UnitConversionRequestModel;
import dev.conversionapi.repository.ConversionApiRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/convert")
public class ConversionApiController {

    private final ConversionApiRepository repository;

    public ConversionApiController(ConversionApiRepository repository) {
        this.repository = repository;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<ConversionRestResponseModel> createNewConversion(@RequestBody UnitConversionRequestModel unitConversionRequest) {

        ConversionRestResponseModel response  = repository.readRequest(unitConversionRequest);

        if (response.isValid()){
            return new ResponseEntity<ConversionRestResponseModel>(response, HttpStatus.OK);

        }else {
            return new ResponseEntity<ConversionRestResponseModel>(response, HttpStatus.BAD_REQUEST);
        }

    }

}
