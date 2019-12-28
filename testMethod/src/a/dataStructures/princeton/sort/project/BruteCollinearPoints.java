package a.dataStructures.princeton.sort.project;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import java.util.*;

public class BruteCollinearPoints {
    private int segments_num = 0;
    private List<LineSegment> segments = null;

    /**
     * finds all line segments containing 4 points
     *
     * @param points
     */
    public BruteCollinearPoints(Point[] points) {
        if (points.length <= 1) {
            return;
        }
        //sorted the lineSegment array by 2 point slope
        SortedSet<LineSegment> set = new TreeSet<>(new LineSegment.LineSegmentComparator());
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                LineSegment lineSegment = new LineSegment(points[i], points[j]);
                set.add(lineSegment);
            }
        }

        //sort the array by the number of lineSegments which have same slope
        LineSegment[] lineSegments = (LineSegment[]) set.toArray();
        SortedSet<LinePoints> set_liP = new TreeSet<>();
        LinePoints linePoints = new LinePoints();
        for (int i = 0; i < lineSegments.length; i++) {
            linePoints.add(lineSegments[i]);
            if (i == lineSegments.length - 1) {
                set_liP.add(linePoints);
                break;
            }
            if (lineSegments[i] == lineSegments[i + 1]) {
                continue;
            } else {
                set_liP.add(linePoints);
                linePoints = new LinePoints();
            }
        }

        //get the greatest number of lineSegments;
        LinePoints[] linePoints_sorted = (LinePoints[]) set_liP.toArray();
        int index = 0;
        for (int i = linePoints_sorted.length; i > 0; i--) {
            if (i == 0) {
                break;
            }
            if (linePoints_sorted[i] != linePoints_sorted[i - 1]) {
                index = i;
                break;
            }
        }

        //set the segments_num;
        segments_num = linePoints_sorted[index].getLineSegmentsList().size();

        //set the segments method
        segments = new ArrayList<LineSegment>();
        for (int i = index; i < linePoints_sorted.length; i++) {
            segments.addAll(linePoints_sorted[i].getLineSegmentsList());
        }


    }


    /**
     * print the number of line segments
     *
     * @return the number of line segments
     */
    public int numberOfSegments() {
        return segments_num;
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
        return (LineSegment[]) segments.toArray();
    }

    /**
     * this class is used to store lineSegments with same slope in abs
     */
    public class LinePoints {
        private List<LineSegment> lineSegments = new ArrayList<>();

        public LinePoints() {
        }

        public LinePoints(LineSegment[] segments) {
            for (int i = 0; i < segments.length; i++) {
                lineSegments.add(segments[i]);
            }
        }

        public void add(LineSegment lineSegment) {
            double slope = getSlopeABS();
            double slope_that = lineSegment.getSlope();
            if (slope == slope_that) {
                lineSegments.add(lineSegment);
            } else {
                return;
            }

        }

        public LineSegment[] getLineSegmentsArray() {
            return (LineSegment[]) lineSegments.toArray();
        }

        public List<LineSegment> getLineSegmentsList() {
            return lineSegments;
        }

        public double getSlopeABS() {
            if (lineSegments.size() == 0) {
                return Double.MIN_VALUE;
            }
            return Math.abs(lineSegments.get(0).getSlope());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LinePoints that = (LinePoints) o;
            List<LineSegment> p1 = that.getLineSegmentsList();
            if (p1.size() != lineSegments.size()) {
                return false;
            }
            return lineSegments.containsAll(p1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(lineSegments);
        }

        public class BySlopeABS implements Comparator<LinePoints> {
            @Override
            public int compare(LinePoints o1, LinePoints o2) {
                double compare = o1.getSlopeABS() - o2.getSlopeABS();
                if (compare > 0) {
                    return 1;
                } else if (compare == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }
    }
}
