package com.example.MeasurementConverterAPI.Controller;

import com.example.MeasurementConverterAPI.Model.ConversionResponse;
import com.example.MeasurementConverterAPI.Service.MeasurementConversionService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for handling measurement conversion requests.
 */
@Validated
@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"*", "Authorization", "Content-Type"})
public class MeasurementConversionController {

    private final MeasurementConversionService conversionService;

    @Autowired
    public MeasurementConversionController(MeasurementConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * Endpoint for converting a measurement input to a list of numbers.
     *
     * @param inputSeq The measurement input sequence.
     * @return ResponseEntity containing the conversion response.
     */
    @GetMapping("/convert-measurements")
    public ResponseEntity<ConversionResponse> convert(@RequestParam("input") @Pattern(regexp = "^[a-z_]+$", message = "Invalid input! Please enter a string with lowercase letters and underscores only.") String inputSeq) {
        List<Integer> convertedList = conversionService.convertToNumbers(inputSeq);
        List<Integer> resultList = conversionService.calculateSums(convertedList);
        ConversionResponse response = new ConversionResponse(inputSeq, resultList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
