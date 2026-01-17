package game.character.sushi.rolledSushi;

public class CucumberRoll extends RolledSushi {

    // 名前は かっぱ巻き
    private static String name = "かっぱ巻き";
    // maxHp = 50 + 5 * level
    private static int maxHpIntercept = 50;
    private static int maxHpSlope = 5;
    // power = 30 + 20 * level
    private static int powerIntercept = 30;
    private static int powerSlope = 20;

    public CucumberRoll(int level) {

        super(name, maxHpIntercept, maxHpSlope, powerIntercept, powerSlope, level);
    }
}
