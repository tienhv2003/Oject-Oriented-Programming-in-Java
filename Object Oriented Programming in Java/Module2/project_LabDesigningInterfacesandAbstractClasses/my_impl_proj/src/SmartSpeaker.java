class SmartSpeaker implements Switchable, Connectable, Volume {
    private boolean isOn = false;
    private boolean isConnected = false;
    private int volume = 50;

    @Override
    public void turnOn(){
        isOn = true;
        System.out.println("Speaker is ON ");
    }

    @Override
    public void turnOff(){
        isOn = false;
        System.out.println("Speaker is OFF ");
    }

    @Override
    public void connect(){
        isConnected = true;
        System.out.println("Speaker is connected ");
    }

    @Override
    public void disconnect(){
        isConnected = false;
        System.out.println("Speaker is disconnected");
    }

    @Override
    public void increaseVol(){
        if (volume < 100){
            volume += 10;
            System.out.println("Volume of Speaker increased to " + volume);
        } else{
            System.out.println("Volume is already at maximum");
        }
    }

    @Override
    public void decreaseVol(){
        if (volume > 0) {
            volume += -(10);
            System.out.println("Volume of Speaker decreased to " + volume);
        } else{
            System.out.println("Volume is already at minimun");
        }
    }
}