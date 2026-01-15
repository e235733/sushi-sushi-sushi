package game.character.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private int maxHp = 50;
    Player testMan = new Player("TestMan", maxHp, 0);
    
    @Test
    void hpIsZeroOrHigher() throws Exception {
        testMan.damaged(100);
        assertEquals(testMan.getHp(), 0);
    }

    @Test
    void declarationOfDeath() throws Exception {
        testMan.damaged(100);
        assertEquals(testMan.isDead(), true);
    }

    @Test
    void hpIsMaxHpOrLower() throws Exception {
        testMan.damaged(10);
        testMan.healed(20);
        assertEquals(testMan.getHp(), this.maxHp);
    }
}
