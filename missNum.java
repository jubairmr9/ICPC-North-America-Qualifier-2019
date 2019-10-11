import java.util.*;


public class missNum {

    public static void main(String[] args)
    {
        Scanner s1 = new Scanner(System.in);

        boolean[] numbersRecited = new boolean[201];

        int numsCount = s1.nextInt();

        for (int i = 0; i < numsCount - 1; i++)
        {
            int num = s1.nextInt();
            numbersRecited[num] = true;
        }
        int last = s1.nextInt();
        numbersRecited[last] = true;


        ArrayList<Integer> notSaid = new ArrayList<>();
        for (int i = 1; i <= last; i++)
        {
            if (numbersRecited[i] == false)
            {
                notSaid.add(i);
            }
        }

        if (notSaid.isEmpty() == true)
        {
            System.out.println("good job");
        }
        else{
            for (int i =0; i<notSaid.size(); i++) {
                System.out.println(notSaid.get(i));
            }
        }
    }

}
