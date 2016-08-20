package com.example.regina.medshare;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProdutoSQL {
	
	SummonDB db;
	int id, transacao;
	double preco;
	String nome, marca, descricao, fotoPath, fornecedor;
	boolean disponivel, novo;
	String[] atributosProduto = {"produto_id", "produto_nome", "marca", "tipo", "descricao", "foto", "fornecedor", "transacao", "disponivel", "novo"};
	String table = "produto";
	
	ProdutoSQL(SummonDB db) {
		this.db = db;
	}
	
	public void carregaProduto(int id) {
		String query = "SELECT * FROM "+table+" WHERE ? = "+id;
		String[] args = {"produto_id"};
 		SQLiteDatabase banco = db.getReadableDatabase();
		Cursor c = banco.rawQuery(query, args);
		c.moveToFirst();
		nome = c.getString(0);
		System.out.println(nome);
		
	}
	
	public void carregaProduto(String nome) {
		
	}
	
	
	
}
