package tudelft.discount;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DiscountApplierTest {

    @Test
    public void basicTest()
    {
        MyProductDao myProductDao = new MyProductDao();
        DiscountApplier discountApplier = new DiscountApplier(myProductDao);
        discountApplier.setNewPrices();
        for (Product product : myProductDao.all())
        {
            if (product.getCategory().equals("BUSINESS"))
                Assertions.assertEquals(product.getPrice(), 110.0, 0.0001);
            if (product.getCategory().equals("HOME"))
                Assertions.assertEquals(product.getPrice(), 90.0, 0.0001);
            if (product.getCategory().equals("OTHER"))
                Assertions.assertEquals(product.getPrice(), 100.0, 0.0001);
        }
    }

    private class MyProductDao implements ProductDao
    {
        private List<Product> products;

        public List<Product> all()
        {
            if (products == null)
            {
                products = new ArrayList<>();
                products.add(new Product("widget1", 100.0, "HOME"));
                products.add(new Product("widget2", 100.0, "BUSINESS"));
                products.add(new Product("widget3", 100.0, "OTHER"));
            }
            return products;
        }
    }
}
