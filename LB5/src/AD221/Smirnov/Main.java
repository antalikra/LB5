package AD221.Smirnov;

import java.util.Scanner;

// Створюємо клас Person
class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    // Гетери та сетери для полів
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Метод для виведення інформації про особу
    public String printInfo() {
        return "Людина " + lastName + " " + firstName + ", вік: " + age;
    }

    // Метод для створення об'єкта Person з введених користувачем даних
    public static Person createPerson() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть прізвище: ");
        String lastName = scanner.nextLine();
        System.out.print("Введіть ім'я: ");
        String firstName = scanner.nextLine();
        System.out.print("Введіть вік: ");
        int age = scanner.nextInt();

        return new Person(lastName, firstName, age);
    }
}

class Student extends Person {
    private String group;
    private String studentID;

    public Student(String lastName, String firstName, int age, String group, String studentID) {
        super(lastName, firstName, age);
        this.group = group;
        this.studentID = studentID;
    }

    // Гетери та сетери для додаткових полів
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // Перевизначений метод для виведення інформації про студента
    @Override
    public String printInfo() {
        return "Студент групи " + group + " " + getLastName() + " " + getFirstName() + ", вік: " + getAge() + ". Номер студентського квитка: " + studentID;
    }

    // Метод для створення об'єкта Student з введених користувачем даних
    public static Student createStudent() {
        Person person = createPerson();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть групу: ");
        String group = scanner.nextLine();
        System.out.print("Введіть номер студентського квитка: ");
        String studentID = scanner.nextLine();

        return new Student(person.getLastName(), person.getFirstName(), person.getAge(), group, studentID);
    }
}

// Створюємо клас Lecturer, який успадковує клас Person
class Lecturer extends Person {
    private String department;
    private double salary;

    public Lecturer(String lastName, String firstName, int age, String department, double salary) {
        super(lastName, firstName, age);
        this.department = department;
        this.salary = salary;
    }

    // Гетери та сетери для додаткових полів
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Перевизначений метод для виведення інформації про викладача
    @Override
    public String printInfo() {
        return "Викладач кафедри " + department + " " + getLastName() + " " + getFirstName() + ", вік: " + getAge() + ". Зарплата: " + salary;
    }

    // Метод для створення об'єкта Lecturer з введених користувачем даних
    public static Lecturer createLecturer() {
        Person person = createPerson();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кафедру: ");
        String department = scanner.nextLine();
        System.out.print("Введіть зарплату: ");
        double salary = scanner.nextDouble();

        return new Lecturer(person.getLastName(), person.getFirstName(), person.getAge(), department, salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Скільки студентів ви хочете додати? ");
        int numStudents = scanner.nextInt();
        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            students[i] = Student.createStudent();
        }

        System.out.print("Скільки лекторів ви хочете додати? ");
        int numLecturers = scanner.nextInt();
        Lecturer[] lecturers = new Lecturer[numLecturers];
        for (int i = 0; i < numLecturers; i++) {
            lecturers[i] = Lecturer.createLecturer();
        }

        System.out.println("Інформація про студентів:");
        for (Student student : students) {
            System.out.println(student.printInfo());
        }

        System.out.println("Інформація про лекторів:");
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer.printInfo());
        }
    }
}

