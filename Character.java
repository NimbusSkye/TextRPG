package rpg;
import java.util.ArrayList;
import java.util.Random;
public class Character {
  private String name;
  private double atk;
  private double maxhp;
  private double currenthp;
  private int numwins;
  private static ArrayList<Spell> spells = new ArrayList<Spell>();
  public Character (String name, double atk, double maxhp, int numwins) {
    this.name = name;
    this.atk = atk;
    this.maxhp = maxhp;
    this.numwins = numwins;
    this.currenthp = maxhp;
  }
  public static void setSpells (ArrayList<Spell> spellslist) {
    //Copy the elements of the input arraylist to the class attribute arraylist via a for loop, just as with a regular array
    for (int i = 0; i < spellslist.size(); i++) 
      spells.add(spellslist.get(i));
  }
  public static void displaySpells () {
    for (int i = 0; i < spells.size(); i++)
      System.out.println (spells.get(i));
  }
  public static double castSpell (String spellname, int seed) {
    Spell s = null;
    for (int i = 0; i < spells.size(); i++) {
      if (spellname.equalsIgnoreCase(spells.get(i).getName())) {
        s = spells.get(i);
        break;
      }
    }
    //s will remain null if none of the spells in the arraylist match the input name. The for loop will break as soon as a matching spell is found
    if (s != null)
      return s.getMagicDamage(seed);
    else
      return -1.0;
  }
  public String getName () {
    return this.name;
  }
  public double getAttackValue () {
    return this.atk;
  }
  public double getMaxHealth () {
    return this.maxhp;
  }
  public double getCurrHealth () {
    return this.currenthp;
  }
  public int getNumWins () {
    return this.numwins;
  }
  public String toString () {
    return this.name + " has " + this.currenthp + " hp.";
  }
  public double getAttackDamage (int seed) {
    Random rng = new Random (seed);
    double atkmultiplier = rng.nextDouble() * 0.3 + 0.7;
    return atkmultiplier * this.atk;
  }
  public double takeDamage (double damage) {
    this.currenthp = this.currenthp - damage;
    return this.currenthp;
  }
  public void increaseWins () {
    this.numwins++;
  }
}