package com.sbicolending.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class DataTypeConverter {

    public int stringtoIntConverter(String stringVal)  {
        int convarteVal = 0;
        try {
            convarteVal = 0;
            if (stringVal == null || stringVal.trim().isEmpty()) {

                return convarteVal;
            }else {

                int intVal = Integer.parseInt(stringVal);
                convarteVal = intVal;
            }
        } catch (Exception e) {
            System.out.println("Exception:- StringtoIntConverter: " + e);
        }
        return convarteVal;
    }


    public LocalDate stringtoDateConverter(String stringVal) throws ParseException {

        LocalDate convertDate = null;
        try {
            convertDate = null;
            if (stringVal == null || stringVal.trim().isEmpty()) {

                return convertDate;
            }else{
                LocalDate date = LocalDate.parse(stringVal, DateTimeFormatter.ISO_DATE);
                convertDate = date;
            }
        } catch (Exception e) {
            System.out.println("Exception:- stringtoDateConverter" + e);
        }
        return convertDate;
    }

    public float integertoFloatConverter(Integer intVal) {

        float convertVal = 0f;
        try {
            convertVal = 0f;

            if(intVal == null || StringUtils.isEmpty(intVal) ){

                return convertVal;
            }else {
                float floatVal = (float) intVal;
                convertVal =floatVal;
            }
        } catch (Exception e) {
            System.out.println("Exception:- integertoFloatConverter" + e);
        }
        return convertVal;
    }


    public Float stringtoFloatConverter(String stringVal) {


        Float convertVal = 0f;
        try {
            convertVal = 0f;

        if(stringVal == null || StringUtils.isEmpty(stringVal) || stringVal.trim().isEmpty()){

            return convertVal;
        }else {
            float floatValue = Float.parseFloat(stringVal);
            convertVal =floatValue;
        }
        } catch (Exception e) {
            System.out.println("Exception:- integertoFloatConverter" + e);
        }
        return convertVal;

    }


    public int doubletoIntConverter(Double doubleVal) {

        int convertVal = 0;
        try {
            convertVal = 0;
            if (doubleVal == null || StringUtils.isEmpty(doubleVal)) {

                return convertVal;
            } else {
                int value1 = (int)Math.round(doubleVal);
                convertVal = value1;
            }
        } catch (Exception e) {
            System.out.println("Exception:- doubletoIntConverter" + e);
        }
        return convertVal;
    }

    public String FloattoStringConverter(Float floatVal) {

        String convertVal = null;
      try {
          if(floatVal == null || StringUtils.isEmpty(floatVal) ) {

              return convertVal;
          }else {
              String stringVal=String.valueOf(floatVal);
              stringVal =stringVal;
          }

       }catch (Exception e){
          System.out.println("Exception:- FloattoStringConverter" + e);
      }
        return convertVal;
    }



}
