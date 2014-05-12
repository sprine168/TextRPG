//This is where the game runs
package textrpg;

import java.util.Scanner;
import textrpg.equipment.*;
import textrpg.items.*;
import textrpg.monsters.Slime;
import textrpg.npcs.NPC;
import textrpg.rooms.*;
import textrpg.weapons.*;

public class Game {

    Scanner scan = new Scanner(System.in);
    static String lineBreak = "=========================="; //String for breaking up likes, might get rid of

    Room currentRoom = null; //the current room the player is in
    String userInput = ""; //does this need to be global?

    //loadRooms() maybe
    public Game(Player hero) {
        //Eventually there'll be a database that stores all of the rooms and other things
        printBreak();

        //This block is temp for now since rooms are just objects sitting in a class right now
        Room prRoom = new PowerRangerRoom(null, null, null, null);
        Room startRoom = new StartingRoom(null, null, null, null);//there's a better way to do this...
        prRoom.setExits(null, startRoom, null, null);
        startRoom.setExits(prRoom, null, null, null);

        currentRoom = startRoom;//for testing atm

        //need player to know which room they're in
        currentRoom.enterRoomText();//need to print every time they enter a new room

        startingThingsForTesting(hero);//all of the testing stuff goes here

        //This is the main loop for the game
        while (!userInput.equals("quit")) {
            System.out.print(">");
            userInput = scan.nextLine();
            command(hero);
        }

        System.out.println("Bye!!");
    }

    public static final void printBreak() {//prints a LINE_BREAKERRR!
        System.out.println(lineBreak);
    }

    private void command(Player hero) {//checks what to do from the users input
        userInput = userInput.toLowerCase();
        int i = userInput.indexOf(' '); //gets the space in the command
        String firstUserInput, restofUserInput = "";

        if (i > 0) {// if there's a space then parse it
            firstUserInput = userInput.substring(0, i);
            restofUserInput = userInput.substring(i + 1, userInput.length());
        }
        else {
            firstUserInput = userInput;
        }

        firstUserInput = parseUserInput(firstUserInput);

        switch (firstUserInput) { //this will be better later....
            case "b":
                Slime m = new Slime();//temporary
                new Battle(hero, m);
                break;
            case "help":
                printCommands();
                break;
            case "quit":
                break;
            case "n":
                if (currentRoom.getNExit() != null) {
                    currentRoom = currentRoom.getNExit();
                    currentRoom.enterRoomText();
                }//methods for these, also need
                else {
                    Room.noExit();
                }
                break;
            case "s":
                if (currentRoom.getSExit() != null) {
                    currentRoom = currentRoom.getSExit();
                    currentRoom.enterRoomText();
                }
                else {
                    Room.noExit();
                }
                break;
            case "e":
                if (currentRoom.getEExit() != null) {
                    currentRoom = currentRoom.getEExit();
                    currentRoom.enterRoomText();
                }
                else {
                    Room.noExit();
                }
                break;
            case "w":
                if (currentRoom.getWExit() != null) {
                    currentRoom = currentRoom.getWExit();
                    currentRoom.enterRoomText();
                }
                else {
                    Room.noExit();
                }
                break;
            case "exits":
                currentRoom.getExits();
                break;
            case "look":
                System.out.println(currentRoom.getRoomDescription());
                break;
            case "i":
                hero.printInventory();
                break;
            case "skills":
                hero.getJob().printSkills();
                break;
            case "status":
                hero.printStatus();
                break;
            case "equipment":
                hero.printEquipment();
                break;
            case "take":
                takeCommand(restofUserInput, hero);
                break;
            case "equip":
                equipCommand(restofUserInput, hero);
                break;
            case "talk":
                talkCommand(restofUserInput);
                break;
            case "shop":
                if (currentRoom.getShop() != null) {
                    currentRoom.getShop().enter(hero);
                }
                else {
                    System.out.println("There isn't a shop here.");
                }
                break;
            case "drop":
                dropCommand(restofUserInput, hero);
                break;
            default:
                System.out.println("Command not recognized.");
                break;
        }
    }

    //Method for testing purpose
    private void startingThingsForTesting(Player hero) {
        System.out.println("There is much testing to be done.\n'b' for battle and 'help' for help~~");
        System.out.println("Here are some items for you!");
        Item s = new SlimeExtract();
        hero.addInventory(s);
        Item hp = new HealthPotion();
        hero.addInventory(hp);

        System.out.println("Here's some gear!");
        Weapon iron = new IronSword();
        Equipment bronze = new BronzeChest();
        hero.getInventory().add(iron);
        hero.setChest(bronze);
    }

    //Formats for shortcuts, need to make an array later of acceptable commands....
    private String parseUserInput(String input) {
        switch (input) {
            case "north":
                input = "n";
                break;
            case "south":
                input = "s";
                break;
            case "east":
                input = "e";
                break;
            case "west":
                input = "w";
                break;
            case "exit":
                input = "exits";
                break;
            case "battle":
                input = "b";
                break;
            case "inventory":
                input = "i";
                break;
            case "search":
                input = "look";
                break;
            case "stats":
                input = "status";
                break;
        }
        return input;
    }
    
    //Prints all of the available commands
    private void printCommands() {
        printBreak();
        System.out.println("north, south, east, west - Moves you arround to different rooms.");
        System.out.println("battle - Starts a testing fight against a slime.");
        System.out.println("look - Tells you the room description.");
        System.out.println("inventory - Tells you all of the items that you have on yourself.");
        System.out.println("exits - Tells you where all of the exits are in the room.");
        System.out.println("skills - Tells you all of the skills that you know.");
        System.out.println("status - Tells your stats, name, and class.");
        System.out.println("equipment - Tells you the current equipment that you're wearing.");
        System.out.println("take - Takes an item from something or somewhere. Usage is take 'object' where object is what you want to take.");
        System.out.println("equip - Equips something to youreself. Usage is equip 'object' where object is what you want to equip to yourself.");
        System.out.println("talk - Talks to someone, including yourself! Usage is talk 'person' where person is who you want to talk to. If you don't specify someone then it will talk to whoever it deems is most important.");
        System.out.println("shop - Enters the shop if there is currently one in the room.");
        System.out.println("quit - Quits the game.");
        printBreak();
    }

    //Figures out what to take
    private void takeCommand(String rest, Player hero) {
        boolean pass = false;
        for (int i = 0; i < currentRoom.getRoomLoot().size(); i++) {//for some reason using nested for each loops crashes here
            for (String tag : currentRoom.getRoomLoot().get(i).getTags()) {
                if (tag.equals(rest)) {
                    Item temp = currentRoom.getRoomLoot().get(i);//sets the item to be taken to a temp variable

                    hero.addInventory(temp);
                    currentRoom.getRoomLoot().remove(temp);
                    System.out.println("Took " + temp.getName() + ".");
                    pass = true;
                }
            }
        }
        if (!pass) { //If there was no item let them know
            System.out.println("There's no item here called that.");
        }
    }

    //Equips something
    private void equipCommand(String input, Player hero) {
        boolean pass = false;
        Equipment temp = null;
        Equipment j = null; //the item that we searched for
        
        for (Item i : hero.getInventory()) {
            if ((i.getName().toLowerCase().equals(input))) {
                if (i.getClass().getSuperclass().equals(Equipment.class) || i.getClass().getSuperclass().equals(Weapon.class)) {
                    pass = true; //^^^ i dont like that line ^^^
                    j = (Equipment)i;//need to access equipmentType method
                    
                    //Look at docs for weapon types (when I write them...)
                    switch (j.getEquipmentType()) {
                        case 1:
                            temp = hero.getWeapon();
                            hero.setWeapon((Weapon) j);
                            break;
                        case 2:
                            temp = hero.getChest();
                            hero.setChest(j);
                            break;
                        case 3:
                            temp = hero.getLegs();
                            hero.setLegs(j);
                            break;
                        case 4:
                            temp = hero.getBracers();
                            hero.setBracers(j);
                            break;
                        case 5:
                            temp = hero.getBoots();
                            hero.setBoots(j);
                            break;
                        case 6:
                            temp = hero.getGloves();
                            hero.setGloves(j);
                            break;
                        case 7:
                            temp = hero.getOffHand();
                            hero.setOffHand((Weapon) j);
                            break;
                        case 8:
                            temp = hero.getOffHand();
                            hero.setOffHand((Weapon) j);
                            break;
                        case 9:
                            temp = hero.getRing();
                            hero.setRing(j);
                            break;
                        case 10:
                            temp = hero.getHat();
                            hero.setHat(j);
                            break;
                        case 11:
                            temp = hero.getGoggles();
                            hero.setGoggles(j);
                            break;
                        default: System.out.println(j.getItemType()); //For debugging
                            break;
                    }
                    System.out.println("Equiped " + i.getName());
                }
                else {
                    System.out.println("You can't equip that!");
                    pass = true;
                }
            }
        }
        
        hero.getInventory().remove(j); //removes the item from the inventory
        
        if (!pass) {
            System.out.println("There's no item here called that.");
        }
        else if(temp != null && !temp.getName().equals("None")){ //Switch the equipment from inventory
            hero.addInventory(temp);
        }
    }

    //Talks to an NPC, 
    private void talkCommand(String input) {
        if (currentRoom.getNPCsInRoom() != null) {
            boolean pass = false;
            
            if (input.trim().equals("")) { //If the player doesn't specify someone
                currentRoom.getNPCsInRoom()[0].printDefaultDialogue();
            }
            else {
                for (NPC n : currentRoom.getNPCsInRoom()) {    //As of right now it can talk to multiple people
                    if (n.getName().equalsIgnoreCase(input)) { //if they have the same name
                        n.printDefaultDialogue();
                        pass = true;
                    }
                }
                if (!pass) {
                    System.out.println("There isn't anyone called that here.");
                }
            }
        }
        else {
            System.out.println("No one's here!");
        }
    }
 
    //Drops an item and puts it in a room
    private void dropCommand(String input, Player hero) {
        boolean found = false;
        for (Item i : hero.getInventory()) {
            if (i.getName().equalsIgnoreCase(input)) {
                if (i.getItemType() != 3) { //If it is not a quest item
                    currentRoom.getRoomLoot().add(i);
                    hero.getInventory().remove(i);
                    //need to check if there are multiple ones, also a/an, also item tags checking
                    i.setItemRoomDescription("There is a " + i.getName() + " laying on the ground."); //shows the item in the look command
                    System.out.println("Dropped " + i.getName() + ".");
                    found = true;
                    break; //only drop one item if there are multiple
                }
                
                else {
                    System.out.println("You cannot drop that item!");
                }
            }
        }
        
        if(!found) {
            System.out.println("Item not found.");
        }
    }
}
