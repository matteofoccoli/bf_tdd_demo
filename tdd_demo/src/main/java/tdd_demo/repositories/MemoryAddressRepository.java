package tdd_demo.repositories;

import tdd_demo.models.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by matteo on 17/06/15.
 */
public class MemoryAddressRepository implements AddressRepository {

  private List<Address> addresses = new ArrayList<>();

  @Override
  public List<Address> all() {
    return addresses;
  }

  @Override
  public Address save(Address address) {
    address.setId(new Random().nextInt());
    addresses.add(address);
    return address;
  }

}
