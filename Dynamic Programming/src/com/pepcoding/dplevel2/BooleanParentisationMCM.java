package com.pepcoding.dplevel2;

public class BooleanParentisationMCM {
    public static void main(String[] args) {
        System.out.println("We will learn about the boolean parenthesization ");

        String str1 = "TFTTFTTFTFFT";
        String str2 = "|&&|^^&|^&|";
        int[][] dpt = new int[str1.length()][str1.length()];
        int[][] dpf = new int[str1.length()][str1.length()];

        for (int gap = 0; gap < dpt.length; gap++) {
            for (int i = 0, j = gap; j < dpt.length; i++, j++) {
                if (gap == 0) {
                    char ch = str1.charAt(i);
                    if (ch == 'T') {
                        dpt[i][j] = 1;
                        dpf[i][j] = 0;
                    } else {
                        dpt[i][j] = 0;
                        dpf[i][j] = 1;
                    }
                } else {
                    for (int k = i; k < j; k++) {
                        char opt = str2.charAt(k);
                        int ltc = dpt[i][k];
                        int rtc = dpt[k + 1][j];
                        int lfc = dpf[i][k];
                        int rfc = dpf[k + 1][j];

                        if (opt == '&') {
                            dpt[i][j] += ltc * rtc;
                            dpf[i][j] += lfc * rtc + ltc * rfc + lfc * rfc;
                        } else if (opt == '|') {
                            dpt[i][j] += ltc * rtc + ltc * rfc + rtc * lfc;
                            dpf[i][j] += lfc * rfc;
                        } else { // XOR
                            dpt[i][j] += ltc * rfc + rtc * lfc;
                            dpf[i][j] += ltc * rtc + lfc * rfc;
                        }
                    }
                }
            }
        }
        System.out.println(dpt[0][str1.length() - 1]);
    }
}
