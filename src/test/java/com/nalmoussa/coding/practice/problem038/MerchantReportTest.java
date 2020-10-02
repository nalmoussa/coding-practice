package com.nalmoussa.coding.practice.problem038;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MerchantReportTest {
    private Merchant merchant1, merchant2;
    private MerchantReport merchantReport;

    @Before
    public void init() {
        merchant1 = new Merchant(1, "Mock Merchant 1");
        merchant2 = new Merchant(2, "Mock Merchant 2");
        merchantReport = new MerchantReport();
    }

    @Test
    public void updateMethodWorksWhenMerchantReportIsEmpty() {
        MerchantScore merchantScore = merchantReport.update(merchant1, 2.2);

        Assert.assertEquals("Failed", merchant1, merchantScore.getMerchant());
        Assert.assertEquals("Failed", 2.2, merchantScore.getTotalSpend(), 0.1);
        Assert.assertEquals("Failed", 1, merchantScore.getTotalVisits());
    }

    @Test
    public void updateMethodWorksWhenCalledRepeatedly() {
        merchantReport.update(merchant1, 2.2);
        MerchantScore merchantScore = merchantReport.update(merchant1, 2.2);

        Assert.assertEquals("Failed", merchant1, merchantScore.getMerchant());
        Assert.assertEquals("Failed", 4.4, merchantScore.getTotalSpend(), 0.1);
        Assert.assertEquals("Failed", 2, merchantScore.getTotalVisits());
    }

    @Test
    public void getMethodReturnsEmptyListWhenMerchantReportIsEmpty() {
        MerchantComparator merchantComparator = new MerchantComparator(MerchantReportType.BySpend);
        List<Merchant> merchantList = merchantReport.get(merchantComparator, 1);

        Assert.assertEquals("Failed", 0, merchantList.size());
    }

    @Test
    public void getMethodRespectsCountArgument() {
        merchantReport.update(merchant1, 2.2);
        merchantReport.update(merchant2, 4.4);
        MerchantComparator merchantComparator = new MerchantComparator(MerchantReportType.BySpend);

        // Even though the customer visited two merchants, get method returns
        // only 1 result since count is 1
        List<Merchant> merchantList = merchantReport.get(merchantComparator, 1);
        Assert.assertEquals("Failed", 1, merchantList.size());
        Assert.assertEquals("Failed", merchant2, merchantList.get(0));

        // Even though the caller asks for 10 results, get method returns
        // only 2 results, since the customers visited only two merchants
        merchantList = merchantReport.get(merchantComparator, 10);
        Assert.assertEquals("Failed", 2, merchantList.size());

        // Even though the customer visits both merchants once (same number of visits),
        // get method returns only one of the two merchants since count is 1
        merchantComparator = new MerchantComparator(MerchantReportType.ByVisits);
        merchantList = merchantReport.get(merchantComparator, 1);
        Assert.assertEquals("Failed", 1, merchantList.size());
    }

    @Test
    public void getMethodReturnsMerchantsSorted() {
        merchantReport.update(merchant1, 4.4);
        merchantReport.update(merchant2, 1.1);
        merchantReport.update(merchant2, 1.1);
        MerchantComparator merchantComparator = new MerchantComparator(MerchantReportType.BySpend);
        List<Merchant> merchantList = merchantReport.get(merchantComparator, 2);

        Assert.assertEquals("Failed", merchant1, merchantList.get(0));
        Assert.assertEquals("Failed", merchant2, merchantList.get(1));

        merchantComparator = new MerchantComparator(MerchantReportType.ByVisits);
        merchantList = merchantReport.get(merchantComparator, 2);

        Assert.assertEquals("Failed", merchant2, merchantList.get(0));
        Assert.assertEquals("Failed", merchant1, merchantList.get(1));
    }

    @Test
    public void getMethodReturnsAllMerchantsWithIdenticalScores() {
        merchantReport.update(merchant1, 2.2);
        merchantReport.update(merchant2, 2.2);
        MerchantComparator merchantComparator = new MerchantComparator(MerchantReportType.BySpend);
        List<Merchant> merchantList = merchantReport.get(merchantComparator, 2);

        Assert.assertTrue("Failed", merchantList.contains(merchant1));
        Assert.assertTrue("Failed", merchantList.contains(merchant2));
    }
}
