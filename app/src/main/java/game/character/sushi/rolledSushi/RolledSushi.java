package game.character.sushi.rolledSushi;

import game.character.sushi.Sushi;
import game.character.player.Player;

public abstract class RolledSushi extends Sushi {

    // 巻き寿司の攻撃確率は 30 %
    private static int probability = 30;
    
    public RolledSushi(String name, int maxHpIntercept, int maxHpSlope, int powerIntercept, int powerSlope, int level) {

        super(name, probability, maxHpIntercept, maxHpSlope, powerIntercept, powerSlope, level);
    }

    // 巻き寿司の攻撃は、体当たりで大ダメージを与えるが自滅する
    @Override
    protected void attack(Player target) {
        System.out.println(this.name + " が転がってきた！");
        target.damaged(this.power);
        // 体当たりをすると死亡する
        this.hp = 0;
        this.isDead = true;
    }
}
