import java.util.*;
import java.lang.Math; 

public class MazeGeneratorCode {
	static int playerx = 2;
	static int playery = MazeGenerator.mazeY-3;
	static int endx = MazeGenerator.mazeX-3;
	static int endy = 2;
	static boolean maze_complete = false;
	
	public static int[][] maze = new int[MazeGenerator.mazeY][MazeGenerator.mazeX];	

	public static void GenerateMaze(){
		int min = 0;
		int max = 0;
		List<String> neighboursList = new ArrayList<>();
		
		for (int i = 0; i < MazeGenerator.mazeY; i ++) {
			for (int j = 0; j < MazeGenerator.mazeX; j ++) {
				if (i == 0 || i == 1 || j == 0 || j ==1 || i == MazeGenerator.mazeY-1 || i == MazeGenerator.mazeY-2 || j == MazeGenerator.mazeX-1 || j == MazeGenerator.mazeX-2) {
					maze[i][j] = 8;
				}
			}
		}
		maze[playery][playerx] = 3;
		maze[endy][endx] = 2;
		
		while(maze_complete == false) {
			for (int i = 2; i < MazeGenerator.mazeY-2; i ++) {
				for (int j = 2; j < MazeGenerator.mazeX-2; j ++) {
					int N = maze[i-2][j];
					int S = maze[i+2][j];
					int E = maze[i][j+2];
					int W = maze[i][j-2];
					if (maze[i][j] == 3) {
						if (N == 0) {
							neighboursList.add("N");
						}
						if (S == 0) {
							neighboursList.add("S");
						}
						if (E == 0) {
							neighboursList.add("E");
						}
						if (W == 0) {
							neighboursList.add("W");
						}
						if (N == 2) {
							neighboursList.add("NX");
						}
						if (E == 2) {
							neighboursList.add("EX");
						}
					}
				}
			}
			max = neighboursList.size() - 1;
			int number = (int)(Math.random() * (max - min + 1) + min);
			int neighbours = neighboursList.size();
			boolean ran = false;
			if (neighbours > 0) {
				String direction = neighboursList.get(number);
				neighboursList.clear();
				for (int i = 2; i < MazeGenerator.mazeY-2; i ++) {
					for (int j = 2; j < MazeGenerator.mazeX-2; j ++) {
						if (maze[i][j] == 3 && ran == false) {
							
							if (direction == "N") {
								maze[i-1][j] = 1;
								maze[i-2][j] = 3;
								maze[i][j] = 1;
								ran = true;
								
							}
							if (direction == "E") {
								maze[i][j+1] = 1;
								maze[i][j+2] = 3;
								maze[i][j] = 1;
								ran = true;
							}
							if (direction == "S") {
								maze[i+1][j] = 1;
								maze[i+2][j] = 3;
								maze[i][j] = 1;
								ran = true;
							}
							if (direction == "W") {
								maze[i][j-1] = 1;
								maze[i][j-2] = 3;
								maze[i][j] = 1;
								ran = true;
							}
							if (direction == "NX") {
								maze[i-1][j] = 1;
								maze[i-2][j] = 3;
								maze[i][j] = 1;
								ran = true;
								
							}
							if (direction == "EX") {
								maze[i][j+1] = 1;
								maze[i][j+2] = 3;
								maze[i][j] = 1;
								ran = true;
							}
						}
					}
				}
			}
			else {
				ran = false;
				neighboursList.clear();
				for (int i = 2; i < MazeGenerator.mazeY-2; i += 2) {
					for (int j = 2; j < MazeGenerator.mazeX-2; j += 2) {
						if (maze[i][j] == 3 && ran == false) {
							if (maze[i+1][j] == 1 && maze[i+2][j] == 1) {
								maze[i][j] = 7;
								maze[i+1][j] = 7;
								maze[i+2][j] = 3;
								ran = true;
								
							}
							else if (maze[i-1][j] == 1 && maze[i-2][j] == 1) {
								maze[i][j] = 7;
								maze[i-1][j] = 7;
								maze[i-2][j] = 3;
								ran = true;
							}
							else if (maze[i][j+1] == 1 && maze[i][j+2] == 1) {
								maze[i][j] = 7;
								maze[i][j+1] = 7;
								maze[i][j+2] = 3;
								ran = true;
							}
							else if (maze[i][j-1] == 1 && maze[i][j-2] == 1) {
								maze[i][j] = 7;
								maze[i][j-1] = 7;
								maze[i][j-2] = 3;
								ran = true;
							}
						}
					}
				}
				boolean space = false;
				for (int i = 2; i < MazeGenerator.mazeY-2; i += 2) {
					for (int j = 2; j < MazeGenerator.mazeX-2; j += 2) {
						if (maze[i][j] == 0) {
							space = true;
						}
					}
				}
				if (space == false) {
					System.out.println("8");
					maze_complete = true; 
					for (int i = 2; i < MazeGenerator.mazeY-2; i += 2) {
						for (int j = 2; j < MazeGenerator.mazeX-2; j += 2) {
							if (maze[i][j] == 3) {
								maze[i][j] = 1;
							}
						}
					}
					maze[playery][playerx] = 3;
					maze[endy][endx] = 2;
				}
			}
		}
	}
	public static void ShowMaze() {
		for (int i = 1; i < MazeGenerator.mazeY-1; i ++) {
			for (int j = 1; j < MazeGenerator.mazeX-1; j ++) {
				if (maze[i][j] == 8 || maze[i][j] == 0) {
					System.out.print('█');
				}
				if (maze[i][j] == 1 || maze[i][j] == 7) {
					System.out.print(' ');
				}
				if (maze[i][j] == 2) {
					System.out.print("X");
				}
				if (maze[i][j] == 3) {
					System.out.print('O');
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	public static void Movement() {
		if (playery == endy && playerx == endx) {
			System.out.println("You won");
			MazeGenerator.won = true;
		}
		else {
			Scanner sc = new Scanner(System.in);
			System.out.print("move in any direction using wasd: ");
			String move = sc.nextLine();
			try {
				if (move.equals("w")) {	
					if (maze[playery - 1][playerx] != 0 && maze[playery - 1][playerx] != 8) {
						maze[playery][playerx] = 1;
						playery -= 2;
						maze[playery][playerx] = 3;
					}
				}
				else if (move.equals("a")){
					if (maze[playery][playerx - 1] != 0 && maze[playery][playerx - 1] != 8) {
						maze[playery][playerx] = 1;
						playerx -= 2;
						maze[playery][playerx] = 3;
					}
				}
				else if (move.equals("s")){
					if (maze[playery + 1][playerx] != 0 && maze[playery + 1][playerx] != 8) {
						maze[playery][playerx] = 1;
						playery += 2;
						maze[playery][playerx] = 3;
					}
				}
				else if (move.equals("d")){
					if (maze[playery][playerx + 1] != 0 && maze[playery][playerx + 1] != 8) {
						maze[playery][playerx] = 1;
						playerx += 2;
						maze[playery][playerx] = 3;
					}
				}	
			}
			catch(Exception error) {
				System.out.println("cant go there");
			}
		
		}
	}
}
