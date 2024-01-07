package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.exceptions.InvalidBillingPhoneValueException;
import com.example.rensyu03.util.MessageFormatter;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class BillingPhoneNumber {
    private static final String FIELD_NAME = "課金先電話番号";
    private static final int NUMBER_MAX_LENGTH = 255;
    private final String value;

    public BillingPhoneNumber(@NonNull final String value) {
        validateNumber(value);
        this.value = value;
    }

    private void validateNumber(final String value) {
        if (value.length() > NUMBER_MAX_LENGTH) {
            throw new InvalidBillingPhoneValueException(
                    MessageFormatter.formatExceedsMaxLengthMessage(FIELD_NAME, NUMBER_MAX_LENGTH)
            );
        }
    }

    public boolean isValueEmpty() {
        return this.value.isEmpty();
    }
}