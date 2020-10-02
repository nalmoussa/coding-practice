package com.nalmoussa.coding.practice.problem010;

import java.util.concurrent.Callable;

class LargeNumberMultiplier implements Callable<LargeNumber> {
  private final LargeNumber largeNumber;
  private final int multiplier;
  private final int powerOfTen;

  LargeNumberMultiplier(LargeNumber largeNumber, int multiplier, int powerOfTen) {
    this.largeNumber = largeNumber;
    this.multiplier = multiplier;
    this.powerOfTen = powerOfTen;
  }

  @Override
  public LargeNumber call() {
    return largeNumber.multiply(multiplier).multiplyByPowerOfTen(powerOfTen);
  }
}
