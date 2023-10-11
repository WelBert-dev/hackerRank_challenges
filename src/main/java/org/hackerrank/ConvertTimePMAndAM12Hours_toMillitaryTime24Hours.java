package org.hackerrank;

/*

Given a time in

-hour AM/PM format, convert it to military (24-hour) time.

Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

Example

Return '12:01:00'.

    Return '00:01:00'.

Function Description

Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.

timeConversion has the following parameter(s):

    string s: a time in

    hour format

Returns

    string: the time in

    hour format

Input Format

A single string
that represents a time in -hour clock format (i.e.: or

).

Constraints

    All input times are valid

Sample Input

07:05:45PM

Sample Output

19:05:45

*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertTimePMAndAM12Hours_toMillitaryTime24Hours {
    public static void main(String[] args) throws ParseException {

        System.out.println(timeConversionMoreElegant_useJavaTimeAPI("12:25:00AM"));

    }
    // Primeira versão MENOS ELEGANTE;
    // Segunada versão ABAIXO MAIS ELEGANTE ;D
    public static String timeConversion_InputMeridianTimeFormat_toOutputMillitaryTimeFormat(String meridianTime_PMAndAM_format12Hours_str) {
        String toMillitaryTime_format24Hours_str = "";

        // Lida com "12:XX:XXAM" pois ele é o único AM com lógica diferente de outros nesta conversão
        // O mesmo vale para "12:XX:XXPM" (FEITO ABAIXO, NÃO NESTE!) que a lógica é a mesma dos AM "comuns" aonde apenas retira o "AM" e retorna a String
        if (meridianTime_PMAndAM_format12Hours_str.contains("AM") &&
            meridianTime_PMAndAM_format12Hours_str.contains("12")) {

                String[] meridianTime_PMAndAM_format12Hours_splited
                        = meridianTime_PMAndAM_format12Hours_str.split(":");

            int indexOfLastElement = meridianTime_PMAndAM_format12Hours_splited.length - 1;
            meridianTime_PMAndAM_format12Hours_splited[indexOfLastElement]
                        = meridianTime_PMAndAM_format12Hours_splited[indexOfLastElement]
                                .substring(0, 2);

            meridianTime_PMAndAM_format12Hours_splited[0] = "00";

            toMillitaryTime_format24Hours_str = String.join(":", meridianTime_PMAndAM_format12Hours_splited);

        }
        // Lida com "XX:XX:XXAM" & TAMBÉM Lida com "12:XX:XXPM" que é a mesma lógica, aonde remove o "PM" e retorna a String
        else if (meridianTime_PMAndAM_format12Hours_str.contains("AM")||
                (meridianTime_PMAndAM_format12Hours_str.contains("12") && meridianTime_PMAndAM_format12Hours_str.contains("PM"))) {

            toMillitaryTime_format24Hours_str = meridianTime_PMAndAM_format12Hours_str.substring(0, meridianTime_PMAndAM_format12Hours_str.length() - 2);

        }
        // Lida com "XX:XX:XXPM" MENOS COM O 12 que tem lógica diferente, aonde o tempo já vem "correto"
        // pois o "comun" para outros é apenas acrescentar +12 horas, ou seja se for 07:00:00PM + 12 = 19:00:00
        else if (meridianTime_PMAndAM_format12Hours_str.contains("PM")) {

            String[] meridianTime_PMAndAM_format12Hours_splited
                = meridianTime_PMAndAM_format12Hours_str.split(":");

            int indexOfLastElement = meridianTime_PMAndAM_format12Hours_splited.length - 1;
            meridianTime_PMAndAM_format12Hours_splited[indexOfLastElement] = meridianTime_PMAndAM_format12Hours_splited[indexOfLastElement].substring(0, 2);

            int hourInPMFormat_int = Integer.parseInt(meridianTime_PMAndAM_format12Hours_splited[0]);
            int hourInMillitaryFormat_int = hourInPMFormat_int + 12;
            meridianTime_PMAndAM_format12Hours_splited[0] = String.valueOf(hourInMillitaryFormat_int);
            toMillitaryTime_format24Hours_str = String.join(":", meridianTime_PMAndAM_format12Hours_splited);

        }

        return toMillitaryTime_format24Hours_str;
    }
    public static String timeConversionMoreElegant(String timeIn12HourFormat) {

        int hour = Integer.parseInt(timeIn12HourFormat.substring(0, 2));
        String timeOfDay = timeIn12HourFormat.substring(8, 10);

        if(timeOfDay.equals("AM"))
        {
            if(hour == 12)
                hour = 0;
        }
        else if(timeOfDay.equals("PM"))
        {
            if(hour != 12)
                hour += 12;
        }

        return String.format("%02d%s", hour, timeIn12HourFormat.substring(2, 8));
    }
    // TERCEIRA VERSÃO MELHOR AINDA POIS UTILIZA Date-Time API `java.time`;
    public static String timeConversionMoreElegant_useJavaTimeAPI(String timeIn12HourFormat) throws ParseException {
        SimpleDateFormat displayFormat_millitaryTime_format24Hours = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat parseFormat_meridianTime_PMAndAM_format12Hours = new SimpleDateFormat("hh:mm:ssa");
        Date date = parseFormat_meridianTime_PMAndAM_format12Hours.parse(timeIn12HourFormat);

        return displayFormat_millitaryTime_format24Hours.format(date);

    }
}
