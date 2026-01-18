class Point {
	private final double x;
	private final double y;
	
	Point(double x, double y) {
		this.x = x;
		this.y = y;	
	}
	
	@Override
	public String toString() {
		return String.format("point (%.3f, %.3f)", x, y);
	}

	public double distanceTo(Point p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}
	
	public Point midPoint(Point p) {
		return new Point((this.x + p.x) / 2, (this.y + p.y) / 2);
	}
	
	public double angleTo(Point p) {
		return Math.atan2((p.y - this.y), (p.x - this.x));
	}

	public Point moveTo(double angle, double dist) {
		double newx = this.x + dist * Math.cos(angle);
		double newy = this.y + dist * Math.sin(angle);
		return new Point(newx, newy);
	}


}
