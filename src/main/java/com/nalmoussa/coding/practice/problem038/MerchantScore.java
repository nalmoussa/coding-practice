package com.nalmoussa.coding.practice.problem038;

public class MerchantScore {
    private final Merchant merchant;
    private double totalSpend;
    private int totalVisits;

    public MerchantScore(Merchant merchant) {
        this.merchant = merchant;
        this.totalSpend = 0.0;
        this.totalVisits = 0;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public double getTotalSpend() {
        return totalSpend;
    }

    public int getTotalVisits() {
        return totalVisits;
    }

    public void add(double amount) {
        this.totalSpend += amount;
        this.totalVisits++;
    }
}
