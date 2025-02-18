package com.fk.weather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.fk.weather.bean.DailyResponse;
import com.fk.weather.bean.NowResponse;
import com.fk.weather.bean.SearchCityResponse;
import com.fk.weather.bean.LifestyleResponse;
import com.fk.weather.repository.SearchCityRepository;
import com.fk.library.base.BaseViewModel;
import com.fk.weather.repository.WeatherRepository;

/**
 * 主页面ViewModel
 * {@link com.fk.weather.MainActivity}
 */
public class MainViewModel extends BaseViewModel {

    public MutableLiveData<SearchCityResponse> searchCityResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<NowResponse> nowResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<DailyResponse> dailyResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<LifestyleResponse> lifestyleResponseMutableLiveData = new MutableLiveData<>();

    /**
     * 搜索城市
     *
     * @param cityName 城市名称
     */
    public void searchCity(String cityName) {
        new SearchCityRepository().searchCity(searchCityResponseMutableLiveData, failed, cityName);
    }

    /**
     * 实况天气
     *
     * @param cityId 城市ID
     */
    public void nowWeather(String cityId) {
        WeatherRepository.getInstance().nowWeather(nowResponseMutableLiveData, failed, cityId);
    }

    /**
     * 天气预报
     *
     * @param cityId 城市ID
     */
    public void dailyWeather(String cityId) {
        WeatherRepository.getInstance().dailyWeather(dailyResponseMutableLiveData, failed, cityId);
    }

    /**
     * 生活指数
     *
     * @param cityId 城市ID
     */
    public void lifestyle(String cityId) {
        WeatherRepository.getInstance().lifestyle(lifestyleResponseMutableLiveData, failed, cityId);
    }
}
