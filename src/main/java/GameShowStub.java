public class GameShowStub extends GameShow {

  public GameShowStub(boolean playerWins) {
    if (playerWins) {
      for (int doorIterator = 0; doorIterator < 3; doorIterator++) {
        getPossibleDoors()[doorIterator] = new Door(doorIterator + 1);
      }
      getPossibleDoors()[2].setPrize(true);
    } else {
      for (int doorIterator = 0; doorIterator < 3; doorIterator++) {
        getPossibleDoors()[doorIterator] = new Door(doorIterator + 1);
      }
      getPossibleDoors()[1].setPrize(true);
    }
  }

  @Override
  public void selectDoor(int doorNumber) {
    getPossibleDoors()[2].setDoorSelected(true);
  }
}
