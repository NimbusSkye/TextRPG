# TextRPG
Text RPG game using Java.

This application implements File IO to read and write to text files that contain information about the player, the monster, and the spells that the player can use. The outcome of each engagement is decided by a Random Number Generator provided by Java.util.Random. 

Player.txt and Monster.txt contain the name, attack, max health, and number of wins for the player and monster, respectively. The program will automatically increment the number of wins for the victor after each battle. Spells.txt specifies the name, damage, and accuracy of each spell that is available to the player.

**Please head over to the "Releases" tab and download the latest release if you wish to test out the program.**

Sample output:
```
Name: Odin
Attack: 10.0
Max Health: 30.0
Number of wins: 8

Name: Fenrir
Attack: 12.0
Max Health: 30.0
Number of wins: 22

Here are the available spells:
fireball deals 5.0 - 10.0 damage. Accuracy: 50.0%.
icestorm deals 1.0 - 7.0 damage. Accuracy: 90.0%.
meteorstrike deals 10.0 - 10.0 damage. Accuracy: 5.0%.
surge of frostfire deals 7.0 - 10.0 damage. Accuracy: 30.0%.

Enter attack, quit, or a spell name.
```
attack
```
Odin will deal 8.71 damage.
Fenrir now has 21.29 hp.

Fenrir will deal 10.45 damage. Brace yourself.
Odin now has 19.55 hp.

Enter attack, quit, or a spell name.
```
fireball
```
Odin tried to cast a spell, but Alex Jones slapped the spellbook out of his hand.

Fenrir will deal 10.79 damage. Brace yourself.
Odin now has 8.75 hp.

Enter attack, quit, or a spell name.
```
fireball
```
Odin tried to cast a spell, but Alex Jones slapped the spellbook out of his hand.

Fenrir will deal 10.30 damage. Brace yourself.
Odin was featured on InfoWars and several million of Alex Jones' followers are now against him.

Successfully wrote to file: monster.txt
Fenrir's wins: 23
```
