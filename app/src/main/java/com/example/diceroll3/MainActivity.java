package com.example.diceroll3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    //dice selections
    public ArrayList<Integer> dice1 = new ArrayList(); //first dice
    public ArrayList<Integer> dice2 = new ArrayList(); //second dice
    public ArrayList<Integer> dice3 = new ArrayList(); //third dice
    //dice rolling
    public int dicerandom = 0; //multiplies the dice by this(6)
    public int dice1random = 0; //the first dice selection
    public int dice2random = 0; //the second dice selection
    public int dice3random = 0; //the third dice selection
    //dice nums
    EditText editText1; //first dice num(gets from dice1random)
    EditText editText2; //second dice num(gets from dice2random)
    EditText editText3; //third dice num(gets from dice3random)
    EditText total;
    //inputs
    //How the dice and keys are set: dice(which dice they apart of[1,2,3])+(which side of the dice[1,2,3,4,5,6])
    //Example of above: dice34 (third dice, fourth side)
    EditText dice11; EditText dice12; EditText dice13; EditText dice14; EditText dice15; EditText dice16; //inputs for the first dice
    EditText dice21; EditText dice22; EditText dice23; EditText dice24; EditText dice25; EditText dice26; //inputs for the second dice
    EditText dice31; EditText dice32; EditText dice33; EditText dice34; EditText dice35; EditText dice36; //inputs for the third dice
    int dice11int; int dice12int; int dice13int; int dice14int; int dice15int; int dice16int; //forms an int from the first dice
    int dice21int; int dice22int; int dice23int; int dice24int; int dice25int; int dice26int; //forms an int from the second dice
    int dice31int; int dice32int; int dice33int; int dice34int; int dice35int; int dice36int; //forms an int from the third dice
    String dice11string; String dice12string; String dice13string; String dice14string; String dice15string; String dice16string; //editText > string > parseInt for dice1
    String dice21string; String dice22string; String dice23string; String dice24string; String dice25string; String dice26string; //editText > string > parseInt for dice2
    String dice31string; String dice32string; String dice33string; String dice34string; String dice35string; String dice36string; //editText > string > parseInt for dice3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sp = this.getPreferences(Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //default dice sides
        //initializing dice sides(18 total sides)
        editText1 = (EditText)findViewById(R.id.textView2);
        editText2 = (EditText)findViewById(R.id.textView);
        editText3 = (EditText)findViewById(R.id.textView5);
        dice11 = (EditText)findViewById(R.id.dice11);
        dice12 = (EditText)findViewById(R.id.dice12);
        dice13 = (EditText)findViewById(R.id.dice13);
        dice14 = (EditText)findViewById(R.id.dice14);
        dice15 = (EditText)findViewById(R.id.dice15);
        dice16 = (EditText)findViewById(R.id.dice16);
        dice21 = (EditText)findViewById(R.id.dice21);
        dice22 = (EditText)findViewById(R.id.dice22);
        dice23 = (EditText)findViewById(R.id.dice23);
        dice24 = (EditText)findViewById(R.id.dice24);
        dice25 = (EditText)findViewById(R.id.dice25);
        dice26 = (EditText)findViewById(R.id.dice26);
        dice31 = (EditText)findViewById(R.id.dice31);
        dice32 = (EditText)findViewById(R.id.dice32);
        dice33 = (EditText)findViewById(R.id.dice33);
        dice34 = (EditText)findViewById(R.id.dice34);
        dice35 = (EditText)findViewById(R.id.dice35);
        dice36 = (EditText)findViewById(R.id.dice36);
        total = (EditText)findViewById(R.id.textView3); //total of all 3 dice combined
        //below sets the saved inputs for dice settings
        dice11.setText(""+sp.getInt("key11",30));
        dice12.setText(""+sp.getInt("key12",30));
        dice13.setText(""+sp.getInt("key13",30));
        dice14.setText(""+sp.getInt("key14",20));
        dice15.setText(""+sp.getInt("key15",20));
        dice16.setText(""+sp.getInt("key16",10));
        dice21.setText(""+sp.getInt("key21",0));
        dice22.setText(""+sp.getInt("key22",0));
        dice23.setText(""+sp.getInt("key23",2));
        dice24.setText(""+sp.getInt("key24",2));
        dice25.setText(""+sp.getInt("key25",3));
        dice26.setText(""+sp.getInt("key26",4));
        dice31.setText(""+sp.getInt("key31",0));
        dice32.setText(""+sp.getInt("key32",1));
        dice33.setText(""+sp.getInt("key33",2));
        dice34.setText(""+sp.getInt("key34",3));
        dice35.setText(""+sp.getInt("key35",4));
        dice36.setText(""+sp.getInt("key36",5));
        setValues(); //populates the arraylist with the current set values
    }
   public void rollDice1(View view){
        //rolls first dice
    dicerandom = (int)(Math.random()*6);
    dice1random = dice1.get(dicerandom);
    editText1.setText(""+dice1random);
    total.setText("Total: "+(dice1random+dice2random+dice3random));
}
public void rollDice2(View view){
        //rolls second dice
    dicerandom = (int)(Math.random()*6);
    dice2random = dice2.get(dicerandom);
    editText2.setText(""+dice2random);
    total.setText("Total: "+(dice1random+dice2random+dice3random));
}
public void rollDice3(View view){
        //rolls third dice
    dicerandom = (int)(Math.random()*6);
    dice3random = dice3.get(dicerandom);
    editText3.setText(""+dice3random);
    total.setText("Total: "+(dice1random+dice2random+dice3random));
}
public void rollDice(View view){
        //rolls all dice
    dicerandom = (int)(Math.random()*6);
    dice1random = dice1.get(dicerandom);
    dice2random = dice2.get(dicerandom);
    dice3random = dice3.get(dicerandom);
    editText1.setText(""+dice1random);
    editText2.setText(""+dice2random);
    editText3.setText(""+dice3random);
    total.setText("Total: "+(dice1random+dice2random+dice3random));
}
public void settings(View view){
        //sets the dice side values
        setValues();
        //end of arraylist edit
    }
    public void resetValues(View view){
        //setting first dice
        dice11.setText("30"); dice12.setText("30"); dice13.setText("30"); dice14.setText("20"); dice15.setText("20"); dice16.setText("10");
        //setting second dice
        dice21.setText("0"); dice22.setText("0"); dice23.setText("2"); dice24.setText("2"); dice25.setText("3"); dice26.setText("4");
        //setting third dice
        dice31.setText("0"); dice32.setText("1"); dice33.setText("2"); dice34.setText("3"); dice35.setText("4"); dice36.setText("5");
        //resetting dice and total text
        editText1.setText(""+0);
        editText2.setText(""+0);
        editText3.setText(""+0);
        total.setText("Total: Nil");
        //completely resets the arraylists to default
        setValues();
    }
public void setValues(){
    //dice1 editText > string > int conversion
    dice11string = dice11.getText().toString(); dice11int = Integer.parseInt(dice11string);
    dice12string = dice12.getText().toString(); dice12int = Integer.parseInt(dice12string);
    dice13string = dice13.getText().toString(); dice13int = Integer.parseInt(dice13string);
    dice14string = dice14.getText().toString(); dice14int = Integer.parseInt(dice14string);
    dice15string = dice15.getText().toString(); dice15int = Integer.parseInt(dice15string);
    dice16string = dice16.getText().toString(); dice16int = Integer.parseInt(dice16string);
    //dice2 editText > string > int conversion
    dice21string = dice21.getText().toString(); dice21int = Integer.parseInt(dice21string);
    dice22string = dice22.getText().toString(); dice22int = Integer.parseInt(dice22string);
    dice23string = dice23.getText().toString(); dice23int = Integer.parseInt(dice23string);
    dice24string = dice24.getText().toString(); dice24int = Integer.parseInt(dice24string);
    dice25string = dice25.getText().toString(); dice25int = Integer.parseInt(dice25string);
    dice26string = dice26.getText().toString(); dice26int = Integer.parseInt(dice26string);
    //dice3 editText > string > int conversion
    dice31string = dice31.getText().toString(); dice31int = Integer.parseInt(dice31string);
    dice32string = dice32.getText().toString(); dice32int = Integer.parseInt(dice32string);
    dice33string = dice33.getText().toString(); dice33int = Integer.parseInt(dice33string);
    dice34string = dice34.getText().toString(); dice34int = Integer.parseInt(dice34string);
    dice35string = dice35.getText().toString(); dice35int = Integer.parseInt(dice35string);
    dice36string = dice36.getText().toString(); dice36int = Integer.parseInt(dice35string);
    //end of int conversion
    dice1.clear();
    dice2.clear();
    dice3.clear();
    //end of arraylist clearing
    dice1.add(dice11int); dice1.add(dice12int); dice1.add(dice13int); dice1.add(dice14int); dice1.add(dice15int); dice1.add(dice16int); //adds dice1 inputs to arraylist(1)
    dice2.add(dice21int); dice2.add(dice22int); dice2.add(dice23int); dice2.add(dice24int); dice2.add(dice25int); dice2.add(dice26int); //adds dice2 inputs to arraylist(2)
    dice3.add(dice31int); dice3.add(dice32int); dice3.add(dice33int); dice3.add(dice34int); dice3.add(dice35int); dice3.add(dice36int); //adds dice3 inputs to arraylist(3)
    SharedPreferences.Editor spe = sp.edit();
    //saves the set inputs to each key
    spe.putInt("key11",+dice11int);
    spe.putInt("key12",+dice12int);
    spe.putInt("key13",+dice13int);
    spe.putInt("key14",+dice14int);
    spe.putInt("key15",+dice15int);
    spe.putInt("key16",+dice16int);
    spe.putInt("key21",+dice21int);
    spe.putInt("key22",+dice22int);
    spe.putInt("key23",+dice23int);
    spe.putInt("key24",+dice24int);
    spe.putInt("key25",+dice25int);
    spe.putInt("key26",+dice26int);
    spe.putInt("key31",+dice31int);
    spe.putInt("key32",+dice32int);
    spe.putInt("key33",+dice33int);
    spe.putInt("key34",+dice34int);
    spe.putInt("key35",+dice35int);
    spe.putInt("key36",+dice36int);
    spe.commit();
    Toast.makeText(MainActivity.this, "Settings have been set and saved to device.", Toast.LENGTH_SHORT).show();
    //end
}
}