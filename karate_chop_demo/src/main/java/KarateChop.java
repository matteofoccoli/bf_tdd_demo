/**
 * Created by matteo on 17/06/15.
 */
public abstract class KarateChop {

  protected static final int ELEMENT_NOT_FOUND = -1;

  public abstract int chop(int[] numbers, int searched);

  protected boolean isEmpty(int[] numbers) {
    return numbers.length == 0;
  }

}
