import java.util.Arrays;

/**
 * Created by matteo on 17/06/15.
 */
public class RecursiveKarateChop extends KarateChop {

  @Override
  public int chop(int[] numbers, int searched) {
    if (isEmpty(numbers))
      return ELEMENT_NOT_FOUND;
    return step(numbers, searched, 0);
  }

  private int step(int[] numbers, int searched, int index) {

    if (numbers.length == 1) {
      if (numbers[0] == searched)
        return index;
      else
        return ELEMENT_NOT_FOUND;
    }

    int half = numbers.length / 2;
    int[] left = Arrays.copyOfRange(numbers, 0, half);
    int[] right = Arrays.copyOfRange(numbers, half, numbers.length);

    if (right[0] > searched)
      return step(left, searched, index);
    else
      return step(right, searched, index + half);
  }

}
