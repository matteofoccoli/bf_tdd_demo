package tdd_demo.models;

/**
 * Created by matteo on 17/06/15.
 */
public class Address {

  private Integer id;
  private String street;
  private String state;

  // Nesessario alla deserializzazione da JSON
  public Address() {
  }

  public Address(String street, String state) {
    this.street = street;
    this.state = state;
  }

  public Integer getId() {
    return id;
  }

  public String getStreet() {
    return street;
  }

  public String getState() {
    return state;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setState(String state) {
    this.state = state;
  }
}
