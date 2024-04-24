package Build;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class AI {
    BoardAndMovement bm;
    AI(){}
    AI(BoardAndMovement bm) {
        this.bm = bm;
    }
    Random rand = new Random();
    ArrayList<Penguin> TEMP = new ArrayList<>();

    public static void main(String[] args) {
        for (int j = 1; j <= 1000; j++) {
            BoardAndMovement bm = new BoardAndMovement();
            AI ai = new AI(bm);
            bm.setStartSpots(bm.numbers());

            for(int k = 0; k < 4; k++) {
                if(ai.randomStart() == false)
                System.out.print("\t\t\t\t\t");
                System.out.println(Arrays.toString(bm.activePenguins.get(k).location));
            }
            System.out.println();
        }
        
    }
    
    //NOTE: Does not give penguin the amount of fish as of 4/21/24
    //NOTE 4/22/24: As written so far, penguin does not need the amount of fish
    public void randomMoveOneSpace() {
        Penguin p = TEMP.get(rand.nextInt(0,TEMP.size()));
        ArrayList<int[]> validDirections = new ArrayList<>();
        int[] possibleLocation = new int[3];
        for (int[] i : p.directions) {
            for(int j = 0; j < 3; j++) {
                possibleLocation[j] = p.location[j] + i[j];
            }
            if(p.bm.validMove(p, possibleLocation)) {
                validDirections.add(i);
            }
        }
        //Guaranteed to have at least one value or the penguin would have been removed 
        //from isolation, but error fail-safe
        if(validDirections.size() != 0) {
            possibleLocation = validDirections.get(rand.nextInt(0, validDirections.size()));
            for (int i = 0; i < 3; i++) {
                possibleLocation[i] += p.location[i];
            }
            p.setLocation(possibleLocation);
        }
    }

    //Returns false only if there is an unexpected error
    public boolean randomMove() {
        Penguin p = TEMP.get(rand.nextInt(0,TEMP.size()));
        ArrayList<int[]> validArrayList = new ArrayList<>();
        int[] possibleLocation = new int[3];
        for (int[] i : p.directions) {
            for(int j = 0; j < 3; j++) {
                possibleLocation[j] = p.location[j] + i[j];
            }
            if(p.bm.validMove(p, possibleLocation)) {
                validArrayList.add(i);
            }
        }

        int[] direction = validArrayList.get(rand.nextInt(0,validArrayList.size()));
        int max; 
        for (max = 0; max < 10; max++) {
            possibleLocation[0] = p.location[0] + (direction[0]*max);
            possibleLocation[1] = p.location[1] + (direction[1]*max);
            possibleLocation[2] = p.location[2] + (direction[2]*max);
            if(!p.bm.validMove(p, possibleLocation)) { 
                System.out.println("Max: " + max + "\t" + Arrays.toString(possibleLocation));
                break;
            }
        }

        max = rand.nextInt(1,max);
        possibleLocation[0] = p.location[0] + (direction[0]*max);
        possibleLocation[1] = p.location[1] + (direction[1]*max);
        possibleLocation[2] = p.location[2] + (direction[2]*max);

        return p.setLocation(possibleLocation);
    }

    //Places first unplaced penguin onto the board
    public boolean randomStart() {
        List<int[]> allValids;
        
        //Fail safe: if don't need to add another penguin just return true
        if(TEMP.size() >= 4)
            return true;
        Penguin p = new Penguin(bm);
        TEMP.add(p);
        bm.addPenguins(p);
        allValids = bm.activeSpots.stream().filter(a -> Arrays.equals(a, 3,4,new int[]{0,0,0,1},3,4)).toList();
        allValids = new ArrayList<>(allValids);
        for (Penguin i : bm.activePenguins) {
            allValids.remove(i.location);
        }
        
        //NOTE: Gives Penguin the actual BoardAndMovement spot 
        int[] chosen = allValids.get(rand.nextInt(0,allValids.size()));
        return p.setLocation(chosen);
    }
}
