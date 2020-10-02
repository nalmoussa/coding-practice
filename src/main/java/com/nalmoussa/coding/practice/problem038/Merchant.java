package com.nalmoussa.coding.practice.problem038;

public class Merchant {
    /** member var to store the id of the merchant */
    private int mId;

    /** member var to track the name of this particular merchant. This is considered immutable. */
    private String mName;

    /** returns to the caller the id for this merchant
     * @return - ID for this particular merchant.
     */
    public int getId() {
        return mId;
    }

    /**
     * Returns to the caller the name of the merchant e.g. Macy's
     * @return - String representation of the merchant name.
     */
    public String getName() {
        return mName;
    }

    /**
     * ctor for merchants within this system.
     * @param merchantId - Id of the merchant. NOTE: Caller to ensure uniqueness.
     * @param name - The name of the merchant.
     */
    public Merchant(int merchantId, String name) {
        mId = merchantId;
        mName = name;
    }
}