package game.character.sushi;

public abstract class NigiriSushi extends Sushi {
    public NigiriSushi(String name, int hp, int power) {
        super(name, hp, power);
    }

    public void slap() {
        System.out.println(this.name + " slapped!");
    }
}
