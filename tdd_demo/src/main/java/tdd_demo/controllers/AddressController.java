package tdd_demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tdd_demo.models.Address;
import tdd_demo.repositories.AddressRepository;
import tdd_demo.repositories.MemoryAddressRepository;
import tdd_demo.services.AddressService;

import java.util.List;

/**
 * Created by matteo on 17/06/15.
 */
@RestController
public class AddressController {

  private AddressService service;
  private AddressRepository repo;

  public AddressController() {
    this.repo = new MemoryAddressRepository();
    this.service = new AddressService(repo);;
  }

  public void setRepo(AddressRepository repo) {
    this.repo = repo;
  }

  public void setService(AddressService service) {
    this.service = service;
  }

  @RequestMapping(
      value = "/addresses",
      method = RequestMethod.GET,
      produces = "application/json"
  )
  public List<Address> all() {
    return service.all();
  }

  @RequestMapping(
      value = "/addresses",
      method = RequestMethod.POST,
      consumes = "application/json"
  )
  @ResponseStatus(HttpStatus.CREATED)
  public Address create(@RequestBody Address address) {
    return service.save(address);
  }

}
