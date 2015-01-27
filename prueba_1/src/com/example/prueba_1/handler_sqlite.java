package com.example.prueba_1;

import static android.provider.BaseColumns._ID;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class handler_sqlite extends SQLiteOpenHelper {

	public handler_sqlite (Context ctx ){
		super(ctx,"usuarios",null,1);
		
	}
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		
		String query = "CREATE TABLE usuarios("+_ID+"INTEGER PRYMARY KEY AUTOINCREMENT,"+
		"user TEXT, password TEXT)";
		db.execSQL(query);
		
	}
	public String leer()
	{
		
		String result="";
		String columnas[]= {_ID,"user,password"};
		Cursor c = this.getReadableDatabase().query("usuarios",columnas,null,null,null,null,null);
		c.moveToLast();
		int id,ui,ip;
		id = c.getColumnIndex(_ID);
		ui = c.getColumnIndex("user");
		ip = c.getColumnIndex("password");
		
		result = c.getString(id)+" "+c.getShort(ui)+" "+c.getShort(ip)+"\n"; 
		return result;
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int version_ant, int version_nue)
	{
		db.execSQL("DROP TABLE IF EXISTS usuarios");
		onCreate(db);
		
	}
	public void insertarReg(String usr, String pass )
	{
		ContentValues valores = new ContentValues();
		valores.put("user", usr);
		valores.put("password", pass);
		
		this.getWritableDatabase().insert("usuarios",null,valores);
		
		
	}
	public void abrir()
	{
		
		this.getWritableDatabase();
	}
	public void cerrar()
	{
		
		this.close();
	}
	
}
