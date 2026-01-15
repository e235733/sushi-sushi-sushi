package game;

import game.GameManager.SushiType;
import game.character.sushi.CucumberRoll;
import game.character.sushi.Sushi;
import game.character.sushi.Tuna;

public class SushiGenerator {
    // 寿司を作成するメソッド
    public Sushi generate(SushiType sushiType) {
        switch (sushiType) {
            case TUNA:
                return new Tuna(100, 10, 50);
            case CUCUMBER_ROLL:
                return new CucumberRoll(50, 50, 30);
            default:
                throw new IllegalArgumentException("unknown sushi: " + sushiType);
        }
    }
}
