package com.example.se2einzelphase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txt_matr;
    TextView txt_antw;
    Button btn_abschicken;
    Button btn_teiler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt_antw = (TextView) findViewById(R.id.txt_antw);
        txt_matr = (EditText) findViewById(R.id.txt_matr);
        btn_abschicken  = (Button) findViewById (R.id.btn_abschicken);
        btn_teiler = (Button) findViewById (R.id.btn_teiler);

        txt_antw.setMovementMethod(new ScrollingMovementMethod());




        btn_teiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mat = txt_matr.getText().toString();

                // Eingabe eines Leerstrings
                if (mat.trim().length() == 0)

                    txt_antw.setText("ungültige Eingabe");


                else {

                    String s = "";

                    for (int i = 0; i <= mat.length()-1; i++) {
                        int a = Character.getNumericValue(mat.charAt(i));
                        for (int j = i + 1; j <= mat.length()-1; j++) {
                            int b = Character.getNumericValue(mat.charAt(j));

                            if (a != 0 && b != 0){
                            int gt =teiler(a,b);
                            if (gt > 1) {
                                s = s + String.valueOf(i) + " und " + String.valueOf(j)
                                        + System.getProperty("line.separator");
                            }
                            }
                        }

                    }

                    txt_antw.setText(s);

                }

            }

            public int teiler(int a, int b) {

                int x;
                do {
                    x = a % b;
                    a = b;
                    b = x;
                } while (b != 0);

                return a;


            }



        });
    }
}
