package me.williamscott.java;

/**
 * Created by wscott on 4/29/14.
 */
public class Scratch {
  public static void main(String[] args) {
    //unterscores in numeric literals
    int underscoreLiteral = 5_3_1;
    System.out.println(underscoreLiteral);

    //array literal
    String[][] names = {
        {
            "Mr.",
            "Mrs.",
            "Ms."
        },
        {
            "Smith",
            "Jones"
        }
    };
    System.out.println(names[0][0] + " " + names[1][0]);
    System.out.println(names[0][2] + " " + names[1][1]);
  }
}
