package ifsc.edu.trabalho2;

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
        cursor.moveToFirst();
        do
        {
            ListaCompra listaCompra = new ListaCompra();
            String desc = cursor.getString(cursor.getColumnIndex("DESCRICAO"));
            listaCompra.inserirDesc(desc);
            String anoMes = cursor.getString(cursor.getColumnIndex("amlista"));
            listaCompra.inserirAnoMes(anoMes);
            lista.add(listaCompra);
        }
        while
        (cursor.moveToNext());
        ListView view = (ListView) findViewById(R.id.list);
        Abapter abapter=new Abapter(this,R.layout.listar,lista);
        view.setAdapter(abapter);

        view.setAdapter(abapter);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("teste","aqui"+position);
                TextView anomes =(TextView) view.findViewById(R.id.textAnoMes);
                TextView desc = (TextView) view.findViewById(R.id.textDescricao);

            }
        });
    }
}
