package ifsc.edu.trabalho2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CadastrarItens extends AppCompatActivity {
    Banco banco;
    SQLiteDatabase base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_itens);
        banco = new Banco(this);
        base = banco.conecao();
    }

    public void cadastrarItem(View view) {
        Intent intent = getIntent();
        int idLista = Integer.parseInt(intent.getStringExtra("valor"));
        startActivity(intent);
        Log.i(" Resultado do idlista :",""+idLista);
        EditText produto = (EditText)findViewById(R.id.produto);
        EditText qtd = (EditText)findViewById(R.id.qtd);
        base.execSQL("insert into itensLista(produto,qtd,codLista)values('"+produto.getText().toString()+"',"+Integer.parseInt(qtd.getText().toString())+"," +
                idLista+")");

    }
}
