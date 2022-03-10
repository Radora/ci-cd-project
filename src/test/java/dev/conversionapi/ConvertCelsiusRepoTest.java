package dev.conversionapi;

import dev.conversionapi.repository.ConvertCelsiusRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertCelsiusRepoTest {

    public static final ConvertCelsiusRepo C_TO_F_STRATEGY = new ConvertCelsiusRepo();

    @Test
    public void ConvertCToF (){
        assertEquals(0,32, C_TO_F_STRATEGY.getConvertedValue(0));}
}
