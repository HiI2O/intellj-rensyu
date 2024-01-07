package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.service.validation.ValidationUtility;
import com.example.rensyu03.util.MessageFormatter;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class ServiceStartDate {
    private static final String FILED_NAME = "サービス開始日";
    private static final String ERROR_CODE = "10018";
    private static final int MAX_LENGTH = 8;

    private final String value;

    public ServiceStartDate(@NonNull final String value) {
        ValidationUtility.throwIfNullOrEmpty(
                value,
                MessageFormatter.formatNullOrEmptyMessage(FILED_NAME),
                ERROR_CODE
        );

        ValidationUtility.throwIfNotNumeric(
                value,
                MessageFormatter.formatNotNumericMessage(FILED_NAME),
                ERROR_CODE
        );

        ValidationUtility.throwIfExceedsMaxLength(
                value,
                MAX_LENGTH,
                MessageFormatter.formatExceedsMaxLengthMessage(FILED_NAME, MAX_LENGTH),
                ERROR_CODE
        );

        this.value = value;
    }
}
