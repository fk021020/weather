package com.fk.weather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.fk.weather.db.bean.MyCity;
import com.fk.weather.repository.CityRepository;
import com.fk.library.base.BaseViewModel;

import java.util.List;

/**
 * 管理城市ViewModel
 * {@link com.fk.weather.ui.ManageCityActivity}
 */
public class ManageCityViewModel extends BaseViewModel {

    public MutableLiveData<List<MyCity>> listMutableLiveData = new MutableLiveData<>();

    /**
     * 获取所有城市数据
     */
    public void getAllCityData() {
        CityRepository.getInstance().getMyCityData(listMutableLiveData);
    }

    /**
     * 添加我的城市数据，在定位之后添加数据
     */
    public void addMyCityData(String cityName) {
        CityRepository.getInstance().addMyCityData(new MyCity(cityName));
    }
}
