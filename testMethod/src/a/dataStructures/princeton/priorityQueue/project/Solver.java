package a.dataStructures.princeton.priorityQueue.project;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solver {
    private MinPQ<Board> minPQ;
    private int moves;
    private List<Board> track;
    private Board currentBoard;

    /**
     * find a solution to the initial board (using the A* algorithm)
     *
     * @param initial
     */
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        /* initial variable*/
        minPQ = new MinPQ<>(initial.getComparator());
        moves = 0;
        currentBoard = initial;
        track = new ArrayList<>();
        track.add(initial);
        findTrack();
    }

    /**
     * find the minimum track of 8-puzzle
     */
    private void findTrack() {
        while(!currentBoard.isGoal()) {
            Iterator<Board> it = currentBoard.neighbors().iterator();
            while(it.hasNext()){
                Board board = it.next();
                minPQ.insert(board);
            }
            currentBoard = minPQ.min();
            track.add(currentBoard);
            moves++;
            minPQ.delMin();
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return currentBoard.isGoal();
    }

    // min number of moves to solve initial board
    public int moves() {
        return moves;
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

    // test client (see below)
    public static void main(String[] args) {
        /*int[][] tiles = new int[3][3];
        tiles[0][0] = 0;
        tiles[0][1] = 1;
        tiles[0][2] = 3;
        tiles[1][0] = 4;
        tiles[1][1] = 2;
        tiles[1][2] = 5;
        tiles[2][0] = 7;
        tiles[2][1] = 8;
        tiles[2][2] = 6;
        Board initial = new Board(tiles);
        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }*/
    }

}
