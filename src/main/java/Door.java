public class Door {
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

  public void setDoorOpen(boolean open) {
    isDoorOpen = open;
  }

  public void setPrize(boolean prize) {
    isPrize = prize;
  }

  public void setDoorSelected(boolean doorSelected) {
    isDoorSelected = doorSelected;
  }
}
