package regular.java.code;

import org.junit.Test;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatesTests {

    @Test
    public void xmlGregorianCalendar() throws Exception {
        Date date = new Date();
        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(date);

        XMLGregorianCalendar gDateFormatted1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);
        System.out.println("Formatted using SimpleDateFormat: " + gDateFormatted1.toString());

        gDateFormatted1.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        System.out.println("Formatted using SimpleDateFormat: " + gDateFormatted1.toString());

        gDateFormatted1.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
        System.out.println("Formatted using SimpleDateFormat: " + gDateFormatted1.toString());

    }
}
