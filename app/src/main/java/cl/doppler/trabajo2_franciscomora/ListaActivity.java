package cl.doppler.trabajo2_franciscomora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cl.doppler.trabajo2_franciscomora.Modelo.Genero;

public class ListaActivity extends AppCompatActivity {

    private List<Genero> ListGenero=new ArrayList <Genero>();
    ArrayAdapter<Genero> arrayAdapterGenero;

    EditText etNombre, etGenero;
    Button btAceptar;
    ListView lvGeneros;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        etNombre = findViewById(R.id.etNombre);
        etGenero = findViewById(R.id.etGenero);
        btAceptar = findViewById(R.id.btAceptar);
        lvGeneros = findViewById(R.id.lvGeneros);

        inicializarFireBase();
        listarGeneros();

        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Genero genero=new Genero();

                genero.setIdGenero(UUID.randomUUID().toString());
                genero.setNombre(etNombre.getText().toString());
                genero.setEstado(etGenero.getText().toString());

                databaseReference.child("Genero").child(genero.getIdGenero()).setValue(genero);

            }
        });

    }

    private void inicializarFireBase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    private void listarGeneros() {
        databaseReference.child("Genero").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListGenero.clear();
                for (DataSnapshot objSnapShot : snapshot.getChildren()){
                    Genero gen = objSnapShot.getValue(Genero.class);
                   ListGenero.add(gen);

                    arrayAdapterGenero = new ArrayAdapter<Genero>(ListaActivity.this, android.R.layout.simple_expandable_list_item_1, ListGenero);
                    lvGeneros.setAdapter(arrayAdapterGenero);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

           }
        });

    }

}