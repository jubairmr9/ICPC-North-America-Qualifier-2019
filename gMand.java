import java.util.*;

public class gMand {

    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);
        int pcts = s1.nextInt();
        int dist = s1.nextInt();

        // votes for A in each district
        int aVoters[] = new int[dist];
        // votes for B in each district
        int bVoters[] = new int[dist];

        for (int i = 0; i<pcts; i++) {

            int distNum = s1.nextInt();
            int aVote = s1.nextInt();
            int bVote = s1.nextInt();

            aVoters[distNum -1] += aVote;
            bVoters[distNum -1] += bVote;
        }

        int sumWastedA = 0;
        int sumWastedB = 0;

        int totalVotes = 0;

        for (int i = 0; i<dist; i++) {

            totalVotes += aVoters[i];
            totalVotes += bVoters[i];

            if (aVoters[i] > bVoters[i]) {

                int wastedVotesA = aVoters[i] - (int) Math.floor((aVoters[i] + bVoters[i])/2) -1;
                sumWastedA += wastedVotesA;

                int wastedVotesB = bVoters[i];
                sumWastedB += wastedVotesB;

                System.out.printf("A %d %d\n", wastedVotesA, wastedVotesB);
            }

            else {

                int wastedVotesB = bVoters[i] - (int) Math.floor((bVoters[i] + aVoters[i])/2) -1;
                sumWastedB += wastedVotesB;

                int wastedVotesA = aVoters[i];
                sumWastedA += wastedVotesA;

                System.out.printf("B %d %d\n", wastedVotesA, wastedVotesB);

            }
        }
        double efficiency = (Math.abs(sumWastedA - sumWastedB))/(double)totalVotes;

        System.out.println(efficiency);
    }

}
