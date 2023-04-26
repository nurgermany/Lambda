package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        //1)

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
          double average = numbers.stream() //stream -для создание элементов
                .mapToInt(num -> num)  //для примитивных типов
                .average()   //для вычесление среднего значение
                .orElse(0);  // если список пустой метод orElse возвращает 0.0
        System.out.println("Среднее значение чисел:" +average);


//2)
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = num.stream()
                .map(n -> n * n)  //лямбда для квадрата
                .collect(Collectors.toList()); //для сбора результат в нов список
        System.out.println("список квадратов:" + squares);


        //3)
        List<Integer> number = Arrays.asList(1,2,3,4,5);
        List<Integer> evenNumbers = number.stream()
                .filter(n -> n % 2 == 0)     //если неетные то != 0
                .collect(Collectors.toList());
        System.out.println("список четные числа" + evenNumbers);

        //4)
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        if (numbers1.contains(3)) {     //для проверки список определенный элемент или нет
            System.out.println("список содержит: 3");
        } else {
            System.out.println("список не содержит: 3");
        }

        //5)
        List <String> strings = Arrays.asList("one","two","three", "four", "five");
        String joinedString = String.join(",", strings); //объединяет все элементы
        System.out.println(joinedString);

        //6)
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5);
        List<Integer> firstThree = numbers2.subList(0,3); // subList- индекс начало и конца
        System.out.println(firstThree);

        //7)
        List<Integer> numbers3 = Arrays.asList(1,2,3,4,5,3,4,6);
        List<Integer> uniqueNumbers = numbers3.stream()
                .distinct()    //убирает все повторяющие элементы
                .collect(Collectors.toList());
        System.out.println(uniqueNumbers);

        //8)
        List<Integer> numbers4 = Arrays.asList(1,2,3,4,5);
        int max = Collections.max(numbers4); // для нахождение мах значение
        System.out.println(max);

        //9
        List<Integer> numbers5 = Arrays.asList(1,2,3,4,5);
        Collections.reverse(numbers5); // для обратный список, перевод - перевернуть
        System.out.println(numbers);


        //Лямбда выражение

        //1
        List<Integer> numbers6 = Arrays.asList(1,2,3,4,5);
        List<Integer> doubleNumbers = numbers6.stream()
                .map(n -> n * 2) // условия для умножения на 2
                .collect(Collectors.toList()); //новый список результата
        System.out.println(doubleNumbers);

        //2
        BinaryOperator<Integer> sum = (a,b) -> a+b; // Бинарныйоператор предств функцию которые принимает два аргумента и возращает того же типа. лямбда-выраж sum складывает два числа
        int result = sum.apply(10,20);   //apply - для нахождения суммы двух чисел
        System.out.println(result);

        //3
        List<Integer> numbers7 = Arrays.asList(1, 5, 10, 15, 20, 25, 30);
        List<Integer> tenNumbers = numbers7.stream()
                .filter(n -> n > 10)
                .collect(Collectors.toList());
        System.out.println(tenNumbers);

        //4
//        List<String> checkLength = str -> str.length() >5;
//        String myString = "Hello world";
//        boolean result = checkLength.length(myString);         // тут не смог понять
//        System.out.println(checkLength);

        //5
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println(stringLength.apply("Hello world"));

        Predicate<String> isLong = str -> str.length() > 5;
        System.out.println(isLong.test("Hello"));
        System.out.println(isLong.test("Hello world"));

        //8
        List<String> string = Arrays.asList("Apple", "Banana", "Orange","Melon","Avocado","Cherry");
        Predicate<String> startWith = str -> str.startsWith("A");
        System.out.println(startWith.test(startWith.toString()));

        //9
        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        List<Integer> squaresList = integers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(squaresList);
    }
}