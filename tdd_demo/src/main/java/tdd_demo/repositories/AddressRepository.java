package tdd_demo.repositories;

import tdd_demo.models.Address;

import java.util.List;

/**
 * Created by matteo on 17/06/15.
 */
public interface AddressRepository {

  List<Address> all();

  Address save(Address address);

}
