package com.example.rensyu03.util;

public class MessageFormatter {
    private static final String NULL_OR_EMPTY_TEMPLATE = "%sはnullまたは空にできません。";
    private static final String NOT_NUMERIC_TEMPLATE = "%sは半角数値でないといけません。";
    private static final String NOT_IN_RANGE_TEMPLATE = "%sは%d~%dでないといけません。";
    private static final String EXCEEDS_MAX_LENGTH_TEMPLATE = "%sは%d以下でないといけません。";
    private static final String TOO_SHORT_TEMPLATE = "%sは%d桁でないといけません。";


    public static String formatNullOrEmptyMessage(String fieldName) {
        return String.format(NULL_OR_EMPTY_TEMPLATE, fieldName);
    }

    public static String formatNotNumericMessage(String fieldName) {
        return String.format(NOT_NUMERIC_TEMPLATE, fieldName);
    }

    public static String formatNotInRangeMessage(String fieldName, int minValue, int maxValue) {
        return String.format(NOT_IN_RANGE_TEMPLATE, fieldName, minValue, maxValue);
    }

    public static String formatExceedsMaxLengthMessage(String filedName, int maxLength) {
        return String.format(EXCEEDS_MAX_LENGTH_TEMPLATE, filedName, maxLength);
    }

    public static String formatTooShortMessage(String fieldName, int digit) {
        return String.format(TOO_SHORT_TEMPLATE, fieldName, digit);
    }
}
