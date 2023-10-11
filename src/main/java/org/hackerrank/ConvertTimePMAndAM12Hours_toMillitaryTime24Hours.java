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

public class ConvertTimePMAndAM12Hours_toMillitaryTime24Hours {
    public static void main(String[] args) {
        String s_toMillitaryTime = timeConversion("13:05:00PM");
        System.out.println(s_toMillitaryTime);
    }
    public static String timeConversion(String s) {
        String toMillitaryTime_str = "";

        if (s.contains("AM") && s.contains("12")) {

            String[] s_splited = s.split(":");
            s_splited[s_splited.length-1] = s_splited[s_splited.length-1].substring(0, 2);
            s_splited[0] = "00";
            toMillitaryTime_str = String.join(":", s_splited);

        } else if (s.contains("AM")|| (s.contains("12") && s.contains("PM"))) {

            toMillitaryTime_str = s.substring(0, s.length() - 2);

        } else if (s.contains("PM")) {

            String[] s_splited = s.split(":");
            s_splited[s_splited.length-1] = s_splited[s_splited.length-1].substring(0, 2);
            int hourInPMFormat_int = Integer.parseInt(s_splited[0]);
            int hourInMillitaryFormat_int = hourInPMFormat_int + 12;
            s_splited[0] = String.valueOf(hourInMillitaryFormat_int);
            toMillitaryTime_str = String.join(":", s_splited);

        }

        return toMillitaryTime_str;
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
}
