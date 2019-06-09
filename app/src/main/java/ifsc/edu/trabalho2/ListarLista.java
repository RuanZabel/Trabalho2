package ifsc.edu.trabalho2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarLista extends AppCompatActivity {
    Banco banco;
    SQLiteDatabase base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_lista);
        ArrayList<ListaCompra> lista = new ArrayList<ListaCompra>();
        banco = new Banco(this);
        base = banco.conecao();
        Cursor cursor = base.rawQuery("select * from listaCompra order by codLista desc",null);
        cursor.moveToFirst();
        do
        {
            ListaCompra listaCompra = new ListaCompra();
            String desc = cursor.getString(cursor.getColumnIndex("DESCRICAO"));
            listaCompra.inserirDesc(desc);
            String anoMes = cursor.getString(cursor.getColumnIndex("amlista"));
            listaCompra.inserirAnoMes(anoMes);
            int id = cursor.getInt(cursor.getColumnIndex("codLista"));
            listaCompra.inserirId(id);
            lista.add(listaCompra);
        }
        while
        (cursor.moveToNext());
        ListView view = (ListView) findViewById(R.id.list);
        Abapter abapter=new Abapter(this,R.layout.listar,lista);
        view.setAdapter(abapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("teste","aqui"+position);
                TextView anomes =(TextView) view.findViewById(R.id.textAnoMes);
                TextView desc = (TextView) view.findViewById(R.id.textDescricao);
                TextView codigo = (TextView) view.findViewById(R.id.CodigoLista);
                Intent intent =new Intent(ListarLista.this, ListarIten.class);
                Log.i("vava",codigo.getText().toString());
                String text = codigo.getText().toString();
                intent.putExtra("id",text);
                //intent.putExtra("desc",desc.getText().toString());
                startActivity(intent);

            }
        });
    }
}
