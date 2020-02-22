package rpg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class RPG {
	  private static Random rng = new Random ();
	  public static void playGame (String player, String monster, String spellslist) throws IOException {
	    ArrayList<Spell> spells = FileIO.readSpells(spellslist);
	    if (spells == null || spells.isEmpty())
	      System.out.println ("The spells list is empty. The game will be played without spells.");
	    Character p = FileIO.readCharacter (player);
	    Character m = FileIO.readCharacter (monster);
	    Character.setSpells (spells);
	    Scanner s = new Scanner (System.in);
	    //double playerhp = p.getCurrHealth();
	    //double monsterhp = m.getCurrHealth();
	    System.out.println ("Name: " + p.getName());
	    System.out.println ("Attack: " + p.getAttackValue());
	    System.out.println ("Max Health: " + p.getMaxHealth());
	    System.out.println ("Number of wins: " + p.getNumWins());
	    System.out.println ();
	    System.out.println ("Name: " + m.getName());
	    System.out.println ("Attack: " + m.getAttackValue());
	    System.out.println ("Max Health: " + m.getMaxHealth());
	    System.out.println ("Number of wins: " + m.getNumWins());
	    System.out.println ();
	    System.out.println ("Here are the available spells:");
	    Character.displaySpells ();
	    System.out.println ();
	    while (p.getCurrHealth() > 0.0 && m.getCurrHealth() > 0.0) {
	      System.out.println ("Enter attack, quit, or a spell name.");
	      String command = s.nextLine();
	      if (command.toLowerCase().equals("quit")) {
	        System.out.println ("Goodbye.");
	        return;
	        //The game will end immediately, skipping the commands after the loop
	      }
	      if (command.toLowerCase().equals("attack")) {
	        System.out.println ();
	        int random = rng.nextInt();
	        double playeratk = p.getAttackDamage(random);
	        String formatmonsterhp = String.format("%.2f", m.getCurrHealth());
	        String formatplayeratk = String.format("%.2f", playeratk);
	        String formatplayerhp = String.format("%.2f", p.getCurrHealth());
	        System.out.println (p.getName() + " will deal " + formatplayeratk + " damage.");
	        formatmonsterhp = String.format("%.2f", m.takeDamage(playeratk));
	        if (m.getCurrHealth() <= 0) {
	          System.out.println ("Good job. " + m.getName() + " is now banned from Twitter and YouTube and Spotify.");
	          break;
	        }
	        else
	          System.out.println (m.getName() + " now has " + formatmonsterhp + " hp.");
	        //I couldn't use the toString method from the Character class because I wanted to format the hp and damage values to 2 decimal places
	        System.out.println ();
	        double monsteratk = m.getAttackDamage(random);
	        String formatmonsteratk = String.format("%.2f", monsteratk);
	        System.out.println (m.getName() + " will deal " + formatmonsteratk + " damage. Brace yourself.");
	        formatplayerhp = String.format("%.2f", p.takeDamage(monsteratk));
	        if (p.getCurrHealth() <= 0) {
	          System.out.println (p.getName() + " was featured on InfoWars and several million of Alex Jones' followers are now against him.");
	          break;
	        }
	        else
	          System.out.println (p.getName() + " now has " + formatplayerhp + " hp.");
	        System.out.println ();
	      }
	      else {
	        System.out.println ();
	        int random = rng.nextInt();
	        //The command will be the spell's name
	        double magatk = Character.castSpell(command, random);
	        String formatmagatk = String.format("%.2f", magatk);
	        //magatk will be 0 if the spell missed, or negative if the spell name was incorrect
	        if (magatk == 0)
	          System.out.println (p.getName() + " tried to cast a spell, but Alex Jones slapped the spellbook out of his hand.");
	        else if (magatk < 0) {
	          System.out.println (p.getName() + " mispronounced his spell and released a loud fart instead, spreading toxic fumes all over the place.");
	          System.out.println (m.getName() + " suffered 0.01 mental damage and was unable to retaliate as it held its nose and waited for the smell to dissipate.");
	          m.takeDamage(0.01);
	          String formatmonsterhp = String.format("%.2f", m.getCurrHealth());
	          System.out.println (m.getName() + " now has " + formatmonsterhp + " hp.");
	          System.out.println ();
	          continue;
	        }
	        else {
	          System.out.println (p.getName() + " casted " + command + " and dealt " + formatmagatk + " damage to " + m.getName() + ".");
	          m.takeDamage(magatk);
	          String formatmonsterhp = String.format("%.2f", m.getCurrHealth());
	          if (m.getCurrHealth() <= 0) {
	            System.out.println ("Good job. " + m.getName() + " is now banned from Twitter and YouTube and Spotify.");
	            break;
	        }
	        else 
	          System.out.println (m.getName() + " now has " + formatmonsterhp + " hp.");
	        }
	        System.out.println ();
	        double monsteratk = m.getAttackDamage(random);
	        String formatmonsteratk = String.format("%.2f", monsteratk);
	        System.out.println (m.getName() + " will deal " + formatmonsteratk + " damage. Brace yourself.");
	        String formatplayerhp = String.format("%.2f", p.takeDamage(monsteratk));
	        if (p.getCurrHealth() <= 0) {
	          System.out.println (p.getName() + " was featured on InfoWars and several million of Alex Jones' followers are now against him.");
	          break;
	        }
	        else
	          System.out.println (p.getName() + " now has " + formatplayerhp + " hp.");
	        System.out.println ();
	        }
	  }
	    System.out.println ();
	    s.close();
	    if (p.getCurrHealth() >= 0) {
	      p.increaseWins();
	      FileIO.writeCharacter (p, player);
	      System.out.println (p.getName() + "'s wins: " + p.getNumWins());
	    }
	    else {
	      m.increaseWins();
	      FileIO.writeCharacter (m, monster);
	      System.out.println (m.getName() + "'s wins: " + m.getNumWins());
	    }
	  }
	  public static void main (String args[]) throws IOException {
	    playGame("player.txt", "monster.txt", "spells.txt");
	  }
	}   
