import java.awt.*;

class GeomPoint extends Point {

    public GeomPoint(int ptx, int pty){
        this.x = ptx;
        this.y = pty;
    }

    int min(int a, int b){
        return Math.min(a, b);
    }

    int max(int a, int b){
        return Math.max(a, b);
    }
}
