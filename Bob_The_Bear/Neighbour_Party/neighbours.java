
import java.util.*;

public class CandidateCode {

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        int no_of_testcases = s.nextInt();
        int number_of_tickets;
        List<Integer> tickets;
        int [] max_sum;
        int [] index;

            for(int i=0;i<no_of_testcases;i++) {

                number_of_tickets = s.nextInt();
                tickets = new ArrayList<>();
                max_sum = new int[number_of_tickets];
                index = new int[number_of_tickets];

                for (int j = 0; j < number_of_tickets; j++) {

                    tickets.add(s.nextInt());
                    max_sum[j] = 0;
                    index[j] = -1;
                }

                if (tickets.size() == 1) {
                    System.out.println(tickets.get(0));
                }
                else {
                    index = find_max_sum(tickets, max_sum, index);

                    if(index.length == 1){
                        System.out.println(index[0]);
                    }
                   else {
                        //System.out.println();
                        int k = index[number_of_tickets-1];
                        while (k >= 0 && index[k] != -1) {

                            System.out.print(tickets.get(index[k]));
                            k = index[k];
                            if (k == index[k]) {
                                k = k - 2;
                            }
                        }
                        System.out.println();
                    }


                }
            }
    }

    public static int [] find_max_sum(List<Integer> tickets,int [] max_sum, int []  index){
            int negative_count=0;
            int max_element = 0;


            if(tickets.get(0)>0) {
                max_sum[0] = tickets.get(0);
                index[0] = 0;
            }else if(tickets.get(0)<=0){
                negative_count++;
                if(tickets.get(0)<0)
                max_element = tickets.get(0);
            }

           if(tickets.get(1) > 0){
              if(tickets.get(1)>tickets.get(0)) {
                  max_sum[1] = tickets.get(1);
                  index[1] = 1;
              }else {
                  max_sum[1] = tickets.get(0);
                  index[1] = 0;
              }
           }
           else if(tickets.get(1)<=0){
               negative_count++;

               if(tickets.get(1)>max_element && tickets.get(1)<0)
                   max_element = tickets.get(1);
           }


        for(int i = 2;i<tickets.size();i++){

           if(tickets.get(i)>0){

               if((tickets.get(i)+max_sum[i-2])> max_sum[i-1]){

                   max_sum[i] = tickets.get(i)+max_sum[i-2];
                   index[i] = i;

               } else if ((tickets.get(i)+max_sum[i-2])== max_sum[i-1]){

                   max_sum[i] = tickets.get(i)+max_sum[i-2];
                   if(tickets.get(i)>tickets.get(i-1))
                       index[i] = i;
                   else
                       index[i] = index[i-1];

               }else{

                   max_sum[i] = max_sum[i-1];
                   index[i] = index[i-1];

               }

           }else if(tickets.get(i)<=0){
               negative_count++;
               if(tickets.get(i)>max_element && tickets.get(i)<0) {
                   max_element = tickets.get(i);
               }
               max_sum[i] = max_sum[i-1];
               index[i] = index[i-1];
           }


        }

        if(negative_count == tickets.size()){
        index = new int[1];
        index[0] = max_element;
        }

      return index;

    }
}

