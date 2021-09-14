package accountingsystem.main.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkServicePitTests {

  @Test
  void EmptyConstructor() {
    WorkService workService = new WorkService();

    Assertions.assertEquals(null, workService.getId());
  }

  @Test
  void getAndSetId() {

    WorkService workService = new WorkService("testName", "testDescription", 150l);
    String s = "1223434343";
    Long id = Long.parseLong(s);
    workService.setId(id);

    Long test = workService.getId();

    Assertions.assertEquals(id, test);
  }

  @Test
  void getName() {
    WorkService workService = new WorkService("testName", "testDescription", 150l);
    Assertions.assertEquals("testName", workService.getName());
  }

  @Test
  void setName() {
    WorkService workService = new WorkService("testName", "testDescription", 150l);

    String test = "testnameeee";
    workService.setName(test);
    Assertions.assertEquals("testnameeee", workService.getName());
  }

  @Test
  void getDescription() {
    WorkService workService = new WorkService("testName", "testDescription", 150l);
    Assertions.assertEquals("testDescription", workService.getDescription());
  }

  @Test
  void setDescription() {
    WorkService workService = new WorkService("testName", "testDescription", 150l);

    String test = "testnameeee";
    workService.setDescription(test);
    Assertions.assertEquals("testnameeee", workService.getDescription());
  }

  @Test
  void getPrice() {

    WorkService workService = new WorkService("testName", "testDescription", 150l);

    long p = 150L;
    Assertions.assertEquals(150L, workService.getPrice());
  }

  @Test
  void setPrice() {

    WorkService workService = new WorkService("testName", "testDescription", 150l);

    long p = 150L;

    workService.setPrice(p);
    Assertions.assertEquals(150L, workService.getPrice());
  }
}
