void main() {

  // 1
  var person = Person(name: "Иван", age: 30, gender: "Мужской");
  person.displayInfo();
  person.increaseAge();
  person.changeName("Сергей");
  person.displayInfo();

  // 2
  var worker = Worker(name: "Алексей", age: 40, gender: "Мужской", salary: 50000);
  worker.displayInfo();
  
  var manager = Manager(name: "Анна", age: 35, gender: "Женский", salary: 70000);
  manager.addSubordinate(worker);
  manager.displayInfo();

  // 3
  List<Animal> animals = [Dog(), Cat(), Cow()];
  for (var animal in animals) {
    animal.makeSound();
  }

  // 4
  Transport car = Car();
  Transport bike = Bike();
  car.move();
  bike.move();

  // 5
  var library = Library();
  library.addBook(Book(title: "1984", author: "Джордж Оруэлл", year: 1949));
  library.addBook(Book(title: "Война и мир", author: "Лев Толстой", year: 1869));
  
  library.findByAuthor("Джордж Оруэлл").forEach((book) => print(book.title));

  // 6
  var account = BankAccount(accountNumber: "123456789");
  account.deposit(1000);
  account.withdraw(500);
  
  // 7
  var counter1 = Counter();
  var counter2 = Counter();
  print("Количество созданных объектов: ${Counter.objectCount}");

  // 8
  Shape circle = Circle(radius: 5);
  Shape rectangle = Rectangle(width: 4, height: 6);
  
  print("Площадь круга: ${circle.getArea()}");
  print("Площадь прямоугольника: ${rectangle.getArea()}");

  // 9
  Animal fish = Fish();
  Animal bird = Bird();
  Animal dog = Dog();

  fish.move();
  bird.move();
  dog.move();

  // 10
  var university = University();
  university.addStudent(Student(name: "Олег", group: "A1", grade: 5));
  university.addStudent(Student(name: "Мария", group: "A2", grade: 4));

  university.sortByName();

  // 11
  var user = User(username: "user123", email: "user@example.com");
  user.displayInfo();

  var admin = Admin(username: "admin", email: "admin@example.com");
  admin.displayInfo();
  admin.banUser(user);

  // 12
  Circle circle = Circle(radius: 5);
  print("Окружность круга: ${circle.getCircumference()}");

  // 13
  var student = Student(name: "Олег", grades: [4, 5, 3, 4]);
  print("Средний балл студента ${student.name}: ${student.getAverageGrade()}");

  // 14. Класс "Список покупок"
  var shoppingList = ShoppingList();
  shoppingList.addItem("Хлеб");
  shoppingList.addItem("Молоко");
  shoppingList.displayItems();

  // 15
  var counter = Counter();
  counter.increment();
  counter.increment();
  counter.reset();
  
  // 16
  Triangle triangle = Triangle(base: 10, height: 5);
  print("Площадь треугольника: ${triangle.getArea()}");

  // 17. Класс "Фильм" и "Кинотеатр"
  var movie = Movie(title: "Интерстеллар", director: "Кристофер Нолан");
  var cinema = Cinema(name: "Кинотеатр Мечта");
  cinema.addMovie(movie);
  
  // 18
  Shape shape1 = Circle(radius: 5);
  Shape shape2 = Circle(radius: 5);
  
  print("Фигуры равны? ${shape1.isEqual(shape2)}");

  // 19
  Calendar calendar = Calendar();
  calendar.addEvent("Встреча с клиентом", DateTime(2023, 10, 15));
  
  // 20
  var studentList = StudentList();
  studentList.addStudent(Student(name: "Иван", grades: [5, 4, 3]));
  studentList.addStudent(Student(name: "Мария", grades: [4, 5, 5]));


// Задача 1
class Person {
  String name;
  int age;
  String gender;

  Person({required this.name, required this.age, required this.gender});

  void displayInfo() {
    print("Имя: $name, Возраст: $age, Пол: $gender");
  }

  void increaseAge() {
    age++;
    print("$name теперь $age лет.");
  }

  void changeName(String newName) {
    name = newName;
    print("Имя изменено на $name.");
  }
}

// Задача 2
class Worker extends Person {
  double salary;

  Worker({required String name, required int age, required String gender, required this.salary})
      : super(name: name, age: age, gender: gender);

}

class Manager extends Worker {
  List<Worker> subordinates = [];

  Manager({required String name, required int age, required String gender, required double salary})
      : super(name: name, age: age, gender: gender, salary: salary);

  void addSubordinate(Worker worker) {
    subordinates.add(worker);
    print("$name добавил работника ${worker.name} в подчинение.");
  }
}

// Задача 3
abstract class Animal {
  void makeSound();
}

class Dog implements Animal {
  @override
  void makeSound() => print("Гав!");
}

class Cat implements Animal {
  @override
  void makeSound() => print("Мяу!");
}

class Cow implements Animal {
  @override
  void makeSound() => print("Му!");
}

// Задача 4
abstract class Transport {
  void move();
}

class Car extends Transport {
  @override
  void move() => print("Машина едет.");
}

class Bike extends Transport {
  @override
  void move() => print("Велосипед едет.");
}

// Задача 5
class Book {
  String title;
  String author;
  int year;

  Book({required this.title, required this.author, required this.year});
}

class Library {
  List<Book> books = [];
  void addBook(Book book) {
    books.add(book);
    print("Книга '${book.title}' добавлена в библиотеку.");
  }

  List<Book> findByAuthor(String author) {
    return books.where((book) => book.author == author).toList();
  }
}

// Задача 6
class BankAccount {
  String accountNumber;
  double _balance = 0;

  BankAccount({required this.accountNumber});

  void deposit(double amount) {
    _balance += amount;
    print("Пополнение на $amount. Баланс: $_balance");
  }

  void withdraw(double amount) {
    if (amount > _balance) {
      print("Недостаточно средств.");
    } else {
      _balance -= amount;
      print("Снятие $amount. Баланс: $_balance");
    }
  }
}

// Задача 7
class Counter {
 static int objectCount = 0;

 Counter() {
   objectCount++;
 }
}

// Задача 8
abstract class Shape {
 double getArea();
}

class Circle extends Shape {
 final double radius;

 Circle({required this.radius});

 @override
 double getArea() => pi * radius * radius;
}

class Rectangle extends Shape {
 final double width;
 final double height;

 Rectangle({required this.width, required this.height});

 @override
 double getArea() => width * height;
}

// Задача 9
class AnimalBase {
 void move() {}
}

class Fish extends AnimalBase {
 @override
 void move() => print("Рыба плавает.");
}

class Bird extends AnimalBase {
 @override
 void move() => print("Птица летает.");
}

class DogAnimal extends AnimalBase {
 @override
 void move() => print("Собака бегает.");
}

// Задача10
class Student {
 String name;
 String group;
 int grade;

 Student({required this.name, required this.group, required this.grade});
}

class University {
 List<Student> students = [];

 void addStudent(Student student) {
   students.add(student);
   print("Студент ${student.name} добавлен.");
 }

 void sortByName() {
   students.sort((a, b) => a.name.compareTo(b.name));
 }
}
// Задача 11
class User {
  String username;
  String email;

  User({required this.username, required this.email});

  void displayInfo() {
    print("Пользователь: $username, Email: $email");
  }
}

class Admin extends User {
  Admin({required String username, required String email}) : super(username: username, email: email);

  void banUser(User user) {
    print("Пользователь ${user.username} заблокирован.");
  }
}

// Задача 12
class Circle {
  double radius;

  Circle({required this.radius});

  double getCircumference() {
    return 2 * pi * radius;
  }
}

// Задача 13
class Student {
  String name;
  List<int> grades;

  Student({required this.name, required this.grades});

  double getAverageGrade() {
    return grades.reduce((a, b) => a + b) / grades.length;
  }
}

// Задача 14
class ShoppingList {
  List<String> items = [];

  void addItem(String item) {
    items.add(item);
    print("Добавлено в список покупок: $item");
  }

  void displayItems() {
    print("Список покупок:");
    for (var item in items) {
      print("- $item");
    }
  }
}

// Задача 15
class Counter {
  int count = 0;

  void increment() {
    count++;
    print("Текущий счетчик: $count");
  }

  void reset() {
    count = 0;
    print("Счетчик сброшен.");
  }
}

// Задача 16
class Triangle {
  double base;
  double height;

  Triangle({required this.base, required this.height});

  double getArea() {
    return (base * height) / 2;
  }
}

// Задача17
class Movie {
   String title;
   String director;

   Movie({required this.title, required this.director});
}

class Cinema {
   String name;
   List<Movie> movies = [];

   Cinema({required this.name});

   void addMovie(Movie movie) {
     movies.add(movie);
     print("Фильм '${movie.title}' добавлен в кинотеатр '$name'.");
   }
}

// Задача18
abstract class Shape {
   double getArea();
   bool isEqual(Shape other);
}

class CircleShape extends Shape {
   final double radius;

   CircleShape({required this.radius});

   @override
   double getArea() => pi * radius * radius;

   @override
   bool isEqual(Shape other) => other is CircleShape && other.radius == radius;
}

// Задача19
class Calendar {
   Map<String, DateTime> events = {};

   void addEvent(String eventName, DateTime date) {
     events[eventName] = date;
     print("Событие '$eventName' добавлено на ${date.toLocal()}.");
   }
}

// Задача20
class StudentList {
   List<Student> students = [];

   void addStudent(Student student) {
     students.add(student);
     print("Студент ${student.name} добавлен.");
   }

   Student? findByName(String name) {
     return students.firstWhere((student) => student.name == name, orElse: () => null);
   }
}