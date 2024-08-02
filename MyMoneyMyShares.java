// This is the Complete Working code

import java.util.*;
import java.lang.*;

class MyMoneyMyShares
{
    public static void main(String arg[])
    {
        List<Integer> appleWeights = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("run distribute_apple");
        System.out.print("Enter apple weight in gram (-1 to stop ) :  ");
        int userinput = sc.nextInt();
        while(userinput != -1)
        {
            appleWeights.add(userinput);
            System.out.print("Enter apple weight in gram (-1 to stop ) :  ");
            userinput = sc.nextInt();
        }

        int totalWeight = 0;

        for(int i=0;i<appleWeights.size();i++)
        {
            totalWeight += appleWeights.get(i);
        }

        Collections.sort(appleWeights,Collections.reverseOrder());

        double ram = 0.5*totalWeight;
        double sham = 0.3*totalWeight;
        double rahim = 0.2*totalWeight;
        
        List<Integer> ramShare= assignApples(appleWeights,(int)ram);
        List<Integer> shamShare= assignApples(appleWeights,(int)sham);
        List<Integer> rahimShare= assignApples(appleWeights,(int)rahim);
        
        System.out.println();
        System.out.println("Distribution Result : ");
        System.out.println("Ram's Share "+ramShare);
        System.out.println("Sham's Share"+shamShare);
        System.out.println("Rahim's Share"+rahimShare);        
    }

    // assignApples function is used to allocate the apples according to the person's share. It takes two parameters, " A list of apple weights" and "total share of the person"
    // and returns a list of the apple weights
    // here we are assuming that values of the weight can always be assingned 
    public static List<Integer> assignApples(List<Integer> list, int tar)
    {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            int flag = -1;
            int wt = list.get(i);
            result.add(wt);
           if(wt == tar)
           {
                break;
           }
           else
           {
                for(int j=i+1;j<list.size();j++)
                {
                    if(wt + list.get(j) == tar)
                    {
                        result.add(list.get(j));
                        flag = 1;
                        break;
                    }
                    else if(wt + list.get(j) < tar)
                    {
                        wt += list.get(j);
                        result.add(list.get(j));
                    }
                }

                if(flag == 1) break;
                else
                {
                    result.clear();
                }
           }
        }

        for(int i : result)
        {
            list.remove(Integer.valueOf(i));
        }
        return result;
    }
}
