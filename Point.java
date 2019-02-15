package maman15;

/**
 * public class Point represents point a point in the place according to Cartesian coordinate system
 * @author Roman Serkinsky
 * id: 312643489
 *
 */

public class Point {

	private double _x;
	private double _y;

	/**
	 * public Point(double x, double y) - the constructor
	 * @param x - represent the position on the axis x
	 * @param y - represent the position on the axis y
	 * time complexity O(1) place complexity O(1)
	 */
	public Point(double x, double y) {

		this._x = x;
		this._y = y;

	}

	/**
	 * public Point(Point other) - other point
	 * @param other - the other point
	 * time complexity O(1) place complexity O(1)
	 */
	public Point(Point other) {

		this._x = other._x;
		this._y = other._y;

	}
	/**
	 * public double getX()
	 * @return - the position on the axis x
	 * time complexity O(1) place complexity O(1)
	 */
	public double getX() {
		return this._x;
	}
	/**
	 * public void setX(double num)
	 * @param num - the number to set the position on the axis x
	 * time complexity O(1) place complexity O(1)
	 */
	public void setX(double num) {
		this._x = num;
	}
	/**
	 * public double getY()
	 * @return the position on the axis y
	 * time complexity O(1) place complexity O(1)
	 */
	public double getY() {
		return this._y;
	}
	/**
	 * public void setY(double num)
	 * @param num - the number to set the position on the axis y
	 * time complexity O(1) place complexity O(1)
	 */
	public void setY(double num) {
		this._y = num;
	}

	/**
	 * public String toString()
	 * @return - the string that represents the point  
	 * @Override
	 * time complexity O(n) place complexity O(n)
	 */
	
	public String toString() {
		return "(" + this._x + "," + this._y + ")";
	}

	/**
	 * public boolean equals(Point other)
	 * @param other - the point to compare with
	 * @return true if the points are equals otherwise return false
	 * time complexity O(1) place complexity O(1)
	 */
	public boolean equals(Point other) {

		return this.getX() == other.getX() && this.getY() == other.getY();

	}
	/**
	 * public boolean isAbove(Point other)
	 * @param other - the point to compare with
	 * @return true if this point higher than the parameter point
	 * time complexity O(1) place complexity O(1)
	 */
	public boolean isAbove(Point other) {

		return this._y > other._y;

	}
	/**
	 * public boolean isUnder(Point other)
	 * @param other - the point to compare with
	 * @return true if this point is under the parameter point otherwise false
	 * time complexity O(1) place complexity O(1)
	 */
	public boolean isUnder(Point other) {

		return other.isAbove(this);

	}
	/**
	 * public boolean isLeft(Point other)
	 * @param other - the parameter point
	 * @return true if this point is left then the parameter point
	 * time complexity O(1) place complexity O(1)
	 */
	public boolean isLeft(Point other) {

		return this._x < other._x;

	}
	/**
	 * public boolean isRight(Point other)
	 * @param other - the parameter point
	 * @return - true if this point is right then the parameter point
	 * time complexity O(1) place complexity O(1)
	 */
	public boolean isRight(Point other) {

		return other.isLeft(this);

	}
	/**
	 * public double distance(Point p)
	 * @param p - the parameter point
	 * @return - the distance between this point and the parameter point
	 * time complexity O(1) place complexity O(1)
	 */
	public double distance(Point p) {

		return Math.sqrt(Math.pow(this._y - p._y, 2) + Math.pow(this._x - p._x, 2));

	}
	/**
	 * public void move(double dx, double dy)
	 * @param dx - the distance to move the point on the x axis
	 * @param dy - the distance to move the point on the y axis
	 * time complexity O(1) place complexity O(1)
	 */
	public void move(double dx, double dy) {

		this._x += dx;
		this._y += dy;

	}

}
