package icesi.i2t.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private EditText et_codigo;
    private Button btn_agregar;
    private ListView lista_estudiantes;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = findViewById(R.id.et_nombre);
        et_codigo = findViewById(R.id.et_codigo);
        btn_agregar = findViewById(R.id.btn_agregar);
        lista_estudiantes = findViewById(R.id.lista_estudiantes);

        adaptador = new Adaptador(this);
        lista_estudiantes.setAdapter(adaptador);

        adaptador.agregarEstudiante(new Estudiante("Cristian","A9012378"));
        adaptador.agregarEstudiante(new Estudiante("Daniel","A9012378"));

        lista_estudiantes.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Estudiante es = (Estudiante) adaptador.getItem(position);
                Toast.makeText(MainActivity.this, es.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_agregar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nombre = et_nombre.getText().toString();
                String codigo = et_codigo.getText().toString();
                Estudiante new_estudiante = new Estudiante(nombre,codigo);
                adaptador.agregarEstudiante(new_estudiante);
                et_nombre.setText("");
                et_codigo.setText("");
            }

        });

    }
}
