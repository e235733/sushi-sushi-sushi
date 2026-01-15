package game.character.sushi;

import game.character.player.Player;

public abstract class RolledSushi extends Sushi {
    
    public RolledSushi(String name, int hp, int power) {
        super(name, hp, power);
    }

    // 巻き寿司の攻撃 roll は、体当たりで大ダメージを与えるが自滅する
    public void roll(Player target) {
        System.out.println(this.name + " rolled!");
        target.damaged(this.power);
    }
}
