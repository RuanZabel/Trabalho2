package ifsc.edu.trabalho2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ListarIten extends AppCompatActivity {
    Banco banco;
    SQLiteDatabase base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_iten);
        ArrayList<ListaCompra> lista = new ArrayList<ListaCompra>();
        banco = new Banco(this);
        base = banco.conecao();
        //Intent intent = this.getIntent();
        //String idLista = intent.getStringExtra("anomes");
        //String id= intent.getStringExtra("desc");
       // startActivity(intent);
        Log.i("valor","merda");
        //Cursor cursor = base.rawQuery("select * from listaCompra order by codLista desc",null);
        //cursor.moveToFirst();
        //cursor.moveToFirst();

    }
}
