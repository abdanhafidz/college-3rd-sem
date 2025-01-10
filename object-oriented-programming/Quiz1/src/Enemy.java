public class Enemy {
    // Properties/fields
    private String name;  // The name of the enemy
    private int health;   // The health points of the enemy
    private int power;    // The attack power of the enemy
    private int defense;  // The defense points of the enemy

    // Constructor
    public Enemy(String name, int health, int power, int defense) {
        // Initializes the enemy's attributes with the provided values
        this.name = name;
        this.health = health;
        this.power = power;
        this.defense = defense;
    }
    
    // Getters and Setters
    public String getName() {
        return name;  // Returns the name of the enemy
    }

    public void setName(String name) {
        this.name = name;  // Sets the name of the enemy
    }

    public int getHealth() {
        return health;  // Returns the health points of the enemy
    }

    public void setHealth(int health) {
        this.health = health;  // Sets the health points of the enemy
    }

    public int getPower() {
        return power;  // Returns the attack power of the enemy
    }

    public void setPower(int power) {
        this.power = power;  // Sets the attack power of the enemy
    }

    public int getDefense() {
        return defense;  // Returns the defense points of the enemy
    }

    public void setDefense(int defense) {
        this.defense = defense;  // Sets the defense points of the enemy
    }

    // Method to attack the player
    public void attack(Player player) {
        // Outputs the attack action
        System.out.println(this.name + " attacks " + player.getName());
        // Calls the takeDamage method on the player with this enemy's power
        player.takeDamage(this.power);
    }

    // Method to take damage from player
    public void takeDamage(int attackPower) {
        // Calculate the damage by subtracting defense from the attack power
        int damage = attackPower - this.defense;
        if (damage < 0) {
            damage = 0; // Prevents healing from negative damage
        }
        // Reduce the enemy's health by the damage amount
        this.health -= damage;
        // Output the damage taken and the remaining health
        System.out.println(this.name + " takes " + damage + " damage. Remaining health: " + this.health);
        // Check if the enemy's health has dropped to zero or below
        if (this.health <= 0) {
            System.out.println(this.name + " died!");  // Outputs a death message if the enemy is defeated
        }
    }
}
