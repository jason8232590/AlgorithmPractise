package com.dx.algorithmpractise.recursion;

/**
 * 1.编程实现斐波那契数列求职 f(n) = f(n-1) + f(n-2)
 * 2.编程实现求阶乘n!
 * 3.编程实现一组数据集合的全排列
 */
public class RecursionPractise {

    /**
     * 实现斐波那契数列
     */
    public int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int finalValue = 0;
        int preValue = 2;
        int beforePreValue = 1;

        for (int i = 3; i <= n; i++) {
            finalValue = preValue + beforePreValue;
            beforePreValue = preValue;
            preValue = finalValue;
        }
        return finalValue;
    }

    /**
     * 编程实现求阶乘n!
     */

    public int jieCheng(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int finalValue = 0;
        int preValue = 2;
        int beforePreValue = 1;

        for (int i = 3; i <= n; i++) {
            finalValue = i * preValue * beforePreValue;
            beforePreValue = preValue;
            preValue = finalValue;
        }
        return finalValue;
    }
}
