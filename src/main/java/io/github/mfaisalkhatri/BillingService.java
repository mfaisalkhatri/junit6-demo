package io.github.mfaisalkhatri;

public class BillingService {

    public double discount (double grossAmount, double discountPercentage) {
        return grossAmount * discountPercentage / 100;
    }

    public double totalBillAmount (double grossAmount, double discountPercentage) {
        return grossAmount - discount (grossAmount, discountPercentage);
    }
}