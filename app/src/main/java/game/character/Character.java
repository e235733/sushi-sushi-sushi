package game.character;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int power;

    public Character(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public void greeting() {
        System.out.println("Hello!");
    }
}
