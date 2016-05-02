/*
--- Day 6: Probably a Fire Hazard ---

Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided to deploy one million lights in a 1000x1000 grid.

Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display the ideal lighting configuration.

Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at 0,0, 0,999, 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive ranges given as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.

To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you in order.

For example:

    turn on 0,0 through 999,999 would turn on (or leave on) every light.
    toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off the ones that were on, and turning on the ones that were off.
    turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.
*/

import java.util.*;

public class Day6{

	static int x = 10;
	static int y = 10;
	static int [][] grid = new int [x][y];

	static void toggle (int num1x, int num1y, int num2x, int num2y){
		System.out.println("======Toggle starts=====");
		System.out.println("*******Start " + num1x + " " + num1y);
		System.out.println("*******GOAL " + num2x + " " + num2y);

		while (num1x != num2x || num1y != num2y){
			//System.out.println("Num1 " + num1x + " " + num1y);
			grid [num1y][num1x] = 1;
			num1x ++;
			if (num1x> x-1 ){
				num1y ++;
				num1x = 0;
			}
		}
		grid [num2y][num2x] = 1;

	}

	static void print (){
		//System.out.println(grid.length);
		for (int i =0 ; i < grid.length ; i++){
			for (int j = 0 ; j < grid[i].length ; j++){
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String stringy = "toggle 0,0 through 9,9";
		Scanner reader = new Scanner (stringy);

		String instruction;
		instruction = reader.next();

		//Decomposes TOGGLE instruction
		if (instruction.equals("toggle")){
			//finds first int param
			/*
			while (!reader.hasNextInt()){ 
				reader.next();
			}
			*/
			String num1 = reader.next();
			Scanner nums = new Scanner (num1);
			nums.useDelimiter(",");
			int num1x = nums.nextInt();
			int num1y = nums.nextInt();
			System.out.println("Row Start " + num1x + " Column Start " + num1y );
			
			//finds second int param
			
			//while (!reader.hasNextInt()){ 
				String holder = reader.next();
			//}

			String num2 = reader.next();
			nums = new Scanner (num2);
			nums.useDelimiter(",");
			int num2x = nums.nextInt();
			int num2y = nums.nextInt();
			System.out.println("Row End " + num2x + " Column End " + num2y );

			toggle(num1x, num1y, num2x, num2y);
		}
		print();
	}
}