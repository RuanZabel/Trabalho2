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

public class CadastrarLista extends AppCompatActivity {
    Banco banco;
    SQLiteDatabase base;
    int valor = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        banco = new Banco(this);
        base = banco.conecao();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_lista);
    }

    public void cadastrarItem(View view) {
        EditText am = (EditText) findViewById(R.id.ano_mes);
        EditText desc = (EditText) findViewById(R.id.descricao);
        base.execSQL("insert into listaCompra(amlista,DESCRICAO)values('"+am.getText().toString()+"','"+desc.getText().toString()+"')");
        Cursor curso = base.rawQuery("select * from listaCompra where amlista = '"+am.getText().toString()+"'" +
                "and descricao = '"+desc.getText().toString()+"' ",null);
        curso.moveToFirst();
        do
        {
            valor = curso.getInt( curso.getColumnIndex("codLista"));
            Log.i(" Resultado Sql :",""+valor);
        }
        while
        (curso.moveToNext());
        Button botao = (Button) findViewById(R.id.cadastrarItem);
        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CadastrarLista.this, CadastrarItens.class);
                intent.putExtra("valor",String.valueOf(valor));
                startActivity(intent);
            }

        });
    }
}
