package com.paydock.paydocksdk.Tools;

import java.io.OptionalDataException;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

/**
 * Created by Mark on 27/06/2017.
 */

public class DateUtils {



    public String DateUtils (Date dateOrNull){

        Optional<Date> sc = Optional.of(dateOrNull);

        if(sc != null){
            System.out.println(sc);
        }

        return (dateOrNull == null ? null : DateFormat.getDateTimeInstance().format(dateOrNull));
    }


}
