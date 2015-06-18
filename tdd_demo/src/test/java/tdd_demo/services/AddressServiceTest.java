package tdd_demo.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tdd_demo.models.Address;
import tdd_demo.repositories.AddressRepository;

import static org.mockito.Mockito.verify;

/**
 * Created by matteo on 17/06/15.
 */
public class AddressServiceTest {

  @Mock
  private AddressRepository repo;

  @InjectMocks
  private AddressService service;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getsAllAddresses() throws Exception {
    service.all();

    verify(repo).all();
  }

  @Test
  public void createsANewAddress() throws Exception {
    Address address = new Address("Via Turati, Milano", "Italy");

    service.save(address);

    verify(repo).save(address);
  }

}