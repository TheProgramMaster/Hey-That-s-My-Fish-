package Build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BoardAndMovement {
    public ArrayList<int[]> activeSpots = new ArrayList<>();
    public ArrayList<Penguin> activePenguins = new ArrayList<>();

    public static void main(String[] args) {
        BoardAndMovement bm = new BoardAndMovement();
        bm.setStartSpots(bm.numbers());
        
        bm.activePenguins.add(new Penguin(bm));
        bm.activePenguins.add(new Penguin(bm));
        /*bm.activePenguins.add(new Penguin(bm));
        bm.activePenguins.add(new Penguin(bm));
        bm.activePenguins.add(new Penguin(bm));
        bm.activePenguins.add(new Penguin(bm));
        bm.activePenguins.add(new Penguin(bm));
        bm.activePenguins.add(new Penguin(bm));

        bm.activePenguins.get(0).setLocation(new int[]{1,8,8});
        bm.activePenguins.get(1).setLocation(new int[]{5,1,11});
        bm.activePenguins.get(2).setLocation(new int[]{8,8,1});
        bm.activePenguins.get(3).setLocation(new int[]{11,1,5});
        bm.activePenguins.get(4).setLocation(new int[]{3,5,9});
        bm.activePenguins.get(5).setLocation(new int[]{5,8,4});
        bm.activePenguins.get(6).setLocation(new int[]{8,5,4});
        bm.activePenguins.get(7).setLocation(new int[]{6,3,8}); */
        bm.activePenguins.get(0).setLocation(new int[]{6,4,7});
        bm.activePenguins.get(1).setLocation(new int[]{6,4,7});

        bm.activeSpots.removeIf(a -> Arrays.equals(a, 0, 3, new int[]{10,1,6}, 0,3));
        bm.activeSpots.removeIf(a -> Arrays.equals(a, 0, 3, new int[]{10,2,5}, 0,3));
        bm.activeSpots.removeIf(a -> Arrays.equals(a, 0, 3, new int[]{9,3,5}, 0,3));
        bm.activeSpots.removeIf(a -> Arrays.equals(a, 0, 3, new int[]{9,4,4}, 0,3));
        bm.activeSpots.removeIf(a -> Arrays.equals(a, 0, 3, new int[]{10,4,3}, 0,3));

        ArrayList<int[]> unreachable = bm.checkForIsolation();
        for (int[] is : unreachable) {
            System.out.println(Arrays.toString(is));
        }
            System.out.println(unreachable.size());
        
        //bm.activePenguins.get(0).setLocation(new int[]{2,7,8});
        //bm.activePenguins.add(new Penguin(bm));
        //bm.activePenguins.get(1).setLocation(new int[]{1,8,8});
        /*for (Penguin i : activePenguins) {
            System.out.println("*" + Arrays.toString(i.location));
        }
        
        activePenguins.get(1).setLocation(new int[]{2,7,8});
        for (Penguin i : activePenguins) {
            System.out.println("*" + Arrays.toString(i.location));
        }*/
        //activePenguins.get(1).setLocation(new int[]{});
        //activePenguins.get(0).setLocation(new int[]{2,7,8});

        //System.out.println(Arrays.toString(activePenguins.get(0).location) + " equals: " + 
        //bm.match(activePenguins.get(0).location));
        //System.out.println(bm.validMove(activePenguins.get(0), new int[]{2,7,8}, new int[]{1,-1,0}));

        
    }

    public void addPenguins(Penguin p) {
        activePenguins.add(p);
    }

    //NOTE: TESTING METHOD
    //Used to test the setStartSpots method
    public List<Integer> numbers() {

        List<Integer> fishTiles = new ArrayList<>();
        fishTiles.clear();
        for (int i = 0; i < 60; i++) fishTiles.add(1);
        /*for (int i = 0; i < 30; i++) fishTiles.add(1);
        for (int i = 0; i < 20; i++) fishTiles.add(2);
        for (int i = 0; i < 10; i++) fishTiles.add(3);
        Collections.shuffle(fishTiles);*/
        return fishTiles;
    }
/* 
    //Commented out 4/22/24
    //Should be unnecessary
    public void setStartSpots() {
        Random rnd = new Random();
        int oneFish = 30;
        int twoFish = 20;
        int threeFish = 10;
        int q = 5;
        int r = 1;
        int s = 11;
        while(activeSpots.size() < 60){
            int fishChoice = rnd.nextInt(1,7);
            if((fishChoice == 1 || fishChoice == 2 || fishChoice == 3)&& oneFish > 0){
                oneFish--;
                activeSpots.add(new int[] {q,r,s,1});
            } else if((fishChoice == 4 || fishChoice == 5) && twoFish > 0) {
                twoFish--;
                activeSpots.add(new int[] {q,r,s,2});
            } else if(fishChoice == 6 && threeFish > 0) {
                threeFish--;
                activeSpots.add(new int[] {q,r,s,3});
            } else {
                continue;
            }
            
            //NOTE: Just hard-coding all the new lines
            //There is probably a more efficient way of doing this 
            if(q == 11 && s == 5){
                q = 4; 
                s = 11;
                r++;
            } else if(q == 11 && s == 4){
                q = 4; 
                s = 10;
                r++;
            } else if(q == 10 && s == 4){
                q = 3; 
                s = 10;
                r++;
            } else if(q == 10 && s == 3){
                q = 3; 
                s = 9;
                r++;
            } else if(q == 9 && s == 3){
                q = 2; 
                s = 9;
                r++;
            } else if(q == 9 && s == 2){
                q = 2; 
                s = 8;
                r++;
            } else if(q == 8 && s == 2){
                q = 1; 
                s = 8;
                r++;
            } else {
                q++;
                s--;
            }
        }
    } */
    public void setStartSpots(List<Integer> fishTiles) {
        activeSpots.clear();
        activePenguins.clear();
        int q = 5;
        int r = 1;
        int s = 11;
        int fishIndex = 0;
        for (int row = 0; row < 8; row++) {
            int numColsInRow = row % 2 == 0 ? 7 : 8;
            for (int col = 0; col < numColsInRow; col++) {
                activeSpots.add(new int[]{q,r,s,fishTiles.get(fishIndex)});
                q++;
                s--;
                fishIndex++;
            }
            for (int col = 0; col < numColsInRow; col++) {
                q--;
                s++;
            }
            if(numColsInRow == 7) {
                q--;
            } else {
                s--;
            }
            r++;
        }
    }

    //takes two int[] of 3 values and returns an int[] of the direction between the two points
    //returns null if the desired cannot be accessed in a straight line
    public int[] getDirection(int[] current, int[] desired) {
        //each array contains 3 values representing q,r, and s
        //q is the movement \, r is the movement -, and s is the movement /

        int q = desired[0] - current[0];
        int r = desired[1] - current[1];
        int s = desired[2] - current[2];

        if(q == 0 && r > 0 && s < 0)
            return new int[]{0,1,-1};
        else if(q == 0 && r < 0 && s > 0)
            return new int[]{0,-1,1};
        else if(q < 0 && r == 0 && s > 0)
            return new int[]{-1,0,1};
        else if(q > 0 && r == 0 && s < 0)
            return new int[]{1,0,-1};
        else if(q > 0 && r < 0 && s == 0)
            return new int[]{1,-1,0};
        else if(q < 0 && r > 0 && s == 0)
            return new int[]{-1,1,0};
        else
            return null;    //Not a straight path
    }

    public void removeSpot(int[] oldLocation){ 
        if(activeSpots.removeIf(a -> Arrays.equals(a, 0, 3, oldLocation, 0,3)))
            System.out.println(Arrays.toString(oldLocation) + " removed successfully");
        else 
            System.out.println(Arrays.toString(oldLocation) + " is not in the array");
    }


    public boolean validMove(Penguin p, int[] desired) {
        int[] current = Arrays.copyOf(p.location, p.location.length);
        int[] direction = getDirection(p.location, desired);
        if(direction == null)
            return false;
        
        //while there is an int[] in activeSpots matching current 
        while (activeSpots.stream().anyMatch(a -> Arrays.equals(a, 0, 3, current, 0,3))) {//Code via https://stackoverflow.com/questions/4849051/using-contains-on-an-arraylist-with-integer-arrays
            
            //if the space is already occupied by a different penguin
            if(!(activePenguins.stream().filter(a -> Arrays.equals(a.location, 0, 3, current, 0,3)).allMatch(a -> a == p)))
                return false;

            //If the desired has been located
            if(Arrays.equals(current, 0, 3, desired, 0,3)) {
                return true;
            }
            else {
                addAll(current, direction);
            }
        }

        return false;
    }

    //TO DO: Test more and optimize space (time seems good enough)
    //Tested 1 Worst case (8 penguins full board) (1 penguin full board), 1 cornered case (1 penguin), and 1 true isolated island (1 penguin)
    public ArrayList<int[]> checkForIsolation() {
        ArrayList<int[]> unreachable = new ArrayList<>();
        unreachable.addAll(activeSpots);
        final int[][] directions = {{0,-1,1},{0,1,-1},{-1,0,1},{1,0,-1},{1,-1,0},{-1,1,0}};
        ArrayList<int[]> toVisit = new ArrayList<>();
        ArrayList<int[]> visited = new ArrayList<>();
        ArrayList<Penguin> tempPenguins = new ArrayList<>();
        tempPenguins.addAll(activePenguins);
        while(!tempPenguins.isEmpty()) {
            Penguin p = tempPenguins.remove(0);
            toVisit.add(Arrays.copyOf(p.location, 3));
            while(!toVisit.isEmpty()) {
                for (int i = 0; i < directions.length; i++) {
                    int[] nextSpace = addAll(Arrays.copyOf(toVisit.get(0),3), directions[i]);
                    if(activeSpots.stream().anyMatch(a -> Arrays.equals(a,0,3,nextSpace,0,3))) {
                        unreachable.removeIf(a -> Arrays.equals(a,0,3, toVisit.get(0),0,3));
                        if(visited.stream().noneMatch(a -> Arrays.equals(a,0,3, nextSpace,0,3))) {
                            toVisit.add(Arrays.copyOf(nextSpace, nextSpace.length));
                            Optional<Penguin> penPlace = activePenguins.stream().filter(a -> Arrays.equals(a.location, 0, 3, nextSpace, 0,3)).findFirst();
                            if(penPlace.isPresent()) {
                                tempPenguins.remove(penPlace.get());
                            }
                        }
                    }
                }
                visited.add(toVisit.remove(0));
            } 
        }
        return unreachable;
    }

    private static int[] addAll(int[] main, int[] b) {
        for(int i = 0; i < 3; i++) {
            main[i] += b[i];
        }
        return main;
    }
}
