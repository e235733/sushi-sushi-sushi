package game.character.sushi;

import game.character.player.Player;

public abstract class RolledSushi extends Sushi {
    
    public RolledSushi(String name, int maxHp, int power, int probability) {
        super(name, maxHp, power, probability);
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
