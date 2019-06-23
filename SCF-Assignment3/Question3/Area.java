public class Area {

	/**
	 * Find area of rectangle
	 * @param width of the rectangle, requires width to be greater than zero
	 * @param height of the rectangle, requires height to be greater than zero
	 * @return area of the rectangle such that width and height is greater than zero
	 */
	double areaRectangle(double width, double height) throws ArithmeticException {
		if (width <= 0 || height <= 0) {
			throw new ArithmeticException("Inputs should be greater than zero");
		} else {
			return width * height;
		}
	}


	/**
	 * Find area of square
	 * @param side of the square, requires side to be greater than zero
	 * @return area of the square such that side is greater than zero
	 */
	double areaSquare(double side) throws ArithmeticException {
		if (side <= 0) {
			throw new ArithmeticException("Inputs should be greater than zero");
		} else {
			return side * side;
		}
	}


	/**
	 * Find area of triangle
	 * @param width of the triangle, requires width to be greater than zero
	 * @param height of the rectangle, requires height to be greater than zero
	 * @return area of the triangle such that width and height is greater than zero
	 */
	double areaTriangle(double width, double height) throws ArithmeticException {
		if (width <= 0 || height <= 0) {
			throw new ArithmeticException("Inputs should be greater than zero");
		} else {
			return (width * height) / 2;
		}
	}


	/**
	 * Find area of circle
	 * @param radius of the circle, requires radius to be greater than zero
	 * @return area of the circle such that radius is greater than zero
	 */
	double areaCircle(double radius) throws ArithmeticException {
		if (radius <= 0) {
			throw new ArithmeticException("Inputs should be greater than zero");
		} else {
			return 2 * Math.PI * radius;
		}
	}
}
