package com.nalmoussa.coding.practice.problem038;

/**
 * This exception class represents an invalid transaction that was attempted with the TransactionManager.
 */
public class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String msg) {
        super(msg);
    }
}