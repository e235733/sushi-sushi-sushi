package game.character.player;

import game.character.Character;

public class Player extends Character {
    
    public Player(String name, int hp, int power) {
        super(name, hp, power);
    }

    // シンプルな攻撃メソッド ナイフ
    public void knifeAttack() {
        System.out.println(this.name + " はナイフで切りつけた!");
    }

    // 範囲攻撃メソッド お茶
    public void teaAttack() {
        System.out.println(this.name + " はお茶を撒き散らした!");
    }

    // 敵を鈍化させるメソッド 納豆
    public void nattoAttack() {
        System.out.println(this.name + " は納豆を仕掛けた!");
    }

    // 回復するメソッド
    public void healed(int healAmount) {
        System.out.println(this.name + " は HP が " + healAmount + " 回復した！");
    }

}
