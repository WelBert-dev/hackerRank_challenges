package org.hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/* Meridiam Greenwich time to Millitary Time Table:

12-hour am-pm clock	| 24-hour military time
12:00 midnight	    | 00:00 | OU SEJA, RESETAR, TIME - 12 == 12:00 midnight - 12:00 == 00:00
1:00 am	            | 01:00 | OU SEJA, APENAS REMOVER "AM" == 1:00AM == 01:00
2:00 am	            | 02:00 | OU SEJA, APENAS REMOVER "AM" == 2:00AM == 02:00
3:00 am 	        | 03:00 | OU SEJA, APENAS REMOVER "AM" == 3:00AM == 03:00
4:00 am	            | 04:00 | OU SEJA, APENAS REMOVER "AM" == 4:00AM == 04:00
5:00 am	            | 05:00 | OU SEJA, APENAS REMOVER "AM" == 5:00AM == 05:00
6:00 am	            | 06:00 | OU SEJA, APENAS REMOVER "AM" == 6:00AM == 06:00
7:00 am	            | 07:00 | OU SEJA, APENAS REMOVER "AM" == 7:00AM == 07:00
8:00 am	            | 08:00 | OU SEJA, APENAS REMOVER "AM" == 8:00AM == 08:00
9:00 am	            | 09:00 | OU SEJA, APENAS REMOVER "AM" == 9:00AM == 09:00
10:00 am	        | 10:00 | OU SEJA, APENAS REMOVER "AM" == 10:00AM == 10:00
11:00 am	        | 11:00 | OU SEJA, APENAS REMOVER "AM" == 11:00AM == 11:00
12:00 pm midday     | 12:00 | OU SEJA, APENAS REMOVER "PM" == 12:00PM == 12:00
1:00 pm	            | 13:00 | OU SEJA, SOMAR time + 12Horas (1:00PM + 12:00 == 13:00 MILLITARY);
2:00 pm	            | 14:00 | OU SEJA, SOMAR time + 12Horas (2:00PM + 12:00 == 14:00 MILLITARY);
3:00 pm	            | 15:00 | OU SEJA, SOMAR time + 12Horas (3:00PM + 12:00 == 15:00 MILLITARY);
4:00 pm	            | 16:00 | OU SEJA, SOMAR time + 12Horas (4:00PM + 12:00 == 16:00 MILLITARY);
5:00 pm	            | 17:00 | OU SEJA, SOMAR time + 12Horas (5:00PM + 12:00 == 17:00 MILLITARY);
6:00 pm	            | 18:00 | OU SEJA, SOMAR time + 12Horas (6:00PM + 12:00 == 18:00 MILLITARY);
7:00 pm	            | 19:00 | OU SEJA, SOMAR time + 12Horas (7:00PM + 12:00 == 19:00 MILLITARY);
8:00 pm	            | 20:00 | OU SEJA, SOMAR time + 12Horas (8:00PM + 12:00 == 20:00 MILLITARY);
9:00 pm	            | 21:00 | OU SEJA, SOMAR time + 12Horas (9:00PM + 12:00 == 21:00 MILLITARY);
10:00 pm	        | 22:00 | OU SEJA, SOMAR time + 12Horas (10:00PM + 12:00 == 22:00 MILLITARY);
11:00 pm	        | 23:00 | OU SEJA, SOMAR time + 12Horas (11:00PM + 12:00 == 23:00 MILLITARY);
12:00 midnight	    | 00:00 | OU SEJA, RESETAR, TIME - 12 == 12:00 midnight - 12:00 == 00:00;


Ou seja, Formula/Regras de conversão:
    - time pertence (1:00AM até 11:00AM) então APENAS remove "AM" (1:00AM REMOVE AM == 01:00 MILLITARY);
    - time pertence (1:00PM até 11:00PM) então SOMAR time + 12Horas (1:00PM + 12:00 == 13:00 MILLITARY);

    - time pertence (12:00AM midnight) então RESETAR time (-12Horas) (12:00AM - 12:00 == 00:00 MILLITARY);
    - time pertence (12:00PM midday) MESMA REGRA QUE (1:00AM até 11:00AM) Aonde apenas REMOVE "PM" (12:00PM REMOVE PM == 12:00 MILLITARY);

*/

class ConvertTimePMAndAM12Hours_toMillitaryTime24HoursTest {

}