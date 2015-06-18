/**
 * Created by matteo on 17/06/15.
 */
public class LinearKarateChop extends KarateChop {

  @Override
  public int chop(int[] numbers, int searched) {
    if (isEmpty(numbers))
      return -1;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == searched)
        return i;
    }
    return -1;
  }

}
