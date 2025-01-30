import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle; // Исправленный импорт
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.Period; // Правильный импорт Period
import java.time.Duration;

public class Main {

    // ========== Singleton и Enum задачи ==========
    static class DatabaseConnection {
        private static DatabaseConnection instance;
        
        private DatabaseConnection() {
            connect();
        }
        
        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }
        
        private void connect() {
            System.out.println("Подключение к базе данных создано.");
        }
    }

    static class Logger {
        private static Logger instance;
        private List<String> logs = new ArrayList<>();
        
        private Logger() {}
        
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }
        
        public void log(String message) {
            logs.add(message);
        }
        
        public void printLogs() {
            logs.forEach(System.out::println);
        }
    }

    enum OrderStatus { NEW, IN_PROGRESS, DELIVERED, CANCELLED }
    
    static class Order {
        private OrderStatus status = OrderStatus.NEW;
        
        public OrderStatus getStatus() {
            return status;
        }
        
        public void setStatus(OrderStatus newStatus) {
            if (status == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED) {
                System.out.println("Нельзя отменить доставленный заказ.");
            } else {
                status = newStatus;
            }
        }
    }

    enum Season { WINTER, SPRING, SUMMER, AUTUMN }
    
    public static String getSeasonName(Season season) {
        switch(season) {
            case WINTER: return "Зима";
            case SPRING: return "Весна";
            case SUMMER: return "Лето";
            case AUTUMN: return "Осень";
            default: return "Неизвестный сезон";
        }
    }

    // ========== Потоки, Декоратор, IO/NIO ==========
    static class FileConverter {
        public static void convertFile(String inputFile, String outputFile) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line.toUpperCase());
                    writer.newLine();
                }
            }
        }
    }

    interface TextProcessor { String process(String text); }

    static class SimpleTextProcessor implements TextProcessor {
        @Override
        public String process(String text) { return text; }
    }

    static class UpperCaseDecorator implements TextProcessor {
        private TextProcessor processor;
        public UpperCaseDecorator(TextProcessor processor) { this.processor = processor; }
        @Override
        public String process(String text) { return processor.process(text).toUpperCase(); }
    }

    static class TrimDecorator implements TextProcessor {
        private TextProcessor processor;
        public TrimDecorator(TextProcessor processor) { this.processor = processor; }
        @Override
        public String process(String text) { return processor.process(text).trim(); }
    }

    static class ReplaceDecorator implements TextProcessor {
        private TextProcessor processor;
        public ReplaceDecorator(TextProcessor processor) { this.processor = processor; }
        @Override
        public String process(String text) { return processor.process(text).replace(" ", "_"); }
    }

    static class PerformanceComparison {
        public static void compareIO(String inputFile, String outputFileIO, String outputFileNIO) throws IOException {
            long start = System.currentTimeMillis();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileIO))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
            }
            long ioTime = System.currentTimeMillis() - start;
            
            start = System.currentTimeMillis();
            try (FileChannel source = FileChannel.open(Paths.get(inputFile));
                 FileChannel dest = FileChannel.open(Paths.get(outputFileNIO), 
                     StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                source.transferTo(0, source.size(), dest);
            }
            long nioTime = System.currentTimeMillis() - start;
            
            System.out.println("IO Time: " + ioTime + " ms, NIO Time: " + nioTime + " ms");
        }
    }

    static class NioFileCopy {
        public static void copy(String source, String dest) throws IOException {
            try (FileChannel src = FileChannel.open(Paths.get(source));
                 FileChannel dst = FileChannel.open(Paths.get(dest), 
                     StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                src.transferTo(0, src.size(), dst);
            }
        }
    }

    // ========== DateTime задачи ==========
    static class DateTimeTasks {
        public static void displayCurrentDateTime() {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("Текущая дата и время: " + now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        }

        public static String compareDates(LocalDate d1, LocalDate d2) {
            return d1.isBefore(d2) ? d1 + " раньше " + d2 : 
                   d1.isAfter(d2) ? d1 + " позже " + d2 : "Даты равны";
        }

        public static long daysUntilNewYear() {
            return LocalDate.now().until(LocalDate.of(LocalDate.now().getYear()+1, 1, 1), ChronoUnit.DAYS);
        }

        public static boolean isLeapYear(int year) { return Year.of(year).isLeap(); }

        public static int countWeekends(int month, int year) {
            return (int) LocalDate.of(year, month, 1)
                .datesUntil(LocalDate.of(year, month, 1).plusMonths(1))
                .filter(d -> d.getDayOfWeek().getValue() >= 6)
                .count();
        }

        public static void measureExecutionTime(Runnable task) {
            long start = System.nanoTime();
            task.run();
            long time = System.nanoTime() - start;
            System.out.println("Выполнено за: " + time/1_000_000 + " ms");
        }

        public static LocalDate parseAndAddDays(String date) {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy")).plusDays(10);
        }

        public static ZonedDateTime convertTimeZone(ZonedDateTime dt, String zone) {
            return dt.withZoneSameInstant(ZoneId.of(zone));
        }

        public static int calculateAge(LocalDate birth) {
            return Period.between(birth, LocalDate.now()).getYears();
        }

        public static void printMonthCalendar(int month, int year) {
            LocalDate start = LocalDate.of(year, month, 1);
            System.out.println(start.getMonth().toString());
            start.datesUntil(start.plusMonths(1))
                 .forEach(d -> System.out.println(d.getDayOfWeek() + " " + d + ": " + 
                     (d.getDayOfWeek().getValue() >= 6 ? "Выходной" : "Рабочий")));
        }

        public static LocalDate randomDate(LocalDate start, LocalDate end) {
            long days = ChronoUnit.DAYS.between(start, end);
            return start.plusDays(new Random().nextInt((int)days + 1));
        }

        public static Duration timeUntil(ZonedDateTime event) {
            return Duration.between(ZonedDateTime.now(), event);
        }

        public static long workingHours(LocalDateTime start, LocalDateTime end) {
            return start.until(end, ChronoUnit.HOURS) - 
                   start.until(end, ChronoUnit.DAYS) * 48; // Простейшая реализация
        }

        public static String formatWithLocale(LocalDate date, Locale locale) {
            return date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", locale));
        }

        public static String russianWeekDay(LocalDate date) {
            return date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("ru"));
        }
    }

    // ========== Главный метод ==========
    public static void main(String[] args) throws IOException {
        // Тест Singleton и Enum
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println("DB instances same: " + (db1 == db2));

        Logger logger = Logger.getInstance();
        logger.log("Test message");
        logger.printLogs();

        Order order = new Order();
        order.setStatus(OrderStatus.IN_PROGRESS);
        System.out.println("Order status: " + order.getStatus());

        System.out.println(getSeasonName(Season.SUMMER));

        // Тест IO/NIO
        FileConverter.convertFile("input.txt", "output.txt");
        PerformanceComparison.compareIO("large.txt", "io_copy.txt", "nio_copy.txt");
        NioFileCopy.copy("source.txt", "dest.txt");

        // Тест DateTime
        DateTimeTasks.displayCurrentDateTime();
        System.out.println(DateTimeTasks.compareDates(LocalDate.now(), LocalDate.now().plusDays(1)));
        System.out.println("Days to NY: " + DateTimeTasks.daysUntilNewYear());
        System.out.println("2024 leap? " + DateTimeTasks.isLeapYear(2024));
        DateTimeTasks.measureExecutionTime(() -> System.out.println("Test task"));
        System.out.println(DateTimeTasks.parseAndAddDays("15-11-2023"));
        System.out.println(DateTimeTasks.russianWeekDay(LocalDate.now()));
    }
}