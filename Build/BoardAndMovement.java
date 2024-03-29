package Build;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardAndMovement {
    public static ArrayList<int[]> activeSpots = new ArrayList<>();
    public int[][] direction = new int[6][3];

    public static void main(String[] args) {
        BoardAndMovement bm = new BoardAndMovement();
        int[] a = {1,2,3};
        int[] d = {1,2,3};
        int[] b = {4,5,7};
        int[] c = {3,3,3};
        int[] e = {3,3,4};

        activeSpots.add(a);
        activeSpots.add(b);
        System.out.println("valid move dbc: " + bm.validMove(d, b, c));
        d[0] = 1;
        d[1] = 2;
        d[2] = 3;
        System.out.println("valid move dbe: " + bm.validMove(d, b, e));
        bm.removeSpot(d);
        bm.removeSpot(c);

        /*
         * Still to do: 
         * setStartSpots
         * Determine which direction the player is attempting to go 
         * logic of when to remove the spot****
         */
    }
    public void setDirections(){
        //each array contains 3 values representing q,r, and s (direction[n][0-2])
        //q is the movement \, r is the movement -, and s is the movement /

        // \ up
        direction[0][0] = 0;
        direction[0][1] = -1;
        direction[0][2] = 1;
        // \ down 
        direction[1][0] = 0;
        direction[1][1] = 1;
        direction[1][2] = -1;
        
        // - left
        direction[2][0] = -1;
        direction[2][1] = 0;
        direction[2][2] = 1;
        // - right 
        direction[3][0] = 1;
        direction[3][1] = 0;
        direction[3][2] = -1;

        // / up
        direction[4][0] = 1;
        direction[4][1] = -1;
        direction[4][2] = 0;
        // / down
        direction[5][0] = -1;
        direction[5][1] = 1;
        direction[5][2] = 0;
    }

    public void setStartSpots(){
        //TO DO: add all coordinates to activeSpots
    }

    public void removeSpot(int[] spot){ 
        for (int[] tempArray : activeSpots) {
            if(Arrays.equals(tempArray, spot))
            {
                activeSpots.remove(tempArray);
                System.out.println(Arrays.toString(spot) + " removed successfully");
                break;
            }
            else if(activeSpots.indexOf(tempArray) == activeSpots.size()-1){
                System.out.println(Arrays.toString(spot) + " is not in the array");
            }
        }

    }

    //NOTE: Only works if you do not hand the actual memory address from activeSpots
    //If current's address is in activeSpots, current's values will change, messing up the board
    public boolean validMove(int[] current, int[] desired, int[] direction) {
        //if current not in activeSpots return false
        for (int[] tempArray : activeSpots) {
            if(Arrays.equals(tempArray, current))
                break;
            else if(tempArray.equals(activeSpots.get(activeSpots.size()-1)))
                {
                    //System.out.println("Not in activeSpots");
                    return false;
                }
        }
        //else if current is the desired location
        if(Arrays.equals(current,desired))
        {
            //System.out.println("Current == desired");
            return true;
        }
        //else
        else {
            //System.out.println("Not yet equal");
            for(int i = 0; i < 3; i++) {
                current[i] += direction[i];
            }
            return validMove(current, desired, direction);
        }
    }
}
