package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Hanoi{
	private static String initialString;
	private final static String INPUT_PATH_FILE = "data/input.txt";
	private final static String OUTPUT_PATH_FILE = "data/results.txt";
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(INPUT_PATH_FILE));
	    BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_PATH_FILE));
	    try {
	    	int tries= Integer.parseInt(br.readLine());
		    int number = 0;
		    String answer = "";
		    
		    for(int i=0;i<tries;i++){
		    	number = Integer.parseInt(br.readLine());
		    	int[] towers= {number,0,0};
		    	initialString = towers[0]+" "+towers[1]+" "+towers[2]+"\n";
		    	resolveTowerOfHanoi(number,towers, 0, 2, 1);
		    	answer += initialString+"\n";
		    }
		    answer = answer.substring(0,answer.length()-1);
		    bw.write(answer);
		    
		    
		    br.close();
		    bw.close();	
	    }catch(NumberFormatException | IOException e) {
	    	System.out.println("An error ocurred");
	    }
	    
	}
	
	public static void resolveTowerOfHanoi(int n,int[] towerOfHanoi,int startTower,int finalTower,int auxTower) {
		if(n==1) {
			towerOfHanoi[startTower]--;
			towerOfHanoi[finalTower]++;
			initialString += towerOfHanoi[0]+" "+towerOfHanoi[1]+" "+towerOfHanoi[2]+"\n";
			return;
		}
		resolveTowerOfHanoi(n-1,towerOfHanoi,startTower,auxTower,finalTower);
		towerOfHanoi[startTower]--;
		towerOfHanoi[finalTower]++;
		initialString += towerOfHanoi[0]+" "+towerOfHanoi[1]+" "+towerOfHanoi[2]+"\n";
		resolveTowerOfHanoi(n-1,towerOfHanoi,auxTower, finalTower,startTower);
	}
}