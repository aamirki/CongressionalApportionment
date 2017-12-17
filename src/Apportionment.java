/**
 * Created by Aamir on 12/17/2017.
 */
public class Apportionment{
    private int numSeats;
    private int[] populations;

    public Apportionment(int numSeats, int[] populations){
        this.numSeats = numSeats;
        this.populations = populations;
    }

    public int getNumSeats(){
        return numSeats;
    }
    public int[] getPopulations(){
        return populations;
    }


    public void setNumSeats(int numSeats){
        this.numSeats = numSeats;
    }
    public void setPopulations(int[] populations){
        this.populations = populations;
    }

    public int[] getApportionments(){
        int[] apportionments = new int[populations.length];
        int[] priorities = new int[populations.length];
        double[] algPriorities = new double[populations.length];
        //Each state guaranteed at least one seat
        for(int state: apportionments){
            apportionments[state] = 1;
            priorities[state] = 1;
        }
        for(int i = 0; i < algPriorities.length; i++){
            algPriorities[i] = populations[i] / (Math.sqrt(priorities[i] * (priorities[i] + 1)));
        }
        for(int i = numSeats; i > 1; i--){
            apportionments[maxValue(algPriorities)]++;
            priorities[maxValue(algPriorities)]++;
            algPriorities[maxValue(algPriorities)] = populations[maxValue(algPriorities)] / (Math.sqrt(priorities[maxValue(algPriorities)] * (priorities[maxValue(algPriorities)] + 1)));
        }
        return apportionments;
    }

    /**
     *
     * @param arr the array being targeted
     * @return returns the index of the element in the array with the largest value, or the index of the first instance
     * of the largest value if it repeats
     */
    public int maxValue(double[] arr){
        double maxVal = arr[0];
        int maxValIndex = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
                maxValIndex = i;
            }
        }
        return maxValIndex;
    }

}
