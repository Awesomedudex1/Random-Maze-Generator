import java.util.Scanner;

public class MazeGenerator {
	
	static String inputmazeY;
	static String inputmazeX;
	static int mazeY = 0;
	static int mazeX = 0;
	static boolean won = false;
	// ada
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Y Height of the maze: ");
		inputmazeY = sc.nextLine();
		System.out.print("X Height of the maze: ");
		inputmazeX = sc.nextLine();
		
		
		
		mazeY = Integer.parseInt(inputmazeY);
		mazeX = Integer.parseInt(inputmazeX);
		mazeY += 4;
		mazeX += 4;
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
	}
}
