package com.pluralsight;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file employee file to process: ");
        String selectedFile = scanner.nextLine();

        System.out.println("Enter the name of the payroll file to create: ");
        String payrollFile = scanner.nextLine();


        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/employeesnew.csv"));
            bufReader.readLine();// skips header
            FileWriter writer = new FileWriter(payrollFile);
            writer.write("id|name|hours-worked|pay-rate\n");

            String line;
            while ((line = bufReader.readLine()) != null) {
                // printEmployee (line); create method here
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

                //write new name
                writer.write (employee.getId() + "|" + employee.getName() + "|" + employee.calculateGrossPay() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
                }
    }
}

