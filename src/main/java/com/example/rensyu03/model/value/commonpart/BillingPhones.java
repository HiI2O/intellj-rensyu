package com.example.rensyu03.model.value.commonpart;

import com.example.rensyu03.exceptions.InvalidBillingPhoneValueException;
import com.example.rensyu03.exceptions.InvalidValueException;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class BillingPhones {
    private static final String PHONE1_NUMBER_ERROR_CODE = "10004";
    private static final String PHONE1_ID_ERROR_CODE = "10005";
    private static final String PHONE2_NUMBER_ERROR_CODE = "10006";
    private static final String PHONE2_ID_ERROR_CODE = "10007";
    private static final String PHONE3_NUMBER_ERROR_CODE = "10008";
    private static final String PHONE3_ID_ERROR_CODE = "10009";
    private static final String PHONE4_NUMBER_ERROR_CODE = "10010";
    private static final String PHONE4_ID_ERROR_CODE = "10011";

    private final BillingPhone billingPhone1;
    private final BillingPhone billingPhone2;
    private final BillingPhone billingPhone3;
    private final BillingPhone billingPhone4;

    private BillingPhones(BillingPhone billingPhone1, BillingPhone billingPhone2, BillingPhone billingPhone3, BillingPhone billingPhone4) {
        this.billingPhone1 = billingPhone1;
        this.billingPhone2 = billingPhone2;
        this.billingPhone3 = billingPhone3;
        this.billingPhone4 = billingPhone4;
    }

    public static BillingPhones createInstance(@NonNull final String number1, @NonNull final String id1,
                                               @NonNull final String number2, @NonNull final String id2,
                                               @NonNull final String number3, @NonNull final String id3,
                                               @NonNull final String number4, @NonNull final String id4) {
        BillingPhone billingPhone1 = createBillingPhoneFor1st(number1, id1);
        BillingPhone billingPhone2 = createBillingPhone(number2, id2, PHONE2_NUMBER_ERROR_CODE, PHONE2_ID_ERROR_CODE);
        BillingPhone billingPhone3 = createBillingPhone(number3, id3, PHONE3_NUMBER_ERROR_CODE, PHONE3_ID_ERROR_CODE);
        BillingPhone billingPhone4 = createBillingPhone(number4, id4, PHONE4_NUMBER_ERROR_CODE, PHONE4_ID_ERROR_CODE);

        return new BillingPhones(billingPhone1, billingPhone2, billingPhone3, billingPhone4);
    }

    private static BillingPhone createBillingPhoneFor1st(final String numberValue, final String idValue) {
        if (numberValue.isEmpty()) {
            throw new InvalidValueException("Phone number is empty", PHONE1_NUMBER_ERROR_CODE);
        }

        if (idValue.isEmpty()) {
            throw new InvalidValueException("Phone ID is empty", PHONE1_ID_ERROR_CODE);
        }

        return new BillingPhone(new BillingPhoneNumber(numberValue), new BillingPhoneId(idValue));
    }

    private static BillingPhone createBillingPhone(final String numberValue, String idValue, String phoneNumberErrorCode, String phoneIdErrorCode) {
        BillingPhoneId billingPhoneId;
        try {
            billingPhoneId = new BillingPhoneId(idValue);
        } catch (InvalidBillingPhoneValueException e) {
            throw new InvalidValueException(e.getMessage(), phoneNumberErrorCode);
        }
        BillingPhone billingPhone;
        try {
            billingPhone = new BillingPhone(new BillingPhoneNumber(numberValue), billingPhoneId);
        } catch (InvalidBillingPhoneValueException e) {
            throw new InvalidValueException(e.getMessage(), phoneIdErrorCode);
        }

        return billingPhone;
    }
}
