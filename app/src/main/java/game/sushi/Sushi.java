package game.sushi;

public abstract class Sushi {
    protected String name;
    protected int hp;
    protected int power;

    public Sushi(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public void greeting() {
        System.out.println("Irasshaimase!");
    }
}
