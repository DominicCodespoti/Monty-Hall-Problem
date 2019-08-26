public class GameShowStub extends GameShow {

  public GameShowStub(boolean playerWins) {
    getPossibleDoors()[0] = new Door();
    getPossibleDoors()[1] = new Door();
    getPossibleDoors()[2] = new Door();
    if (playerWins) {
      getPossibleDoors()[2].setPrize(true);
    } else {
      getPossibleDoors()[1].setPrize(true);
    }
  }

  @Override
  public void selectDoor(int doorNumber) {
    getPossibleDoors()[2].setDoorSelected(true);
  }
}
