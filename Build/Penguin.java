package Build;

import java.util.Arrays;
import java.util.Optional;

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

        if(location[0] == 0) {
            if (bm.activeSpots.stream().anyMatch(a -> Arrays.equals(a, 0, 3, newLocation, 0,3))
            && bm.activePenguins.stream().noneMatch(a -> Arrays.equals(a.location, 0, 3, newLocation, 0,3)))
            {
                int[] aSpot = bm.activeSpots.stream().filter(a -> Arrays.equals(a, 0, 3, newLocation, 0,3)).findFirst().get();
                if(aSpot[3] == 1) {
                    location = newLocation;
                    return true;
                }
            }

            //All below for printing tests 
            //Can be deleted once testing is complete
            Optional<int[]> b = bm.activeSpots.stream().filter(a -> Arrays.equals(a, 0, 3, newLocation, 0,3)).findFirst();
            if(b.isPresent()) {
                System.out.println(Arrays.toString(b.get())+ " is occupied or not 1-fish");
            } else {
                System.out.println(Arrays.toString(newLocation) + " is missing");
            }  

            return false;
        }
        
        if(bm.validMove(this, newLocation)) {
            bm.removeSpot(location);
            location = newLocation;
            return true;
        }
        System.out.println(Arrays.toString(newLocation) + " is not a valid location");
        return false;
    }

    /*
     public boolean setLocation(int[] newLocation) {
        //if a location hasn't been set yet

        if(location[0] == 0) {
            if (BoardAndMovement.activeSpots.stream().anyMatch(a -> Arrays.equals(a, 0, 3, newLocation, 0,3))) {
                for(Penguin p : BoardAndMovement.activePenguins) {
                    if(Arrays.equals(p.location,newLocation)) {
                        System.out.println(Arrays.toString(newLocation) + " is occupied");
                        return false;
                    }
                }
                int[] aSpot = BoardAndMovement.activeSpots.stream().filter(a -> Arrays.equals(a, 0, 3, newLocation, 0,3)).findFirst().get();
                if(aSpot[3] == 1) {
                    System.out.println(Arrays.toString(newLocation) + " is not occupied and is a one fish");
                    location = newLocation;
                    return true;
                } else {
                    System.out.println(Arrays.toString(newLocation) + " is not occupied but has " + aSpot[3] + " fish");
                    return false;
                }
            }
            
            //All below for printing tests 
            //Can be deleted once testing is complete
            Optional<int[]> b = BoardAndMovement.activeSpots.stream().filter(a -> Arrays.equals(a, 0, 3, newLocation, 0,3)).findFirst();
            if(b.isPresent()) {
                System.out.println(Arrays.toString(b.get())+ " is occupied or not 1-fish");
            } else {
                System.out.println(Arrays.toString(newLocation) + " is missing");
            }  

            return false;
        }
        
        if(bm.validMove(this, newLocation)) {
            //System.out.println("\t" + Arrays.toString(location));
            bm.removeSpot(location);
            location = newLocation;
            return true;
        }
        System.out.println(Arrays.toString(newLocation) + " is not a valid location");
        return false;
    }
     */
}
