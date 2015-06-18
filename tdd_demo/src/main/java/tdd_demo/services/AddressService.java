package tdd_demo.services;

import tdd_demo.models.Address;
import tdd_demo.repositories.AddressRepository;

import java.util.List;

/**
 * Created by matteo on 17/06/15.
 */
public class AddressService {

  private AddressRepository repo;

  public AddressService(AddressRepository repo) {
    this.repo = repo;
  }

  public List<Address> all() {
    return repo.all();
  }

  public Address save(Address address) {
    return repo.save(address);
  }

}
