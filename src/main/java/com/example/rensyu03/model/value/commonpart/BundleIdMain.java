package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.service.validation.ValidationUtility;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class BundleIdMain {
    private static final String ERROR_CODE = "10012";
    private static final String IS_NULL_OR_EMPTY_MESSAGE = "バンドルID（メイン）はnullまたは空にできません。";
    private static final String EXCEEDS_MAX_LENGTH_MESSAGE = "バンドルID（メイン）は16桁以下です。";
    private static final int MAX_LENGTH = 16;

    private final String value;

    public BundleIdMain(@NonNull final String value) {
        validateBundleIdMain(value);
        this.value = value;
    }

    private void validateBundleIdMain(final String value) {
        ValidationUtility.throwIfNullOrEmpty(value, IS_NULL_OR_EMPTY_MESSAGE, ERROR_CODE);
        ValidationUtility.throwIfExceedsMaxLength(value, MAX_LENGTH, EXCEEDS_MAX_LENGTH_MESSAGE, ERROR_CODE);
    }


}
