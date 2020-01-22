package a.dataStructures.princeton.priorityQueue.project;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solver {
    private final List<Board> track;
    private Board currentBoard;

    /**
     * find a solution to the initial board (using the A*algorithm)
     *
     * @param initial
     */
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        /** initial variable*/
        currentBoard = initial;
        track = new ArrayList<>();
        track.add(initial);

        /** find the minimum track of 8-puzzle */
        MinPQ<Board> minPQ = null;
        do {
            minPQ = new MinPQ<>((Board less, Board bigger) -> {
                if (less.equals(bigger)) {
                    return 0;
                }
                int thisKey = less.manhattan();
                int thatKey = bigger.manhattan();
                if (thisKey > thatKey) {
                    return 1;
                } else if (thisKey < thatKey) {
                    return -1;
                } else {
                    return 0;
                }
            });
            Iterator<Board> it = currentBoard.neighbors().iterator();
            while (it.hasNext()) {
                Board board = it.next();
                minPQ.insert(board);
            }
            currentBoard = minPQ.min();
            track.add(currentBoard);
        } while (!currentBoard.isGoal());
    }

    /**
     * is the initial board solvable?
     *
     * @return result
     */
    public boolean isSolvable() {
        return currentBoard.isGoal();
    }

    /**
     * min number of moves to solve initial board
     *
     * @return number
     */
    public int moves() {
        return track.size() - 1;
    }

    /**
     * sequence of boards in a shortest solution
     *
     * @return
     */
    public Iterable<Board> solution() {
        return new SolutionIterable();
    }

    private class SolutionIterable implements Iterable<Board> {

        @Override
        public Iterator<Board> iterator() {
            return track.iterator();
        }
    }

    //test client (see below)
    public static void main(String[] args) {


        //solve the puzzle
        Solver solver = new Solver(TestUnits.puzzle08());

        //test moves
        System.out.println(solver.moves());

        //print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }


        System.out.println(solver.moves());
    }

}
