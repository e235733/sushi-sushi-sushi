package game.character.sushi;

import java.util.Random;

import game.character.player.Player;

public abstract class NigiriSushi extends Sushi {

    Random random = new Random();

    public NigiriSushi(String name, int maxHp, int power, int probability) {
        super(name, maxHp, power, probability);
    }

    // 握り寿司の攻撃は、叩いて相手にダメージを与える
    @Override
    protected void attack(Player target) {
        System.out.println(this.name + " が叩いてきた！");
        target.damaged(this.power);
    }
}
