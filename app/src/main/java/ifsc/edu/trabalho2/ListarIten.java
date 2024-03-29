package ifsc.edu.trabalho2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarIten extends AppCompatActivity {
    Banco banco;
    SQLiteDatabase base;
    ArrayList<ItensCompra>item;;
    String idLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_iten);
        banco = new Banco(this);
        base = banco.conecao();
        item = new ArrayList<ItensCompra>();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        idLista = bundle.getString("id");
        //String id= intent.getStringExtra("desc");
        Log.i("valorsasa",idLista);
        Cursor cursor = base.rawQuery("select * from itensLista where codLista ='"+idLista+"'",null);

        while
        (cursor.moveToNext() == true){
            ItensCompra compra = new ItensCompra();
            String produto = cursor.getString(cursor.getColumnIndex("produto"));
            compra.setProduto(produto);
            int qtd = cursor.getInt(cursor.getColumnIndex("qtd"));
            compra.setQuantidade(qtd);
            item.add(compra);
        }
        ListView view = (ListView) findViewById(R.id.list_item);
        AdapterItens abapter=new AdapterItens(this,R.layout.listar,item);
        view.setAdapter(abapter);

    }

    public void excluirLista(View view) {
        Button botao = (Button) findViewById(R.id.botaoExcluir);
        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                base.delete("itensLista","codLista ="+idLista,null);
                base.delete("listaCompra","codLista ="+idLista,null);
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
                intent.putExtra("id",idLista);
                startActivity(intent);
            }

        });
    }

    public void voltar(View view) {
        Button botao = (Button) findViewById(R.id.botaoVoltar);
        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListarIten.this, ListarLista.class);
                startActivity(intent);
            }

        });
    }
}
