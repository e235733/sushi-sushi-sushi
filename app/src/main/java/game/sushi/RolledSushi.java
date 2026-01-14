package game.sushi;

public abstract class RolledSushi extends Sushi {
    public RolledSushi(String name, int hp, int power) {
        super(name, hp, power);
    }

    public void roll() {
        System.out.println(this.name + " rolled!");
    }
}
