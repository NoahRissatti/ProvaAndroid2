package com.example.provaandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InserirDadosActivity extends AppCompatActivity {

    private EditText editText;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserir_dados);

        editText = findViewById(R.id.editText);

        BancoDeDados dbHelper = new BancoDeDados(this);
        database = dbHelper.getWritableDatabase();
    }

    public void inserirTexto(View view) {
        String textoInserido = editText.getText().toString();

        ContentValues values = new ContentValues();
        values.put(BancoDeDados.COLUNA_TEXTO, textoInserido);

        try {
            database.insertOrThrow(BancoDeDados.TABELA_TEXTO, null, values);
            System.out.println("Inserido no banco de dados com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro");
        }
    }
}