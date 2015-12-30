package com.massivcode.weatherinfoexam.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.massivcode.weatherinfoexam.models.Forecast;
import com.massivcode.weatherinfoexam.models.WeatherInfo;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

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
public class NetworkUtil {

    public static final String URL_CURRENT = "http://api.openweathermap.org/data/2.5/weather?q=seoul&mode=json&units=metric&appid=2de143494c0b295cca9337e1e96b00e0";
    public static final String URL_FORECAST = "http://api.openweathermap.org/data/2.5/forecast?q=seoul&mode=json&units=metric&appid=2de143494c0b295cca9337e1e96b00e0";

    /**
     * URL 으로부터 데이터를 가져오는 메소드
     * @param urlString
     * @return
     * @throws IOException
     */
    public static String getDataFromUrl(String urlString) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(urlString)
                .build();


        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static WeatherInfo parseJsonToCurrentWeatherInfo(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherInfo weatherInfo = objectMapper.readValue(jsonString, WeatherInfo.class);
        return weatherInfo;
    }

    public static Forecast parseJsonToForecastInfo(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Forecast forecast = objectMapper.readValue(jsonString, Forecast.class);
        return forecast;
    }

}
