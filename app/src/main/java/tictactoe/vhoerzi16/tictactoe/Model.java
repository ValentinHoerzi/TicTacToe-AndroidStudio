package tictactoe.vhoerzi16.tictactoe;

import java.util.Arrays;

public class Model {
    private Model(){}

    public static int determineWinner(int[][] matrix){ //returns -2 if the game is not finished and 0 if its a draw
        boolean couldBeDraw = true;
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length;j++)
                if(matrix[i][j]==0)
                    couldBeDraw=false;



        if((matrix[0][0] == matrix[1][1]) &&(matrix[1][1] == matrix[2][2])){
            return matrix[0][0] != 0 ?matrix[0][0]:-2;
        }else if((matrix[0][2] == matrix[1][1]) &&(matrix[1][1] == matrix[2][0])){
            return matrix[0][2]!= 0 ?matrix[0][2]:-2;
        }else{
            for(int iterateThroughRows = 0; iterateThroughRows < matrix.length; iterateThroughRows++){
                int currentRowValue = -2;
                int currentRowCounter = 0;
                for (int iterateThroughLines = 0; iterateThroughLines < matrix[iterateThroughRows].length; iterateThroughLines++) {
                    if(iterateThroughRows == 2){
                        int current = matrix[iterateThroughRows][iterateThroughLines];
                        if(current ==  matrix[iterateThroughRows-1][iterateThroughLines]){
                            if(current ==  matrix[iterateThroughRows-2][iterateThroughLines]){
                                return current != 0 ? current : -2;
                            }
                        }
                    }
                    int cur = matrix[iterateThroughRows][iterateThroughLines];
                    if(cur!=currentRowValue){
                        currentRowValue = cur;
                        currentRowCounter = 1;
                    }else{
                        currentRowCounter++;
                        if(currentRowCounter == 3)return cur != 0 ? cur : -2;
                    }
                }
            }
        }
        return (couldBeDraw ? 0 : -2);
    }

}
