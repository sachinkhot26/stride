import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignment1 {

	public static void main(String[] args) {
		int length=0;
		int totalSum=0;
//		List<Integer>sqSum= new ArrayList<>();
//		sqSum.add(1);
//		sqSum.add(2);
//		sqSum.add(3);
//		sqSum.add(2);
//		sqSum.add(3);
		List<Integer> sqSum = new ArrayList<Integer>(Arrays.asList(1,2,3));
		
		
//		List<Integer>cubeSum=new ArrayList<>();
//		cubeSum.add(2);
//		cubeSum.add(3);
//		cubeSum.add(2);
		
		List<Integer> cubeSum = new ArrayList<Integer>(Arrays.asList(2,3));
		
		if(sqSum.size()>cubeSum.size()) {
			length=sqSum.size();
		}else {
			length=cubeSum.size();
		}
		
		for(int i=0;i<length;i++) {
			if(i<sqSum.size()) {
				totalSum=totalSum+(sqSum.get(i)*sqSum.get(i));
			}
			if(i<cubeSum.size()) {
				totalSum=totalSum+(cubeSum.get(i)*cubeSum.get(i)*cubeSum.get(i));
			}
		}
		System.out.println("Total Sum====="+totalSum);
		
	}

}
