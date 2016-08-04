import java.io.*;
public class ScoreBoard {

	static Integer pointA = 0;
	static Integer pointB = 0;
	static Integer gameA = 0,gameB = 0;
	static Integer setA = 0,setB = 0;
	static Integer matchA = 0,matchB = 0;
	
	
	public static void main(String[] args)throws IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		String input = br.readLine();
		updateScoreboard(input);
		
	}

	private static void updateScoreboard(String input) {
		for(char ch : input.toCharArray()) {
			updatePoint(ch);
			printScoreboard();
			checkAndPrintWin();
		}
	}

	private static void checkAndPrintWin() {
		if(matchA ==1)
			p("A WON THE MATCH !!\n");
		else if(matchB == 1)
			p("B WON THE MATCH !!\n");
	}
	private static void printScoreboard() {

		p("     SET       GAME      POINT   \n");
		p("---------------------------------\n");
		p("A :\t"+setA+"\t"+gameA+"\t");
		if(pointA==1)
                    System.out.println(15);
             else if(pointA==2)
                    System.out.println(30);
             else if(pointA==3)
                    System.out.println(40);
             else if(pointA==4)
                    System.out.println("AD");
			else 
					System.out.println(0);
		p("B :\t"+setB+"\t"+gameB+"\t");
		if(pointB==1)
                    System.out.println(15);
             else if(pointB==2)
                    System.out.println(30);
             else if(pointB==3)
                    System.out.println(40);
             else if(pointB==4)
                    System.out.println("AD");
			else 
					System.out.println(0);
		p("---------------------------------\n");
		
	}

	public static void p(Object o) {
		System.out.print(o);
	}
	
	private static void updatePoint(char ch) {
		
		if(ch == 'A' || ch=='a') {
			pointA = pointA + 1;
			if(pointA==pointB && pointA>=4){
				pointA=pointB=3;
			}
			if((pointA >= 4) && (pointA-pointB >= 2)){
					pointA = pointB = 0;
					updateGame(ch);
					return;
				}	
			}
		else {
			pointB = pointB + 1;
			if(pointA==pointB && pointA>=4){
				pointA=pointB=3;
			}
			if((pointB >= 4) && (pointB-pointA >= 2)){
				pointA = pointB = 0;
				updateGame(ch);
				return;
			}	
		}
		
		
	}

	private static void updateGame(char ch) {
		
		if(ch == 'A') {
			gameA = gameA + 1;
			if((gameA >= 6) && (gameA-gameB >= 2)){
					gameA = gameB = 0;
					updateSet(ch);
					return;
				}	
			}
		else {
			gameB = gameB + 1;
			if((gameB >= 6) && (gameB-gameA >= 2)){
				gameA = gameB = 0;
				updateSet(ch);
				return;
			}	
		}
		
		
	}

	private static void updateSet(char ch) {
		
		if(ch == 'A') {
			setA = setA + 1;
			if(setA == 2)
				matchA++;
		}
		else {
			setB = setB + 1;
			if(setB == 2)
				matchB++;
			}	
	}
	
	
}