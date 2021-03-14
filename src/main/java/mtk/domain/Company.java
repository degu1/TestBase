package mtk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    private String name = "No name";

    private List<Employee> employees = new ArrayList<>();

    public Company(String newName) {
        this.setName(newName);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void addEmployee(Employee newEmployee) {
        this.employees.add(newEmployee);
    }

    /**
     * Increase every employee's salary by the specified fraction
     *
     * @param incrementAsFraction salary increase as a fraction of the original salary. e.g. if the value of the
     *                            parameter is 0.1, everyone at the company gets a 10% raise
     */
    public void everybodyGetsRaiseBy(double incrementAsFraction) {
        this.employees.forEach(e -> e.setSalary(e.getSalary() * (1.0 + incrementAsFraction)));
    }

    /**
     * Finds an employee by their id
     *
     * @param id the id of the employee to be found
     * @return the employee with the id passed as the parameter or null if no such employee exists
     */
    public Employee findEmployeeById(String id) {
        for (Employee employee : this.employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public int numberOfEmployees() {
        return 7;
    }

    public void addEmployees(List<Employee> employees) {
        this.employees.addAll(employees);
    }

    public List<Employee> getEmployessOver18() {
        return employees.stream().filter(employee -> employee.getAge() > 17).collect(Collectors.toList());
//        List<Employee> result = new ArrayList<>();
//        for (Employee employee : this.employees) {
//            if (employee.getAge() > 17) {
//                result.add(employee);
//            }
//        }
//        return result;
    }
}
