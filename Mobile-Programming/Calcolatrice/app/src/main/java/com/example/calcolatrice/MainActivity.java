package com.example.calcolatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView TVdisplay1, TVdisplay2, TVmemory;
    char operator;
    boolean equalJustPressed = false;
    String memory = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TVdisplay1 = findViewById(R.id.display1);
        TVdisplay2 = findViewById(R.id.display2);
        TVmemory = findViewById(R.id.memory);
    }

    public void digitClicked(View v) { // Numeri cliccati
        if(equalJustPressed)
            TVdisplay2.setText("");

        Button b = (Button) v;
        String str = TVdisplay1.getText().toString() + b.getText().toString();
        TVdisplay1.setText(str);
        equalJustPressed = false;
    }

    public void operatorClicked(View v) { // Operatore cliccato
        Button b = (Button) v;
        if(TVdisplay1.getText().toString().contains(String.valueOf(operator)))
            return; // E' possibile solo un'operazione alla volta

        operator = b.getText().charAt(0);
        String str = TVdisplay1.getText().toString() + operator;

        TVdisplay1.setText(str);
    }

    public void equalClicked(View v) { // Uguale cliccato
        String str = TVdisplay1.getText().toString();
        if(str.equals("") || !str.contains(String.valueOf(operator)))// Se è vuoto il display oppure se non contiene l'operatore
            return;
        if(str.endsWith(String.valueOf(operator))) // Se è stato cliccato un operatore
            return;

        int indexOperator = str.indexOf(operator);
        double x = Double.parseDouble(str.substring(0, indexOperator));
        double y = Double.parseDouble(str.substring(indexOperator + 1));

        if (x == 0 || y == 0)
            return;

        double res = 0;

        TVdisplay2.setText(String.valueOf(y));
        switch (operator) {
            case '+' :
                res = x + y;
                break;
            case '-':
                res = x - y;
                break;
            case '*':
                res = x * y;
                break;
            case '/':
                res = x / y;
                break;
        }

        TVdisplay1.setText("");
        TVdisplay2.setText("" + res);

        operator = 0;
        equalJustPressed = true;
    }

    public void pointClicked(View v) { // Punto cliccato
        Button b = (Button) v;
        String str = TVdisplay1.getText().toString();
        if(!TVdisplay1.getText().toString().contains(".")) {
            str +=  b.getText().toString();
            TVdisplay1.setText(str);
        }
        else if (str.contains(String.valueOf(operator))){
            if(!str.substring(str.indexOf(operator) + 1).contains(".")){
                str += b.getText().toString();
                TVdisplay1.setText(str);
            }
        }
    }

    public void premutoC(View c) { // Cancella display1 e display2
        TVdisplay2.setText("");
        TVdisplay1.setText("");
    }

    public void premutoMS(View c) {
        String str = TVdisplay2.getText().toString();
        if(!str.equals("")) {
            memory = "";
            memory += str;
        }
    }

    public void premutoMC(View c) {
        if(!memory.equals("")) {
            memory = "";
        }
    }

    public void premutoMR(View c) {
        if(memory.equals(""))
            return;
        if(!TVdisplay2.getText().toString().equals(""))
            TVdisplay2.setText("");

        String str = TVdisplay1.getText().toString();
        if(memory.contains(String.valueOf('.')) && str.contains(String.valueOf('.')) && !str.contains(String.valueOf(operator)))
            return;
        str += String.valueOf(memory);
        TVdisplay1.setText(str);
    }
}