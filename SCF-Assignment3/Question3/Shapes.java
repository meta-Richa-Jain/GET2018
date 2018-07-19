import java.util.Scanner;

/**
 * This class contains main method to take inputs from user and inputs should be greater than zero
 * @author Richa Jain
 */
public class Shapes {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your choice: \n"
				+ " 1 to find area of triangle\n"
				+ " 2 to find area of rectangle\n"
				+ " 3 to find area of square\n" + " 4 to find area of circle\n"
				+ " 5 to exit");
		int choice = scan.nextInt();
		do {
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter width and height of triangle");
					double widthTriangle = scan.nextInt();
					double heightTriangle = scan.nextInt();
					Area triAreaObj = new Area();
					System.out.println(triAreaObj.areaTriangle(widthTriangle,
							heightTriangle));
				} catch (ArithmeticException e) {
					System.out.println("Error detected : " + e.getMessage());

				}
				break;
			case 2:
				try {
					System.out.println("Enter width and height of rectangle");
					double widthRectangle = scan.nextInt();
					double heightRectangle = scan.nextInt();
					Area recAreaObj = new Area();
					System.out.println(recAreaObj.areaRectangle(widthRectangle,
							heightRectangle));
				} catch (ArithmeticException e) {
					System.out.println("Error detected : " + e.getMessage());

				}
				break;
			case 3:
				try {
					System.out.println("Enter the side of square");
					double side = scan.nextInt();
					Area squareAreaObj = new Area();
					System.out.println(squareAreaObj.areaSquare(side));
				} catch (ArithmeticException e) {
					System.out.println("Error detected : " + e.getMessage());

				}
				break;
			case 4:
				try {
					System.out.println("Enter radius of the circle");
					double radius = scan.nextInt();
					Area circleAreaObj = new Area();
					System.out.println(circleAreaObj.areaCircle(radius));
				} catch (ArithmeticException e) {
					System.out.println("Error detected : " + e.getMessage());

				}
				break;
			default:
				System.out.println("wrong choice");
				break;
			}
		} while (choice < 5);
		scan.close();
	}

}
