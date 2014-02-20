package c97rjn.cs.umu.se.mood;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    int colOneSelectedRow = 0;
    int colTwoSelectedRow = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetAllImages();



    }

    private void resetAllImages() {
        for(int row=1;row<5;row++) {            
            for(int col=1;col<3;col++) {
                resetImage(row,col);
            }   
        }

    }

    private void resetImage(int row, int col) {

        ImageButton aButton = getButton(row,col);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);

        drawable.setStroke(5, Color.WHITE);
        //drawable.setColor(Color.LTGRAY);

        aButton.setBackgroundDrawable(drawable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void gameButton(View v) {
        
        // if both selected clear all first
        
        if (colOneSelectedRow != 0 && colTwoSelectedRow != 0) {
            resetAllImages();
            colOneSelectedRow = 0;
            colTwoSelectedRow = 0;
        }
        

        // check the first column

        if (v.getId() == R.id.GameButton1_1) {


            colOneSelectedRow = 1;            
            select(1,1,(ImageButton) findViewById(R.id.GameButton1_1));
        }

        if (v.getId() == R.id.GameButton2_1) {

            colOneSelectedRow = 2;            
            select(2,1,(ImageButton) findViewById(R.id.GameButton2_1));
        }

        if (v.getId() == R.id.GameButton3_1) {

            colOneSelectedRow = 3;
            select(3,1,(ImageButton) findViewById(R.id.GameButton3_1));            
        }

        if (v.getId() == R.id.GameButton4_1) {

            colOneSelectedRow = 4;
            select(4,1,(ImageButton) findViewById(R.id.GameButton4_1));
        }


        // check the second column

        if (v.getId() == R.id.GameButton1_2) {

            colTwoSelectedRow = 1;
            select(1,2,(ImageButton) findViewById(R.id.GameButton1_2));
        }

        if (v.getId() == R.id.GameButton2_2) {

            colTwoSelectedRow = 2;
            select(2,2,(ImageButton) findViewById(R.id.GameButton2_2));
        }

        if (v.getId() == R.id.GameButton3_2) {

            colTwoSelectedRow = 3;
            select(3,2,(ImageButton) findViewById(R.id.GameButton3_2));
        }

        if (v.getId() == R.id.GameButton4_2) {

            colTwoSelectedRow = 4;
            select(4,2,(ImageButton) findViewById(R.id.GameButton4_2));
        }


        // if two choises have been made

        if (colOneSelectedRow == 1 && colTwoSelectedRow == 2 ) {

            display("That is correct");
            
        }
        else{

            if (colOneSelectedRow != 0 && colTwoSelectedRow != 0)
            {
                display("Wrong! Pick 2 new pictures");
                
            }
        }

    }



    private void select(int row, int col, ImageButton selectedImage) {



        for (int iRow=1;iRow<5;iRow++) {

            if (iRow != row) {


                resetImage(iRow,col);

            }

            if (iRow == row) {

                tagImage(iRow,col);
                            }
        }
    }

    private void tagImage(int row, int col) {
        ImageButton aButton = getButton(row,col);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setStroke(5, Color.MAGENTA);
        //drawable.setColor(Color.BLACK);

        aButton.setBackgroundDrawable(drawable);

        
    }

    private ImageButton getButton(int row, int col) {

        if(col == 1) {
            if(row == 1)
                return (ImageButton) findViewById(R.id.GameButton1_1);

            if(row == 2)
                return (ImageButton) findViewById(R.id.GameButton2_1);

            if(row == 3)
                return (ImageButton) findViewById(R.id.GameButton3_1);

            if(row == 4)
                return (ImageButton) findViewById(R.id.GameButton4_1);
        }

        if(col == 2) {
            if(row == 1)
                return (ImageButton) findViewById(R.id.GameButton1_2);

            if(row == 2)
                return (ImageButton) findViewById(R.id.GameButton2_2);

            if(row == 3)
                return (ImageButton) findViewById(R.id.GameButton3_2);

            if(row == 4)
                return (ImageButton) findViewById(R.id.GameButton4_2);
        }


        return null;
    }

    private void display(String text) {

        Toast.makeText(this.getBaseContext(),text, 
                Toast.LENGTH_SHORT).show();

    }

}
