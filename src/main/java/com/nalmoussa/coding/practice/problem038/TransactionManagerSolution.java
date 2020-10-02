package com.nalmoussa.coding.practice.problem038;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class TransactionManagerSolution implements TransactionManager {
    Map<Integer, MerchantReport> merchantReportByCustomer = new Hashtable<>();

    public TransactionManagerSolution() {
        super();
    }

    private void UpdateMerchantReport(int customerId, Merchant merchant, double amount) {
        MerchantReport merchantReport = this.merchantReportByCustomer.get(customerId);
        if (merchantReport == null) {
            merchantReport = new MerchantReport();
            this.merchantReportByCustomer.put(customerId, merchantReport);
        }
        merchantReport.update(merchant, amount);
    }

    private void validateArguments(Merchant merchant, double amount)
            throws InvalidTransactionException {
        if (merchant == null) {
            throw new IllegalArgumentException("Invalid merchant: merchant can not be null");
        }

        if (merchant.getName() == null || merchant.getName().isEmpty()) {
            throw new IllegalArgumentException("Invalid Merchant: Merchant's name can not be null or empty");
        }

        if (amount <= 0.0) {
            throw new InvalidTransactionException("Invalid Amount: Amount must be bigger than zero");
        }
    }

    public Transaction transact(int customerId, Merchant merchant, double amount)
            throws InvalidTransactionException {
        validateArguments(merchant, amount);
        UpdateMerchantReport(customerId, merchant, amount);
        return new Transaction(customerId, merchant, amount, TransactionType.Debit);
    }

    public Transaction credit(int customerId, Merchant merchant, double amount)
            throws InvalidTransactionException {
        validateArguments(merchant, amount);
        UpdateMerchantReport(customerId, merchant, amount);
        return new Transaction(customerId, merchant, amount, TransactionType.Credit);
    }

    public List<Merchant> getMerchantReportByCustomer(int customerId, MerchantReportType reportType, int count) {
        MerchantReport merchantReport = this.merchantReportByCustomer.get(customerId);
        MerchantComparator comparator = new MerchantComparator(reportType);
        return merchantReport.get(comparator, count);
    }
}