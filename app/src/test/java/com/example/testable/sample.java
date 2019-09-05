package com.example.testable;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;

@RunWith(MockitoJUnitRunner.class)
public class sample {

    CalDate cal = new CalDate();

    @Test
    public void calculate_8month() {
        //given
        LocalDate now = LocalDate.of(2019,8,1);

        //when
        LocalDate date = cal.calculateExpiry(now, 20000);

        //then
        Assert.assertEquals(LocalDate.of(2019, 12, 16), date);
    }

    @Test
    public void calculate_other_month() {
        //given
        LocalDate now = LocalDate.of(2019,3,1);

        //when
        LocalDate date = cal.calculateExpiry(now, 20000);

        //then
        Assert.assertEquals(LocalDate.of(2019, 7, 1), date);
    }
}

class CalDate{

    public LocalDate calculateExpiry(LocalDate date, int payAmount){
        if(date.getMonth() == Month.AUGUST){
            return date.plusMonths(payAmount / 5000).plusDays(15);
        }else{
            return date.plusMonths(payAmount / 5000);
        }
    }
}
