package com.sbicolending.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentLinks {


    public List<Long> getBusinessPhoneNumberNia() {

            List<Long> businessPhoneNumberNia = new ArrayList<>();
            businessPhoneNumberNia.add(9876543210L);
            businessPhoneNumberNia.add(9876543210L);
            return businessPhoneNumberNia;
    }

    public List<String> getBusinessEmailIdNia() {

            List<String> businessEmailIdNia = new ArrayList<>();
            businessEmailIdNia.add("holmes@credavenue.com");
            businessEmailIdNia.add("holmes@credavenue.com");

            return businessEmailIdNia;
    }



}
