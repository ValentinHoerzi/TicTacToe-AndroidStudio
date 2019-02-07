package tictactoe.vhoerzi16.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView displayAvailableFields;
    TextView displayCurrentPlayer;
    Player currentPlayer;
    Integer availableFields;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
        onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String[][] currentButtonState = checkButtonState();
        for(int i = 0; i < currentButtonState.length; i++){
            outState.putStringArray("Row_"+(i+1),currentButtonState[i]);
        }

    }

    @Override
    protected  void  onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

    }


    private void initializeUI(){
        tableLayout = findViewById(R.id.tableLayout);
        displayAvailableFields = findViewById(R.id.textViewDisplayAvailableFields);
        displayCurrentPlayer = findViewById(R.id.textViewDisplayCurrentPlayer);
        availableFields = new Integer(9);
        displayAvailableFields.setText(String.valueOf(availableFields.intValue()));
        if(Math.random() > 0.5){
            currentPlayer = Player.PLAYER_1;
        }else{
            currentPlayer = Player.PLAYER_2;
        }
        displayCurrentPlayer(currentPlayer);
    }

    public void btnClicked(View view) {
        Button currentBtn = (Button) view;
        if(currentBtn.getText().equals("")){
            if(currentPlayer.equals(Player.PLAYER_1)){
                    currentBtn.setText("X");
                currentPlayer = Player.PLAYER_2;
            }else if(currentPlayer.equals(Player.PLAYER_2)){
                    currentBtn.setText("O");
                currentPlayer = Player.PLAYER_1;
            }
            refreshCount();
        }else{
            //TODO toast
        }
        displayCurrentPlayer(currentPlayer);
    }

    private void displayCurrentPlayer(Player p) {
        displayCurrentPlayer.setText(p.toString().toLowerCase());
    }

    private void refreshCount(){
        availableFields = new Integer(availableFields.intValue()-1);
        displayAvailableFields.setText(String.valueOf(availableFields.intValue()));
    }

    private String[][] checkButtonState(){
        String[][] currentStat = new String[3][3];
        for(int i = 0; i < tableLayout.getChildCount(); i++){
            TableRow currentRow = (TableRow)tableLayout.getChildAt(i);
            for(int j = 0; j < currentRow.getChildCount(); j++){
                Button currentButton = (Button) currentRow.getChildAt(j);
                currentStat[i][j] = currentButton.getText().toString();
            }
        }
        return null;
    }
}
