package com.wision.www.coolweather.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.*;
import com.wision.www.coolweather.R;
import com.wision.www.coolweather.db.CoolWeatherDB;
import com.wision.www.coolweather.model.City;
import com.wision.www.coolweather.model.County;
import com.wision.www.coolweather.model.Province;
import com.wision.www.coolweather.util.HttpCallbackListener;
import com.wision.www.coolweather.util.HttpUtil;
import com.wision.www.coolweather.util.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JM on 2016/10/18.
 */

public class ChooseAreaActivity extends Activity {
	public static final int LEVEL_PROVINCE = 0;
	public static final int LEVEL_CITY = 1;
	public static final int LEVEL_COUNTY = 2;

	private ProgressDialog progressDialog;
	private TextView titleText;
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private CoolWeatherDB coolWeatherDB;
	private List<String> dataList = new ArrayList<String>();

	private List<Province> provinceList;
	private List<City> cityList;
	private List<County> countyList;
	private Province selectedProvince;
	private City selectedCity;
	private int currentLevel;

	/**
	 * 是否从WeatherActivity中跳转过来
	 */
	private boolean isFromWeatherActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		isFromWeatherActivity = getIntent().getBooleanExtra("from_weather_activity", false);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		//已经选择了城市并不是从WeatherActivity跳转过来，才会直接跳转到WeatherActivity
		if (prefs.getBoolean("city_selected", false) && !isFromWeatherActivity) {
			Intent intent = new Intent(this, WeatherActivity.class);
			startActivity(intent);
			finish();
			return;
		}

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.choose_area);
		listView = (ListView) findViewById(R.id.list_view);
		titleText = (TextView) findViewById(R.id.title_text);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
		listView.setAdapter(adapter);
		coolWeatherDB = CoolWeatherDB.getInstance(this);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			/**
			 * Callback method to be invoked when an item in this AdapterView has
			 * been clicked.
			 * <p>
			 * Implementers can call getItemAtPosition(position) if they need
			 * to access the data associated with the selected item.
			 *
			 * @param parent   The AdapterView where the click happened.
			 * @param view     The view within the AdapterView that was clicked (this
			 *                 will be a view provided by the adapter)
			 * @param position The position of the view in the adapter.
			 * @param id       The row id of the item that was clicked.
			 */
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (currentLevel == LEVEL_PROVINCE) {
					selectedProvince = provinceList.get(position);
					queryCities();
				} else if (currentLevel == LEVEL_CITY) {
					selectedCity = cityList.get(position);
					queryCounties();
				} else if (currentLevel == LEVEL_COUNTY){
					String countyCode = countyList.get(position).getCountyCode();
					Intent intent = new Intent(ChooseAreaActivity.this, WeatherActivity.class);
					intent.putExtra("county_code", countyCode);;
					startActivity(intent);
					finish();
				}
			}
		});
		queryProvinces();
	}

	private void queryCities() {
		cityList = coolWeatherDB.loadCities(selectedProvince.getId());
		if(cityList.size() > 0){
			dataList.clear();
			for (City city : cityList){
				dataList.add(city.getCityName());
			}
			adapter.notifyDataSetChanged();
			listView.setSelection(0);
			titleText.setText(selectedProvince.getProvinceName());
			currentLevel = LEVEL_CITY;
		} else {
			queryFromServer(selectedProvince.getProvinceCode(), LEVEL_CITY);
		}
	}

	private void queryProvinces() {
		provinceList = coolWeatherDB.loadProvinces();
		if (provinceList.size() > 0){
			dataList.clear();
			for (Province province : provinceList){
				dataList.add(province.getProvinceName());
			}
			adapter.notifyDataSetChanged();
			listView.setSelection(0);
			titleText.setText("中国");
			currentLevel = LEVEL_PROVINCE;
		} else {
			queryFromServer(null, LEVEL_PROVINCE);
		}
	}
	private void queryCounties() {
		countyList = coolWeatherDB.loadCounties(selectedCity.getId());
		if (countyList.size() > 0){
			dataList.clear();
			for (County county : countyList){
				dataList.add(county.getCountyName());
			}
			adapter.notifyDataSetChanged();
			listView.setSelection(0);
			titleText.setText(selectedCity.getCityName());
			currentLevel = LEVEL_COUNTY;
		} else {
			queryFromServer(selectedCity.getCityCode(), LEVEL_COUNTY);
		}
	}

	private void queryFromServer(final String code, final int type){
		String address = "";
//		if (!TextUtils.isEmpty(code)){
//			address = "http://www.weather.com.cn/data/list3/city" + code + ".xml";
//		} else {
//			address = "http://www.weather.com.cn/data/list3/city.xml";
//		}
		switch (type){
			case LEVEL_PROVINCE:
				address = "http://www.weather.com.cn/data/city3jdata/china.html";
				break;
			case LEVEL_CITY:
				address = "http://www.weather.com.cn/data/city3jdata/provshi/" + code + ".html";
				break;
			case LEVEL_COUNTY:
				address = "http://www.weather.com.cn/data/city3jdata/station/" + code + ".html";
				break;
		}
		showProgressDialog();
		HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
			@Override
			public void onFinish(String response) {
				boolean result = false;
				switch (type){
					case LEVEL_PROVINCE:
						result = Utility.handleProvincesResponse(coolWeatherDB, response);
						break;
					case LEVEL_CITY:
						result = Utility.handleCityiesResponse(coolWeatherDB, response, selectedProvince);
						break;
					case LEVEL_COUNTY:
						result = Utility.handleCountiesesponse(coolWeatherDB, response, selectedCity);
				}

				if (result){
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							closeProgressDialog();
							switch (type) {
								case LEVEL_PROVINCE:
									queryProvinces();
									break;
								case LEVEL_CITY:
									queryCities();
									break;
								case LEVEL_COUNTY:
									queryCounties();
									break;
							}

						}
					});
				}

			}

			@Override
			public void onError(Exception e) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						closeProgressDialog();
						Toast.makeText(ChooseAreaActivity.this, "加载失败", Toast.LENGTH_SHORT).show();

					}
				});
			}
		});
	}

	private void showProgressDialog(){
		if (progressDialog == null){
			progressDialog = new ProgressDialog(this);
			progressDialog.setMessage("正在加载....");
			progressDialog.setCanceledOnTouchOutside(false);
		}
		progressDialog.show();
	}

	private void closeProgressDialog(){
		if (progressDialog != null){
			progressDialog.dismiss();
		}
	}

	public void onBackPressed(){
		if (currentLevel == LEVEL_COUNTY){
			queryCities();
		} else if (currentLevel == LEVEL_CITY){
			queryProvinces();
		} else {
			if (isFromWeatherActivity) {
				Intent intent = new Intent(this, WeatherActivity.class);
				startActivity(intent);
			}
			finish();
		}
	}
}
