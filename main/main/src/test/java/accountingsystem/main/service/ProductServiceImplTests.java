package accountingsystem.main.service;

import accountingsystem.main.model.Manufacturer;
import accountingsystem.main.model.Product;
import accountingsystem.main.repository.ProductRepository;
import accountingsystem.main.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTests {

  @Mock ProductRepository productRepository;

  @InjectMocks ProductServiceImpl productService;

  @Test
  public void getAllProductsTest() {
    List<Product> products = new ArrayList<Product>();
    // given
    // we define some products with their manufacturers
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

    // we add them to the products list
    products.add(product);
    products.add(product1);
    products.add(product2);

    // when
    when(productRepository.findAll()).thenReturn(products);

    // test
    List<Product> proList = productService.findAll();
    Assert.assertEquals(3, proList.size());
    verify(productRepository, times(1)).findAll();
  }

  @Test
  public void deleteProductByIdTest() {

    // given
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");

    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Long productId = product.getId();

    when(productRepository.findById(productId))
        .thenReturn(java.util.Optional.of(product))
        .thenReturn(null);

    productService.deleteById(productId);

    // test
    verify(productRepository).deleteById(productId);
  }

  @Test
  public void getProductByIdTest() {

    // creating Product
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    Long productId = product.getId();

    // when
    when(productRepository.findById(productId)).thenReturn(java.util.Optional.of(product));

    Product product1 = productService.findById(productId);

    // test
    Assert.assertEquals("productDescription", product1.getDescription());
    Assert.assertEquals("productName", product1.getName());
    Assert.assertEquals(150l, product1.getPrice().longValue());
    Assert.assertEquals(manufacturer, product1.getManufacturer());
  }

  @Test
  public void createProductTest() {

    // given
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());

    // when
    when(productRepository.save(any(Product.class))).thenReturn(product);

    Product createdProduct = productService.save(product);

    Assert.assertFalse(createdProduct.getName().isEmpty());

    Assert.assertEquals("productDescription", createdProduct.getDescription());

    Assert.assertEquals(150l, createdProduct.getPrice().longValue());
  }

  @Test
  public void findByNameLikeTest3() {

    String name = "product";

    List<Product> products = new ArrayList<Product>();
    // given
    // we define some products with their manufacturers
    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");

    Product product =
        new Product(
            "productDescription",
            "productName",
            manufacturer,
            151l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product1 =
        new Product(
            "productDescription1",
            "productName1",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product2 =
        new Product(
            "productDescription2",
            "productName2",
            manufacturer,
            152l,
            LocalDateTime.now(),
            LocalDateTime.now());

    // we add them to the products list
    products.add(product);
    products.add(product1);
    products.add(product2);

    // when
    when(productRepository.findByNameLike(name)).thenReturn(products);

    List<Product> expectedProducts = productService.findByNameLike(name);

    // test
    Assert.assertEquals(3, expectedProducts.size());
    verify(productRepository, times(1)).findByNameLike(name);
  }
}
