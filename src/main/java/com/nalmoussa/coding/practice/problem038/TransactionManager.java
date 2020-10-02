package com.nalmoussa.coding.practice.problem038;

import java.util.List;

/**
 * Class used to transactions that take place for a customer. Provides basic reporting capabilities as well.
 */
public interface TransactionManager {
    /**
     * This method is used to perform a debit type transaction with the transaction manager. It will return to the caller
     * a transaction object which contains all of the needed information to represent what transpired.
     *
     * @param customerId - ID of the customer
     * @param merchant - Reference to the Merchant object e.g. where the transaction took place.
     * @param amount - The amount of the transaction taking place expressed in positive numbers.
     * @return Transaction object recording all of the information about the transaction.
     * @throws IllegalArgumentException - Thrown in the case when invalid parameters are provided.
     * @throws InvalidTransactionException - Thrown in the case where abnormalities are found e.g. invalid amount or
     * an invalid merchant object is provided.
     */
    Transaction transact(int customerId, Merchant merchant, double amount)
            throws IllegalArgumentException, InvalidTransactionException;

    /**
     * This method is used to perform a credit type transaction with the transaction manager. It will return to the caller
     * a transaction object which contains all of the needed information to represent what transpired.
     *
     * @param customerId - ID of the customer
     * @param merchant - Reference to the Merchant object e.g. where the transaction took place.
     * @param amount - The amount to credit for this particular transaction; expressed in positive numbers.
     * @return Transaction object recording all of the information about the transaction.
     * @throws IllegalArgumentException - Thrown in the case when invalid parameters are provided.
     * @throws InvalidTransactionException - Thrown in the case where abnormalities are found e.g. invalid amount or
     * an invalid merchant object is provided.
     */
    Transaction credit(int customerId, Merchant merchant, double amount)
            throws IllegalArgumentException, InvalidTransactionException;

    /**
     * Returns to the caller a customer specific report of spending activity.
     *
     * @param customerId - The ID of the customer to report on.
     * @param reportType - The type of report to generate e.g. report by spending or by number of visits.
     * @param count - The # of entries (or depth) that the caller would like to go in the report
     * @return - The list of merchants frequented by the customer specified ordered according to the reportType chosen.
     * @throws IllegalArgumentException - Thrown when the provided arguments are not valid.
     */
    List<Merchant> getMerchantReportByCustomer(int customerId, MerchantReportType reportType, int count)
            throws IllegalArgumentException;
}