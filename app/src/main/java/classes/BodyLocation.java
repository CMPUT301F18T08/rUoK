package classes;

import java.util.Date;

public class BodyLocation {
    private static int touchX;
    private static int touchY;
    private String bodyLocation;


    public static int getTouchX() { return touchX; }
    public static int getTouchY() { return touchY; }

    public void setTouchX(int touchX) {this.touchX = touchX; }
    public void setTouchY(int touchY) {this.touchX = touchY; }
    public void setBodyLocation(String bodyLocation) {this.bodyLocation = bodyLocation; }

    public String getBodyLocation() { return  bodyLocation; }

    public void update(int touchX, int touchY){}
}
