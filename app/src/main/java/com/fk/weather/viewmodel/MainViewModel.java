package com.fk.weather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.fk.weather.bean.SearchCityResponse;
import com.fk.weather.repository.SearchCityRepository;
import com.fk.library.base.BaseViewModel;

/**
 * 主页面ViewModel
 * {@link com.example.goodweather.MainActivity}
 */
public class MainViewModel extends BaseViewModel {

    public MutableLiveData<SearchCityResponse> searchCityResponseMutableLiveData = new MutableLiveData<>();

    /**
     * 搜索成功
     * @param cityName 城市名称
     */
    public void searchCity(String cityName) {
        new SearchCityRepository().searchCity(searchCityResponseMutableLiveData, failed, cityName);
    }
}
