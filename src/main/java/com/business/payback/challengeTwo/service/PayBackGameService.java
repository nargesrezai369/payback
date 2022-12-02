package com.business.payback.challengeTwo.service;

import com.business.payback.challengeTwo.model.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Nargess
 * this class is payback game service.
 * <p>
 * in this game we assume the checkerboard is a 1D array (15*15) of suare class. each elemet of array have a number
 * that created with column and row with row*15+column formula. so we can find the neighbor and set the neighbor number
 * in elements.
 * <p>
 * at the first the checkerboard is initialized by initCheckBoard method.
 * <p>
 * with method game you can start the game with your selected roundCount.
 * <p>
 * be carefull at the result, I show you number of point and pointees. point is number of all pointees that are sitting
 * on this square until now (in all steps). number of pointees is just for last round (25 or 50 or 100)
 **/
public class PayBackGameService {

    /**
     * size of checkerboard
     */
    private static final int checkBoardSize = 15;

    /**
     * a 1D array for checkerboard game
     */
    private static final Square[] checkBoard = new Square[checkBoardSize * checkBoardSize];


    /**
     * initialize checkerboard array.
     * for all element it's set column number, row number, number of current pointee with 1, number of point count with
     * 0 and find the neighbors.
     * each element in the array has a number base on row and col, row*15+col. so we can set neighbors easily.
     */
    private static void initCheckBoard() {
        //first for because of number of checkerboard row
        int row = 0;
        while (row < checkBoardSize) {

            //second for because of number of checkerboard column
            for (int col = 0; col < checkBoardSize; col++) {

                //set elemet of array
                checkBoard[row * checkBoardSize + col] = Square.builder()
                        .col(col)
                        .row(row)
                        .currentPointeesCount(1)
                        .pointsCount(0)
                        .neighborList(findNeighborList(row, col)) // call find neighbor method
                        .build();
            }
            row = row + 1;
        }
    }

    /**
     * @param row : row index of element
     * @param col : col index of element
     * @return : number of neighbor
     */
    private static List<Integer> findNeighborList(int row, int col) {

        //declare neighbor list
        List<Integer> neighborList = new ArrayList<>();

        //neighbor row index should be less than 15
        if (row + 1 < checkBoardSize) {

            //element with row+1 and col is a neighbor for current cell
            neighborList.add((row + 1) * checkBoardSize + col);
        }

        //neighbor row index should be greater than -1
        if (row - 1 > -1) {

            //element with row-1 and col is a neighbor for current cell
            neighborList.add((row - 1) * checkBoardSize + col);
        }


        //neighbor col index should be greater than -1
        if (col - 1 > -1) {

            //element with row and col-1 is a neighbor for current cell
            neighborList.add(row * checkBoardSize + (col - 1));
        }

        //neighbor col index should be less than 15
        if (col + 1 < checkBoardSize) {

            //element with row and col+1 is a neighbor for current cell
            neighborList.add(row * checkBoardSize + (col + 1));
        }
        //return result
        return neighborList;
    }

    /**
     * check final round number.
     * it mist be 25 or 50 or 100 otherwise the method return an exception.
     *
     * @param finalRoundNumber :  final round number
     */
    private static void checkRound(int finalRoundNumber) {
        if (finalRoundNumber != 25 && finalRoundNumber != 50 && finalRoundNumber != 100)
            throw new RuntimeException("round error... , round must be 25,50 or 100. ");
    }

    /**
     * select a square from this square's neighborhood
     * when a bird jump, pointees should jump to a random square.
     * this method get count of neighbor and select one of them randomly.
     *
     * @param size : number of neighbors
     * @return random neighbor number
     */
    private static int getRandomSquare(int size) {

        //random square number
        int randomSquare;

        //call random method for get a number
        randomSquare = (int) ((Math.random() * (size)) + 0);

        //return result
        return randomSquare;
    }

    /**
     * strt the game
     * for number of all round, each step of game is executed here.
     *
     * @param roundNumber: number of final round.
     */
    private static void game(int roundNumber) {

        //for number of all round, each step of game is executed h
        for (int round = 0; round < roundNumber; round++) {

            //call each step of game
            doGameRound();
        }
    }

    /**
     * each step of game excute here.
     * for each square in array, until the pointees are existed, jump method is executed and pointees go to another
     * square and are sitting on ite (in newPointeesCount)
     */
    private static void doGameRound() {

        //for each square in array, until the pointees are existed, jump method is executed
        for (Square currentSquare : checkBoard) {
            while (currentSquare.getCurrentPointeesCount() != 0) {

                //call jump method for each pointee in current square
                jumpPointees(currentSquare);
            }
        }
        //return result
        initPointees();
    }

    /**
     * jump pointees method
     * in this current square, a random neighbor is selected and current pointee jump to it, be careful that the
     * pointee add to newPointeesCount for next step not this step.
     *
     * @param currentSquare : one the square in checkerboard
     */
    private static void jumpPointees(Square currentSquare) {

        //select random neighbor
        int randomNeighborNumber = getRandomSquare(currentSquare.getNeighborList().size());

        //select random element with their number in randomNeighborNumber
        int randomSquareCell = currentSquare.getNeighborList().get(randomNeighborNumber);

        //decrease count of current pointees
        currentSquare.setCurrentPointeesCount(currentSquare.getCurrentPointeesCount() - 1);

        //update pointee in neighbor cell
        checkBoard[randomSquareCell].setNewPointeesCount(checkBoard[randomSquareCell].getNewPointeesCount() + 1);

        //update points (all pointees until now) in neighbor cell
        checkBoard[randomSquareCell].setPointsCount(checkBoard[randomSquareCell].getPointsCount() + 1);
    }

    /**
     * this method is for update pointee for next round.
     * jumped pointees save in NewPointeesCount for next step and after the round the CurrentPointeesCount initialize
     * whit NewPointeesCount.
     */
    private static void initPointees() {
        //
        for (Square currentSquare : checkBoard) {

            //initialize CurrentPointeesCount with NewPointeesCount for next step
            currentSquare.setCurrentPointeesCount(currentSquare.getNewPointeesCount());

            //initialize newpointees for next round
            currentSquare.setNewPointeesCount(0);
        }
    }

    /**
     * the Number Of Points Per Each Coupon.
     * points is all of the pointees that are sitting on this square until now
     */
    private static void theNumberOfPointsPerEachCoupon() {
        System.out.println("***************************************************************************************\n");

        System.out.println(" The Number Of Points Per Each Coupon.");
        System.out.println(" Points is all of the pointees that are sitting on" +
                " this square until now.\n");

        for (Square square : checkBoard) {
            System.out.println("  square ( " + square.getRow() + " , " + square.getCol() + " ) = " +
                    square.getPointsCount());
        }
    }

    /**
     * the Number Of Pointees Per Each Coupon.
     * number of pointees that are sitting on this square currently
     */
    private static void theNumberOfPointeesPerEachCoupon() {

        System.out.println("***************************************************************************************\n");

        System.out.println(" The Number Of Points Per Each Coupon.");
        System.out.println(" Number of pointees that are sitting on this square currently.\n");

        for (Square square : checkBoard) {
            System.out.println("  square ( " + square.getRow() + " , " + square.getCol() + " ) = " +
                    "" + square.getCurrentPointeesCount());
        }
    }

    /**
     * the Coupon nWith Highest Number Of Points.
     * points is all of the pointees that are sitting on this square until now.
     * algorithm is linear search.
     */
    private static void theCouponWithHighestNumberOfPoints() {

        //It's consider that maybe there are some square with the same value
        List<Square> maxSquares = new ArrayList<>();
        int max = 0;
        //
        for (Square square : checkBoard) {
            if (square.getPointsCount() > max) {
                max = square.getPointsCount();
                maxSquares = new ArrayList<>();
                maxSquares.add(square);
            } else if (square.getPointsCount() == max) {
                maxSquares.add(square);
            }
        }
        System.out.println("***************************************************************************************\n");
        System.out.println(" Highest Number Of points (number of all pointees until now) on this square is " + max );

        for (Square targetSquare : maxSquares) {
            System.out.println("   (" + targetSquare.getRow() + " , " +
                    targetSquare.getCol() + " ) ");
        }
    }

    /**
     * the Coupo nWith Highest Number Of Points.
     * number of pointees that are sitting on this square currently.
     * algorithm is linear search.
     */
    private static void theCouponWithHighestNumberOfPointees() {

        //It's consider that maybe there are some square with the same value
        List<Square> maxSquares = new ArrayList<>();
        int max = 0;
        //
        for (Square square : checkBoard) {
            if (square.getCurrentPointeesCount() > max) {
                max = square.getCurrentPointeesCount();
                maxSquares = new ArrayList<>();
                maxSquares.add(square);
            } else if (square.getCurrentPointeesCount() == max) {
                maxSquares.add(square);
            }
        }
        System.out.println("***************************************************************************************\n");
        System.out.println(" Highest Number Of Pointees that are sitting on this square currently is " + max );

        for (Square targetSquare : maxSquares) {
            System.out.println("   (" + targetSquare.getRow() + " , " +
                    targetSquare.getCol() + " ) ");
        }
    }

    /**
     * steps of game
     * you can start game with this method
     *
     * @param gameRound: the number of game round that user want to play and get the coupon score
     */
    public static void startGame(int gameRound) {

        //check round number, it must be 25 or 50 or 100
        checkRound(gameRound);

        //initialize game board
        initCheckBoard();

        //start the game
        game(gameRound);

        //print the Number Of Points Per Each Coupon
        theNumberOfPointsPerEachCoupon();

        //print the Number Of Pointees Per Each Coupon
        theNumberOfPointeesPerEachCoupon();

        //print the Coupon With Highest Number Of Points
        theCouponWithHighestNumberOfPoints();

        //print the Coupon With Highest Number Of Pointees
        theCouponWithHighestNumberOfPointees();
    }
}
