

public class MSWord extends Program{

    public MSWord(String name) {
        this.setName(name);
        this.setIsRunning(false);
    }

    @Override
    public void run() {
        System.out.println("Opening MS Word...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping MS Word...");
    }

    @Override
    public boolean getIsRunning(){
        return false;
    }
}
