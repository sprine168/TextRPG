package textrpg;//All living things in the game (The textrpg.Player, NPCs, and textrpg.monsters) inherit this class

public class Entity {
    private String name;
    private int baseHealth, currentHealth, maxHealth;
    private int baseMana, currentMana, maxMana;
    private int baseStrength, currentStrength;
    private int baseMagic, currentMagic;
    private int baseAgility, currentAgility;
    private int baseDefense, currentDefense;
    private int baseMagicDefense, currentMagicDefense;
    
    public String getName(){return name;}
    public void setName(String input){name = input;}
    
    public int getCurrentHealth() {
        if (currentHealth < 0) {
            return 0;
        }
        return currentHealth;
    }
    public void setCurrentHealth(int input){currentHealth = input;} 
    public int getBaseHealth(){return baseHealth;}
    public void setBaseHealth(int input){baseHealth = input;}
    public int getMaxHealth(){return maxHealth;}
    public void setMaxHealth(int input){maxHealth = input;}
    
    public int getCurrentMana() {
        if (currentMana < 0) {
            return 0;
        }
        return currentMana;
    }
    public void setCurrentMana(int input){currentMana = input;}
    public int getBaseMana(){return baseMana;}
    public void setBaseMana(int input){baseMana = input;}
    public int getMaxMana(){return maxMana;}
    public void setMaxMana(int input){maxMana = input;}
    
    public int getCurrentStrength() {
        if (currentStrength < 0) {
            return 0;
        }
        return currentStrength;
    }
    public void setCurrentStrength(int input){currentStrength = input;}
    public int getBaseStrength(){return baseStrength;}
    public void setBaseStrength(int input){baseStrength = input;}
    
    public int getCurrentMagic() {
        if (currentMagic < 0) {
            return 0;
        }
        return currentMagic;
    }
    public void setCurrentMagic(int input){currentMagic = input;}
    public int getBaseMagic(){return baseMagic;}
    public void setBaseMagic(int input){baseMagic = input;}
    
    public int getCurrentAgility() {
        if (currentAgility < 0) {
            return 0;
        }
        return currentAgility;
    }
    public void setCurrentAgility(int input){currentAgility = input;}
    public int getBaseAgility(){return baseAgility;}
    public void setBaseAgility(int input){baseAgility = input;}
    
    public int getCurrentDefense() {
        if (currentDefense < 0) {
            return 0;
        }
        return currentDefense;
    }
    public void setCurrentDefense(int input){currentDefense = input;}
    public int getBaseDefense(){return baseDefense;}
    public void setBaseDefense(int input){baseDefense = input;}
    
    public int getCurrentMagicDefense() {
        if (currentMagicDefense < 0) {
            return 0;
        }
        return currentMagicDefense;
    }
    public void setCurrentMagicDefense(int input){currentMagicDefense = input;}
    public int getBaseMagicDefense(){return baseMagicDefense;}
    public void setBaseMagicDefense(int input){baseMagicDefense = input;}
    
    public void initCurrentStats(){
        currentHealth = baseHealth;
        currentMana = baseMana;
        currentStrength = baseStrength;
        currentMagic = baseMagic;
        currentAgility = baseAgility;
        currentDefense = baseDefense;
        currentMagicDefense = baseMagicDefense;
    }
}