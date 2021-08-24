package accountingsystem.main.service;

import accountingsystem.main.model.Manufacturer;
import accountingsystem.main.repository.ManufacturerRepository;
import accountingsystem.main.service.impl.ManufacturerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ManufacturerServiceImplTests {

    @InjectMocks
    ManufacturerServiceImpl manufacturerService;

    @Mock
    ManufacturerRepository manufacturerRepository;

    @Test
    public void getAllManufacturersTest() {
        List<Manufacturer> list = new ArrayList<Manufacturer>();
        //we define some manufacturers
        Manufacturer manufacturer = new Manufacturer("TestUser", "USA");
        Manufacturer manufacturer1 = new Manufacturer("TestUser", "SRB");
        Manufacturer manufacturer2 = new Manufacturer("TestUser", "RS");
        //we add them in predefined list
        list.add(manufacturer);
        list.add(manufacturer1);
        list.add(manufacturer2);

        when(manufacturerRepository.findAll()).thenReturn(list);

        //test
        List<Manufacturer> manList = manufacturerService.findAll();
        Assert.assertEquals(3, manList.size());
        verify(manufacturerRepository, times(1)).findAll();


    }

    @Test
    public void getManufacturerByIdTest() {

        //creating Manufacturer
        Manufacturer manufacturer = new Manufacturer("TestUser", "MKD");

        Long manufacturerId = manufacturer.getId();

        when(manufacturerRepository.findById(manufacturerId)).thenReturn(java.util.Optional.of(manufacturer));

        Manufacturer manufacturer1 = manufacturerService.findById(manufacturerId);

        Assert.assertEquals("TestUser", manufacturer1.getName());
        Assert.assertEquals("MKD", manufacturer1.getCountry());
    }


    @Test
    public void createManufacturerTest() {

        Manufacturer manufacturer = new Manufacturer("Viktor","MKD");

        when(manufacturerRepository.save(any(Manufacturer.class))).thenReturn(manufacturer);

        Manufacturer createdManufacturer = manufacturerService.save(manufacturer.getName(),manufacturer.getCountry());

        Assert.assertFalse(createdManufacturer.getName().isEmpty());

        Assert.assertEquals("Viktor",createdManufacturer.getName());

        Assert.assertEquals("MKD",createdManufacturer.getCountry());


//        Manufacturer manufacturer = new Manufacturer("Viktor","MKD");
//
//        when(manufacturerRepository.save(manufacturer)).thenReturn(manufacturer);
//
//        Assert.assertEquals(manufacturer,manufacturerService.save(manufacturer.getName(),manufacturer.getCountry()));


    }

    @Test
    public void deleteManufacturerByIdTest() {
        //given
        Manufacturer manufacturer = new Manufacturer("Viksa","USA");

        Long manufacturerId = manufacturer.getId();

        //when
        when(manufacturerRepository.findById(manufacturerId)).thenReturn(java.util.Optional.of(manufacturer)).thenReturn(null);


         manufacturerService.deleteById(manufacturerId);

        //test
         verify(manufacturerRepository).deleteById(manufacturerId);

    }

    @Test
    public void findByNameLikeTest() {

        String name = "Vik";

        List<Manufacturer> list = new ArrayList<Manufacturer>();
        //we define some manufacturers
        Manufacturer manufacturer = new Manufacturer("Viktor", "USA");
        Manufacturer manufacturer1 = new Manufacturer("Viksa", "SRB");
        Manufacturer manufacturer2 = new Manufacturer("Viktorija", "RS");
        //we add them in predefined list
        list.add(manufacturer);
        list.add(manufacturer1);
        list.add(manufacturer2);

        //when
        when(manufacturerRepository.findByNameLike(name)).thenReturn(list);

        //then
        List<Manufacturer> expectedManufacturers = manufacturerService.findByNameLike(name);
        Assert.assertEquals(3, expectedManufacturers.size());
        verify(manufacturerRepository, times(1)).findByNameLike(name);


    }
}
