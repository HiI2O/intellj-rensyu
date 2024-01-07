package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.service.validation.ValidationUtility;
import com.example.rensyu03.util.MessageFormatter;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class BundleIdIdentifier {
    private static final String ERROR_CODE = "10013";
    private static final String FIELD_NAME = "バンドルID識別子";
    private static final int MAX_LENGTH = 1;
    // TODO　1は何かを意味しているはずなので名前を後で調べる
    private static final String ONE = "1";
    private final String value;

    public BundleIdIdentifier(@NonNull final String value) {
        ValidationUtility.throwIfNullOrEmpty(
                value,
                MessageFormatter.formatNullOrEmptyMessage(FIELD_NAME),
                ERROR_CODE
        );

        ValidationUtility.throwIfNotMatchLength(
                value,
                MAX_LENGTH,
                MessageFormatter.formatExceedsMaxLengthMessage(FIELD_NAME, MAX_LENGTH),
                ERROR_CODE
        );

        this.value = value;
    }

    public boolean isNotOne() {
        return !value.equals(ONE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BundleIdIdentifier that = (BundleIdIdentifier) o;

        // valueは必ず非nullであるため、その等価性のみを確認します
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        // valueは必ず非nullであるため、hashCodeを直接返します
        return value.hashCode();
    }
}