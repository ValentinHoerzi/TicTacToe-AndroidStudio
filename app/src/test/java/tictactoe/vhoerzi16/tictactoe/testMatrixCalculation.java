package tictactoe.vhoerzi16.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class testMatrixCalculation {
    @Test
    public void checkWinnerLine1() throws Exception {
        /*
        Line 1 full
         */
        int[][] testMatrix =  {{1,1,1},
                               {1,-1,-1},
                              {-1,1,-1}};
        int exp = 1;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);
    }

    @Test
    public void checkWinnerLine2() throws Exception {
        /*
        Line 2 full
         */
        int[][] testMatrix =  {{1,-1,0},
                               {1,1,1},
                               {0,1,-1}};
        int exp = 1;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);
    }

    @Test
    public void checkWinnerLine3() throws Exception {
        /*
        Line 3 full
         */
        int[][] testMatrix =  {{1,-1,-1},
                               {-1,0,-1},
                               {1,1,1}};
        int exp = 1;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);
    }

    @Test
    public  void checkWinnerColumn1() throws  Exception{
        /*
        Column 1 full
         */
        int[][] testMatrix =  {{1,-1,-1},
                               {1,1,-1},
                               {1,0,0}};
        int exp = 1;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);
    }

    @Test
    public  void checkWinnerColumn2() throws  Exception{
        /*
        Column 2 full
         */
        int[][] testMatrix =  {{-1,-1,-1},
                               {1,-1,-1},
                               {1,-1,1}};
        int exp = -1;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);

    }

    @Test
    public  void checkWinnerColumn3() throws  Exception{
        /*
        Column 3 full
         */
        int[][] testMatrix =  {{1,-1,-1},
                               {1,-1,-1},
                               {0,1,-1}};
        int exp = -1;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);
    }

    @Test
    public  void checkWinnerCross1() throws  Exception{
        /*
        Cross left to right
         */
        int[][] testMatrix =  {{-1,-1,0},
                               {1,-1,-1},
                               {-1,1,-1}};
        int exp = -1;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);
    }


    @Test
    public  void checkWinnerCross2() throws  Exception{
        /*
       Cross right to left
         */
        int[][] testMatrix =  {{1,-1,-1},
                               {1,-1,-1},
                               {-1,1,0}};
        int exp = -1;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);
    }

    @Test
    public void testDraw() throws Exception{
                /*
        Expected a draw
         */
        int[][] testMatrix =  {{-1,-1,1},
                               {1,-1,-1},
                               {-1,1,1}};
        int exp = 0;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);
    }

    @Test
    public void testGameNotFinished1(){
        int[][] testMatrix =  {{0,-1,1},
                               {0,1,-1},
                               {0,0,0}};
        int exp = -2;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);
    }

    @Test
    public void testGameNotFinished2(){
        int[][] testMatrix =  {{0,-1,1},
                               {0,1,-1},
                               {0,1,0}};
        int exp = -2;
        int res = Model.determineWinner(testMatrix);
        assertEquals(exp,res);
    }
}