

public abstract class Program {

    private String name;
    private boolean isRunning = false;

    public Program() {

    }

    public Program(String name) {
        this.name = name;
        this.isRunning = false;
    }

    abstract void run();
    abstract void stop();

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }


}
