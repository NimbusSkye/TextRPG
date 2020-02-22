package rpg;
import java.util.Random;
public class Spell {
  private String name;
  private double minatk;
  private double maxatk;
  private double accuracy;
  public Spell (String name, double minatk, double maxatk, double accuracy) {
    this.name = name;
    this.minatk = minatk;
    this.maxatk = maxatk;
    this.accuracy = accuracy;
    if (minatk < 0 || minatk > maxatk || accuracy < 0 || accuracy > 1)
      throw new IllegalArgumentException (this.name + "'s minimum damage cannot be negative or greater than its maximum damage. Also ensure that its accuracy is not negative or greater than 1.");
  }
  public String getName() {
    return this.name;
  }
  public double getMagicDamage (int seed) {
    Random rng = new Random (seed);
    double random = rng.nextDouble();
    if (random > this.accuracy)
      return 0.00;
    else 
      return rng.nextDouble() * (maxatk - minatk) + minatk;
  }
  public String toString () {
    return this.name + " deals " + this.minatk + " - " + this.maxatk + " damage. Accuracy: " + this.accuracy * 100 + "%.";
  }
}