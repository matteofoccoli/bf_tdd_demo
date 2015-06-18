import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by matteo on 17/06/15.
 */
public class LinearKarateChopTest {

  private KarateChop chopper;

  @Before
  public void setUp() throws Exception {
    chopper = new LinearKarateChop();
  }

  @Test
  public void emptyArray() throws Exception {
    assertThat(chopper.chop(new int[]{}, 12), equalTo(-1));
  }

  @Test
  public void oneElementArray() throws Exception {
    assertThat(chopper.chop(new int[]{23}, 12), equalTo(-1));
    assertThat(chopper.chop(new int[]{23}, 23), equalTo(0));
  }

  @Test
  public void twoElementsArray() throws Exception {
    int[] numbers = {23, 56};

    assertThat(chopper.chop(numbers, 12), equalTo(-1));
    assertThat(chopper.chop(numbers, 23), equalTo(0));
    assertThat(chopper.chop(numbers, 56), equalTo(1));
  }

  @Test
  public void manyElementsArray() throws Exception {
    int[] numbers = {1, 3, 5, 23, 34, 45};

    assertThat(chopper.chop(numbers, 23), equalTo(3));
  }
}

