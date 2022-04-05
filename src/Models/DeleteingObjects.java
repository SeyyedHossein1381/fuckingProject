package Models;

public class DeleteingObjects {
    private int origin;
    private int destination;
    int line;
    private char direction;
    public DeleteingObjects(int origin ,int destination , int line , char direction){
        this.origin = origin;
        this.destination = destination;
        this.direction = direction;
        this.line = line;
    }
}
