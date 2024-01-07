package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.exceptions.InvalidValueException;
import com.example.rensyu03.service.validation.ValidationUtility;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class CustomerTaxCategory {
    private static final String ERROR_CODE = "10015";
    private static final String IS_NULL_OR_EMPTY_MESSAGE = "バンドルID（メイン）はnullまたは空にできません。";
    private static final String IS_NOT_NUMERIC_MESSAGE = "顧客課税区分は半角数値でないといけません。";
    private static final String INVALID_TAX_CATEGORY_MESSAGE = "顧客課税区分は1または3でないといけません。";
    private static final String TAX_CATEGORY_ONE = "1";
    private static final String TAX_CATEGORY_THREE = "3";

    private final String value;

    public CustomerTaxCategory(@NonNull final String value) {
        ValidationUtility.throwIfNullOrEmpty(value, IS_NULL_OR_EMPTY_MESSAGE, ERROR_CODE);
        ValidationUtility.throwIfNotNumeric(value, IS_NOT_NUMERIC_MESSAGE, ERROR_CODE);

        validateTaxCategory(value);

        this.value = value;
    }

    private void validateTaxCategory(final String value) {
        boolean isValidTaxCategory = TAX_CATEGORY_ONE.equals(value) || TAX_CATEGORY_THREE.equals(value);
        if (!isValidTaxCategory) {
            throw new InvalidValueException(INVALID_TAX_CATEGORY_MESSAGE, ERROR_CODE);
        }
    }
}
