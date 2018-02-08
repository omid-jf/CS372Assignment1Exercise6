/*
 * This file is part of the CS372Assignment1Exercise6 project.
 *
 * Author: Omid Jafari - omidjafari.com
 * Copyright (c) 2018
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import java.math.BigInteger;

public class Fibonacci {
    private static int expFib(int n){
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return expFib(n - 1) + expFib(n - 2);
    }

    private static int polyFib(int n){
        int[] f = new int[n + 1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++)
            f[i] = f[i - 1] + f[i - 2];

        return f[n];
    }

    public static void main (String[] args){
        System.out.println("|======================================================|");
        System.out.println("|            Execution time in nano seconds            |");
        System.out.println("|======================================================|");
        System.out.println("| n     | Exponential Algorithm | Polynomial Algorithm |");
        System.out.println("|======================================================|");

        long startTime, expRunTime, polyRunTime;
        int answer;

        for (int i = 1; i <= 50; i += 5) {
            startTime = System.nanoTime();
            expFib(i);
            expRunTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            polyFib(i);
            polyRunTime = System.nanoTime() - startTime;

            System.out.printf("| %-5d | %-21d | %-20d |\n", i, expRunTime, polyRunTime);
            System.out.println("|------------------------------------------------------|");
        }

        for (int i = 1; i <= 1000; i++){
            startTime = System.nanoTime();
            expFib(i);
            expRunTime = System.nanoTime() - startTime;

            if (expRunTime >= 10000000){
                System.out.println("Largest value of n for exponential algorithm computed in " +
                        "less than 10 milliseconds is: " + i);
                break;
            }
        }

        for (int i = 1; i <= 1000; i++){
            startTime = System.nanoTime();
            answer = polyFib(i);
            polyRunTime = System.nanoTime() - startTime;

            if (polyRunTime >= 10000000){
                System.out.println("Largest value of n for polynomial algorithm computed in " +
                        "less than 10 milliseconds is: " + i);
                break;
            }

            if (answer < 0){
                System.out.println("Largest value of n for polynomial algorithm computed " +
                        "before int overflows is: " + (i - 1));
                break;
            }
        }
    }
}
