package ifsc.edu.trabalho2;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Banco {
    public SQLiteDatabase banco;

    public Banco(Activity ma) {
        banco = ma.openOrCreateDatabase("banco",ma.getBaseContext().MODE_PRIVATE,null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS listaCompra" +
                "(codLista INTEGER PRIMARY KEY AUTOINCREMENT," +
                "amlista TEXT not null," +
                "DESCRICAO TEXT NOT NULL)");

        banco.execSQL("CREATE TABLE IF NOT EXISTS itensLista" +
                "(codItensLista INTEGER PRIMARY KEY AUTOINCREMENT," +
                "produto TEXT not null," +
                "qtd INTEGER," +
                "codLista INTEGER not null," +
                "inComprado INTEGER)");
    }


    public SQLiteDatabase conecao(){
        return banco;
    }
}
