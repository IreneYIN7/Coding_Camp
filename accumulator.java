import java.util.ArrayList;

public class accumulator {
    public ArrayList<Integer> arrInt = new ArrayList<>();

	public void add(int x) {
    arrInt.add(x);
	}
	public int sum() {
    int sum =0;
    for (int i =0; i< arrInt.size(); i++){
      sum += arrInt.get(i);
    }
    return sum;
	}
    public String toString(){
        
        return arrInt.toString();
    }
    
    public static void main(String[] args){
        accumulator a = new accumulator();
        a.add(1);
        System.out.println(a.toString());

    }
    
}
