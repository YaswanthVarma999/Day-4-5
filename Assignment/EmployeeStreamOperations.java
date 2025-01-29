package com.streamex;

import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeStreamOperations {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John", "HR", 40000),
            new Employee(2, "Sarah", "Engineering", 45000),
            new Employee(3, "Alex", "Engineering", 43000),
            new Employee(4, "Emma", "Sales", 45000),
            new Employee(5, "Sophia", "HR", 48000),
            new Employee(6, "James", "Engineering", 44500)
        );

        employees.stream()
                .max(Comparator.comparingDouble(e -> e.salary))
                .ifPresent(e -> System.out.println("Employee with Highest Salary: " + e));

        System.out.println("Employees with Salary > 5000:");
        employees.stream()
                .filter(e -> e.salary > 5000)
                .forEach(System.out::println);

        System.out.println("Employee Names and Salaries:");
        employees.stream()
                .map(e -> e.name + " - " + e.salary)
                .forEach(System.out::println);

        long count = employees.stream().count();
        System.out.println("Total Employees: " + count);

        System.out.println("Employees Grouped by Department:");
        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department));
        groupedByDept.forEach((dept, employeeList) -> {
            System.out.println(dept + ": " + employeeList);
        });

        double averageSalary = employees.stream()
                .mapToDouble(e -> e.salary)
                .average()
                .orElse(0.0);
        System.out.println("Average Salary: " + averageSalary);

        System.out.println("Employees Sorted by Salary:");
        employees.stream()
                .sorted(Comparator.comparingDouble(e -> e.salary))
                .forEach(System.out::println);

        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(e -> System.out.println("Second Highest Salary: " + e));

        System.out.println("Partition Employees by Salary > 5000:");
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.salary > 5000));
        partitioned.forEach((key, employeeList) -> {
            System.out.println((key ? "Above" : "Below") + " 5000: " + employeeList);
        });

        employees.stream()
                .max(Comparator.comparingInt(e -> e.name.length()))
                .ifPresent(e -> System.out.println("Employee with Longest Name: " + e));

        System.out.println("Average Salary by Department:");
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.averagingDouble(e -> e.salary)));
        avgSalaryByDept.forEach((dept, avgSalary) -> {
            System.out.println(dept + ": " + avgSalary);
        });

        System.out.println("Top 3 Highest Paid Employees:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("Total Salary of All Employees: " + totalSalary);
    }
}
