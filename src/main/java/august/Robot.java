package august;


import lombok.Data;

@Data
public class Robot {
    private double x = 250;
    private double y = 250;
    private double speed = 1;
    public double turnSpeed = 0.75;
    private double heading = 0;
    private int width = 10;
    private int height = 10;

    public void turnLeft(){
        heading += turnSpeed;
        if (heading >= 360){
            heading -= 360;
        }
    }

    public void turnRight(){
        heading -= turnSpeed;
        if (heading >= 360){
            heading -= 360;
        }
    }

    public void moveForward(){
        double rad = Math.toRadians(heading);
        x += speed * Math.cos(rad);
        y += speed * Math.sin(rad);
    }

    public void moveBack(){
        double rad = Math.toRadians(heading);
        x -= speed * Math.cos(rad);
        y -= speed * Math.sin(rad);
    }

    public String getDetails(){
        return String.format("position: (%.2F, %.2F) heading: %.1F", x, y, heading);
    }

}
