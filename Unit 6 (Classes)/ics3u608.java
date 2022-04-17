import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Child child1 = new Child(s.nextInt(), s.nextDouble());
        Child child2 = new Child(s.nextInt(), s.nextDouble());
        Child child3 = new Child(s.nextInt(), s.nextDouble());
        System.out.println("Child 1 vs Child 2 - " + child1.equals(child2));
        System.out.println("Child 2 vs Child 3 - " + child2.equals(child3));
        System.out.println("Child 3 vs Child 1 - " + child3.equals(child1));

        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }
}

class Child {
  private int height;
  private double mass;

  public Child (int a, double b) {
    this.height = a;
    this.mass = b;
  }

  public boolean equals (Child other) {
    int height = Math.abs(this.height - other.height);
    double mass = Math.abs(this.mass - other.mass);
    if (height <= 2) {
        if (mass <= 0.5) {
          return true;
        }
    }
    return false;
  }

  public String toString() {
    double bmi = this.mass / (this.height / 100.0 * this.height / 100.0);
    if (bmi > 18.0) {
      return "Child - good";
    }
    else {
      return "Child - bad";
    }
  }
} 
