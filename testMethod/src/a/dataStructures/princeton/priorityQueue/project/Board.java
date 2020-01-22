package a.dataStructures.princeton.priorityQueue.project;

import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

public class Board {
    private int dimension;
    private int len;
    private int[] blocks;

    /**
     * create a board from an n-by-n array of tiles,
     * where tiles[row][col] = tile at (row, col)
     *
     * @param tiles
     */
    public Board(int[][] tiles) {
        dimension = tiles.length;
        len = dimension * dimension;
        blocks = new int[len];
        int index = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                int context = tiles[i][j];
                blocks[index] = context;
                index++;
            }
        }

    }

    private Board(int[] blocks, int dimension) {
        this.dimension = dimension;
        this.len = dimension * dimension;
        this.blocks = Arrays.copyOf(blocks, blocks.length);
    }

    /**
     * string representation of this board
     *
     * @return a array on puzzle
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(dimension + "\n");
        int index = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sb.append(blocks[index]);
                index++;
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * board dimension n
     *
     * @return the length of row or column
     */
    public int dimension() {
        return dimension;
    }

    /**
     * number of tiles out of place
     *
     * @return number
     */
    public int hamming() {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (blocks[i] != 0 && blocks[i] != (i + 1)) {
                count++;
            }
        }
        return count;
    }

    /**
     * sum of Manhattan distances between tiles and goal
     *
     * @return number
     */
    public int manhattan() {
        int manhattan = 0;
        for (int k = 0; k < len; k++) {
            if (blocks[k] == 0) continue;
            int rowdiff = Math.abs(getRow(blocks[k]) - getRow(k + 1));
            int coldiff = Math.abs(getCol(blocks[k]) - getCol(k + 1));
            manhattan = manhattan + rowdiff + coldiff;
        }
        return manhattan;
    }

    // is this board the goal board?

    /**
     * justify this board to be goal board
     *
     * @return result
     */
    public boolean isGoal() {
        for (int k = 0; k < len - 1; k++) {
            if (blocks[k] != k + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * does this board equal y?
     *
     * @param y the object
     * @return the result of equality
     */
    public boolean equals(Object y) {
        if (y == null) {
            return false;
        }
        if (!(y instanceof Board)) {
            return false;
        }
        if (y == this) {
            return true;
        }
        Board that = (Board) y;
        return Arrays.equals(blocks, that.blocks);
    }

    /**
     * find all neighboring boards
     *
     * @return Iterable
     */
    public Iterable<Board> neighbors() {
        return new BoardIterable();
    }

    private class BoardIterable implements Iterable<Board> {
        @Override
        public Iterator<Board> iterator() {
            //find the 0 block
            int index = 0;
            for (int i = 0; i < len; i++) {
                if (blocks[i] == 0) {
                    index = i;
                    break;
                }
            }
            //get up,left,bottom,right index
            int[] indexs = getSurroundIndexs(index);

            //create the new board
            List<Board> boards = new ArrayList<>();
            for (int i = 0; i < indexs.length; i++) {
                if (indexs[i] != -1) {
                    int[] neighbour = Arrays.copyOf(blocks, blocks.length);
                    exchangeElement(neighbour, indexs[i], index);
                    Board b = new Board(neighbour, dimension);
                    boards.add(b);
                }
            }
            return boards.iterator();
        }
    }

    public Comparator<Board> getComparator() {
        return new BoardComparator();
    }

    private class BoardComparator implements Comparator<Board> {
        @Override
        public int compare(Board o1, Board o2) {
            int thisKey = o1.manhattan();
            int thatKey = o2.manhattan();
            /* the smaller key means bigger */
            if (thisKey > thatKey) {
                return 1;
            } else if (thisKey < thatKey) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * a board that is obtained by exchanging any pair of tiles
     *
     * @return a twin board
     */
    public Board twin() {
        int[] twinBlocks = Arrays.copyOf(blocks, blocks.length);
        // choose a non-blank block randomly
        int k;
        do {
            k = StdRandom.uniform(len);
        } while (blocks[k] == 0);
        //get surrounding index
        int[] indexs = getSurroundIndexs(k);
        int range = indexs.length;
        // choose an exchange direction randomly
        int key;
        while (true) {
            key = StdRandom.uniform(range);
            // a direction index is out of bound
            if (indexs[key] == -1) {
                continue;
            }
            exchangeElement(twinBlocks, k, key);
            break;
        }
        Board board = new Board(twinBlocks, dimension);
        return board;
    }

    /**
     * get row number(start from 1)
     *
     * @param index the index need to find
     * @return row
     */
    private int getRow(int index) {
        return (int) Math.ceil((double) index / (double) dimension);
    }


    /**
     * get column number(start from 1)
     *
     * @param index the index need to find
     * @return col
     */
    private int getCol(int index) {
        if (index % dimension == 0) return dimension;
        return index % dimension;
    }

    /**
     * get up,left,bottom,right index
     *
     * @param index the node index in blocks
     * @return all indexs in blocks
     */
    private int[] getSurroundIndexs(int index) {
        //get row and col in n-n array
        int row = getRow(index + 1);
        int col = getCol(index + 1);

        //get up,left,bottom,right index
        int[] indexs = new int[4];
        indexs[0] = getIndex(row - 1, col);
        indexs[1] = getIndex(row, col - 1);
        indexs[2] = getIndex(row + 1, col);
        indexs[3] = getIndex(row, col + 1);
        return indexs;
    }

    /**
     * exchange two element in a array
     *
     * @param blocks the array
     * @param indexA first index
     * @param indexB second index
     */
    private void exchangeElement(int[] blocks, int indexA, int indexB) {
        int temp = blocks[indexA];
        blocks[indexA] = blocks[indexB];
        blocks[indexB] = temp;
    }


    /**
     * get index by row and col
     *
     * @param row
     * @param col
     * @return
     */
    private int getIndex(int row, int col) {
        if (row <= 0 || col <= 0 || row > dimension || col > dimension) {
            return -1;
        }
        return (row - 1) * dimension + (col - 1);
    }


    /**
     * unit testing (not graded)
     *
     * @param args
     */
    public static void main(String[] args) {
        //test neighbour method
        /*int[][] tiles = new int[3][3];
        tiles[0][0] = 1;
        tiles[0][1] = 0;
        tiles[0][2] = 3;
        tiles[1][0] = 4;
        tiles[1][1] = 2;
        tiles[1][2] = 5;
        tiles[2][0] = 7;
        tiles[2][1] = 8;
        tiles[2][2] = 6;
        Board b = new Board(tiles);
        Iterator<Board> it = b.neighbors().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/

        //test getIndex
        //System.out.println(b.getIndex(2, 2));
    }
}