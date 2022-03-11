package dev.conversionapi;

import dev.conversionapi.repository.ConvertFahrenheitRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertFahrenheitRepoTest {

    public static final ConvertFahrenheitRepo F_TO_C_STRATEGY = new ConvertFahrenheitRepo();

    @Test

    public void ConvertFToC(){
        float result = F_TO_C_STRATEGY.getConvertedValue(41);
        assertEquals(5,result );
        //assertEquals(5,41, F_TO_C_STRATEGY.getConvertedValue(41));

    }

}
// 5 C = 41 F (fromValue)