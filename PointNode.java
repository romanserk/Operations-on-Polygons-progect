package maman15;
/**
 * public class PointNode represents a vertex in a polygon
 * @author Roman Serkinskiy
 *
 */
public class PointNode {

	private Point _point;
	private PointNode _next;
	/**
	 * public PointNode (Point p) - constructor
	 * @param p - the parameter point
	 * time complexity O(1) place complexity O(1)
	 */
	public PointNode (Point p){
		
		this._point = p;
		this._next = null;
		
	}
	/**
	 * public PointNode (Point p, PointNode n)
	 * @param p - the parameter point
	 * @param n - the parameter of the next vertex
	 * time complexity O(1) place complexity O(1)
	 */
	public PointNode (Point p, PointNode n){
		
		this._point = p;
		this._next = n;
		
	}
	/**
	 * public PointNode (PointNode p)
	 * @param p - the next vertex
	 * time complexity O(1) place complexity O(1)
	 */
	public PointNode (PointNode p){
		
		this._next = p;
		
	}
	/**
	 * public Point getPoint()
	 * @return - the point
	 * time complexity O(1) place complexity O(1)
	 */
	public Point getPoint() {
		return _point;
	}
	/**
	 * public void setPoint(Point p)
	 * @param p - point to be set
	 * time complexity O(1) place complexity O(1)
	 */
	public void setPoint(Point p) {
		this._point = p;
	}
	/**
	 * public PointNode getNext()
	 * @return - the next vertex
	 * time complexity O(1) place complexity O(1)
	 */
	public PointNode getNext() {
		return _next;
	}
	/**
	 * public void setNext(PointNode next)
	 * @param next - the vertex to be set
	 * time complexity O(1) place complexity O(1)
	 */
	public void setNext(PointNode next) {
		this._next = next;
	}
	
	
	
}
