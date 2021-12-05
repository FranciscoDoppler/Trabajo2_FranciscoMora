package cl.doppler.trabajo2_franciscomora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button botoN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        botoN =(Button) findViewById(R.id.btLista);


        Intent intent2=new Intent(this, MapsActivity.class);
        Intent intent1=new Intent(this,ListaActivity.class);

                botoN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(intent1);
                        startActivity(intent2);
                    }
                });


    }
}