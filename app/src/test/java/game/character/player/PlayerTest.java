package game.character.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import game.InputManager;

class PlayerTest {

    private InputManager inputManager = new InputManager();

    private int maxHp = 50;
    Player testMan = new Player("TestMan", maxHp, this.inputManager);
    
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
