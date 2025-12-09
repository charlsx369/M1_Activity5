

public class MSExcel extends Program {

    public MSExcel(String name) {
        this.setName(name);
        this.setIsRunning(false);
    }

    @Override
    public void run() {
        String message = "Opening MS Excel...";
                System.out.println(message);

    }

    @Override
    public void stop() {
        String message = "Stopping MS Excel...";
                System.out.println(message);
    }

    @Override
    public boolean getIsRunning(){
        return false;
    }

}
