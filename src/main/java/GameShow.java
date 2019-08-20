import java.util.Arrays;
import java.util.Random;

public class GameShow {
  private Door[] possibleDoors = new Door[3];
  public Door[] getPossibleDoors() {
    return possibleDoors;
  }

  public GameShow() {
    Random randomNumberGenerator = new Random();
    for (int doorIterator = 0; doorIterator < 3; doorIterator++) {
      possibleDoors[doorIterator] = new Door(doorIterator + 1);
    }
    int randomNumberHolder = (randomNumberGenerator.nextInt(3));
    possibleDoors[randomNumberHolder].setPrize(true);
  }

  public void selectDoor(int doorNumber) {
    possibleDoors[doorNumber].setDoorSelected(true);
  }

  public void swapDoors() {
    int doorNumber = 0;
    for (int i = 0; i < 3; i++) {
      if (!getPossibleDoors()[i].getIsDoorOpen()) {
        doorNumber = i;
      }
    }
    Arrays.stream(getPossibleDoors()).forEach(door -> door.setDoorSelected(false));
    selectDoor(doorNumber);
  }

  public void openDoor() {
    boolean foundDoor = false;
    for (Door door : possibleDoors) {
      if (!door.getPrize() && !foundDoor && !door.getIsDoorSelected()) {
        door.setDoorOpen(true);
        foundDoor = true;
      }
    }
  }

  public boolean checkIfPrizeIsSelected() {
    for (Door door : possibleDoors) {
      if (door.getPrize() && door.getIsDoorSelected()) {
        return true;
      }
    }
    return false;
  }
}
