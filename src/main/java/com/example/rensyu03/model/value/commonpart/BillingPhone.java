package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.exceptions.InvalidBillingPhoneValueException;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class BillingPhone {
    private static final String ID_NOT_SET_ERROR_MESSAGE = "課金先電話番号識別子が未設定の場合、課金先電話番号も未設定でなくてはなりません。";

    private final BillingPhoneNumber number;
    private final BillingPhoneId id;

    public BillingPhone(@NonNull final BillingPhoneNumber number, @NonNull final BillingPhoneId id) {
        this.number = number;
        this.id = id;
        validateNumber();
    }

    private void validateNumber() {
        boolean isIdEmpty = this.id.isEmpty();
        boolean isNumberEmpty = this.number.isValueEmpty();

        if (isIdEmpty && !isNumberEmpty || !isIdEmpty && isNumberEmpty) {
            throw new InvalidBillingPhoneValueException(ID_NOT_SET_ERROR_MESSAGE);
        }
    }
}
