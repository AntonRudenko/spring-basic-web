package ru.tonyware.utils.barcode;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Anton Rudenko
 */
public class EanUtils {

    /**
     * Check control sum for ean barcode
     * @param code ean barcode
     */
    public static boolean isControlSumValid(String code) {
        if (code.length() != 8 && code.length() != 13) throw new RuntimeException("Supplied code is not ean code without control sum");

        int sum = 0;
        int[] array = stringToIntArray(code);

        ArrayUtils.reverse(array);

        for (int i = 0; i < array.length; i++) {
            int coef = isEven(i + 1) ? 3 : 1;
            sum += coef * array[i];
        }

        int controlSum = sum % 10;

        return controlSum == 0;
    }

    /**
     * Calculate control digit for ean code
     * @param code ean code without control digit
     * @return control digit
     */
    public static int calculateControlDigit(String code) {
        if (code.length() != 7 && code.length() != 12) throw new RuntimeException("Supplied code is not ean code without control sum");

        code += "0";

        int sum = 0;
        int[] array = stringToIntArray(code);

        ArrayUtils.reverse(array);

        for (int i = 0; i < array.length; i++) {
            int coef = isEven(i + 1) ? 3 : 1;
            sum += coef * array[i];
        }

        int controlSum = sum % 10;

        if (controlSum == 0) return 0;
        else return 10 - controlSum;
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }

    private static int[] numberToArray(Long l) {
        String str = Long.toString(l);
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i) - '0';
        }
        return result;
    }

    private static int[] stringToIntArray(String str) {
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i) - '0';
        }
        return result;
    }

}