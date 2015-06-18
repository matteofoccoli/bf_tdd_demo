package tdd_demo.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.web.servlet.MockMvc;
import tdd_demo.models.Address;
import tdd_demo.repositories.AddressRepository;
import tdd_demo.repositories.MemoryAddressRepository;
import tdd_demo.services.AddressService;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by matteo on 17/06/15.
 */
public class AddressControllerTest {

  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    AddressController controller = new AddressController();
    AddressRepository repo = new MemoryAddressRepository();
    repo.save(new Address("Via Lancetti, Milano", "Italy"));
    repo.save(new Address("Via Papa Giovanni, Bergamo", "Italy"));
    controller.setService(new AddressService(repo));

    mvc = standaloneSetup(controller).build();
  }

  @Test
  public void getAddressesAsJson() throws Exception {
    mvc.perform(get("/addresses")).
        andExpect(status().isOk()).
        andExpect(content().contentType(MediaType.APPLICATION_JSON)).
        andExpect(jsonPath("$", hasSize(2))).
        andExpect(jsonPath("$[0].street", is("Via Lancetti, Milano")));
  }

  @Test
  public void createAddressFromJson() throws Exception {
    mvc.perform(post("/addresses").
        contentType(MediaType.APPLICATION_JSON).
        accept(MediaType.APPLICATION_JSON).
        content("{\"street\":\"Via Piranesi, Milano\",\"state\":\"Italy\"}")).
        andExpect(status().isCreated());
  }

}