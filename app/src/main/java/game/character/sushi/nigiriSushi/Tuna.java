package game.character.sushi.nigiriSushi;

public class Tuna extends NigiriSushi {

    // 名前は マグロ
    private static String name = "マグロ";
    // maxHp = 100 + 10 * level
    private static int maxHpIntercept = 100;
    private static int maxHpSlope = 10;
    // power = 20 + 10 * level
    private static int powerIntercept = 20;
    private static int powerSlope = 10;

    public Tuna(int level) {
        
        super(name, maxHpIntercept, maxHpSlope, powerIntercept, powerSlope, level);
    }
}
