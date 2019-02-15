package maman15;
/**
 * public class Polygon represents a convex polygon in the place
 * @author Roman Serkinskiy
 *
 */
public class Polygon {

	private PointNode _head;
	/**
	 * public Polygon() the constructor set the head to be null
	 * complexity O(1) place complexity O(1)
	 */
	public Polygon() {

		this._head = null;

	}
	
	
	/**
	 * public boolean addVertex(Point p, int pos)
	 * @param p - the point to add
	 * @param pos - the position where to add the point
	 * @return true if the point successfully added otherwise false 
	 * time complexity O(n) 
	 * place complexity O(1)
	 */
	public boolean addVertex(Point p, int pos) {
		int PointNodesNum;
		PointNodesNum = this.length();
		PointNode currentNode = _head;
		PointNode pervious = _head;
		PointNode newPointNode = new PointNode(p);

		int count = 0;
		//checks if the number of vertexes is possible
		if ((PointNodesNum + 1 < pos) || (pos < 1) || (p == null)) {
			return false;
		} else if (_head == null) {
			if (pos == 1) {
				PointNode add = new PointNode(p);
				_head = add;
			}
		} else if (pos <= length()) {

			while (count < pos - 1) {// if the position is not in the head

				pervious = pervious.getNext(); // finding the right place
				count++;

			}
			PointNode current = pervious.getNext(); // set the current position
			newPointNode.setNext(current);//set the current point to be next of the parameter point
			pervious.setNext(newPointNode);//set the parameter point to be next of the previous point
			
			
		} else if ((_head != null) && (pos == PointNodesNum + 1)) {
			currentNode = _head;
			count = 1;
			while ((currentNode.getNext() != null) && (count != (pos - 1))) {
				count++;
				currentNode = currentNode.getNext();
			}
			
			PointNode add = new PointNode(p);
			currentNode.setNext(add);
		}
		return true;
	}

	private int length() { // return the length of the list (the number of the
							// vertexes)
		PointNode current = _head;
		int count = 0;

		while (current != null) {// counting the number of the vertexes
			count++;
			current = current.getNext();
		}
		return count;

	}
	/**
	 * public Point highestVertex()
	 * @return - the highest vertex of the polygon
	 * time complexity O(n) place complexity O(1)
	 */
	public Point highestVertex() {
		PointNode currentNode = _head;
		PointNode highest = _head;
		if (currentNode == null)
			return null;
		while (currentNode != null) {
			if (currentNode.getPoint().isAbove(highest.getPoint())) {
				highest = currentNode;
			}
			currentNode = currentNode.getNext();
		}
		return new Point(highest.getPoint());
	}

	/**
	 * public String toString()
	 * return the string that represents the polygon
	 * @Override
	 * time complexity O(n) place complexity O(n)
	 */
	public String toString() {
		int PointNodesNum;
		PointNodesNum = this.length();
		PointNode currentNode = _head;
		if (PointNodesNum == 0) {
			return "The polygon has 0 vertices.";
		}
		String s = "The polygon has " + PointNodesNum + " vertices:\n";
		s += "(";
		while (currentNode.getNext() != null) {
			s += currentNode.getPoint().toString();
			s += ",";
			currentNode = currentNode.getNext();
		}
		s += currentNode.getPoint().toString();
		s += ")";
		return s;
	}
	/**
	 * public double calcPerimeter()
	 * @return - the perimeter of the polygon
	 * time complexity O(n) place complexity O(n) 
	 */
	public double calcPerimeter() {
		PointNode current = _head;
		double perimeter = 0;
		if (length() < 2) {
			return 0;
		}
		if (length() == 2) {//if there is only 2 points
			return _head.getPoint().distance(_head.getNext().getPoint());
		}

		while (current.getNext() != null) {
			perimeter += current.getPoint().distance(current.getNext().getPoint()); //counting the distance between the vertexes and add it to the perimeter
			current = current.getNext();

		}
		perimeter += current.getPoint().distance(_head.getPoint()); //add the last vertex distance of the head vertex

		return perimeter;

	}
	/**
	 * public double calcArea()
	 * @return - the area of the polygon
	 * time complexity O(n) place complexity O(n)
	 */
	public double calcArea() {
		double area = 0;
		PointNode current = _head;
		if (length() < 3) { // if there is less then 3 vertexes return 0
			return area;
		} else {

			while (current.getNext().getNext() != null) {
				// the sum of all the triangles that cover the area of the polygon
				area += calcTri(_head.getPoint(), current.getNext().getPoint(), current.getNext().getNext().getPoint());
				current = current.getNext();
			}
			return area;
		}
	}

	private double calcTri(Point first, Point second, Point third) {

		double a = first.distance(second);//first triangle side
		double b = first.distance(third);//second triangle side
		double c = second.distance(third);//Third triangle side
		double s = (a + b + c) / 2;//half of the triangle perimeter

		return Math.sqrt(s * (s - a) * (s - b) * (s - c));//Heron formula to calculate the triangle area

	}
	/**
	 * public boolean isBigger(Polygon other)
	 * @param other - the parameter polygon	
	 * @return - if this polygon is bigger then the parameter polygon
	 * time complexity O(1) place complexity O(1)
	 */
	public boolean isBigger(Polygon other) {

		return other.calcArea() < this.calcArea();

	}
	/**
	 * public int findVertex(Point p)
	 * @param p - the parameter point
	 * @return - the place in the polygon of the parameter point
	 * if there is no vertex in the polygon like given by parameter point return -1 
	 * time complexity O(n) place complexity O(1)
	 */
	public int findVertex(Point p) {
		int position = -1;
		int curLocation = 1;
		PointNode currentNode = _head;
		while (currentNode != null) {
			if (currentNode.getPoint().equals(p)) {
				position = curLocation;
			}
			currentNode = currentNode.getNext();
			curLocation++;
		}
		return position;
	}
	/**
	 * public Point getNextVertex(Point p)
	 * @param p - the parameter point
	 * @return the next vertex of given parameter point
	 * time complexity O(n) place complexity O(1)
	 */
	public Point getNextVertex(Point p) {

		PointNode current = _head;
		int count = 1;

		if (length() == 1) {
			return _head.getNext().getPoint();
		}

		while (current.getNext() != null) {// going thru all the vertexes and check if ther is one like given by parameter
			count ++;
			if (current.getPoint().equals(p)) {
				
				return current.getNext().getPoint();
			}
			
			current = current.getNext();

		}
		if (count == this.length()){
			return _head.getPoint();
		}
		return null;
	}
	/**
	 * public Polygon getBoundingBox()
	 * @return - the rectangle parallel to the axis represents as a polygon that blocks this polygon
	 * time complexity O(n) place complexity O(n)
	 */
	public Polygon getBoundingBox() {

		PointNode current = _head;
		Point highest = _head.getPoint();//the highest point
		Point lowest = _head.getPoint();//the lowest point
		Point right = _head.getPoint();//the most right point
		Point left = _head.getPoint();//the most left point

		while (current != null) {
			//finding all needed points
			if (current.getPoint().isAbove(highest)) {
				highest = current.getPoint();//find the highest point
			}
			if (current.getPoint().isUnder(lowest)) {
				lowest = current.getPoint();//find the lowest point
			}
			if (current.getPoint().isRight(right)) {
				right = current.getPoint();//find the most right point
			}
			if (current.getPoint().isLeft(left)) {
				left = current.getPoint();//find the most left point
			}

			current = current.getNext();
		}
		//makes the points that represents the rectangle
		Point a = new Point(left.getX(), lowest.getY());
		Point b = new Point(left.getX(), highest.getY());
		Point c = new Point(right.getX(), highest.getY());
		Point d = new Point(right.getX(), lowest.getY());
		//add all the points to create the polygon
		Polygon p = new Polygon();
		p.addVertex(a, 1);
		p.addVertex(b, 2);
		p.addVertex(c, 3);
		p.addVertex(d, 4);

		return p;

	}

}
