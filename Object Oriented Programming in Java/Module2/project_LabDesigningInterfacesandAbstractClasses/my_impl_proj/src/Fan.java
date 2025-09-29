public class Fan implements Switchable, Adjustable{
    private boolean isOn = false;
    private int speed = 1;

    // Switchable methods
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Fan is turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Fan is turned OFF.");
    }

    // Adjustable methods
    @Override
    public void increase() {
        if (speed < 3) {
            speed += 1;
            System.out.println("Speed increased to " + speed);
        } else {
            System.out.println("Speed is already at maximum.");
        }
    }

    @Override
    public void decrease() {
        if (speed > 0) {
            speed -= 1;
            System.out.println("Speed decreased to " + speed);
        } else {
            System.out.println("Speed is already at minimum.");
        }
    }

}