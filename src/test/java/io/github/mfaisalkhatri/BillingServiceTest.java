package io.github.mfaisalkhatri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName ("Generate Bill Tests")
@TestMethodOrder (OrderAnnotation.class)
public class BillingServiceTest {

    private BillingService billingService;

    @BeforeEach
    void setUp () {
        billingService = new BillingService ();
    }

    @Test
    @DisplayName ("Discount Calculation Test")
    @Order (1)
    void testShouldCalculateDiscount () {
        double discount = billingService.discount (1000, 10);
        assertEquals (100, discount);
    }

    @Test
    @DisplayName ("Test for Zero Discount calculation")
    @Order (2)
    void testShouldCalculateTotalBillAmountAfterDiscount () {
        double discount = billingService.discount (5000, 0);
        assertEquals (0, discount);
    }

    @Nested
    class TotalBillAmountTests {
        @Test
        @Order (4)
        @DisplayName ("Test to calculate total bill amount after discount")
        void testShouldCalculteTotalBillAmount () {
            double totalBillAmount = billingService.totalBillAmount (5000, 20);
            assertEquals (4000, totalBillAmount);
        }

        @Test
        @Order (3)
        @DisplayName ("Test to Calculate total bill amount when discount is zero")
        void testShouldCalculateTotalBillWithZeroDiscount () {
            double totalBillAmount = billingService.totalBillAmount (7999, 0);
            assertEquals (7999, totalBillAmount);
        }
    }
}