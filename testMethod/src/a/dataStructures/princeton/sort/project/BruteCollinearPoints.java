package a.dataStructures.princeton.sort.project;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BruteCollinearPoints {
    private List<LineSegment> segments = new ArrayList<>();

    /**
     * finds all line segments containing 4 points
     *
     * @param points all points
     */
    public BruteCollinearPoints(Point[] points) {
        // check corner cases
        if (points == null) {
            throw new IllegalArgumentException("the number of points is invalidate");
        }
        if (hasDuplicate(points)) {
            throw new IllegalArgumentException("points have duplicate points");
        }
        //sort array so that lineSegment start from second or third Quadrant
        Arrays.sort(points);

        //create the vector by points
        double slope;
        int n = points.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                slope = points[i].slopeTo(points[j]);
                for (int k = j + 1; k < n - 1; k++) {
                    if (slope == points[i].slopeTo(points[k])) {
                        for (int l = k + 1; l < n; l++) {
                            if (slope == points[i].slopeTo(points[l])) {
                                segments.add(new LineSegment(points[i], points[l]));
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * print the number of line segments
     *
     * @return the number of line segments
     */
    public int numberOfSegments() {
        return segments.size();
    }

    /**
     * create segments
     *
     * @return array of LineSegment
     */
    public LineSegment[] segments() {
        if (segments == null) {
            return new LineSegment[0];
        }

        return segments.toArray(new LineSegment[segments.size()]);
    }

    private boolean hasDuplicate(Point[] points) {
        Map map = Arrays.asList(points).
                stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return !map.isEmpty();
    }

}
