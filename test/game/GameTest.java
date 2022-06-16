package game;


import org.junit.Test;

public class GameTest {

    @Test(expected = Exception.class)
    public void executeMethod_shouldThrowException_ifFileNotFound() throws Exception {
        JSONRead.readJSON("RandomText1");
    }
}