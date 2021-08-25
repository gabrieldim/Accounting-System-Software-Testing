package accountingsystem.main.service;

import accountingsystem.main.model.Manufacturer;
import accountingsystem.main.model.Product;
import accountingsystem.main.model.WorkService;
import accountingsystem.main.repository.WorkServiceRepository;
import accountingsystem.main.service.impl.WorkServicesServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class WorkServiceImplTests {

    @Mock
    WorkServiceRepository workServiceRepository;

    @InjectMocks
    WorkServicesServiceImpl workServicesService;


    @Test
    public void getAllWorkServicesTest() {
        List<WorkService> services = new ArrayList<WorkService>();
        //given
        //we define some workservices
        WorkService workService = new WorkService("testName", "testDescription", 150l);
        WorkService workService1 = new WorkService("testName1", "testDescription1", 150l);
        WorkService workService2 = new WorkService("testName2", "testDescription2", 150l);

        //we add them to the products list
        services.add(workService);
        services.add(workService1);
        services.add(workService2);

        //when
        when(workServiceRepository.findAll()).thenReturn(services);

        //test
        List<WorkService> serList = workServicesService.findAll();
        Assert.assertEquals(3, serList.size());
        verify(workServiceRepository, times(1)).findAll();
    }


    @Test
    public void deleteWorkServiceByIdTest() {

        //given
        WorkService workService = new WorkService("testName", "testDescription", 150l);

        Long workServiceId = workService.getId();

        when(workServiceRepository.findById(workServiceId)).thenReturn(java.util.Optional.of(workService)).thenReturn(null);

        workServicesService.deleteById(workServiceId);

        //test
        verify(workServiceRepository).deleteById(workServiceId);
    }

    @Test
    public void findByNameLikeTest3() {


        List<WorkService> services = new ArrayList<WorkService>();

        //given
        WorkService workService = new WorkService("testName", "testDescription", 150l);
        WorkService workService1 = new WorkService("testNa", "testDescription1", 150l);
        WorkService workService2 = new WorkService("test", "testDescription2", 150l);

        //we add them to the products list
        services.add(workService);
        services.add(workService1);
        services.add(workService2);

        String name = "test";

        //when
        when(workServiceRepository.findByNameLike(name)).thenReturn(services);

        List<WorkService> expectedWorkServices = workServicesService.findByNameLike(name);

        //test
        Assert.assertEquals(3, expectedWorkServices.size());
        verify(workServiceRepository, times(1)).findByNameLike(name);


    }

    @Test
    public void getWorkServiceByIdTest() {

        //creating workService
        WorkService workService = new WorkService("testName", "testDescription", 150l);

        Long workServiceId = workService.getId();

        //when
        when(workServiceRepository.findById(workServiceId)).thenReturn(java.util.Optional.of(workService));

        WorkService workService1 = workServicesService.findById(workServiceId);

        Assert.assertEquals("testName", workService1.getName());
        Assert.assertEquals("testDescription", workService1.getDescription());
        Assert.assertEquals(150l, workService1.getPrice().longValue());
    }

    @Test
    public void createWorkServiceTest() {

        //given
        WorkService workService = new WorkService("testName", "testDescription", 150l);

        //when
        when(workServiceRepository.save(any(WorkService.class))).thenReturn(workService);

        WorkService createdWorkService = workServicesService.save(workService.getName(),workService.getDescription(),workService.getPrice());

        //test
        Assert.assertFalse(createdWorkService.getName().isEmpty());

        Assert.assertEquals("testName",createdWorkService.getName());

        Assert.assertEquals("testDescription",createdWorkService.getDescription());

        Assert.assertEquals(150l,createdWorkService.getPrice().longValue());
    }

}
