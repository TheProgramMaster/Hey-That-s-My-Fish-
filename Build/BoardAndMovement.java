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

    public void setStartSpots(){
        activeSpots.clear();
        
    }

    //takes two int[] of 3 values and returns an int[] of the direction between the two points
    //returns null if the desired cannot be accessed in a straight line
    public int[] getDirection(int[] current, int[] desired) {
        //each array contains 3 values representing q,r, and s
        //q is the movement \, r is the movement -, and s is the movement /

        int q = current[0] - desired[0];
        int r = current[1] - desired[1];
        int s = current[2] - desired[2];

        if(q == 0 && r > 0 && s < 0)
            return new int[]{0,-1,1};
        else if(q == 0 && r < 0 && s > 0)
            return new int[]{0,1,-1};
        else if(q < 0 && r == 0 && s > 0)
            return new int[]{-1,0,1};
        else if(q > 0 && r == 0 && s < 0)
            return new int[]{1,0,-1};
        else if(q > 0 && r < 0 && s == 0)
            return new int[]{1,-1,0};
        else if(q < 0 && r > 0 && s == 0)
            return new int[]{-1,1,0};
        else
            return null;    
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
