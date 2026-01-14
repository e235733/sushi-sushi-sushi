package game.character;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int power;

    public Character(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public void greeting() {
        System.out.println("Hello!");
    }

    // ダメージを受けるメソッド
    public void damaged(int power) {
        System.out.println(this.name + " は " + power + " ダメージを受けた！");
    }

    // 名前の getter
    public String getName() {
        return this.name;
    }
}
