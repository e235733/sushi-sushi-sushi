package game.character.player;

import java.util.List;
import java.util.Random;

import game.character.sushi.Sushi;

public class NattoAttack extends Attack {
    
    private int probability;
    private Random random = new Random();

    public NattoAttack(int power, Player player, int probability) {
        super(power, player);
        this.probability = probability;
    }

    // 複数の敵を鈍化させるメソッド nattoAttack
    public void attack(List<Sushi> sushiList) {
        System.out.println(this.player.getName() + " は納豆を仕掛けた!");
    
        for (Sushi target : sushiList) {
            // 乱数を生成し、ヒットを確率的にする
            if (random.nextInt(100) < probability) {
                System.out.println(target.getName() + " がネバネバにかかった！");
                // ここに鈍化させるメソッドを書く
            }
        }
    }
}
