package com.nalmoussa.coding.practice.problem038;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TransactionManagerSolutionTest {
    private final Merchant[] mGoodMerchants = {
            new Merchant(1, "Costco"),
            new Merchant(2, "Barell Drugs"),
            new Merchant(3, "Safeway"),
            new Merchant(4, "McDonalds"),
            new Merchant(5, "TacoTime"),
            new Merchant(6, "Subway"),
            new Merchant(7, "Flying Pie Pizza"),
            new Merchant(8, "Issaquah Shell"),
            new Merchant(9, "Fred Meyer"),
            new Merchant(10, "Jak's Grill")
    };
    private TransactionManagerSolution mTxMgr;

    @Before
    public void resetTest() {

        // Create a new instance of the transaction manager in-between tests to ensure that we don't have any
        // data pollution between test cases.
        mTxMgr = new TransactionManagerSolution();
    }

    @Test
    public void simpleTransactionTests() throws InvalidTransactionException {

        Merchant[] badMerchants = {
                new Merchant(1, null),
                new Merchant(1, ""),
        };

        // First try to see if invalid merchants are handled properly.
        for(Merchant currentMerchant : badMerchants) {

            try {
                mTxMgr.transact(1, currentMerchant, 1.00);
                Assert.fail("Didn't receive expected exception for a invalid merchant definition");

            }catch(IllegalArgumentException | InvalidTransactionException ex) {
                // expected exception
            }
        }

        // try a simple transaction to make sure the basics work.
        mTxMgr.transact(1, mGoodMerchants[0], 1.00);

        double[] badTxAmounts = { -1.0, 0.00};
        for(int index=0;index<2;index++) {

            // First try a debit.
            try {

                mTxMgr.transact(1, mGoodMerchants[index], badTxAmounts[index]);
                Assert.fail("Failed ot receive InvalidTransactionException for a invalid transaction");

            } catch (InvalidTransactionException ex) {
                // expected exception
            }

            // Then attempt a basic credit.
            try {

                mTxMgr.credit(1, mGoodMerchants[index], badTxAmounts[index]);
                Assert.fail("Failed ot receive InvalidTransactionException for a invalid transaction");

            } catch (InvalidTransactionException ex) {
                // expected exception
            }
        }
    }

    @Test
    public void testDebitTransactions() throws InvalidTransactionException {
        double[] txAmounts = { 1.00, .50, .25};

        for(int index=0;index<3;index++) {
            mTxMgr.transact(1, mGoodMerchants[index], txAmounts[index]);
        }

        List<Merchant> topMerchantBySpend = mTxMgr.getMerchantReportByCustomer(1,
                MerchantReportType.BySpend, 1);

        Assert.assertEquals("Invalid number of merchannts returned", 1, topMerchantBySpend.size());

        Merchant theMerchant = topMerchantBySpend.get(0);
        Assert.assertEquals("Unexpected top merchant", theMerchant, mGoodMerchants[0]);
    }

    @Test
    public void testCreditTransactions() throws InvalidTransactionException {

        mTxMgr.transact(1, mGoodMerchants[0], 5.00);
        mTxMgr.credit(1, mGoodMerchants[0], 3.00);
        mTxMgr.transact(1, mGoodMerchants[1], 5.00);

        List<Merchant> topMerchantBySpend = mTxMgr.getMerchantReportByCustomer(1,
                MerchantReportType.BySpend, 1);

        Assert.assertEquals("Invalid number of merchannts returned", 1, topMerchantBySpend.size());

        Merchant theMerchant = topMerchantBySpend.get(0);
        Assert.assertEquals("Unexpected top merchant", theMerchant, mGoodMerchants[0]);
    }

    @Test
    public void testMerchantVisitReport() throws InvalidTransactionException {

        mTxMgr.transact(1, mGoodMerchants[0], 5.00);
        mTxMgr.credit(1, mGoodMerchants[0], 3.00);
        mTxMgr.transact(1, mGoodMerchants[1], 5.00);

        List<Merchant> topMerchantByVisits = mTxMgr.getMerchantReportByCustomer(1,
                MerchantReportType.ByVisits, 2);

        int index=0;
        for(Merchant currentMerchant : topMerchantByVisits) {
            Assert.assertEquals("unexpected ordering of merchants by visit", currentMerchant, mGoodMerchants[index]);
            index++;
        }

    }

    @Test
    public void testMerchantSpendReport() throws InvalidTransactionException {

        mTxMgr.transact(1, mGoodMerchants[0], 5.00);
        mTxMgr.transact(1, mGoodMerchants[0], 3.00);
        mTxMgr.transact(1, mGoodMerchants[1], 5.00);
        mTxMgr.transact(2, mGoodMerchants[1], 15.00);

        List<Merchant> topMerchantBySpend = mTxMgr.getMerchantReportByCustomer(1,
                MerchantReportType.BySpend, 2);

        int index=0;
        for(Merchant currentMerchant : topMerchantBySpend) {
            Assert.assertEquals("unexpected ordering of merchants by spend", currentMerchant, mGoodMerchants[index]);
            index++;
        }
    }
}
