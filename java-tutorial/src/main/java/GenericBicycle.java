/**
 * Created by wscott on 4/29/14.
 */
public class GenericBicycle implements Bicycle {

  int cadence = 0;
  int speed = 0;
  int gear = 1;

  @Override
  public void changeCadence(int cadence) {
    this.cadence = cadence;
  }

  @Override
  public void speedUp(int increment) {
    this.speed += increment;
  }

  @Override
  public void applyBreaks(int decrement) {
    this.speed -= decrement;
  }

  @Override
  public void changeGear(int newGear) {
    this.gear = newGear;
  }

  @Override
  public String toString() {
    return "cadence:" + this.cadence +
        ", speed:" + this.speed +
        ", gear:" + this.gear;
  }

}
