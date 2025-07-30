package br.com.wallacewolv.controllers;

import br.com.wallacewolv.exception.UnsupportedMathOperationException;
import br.com.wallacewolv.services.MathService;
import br.com.wallacewolv.utils.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    //http://localhost:8080/math/sum/3/5 - somatória
    @RequestMapping("sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num1 = NumberConverter.convertToDouble(numberOne);
        Double num2 = NumberConverter.convertToDouble(numberTwo);

        return mathService.sum(num1, num2);
    }

    //http://localhost:8080/math/subtraction/3/5 - subtração
    @RequestMapping("subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num1 = NumberConverter.convertToDouble(numberOne);
        Double num2 = NumberConverter.convertToDouble(numberTwo);

        return mathService.subtraction(num1, num2);
    }

    //http://localhost:8080/math/multiplication/3/5 - multiplicação
    @RequestMapping("multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num1 = NumberConverter.convertToDouble(numberOne);
        Double num2 = NumberConverter.convertToDouble(numberTwo);

        return mathService.multiplication(num1, num2);
    }

    //http://localhost:8080/math/division/3/5 - divisão
    @RequestMapping("division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num1 = NumberConverter.convertToDouble(numberOne);
        Double num2 = NumberConverter.convertToDouble(numberTwo);

        return mathService.division(num1, num2);
    }

    //http://localhost:8080/math/mean/3/5 - média
    @RequestMapping("mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num1 = NumberConverter.convertToDouble(numberOne);
        Double num2 = NumberConverter.convertToDouble(numberTwo);

        return mathService.mean(num1, num2);
    }

    //http://localhost:8080/math/square-root/81 - raiz quadrada
    @RequestMapping("square-root/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!NumberConverter.isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num = NumberConverter.convertToDouble(number);
        return mathService.squareRoot(num);
    }
}
