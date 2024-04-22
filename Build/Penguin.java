package Build;

import java.util.Arrays;

public class Penguin {
    BoardAndMovement bm;
    int[] location = new int[4];
    final int[][] directions = {{0,-1,1},{0,1,-1},{-1,0,1},{1,0,-1},{1,-1,0},{-1,1,0}};
    Penguin(BoardAndMovement bam) { 
        bm = bam;
    }
    
    //If a penguin is completely isolated, returns true. Else, returns false
    public boolean penguinIsolation() {
        int[] desired = new int[3];
        for(int[] i : directions) {
            desired[0] = location[0] + i[0];
            desired[1] = location[1] + i[1];
            desired[2] = location[2] + i[2];
            if(bm.validMove(this, desired) == true) {
                return false;
            } 
        }
        return true;
    }

    //Sets a new location and returns true if the move can be made 
    //Returns false the move cannot be made  
    public boolean setLocation(int[] newLocation) {
        //if a location hasn't been set yet
        //TO DO: Add 1 fish logic
        if(location[0] == 0 && 
        BoardAndMovement.activeSpots.stream().anyMatch(a -> Arrays.equals(a, 0, 3, newLocation, 0,3))) {
            location = Arrays.copyOf(newLocation,newLocation.length);
            return true;
        }
        if(bm.validMove(this, newLocation)) {
            System.out.println("\t" + Arrays.toString(location));
            bm.removeSpot(location);
            location = newLocation;
            return true;
        }
        System.out.println(Arrays.toString(newLocation) + " is not a valid location");
        return false;
    }
}
