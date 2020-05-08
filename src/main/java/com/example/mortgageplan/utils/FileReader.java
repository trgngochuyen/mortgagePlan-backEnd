package com.example.mortgageplan.utils;

import com.example.mortgageplan.entity.Customer;
import com.example.mortgageplan.repository.CustomerRepository;
import com.example.mortgageplan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component("fileReader")
public class FileReader {

    @Autowired
    CustomerRepository repository;
    @Autowired
    CustomerService service;

    public void readFile(String pathname) {
        try {
            File myObj = new File(pathname);
            Scanner myReader = new Scanner(myObj);
            int line = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(line != 0) {
                    String[] values = data.split(",");
                    if (values.length == 1) continue;
                    if (values.length > 4) {
                        values[0] = values[0].replaceAll("^\"|\"$", "").concat(" " + values[1].replaceAll("^\"|\"$", ""));
                        values[1] = values[2];
                        values[2] = values[3];
                        values[3] = values[4];
                    }
                    String name = values[0];
                    float loan = Float.parseFloat(values[1]);
                    float interest = Float.parseFloat(values[2]);
                    int years = Integer.parseInt(values[3]);
                    double monthlyPayment = service.calculateMonthlyPayment(years, interest, loan);
                    Customer customer = new Customer(name,years, loan,interest, 0);
                    customer.setMonthlyPayment((float)monthlyPayment);
                    repository.save(customer);
                }
                line++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
