package com.business.payback.challengeTwo.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author : Nargess
 * this class is for each Sauare in the checkboard
 * It's consider that checkerboard in a array of this class
 **/

@Data
@Builder
public class Square {

    /**
     * number of Pointees that now are in the square for each step
     */
    private int currentPointeesCount;

    /**
     * number of pointees that now jump in this square for this step, these Pointess are currentPointeesCount in next
     * step
     */
    private int newPointeesCount;

    /**
     * number of all pointees that are sitting on this square until now (in all steps)
     */
    private int pointsCount;

    /**
     * list of neighbor number of this square
     */
    private List<Integer> neighborList;

    /**
     * row index
     */
    private int row;

    /**
     * column index
     */
    private int col;

}
