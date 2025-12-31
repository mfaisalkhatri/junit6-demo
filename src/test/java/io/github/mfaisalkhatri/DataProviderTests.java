package io.github.mfaisalkhatri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName ("Generate Bill Tests from CSV Source")
class DataProviderTests {

    private BillingService billingService;

    @BeforeEach
    void setUp () {
        billingService = new BillingService ();
    }

    @ParameterizedTest (name = "[{index}] = grossAmt={0}, discountPercentage={1}, totalAmt= {2}")
    @CsvSource ({ "100,10,90", "7899,0,7899", "4512.50,2,4422.25" })
    void testBillFromCsv (double grossAmount, double discountPercent, double totalBill) {
        assertEquals (totalBill, billingService.totalBillAmount (grossAmount, discountPercent));
    }

    @ParameterizedTest (name = "[{index}] = grossAmt={0}, discountPercentage={1}, totalAmt= {2}")
    @CsvFileSource (resources = "/billing-test-data.csv", numLinesToSkip = 1)
    void testBillFromCsvFile (double grossAmount, double discountPercent, double totalBill) {
        assertEquals (totalBill, billingService.totalBillAmount (grossAmount, discountPercent));
    }
}