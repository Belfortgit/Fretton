import java.util.*;
import java.lang.*;


class Direction
{
    int row;
    int col;
    int jump; // 1 = jump, 0 = No jump
    public Direction(int row, int col, int jump)
    {
        this.row = row;
        this.col = col;
        this.jump = jump;
    }
}

class KillAllAndReturn
{
    HashMap<Integer, List<Integer>> mapArr[] = new HashMap[2];
    mapArr[0] = new HashMap<>();
    mapArr[1] = new HashMap<>();

    public static void addInMap(String arr[])
    {
        int col = Integer.parseInt(arr[0]);
        int row = Integer.parseInt(arr[1]);
        if(mapArr[0].contains(row))
        {
            map.put(row,map.get(row).add(col));
        }
        else{
            map.put(row,new ArrayList<Integer>());
            map.put(row,map.get(row).add(col));
        }

        if(mapArr[1].contains(col))
        {
            map.put(col,map.get(col).add(row));
        }
        else{
            map.put(col,new ArrayList<Integer>());
            map.put(col,map.get(col).add(row));
        }
    }

    public static void allPaths(List<Direction> list, int dir, int row, int col)
    {
        if(homeCol == col && homeRow == row)
        {
            list.add(new Direction(col,row,0),1,temprow,tempcol);
            return;
        }


        int temprow = (dir==0)? row : col;
        int tempcol = (dir==0) ? col : row;
        List<Integer> seqlist = mapArr[dir].get(temprow);

        for(int i=0;i<seqlist.size();i++)
        {
            if(tempcol > seqlist.get(i))
            {
                allPaths(list.add(new Direction(col,row,0)),1,temprow,tempcol);

                // this condition is for jumping instead of killing
                if(seqlist.size()>i+1)
                {
                    allPaths(list.add(new Direction(col,row,1),1,temprow,tempcol));
                }
            }
        }
    }

    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("find_my_home_castle –soldiers 11");
        for(int i=0;i<11;i++)
        {
            System.out.print("Enter coordinates for soldier "+i+" ");
            String s = sc.nextLine();
            String splitarr[] = s.split(",");
            addInMap(splitarr);
        }
        System.out.println("Enter the coordinates for your “special” castle: ");
        String s = sc.nextLine();
        int homeRow = Integer.parseInt(s.charAt(2));
        int homeCol = Integer.parseInt(s.charAt(0));

        allPaths(new ArrayList<Direction>, 0, homeRow, homeCol);

        System.out.println(mapArr[0]);
    }
}

/*

the above code is incomplete, below i explained my approach for this problem using recursion  

Here my approach is to use recursive approach of trying all possible paths to reach home through
killing the soldiers.
Indirectly iam trying to reach home through the soldiers coordinates using recursion and backtracking.

I made a Direction class which stores the row, col and jump on the path.
Iam storing every path in a list and in turn storing all those lists into another list.

addInMap method is used in two ways it contains the possibilties of the jump we can take 
mapArr[0] says hte jumps you can take in the direction of row and mapArr[1] is in column direction

*/