package br.com.ycj.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BrasilTaxServiceTest {

    @Test
    public void taxTestSucess(){
        BrasilTaxService bts = new BrasilTaxService();
        double tax = bts.tax(20);
        Assertions.assertEquals(tax,4);
    }

    @Test
    public void taxTestFailed(){
        BrasilTaxService bts = new BrasilTaxService();
        double tax = bts.tax(20);
        System.out.println(tax);
        Assertions.assertNotEquals(tax,5);
    }
}
