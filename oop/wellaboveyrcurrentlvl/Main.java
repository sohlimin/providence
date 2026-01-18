import java.util.List;

static double epsilon = 1E-15; // declare epsilon as a constant

double distanceBetween(Point p, Point q) {
    double dx = p.x - q.x;
    double dy = p.y - q.y;
    return Math.sqrt(dx * dx + dy * dy);
}

boolean circleContainsPoint(Circle c, Point p) {
    return distanceBetween(c.centre, p) < c.radius + epsilon;
}

Circle createUnitCircle(Point p, Point q) {
    Point m = new Point((p.x + q.x) / 2.0, (p.y + q.y) / 2.0);
    double theta = Math.atan2(q.y - p.y, q.x - p.x);
    double mc = Math.sqrt(1.0 - Math.pow(distanceBetween(m, p), 2.0));
    double newx = m.x + mc * Math.cos(theta + Math.PI / 2.0);
    double newy = m.y + mc * Math.sin(theta + Math.PI / 2.0);
    return new Circle(new Point(newx, newy), 1.0);
}

int findCoverage(Circle c, List<Point> points) {
    int coverage = 0;
    for (Point point : points) {
        if (circleContainsPoint(c, point)) {
            coverage = coverage + 1;
        }
    }
    return coverage;
}

int findMaxDiscCoverage(List<Point> points) {
    int maxDiscCoverage = 0;
    int numOfPoints = points.size();

    for (int i = 0; i < numOfPoints - 1; i++) {
        for (int j = i + 1; j < numOfPoints; j++) {
            Point p = points.get(i);
            Point q = points.get(j);
            double distPQ = distanceBetween(p, q);
            if (distPQ < 2.0 + epsilon && distPQ > 0) {
                Circle c = createUnitCircle(p, q);
                int coverage = findCoverage(c, points);
                if (coverage > maxDiscCoverage) {
                    maxDiscCoverage = coverage;
                }
            }
        }
    }
    return maxDiscCoverage;
}

void main() {}
