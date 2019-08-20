public class Door {
  private int doorNumber;
  private boolean isPrize = false;
  private boolean isDoorOpen = false;
  private boolean isDoorSelected = false;

  public Boolean getPrize() {
    return isPrize;
  }

  public Boolean getIsDoorOpen() {
    return isDoorOpen;
  }

  public Boolean getIsDoorSelected() {
    return isDoorSelected;
  }

  public int getDoorNumber() {
    return doorNumber;
  }

  public void setDoorOpen(boolean open) {
    isDoorOpen = open;
  }

  public void setPrize(boolean prize) {
    isPrize = prize;
  }

  public void setDoorSelected(boolean doorSelected) {
    isDoorSelected = doorSelected;
  }

  public void setDoorNumber(int doorNumber) {
    this.doorNumber = doorNumber;
  }

  public Door(int doorNumber) {
    setDoorNumber(doorNumber);
  }
}
