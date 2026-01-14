package game.character.sushi;

import game.character.Character;

public abstract class Sushi extends Character{

    public Sushi(String name, int hp, int power) {
        super(name, hp, power);
    }

    @Override
    public void greeting() {
        System.out.println("Irasshaimase!");
    }
}
