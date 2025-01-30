import java.time.format.DateTimeParseException
import java.time.LocalDate

// 1
fun max(a: Int, b: Int): Int {
    if (a == b) throw IllegalArgumentException("Числа равны.")
    return if (a > b) a else b
}

// 2
fun divide(a: Double, b: Double): Double {
    if (b == 0.0) throw ArithmeticException("Недопустимо деление на ноль.")
    return a / b
}

// 3
fun convertToInt(str: String): Int {
    return str.toIntOrNull() ?: throw NumberFormatException("Невозможно конвертировать строку в число.")
}

// 4
fun checkAge(age: Int) {
    if (age < 0 || age > 150) throw IllegalArgumentException("Некорректный возраст.")
}

// 5
fun sqrt(number: Double): Double {
    if (number < 0) throw IllegalArgumentException("Отрицательное число.")
    return kotlin.math.sqrt(number)
}

// 6
fun factorial(n: Int): Long {
    if (n < 0) throw IllegalArgumentException("Отрицательное число.")
    return if (n == 0) 1 else n * factorial(n - 1)
}

// 7
fun checkForZeros(array: IntArray) {
    if (array.contains(0)) throw IllegalArgumentException("Массив содержит нули.")
}

// 8
fun power(base: Double, exponent: Int): Double {
    if (exponent < 0) throw IllegalArgumentException("Отрицательная степень.")
    return Math.pow(base, exponent.toDouble())
}

// 9
fun trimString(str: String, length: Int): String {
    if (length > str.length) throw IllegalArgumentException("Длина превышает длину строки.")
    return str.substring(0, length)
}

// 10
fun findInArray(array: Array<Int>, element: Int): Int {
    return array.indexOf(element.takeIf { it in array } ?: throw NoSuchElementException("Элемент не найден."))
}

// 11. Конвертация в двоичную систему
fun toBinaryString(number: Int): String {
    if (number < 0) throw IllegalArgumentException("Отрицательное число.")
    return Integer.toBinaryString(number)
}

// 12
fun checkDivisibility(a: Int, b: Int) {
    if (b == 0) throw ArithmeticException("Недопустимо деление на ноль.")
    if (a % b != 0) throw IllegalArgumentException("$a не делится на $b.")
}

// 13
fun readElement(list: List<String>, index: Int): String {
    if (index !in list.indices) throw IndexOutOfBoundsException("Индекс вне пределов списка.")
    return list[index]
}

// Задача 14
class WeakPasswordException(message: String) : Exception(message)

fun checkPasswordStrength(password: String) {
    if (password.length < 8) throw WeakPasswordException("Пароль слишком слабый.")
}

// Задача 15


fun checkDateFormat(dateStr: String) {
    try {
        LocalDate.parse(dateStr, java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    } catch (e: DateTimeParseException) {
        throw IllegalArgumentException("Некорректная дата.")
    }
}

// Задача 16
fun concatStrings(str1: String?, str2: String?): String {
    if (str1 == null || str2 == null) throw NullPointerException("Одна из строк равна null.")
    return str1 + str2
}

// Задача 17
fun remainder(a: Int, b: Int): Int {
    if (b == 0) throw ArithmeticException("Недопустимо деление на ноль.")
    return a % b
}

// Задача 18
fun squareRoot(number: Double): Double {
    return sqrt(number)
}

// Задача 19
fun celsiusToFahrenheit(celsius: Double): Double {
    if (celsius < -273.15) throw IllegalArgumentException("Температура ниже абсолютного нуля.")
    return celsius * 9 / 5 + 32
}

// Задача 20
fun checkStringEmpty(str: String?) {
    if (str.isNullOrEmpty()) throw IllegalArgumentException("Строка пустая или равна null.")
}

fun main() {
}