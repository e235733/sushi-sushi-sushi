package game.character.player;

import game.SushiList;

public class TeaAttack extends Attack{

    private int probability;
    
    public TeaAttack(int power, Player player, int probability) {
        super(power, player);
        this.probability = probability;
    }

    // お茶を撒き散らして複数の敵にダメージを与える teaAttack
    public void attack(SushiList sushiList) {
        System.out.println(this.player.getName() + " はお茶を撒き散らした!");
        sushiList.damagedAll(this.probability, this.power);
    }
}
