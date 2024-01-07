package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.service.validation.ValidationUtility;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class TransactionType {
    private static final String ILLEGAL_VALUE_ERROR_MESSAGE = "トランザクション種別は11のみ指定可能です。";
    private static final String ERROR_CODE = "10003";
    private static final String EXPECTED_VALUE = "11";

    private final String value;

    public TransactionType(@NonNull final String value) {
        ValidationUtility.throwIfNotEquals(
                value,
                EXPECTED_VALUE,
                ILLEGAL_VALUE_ERROR_MESSAGE,
                ERROR_CODE
        );

        this.value = value;
    }

}
