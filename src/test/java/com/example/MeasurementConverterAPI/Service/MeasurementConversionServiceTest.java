package com.example.MeasurementConverterAPI.Service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MeasurementConversionServiceTest {

//    @Mock
//    private SomeDependency someDependency;

    @InjectMocks
    private MeasurementConversionService measurementConversionService;

    @Before
    public void setUp() {
        // Perform any setup or stubbing required for the tests
    }

    @Test
    public void testConvertToNumbers() {
        // Arrange
        String inputSeq = "ac";
        List<Integer> expectedNumbers = List.of(1, 3);

        // Act
        List<Integer> actualNumbers = measurementConversionService.convertToNumbers(inputSeq);

        // Assert
        assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    public void testConvertToNumbers2() {
        // Arrange
        String inputSeq = "abbcc";
        List<Integer> expectedNumbers = List.of(1, 2, 2, 3, 3);

        // Act
        List<Integer> actualNumbers = measurementConversionService.convertToNumbers(inputSeq);

        // Assert
        assertEquals(expectedNumbers, actualNumbers);
    }
    @Test
    public void testCalculateSums() {
        // Arrange
        List<Integer> convIntList = List.of(1,3);
        List<Integer> expectedSums = List.of(3);

        // Act
        List<Integer> actualSums = measurementConversionService.calculateSums(convIntList);

        // Assert
        assertEquals(expectedSums, actualSums);
    }

    // Add more test methods for different scenarios

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSums_InvalidInput() {
        // Arrange
        List<Integer> convIntList = List.of(1, 3, 5);

        // Act
        measurementConversionService.calculateSums(convIntList);

        // Assert
        // Expecting IllegalArgumentException to be thrown
    }
}
