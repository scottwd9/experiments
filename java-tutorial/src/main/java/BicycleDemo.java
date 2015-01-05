/**
 * Created by wscott on 4/29/14.
 */
public class BicycleDemo {
  public static void main(String[] args) {
    Bicycle bike1 = new GenericBicycle();
    Bicycle bike2 = new GenericBicycle();

    bike1.changeCadence(50);
    bike1.speedUp(10);
    bike1.changeGear(2);

    bike2.changeCadence(50);
    bike2.speedUp(10);
    bike2.changeGear(2);
    bike2.changeCadence(40);
    bike2.speedUp(10);
    bike2.changeGear(3);

    System.out.println(bike1.toString());
    System.out.println(bike2.toString());
  }
}
