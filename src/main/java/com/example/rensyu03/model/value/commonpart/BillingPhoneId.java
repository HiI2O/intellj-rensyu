package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.exceptions.InvalidBillingPhoneValueException;
import com.example.rensyu03.util.MessageFormatter;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class BillingPhoneId {
    private static final String FILED_NAME = "課金先電話番号識別子";
    private static final int ID_DIGIT = 1;

    private final String value;

    public BillingPhoneId(@NonNull final String value) {
        validateId(value);
        this.value = value;
    }

    private void validateId(final String value) {
        if (value.length() > ID_DIGIT) {
            throw new InvalidBillingPhoneValueException(
                    MessageFormatter.formatTooShortMessage(FILED_NAME, ID_DIGIT)
            );
        }
    }

    public boolean isEmpty() {
        return this.value.isEmpty();
    }
}
