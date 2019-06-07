package ifsc.edu.trabalho2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
    public SQLiteDatabase banco;
    Banco banca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrarLista(View view) {
        Button botao = (Button) findViewById(R.id.cadastrar);
        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, CadastrarLista.class);
                startActivity(intent);
            }

        });

    }

    public void listarLista(View view) {
        Button botao = (Button) findViewById(R.id.listarLista);
        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, ListarLista.class);
                startActivity(intent);
            }

        });
    }

}
