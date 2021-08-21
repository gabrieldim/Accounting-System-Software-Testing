package accountingsystem.main.repository;

import accountingsystem.main.model.Manufacturer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ManufacturerRepositoryTests {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Test
    public void saveManufacturerTest(){
        Manufacturer manufacturer = new Manufacturer("TestUser","MKD");
        Long manufacturerId = this.manufacturerRepository.save(manufacturer).getId();
        Manufacturer manufacturer1 = this.manufacturerRepository.findById(manufacturerId).get();

        Assert.assertNotNull(manufacturer);
        Assert.assertEquals(manufacturer.getId(),manufacturer1.getId());
        Assert.assertEquals(manufacturer.getCountry(),manufacturer1.getCountry());
        Assert.assertEquals(manufacturer.getName(),manufacturer1.getName());

    }

    @Test
    public void deleteManufacturerTest(){
        Manufacturer manufacturer = new Manufacturer("TestUser","USA");
        Long manufacturerId = this.manufacturerRepository.save(manufacturer).getId();
        this.manufacturerRepository.deleteById(manufacturerId);

        Assert.assertThrows(NoSuchElementException.class, () -> {
            this.manufacturerRepository.findById(manufacturerId).get();
        });

    }

    @Test
    public void findAllManufacturersTest(){
        Manufacturer manufacturer = new Manufacturer("TestUser","USA");
        Manufacturer manufacturer1 = new Manufacturer("TestUser","SRB");
        Manufacturer manufacturer2 = new Manufacturer("TestUser","RS");

        this.manufacturerRepository.save(manufacturer);
        this.manufacturerRepository.save(manufacturer1);
        this.manufacturerRepository.save(manufacturer2);

        Assert.assertNotNull(this.manufacturerRepository.findAll());
        Assert.assertEquals(3,this.manufacturerRepository.findAll().stream().count());

    }



}
