import java.util.Scanner;

/**
 * This class contains main method to take inputs from user and inputs should be greater than zero
 * @author Richa Jain
 */
public class Shapes {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Area area;
		double width;
		double height;
		double side;
		double radius; 
		int choice;
		do {
			System.out.println("Enter your choice: \n"
					+ " 1 to find area of triangle\n"
					+ " 2 to find area of rectangle\n"
					+ " 3 to find area of square\n" + " 4 to find area of circle\n"
					+ " 5 to exit");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter width and height of triangle");
					width = scan.nextInt();
					height= scan.nextInt();
					area = new Area();
					System.out.println("Area : " + area.areaTriangle(width,
							height));
				} catch (ArithmeticException e) {
					System.out.println("Error detected : " + e.getMessage());

				}
				break;
			case 2:
				try {
					System.out.println("Enter width and height of rectangle");
					width = scan.nextInt();
					height = scan.nextInt();
					area = new Area();
					System.out.println("Area : " +area.areaRectangle(width,
							height));
				} catch (ArithmeticException e) {
					System.out.println("Error detected : " + e.getMessage());

				}
				break;
			case 3:
				try {
					System.out.println("Enter the side of square");
					side = scan.nextInt();
					area = new Area();
					System.out.println("Area : " +area.areaSquare(side));
				} catch (ArithmeticException e) {
					System.out.println("Error detected : " + e.getMessage());

				}
				break;
			case 4:
				try {
					System.out.println("Enter radius of the circle");
					radius = scan.nextInt();
					area = new Area();
					System.out.println("Area : " +area.areaCircle(radius));
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
