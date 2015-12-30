package com.massivcode.weatherinfoexam.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

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
@JsonIgnoreProperties({"cod", "message", "cnt"})
public class Forecast {

    public City city;
    public ArrayList<WeatherList> list;

    @JsonCreator
    public Forecast(@JsonProperty("city") City city,
                    @JsonProperty("list") ArrayList<WeatherList> list) {
        this.city = city;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "city=" + city +
                ", list=" + list +
                '}';
    }

    @JsonIgnoreProperties({"id", "population", "sys", "cod", "message", "cnt"})
    public static class City {
        public String name;
        public Coord coord;
        public String country;

        @JsonCreator
        public City(@JsonProperty("name") String name,
                    @JsonProperty("coord") Coord coord,
                    @JsonProperty("country") String country) {
            this.name = name;
            this.coord = coord;
            this.country = country;
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", coord=" + coord +
                    ", country='" + country + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties({"dt", "clouds", "snow", "sys", "rain"})
    public static class WeatherList {
        public Main main;
        public ArrayList<Weather> weather;
        public Wind wind;
        public String dt_txt;

        @JsonCreator
        public WeatherList(@JsonProperty("id") Main main,
                           @JsonProperty("weather") ArrayList<Weather> weather,
                           @JsonProperty("wind") Wind wind,
                           @JsonProperty("dt_txt") String dt_txt) {
            this.main = main;
            this.weather = weather;
            this.wind = wind;
            this.dt_txt = dt_txt;
        }

        @Override
        public String toString() {
            return "WeatherList{" +
                    "main=" + main +
                    ", weather=" + weather +
                    ", wind=" + wind +
                    ", dt_txt='" + dt_txt + '\'' +
                    '}';
        }
    }

    public static class Weather {
        public String id;
        public String main;
        public String description;
        public String icon;

        @JsonCreator
        public Weather(@JsonProperty("id") String id,
                       @JsonProperty("main") String main,
                       @JsonProperty("description") String description,
                       @JsonProperty("icon") String icon) {
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }

        @Override
        public String toString() {
            return "Weather{" +
                    "id='" + id + '\'' +
                    ", main='" + main + '\'' +
                    ", description='" + description + '\'' +
                    ", icon='" + icon + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties({"sea_level", "grnd_level", "temp_kf"})
    public static class Main {
        public String temp;
        public String pressure;
        public String humidity;
        public String temp_min;
        public String temp_max;

        @JsonCreator
        public Main(@JsonProperty("temp") String temp,
                    @JsonProperty("pressure") String pressure,
                    @JsonProperty("humidity") String humidity,
                    @JsonProperty("temp_min") String temp_min,
                    @JsonProperty("temp_max") String temp_max) {
            this.temp = temp;
            this.pressure = pressure;
            this.humidity = humidity;
            this.temp_min = temp_min;
            this.temp_max = temp_max;
        }

        @Override
        public String toString() {
            return "Main{" +
                    "temp='" + temp + '\'' +
                    ", pressure='" + pressure + '\'' +
                    ", humidity='" + humidity + '\'' +
                    ", temp_min='" + temp_min + '\'' +
                    ", temp_max='" + temp_max + '\'' +
                    '}';
        }
    }

    public static class Coord {
        public String lon;
        public String lat;

        @JsonCreator
        public Coord(@JsonProperty("lon") String lon,
                     @JsonProperty("lat") String lat) {
            this.lon = lon;
            this.lat = lat;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "lon='" + lon + '\'' +
                    ", lat='" + lat + '\'' +
                    '}';
        }
    }

    public static class Wind {
        public String speed;
        public String deg;

        @JsonCreator
        public Wind(@JsonProperty("speed") String speed,
                    @JsonProperty("deg") String deg) {
            this.speed = speed;
            this.deg = deg;
        }

        @Override
        public String toString() {
            return "Wind{" +
                    "speed='" + speed + '\'' +
                    ", deg='" + deg + '\'' +
                    '}';
        }
    }
}
