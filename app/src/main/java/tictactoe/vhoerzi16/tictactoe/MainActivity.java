package tictactoe.vhoerzi16.tictactoe;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    TextView displayAvailableFields;
    TextView displayCurrentPlayer;
    Player currentPlayer;
    Integer availableFields;
    TableLayout tableLayout;
    private static final String TAG = "TicTacToe Demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG,"--- onSaveInstanceState");
            outState.putString("currentPlayer",currentPlayer.toString());
            outState.putString("availableFields",availableFields.toString());

            String[][] currentButtonState = checkButtonState();
            for(int i = 0; i < currentButtonState.length; i++){
                outState.putStringArray("btnRow_"+(i+1),currentButtonState[i]);
            }

        super.onSaveInstanceState(outState);
    }

    @Override
    protected  void  onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG,"--- onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);

        currentPlayer = Player.valueOf(savedInstanceState.get("currentPlayer").toString().toUpperCase());
        availableFields = new Integer(Integer.parseInt((String)savedInstanceState.get("availableFields")));

        displayAvailableFields.setText(availableFields.toString());
        displayCurrentPlayer.setText(currentPlayer.toString().toLowerCase());


        String[][] emButts = new String[3][3];

        int coutn = 0;
        for(String key : savedInstanceState.keySet()){
            if(key.equals("btnRow_1")||key.equals("btnRow_2")||key.equals("btnRow_3")){
                emButts[coutn] = (String[]) savedInstanceState.get(key);
                coutn++;
            }
        }
        setButtonState(emButts);
    }


    private void initializeUI(){
        Log.i(TAG, "--- initializeUI");
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

    private int[][] tableToArray(TableLayout table){
        int[][] currentStat = new int[3][3];
        for(int i = 0; i < tableLayout.getChildCount(); i++){
            TableRow currentRow = (TableRow)tableLayout.getChildAt(i);
            for(int j = 0; j < currentRow.getChildCount(); j++){
                Button currentButton = (Button) currentRow.getChildAt(j);
                if(currentButton.getText().toString().equals("X")){
                    currentStat[i][j] = 1;
                }else if(currentButton.getText().toString().equals("O")){
                    currentStat[i][j] = -1;
                }else{
                    currentStat[i][j] = 0;
                }
            }
        }
        return currentStat;
    }

    public void btnClicked(View view) {
        Log.v(TAG,currentPlayer +"-> btnClicked");
        Button currentBtn = (Button) view;
        if(currentBtn.getText().equals(" ")){
            if(currentPlayer.equals(Player.PLAYER_1)){
                    currentBtn.setText("X");
                currentPlayer = Player.PLAYER_2;
            }else if(currentPlayer.equals(Player.PLAYER_2)){
                    currentBtn.setText("O");
                currentPlayer = Player.PLAYER_1;
            }
            refreshCount();
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Junge siagst du ned das do scho wos is?";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
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
        return currentStat;
    }

    private void setButtonState(String[][] btnState){
        for(int i = 0; i < tableLayout.getChildCount(); i++){
            TableRow currentRow = (TableRow)tableLayout.getChildAt(i);
            for(int j = 0; j < currentRow.getChildCount(); j++){
                Button currentButton = (Button) currentRow.getChildAt(j);
                currentButton.setText(btnState[i][j]);
            }
        }
    }

    private void resestGame(){availableFields = new Integer(9);
        displayAvailableFields.setText(String.valueOf(availableFields.intValue()));
        if(Math.random() > 0.5){
            currentPlayer = Player.PLAYER_1;
        }else{
            currentPlayer = Player.PLAYER_2;
        }
        displayCurrentPlayer(currentPlayer);


        for(int i = 0; i < tableLayout.getChildCount(); i++){
            TableRow currentRow = (TableRow)tableLayout.getChildAt(i);
            for(int j = 0; j < currentRow.getChildCount(); j++){
                Button currentButton = (Button) currentRow.getChildAt(j);
                currentButton.setText(" ");
            }
        }
    }
}
