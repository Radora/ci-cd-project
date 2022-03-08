package dev.conversionapi.repository;


import dev.conversionapi.model.ConversionAPI;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConversionApiRepository {

    List<ConversionAPI> conversions = new ArrayList<>();


    public ConversionApiRepository(){
        conversions.add(
                new ConversionAPI("kg","g",13.43f)
        );
    }

    public List<ConversionAPI> findAll(){
        return conversions;
    }

    /*
    onversionAPI(String fromType, String toType, float fromValue)
     */
}
