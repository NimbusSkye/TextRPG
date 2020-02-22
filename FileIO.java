package rpg;
import java.io.*;
import java.util.ArrayList;
public class FileIO {
  public static Character readCharacter (String filename) {
    try {
    FileReader fr = new FileReader (filename);
    BufferedReader br = new BufferedReader (fr);
    String name = br.readLine();
    double atk = Double.parseDouble(br.readLine());
    double maxhp = Double.parseDouble(br.readLine());
    int numwins = Integer.parseInt(br.readLine());
    Character p1 = new Character (name, atk, maxhp, numwins);
    br.close();
    return p1;
  }
    catch (FileNotFoundException e) {
      System.out.println ("The file could not be found! The game cannot be played. Goodbye.");
      System.exit(1);
    }
    catch (IOException e) {
      System.out.println ("IO Exception.");
      System.exit(1);
    }
    return null;
}
  public static ArrayList<Spell> readSpells (String filename) {
    try {
      FileReader fr = new FileReader (filename);
      BufferedReader br = new BufferedReader (fr);
      ArrayList<Spell> spells = new ArrayList<Spell>();
      String[] spellcomponent;
      String linejustread = br.readLine();
      while (linejustread != null) {
        //The split method below will create an array of Strings, each element of which will be a component of the spell
        spellcomponent = linejustread.split("\t");
        //Each attribute of the spell is initialized below
        String name = spellcomponent[0];
        double minatk = Double.parseDouble(spellcomponent[1]);
        double maxatk = Double.parseDouble(spellcomponent[2]);
        double accuracy = Double.parseDouble(spellcomponent[3]);
        //Calling the spell constructor
        Spell newspell = new Spell (name, minatk, maxatk, accuracy);
        spells.add(newspell);
        linejustread = br.readLine();
      }
      br.close();
      return spells;
  }
    catch (FileNotFoundException e) {
      System.out.println ("File not found!");
      System.exit(0);
      return null;
    }
    catch (IOException e) {
      System.out.println ("IOException");
      System.exit(0);
      return null;
    }
  }
  public static void writeCharacter (Character c, String filename) throws IOException {
    FileWriter fw = new FileWriter (filename);
    BufferedWriter bw = new BufferedWriter (fw);
    bw.write (c.getName());
    bw.newLine();
    bw.write (Double.toString(c.getAttackValue()));
    bw.newLine();
    bw.write (Double.toString(c.getMaxHealth()));
    bw.newLine();
    bw.write (Integer.toString(c.getNumWins()));
    bw.close();
    fw.close();
    System.out.println ("Successfully wrote to file: " + filename);
  }
  public static void main (String args[]) {
	  System.out.println(readCharacter("player.txt"));
  }
}