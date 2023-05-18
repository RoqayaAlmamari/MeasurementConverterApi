package com.example.MeasurementConverterAPI.Model;

import java.util.List;

/**
 * Represents the response for a measurement conversion request.
 */
public class ConversionResponse {

    private String input;
    private List<Integer> output;

    public ConversionResponse(String input, List<Integer> output) {
        this.input = input;
        this.output = output;
    }

    /**
     * Retrieves the input sequence for the measurement conversion.
     *
     * @return The input sequence.
     */
    public String getInput() {
        return input;
    }

    /**
     * Retrieves the output list of numbers resulting from the measurement conversion.
     *
     * @return The output list of numbers.
     */
    public List<Integer> getOutput() {
        return output;
    }
}
