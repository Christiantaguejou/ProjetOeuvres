import com.epul.oeuvres.dao.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class test {

    public static void main(String[] args){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
        try {
            System.out.println(new Date(format.parse("10-02-2010").getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
