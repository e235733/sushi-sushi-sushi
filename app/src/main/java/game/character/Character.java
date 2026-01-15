package game.character;

public abstract class Character {

    protected String name;
    protected int maxHp;
    protected int hp;
    protected int power;

    private boolean isDead;

    public Character(String name, int maxHp, int power) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.power = power;

        this.isDead = false;
    }

    // ダメージを受けるメソッド
    public void damaged(int power) {
        System.out.println(this.name + " は " + power + " ダメージを受けた！");
        // 0を下回らないようにする
        this.hp = Math.max(this.hp - power, 0);
        System.out.println(this.name + "の HP は " + this.hp + " になった！");

        // 死亡判定
        if (this.hp == 0) {
            isDead = true;
            System.out.println(this.name + " は死亡した！");
        }
    }

    // 名前の getter
    public String getName() {
        return this.name;
    }

    // HP の getter
    public int getHp() {
        return this.hp;
    }

    // 攻撃力 の getter
    public int getPower() {
        return this.power;
    }

    // 死亡確認
    public boolean isDead() {
        return this.isDead;
    }
}
