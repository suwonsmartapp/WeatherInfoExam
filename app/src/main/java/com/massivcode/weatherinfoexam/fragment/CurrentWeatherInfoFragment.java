package com.massivcode.weatherinfoexam.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.massivcode.weatherinfoexam.R;
import com.massivcode.weatherinfoexam.models.WeatherInfo;

/**
 * Copyright 2015 Pureum Choe
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * <p/>
 * Created by Ray Choe on 2015-12-30.
 */
public class CurrentWeatherInfoFragment extends Fragment {

    private TextView mSunrise, mSunset, mWindSpeed, mWindDeg, mWeather, mTemp, mPressure, mHumidity, mVisibility;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        mSunrise = (TextView) view.findViewById(R.id.sunrise_tv);
        mSunset = (TextView) view.findViewById(R.id.sunset_tv);
        mWindSpeed = (TextView) view.findViewById(R.id.windspeed_tv);
        mWindDeg = (TextView) view.findViewById(R.id.winddeg_tv);
        mWeather = (TextView) view.findViewById(R.id.description_tv);
        mTemp = (TextView) view.findViewById(R.id.temp_tv);
        mPressure = (TextView) view.findViewById(R.id.pressure_tv);
        mHumidity = (TextView) view.findViewById(R.id.humidity_tv);
        mVisibility = (TextView) view.findViewById(R.id.visibility_tv);
    }

    public void setData(final WeatherInfo weatherInfo) {
        final WeatherInfo.Weather weather = weatherInfo.weather.get(0);


        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                mSunrise.setText(weatherInfo.sys.sunrise);
                mSunset.setText(weatherInfo.sys.sunset);
                mWindSpeed.setText(weatherInfo.wind.speed);
                mWindDeg.setText(weatherInfo.wind.deg);
                mWeather.setText(weather.description);
                mTemp.setText(weatherInfo.main.temp);
                mPressure.setText(weatherInfo.main.pressure);
                mHumidity.setText(weatherInfo.main.humidity);
                mVisibility.setText(weatherInfo.visibility);
            }
        });




    }


}
