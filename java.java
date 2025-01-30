import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задача 1
        /*System.out.print("Введите целое число: ");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println(number + " — четное число.");
        } else {
            System.out.println(number + " — нечетное число.");
        }*/

        // Задача 2
        /*System.out.print("Введите три целых числа: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int min = Math.min(a, Math.min(b, c));
        System.out.println("Минимальное число: " + min);*/

        // Задача 3
        /*System.out.print("Введите число для таблицы умножения: ");
        int multiplicationTableNumber = scanner.nextInt();
        System.out.println("Таблица умножения на " + multiplicationTableNumber + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(multiplicationTableNumber + " * " + i + " = " + (multiplicationTableNumber * i));
        }*/

        // Задача 4
        //System.out.print("Введите целое число N: ");
        /*int n = scanner.nextInt();
        int sumToN = n * (n + 1) / 2;
        System.out.println("Сумма чисел от 1 до " + n + ": " + sumToN);*/

        // Задача 5
        /*System.out.print("Введите количество чисел Фибоначчи: ");
        int fibCount = scanner.nextInt();
        int aFib = 0, bFib = 1;
        System.out.print("Первые " + fibCount + " чисел Фибоначчи: ");
        for (int i = 0; i < fibCount; i++) {
            System.out.print(aFib + " ");
            int nextFib = aFib + bFib;
            aFib = bFib;
            bFib = nextFib;
        }
        System.out.println();*/

        // Задача 6
        /*System.out.print("Введите число для проверки на простоту: ");
        int primeCheck = scanner.nextInt();
        boolean isPrime = true;
        if (primeCheck <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(primeCheck); i++) {
                if (primeCheck % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println(primeCheck + (isPrime ? " — простое число." : " — не простое число."));*/

        // Задача 7
        /*System.out.print("Введите целое число N для обратного порядка: ");
        int reverseN = scanner.nextInt();
        for (int i = reverseN; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();*/

        // Задача 8
        /*System.out.print("Введите два целых числа A и B: ");
        int aEven = scanner.nextInt();
        int bEven = scanner.nextInt();
        int sumEven = 0;
        for (int i = Math.min(aEven, bEven); i <= Math.max(aEven, bEven); i++) {
            if (i % 2 == 0) {
                sumEven += i;
            }
        }
        System.out.println("Сумма четных чисел от " + aEven + " до " + bEven + ": " + sumEven);*/

        // Задача 9
        /*System.out.print("Введите строку для реверса: ");
        scanner.nextLine(); // очистка буфера
        String strToReverse = scanner.nextLine();
        String reversedStr = new StringBuilder(strToReverse).reverse().toString();
        System.out.println("Реверс строки: " + reversedStr);*/

        // Задача 10
        /*System.out.print("Введите целое число для подсчета цифр: ");
        int digitCountNumber = scanner.nextInt();
        int digitCount = String.valueOf(Math.abs(digitCountNumber)).length();
        System.out.println("Количество цифр в числе: " + digitCount);*/

        // Задача 11
        /*System.out.print("Введите целое число для вычисления факториала: ");
        int factorialN = scanner.nextInt();
        long factorial = 1;
        for (int i = 1; i <= factorialN; i++) {
            factorial *= i;
        }
        System.out.println("Факториал числа " + factorialN + ": " + factorial);*/

        // Задача 12
        /*System.out.print("Введите целое число для нахождения суммы цифр: ");
        int sumDigitsNumber = scanner.nextInt();
        int sumDigits = 0;
        while (sumDigitsNumber != 0) {
            sumDigits += sumDigitsNumber % 10;
            sumDigitsNumber /= 10;
        }
        System.out.println("Сумма цифр числа: " + sumDigits);*/

        // Задача 13
        /*System.out.print("Введите строку для проверки на палиндром: ");
        String palindromeStr = scanner.next();
        String reversedPalindromeStr = new StringBuilder(palindromeStr).reverse().toString();
        if (palindromeStr.equals(reversedPalindromeStr)) {
            System.out.println(palindromeStr + " — палиндром.");
        } else {
            System.out.println(palindromeStr + " — не палиндром.");
        }*/

        // Задача 14
        /*System.out.print("Введите размер массива: ");
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }

        int maxInArray = array[0];
        for (int num : array) {
            if (num > maxInArray) {
                maxInArray = num;
            }
        }

        System.out.println("Максимальное число в массиве: " + maxInArray);*/

        // Задача 15
        /*int sumOfArrayElements = 0;
        for (int num : array) {
            sumOfArrayElements += num;
        }

        System.out.println("Сумма всех элементов массива: " + sumOfArrayElements);*/

        // Задача 16
        /*int positiveCount = 0;
        int negativeCount = 0;

        for (int num : array) {
            if (num > 0) positiveCount++;
            else if (num < 0) negativeCount++;
        }

        System.out.println("Количество положительных чисел: " + positiveCount);
        System.out.println("Количество отрицательных чисел: " + negativeCount);*/

        // Задача 17
        /*System.out.print("Введите два целых числа A и B для поиска простых чисел: ");
        int aPrimeRange = scanner.nextInt();
        int bPrimeRange = scanner.nextInt();

        for (int i = Math.min(aPrimeRange, bPrimeRange); i <= Math.max(aPrimeRange, bPrimeRange); i++) {
            boolean isPrimeInRange = true;
            if (i <= 1) isPrimeInRange = false;
            else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrimeInRange = false;
                        break;
                    }
                }
            }
            if (isPrimeInRange) {
                System.out.print(i + " ");
            }
        }
        System.out.println();*/

        // Задача 18
        /*System.out.print("Введите строку для подсчета гласных и согласных: ");
        String vowelConsonantStr = scanner.next();
        int vowelsCount = 0;
        int consonantsCount = 0;

        for (char ch : vowelConsonantStr.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                vowelsCount++;
            } else if (Character.isLetter(ch)) {
                consonantsCount++;
            }
        }

        System.out.println("Количество гласных букв: " + vowelsCount);
        System.out.println("Количество согласных букв: " + consonantsCount);*/

        // Задача 19
        /*System.out.print("Введите строку, состоящую из нескольких слов: ");
        scanner.nextLine(); // очистка буфера
        String wordsStr = scanner.nextLine();
        String[] wordsArray = wordsStr.split("\s+");
        StringBuilder reversedWordsStr = new StringBuilder();

        for (int i = wordsArray.length - 1; i >= 0; i--) {
            reversedWordsStr.append(wordsArray[i]).append(" ");
        }

        System.out.println("Перестановка слов в строке: " + reversedWordsStr.toString().trim());*/

        // Задача 20
        /*System.out.print("Введите целое число для проверки на число Армстронга: ");
        int armstrongNumber = scanner.nextInt();
        String armstrongNumStr = String.valueOf(armstrongNumber);
        int armstrongLength = armstrongNumStr.length();
        int sumArmstrongDigits = 0;

        for (char ch : armstrongNumStr.toCharArray()) {
            sumArmstrongDigits += Math.pow(Character.getNumericValue(ch), armstrongLength);
        }

        if (sumArmstrongDigits == armstrongNumber) {
            System.out.println(armstrongNumber + " — число Армстронга.");
        } else {
            System.out.println(armstrongNumber + " — не число Армстронга.");
        }

        scanner.close();*/
    }
}