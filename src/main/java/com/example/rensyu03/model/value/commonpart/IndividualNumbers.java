package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.service.validation.ValidationUtility;
import com.example.rensyu03.util.MessageFormatter;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class IndividualNumbers {
    private static final String ERROR_CODE = "10036";
    private static final String FIELD_NAME = "個別部数";
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 10;

    private final int value;

    public IndividualNumbers(@NonNull final String value) {
        final String normalizedValue = value.isEmpty() ? "0" : value;

        ValidationUtility.throwIfNotNumeric(
                normalizedValue,
                MessageFormatter.formatNotNumericMessage(FIELD_NAME),
                ERROR_CODE
        );

        ValidationUtility.throwIfNotInRange(
                normalizedValue,
                MIN_VALUE,
                MAX_VALUE,
                MessageFormatter.formatNotInRangeMessage(FIELD_NAME, MIN_VALUE, MAX_VALUE),
                ERROR_CODE
        );

        this.value = Integer.parseInt(normalizedValue);
    }
}
