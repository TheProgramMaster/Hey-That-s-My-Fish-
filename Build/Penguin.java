package Build;

public class Penguin {
    //private static int[] position = {2,8,7};
    private static BoardAndMovement bm;
    int[] location = new int[4];
    Penguin(BoardAndMovement bam) { 
        bm = bam;
    }
    
    //If a penguin is completely isolated, returns true. Else, returns false
    public boolean penguinIsolation() {
        int[][] directions = {{0,-1,1},{0,1,-1},{-1,0,1},{1,0,-1},{1,-1,0},{-1,1,0}};
        int[] desired = new int[3];
        for(int[] i : directions) {
            desired[0] = location[0] + i[0];
            desired[1] = location[1] + i[1];
            desired[2] = location[2] + i[2];
            if(bm.validMove(location, desired, i) == true) {
                return false;
            } 
        }
        return true;
    }

    public void setLocation(int[] newLocation) {
        if(bm.validMove(location, newLocation, newLocation)) {
            bm.removeSpot(location);
            //TO DO: Add any points? Or are we handling that fully front end? 
            location = newLocation;
        }
    }
}
