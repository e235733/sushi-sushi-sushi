package game.character.player;

import game.SushiList;

public class TeaAttack extends Attack{

    private int probability;
    
    public TeaAttack(int power, Player player, int probability) {
        super(power, player);
        this.probability = probability;
    }

    // お茶を撒き散らして複数の敵にダメージを与える teaAttack
    public int attack(SushiList sushiList) {
        int gotXp = 0;
        // sushi が存在するときのみ攻撃する
        if (sushiList.getNumSushi() != 0) {
            System.out.println(this.player.getName() + " はお茶を撒き散らした!");
            gotXp += sushiList.damagedAllAndGetSumXp(this.probability, this.power);
        }

        return gotXp;
    }
}
