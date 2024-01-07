package com.example.rensyu03.service.validation;

import com.example.rensyu03.exceptions.InvalidValueException;

import java.util.Objects;

/**
 * ValidationUtilityは、文字列の検証を助けるための一連の静的メソッドを提供します。
 * 各メソッドは特定の検証を行い、検証が失敗した場合はInvalidValueExceptionをスローします。
 */
public class ValidationUtility {

    /**
     * 文字列がnullまたは空でないことを検証します。該当する場合、エラーメッセージとエラーコードを伴うInvalidValueExceptionをスローします。
     */
    public static void throwIfNullOrEmpty(final String value, final String errorMessage, final String errorCode) {
        final String trimmedValue = Objects.requireNonNullElse(value, "").trim();
        if (trimmedValue.isEmpty()) {
            throw new InvalidValueException(errorMessage, errorCode);
        }
    }

    /**
     * 与えられた文字列の長さが指定された最大長を超えるかどうかを検証します。長さが最大を超えると、エラーメッセージとエラーコードを使用してInvalidValueExceptionをスローします。
     */
    public static void throwIfExceedsMaxLength(final String value, final int maxLength, final String errorMessage, final String errorCode) {
        if (value.length() > maxLength) {
            throw new InvalidValueException(errorMessage, errorCode);
        }
    }

    /**
     * 与えられた文字列と期待される文字列が等しいことを検証します。等しくない場合、エラーメッセージとエラーコードを持つInvalidValueExceptionをスローします。
     */
    public static void throwIfNotEquals(final String value, final String expectedValue, final String errorMessage, final String errorCode) {
        if (!expectedValue.equals(value)) {
            throw new InvalidValueException(errorMessage, errorCode);
        }
    }

    /**
     * 与えられた文字列の長さが指定された期待する長さと一致するかどうかを検証します。
     * 一致しない場合、エラーメッセージとエラーコードを持つInvalidValueExceptionをスローします。
     */
    public static void throwIfNotMatchLength(final String value, final int expectedLength, final String errorMessage, final String errorCode) {
        if (value.length() != expectedLength) {
            throw new InvalidValueException(errorMessage, errorCode);
        }
    }

    /**
     * 与えられた文字列が数値であること（すなわち、数字のみから構成される）を検証します。
     * 数値でない場合、エラーメッセージとエラーコードを持つInvalidValueExceptionをスローします。
     */
    public static void throwIfNotNumeric(final String value, final String errorMessage, final String errorCode) {
        if (!value.matches("^\\d+$")) {
            throw new InvalidValueException(errorMessage, errorCode);
        }
    }

    /**
     * 文字列を整数に変換し、その数値が特定の最小値と最大値の範囲内にあることを検証します。
     * 数値が範囲外である場合、または文字列が整数に変換できない場合、エラーメッセージとエラーコードを持つInvalidValueExceptionをスローします。
     */
    public static void throwIfNotInRange(final String value, final int minValue, final int maxValue, final String errorMessage, final String errorCode) {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue < minValue || intValue > maxValue) {
                throw new InvalidValueException(errorMessage, errorCode);
            }
        } catch (NumberFormatException ex) {
            throw new InvalidValueException(errorMessage, errorCode);
        }
    }
}