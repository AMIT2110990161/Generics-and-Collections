package Collections.map_interface;

import java.util.*;

public class GroupByDepartment {
    static class Employee {
        String name;
        String department;

        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }
    }

    public static Map<String, List<String>> groupByDepartment(List<Employee> employees) {
        Map<String, List<String>> grouped = new HashMap<>();
        for (Employee e : employees) {
            grouped.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e.name);
        }
        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        System.out.println(groupByDepartment(employees));
    }
}

