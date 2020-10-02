# Implementation of TransactionManager

This is an attempt to implement the `TransactionManager` interface with as little
memory as possible while not sacrificing performance. We introduced the following
classes to achieve this implementation:

* **MerchantComparator**: Implements `Comparator` interface and used to sort merchant list
* **MerchantReport**: Manages all merchants visited by a given customer
* **MerchantScore**: Stores total visits/spend by a given customer at a given merchant

### Time complexity

Assuming _n_ is the average number of merchants visited by a customer:

* `TransactionManager.transact`: O(1)
* `TransactionManager.credit`: O(1)
* `TransactionManager.getMerchantReportByCustomer`: O(_n.log(n)_)

In theory and in the worst case scenario, a customer can visit all merchants. In reality,
a customer would visit a relatively small number of merchants, I imagine less than 1000.
Moreover, I imagine the number of transactions (whether debit or credit) is way higher
than the number of requested reports. Therefore, the above time complexities meet our performance
requirement.

### Space complexity

The data structure we use here is a **Hashtable** (`TransactionManagerSolution.merchantReportByCustomer`)
where the key is `customerId`, and the value is another **Hashtable** (`MerchantReport.merchantScoreMap`),
where the key is `merchantId`, and the value is object of `MerchantScore`. Assuming _m_ is the number of customers
managed in our application and _n_ is the average number of merchants visited by a customer, 

The space complexity is: O(n.m)

> Note: In this implementation, we include merchant objects inside MerchantScore. In reality Merchant class can hold
> more details than simply the id and name of the merchant. To save even more memory, we could remove the actual
> merchant object from MerchantScore and rely on the key (merchantId) of `merchantScoreMap` hashtable to lookup the 
> merchant from a lookup merchant map (say `merchantMap`)

### Unit Tests

In addition to the tests inside `TransactionManagerSolutionTest`, we introduce the following test classes:

* `MerchantComparatorTest`
* `MerchantReportTest`
* `MerchantScoreTest`

All unit tests pass successfully.