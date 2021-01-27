package time_conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {
    static String timeConversion(String s) {
        SimpleDateFormat originalsdf = new SimpleDateFormat("hh:mm:ssa",Locale.US);
        SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm:ss");

        Date date = null;

        try {
            date = originalsdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parseFormat.format(date);
    }
}
