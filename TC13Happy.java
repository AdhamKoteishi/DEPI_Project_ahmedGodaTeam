package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.CartPage;

public class TC13 extends BaseTest {

    @Test
    public void verifyCorrectQuantityAddedToCart() throws InterruptedException {

        HomePage home = new HomePage(driver);
        ProductDetailsPage details = new ProductDetailsPage(driver);
        CartPage cart = new CartPage(driver);

        Assert.assertTrue(home.isHomePageVisible());

        home.clickFirstProductView();
        Assert.assertTrue(details.isProductDetailsVisible());

        details.setProductQuantity(4);
        details.clickAddToCartButton();
        details.clickViewCartButton();

        Thread.sleep(2000);

        Assert.assertEquals(cart.getCartProductQuantity(), "4");
    }
}
