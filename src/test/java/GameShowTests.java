import java.util.Arrays;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class GameShowTests {
  private int swapWins = 0;
  private int stayWins = 0;

  @Test
  public void onlyDoorWithGoatCanBeOpened() {
    GameShow testGame = new GameShow();
    testGame.openDoor();
    Assert.assertEquals(1, Arrays.stream(testGame.getPossibleDoors())
        .filter(door -> door.getIsDoorOpen() && !door.getPrize())
        .count());
  }

  @Test
  public void winConditionFiresOffCorrectly() {
    GameShowStub testGame = new GameShowStub(true);
    testGame.openDoor();
    testGame.getPossibleDoors()[2].setDoorSelected(true);
    Assert.assertTrue(testGame.checkIfPrizeIsSelected());
  }

  @Test
  public void winConditionFailsCorrectly() {
    GameShowStub testGame = new GameShowStub(false);
    testGame.openDoor();
    testGame.getPossibleDoors()[2].setDoorSelected(true);
    Assert.assertFalse(testGame.checkIfPrizeIsSelected());
  }

  @Test
  public void swapDoorsUnselectsOldDoor() {
    GameShowStub testGame = new GameShowStub(false);
    testGame.openDoor();
    testGame.getPossibleDoors()[1].setDoorSelected(true);
    testGame.swapDoors();
    Assert.assertFalse(testGame.getPossibleDoors()[1].getIsDoorSelected());
  }

  @Test
  public void swapDoorsDoesNotSwapToSameDoor() {
    GameShow testGame = new GameShow();
    testGame.getPossibleDoors()[2].setDoorSelected(true);
    testGame.openDoor();
    testGame.swapDoors();
    Assert.assertFalse(testGame.getPossibleDoors()[2].getIsDoorSelected());
  }

  @Test
  public void simulateOneThousandGames() {
    simulateFiveHundredStays();
    simulateFiveHundredSwaps();
    int swapAverage = (swapWins * 100) / 500;
    int stayAverage = (stayWins * 100) / 500;
    System.out.println("The average percent of wins for swaps: " + swapAverage + "%");
    System.out.println("The average percent of wins for stays: " + stayAverage + "%");
    Assert.assertTrue(swapAverage > 40);
    Assert.assertTrue(stayAverage < 40);
  }

  public void simulateFiveHundredStays() {
    for (int i = 0; i < 500; i++) {
      GameShow testGame = new GameShow();
      Random randomNumberGenerator = new Random();
      testGame.selectDoor(randomNumberGenerator.nextInt(3));
      testGame.openDoor();
      if (testGame.checkIfPrizeIsSelected()) {
        stayWins++;
      }
    }
  }

  public void simulateFiveHundredSwaps() {
    for (int i = 0; i < 500; i++) {
      GameShow testGame = new GameShow();
      Random randomNumberGenerator = new Random();
      testGame.selectDoor(randomNumberGenerator.nextInt(3));
      testGame.openDoor();
      testGame.swapDoors(); //use stub
      if (testGame.checkIfPrizeIsSelected()) {
        swapWins++;
      }
    }
  }
}
