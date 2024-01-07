package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.service.validation.ValidationUtility;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class TransactionId {
    private static final String ID_NULL_OR_EMPTY_MESSAGE = "Transaction IDは null または空にできません";
    private static final String ID_TOO_LONG_MESSAGE = "Transaction IDは 12 文字を超えることはできません";
    private static final String ERROR_CODE = "10002";
    private static final int MAX_ID_LENGTH = 12;

    private final String value;

    public TransactionId(@NotNull final String value) {
        ValidationUtility.throwIfNullOrEmpty(value, ID_NULL_OR_EMPTY_MESSAGE, ERROR_CODE);
        ValidationUtility.throwIfExceedsMaxLength(value, MAX_ID_LENGTH, ID_TOO_LONG_MESSAGE, ERROR_CODE);

        this.value = value;
    }
}
