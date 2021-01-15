/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author frank
 */
public class ChessRank implements Comparable<ChessRank> {

    private int ID;
    private int rank;

    public ChessRank() {
        ID = -1;
        rank = 0;
    }

    public ChessRank(int ID, int rank) {
        this.ID = ID;
        this.rank = rank;
    }

    public int getID() {
        return ID;
    }

    public int getRank() {
        return rank;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(ChessRank o) {
        return this.rank - o.rank;
    }
}
