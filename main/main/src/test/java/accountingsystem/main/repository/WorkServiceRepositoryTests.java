package accountingsystem.main.repository;

import accountingsystem.main.model.WorkService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

@DataJpaTest
@RunWith(SpringRunner.class)
public class WorkServiceRepositoryTests {

    @Autowired
    public WorkServiceRepository workServiceRepository;

    @Test
    public void saveWorkServiceTest(){
        WorkService workService = new WorkService("testName","testDescription",150l);
        Long workServiceId = this.workServiceRepository.save(workService).getId();
        WorkService workService1 = this.workServiceRepository.findById(workServiceId).get();

        Assert.assertNotNull(workService);
        Assert.assertEquals(workService.getPrice(),workService1.getPrice());
        Assert.assertEquals(workService.getDescription(),workService1.getDescription());
        Assert.assertEquals(workService.getId(),workService1.getId());
        Assert.assertEquals(workService.getName(),workService1.getName());

    }

    @Test
    public void deleteWorkServiceTest(){
        WorkService workService = new WorkService("testName","testDescription",150l);
        Long workServiceId = this.workServiceRepository.save(workService).getId();
        this.workServiceRepository.deleteById(workServiceId);

        Assert.assertThrows(NoSuchElementException.class, () -> {
            this.workServiceRepository.findById(workServiceId).get();
        });
    }

    @Test
    public void findAllWorkServicesTest(){
        WorkService workService = new WorkService("testName","testDescription",150l);
        WorkService workService1 = new WorkService("testName","testDescription",150l);
        WorkService workService2 = new WorkService("testName","testDescription",150l);

        this.workServiceRepository.save(workService);
        this.workServiceRepository.save(workService1);
        this.workServiceRepository.save(workService2);

        Assert.assertNotNull(this.workServiceRepository.findAll());
        Assert.assertEquals(3,this.workServiceRepository.findAll().stream().count());


    }

}
