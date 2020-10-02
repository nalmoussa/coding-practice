package com.nalmoussa.coding.practice.problem038;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MerchantComparatorTest {
    private MerchantScore merchantScore1, merchantScore2;

    @Before
    public void init() {
        Merchant merchant = new Merchant(1, "Mock Merchant");
        merchantScore1 = new MerchantScore(merchant);
        merchantScore2 = new MerchantScore(merchant);
    }

    @Test
    public void comparingBySpendWorksWhenScore1GreaterThanScore2() {
        merchantScore1.add(4.4);
        merchantScore2.add(2.2);

        MerchantComparator comparator = new MerchantComparator(MerchantReportType.BySpend);
        int actual = comparator.compare(merchantScore1, merchantScore2);
        Assert.assertEquals("Failed", -1, actual);
    }

    @Test
    public void comparingBySpendWorksWhenScore1LessThanScore2() {
        merchantScore1.add(2.2);
        merchantScore2.add(4.4);

        MerchantComparator comparator = new MerchantComparator(MerchantReportType.BySpend);
        int actual = comparator.compare(merchantScore1, merchantScore2);
        Assert.assertEquals("Failed", 1, actual);
    }

    @Test
    public void comparingBySpendWorksWhenScore1IsEqualToScore2() {
        merchantScore1.add(2.2);
        merchantScore2.add(2.2);

        MerchantComparator comparator = new MerchantComparator(MerchantReportType.BySpend);
        int actual = comparator.compare(merchantScore1, merchantScore2);
        Assert.assertEquals("Failed", 0, actual);
    }

    @Test
    public void comparingByVisitsWorksWhenScore1GreaterThanScore2() {
        merchantScore1.add(2.2);
        merchantScore1.add(2.2);
        merchantScore2.add(4.4);

        MerchantComparator comparator = new MerchantComparator(MerchantReportType.ByVisits);
        int actual = comparator.compare(merchantScore1, merchantScore2);
        Assert.assertEquals("Failed", -1, actual);
    }

    @Test
    public void comparingByVisitsWorksWhenScore1LessThanScore2() {
        merchantScore1.add(4.4);
        merchantScore2.add(2.2);
        merchantScore2.add(2.2);

        MerchantComparator comparator = new MerchantComparator(MerchantReportType.ByVisits);
        int actual = comparator.compare(merchantScore1, merchantScore2);
        Assert.assertEquals("Failed", 1, actual);
    }

    @Test
    public void comparingByVisitsWorksWhenScore1IsEqualToScore2() {
        merchantScore1.add(2.2);
        merchantScore2.add(4.4);

        MerchantComparator comparator = new MerchantComparator(MerchantReportType.ByVisits);
        int actual = comparator.compare(merchantScore1, merchantScore2);
        Assert.assertEquals("Failed", 0, actual);
    }
}
