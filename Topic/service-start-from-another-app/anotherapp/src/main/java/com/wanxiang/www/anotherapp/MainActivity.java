package com.wanxiang.www.anotherapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import com.wanxiang.www.startservicefromanotherapp.IAppServiceRemoteBinderInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

	private Intent serviceIntent;

	private EditText etInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etInput = (EditText) findViewById(R.id.etInput);

		serviceIntent = new Intent();
		serviceIntent.setComponent(new ComponentName("com.wanxiang.www.startservicefromanotherapp", "com.wanxiang.www.startservicefromanotherapp.AppService"));
		serviceIntent.putExtra("data", "Hello AppService");

		findViewById(R.id.btnStartAppService).setOnClickListener(this);
		findViewById(R.id.btnStopAppService).setOnClickListener(this);
		findViewById(R.id.btnBindAppService).setOnClickListener(this);
		findViewById(R.id.btnUnbindAppService).setOnClickListener(this);
		findViewById(R.id.btnSync).setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.btnStartAppService:
				//explicit Intent
				startService(serviceIntent);
				break;
			case R.id.btnStopAppService:
				stopService(serviceIntent);
				break;
			case R.id.btnBindAppService:
				//explicit Intent
				bindService(serviceIntent, this, BIND_AUTO_CREATE);
				break;
			case R.id.btnUnbindAppService:
				unbindService(this);
				binder = null;
				break;
			case R.id.btnSync:
				if (binder != null)
					try {
						binder.setData(etInput.getText().toString());
					} catch (RemoteException e) {
						e.printStackTrace();
					}

				break;
			default:
				break;
		}
	}

	@Override
	public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
		//stdout mean connect successful
		System.out.println("Bind service");
		System.out.println(iBinder);
		binder = IAppServiceRemoteBinderInterface.Stub.asInterface(iBinder);
	}

	@Override
	public void onServiceDisconnected(ComponentName componentName) {

	}

	private IAppServiceRemoteBinderInterface binder = null;
}
