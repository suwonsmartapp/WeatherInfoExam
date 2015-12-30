package com.massivcode.weatherinfoexam.models;

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
public class ForecastEachInfo {
    private String temp;
    private String pressure;
    private String humidity;
    private String description;
    private String windSpeed;
    private String windDeg;

    public ForecastEachInfo() {
    }

    public ForecastEachInfo(String temp, String pressure, String humidity, String description, String windSpeed, String windDeg) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.description = description;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(String windDeg) {
        this.windDeg = windDeg;
    }

    @Override
    public String toString() {
        return "ForecastEachInfo{" +
                "temp='" + temp + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", description='" + description + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windDeg='" + windDeg + '\'' +
                '}';
    }
}
