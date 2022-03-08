package dev.conversionapi.controller;

import dev.conversionapi.model.ConversionRest;
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

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConversionRest> createNewConversion(@RequestBody UnitConversionRequestModel unitConversionRequest) {

        ConversionRest returnValue = new ConversionRest(unitConversionRequest.getFromType(), unitConversionRequest.getToType(), unitConversionRequest.getFromValue());

        return new ResponseEntity<ConversionRest>(returnValue, HttpStatus.OK);
    }

}
