package game.character.player;

import java.util.Random;

import game.SushiList;

public class TeaAttack extends Attack{

    private int probability;
    private Random random = new Random();
    
    public TeaAttack(int power, Player player, int probability) {
        super(power, player);
        this.probability = probability;
    }

    // お茶を撒き散らして複数の敵にダメージを与える teaAttack
    public void attack(SushiList sushiList) {
        System.out.println(this.player.getName() + " はお茶を撒き散らした!");

        for (int targetId=0; targetId < sushiList.getNumSushi(); targetId++) {
            // 一定の確率でヒットする
            if (random.nextInt(100) < probability) {
                System.out.println(sushiList.getName(targetId) + " にお茶がかかった！");
                sushiList.damaged(targetId, this.power);
            }
        }
    }
}
