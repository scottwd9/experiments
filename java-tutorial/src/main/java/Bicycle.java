/**
 * Created by wscott on 4/29/14.
 */
public interface Bicycle {
  void changeCadence(int cadence);

  void speedUp(int increment);

  void applyBreaks(int decrement);

  void changeGear(int newGear);
}
