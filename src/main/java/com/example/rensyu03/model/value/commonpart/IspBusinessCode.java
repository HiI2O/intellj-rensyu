package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.service.validation.ValidationUtility;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class IspBusinessCode {
    private static final String ERROR_CODE = "10011";
    private static final String IS_NULL_OR_EMPTY_MESSAGE = "ISP事業者コードはnullまたは空にできません。";
    private static final String EXCEEDS_MAX_LENGTH_MESSAGE = "ISP事業者コードは5桁以下です。";
    private static final int MAX_LENGTH = 5;
    private final String value;

    public IspBusinessCode(@NonNull final String value) {
        ValidationUtility.throwIfNullOrEmpty(value, IS_NULL_OR_EMPTY_MESSAGE, ERROR_CODE);
        ValidationUtility.throwIfExceedsMaxLength(value, MAX_LENGTH, EXCEEDS_MAX_LENGTH_MESSAGE, ERROR_CODE);
        this.value = value;
    }
}
