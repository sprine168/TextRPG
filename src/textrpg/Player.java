package textrpg;//Need to make quests and have objects associated in here n such ya know

import textrpg.equipment.Equipment;
import textrpg.equipment.NoneE;
import textrpg.items.Item;
import textrpg.jobs.Job;
import textrpg.weapons.NoneW;
import textrpg.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

    private Job job;

    private Weapon weapon = new NoneW();
    private Weapon offHand = new NoneW(); //shield or offhand goes here
    private Equipment chest = new NoneE();
    private Equipment legs = new NoneE();
    private Equipment bracers = new NoneE();
    private Equipment boots = new NoneE();
    private Equipment gloves = new NoneE();
    private Equipment ring = new NoneE();
    private Equipment hat = new NoneE();
    private Equipment goggles = new NoneE();//not sure if i want these...

    private List<Item> inventory = new ArrayList<>();

    private int level;
    private int currentExp;
    private int nextLevelExp = 27; //exp needed to reach the next level - Temporary number

    private int gold = 0;

    //sets the level to 1 and initializes the players job
    public Player(String n, int j) {
        level = 1;
        super.setName(n);
        new Job(this, j);
    }
    
    public String getJobName(){return job.getJobName();}
    
    public Weapon getWeapon(){return weapon;}
    public void setWeapon(Weapon e){weapon = e;initCurrentStats();}
    
    public Weapon getOffHand(){return offHand;}
    public void setOffHand(Weapon e){offHand = e;initCurrentStats();}
    
    public Equipment getChest(){return chest;}
    public void setChest(Equipment e){chest = e;initCurrentStats();}
    
    public Equipment getLegs(){return legs;}
    public void setLegs(Equipment e){legs = e;initCurrentStats();}
    
    public Equipment getBracers(){return bracers;}
    public void setBracers(Equipment e){bracers = e;initCurrentStats();}
    
    public Equipment getBoots(){return boots;}
    public void setBoots(Equipment e){boots = e;initCurrentStats();}
    
    public Equipment getGloves(){return gloves;}
    public void setGloves(Equipment e){gloves = e;initCurrentStats();}
    
    public Equipment getRing(){return ring;}
    public void setRing(Equipment e){ring = e;initCurrentStats();}
    
    public Equipment getHat(){return hat;}
    public void setHat(Equipment e){hat = e;initCurrentStats();}
    
    public Equipment getGoggles(){return goggles;}
    public void setGoggles(Equipment e){goggles = e;initCurrentStats();}
   
    public Equipment[] getEquipment() {
        Equipment[] temp = {weapon, chest, legs, bracers, boots, gloves, offHand, ring, hat, goggles};
        return temp;
    }

    public List<Item> getInventory(){return inventory;}//used for removing and looping
    public void addItemToInventory(Item i){inventory.add(i);}
    
    public Job getJob(){return job;}
    public void setJob(Job j){job = j;} //if it is ever possible to switch textrpg.jobs then need to do more than this

    /**
     * Returns the textrpg.Player's inventory without duplicates
     * @return Item[]
     */
    public Item[] getUniqueInventoryItems() {
        Item[] invenCount = new Item[getInventory().size()];

        for (int i = 0; i < getInventory().size(); i++) {
            for (int j = 0; j - 1 < i; j++) {
                if (invenCount[j] != null && invenCount[j] == getInventory().get(i)) {
                    break;
                }
                else if (invenCount[j] == null) {
                    invenCount[j] = getInventory().get(i);
                    break;
                }
            }
        }
        return invenCount;
    }

    /**
     * Prints the players inventory in the format 'itemName(quantity)'
     */
    public void printInventory() {
        Game.printBreak();
        System.out.println("Your inventory:");
        String inven = "Gold: " + getGold() + ", ";//the inventory string that gets printed out
        String[][] invenCount = Game.getCountedInventory(getInventory());

        for (int i = 0; i < invenCount.length; i++) { //prints the inventory and counter if > 1
            if (invenCount[i][0] != null) {
                if (Integer.valueOf(invenCount[i][1]) > 1) {
                    inven += invenCount[i][0] + "(" + invenCount[i][1] + "), ";
                }
                else {
                    inven += invenCount[i][0] + ", ";
                }
            }
        }
        if (inven.length() > 2) {//formatting
            inven = inven.substring(0, inven.length() - 2);
        }

        System.out.println(inven);
    }

    public int getCurrentExp(){return currentExp;}
    public void setCurrentExp(int i) {
        if (nextLevelExp < (currentExp + i)) { //Carrys over left over experience
            currentExp = (currentExp + i) - nextLevelExp;
            levelUp();
        }
        else {
            currentExp = i;
        }
    }

    public int getNextLevelExp(){return nextLevelExp;}
    public void setNextLevelExp(int i){nextLevelExp = i;}
    
    public int getLevel(){return level;}
    public void levelUp() {
        level += 1;
        System.out.println("You reached level " + level + "!");

        getJob().levelUp(this); //Note: This line does not call this method
        initCurrentStats(); //Need to set currect stats since they changed
    }
    
    public int getGold(){return gold;}
    public void setGold(int i){gold = i;}
    
    public void printStatus() {
        Game.printBreak();
        System.out.println("Name: " + getName() + "\tJob: " + getJobName() + "\tLevel:" + getLevel());
        System.out.println("Health:" + getCurrentHealth() + "\nMana:" + getCurrentMana() + "\nStrength:" + getCurrentStrength() + "\nMagic:" + getCurrentMagic() + "\nAgility:" + getCurrentAgility() + "\nDefense:" + getCurrentDefense() + "\nMagic Defense:" + getCurrentMagicDefense());
    }

    public void printEquipment() {
        Game.printBreak();
        System.out.println("Weapons: " + getWeapon().getName() + "/" + getOffHand().getName());
        System.out.println("Chest: " + getChest().getName() + "\tLegs: " + getLegs().getName());
        System.out.println("Bracers: " + getBracers().getName() + "\tBoots: " + getBoots().getName());
        System.out.println("Gloves: " + getGloves().getName() + "\tRing: " + getRing().getName());
        System.out.println("Helmet: " + getHat().getName() + "\tGoggles: " + getGoggles().getName());
    }

    @Override //Sets the current stats by calculating the base and bonus from textrpg.equipment
    public void initCurrentStats() {
        int[] temp = calculateBonusStats();
        super.setCurrentHealth(super.getBaseHealth() + temp[0]);
        super.setMaxHealth(super.getCurrentHealth());
        super.setCurrentMana(super.getBaseMana() + temp[1]);
        super.setMaxMana(super.getCurrentMana());
        super.setCurrentStrength(super.getBaseStrength() + temp[2]);
        super.setCurrentMagic(super.getBaseMagic() + temp[3]);
        super.setCurrentAgility(super.getBaseAgility() + temp[4]);
        super.setCurrentDefense(super.getBaseDefense() + temp[5]);
        super.setCurrentMagicDefense(super.getBaseMagicDefense() + temp[6]);
    }

    //Calculates the bonus stats from textrpg.equipment
    private int[] calculateBonusStats() {
        int[] temp = new int[7];
        for (int i = 0; i < 7; i++) {
            temp[i] = 0;
            temp[i] += getWeapon().getEquipmentStats()[i]; //0 is the index of the hp modifier stat, look at docs
            temp[i] += getOffHand().getEquipmentStats()[i];
            temp[i] += getChest().getEquipmentStats()[i];
            temp[i] += getLegs().getEquipmentStats()[i];
            temp[i] += getBracers().getEquipmentStats()[i];
            temp[i] += getBoots().getEquipmentStats()[i];
            temp[i] += getGloves().getEquipmentStats()[i];
            temp[i] += getRing().getEquipmentStats()[i];
            temp[i] += getHat().getEquipmentStats()[i];
            temp[i] += getGoggles().getEquipmentStats()[i];
        }
        return temp;
    }

    //Used for HP pots and MP pots and such (for now)
    //Look at Item use documentation for order of array
    /**
     * Takes an array of stats from an item and adds it to the players
     * @param statsModified 
     */
    public void useItem(int[] statsModified) {
        if (statsModified[7] == 1) {//if it can increase max hp or mp, can probably make if-else better

            super.setCurrentHealth(super.getCurrentHealth() + statsModified[0]);
        }
        else {
            if (super.getCurrentHealth() + statsModified[0] > super.getMaxHealth()) {
                super.setCurrentHealth(super.getMaxHealth());
            }
            else {
                super.setCurrentHealth(super.getCurrentHealth() + statsModified[0]);
            }
        }

        if (statsModified[7] == 1) {//if it can increase max hp or mp, can probably make if-else better

            super.setCurrentMana(super.getCurrentMana() + statsModified[1]);
        }
        else {
            if (super.getCurrentMana() + statsModified[1] > super.getMaxMana()) {
                super.setCurrentMana(super.getMaxMana());
            }
            else {
                super.setCurrentMana(super.getCurrentMana() + statsModified[1]);
            }
        }

        super.setCurrentStrength(super.getCurrentStrength() + statsModified[2]);
        super.setCurrentMagic(super.getCurrentMagic() + statsModified[3]);
        super.setCurrentAgility(super.getCurrentAgility() + statsModified[4]);
        super.setCurrentDefense(super.getCurrentDefense() + statsModified[5]);
        super.setCurrentMagicDefense(super.getCurrentMagicDefense() + statsModified[6]);
    }

    //Look at docs for textrpg.equipment type
    //Calls this method when no type is specified
    /**
     * Sets the textrpg.equipment passed to the textrpg.Player
     * @param e The textrpg.equipment to equip
     */
    public void setEquipment(Equipment e) {
        setEquipment(e, e.getEquipmentType());
    }

    /**
     * Sets the textrpg.equipment passed to the textrpg.Player
     * @param e The textrpg.equipment to equip
     * @param type The type of textrpg.equipment
     */
    public void setEquipment(Equipment e, int type) {
        switch (type) {
            case 1:
                if (e.getName().equals("None")) {
                    Weapon tempW = new NoneW();
                    setWeapon(tempW);
                }
                else {
                    setWeapon((Weapon) e);
                }
                break;
            case 2:
                setChest(e);
                break;
            case 3:
                setLegs(e);
                break;
            case 4:
                setBracers(e);
                break;
            case 5:
                setBoots(e);
                break;
            case 6:
                setGloves(e);
                break;
            case 7:
                if (e.getName().equals("None")) {
                    Weapon tempS = new NoneW();
                    setOffHand(tempS);
                }
                else {
                    setOffHand((Weapon) e);
                }
                break;
            case 8:
                if (e.getName().equals("None")) {
                    Weapon tempO = new NoneW();
                    setOffHand(tempO);
                }
                else {
                    setOffHand((Weapon) e);
                }
                break;
            case 9:
                setRing(e);
                break;
            case 10:
                setHat(e);
                break;
            case 11:
                setGoggles(e);
                break;
        }
    }
}
