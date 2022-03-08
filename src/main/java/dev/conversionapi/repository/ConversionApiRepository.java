package dev.conversionapi.repository;


import dev.conversionapi.model.ConversionRest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConversionApiRepository {

    private List<ConversionRest> conversions;

    public ConversionApiRepository() {
        this.conversions = new ArrayList<>();
    }



    public List<ConversionRest> findAll() {
        return conversions;
    }

    /*
        conversionAPI(String fromType, String toType, float fromValue)
     */
}
