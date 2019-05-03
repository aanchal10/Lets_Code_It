import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {


        Scanner s = new Scanner(System.in);
        int no_of_testcases = s.nextInt();
        int villains_players = 0;
        ArrayList<Integer> villain_strength = new ArrayList<>();
        ArrayList<Integer> player_energy = new ArrayList<>();
        ArrayList<String> all_results = new ArrayList<>();

        //Taking Input from User

        for (int i = 0; i < no_of_testcases; i++){
            villains_players = s.nextInt();
            villain_strength = new ArrayList<>();
            player_energy = new ArrayList<>();

        for (int j = 0; j < villains_players; j++) {

            villain_strength.add(s.nextInt());
            }
            for (int j = 0; j < villains_players; j++) {

                player_energy.add(s.nextInt());
            }
            String result = winOrLose(villain_strength,player_energy);
            all_results.add(result);
        }
         for (int j =0 ;j<all_results.size();j++){
            System.out.println(all_results.get(j));
         }
    }


    public static String winOrLose(ArrayList<Integer> villain_strength, ArrayList<Integer> player_energy){
        String result = "LOSE";
        int count = 0;

        Collections.sort(villain_strength,Collections.reverseOrder());
        Collections.sort(player_energy,Collections.reverseOrder());

        if(player_energy.get(0)<villain_strength.get(0)){
            result = "LOSE";
            return result;
        }
          else{
            for (int k=1 ; k<villain_strength.size(); k++) {
                if(player_energy.get(k)>villain_strength.get(k)) {
                    count++;
                }
            }
            if(count == villain_strength.size()-1){
               result = "WIN";
            }else {
                result = "LOSE";
            }
            return result;
        }

    }
}