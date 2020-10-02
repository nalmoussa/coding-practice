package com.nalmoussa.coding.practice.problem038;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MerchantScoreTest {
    private MerchantScore merchantScore;
    private int merchantId = 1;
    private String merchantName = "Mock Merchant";

    @Before
    public void init() {
        Merchant merchant = new Merchant(merchantId, merchantName);
        merchantScore = new MerchantScore(merchant);
    }

    @Test
    public void getMerchantMethodWorks() {
        Merchant actualMerchant = merchantScore.getMerchant();
        Assert.assertEquals("Failed", merchantId, actualMerchant.getId());
        Assert.assertEquals("Failed", merchantName, actualMerchant.getName());
    }

    @Test
    public void getTotalSpendMethodWorks() {
        Assert.assertEquals("Failed", 0.0, merchantScore.getTotalSpend(), 0.1);
    }

    @Test
    public void getTotalVisitsMethodWorks() {
        Assert.assertEquals("Failed", 0, merchantScore.getTotalVisits());
    }

    @Test
    public void addMethodWorks() {
        merchantScore.add(2.2);
        merchantScore.add(2.2);
        Assert.assertEquals("Failed", 4.4, merchantScore.getTotalSpend(), 0.1);
        Assert.assertEquals("Failed", 2, merchantScore.getTotalVisits());
    }
}
