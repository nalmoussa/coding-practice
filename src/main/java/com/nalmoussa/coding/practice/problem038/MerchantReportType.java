package com.nalmoussa.coding.practice.problem038;

/**
 * This enum captures each of the report types that can be fulfilled by the transaction manager.
 *
 * BySpend - The top merchants by the amount of money spent at each of the merchants.
 * ByVisits - The top merchants by the number of times that merchant is visited by a customer.
 */
public enum MerchantReportType {
    BySpend,
    ByVisits
}