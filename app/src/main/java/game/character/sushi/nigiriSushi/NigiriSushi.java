package game.character.sushi.nigiriSushi;

import game.character.sushi.Sushi;
import game.character.player.Player;

import java.util.Random;

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
