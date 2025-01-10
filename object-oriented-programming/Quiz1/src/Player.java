public class Player {
    // Properties/fields
    private String name;   // The name of the player
    private int health;    // The health points of the player
    private int power;     // The attack power of the player
    private int defense;   // The defense points of the player

    // Constructor
    public Player(String name, int health, int power, int defense) {
        // Initializes the player's attributes with the provided values
        this.name = name;
        this.health = health;
        this.power = power;
        this.defense = defense;
    }

    // Getters and Setters
    public String getName() {
        return name;  // Returns the name of the player
    }

    public void setName(String name) {
        this.name = name;  // Sets the name of the player
    }

    public int getHealth() {
        return health;  // Returns the health points of the player
    }

    public void setHealth(int health) {
        this.health = health;  // Sets the health points of the player
    }

    public int getPower() {
        return power;  // Returns the attack power of the player
    }

    public void setPower(int power) {
        this.power = power;  // Sets the attack power of the player
    }

    public int getDefense() {
        return defense;  // Returns the defense points of the player
    }

    public void setDefense(int defense) {
        this.defense = defense;  // Sets the defense points of the player
    }

    // Method to attack the enemy
    public void attack(Enemy enemy) {
        // Outputs the attack action
        System.out.println(this.name + " attacks " + enemy.getName());
        // Calls the takeDamage method on the enemy with this player's power
        enemy.takeDamage(this.power);
    }

    // Method to take damage from enemy
    public void takeDamage(int attackPower) {
        // Calculate the damage by subtracting defense from the attack power
        int damage = attackPower - this.defense;
        if (damage < 0) {
            damage = 0; // Prevents healing from negative damage
        }
        // Reduce the player's health by the damage amount
        this.health -= damage;
        // Output the damage taken and the remaining health
        System.out.println(this.name + " takes " + damage + " damage. Remaining health: " + this.health);
        // Check if the player's health has dropped to zero or below
        if (this.health <= 0) {
            System.out.println(this.name + " died!");  // Outputs a death message if the player is defeated
        }
    }
}
