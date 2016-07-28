package com.shnaps;

import java.util.ArrayList;
import java.util.Collections;

public class DecimalNumbers {
    private long number;

    /**
     * Constructor of DecimalNumbers
     *
     * @param n Parameter
     */
    public DecimalNumbers(String n) {
        number = Long.valueOf(n);
    }

    /**
     * Method that morphing our number to the right form
     *
     * @param n     Number that will be morphed
     * @param one   First morphe form
     * @param two   Second morphe form
     * @param three Third morphe form
     * @return Morphed form of word
     */
    public static String morph(int n, String one, String two, String three) {
        n = Math.abs(n) % 100;
        int n1 = n % 10;
        if (n > 10 && n < 20) return three;
        if (n1 > 1 && n1 < 5) return two;
        if (n1 == 1) return one;
        return three;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(String numString) {
        number = Long.valueOf(numString);
    }

    /**
     * Method converting input number to it is string presentation
     *
     * @return Converted number
     */
    public String numberToString() {
        String[][] decimals = {
                {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
                {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
        };
        String[] hundreds = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        String[] firstTen = {"", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать"};
        String[] tens = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[][] forms = {
                {"", "", "", "1"},
                {"", "", "", "0"},
                {"тысяча", "тысячи", "тысяч", "1"},
                {"миллион", "миллиона", "миллионов", "0"},
                {"миллиард", "миллиарда", "миллиардов", "0"},
                {"триллион", "триллиона", "триллионов", "0"},
                {"квадриллион", "квадриллиона", "квадриллионов", "0"},
                //Ограничение переполнения лонга.
                //{"квинтиллион", "квинтиллиона", "квинтиллионов", "0"},
                //{"секстиллион", "секстиллиона", "секстиллионов", "0"},
                //{"септиллион", "септиллиона", "септиллионов", "0"},
                //{"октиллион", "октиллиона", "октиллионов", "0"},
        };
        StringBuffer result = new StringBuffer();
        long tempNum = number;
        ArrayList segments = new ArrayList();
        /**
         * Checking if number is < 0
         */
        if (tempNum < 0) {
            tempNum = tempNum * ( -1 );
            result.append("минус ");
        }
        /**
         * Creating ArrayList of number
         */
        while (tempNum > 999) {
            try {
                long seg = tempNum / 1000;
                segments.add(tempNum - ( seg * 1000 ));
                tempNum = seg;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        segments.add(tempNum);
        Collections.reverse(segments);

        /**
         * Checking if number = 0
         */
        if (number == 0) {
            result.append("ноль");
            return result.toString();
        }
        int level = segments.size();
        for (int i = 0; i < segments.size(); i++
                ) {
            /**
             * Getting male/female form of number
             */
            int genderForm = Integer.valueOf(forms[level][3]);
            int currentSeg = Integer.valueOf(segments.get(i).toString());

            String tempResult = String.valueOf(currentSeg);
            /**
             * Creating temp triplets
             */
            if (tempResult.length() == 1) tempResult = "00" + tempResult;
            if (tempResult.length() == 2) tempResult = "0" + tempResult;

            /**
             * Substring parts of num from triplets
             */
            int first = Integer.valueOf(tempResult.substring(0, 1));
            int second = Integer.valueOf(tempResult.substring(1, 2));
            int third = Integer.valueOf(tempResult.substring(2, 3));
            int part = Integer.valueOf(tempResult.substring(1, 3));

            /**
             *Checking words to get proper form from array
             */
            if (currentSeg > 99) {
                result.append(hundreds[first] + " ");
            }
            if (part > 20) {
                result.append(tens[second] + " ");
                result.append(decimals[genderForm][third] + " ");
            } else {
                if (part > 9) {
                    result.append(firstTen[part - 9] + " ");
                } else {
                    result.append(decimals[genderForm][third] + " ");
                }
            }
            /**
             * Returning right form of current segment of number
             */
            result.append(morph(currentSeg, forms[level][0], forms[level][1], forms[level][2]) + " ");
            level--;
        }
        /**
         * Returning resultating morphed string
         */
        return result.substring(0, result.length() - 2).toString();
    }
}

