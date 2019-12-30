package a.dataStructures.princeton.sort.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FastCollinearPoints {
    private int MINIMAL_NUM = 4;
    private List<LineSegment> segments;

    public FastCollinearPoints() {
        segments = new ArrayList<>();
    }

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        // check corner cases
        if (points == null) {
            throw new IllegalArgumentException("the number of points is invalidate");
        }
        if (hasDuplicate(points)) {
            throw new IllegalArgumentException("points have duplicate points");
        }
        if (points.length < MINIMAL_NUM) {
            return;
        }

        //finds all line segments containing 4 or more points
        Arrays.sort(points);
        int N = points.length;
        for (int i = 0; i < N - 3; i++) {
            Arrays.sort(points, points[i].slopeOrder());
            for (int p = 0, first = 1, last = 2; last < N; last++) {
                Point p0 = points[p];
                Point p1 = points[first];
                Point p2 = points[last];
                double slope_first = p0.slopeTo(p1);
                double slope_last = p0.slopeTo(p2);
                boolean isInLine = Double.compare(slope_first, slope_last) == 0;
                while (last < N && isInLine) {
                    last++;
                }
                if (last - first >= MINIMAL_NUM - 1 && p0.compareTo(p1) < 0) {
                    segments.add(new LineSegment(p0, points[last]));
                }
                first = last;
            }

        }
    }

    // the line segments
    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    //check whether points have repeat point
    private boolean hasDuplicate(Point[] points) {
        Map map = Arrays.asList(points).
                stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return !map.isEmpty();
    }

}