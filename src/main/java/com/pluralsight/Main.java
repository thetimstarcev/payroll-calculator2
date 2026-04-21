package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/employees.csv"));
            bufReader.readLine(); // skips header
            String line;

            while ((line = bufReader.readLine()) != null) {

                String [] parts = line.split ("\\|");

                int id = Integer.parseInt(parts [0]);
                String name = parts [1];
                double hoursWorked = Double.parseDouble(parts [2]);
                double payRate = Double.parseDouble(parts [3]);


                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setHoursWorked(hoursWorked);
                employee.setPayRate(payRate);

                System.out.println(employee.getId() + " " + employee.getName() + " " + employee.calculateGrossPay());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
                }
            }
}

