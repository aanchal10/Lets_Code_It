import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CandidateCode {

    public static void main(String[] args) {


       Scanner s = new Scanner(System.in);
       Long no_of_testcases = s.nextLong();
       Long row_phases;
       Long column_states;
       ArrayList<Long> row_phase_values;
       ArrayList<Long> col_state_values;
       boolean government;

       for (int i =0; i<no_of_testcases;i++){

           row_phases = s.nextLong();
           column_states = s.nextLong();
           row_phase_values = new ArrayList<>();
           col_state_values = new ArrayList<>();
           long phase_total = 0L;
           long column_total = 0L;


           for(int j = 0; j<row_phases; j++){

               row_phase_values.add(s.nextLong());
               phase_total += row_phase_values.get(j);
           }

           for(int k =0 ; k<column_states;k++){

               col_state_values.add(s.nextLong());
               column_total += col_state_values.get(k);

           }
           Collections.sort(row_phase_values,Collections.reverseOrder());
           Collections.sort(col_state_values);
          

           if(phase_total == column_total){
               government = calculate(row_phase_values,col_state_values);
               if(government)
                   System.out.println("YES");
               else
                   System.out.println("NO");
           }else {
               System.out.println("NO");
           }

       }

    }

    private static boolean calculate(ArrayList<Long> row_phase_values, ArrayList<Long> col_state_values) {

        long left_sum = 0L;
        long right_sum = 0L;
        boolean government = true;
        int col_index = 0;

        for(int v = 1; v <= row_phase_values.size() ; v++){

            left_sum += (row_phase_values.get(v-1));

            while (col_index < col_state_values.size()){

                if(col_state_values.get(col_index) <= v){
                    right_sum += col_state_values.get(col_index);
                    col_index++;
                }else{

                    break;
                }
            }

            if(left_sum > right_sum + (col_state_values.size()-col_index) * v){

                government = false;
            }

        }
        return government;
    }
}
