package com.ust.assignment.controller;


import com.ust.assignment.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public double add(@RequestParam  double num1, @RequestParam  double num2) {
        return calculatorService.add(num1, num2);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam  double num1, @RequestParam  double num2) {
        return calculatorService.subtract(num1, num2);
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam  double num1, @RequestParam  double num2) {
        return calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double num1, @RequestParam  double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return calculatorService.divide(num1, num2);
    }
}

