package game.character.player;

import java.util.List;
import java.util.Random;

import game.character.Character;
import game.character.sushi.Sushi;

public class Player extends Character {

    Random random = new Random();
    
    public Player(String name, int hp, int power) {
        super(name, hp, power);
    }

    // シンプルな攻撃メソッド ナイフ
    public void knifeAttack(Sushi target) {
        System.out.println(this.name + " は " + target.getName() + " をナイフで切りつけた!");
        target.damaged(this.power);
    }

    // 範囲攻撃メソッド お茶
    public void teaAttack(List<Sushi> targetList) {
        System.out.println(this.name + " はお茶を撒き散らした!");

        for (Sushi target : targetList) {
            System.out.println(target.getName() + " にお茶がかかった！");
        }
    }

    // 一部の敵を鈍化させるメソッド 納豆
    public void nattoAttack(List<Sushi> targetList) {
        System.out.println(this.name + " は納豆を仕掛けた!");
    
        for (Sushi target : targetList) {
            // 乱数を生成し、ヒットを確率的にする
            if (random.nextInt(100) < 50) {
                System.out.println(target.getName() + " がネバネバにかかった！");
            }
        }
    }

    // 回復するメソッド
    public void healed(int healAmount) {
        System.out.println(this.name + " は HP が " + healAmount + " 回復した！");
    }

}
