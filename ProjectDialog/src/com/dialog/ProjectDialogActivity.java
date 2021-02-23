package com.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ProjectDialogActivity extends Activity implements OnClickListener {
    Button btn_Send, btn_Share, btn_Exit;
    String[] items = {"Facebook","Twitter","Instagram"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn_Send = (Button) findViewById(R.id.btnSend);
        btn_Share = (Button) findViewById(R.id.btnShare);
        btn_Exit = (Button) findViewById(R.id.btnExit);
        
        btn_Send.setOnClickListener(this);
        btn_Share.setOnClickListener(this);
        btn_Exit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
    	
    	switch (v.getId()){
    	case R.id.btnSend:
    	Toast.makeText(this, "SMS Terkirim...", Toast.LENGTH_LONG).show();
    	break;
    	case R.id.btnShare:
    		tampilListDialog();
    		break;
    	case R.id.btnExit:
    		exit();
    		break;
    	default:
    		break;
    	}
    }
    private void tampilListDialog(){
    	AlertDialog.Builder pesan = new AlertDialog.Builder(this);
    	pesan.setTitle("Share Picture Via");
    	pesan.setItems(items, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int item) {
				Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_LONG).show();
				
			}
		}).show();
    	
    }
    
    private void exit(){
    	AlertDialog.Builder pesan = new AlertDialog.Builder(this);
    	pesan.setMessage("Yakin nih mau keluar...?");
    	pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener(){
    		
    		public void onClick(DialogInterface dialog, int i) {
    			finish();
    		}
    	});
    	
    	pesan.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int i) {
				dialog.cancel();
				
			}
		}).show();
    }
}