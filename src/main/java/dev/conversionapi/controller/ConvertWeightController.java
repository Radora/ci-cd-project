package dev.conversionapi.controller;

import dev.conversionapi.repository.ConvertWeightRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/convert")
public class ConvertWeightController {

    private final ConvertWeightRepository repository;

    public ConvertWeightController(ConvertWeightRepository repository) {
        this.repository = repository;
    }

    /*
    private boolean valid;
    private float result;
    private float fromValue;
    private String fromType;
    private String toType;
     */
}
