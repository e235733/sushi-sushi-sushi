package game.character.sushi.nigiriSushi;

import game.character.sushi.Sushi;
import game.character.player.Player;

public abstract class NigiriSushi extends Sushi {

    // 握り寿司の攻撃確率は 50 %
    private static int probability = 50;

    public NigiriSushi(String name, int maxHpIntercept, int maxHpSlope, int powerIntercept, int powerSlope, int level) {

        super(name, probability, maxHpIntercept, maxHpSlope, powerIntercept, powerSlope, level);
    }

    // 握り寿司の攻撃は、叩いて相手にダメージを与える
    @Override
    protected void attack(Player target) {
        System.out.println(this.name + " が叩いてきた！");
        target.damaged(this.power);
    }
}
