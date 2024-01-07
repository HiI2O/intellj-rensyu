package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.service.validation.ValidationUtility;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class BundleIdAggregationContract {
    private static final String ERROR_CODE = "10014";
    private static final String IS_NULL_OR_EMPTY_MESSAGE = "バンドルID識別子が1以外の場合は、必須です。";
    private final String value;

    public BundleIdAggregationContract(@NonNull final String value, final BundleIdIdentifier bundleIdIdentifier) {
        if (bundleIdIdentifier.isNotOne()) {
            ValidationUtility.throwIfNullOrEmpty(value, IS_NULL_OR_EMPTY_MESSAGE, ERROR_CODE);
        }
        this.value = value;
    }
}
