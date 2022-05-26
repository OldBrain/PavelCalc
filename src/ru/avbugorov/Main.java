package ru.avbugorov;

public class Main {

    public static void main(String[] args) {
        Calculation calculation = new Calculation();

        /**
         * Для теста работы
         * дата строка строгого формата "yyyy/MM/dd HH:mm"
         * иначе будет ParseException и NullPointerException
         *
         *  summ надо писать или с точкой и нолями например 159.00 или 159d
         *  иначе будет подчеркиваться красным
         * */
        Double testResult = calculation.getResult("2023/01/01 00:00"
                , "2023/01/02 00:00"
                , 1500.00);

        System.out.println("Результат: " + testResult);

    }
}
