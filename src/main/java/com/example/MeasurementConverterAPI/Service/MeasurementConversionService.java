package com.example.MeasurementConverterAPI.Service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for performing measurement conversion operations.
 */
@Service
public class MeasurementConversionService {
    private static final Logger logger = LoggerFactory.getLogger(MeasurementConversionService.class);

    /**
     * Converts the input sequence to a list of numbers based on the conversion rules.
     *
     * @param inputSeq The input sequence to be converted.
     * @return The list of converted numbers.
     * @throws IllegalArgumentException if an error occurs during the conversion.
     */
    public List<Integer> convertToNumbers(String inputSeq) {
        logger.debug("Converting input sequence to numbers: {}", inputSeq);

        List<Integer> convIntList = new ArrayList<>();
        boolean isIn_Z_Consecutive = false;
        int zSequenceSum = 0;

        if (inputSeq.startsWith("_")) {
            convIntList.add(getIntValue('_'));
        }

        try {
            for (char c : inputSeq.toCharArray()) {
                if (c != 'z' && !isIn_Z_Consecutive) {
                    convIntList.add(getIntValue(c));
                } else if (c != 'z' && isIn_Z_Consecutive) {
                    zSequenceSum += getIntValue(c);
                    convIntList.add(zSequenceSum);
                    isIn_Z_Consecutive = false;
                    zSequenceSum = 0;
                } else {
                    if (!isIn_Z_Consecutive) {
                        zSequenceSum = 26;
                        isIn_Z_Consecutive = true;
                    } else {
                        zSequenceSum += 26;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error occurred during conversion: {}", e.getMessage());
            throw new IllegalArgumentException("Error occurred during conversion");
        }

        logger.debug("Converted numbers: {}", convIntList);
        return convIntList;
    }

    /**
     * Checks if the input sequence is valid, i.e., it contains only lowercase letters and underscores.
     *
     * @param convIntList The input sequence to be validated.
     * @return true if the input sequence is valid, false otherwise.
     */
    public List<Integer> calculateSums(List<Integer> convIntList) {
        logger.debug("Calculating sums from converted numbers");

        List<Integer> resultList = new ArrayList<>();
        int listIterIndex = 0;

        try {
            while (listIterIndex < convIntList.size()) {
                int packageIndicatorValue = convIntList.get(listIterIndex++);
                int currPackageSum = 0;

                for (int i = 0; i < packageIndicatorValue && listIterIndex < convIntList.size(); i++) {
                    currPackageSum += convIntList.get(listIterIndex++);
                }

                resultList.add(currPackageSum);
            }
        } catch (Exception e) {
            logger.error("Error occurred during calculation: {}", e.getMessage());
            throw new IllegalArgumentException("Error occurred during calculation");
        }

        logger.debug("Calculated sums: {}", resultList);
        return resultList;
    }



    private int getIntValue(char currChar) {
        return currChar == '_' ? 0 : currChar - 'a' + 1;
    }

    /**
     * Checks if the input sequence is valid, i.e., it contains only lowercase letters and underscores.
     *
     * @param inputSeq The input sequence to be validated.
     * @return true if the input sequence is valid, false otherwise.
     */
    public boolean isValidInput(String inputSeq) {
        for (char currentChar : inputSeq.toCharArray()) {
            if (!(currentChar == '_' || Character.isLowerCase(currentChar))) {
                return false;
            }
        }
        return true;
    }
}