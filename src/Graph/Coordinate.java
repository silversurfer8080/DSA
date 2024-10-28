package Graph;

import java.util.Objects;

public class Coordinate {
    //represent the row coordinate
    int r;
    //represent the column coordinate
    int c;
    public Coordinate(int r, int c){
        this.r = r;
        this.c = c;
    }
    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if ((obj instanceof Coordinate) && ((Coordinate) obj).r == r && ((Coordinate) obj).c == c) {
            return true;
        }
        return false;
    }
}
