package com.massivcode.weatherinfoexam;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.massivcode.weatherinfoexam.fragment.CurrentWeatherInfoFragment;
import com.massivcode.weatherinfoexam.fragment.ForecastFragment;
import com.massivcode.weatherinfoexam.fragment.SearchFragment;
import com.massivcode.weatherinfoexam.models.Forecast;
import com.massivcode.weatherinfoexam.models.ForecastEachInfo;
import com.massivcode.weatherinfoexam.models.WeatherInfo;
import com.massivcode.weatherinfoexam.utils.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchFragment.SearchWordTransferListener {

    private SearchFragment mSearchFragment;
    private CurrentWeatherInfoFragment mCurrentFragment;
    private ForecastFragment mForecastFragment;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private PagerAdapter mAdapter;

    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mSearchFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.search_fragment);
        mSearchFragment.setOnSearchResultTransferListener(this);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);

        mFragmentList = new ArrayList<>();
        mCurrentFragment = new CurrentWeatherInfoFragment();
        mForecastFragment = new ForecastFragment();
        mFragmentList.add(mCurrentFragment);
        mFragmentList.add(mForecastFragment);

        mAdapter = new PagerAdapter(getSupportFragmentManager(), mFragmentList);

        mViewPager.setAdapter(mAdapter);

        mTabLayout.addTab(mTabLayout.newTab().setText("현재 날씨"));
        mTabLayout.addTab(mTabLayout.newTab().setText("날씨 예보"));

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));


    }

    /**
     * SearchFragment 로부터 받은 검색어로 URL 문자열을 생성하고,
     * 해당 문자열로부터 JSON 데이터를 받아 파싱한 뒤,
     * 각자의 프래그먼트에 전달
     * @param searchWord
     */
    @Override
    public void receivedSearchWord(String searchWord) {
        final String urlCurrentWeather = "http://api.openweathermap.org/data/2.5/weather?&q="+ searchWord +"&mode=json&units=metric&appid=2de143494c0b295cca9337e1e96b00e0";
        final String urlForecast = "http://api.openweathermap.org/data/2.5/forecast?&q="+ searchWord +"&mode=json&units=metric&appid=2de143494c0b295cca9337e1e96b00e0";

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WeatherInfo weatherInfo = NetworkUtil.parseJsonToCurrentWeatherInfo(NetworkUtil.getDataFromUrl(urlCurrentWeather));
                    Forecast forecast = NetworkUtil.parseJsonToForecastInfo(NetworkUtil.getDataFromUrl(urlForecast));
                    ArrayList<Forecast.WeatherList> weatherList = forecast.list;
                    ArrayList<String> groupData = new ArrayList<String>();

                    List<List<ForecastEachInfo>> childData = new ArrayList<>();

                    for(int i = 0; i < weatherList.size(); i++) {
                        ArrayList<ForecastEachInfo> childContent = new ArrayList<ForecastEachInfo>();
                        Forecast.WeatherList each = weatherList.get(i);
                        groupData.add(each.dt_txt);

                        Forecast.Weather eachWeather = each.weather.get(0);


                        ForecastEachInfo eachInfo = new ForecastEachInfo();
                        eachInfo.setDescription(eachWeather.description);
                        eachInfo.setHumidity(each.main.humidity);
                        eachInfo.setPressure(each.main.pressure);
                        eachInfo.setTemp(each.main.temp);
                        eachInfo.setWindDeg(each.wind.deg);
                        eachInfo.setWindSpeed(each.wind.speed);

                        childContent.add(eachInfo);
                        childData.add(childContent);
                    }



                    mCurrentFragment.setData(weatherInfo);
                    mForecastFragment.setData(groupData, childData);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class PagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mList;

        public PagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }
}
