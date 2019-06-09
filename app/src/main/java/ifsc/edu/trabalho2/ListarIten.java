package ifsc.edu.trabalho2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarIten extends AppCompatActivity {
    Banco banco;
    SQLiteDatabase base;
    String idLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_iten);
        ArrayList<ItensCompra> lista = new ArrayList<ItensCompra>();
        banco = new Banco(this);
        base = banco.conecao();
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        idLista = b.getString("id");
        Log.i("valor",idLista);
        Cursor cursor = base.rawQuery("select * from itensLista where codLista = "+idLista+"",null);
        //cursor.moveToFirst();
        while (cursor.moveToNext() == true){
            ItensCompra item = new ItensCompra();
            String produto = cursor.getString(cursor.getColumnIndex("produto"));
            item.setProduto(produto);
            int qtd = cursor.getInt(cursor.getColumnIndex("qtd"));
            item.setQuantidade(qtd);
            lista.add(item);

        }
        ListView view = (ListView) findViewById(R.id.list_item);
        AdapterItens abapter=new AdapterItens(this,R.layout.listar,lista);
        view.setAdapter(abapter);


    }

    public void excluirLista(View view) {

        Button botao = (Button) findViewById(R.id.botaoExcluir);
        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                base.delete("itensLista","codLista="+idLista,null);
                base.delete("listaCompra","codLista="+idLista,null);
                Intent intent =new Intent(ListarIten.this, ListarLista.class);
                startActivity(intent);
            }

        });

    }

    public void cadastrarItem(View view) {
        Button botao = (Button) findViewById(R.id.botaoCadastrar);
        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListarIten.this, CadastrarItens.class);
                intent.putExtra("valor",idLista);
                startActivity(intent);
            }

        });
    }

    public void voltar(View view) {
        Button botao = (Button) findViewById(R.id.botaoVoltar);
        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListarIten.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}
