import java.util.List;

private static final double epsilon = 1E-15;

public Circle createUnitCircle(Point a, Point b) {
	Point m = a.midPoint(b);
	double angle = a.angleTo(b);
	double dist = Math.sqrt(1.0 - Math.pow(m.distanceTo(a), 2.0));
	Point centre = m.moveTo(angle + Math.PI / 2.0, dist);
	return new Circle(centre, 1.0);
	}
	
int findCoverage(Circle c, List<Point> points) {
	int coverage = 0;
	for (Point pt : points) {
		if (c.containsPoint(pt)) {
			coverage++;
		}
	}
	return coverage;
}

int findMaxDiscCoverage(List<Point> points) {
	int maxCoverage = 0;
	int noOfPoints = points.size();

	for (int i = 0; i < noOfPoints - 1; i++) {
		for (int j = i + 1; j < noOfPoints; j++) {
			Point a = points.get(i);
			Point b = points.get(j);
			double distAB = a.distanceTo(b);
			if (distAB < 2.0 + epsilon && distAB > 0) {
				Circle c = createUnitCircle(a, b);
				int coverage = findCoverage(c, points);
				if (coverage > maxCoverage) {
					maxCoverage = coverage;
				}
			}
		}
	}
	return maxCoverage;
}
	
void main (){
}	
