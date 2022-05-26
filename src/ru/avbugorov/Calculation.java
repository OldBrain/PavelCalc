package ru.avbugorov;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Calculation {
    //Задается формат даты
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    //Количество миллисекунд в сутках
    public static final Integer MLS_IN_24_HOURS = 86400000;

    public Double getResult(String timeUp, String timeDown, Double summ) {

        /**
         * timeToMilliseconds()
         * Возвращает количество миллисекунд, прошедших с 1 января 1970 года,
         * 00:00:00 по Гринвичу
         * */
        Long timeBegin = timeToMilliseconds(timeUp);
        Long timeEnd = timeToMilliseconds(timeDown);

        Long interval = timeEnd - timeBegin;

/**
 * Это на всякий случай вдруг понадобтся.
 * */
        Long diffMinutes = getIntervalMinute(interval);
        Long diffSeconds = getIntervalSeconds(interval);
        Long diffHours = getIntervalHours(interval);
        Long diffDays = getIntervalDays(interval);
        /********************************************/

//        TODO  Сюда писать формулу расчета например:
        Double result = null;
        result = (summ / MLS_IN_24_HOURS) * interval;
        return result;
    }

    private Long getIntervalMinute(Long interval) {
        return interval / (60 * 1000) % 60;
    }

    private Long getIntervalDays(Long interval) {
        return interval / (24 * 60 * 60 * 1000);
    }

    private Long getIntervalHours(Long interval) {
        return interval / (60 * 60 * 1000) % 24;
    }

    private Long getIntervalSeconds(Long interval) {
        return interval / 1000 % 60;
    }


    /**
     * @param timeUp - Строка формата "yyyy/MM/dd HH:mm",
     *               иначе будет ParseException.
     *               Применены методы:
     *               format.parse - Метод parse извлекает текст из начала заданной строки для получения даты. Метод может не использовать весь текст данной строки.
     *               Параметры:
     *               источник – Строка - timeUp .
     *               Возвращается:
     *               Тип Date, от строки timeUp.
     *               Бросает:
     * @Exception Бросает Исключение ParseException – если начало указанной строки
     * не может быть проанализировано. В этом случае вернеться null
     * <p>
     * getTime() -Возвращает количество миллисекунд, прошедших с 1 января 1970 года, 00:00:00 по Гринвичу,
     * @result Long Возвращает количество миллисекунд, прошедших с 1 января 1970 года, 00:00:00 по Гринвичу
     */

    private Long timeToMilliseconds(String timeUp) {
        try {
            return format.parse(timeUp).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
