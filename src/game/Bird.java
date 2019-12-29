package game;

public class Bird {

    int y;
    int vel;

    public Bird(int y, int vel){
        this.y = y;
        this.vel = vel;
    }

    public static void changeY(Bird bird){
        bird.y -= bird.vel;
    }

    public static void changeVel(Bird bird){
        bird.vel -= 1;
    }

    public static void checkStatus(Bird bird){
        if (bird.y > 420 || bird.y < 0){
            Driver.running = false;
        }
    }

}
