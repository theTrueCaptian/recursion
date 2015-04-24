package recursionNetbeans;
import java.util.*;
/**
 * maeda hanafi
 * 3/19/10
 * recursion
 */
class recursion {

	int totalDisks = 0, moves = 0;
    long sumTime, factorialTime, fibonacciTime, combinationTime, hanoiTime;

    public static void main(String[] args) {
    	recursion l = new recursion();
    }

    public recursion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer greater than 0, n: ");
        int n = 1;
        boolean continueInput = true;
        do{
	        try{
	        	do{
	        		n = sc.nextInt();
	        		if(n<=0){
	        			System.out.println("Please enter integer greater than 0 only.");
	        		}
	        	}while(n<=0);
	        	continueInput = false;
	         }catch(InputMismatchException ex){
	             System.out.println("Please enter integer only.");
	             sc.nextLine();
	         }
        }while(continueInput);
        int p = 1;
        continueInput = true;
        do{
	        try{
	        	do{
	        		System.out.println("Enter an integer, p, where 0<p<n+1:");
	        		p = sc.nextInt();
	        		if(p>n || p<=0){
	        			System.out.println("Please enter integer less than n.");
	        		}
	        	}while(p>n || p<=0);
	        	continueInput = false;
	        }catch(InputMismatchException ex){
	        	System.out.println("Please enter integer only.");
	        	sc.nextLine();
	        }
        }while(continueInput);
        display(n, p);
    }

    public void display(int n, int p){
        long startTime = System.nanoTime();
        System.out.println("Sum of integers between 1 and " + n + " is " + sum(n));
        sumTime = System.nanoTime() - startTime;
        System.out.println("Time: " + sumTime + " nsec\n");

        startTime = System.nanoTime();
        System.out.println("Factorial from 1 to " + n + " is " + factorial(n));
        factorialTime = System.nanoTime() - startTime;
        System.out.println("Time: " + factorialTime + " nsec\n");

        startTime = System.nanoTime();
        System.out.println("The " + n + "th Fibonacci # is " + fibonacci(n));
        fibonacciTime = System.nanoTime() - startTime;
        System.out.println("Time: " + fibonacciTime + " nsec\n");

        startTime = System.nanoTime();
        System.out.println("Combination of " + p + " elements from " + n + " elements is " + combination(n,p));
        combinationTime = System.nanoTime() - startTime;
        System.out.println("Time: " + combinationTime + " nsec\n");

        System.out.println("Towers of Hanoi using " + n + " disks:");
        startTime = System.nanoTime();
        hanoi(n);
        hanoiTime = System.nanoTime() - startTime;
        System.out.println("Time: " + hanoiTime + " nsec\n");
    }

    public int sum(int n){
        if(n==1){
            return 1;
        }else if(n==0){
            return 0;
        }else{
            return (n+sum(n-1));
        }
    }

    public int factorial(int n){
        if(n==1 || n==0){
            return 1;
        }else{
            return (n*factorial(n-1));
        }
    }

    public int fibonacci(int n){
        if(n==1 || n==2){
            return 1;
        }else{
            return (fibonacci(n-1) + fibonacci(n-2));
        }
    }

    //Combination of p elements out of n elements is nCp = n!/[(n - p)! p!]
    public int combination(int n, int p){
        return factorial(n)/(factorial(n-p) * factorial(p));
    }
    public void hanoi(int n){
        int disks;
        char fromPole = 'A';
        char withPole = 'B';
        char toPole = 'C';
        disks = n;
        totalDisks = disks;
        if(totalDisks > 10){
            System.out.println("Working...");
        }
        solveHanoi(disks, fromPole, toPole, withPole);
    }

    public void solveHanoi(int disks, char fromPole, char toPole, char withPole) {
        if (disks >= 1) {
            solveHanoi(disks-1, fromPole, withPole, toPole);
            moveDisk(fromPole, toPole);
            solveHanoi(disks-1, withPole, toPole, fromPole);
        }
    }

    public void moveDisk(char fromPole, char toPole) {
        moves++;
        if(totalDisks <= 10){
            System.out.print("Move from " + fromPole + " to " + toPole + ". ");
            if(moves%4 == 0){
                System.out.println();
            }
        }else{
            if (moves%4 == 0){
                System.out.println();
            }
        }
    }



}
