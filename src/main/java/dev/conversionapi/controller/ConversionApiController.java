package dev.conversionapi.controller;

import dev.conversionapi.model.ConversionAPI;
import dev.conversionapi.repository.ConversionApiRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/convert")
public class ConversionApiController {

    private final ConversionApiRepository repository;

    public ConversionApiController(ConversionApiRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ConversionAPI> findAll() {
        return repository.findAll();
    }
}
