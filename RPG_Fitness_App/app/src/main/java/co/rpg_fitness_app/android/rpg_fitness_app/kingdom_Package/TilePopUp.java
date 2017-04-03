package co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by Tanner on 3/11/2017.
 */

public class TilePopUp extends Activity{

    Tile tile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tile_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.85), (int)(height*0.85));

        this.tile = (Tile) getIntent().getSerializableExtra("tile");
        configureExitButton();
        configurePurchaseButton();
        populateTemplate();
    }

    private void configureExitButton() {
        Button Button = (Button) findViewById(R.id.exitTilePopUp);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configurePurchaseButton() {
        //purchase house
        ImageButton Button;
        Button = (ImageButton) findViewById(R.id.purchaseBuilding1);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("house")) {
                    Intent resultData = new Intent();
                    resultData.putExtra("tile", tile);
                    setResult(1, resultData);
                    finish();
                }
                else {
                    finish();
                }
            }
        });
        //purchase wood bridge
        Button = (ImageButton) findViewById(R.id.purchaseBuilding2);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("wood bridge")) {
                    Intent resultData = new Intent();
                    resultData.putExtra("tile", tile);
                    setResult(1, resultData);
                    finish();
                }
                else{
                    finish();
                }
            }
        });
        //purchase cave
        Button = (ImageButton) findViewById(R.id.purchaseBuilding3);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("cave")) {
                    Intent resultData = new Intent();
                    resultData.putExtra("tile", tile);
                    setResult(1, resultData);
                    finish();
                }
                else {
                    finish();
                }
            }
        });
        //purchase Tavern
        Button = (ImageButton) findViewById(R.id.purchaseBuilding4);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("tavern")) {
                    Intent resultData = new Intent();
                    resultData.putExtra("tile", tile);
                    setResult(1, resultData);
                    finish();
                }
                else {
                    finish();
                }
            }
        });
        //purchase Fort
        Button = (ImageButton) findViewById(R.id.purchaseBuilding5);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("fort")) {
                    Intent resultData = new Intent();
                    resultData.putExtra("tile", tile);
                    setResult(1, resultData);
                    finish();
                }
                else {
                    finish();
                }
            }
        });
        //purchase pond
        Button = (ImageButton) findViewById(R.id.purchaseBuilding6);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("pond")) {
                    Intent resultData = new Intent();
                    resultData.putExtra("tile", tile);
                    setResult(1, resultData);
                    finish();
                }
                else {
                    finish();
                }
            }
        });
    }

    private void populateTemplate(){
        //house
        ImageButton i;
        TextView t;
        i = (ImageButton) findViewById(R.id.purchaseBuilding1);
        i.setBackgroundResource(R.drawable.shield);
        t = (TextView) findViewById(R.id.purchaseBuilding1Text);
        t.setText("House:\nA house will give you extra gold!\nConstruction Cost: 1 wood, 1 gold");
        //wood bridge
        i = (ImageButton) findViewById(R.id.purchaseBuilding2);
        i.setBackgroundResource(R.drawable.shield);
        t = (TextView) findViewById(R.id.purchaseBuilding2Text);
        t.setText("Wood Bridge:\nA wood bridge will give you extra wood!\nConstruction Cost: 1 wood, 1 gold");
        //cave
        i = (ImageButton) findViewById(R.id.purchaseBuilding3);
        i.setBackgroundResource(R.drawable.shield);
        t = (TextView) findViewById(R.id.purchaseBuilding3Text);
        t.setText("Cave:\nA cave will give you extra stone!\nConstruction Cost: 1 wood, 1 gold");
        //tavern
        i = (ImageButton) findViewById(R.id.purchaseBuilding4);
        i.setBackgroundResource(R.drawable.shield);
        t = (TextView) findViewById(R.id.purchaseBuilding4Text);
        t.setText("Tavern:\nA tavern will give you extra gold!\nConstruction Cost: 1 stone, 1 gold");
        //fort
        i = (ImageButton) findViewById(R.id.purchaseBuilding5);
        i.setBackgroundResource(R.drawable.shield);
        t = (TextView) findViewById(R.id.purchaseBuilding5Text);
        t.setText("Fort:\nA fort will give you extra wood!\nConstruction Cost: 1 wood, 1 gold");
        //pond
        i = (ImageButton) findViewById(R.id.purchaseBuilding6);
        i.setBackgroundResource(R.drawable.shield);
        t = (TextView) findViewById(R.id.purchaseBuilding6Text);
        t.setText("Pond:\nA pond will give you extra gold!\nConstruction Cost: 1 stone, 1 gold");
    }


    //TODO
    private boolean purchaseBuilding(String buildingName){
        //////////test code////////////////
        Building newBuilding = new Building(buildingName);
        tile.setMyBuilding(newBuilding);
        return true;
        //////////////////////////////////

        //TODO get users currency
        /*Building newBuilding = new Building(buildingName);
        Currency userCurrency = user.getCurrency();
        Currency buildingCost = newBuilding.getCost();
        if (userCurrency.getWood()>=buildingCost.getWood() && userCurrency.getGold()>=buildingCost.getGold() && userCurrency.getStone()>=buildingCost.getStone() &&
                userCurrency.getMisc1()>=buildingCost.getMisc1() && userCurrency.getMisc2()>=buildingCost.getMisc2() && userCurrency.getMisc3()>=buildingCost.getMisc3() &&
                userCurrency.getMisc1()>=buildingCost.getMisc5() && userCurrency.getMisc1()>=buildingCost.getMisc5()) {
            userCurrency.updateResource(false, buildingCost.getWood(), buildingCost.getGold(), buildingCost.getStone(), buildingCost.getMisc1(),
                    buildingCost.getMisc2(), buildingCost.getMisc3(), buildingCost.getMisc4(), buildingCost.getMisc5());
        }
       else{
            return false;
        }
        tile.setMyBuilding(newBuilding);
        return true;*/
    }

}
