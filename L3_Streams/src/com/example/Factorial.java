package com.example;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Factorial {

  public static void main(String[] args) {
    //Given a list of integer, you need the factorial of all the numbers

      List<Integer> al = Arrays.asList(10000, 2000, 3000, 5000, 23000, 56000, 45000, 50000);

//      List<Integer> al = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

      long start = System.currentTimeMillis();

      al.stream()
              .map(Factorial::calculate)
              .collect(Collectors.toList());

      long end = System.currentTimeMillis();

      System.out.println(end - start);

  }

  private static BigInteger calculate(int num){
      BigInteger result = BigInteger.ONE;

      for(int i = 2; i <= num; i++){
          result = result.multiply(BigInteger.valueOf(i));
      }

      return result;
  }

  private static Integer calculateInt(int num){
      int result = 1;
      for(int i = 2; i <= num; i++){
          result = result * i;
      }

      return result;
  }
}
