package service;
import com.tracking.number.tracking.number.service.TrackingNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(TrackingNumberService.class)
public class TrackingNumberServiceTest {

    @Autowired
    private TrackingNumberService generatorService;

    @Test
    public void testUniqueTrackingNumbers() {
        String trackingNumber1 = generatorService.generateTrackingNumber();
        String trackingNumber2 = generatorService.generateTrackingNumber();
        assertNotEquals(trackingNumber1, trackingNumber2);
    }

    @Test
    public void testGenerateMultipleTrackingNumbers() {
        long count = 1000;
        List<String> trackingNumbers = generatorService.generateMultipleTrackingNumbers((int) count).collect(Collectors.toList());

        assertEquals(count, trackingNumbers.size());
        assertEquals(count, trackingNumbers.stream().distinct().count());
    }
}
