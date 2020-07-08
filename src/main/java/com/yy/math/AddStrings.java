package com.yy.math;

/**
 * Created by Administrator on 2020/6/22.
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "1231";
        System.out.println(new AddStrings().addStrings(num1, num2));

    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int m = i >= 0 ? num1.charAt(i) - '0': 0;
            int n = j >= 0 ? num2.charAt(j) - '0': 0;
            int temp = m + n + carry;
            carry = temp / 10;
            res.append(temp % 10);
            i--;
            j--;
        }
        if(carry == 1){
            res.append(carry);
        }
        return res.reverse().toString();
    }

}
