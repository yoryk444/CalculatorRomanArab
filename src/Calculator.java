
import java.util.Scanner;

public class Calculator {
    

    public static void main(String[] args) throws Exception {
        Converter converter = new Converter();
        String[] actionSign = new String[]{"+", "-", "/", "*"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа до 10 и знак операции: ");
        String str = scanner.nextLine();
        //Определяем арифметическое действие:
        int actionIndex = -1;
        for (int i = 0; i < actionSign.length; i++) {
            if (str.contains(actionSign[i])) {
                actionIndex = i;
                break;
            }
        }

        if (actionIndex == -1) {
            throw new Exception("Не найден знак операции");
        }

        String[] arrStr = str.toUpperCase().split("[+\\-\\*\\/]");
        if (arrStr.length != 2) {
            throw new Exception("Вы ввели не 2 числа");
        }
        if (converter.isRoman(arrStr[0]) == converter.isRoman(arrStr[1])) {
            int number1;
            int number2;
            //Определяем, римские ли это числа
            boolean isRoman = converter.isRoman(arrStr[0]);
            if (isRoman) {

                number1 = converter.romanToArab(arrStr[0]);
                number2 = converter.romanToArab(arrStr[1]);

            } else {

                number1 = Integer.parseInt(arrStr[0]);
                number2 = Integer.parseInt(arrStr[1]);
            }
            if (number1 > 10 || number2 > 10){
                throw new Exception("Числа должны быть до 10");
            }

            int result = 0;
            switch (actionSign[actionIndex]) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 == 0) {
                        throw new Exception("На ноль делить нельзя");
                    }
                    result = number1 / number2;
                    break;
            }
            if (isRoman) {
                if (result < 1) {
                    throw new Exception("Римские числа не могут быть отрицательными или '0' ");
                }
                System.out.println(converter.arabToRoman(result));
            } else {
                System.out.println(result);
            }
        } else {
            throw new Exception("Числа должны быть в одном формате");
        }
    }
}
