import java.util.Scanner;

public class MazeGenerator {
	
	static String inputmazeY;
	static String inputmazeX;
	static int mazeY = 0;
	static int mazeX = 0;
	static boolean won = false;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean dimensionsWork = false;
		while(dimensionsWork == false) {
			try {
				System.out.print("Height of the maze: ");
				inputmazeY = sc.nextLine();
				System.out.print("Width of the maze: ");
				inputmazeX = sc.nextLine();
				inputmazeX = inputmazeX.trim();
				inputmazeY = inputmazeY.trim();
				
				mazeY = Integer.parseInt(inputmazeY);
				mazeY *= 2;
				mazeY += 4;
				mazeX = Integer.parseInt(inputmazeX);
				mazeX *= 2;
				mazeX += 4;	
				dimensionsWork = true;
				
			}
			catch(Exception e){
				System.out.println("Please input numbers");
			}
		}
		if (mazeY % 2 == 0) {
			mazeY += 1;
		}
		if (mazeX % 2 == 0) {
			mazeX += 1;
		}
		MazeGeneratorCode.GenerateMaze();
		while (won == false) {
			for (int i = 0; i < 10; i++) {
				System.out.println(" ");
			}
			MazeGeneratorCode.ShowMaze();
			MazeGeneratorCode.Movement();
		}
		sc.close();
	}
}
