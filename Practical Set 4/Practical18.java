class Member {
    String name;
    int age;
    String phoneNumber;
    String address;
    double salary;

    void printSalary() {
        System.out.println("Salary: " + salary);
    }
}

class Employee extends Member {
    String specialization;
}

class Manager extends Member {
    String department;
}

public class Practical18 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.name = "Name 1";
        employee.age = 30;
        employee.phoneNumber = "123456789";
        employee.address = "India";
        employee.salary = 50000;
        employee.specialization = "Software Engineering";

        Manager manager = new Manager();
        manager.name = "name 2 ";
        manager.age = 40;
        manager.phoneNumber = "987654321";
        manager.address = "456 Elm St";
        manager.salary = 80000;
        manager.department = "IT";

        System.out.println("Employee Details:");
        System.out.println("Name: " + employee.name);
        System.out.println("Age: " + employee.age);
        System.out.println("Phone Number: " + employee.phoneNumber);
        System.out.println("Address: " + employee.address);
        employee.printSalary();
        System.out.println("Specialization: " + employee.specialization);

        System.out.println("\nManager Details:");
        System.out.println("Name: " + manager.name);
        System.out.println("Age: " + manager.age);
        System.out.println("Phone Number: " + manager.phoneNumber);
        System.out.println("Address: " + manager.address);
        manager.printSalary();
        System.out.println("Department: " + manager.department);
    }
}
