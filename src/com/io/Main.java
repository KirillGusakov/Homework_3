package com.io;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //Ex 1
        List<String> list = getText("src\\text.txt");
        printStringsStartsWithVowel(list);


        //Ex 2
       /* List<String> list = getText("src\\text.txt");
        findAndPrintMatchingWords(list);*/

        //EX3
        /*List <String> list = getText("src\\numbers.txt");
        getMaxNumberInRow(list);*/

        /*ex 4
        List<String> list = setPrivateInTxt();
        writeToFile("Private.txt", list);*/

     /*   ex5
        List<StringBuilder> sb = reverseRow();
        writeToFile("Reversed.txt", sb);*/
    }

    public static List<String> getText(String path) {
        try (BufferedReader buf = new BufferedReader(new FileReader(path))) {
            return buf.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printStringsStartsWithVowel(List<String> list) {
        list.stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .map(word -> word.replaceAll("[^a-zA-Zа-яА-Я]", ""))
                .filter(word -> !word.isEmpty())
                .filter(str -> isVowel(str.charAt(0)))
                .forEach(System.out::println);
    }


    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }



    public static void findAndPrintMatchingWords(List<String> lines) {
        lines.stream()
                .map(line -> line.split("\\s+"))
                .flatMap(array -> {
                    List<String> words = List.of(array);
                    return IntStream.range(0, words.size() - 1)
                            .filter(i -> words.get(i).charAt(words.get(i).length() - 1) == words.get(i + 1).charAt(0))
                            .mapToObj(i -> words.get(i) + " " + words.get(i + 1));
                })
                .forEach(System.out::println);
    }

    public static void getMaxNumberInRow(List<String> list) {
        list = list.stream()
                .map(line -> line.replaceAll("\\D+", " ").trim())
                .collect(Collectors.toList());

        for (String line : list) {
            String[] digitSequences = line.split("\\D+");
            long maxDigits = 0;
            String maxDigitSequence = "";

            for (String digitSequence : digitSequences) {
                if (digitSequence.length() > maxDigits) {
                    maxDigits = digitSequence.length();
                    maxDigitSequence = digitSequence;
                }
            }
            System.out.println(maxDigitSequence);
        }
    }

    public static List<String> setPrivateInTxt() {
        try (BufferedReader line = new BufferedReader(new FileReader("src\\JavaCode.txt"))) {
            return line.lines()
                    .map(string -> string.replaceAll("public", "private"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<StringBuilder> reverseRow() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\text.txt"))){
            return bufferedReader.lines()
                    .map(string -> new StringBuilder(string).reverse())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(String fileName, List<?> content) {
        try {
            Files.write(Paths.get(fileName), content
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
