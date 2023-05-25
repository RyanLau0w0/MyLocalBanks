package sg.edu.rp.c346.id22023219.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);


    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == btnDBS){
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Telephone");
        }
        else if (v == btnOCBC) {
            menu.add(0,2,0,"Website");
            menu.add(0,3,1,"Telephone");
        }
        else if (v == btnUOB) {
            menu.add(0,4,0,"Website");
            menu.add(0,5,1,"Telephone");
        }

    }

    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            Intent intentWeb = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.dbs.com.sg"));
            startActivity(intentWeb);
            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL , Uri.parse("tel:" + "18001111111"));
            startActivity(intentCall);
            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==2) { //check if the selected menu item ID is 1
            //code for action
            Intent intentWeb = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.ocbc.com"));
            startActivity(intentWeb);
            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==3) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL , Uri.parse("tel:" + "18003633333"));
            startActivity(intentCall);
            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==4) { //check if the selected menu item ID is 1
            //code for action
            Intent intentWeb = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.uob.com.sg"));
            startActivity(intentWeb);
            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==5) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL , Uri.parse("tel:" + "18002222121"));
            startActivity(intentCall);
            return true;  //menu item successfully handled
        }


        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;
        }
        else if (id == R.id.chineseSelection) {
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}