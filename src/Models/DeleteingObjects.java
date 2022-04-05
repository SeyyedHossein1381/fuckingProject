package Models;

public class DeleteingObjects {
    private int origin;
    private int destination;
    int line;
    private char diriction;
    public DeleteingObjects(int origin ,int destination , int line , char direction){
        this.origin = origin;
        this.destination = destination;
        this.diriction = direction;
        this.line = line;
    }
}
