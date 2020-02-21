package it.nextre.academy.pr130120.collezioni;

import java.util.*;

public class MainCollection {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(2,6,8,9,0);

        Collections.rotate(nums,1);
        System.out.println(nums);

        MyMath calc = new MyMath();

        nums.forEach(item -> System.out.println(item));
        nums.stream()
                .map(calc::raddoppia)
                .sorted(Integer::compareTo)
                .forEach(System.out::println);


        System.out.println('È'=='È');

    }//end main
}//end class


class MyMath {
    public Integer raddoppia(Integer num){
        return num * 2;
    }
}