package studio.bowman.gamblegame;

/**
 * Created by Kikizzz on 2017.04.03..
 */

public class Utils {
    public boolean crashRunning;

    public Utils(boolean crashRunning) {
        this.crashRunning = crashRunning;
    }

    public boolean isCrashRunning() {
        return crashRunning;
    }

    public void setCrashRunning(boolean crashRunning) {
        this.crashRunning = crashRunning;
    }
}
