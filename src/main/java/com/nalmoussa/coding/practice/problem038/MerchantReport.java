package com.nalmoussa.coding.practice.problem038;

import java.util.*;

public class MerchantReport {
    private Map<Integer, MerchantScore> merchantScoreMap;

    public MerchantReport() {
        merchantScoreMap = new Hashtable<>();
    }

    public MerchantScore update(Merchant merchant, double amount) {
        int merchantId = merchant.getId();
        MerchantScore merchantScore = this.merchantScoreMap.get(merchantId);
        if (merchantScore == null) {
            merchantScore = new MerchantScore(merchant);
        }
        merchantScore.add(amount);
        this.merchantScoreMap.put(merchantId, merchantScore);
        return merchantScore;
    }

    public List<Merchant> get(MerchantComparator comparator, int count) {
        PriorityQueue<MerchantScore> sortedMerchant = new PriorityQueue<>(comparator);
        sortedMerchant.addAll(this.merchantScoreMap.values());

        int length = Math.min(count, sortedMerchant.size());
        List<Merchant> result = new ArrayList<>();
        for (int index = 0; index < length; index++) {
            result.add(Objects.requireNonNull(sortedMerchant.poll()).getMerchant());
        }
        return result;
    }
}
