import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {

    @Test
    public void test() {
        String str = "2018/02/06 20:20:40";
//        String str = "18-2-10";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd h:mm:ss");
//        SimpleDateFormat format = new SimpleDateFormat();
        try {
            String pattern = format.toPattern();
            System.out.println(pattern);
            Date date = format.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
