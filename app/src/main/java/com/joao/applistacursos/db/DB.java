package com.joao.applistacursos.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DB extends SQLiteOpenHelper implements BaseColumns {
    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "dadosUsuario";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String SOBRENOME = "sobrenome";
    public static final String TELEFONE = "telefone";
    public static final String CURSO = "curso";
    public static final int VERSAO = 1;

    public DB(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String criarDB = "CREATE TABLE " + DB.TABELA + " ( " +
                DB.ID + " INTEGER PRIMARY KEY, " +
                DB.NOME + " text, " +
                DB.SOBRENOME + " text, " +
                DB.TELEFONE + " text, " +
                DB.CURSO + " text)";
        sqLiteDatabase.execSQL(criarDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(sqLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
