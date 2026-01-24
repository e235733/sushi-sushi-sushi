package game.character.player;

import java.util.List;
import java.util.Random;

import game.character.sushi.Sushi;

public class TeaAttack extends Attack{

    private int probability;
    private Random random = new Random();
    
    public TeaAttack(int power, Player player, int probability) {
        super(power, player);
        this.probability = probability;
    }

    // お茶を撒き散らして複数の敵にダメージを与える teaAttack
    public void attack(List<Sushi> sushiList) {
        System.out.println(this.player.getName() + " はお茶を撒き散らした!");

        for (Sushi target : sushiList) {
            // 一定の確率でヒットする
            if (random.nextInt(100) < probability) {
                System.out.println(target.getName() + " にお茶がかかった！");
                target.damaged(power);
            }
        }
    }
}
