package br.com.wallacewolv.controllers;

import br.com.wallacewolv.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/3/5 - somatória
    @RequestMapping("sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num1 = convertToDouble(numberOne);
        Double num2 = convertToDouble(numberTwo);

        return num1 + num2;
    }

    //http://localhost:8080/math/subtraction/3/5 - subtração
    @RequestMapping("subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num1 = convertToDouble(numberOne);
        Double num2 = convertToDouble(numberTwo);

        return num1 - num2;
    }

    //http://localhost:8080/math/multiplication/3/5 - multiplicação
    @RequestMapping("multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num1 = convertToDouble(numberOne);
        Double num2 = convertToDouble(numberTwo);

        return num1 * num2;
    }

    //http://localhost:8080/math/division/3/5 - divisão
    @RequestMapping("division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num1 = convertToDouble(numberOne);
        Double num2 = convertToDouble(numberTwo);

        return num1 / num2;
    }

    //http://localhost:8080/math/mean/3/5 - média
    @RequestMapping("mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num1 = convertToDouble(numberOne);
        Double num2 = convertToDouble(numberTwo);

        return (num1 + num2) / 2;
    }

    //http://localhost:8080/math/square-root/81 - raiz quadrada
    @RequestMapping("square-root/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double num = convertToDouble(number);
        return Math.sqrt(num);
    }

    private Double convertToDouble(String strNumber) throws UnsupportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        String number = strNumber.replace(",", "."); // R$ 5,00 UDS 5.0
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;

        String number = strNumber.replace(",", "."); // R$ 5,00 UDS 5.0
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
