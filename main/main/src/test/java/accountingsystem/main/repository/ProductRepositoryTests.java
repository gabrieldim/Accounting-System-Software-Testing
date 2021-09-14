package accountingsystem.main.repository;

import accountingsystem.main.model.Manufacturer;
import accountingsystem.main.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ProductRepositoryTests {

  @Autowired public ProductRepository productRepository;

  @Test
  public void saveProductTest() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Long productId = this.productRepository.save(product).getId();
    Product product1 = this.productRepository.findById(productId).get();

    Assert.assertNotNull(product);
    Assert.assertEquals(product.getPrice(), product1.getPrice());
    Assert.assertEquals(product.getDate(), product1.getDate());
    Assert.assertEquals(product.getDescription(), product1.getDescription());
    Assert.assertEquals(product.getExpirationDate(), product1.getExpirationDate());
    Assert.assertEquals(product.getId(), product1.getId());
    Assert.assertEquals(product.getProcurementPrice(), product1.getProcurementPrice());
    Assert.assertEquals(product.getName(), product1.getName());
    Assert.assertEquals(product.getProfit(), product1.getProfit());
  }

  @Test
  public void deleteProductTest() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Long productId = this.productRepository.save(product).getId();
    this.productRepository.deleteById(productId);

    Assert.assertThrows(
        NoSuchElementException.class,
        () -> {
          this.productRepository.findById(productId).get();
        });
  }

  @Test
  public void findAllProductsTest() {
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Manufacturer manufacturer1 = new Manufacturer("TestUser", "MKD");
    Product product1 =
        new Product(
            "productDescription",
            "productName",
            manufacturer1,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Manufacturer manufacturer2 = new Manufacturer("TestUser", "MKD");
    Product product2 =
        new Product(
            "productDescription",
            "productName",
            manufacturer2,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    this.productRepository.save(product);
    this.productRepository.save(product1);
    this.productRepository.save(product2);

    Assert.assertNotNull(this.productRepository.findAll());
    Assert.assertEquals(3, this.productRepository.findAll().stream().count());
  }
}
