package com.yy.math;

import java.util.*;

/**
 * Created by Administrator on 2020/6/23.
 */
public class Calculate {
    public static void main(String[] args) {
        String s = "3 * (2-6 /(3 -7))";
        System.out.println(new Calculate().calculate(s));
        System.out.println(4/2);
        System.out.println(Integer.toBinaryString(8));
        int maxXor = 1;
        for(int i = 4 - 1; i > -1; --i) {
            // go to the next bit by the left shift
            maxXor <<= 1;
        }
        System.out.println(Integer.toBinaryString(maxXor));
    }


    public int calculate(String s){
        char[] ss = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < ss.length; i++) {
            list.add(ss[i]);
        }
        int result = help(list);
        return result;
    }

    public int help(LinkedList<Character> list){
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        while(list.size() > 0) {
            char c = list.removeFirst();
            //将字符转换为数字
            if(Character.isDigit(c)){
                num = 10 * num + (c - '0');
            }
            if(c == '('){
                num = help(list);
            }
            //碰到的是字符
            if((!Character.isDigit(c) && c != ' ') || list.size() == 0){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                sign = c;
                num = 0;
            }
            if(c == ')'){
                break;
            }
        }
        while(!stack.isEmpty()){
            res += stack.pop();
        }

        return res;
    }
}
