package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.service.validation.ValidationUtility;
import com.example.rensyu03.util.MessageFormatter;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class ProductSubscriptionCategory {
    private static final String ERROR_CODE = "10016";
    private static final String FIELD_NAME = "商品申込区分";
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 7;
    private final String value;

    public ProductSubscriptionCategory(@NonNull final String value) {
        validateSubscriptionCategory(value);

        this.value = value;
    }

    private void validateSubscriptionCategory(final String value) {
        ValidationUtility.throwIfNullOrEmpty(
                value,
                MessageFormatter.formatNullOrEmptyMessage(FIELD_NAME),
                ERROR_CODE
        );

        ValidationUtility.throwIfNotNumeric(
                value,
                MessageFormatter.formatNotNumericMessage(FIELD_NAME),
                ERROR_CODE
        );

        ValidationUtility.throwIfNotInRange(
                value,
                MIN_VALUE,
                MAX_VALUE,
                MessageFormatter.formatNotInRangeMessage(FIELD_NAME, MIN_VALUE, MAX_VALUE),
                ERROR_CODE
        );
    }

    public boolean isValue6or7() {
        return value.equals("6") || value.equals("7");
    }
}
