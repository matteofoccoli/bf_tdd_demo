package tdd_demo.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tdd_demo.TddDemoApplicationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by matteo on 17/06/15.
 */
public class AddressControllerIntegrationTest extends TddDemoApplicationTests {

  @Autowired
  private WebApplicationContext context;
  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void createAddressFromJson() throws Exception {
    mvc.perform(post("/addresses").
        contentType(MediaType.APPLICATION_JSON).
        content("{\"street\":\"Via Piranesi, Milano\",\"state\":\"Italy\"}")).
        andExpect(status().isCreated());
  }

}
