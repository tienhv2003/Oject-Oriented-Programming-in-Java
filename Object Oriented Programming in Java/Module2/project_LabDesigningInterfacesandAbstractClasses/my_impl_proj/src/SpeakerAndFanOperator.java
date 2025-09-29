public class SpeakerAndFanOperator {
    public static void main(String s[])
    {
        SmartSpeaker spker = new SmartSpeaker();
        Fan f1 = new Fan();

        System.out.println("Speaker check");
        spker.turnOn();
        spker.turnOff();
        spker.connect();
        spker.disconnect();
        spker.increaseVol();
        spker.decreaseVol();

        System.out.println("Fan check");
        f1.turnOn();
        f1.turnOff();
        f1.increase();
        f1.decrease();
    } 
}