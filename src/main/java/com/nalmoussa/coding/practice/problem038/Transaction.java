package com.nalmoussa.coding.practice.problem038;

import java.util.UUID;

public class Transaction {
    /** Merchant where the transaction took place */
    private Merchant mMerchant;

    /** amount of the transaction */
    private double mTransactionAmount;

    /** type of transaction this was for the customer */
    private TransactionType mType;

    /** the customer who executed this transaction. */
    private int mCustomerId;

    /** Unique ID of the transaction within the system */
    private UUID mTxId = UUID.randomUUID();

    /**
     * Returns to the caller the Merchant where this transaction took place.
     *
     * @return Merchant object instance.
     */
    public Merchant getMerchant() {
        return mMerchant;
    }

    /**
     * Returns to the caller the type of transaction that took place e.g. debit or credit
     *
     * @return - TransactionType enum instance representing the type of transaction.
     */
    public TransactionType getTransactionType() {
        return mType;
    }

    /**
     * Returns to the caller the id of the customer who performed this transaction.
     *
     * @return - int representing the customer id.
     */
    public int getCustomerId() {
        return mCustomerId;
    }

    /**
     * Returns to the caller the unique id of the transaction.
     *
     * @return UUID representing the transaction.
     */
    public UUID getTransactionId() {
        return mTxId;
    }

    /**
     * Returns to the caller the amount of the transaction that took place.
     *
     * @return - The dollar amount that was credited or debited as a result of this transaction.
     */
    public double getTransactionAmount() {
        return mTransactionAmount;
    }

    /**
     * ctor for a Transaction object. This is used to represent a financial transaction within the system capturing
     * all of the important aspects of the transaction itself.
     * @param customerId - The customer who executed this transaction.
     * @param merchant - The merchant where the transaction took place.
     * @param amount - The amount of the transaction.
     * @param txType - The type of transaction this is (Debit, Credit).
     */
    public Transaction(int customerId, Merchant merchant, double amount, TransactionType txType) {
        mCustomerId = customerId;
        mMerchant = merchant;
        mTransactionAmount = amount;
        mType = txType;
    }
}