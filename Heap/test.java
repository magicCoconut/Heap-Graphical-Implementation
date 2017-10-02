import java.util.*;
// import java.lang.management.*;
// import java.util.Scanner;
// import java.lang.Math.*;

// /**
//  *  The <tt>Test</tt> class analyzes the running time 
//  *  for the up-heap and down-heap bubbling procedures.
//  *
//  *  @author Zhengyi Yin
//  *  @author Yudi An
//  *  @version 2.0
//  */

// public class test {
// 	 /**
//      * @exception No exceptions are thrown
//      */	
// 	public static final long TEST_NUM = 100;
// 	public static void main(String[] args){
		
// 		if(args.length == 0){
//         System.out.println("\n>> Proper Usage is: java program num_nodes");
//         System.exit(0);
//     	}

// 		int n = Integer.parseInt(args[0]);

// 		long time1 =0;
// 		long time2 = 0;
// 		int num1 = 1;
// 		int num2= 1;
// 		long temp1=0;
// 		long temp2=0;
		
// 		Integer[] in = new Integer[n];

// 		//create a random array
// 		for(int i=0;i<n;i++){
// 			in[i] = randInt(0,n);
// 			// System.out.println(in[i]);
// 		}

// 		PriorityQueue test = new PriorityQueue(in);
		
// 		// loop for computing insert time and remove time
// 		for(int i=0;i<TEST_NUM;i++){

// 			int l = randInt(0,n);
// 			test.insert(l);
// 			long t1 = System.nanoTime();
// 			test.insert(l);
// 			long t2 = System.nanoTime();
// 			System.out.println(t2-t1);
// 			if(i==2){
// 				time1+=t2-t1;
// 				temp1 = t2-t1;
// 			}				
// 			else if(i>3){
// 				// System.out.println(t2-t1);
// 				 if(Math.abs((t2-t1)-(time1/num1))<=2000){
// 				 // if(Math.abs(t2-t1-temp1)<=1000){
// 					time1+=t2-t1;
// 					num1++;
// 					temp1 = t2-t1;
// 					System.out.print("true==");
// 					System.out.println(temp1);
// 				// }
// 				}
// 			    }
			
// 			// time1 +=t2-t1;
            
			
// 			test.removeMin();
// 			long t3 = System.nanoTime();	
// 			test.removeMin();
// 			long t4 = System.nanoTime();
// 			if(i==2){
// 				time2 +=t4-t3;
// 				temp2 = t4-t3;
// 			}
// 			else if(i>3){
// 				if(Math.abs((t4-t3)-(time2/num2))<=500){
// 				// if(Math.abs(t4-t3-temp2)<=1000){
// 					time2 +=t4-t3;
// 					num2++;
// 					temp2 = t4-t3;
// 					// System.out.println(temp2);


// 				// }
// 			}	
// 		}
// 	}
// 		//compute the average time of insert and remove
// 		long insert_mean = time1/num1;
// 		System.out.println(TEST_NUM+"the average time for insert is:"+insert_mean);
// 		long remove_mean = time2/num2;
// 		System.out.println(TEST_NUM+"the average time for remove is:"+remove_mean);

// 	}

	
// 	public static Integer randInt(int min, int max) {

//     // NOTE: Usually this should be a field rather than a method
//     // variable so that it is not re-seeded every call.
//     Random rand = new Random();

//     // nextInt is normally exclusive of the top value,
//     // so add 1 to make it inclusive
//     Integer randomNum = rand.nextInt((max - min) + 1) + min;

//     return randomNum;
// 	}
// }


interface hh{
	 void m();
}
class test implements Comparable<test>{

	public int compareTo(test t){
		return 1;
	}
 // no constructor
// final int AND_PREC;
// public Confusion(){
// 	AND_PREC = 40;
// }
	int h = 3;

	public class AndOperator {
	 	public int k = h;
	 	public int get(){
	 		return k;
	 	}

	} 
	AndOperator n = new AndOperator();
	int hg = n.get();


 public static void main(String[] args) {
	 Confusion conf = new Confusion();
	 String[] str = new String[2];
	 System.out.println(str[0]);
 }
}  