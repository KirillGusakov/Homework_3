package com.exceptions;
/*ДЗ. Исключения
        1. Объявите ссылочную переменную со значением null. Вызовите метод у этой переменной.
        Отловить возникшее исключение c помощью блока try-catch.

        2. Написать код, который создаст, а затем отловит ArrayIndexOutOfBoundsException.

        3. Создать собственный класс-исключение - наследник класса Exception. Создать метод,
        выбрасывающий это исключение. Вызвать этот метод и отловить исключение.
        Вывести stack trace в консоль.

        4. Бросить одно из существующих в JDK исключений, отловить его и оберните его в свое
        кастомное исключение указав в качестве причины отловленное.

        5. Создать метод случайным образом выбрасывающий одно из 3-х видов исключений.
        Вызвать этот метод в блоке try-catch, отлавливающим любое из 3-х.*/

import java.util.Random;

public class Main {
    public static void main(String[] args) {
    /*    Ex 1
        String str = null;
        try {
            str.getBytes();
        } catch (NullPointerException ex) {
            System.out.println("Exception was caught");
        }*/

       /* Ex 2
        int [] array = new int [5];
        try {
            System.out.println(array[5]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }*/

       /* Ex 3
        try {
            getException();
        } catch (MyException e) {
           e.printStackTrace();
        }*/

       /* Ex 4
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            new MyException(e);
        }*/

     /*   Ex 5
        try {
            throwRandomException();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }*/
    }

    public static void getException() throws MyException {
        throw new MyException("message");
    }

    public static void throwRandomException() {
        Random random = new Random();
        int randomNum = random.nextInt(3);

        switch (randomNum) {
            case 0:
                throw new RuntimeException("This is Exception1");
            case 1:
                throw new ArrayIndexOutOfBoundsException("This is Exception2");
            case 2:
                throw new NullPointerException("This is Exception3");
        }
    }
}
