package lab;
import java.util.ArrayList;

public class Main {
  
  /*
	Wall = 0
  Open = 1 
  Visited = 2
  Solution = 3
  */
  
	static int[][] labyrinth = {
			 {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			 {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
			 {0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
			 {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			 {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
			 {0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0},
			 {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
			 {0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0},
			 {0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
			 {0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0},};
	
	static int startX = 2;
	static int startY = 10;
	
	static ArrayList<String> solution = new ArrayList<>(); // string will be y-x positions.
	
	static boolean labSolver(int currentX, int currentY, int[][] lab) {
		// Check if the labyrinth is solved. add currentX == 0 || currentX == labyrinth[0].length - 1 if solvers should be added on borders
		if (currentY == 0) {
			lab[currentY][currentX] = 3;
			solution.add("solution: " + currentY + " " + currentX);
			return true;
		}
    // the current position is visited!
		lab[currentY][currentX] = 2;
    
		// check up
			if (lab[currentY - 1][currentX] == 1) {
				if (labSolver(currentX, currentY -1, lab)) {
					lab[currentY][currentX] = 3;
					solution.add("solution: " + currentY + " " + currentX);
					return true;
				}
			}
    
			// check left
			if (currentX > 0) {
				if (lab[currentY][currentX - 1] == 1) {
					if (labSolver(currentX - 1, currentY, lab)) {
						lab[currentY][currentX] = 3;
						solution.add("solution: " + currentY + " " + currentX);
						return true;
					}
				}
			}
			
			// check right
			if (currentX < lab[currentY].length -1) {
				if (lab[currentY][currentX + 1] == 1) {
					if (labSolver(currentX + 1, currentY, lab)) {
						lab[currentY][currentX] = 3;
						solution.add("solution: " + currentY + " " + currentX);
						return true;
					}
				}
			}
    
			// check down 

			if (currentY < lab.length -1) {
				if (lab[currentY + 1][currentX] == 1) {
					if (labSolver(currentX, currentY + 1, lab)) {
						lab[currentY][currentX] = 3;
						solution.add("solution: " + currentY + " " + currentX);
						return true;
					}
				}
			}
    
		 return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("labyrinth");
		
		 try {
			 labSolver(startX, startY, labyrinth);
		 } catch (Exception e) {
			 System.out.println(e);
		 }
		 
		 for (int i = 0; i < labyrinth.length; i++) {
			 for (int j = 0; j < labyrinth[i].length; j++) {
				 System.out.print(labyrinth[i][j]);
			 }
			 System.out.println("");
		 }
		 System.out.println("");
		 
		 for (int i = 0; i < solution.size(); i++) {
			 System.out.println(solution.get(i));
		 }
	}
}
