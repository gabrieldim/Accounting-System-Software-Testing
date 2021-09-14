package accountingsystem.main.controllers.test;

import accountingsystem.main.model.Manufacturer;
import accountingsystem.main.model.Product;
import accountingsystem.main.repository.ProductRepository;
import accountingsystem.main.service.ManufacturerService;
import accountingsystem.main.service.ProductService;
import accountingsystem.main.web.api.RestProductController;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @RunWith(MockitoJUnitRunner.class)
@WebMvcTest(RestProductController.class)
@RunWith(SpringRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ProductRestTest {

  /*
      @Autowired
      private ObjectMapper objectMapper;
  */
  @MockBean private ProductService productService;

  @MockBean private ManufacturerService manufacturerService;

  @Autowired private WebApplicationContext webApplicationContext;

  @Autowired public ProductRepository productRepository;

  @Autowired private MockMvc mockMvc;

  /*  @BeforeEach
  void setMockMvc(){
      this.mockMvc = MockMvcBuilders.standaloneSetup(new RestProductController(null,null,null)).build();
  }*/

  @Test
  public void Testtest() {
    assertNotNull(mockMvc);
  }

  @Test
  public void Test() throws Exception {

    Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");
    Product product1 =
        new Product(
            "productDescription",
            "productName1",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product2 =
        new Product(
            "productDescription",
            "productName2",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    Product product3 =
        new Product(
            "productDescription",
            "productName3",
            manufacturer,
            150l,
            LocalDateTime.now(),
            LocalDateTime.now());
    productRepository.save(product1);
    productRepository.save(product2);
    productRepository.save(product3);

    List<Product> listproducts = new ArrayList<Product>();
    listproducts.add(product1);
    listproducts.add(product2);
    listproducts.add(product3);
    Mockito.when(productRepository.findAll()).thenReturn(listproducts);
    String url = "/api/product/getAllProducts";

    mockMvc
        .perform(get("http://localhost:8080/api/product/getAllProducts"))
        .andExpect(status().isOk());
  }
}
