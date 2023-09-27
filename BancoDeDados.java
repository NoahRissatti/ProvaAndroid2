package com.example.provaandroid;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "meu_banco.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABELA_TEXTO = "texto";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_TEXTO = "conteudo";

    private static final String DATABASE_CREATE = "create table "
            + TABELA_TEXTO + "(" + COLUNA_ID
            + " integer primary key autoincrement, " + COLUNA_TEXTO
            + " text not null);";

    public BancoDeDados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_TEXTO);
        onCreate(db);
    }
}
