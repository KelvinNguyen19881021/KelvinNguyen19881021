

package selenium.com.utils;

import org.openqa.selenium.Rectangle;
import selenium.com.keywords.WebUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

//final -> We do not want any class to extend this class
public final class DateUtils {

    private DateUtils() {
        super();
    }

    /**
     * @return lấy ra ngày tháng năm hiện tại của máy theo cấu trúc mặc định
     */
    public static String getCurrentDate() {
        Date date = new Date();
        return date.toString().replace(":", "_").replace(" ", "_");
    }

    /**
     * @return lấy ra ngày tháng năm và giờ phút giây hiện tại của máy theo cấu trúc dd/MM/yyyy HH:mm:ss
     */
    public static String getCurrentDateTime() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(now);
    }

    public static String getCurrentDateTimeCustom(String separator_Character) {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String timeStamp = formatter.format(now).replace("/", separator_Character);
        timeStamp = timeStamp.replace(" ", separator_Character);
        timeStamp = timeStamp.replace(":", separator_Character);
        return timeStamp;
    }

    /**
     * @return lấy ra ngày tháng năm và giờ phút giây hiện tại của máy theo cấu trúc dd/MM/yyyy HH:mm:ss
     */
    public static String getCurrentDateTime(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        ZoneId z = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.now( z );
        return formatter.format(zdt);
    }

    public static ArrayList<String> parseDateYearToString(String inputDate) {
        // Parse from String to Date
        Date newDate = new Date();
        try {
            newDate = new SimpleDateFormat("MM/dd/yyyy").parse(inputDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        inputDate = new SimpleDateFormat("MM/dd/yyyy").format(newDate);
        // Return data format
        String year = inputDate.substring(6, 10);
        String day = inputDate.substring(3, 5);
        String month = inputDate.substring(0, 2);

        ArrayList<String> dateFormat = new ArrayList<>();
        dateFormat.add(month);
        dateFormat.add(day);
        dateFormat.add(year);
        return dateFormat;
    }

    public static ArrayList<Integer> smartsNumberOfDateToRun(String DateTime) {
        ArrayList<String> currentDate =
                parseDateYearToString(DateUtils.getCurrentDateTime("MM/dd/yyyy"));
        ArrayList<String> DOB = parseDateYearToString(DateTime);
        ArrayList<Integer> numberSwaps = new ArrayList<>();
        int month = Integer.parseInt(currentDate.get(0)) - Integer.parseInt(DOB.get(0));
        int day = Integer.parseInt(currentDate.get(1)) - Integer.parseInt(DOB.get(1));
        int year = Integer.parseInt(currentDate.get(2)) - Integer.parseInt(DOB.get(2));
        numberSwaps.add(Math.abs(day));
        numberSwaps.add(Math.abs(month));
        numberSwaps.add(Math.abs(year));
        return numberSwaps;
    }

    /**
     * @return lấy ra ngày tháng năm và giờ phút giây hiện tại bên US/Canada của máy theo cấu trúc tùy chọn (MM/dd/yyyy)
     */
    public static String getCurrentDateTimeByZone(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        ZoneId z = ZoneId.of( "America/New_York" );
        ZonedDateTime zdt = ZonedDateTime.now(z);
        return formatter.format(zdt);

    }

    public static ArrayList<Integer> smartsNumberOfDateTimeZoneUSToRun(String DateTimeZoneByUS) {
        ArrayList<String> currentDate =
                parseDateYearToString(DateUtils.getCurrentDateTimeByZone("MM/dd/yyyy"));
        ArrayList<String> datetimeZone = parseDateYearToString(DateTimeZoneByUS);
        ArrayList<Integer> numberSwaps = new ArrayList<>();
        int month = Integer.parseInt(currentDate.get(0)) - Integer.parseInt(datetimeZone.get(0));
        int day = Integer.parseInt(currentDate.get(1)) - Integer.parseInt(datetimeZone.get(1));
        int year = Integer.parseInt(currentDate.get(2)) - Integer.parseInt(datetimeZone.get(2));
        numberSwaps.add(Math.abs(day));
        numberSwaps.add(Math.abs(month));
        numberSwaps.add(Math.abs(year));
        return numberSwaps;
    }

    public static String DateFormatConverter(String inputDate) {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

            LocalDate date = LocalDate.parse(inputDate, inputFormatter);
            return date.format(outputFormatter);
        }

}
