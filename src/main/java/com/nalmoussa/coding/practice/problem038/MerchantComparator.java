package com.nalmoussa.coding.practice.problem038;

import java.util.Comparator;

public class MerchantComparator implements Comparator<Object> {
    private final MerchantReportType reportType;

    public MerchantComparator(MerchantReportType reportType) {
        this.reportType = reportType;
    }

    @Override
    public int compare(Object o1, Object o2) {
        MerchantScore merchantScore1 = (MerchantScore)o1;
        MerchantScore merchantScore2 = (MerchantScore)o2;

        double diff;
        if (MerchantReportType.BySpend == this.reportType) {
            diff = merchantScore1.getTotalSpend() - merchantScore2.getTotalSpend();
        } else {
            diff = merchantScore1.getTotalVisits() - merchantScore2.getTotalVisits();
        }

        if (diff == 0.0) {
            return 0;
        } else {
            return (int)(-diff / Math.abs(diff));
        }
    }
}
