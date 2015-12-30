# 입력한 도시의 현재 날씨와 5일치 예보 정보를 출력하는 예제 앱
okhttp와 jackson 라이브러리를 이용하는 예제입니다.
![네비게이션](https://raw.githubusercontent.com/suwonsmartapp/WeatherInfoExam/master/doc/Screenshot_20151230-172450.png)
![네비게이션](https://raw.githubusercontent.com/suwonsmartapp/WeatherInfoExam/master/doc/Screenshot_20151230-172501.png)

# 1. 레이아웃
## activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:orientation="vertical"
    tools:context="com.massivcode.weatherinfoexam.MainActivity">

    <android.support.design.widget.TabLayout
        android:id="@+id/tab_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <android.support.v4.view.ViewPager
        android:layout_weight="1"
        android:id="@+id/viewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

    <fragment
        android:id="@+id/search_fragment"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:name="com.massivcode.weatherinfoexam.fragment.SearchFragment"
        tools:layout="@layout/fragment_search" />

</LinearLayout>

```
## fragment_current_weather.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="온도"
            android:textColor="#000000" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="날씨"
            android:textColor="#000000" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="5dp"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/temp_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="온도 데이터 표시" />

        <TextView
            android:id="@+id/description_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="날씨 데이터 표시" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:orientation="horizontal">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="일출"
            android:textColor="#000000" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="일몰"
            android:textColor="#000000" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="5dp"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/sunrise_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="일출 데이터 표시" />

        <TextView
            android:id="@+id/sunset_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="일몰 데이터 표시" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:orientation="horizontal">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="풍속"
            android:textColor="#000000" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="풍향"
            android:textColor="#000000" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="5dp"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/windspeed_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="풍속 데이터 표시" />

        <TextView
            android:id="@+id/winddeg_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="풍향 데이터 표시" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:orientation="horizontal">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="기압"
            android:textColor="#000000" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="습도"
            android:textColor="#000000" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="가시거리"
            android:textColor="#000000" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="5dp"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/pressure_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="기압 데이터 표시" />

        <TextView
            android:id="@+id/humidity_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="습도 데이터 표시" />

        <TextView
            android:id="@+id/visibility_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="가시거리 표시" />
    </LinearLayout>


</LinearLayout>
```
## fragment_forecast.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    android:orientation="vertical">

    <ExpandableListView
        android:id="@+id/expand_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</LinearLayout>
```
## fragment_search.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">

    <EditText
        android:id="@+id/search_et"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:hint="도시 이름을 입력하세요" />

    <Button
        android:id="@+id/connect_btn"
        android:text="접속"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

</LinearLayout>
```
## item_group.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    android:orientation="vertical">

    <TextView
        android:layout_marginLeft="16dp"
        android:id="@+id/group_tv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```
## item_child.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="날씨"
            android:textColor="#000000" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="기온"
            android:textColor="#000000" />

    </LinearLayout>

    <LinearLayout
        android:layout_marginTop="5dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:id="@+id/child_weather_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="날씨 데이터" />

        <TextView
            android:id="@+id/child_temp_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="기온 데이터" />

    </LinearLayout>

    <LinearLayout
        android:layout_marginTop="16dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="풍속"
            android:textColor="#000000" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="풍향"
            android:textColor="#000000" />

    </LinearLayout>

    <LinearLayout
        android:layout_marginTop="5dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:id="@+id/child_windspeed_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="풍속 데이터" />

        <TextView
            android:id="@+id/child_winddeg_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="풍향 데이터" />

    </LinearLayout>

    <LinearLayout
        android:layout_marginTop="16dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="기압"
            android:textColor="#000000" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="습도"
            android:textColor="#000000" />

    </LinearLayout>

    <LinearLayout
        android:layout_marginTop="5dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:id="@+id/child_pressure_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="기압 데이터" />

        <TextView
            android:id="@+id/child_humidity_tv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:text="습도 데이터" />

    </LinearLayout>


</LinearLayout>
```

# 2. 모델
## WeatherInfo : 현재 날씨 정보를 파싱하기 위한 모델
```java
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
@JsonIgnoreProperties({"base", "clouds", "dt", "id", "cod"}) // 입력된 JSON 에서 무시할 프로퍼티 설정
public class WeatherInfo {

    public String visibility;
    public String name;
    public Coord coord;
    public Wind wind;
    public Sys sys;
    public ArrayList<Weather> weather;
    public Main main;

    @JsonCreator // 생성자에 추가
    public WeatherInfo(@JsonProperty("visibility") String visibility,
                       @JsonProperty("name") String name,
                       @JsonProperty("coord") Coord coord,
                       @JsonProperty("wind") Wind wind,
                       @JsonProperty("sys") Sys sys,
                       @JsonProperty("weather") ArrayList<Weather> weather,
                       @JsonProperty("main") Main main) {
        this.visibility = visibility;
        this.name = name;
        this.coord = coord;
        this.wind = wind;
        this.sys = sys;
        this.weather = weather;
        this.main = main;
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

    @JsonIgnoreProperties({"type", "id", "message"})
    public static class Sys {
        public String country;
        public String sunrise;
        public String sunset;

        @JsonCreator
        public Sys(@JsonProperty("country") String country,
                   @JsonProperty("sunrise") String sunrise,
                   @JsonProperty("sunset") String sunset) {
            this.country = country;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }

        @Override
        public String toString() {
            return "Sys{" +
                    "country='" + country + '\'' +
                    ", sunrise='" + sunrise + '\'' +
                    ", sunset='" + sunset + '\'' +
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

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "visibility='" + visibility + '\'' +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", wind=" + wind +
                ", sys=" + sys +
                ", weather=" + weather +
                ", main=" + main +
                '}';
    }

}

```
## Forecast : 날씨 예보 정보를 파싱하기 위한 모델
```java
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

```
## ForecastEachInfo : 예보 정보를 표시하는 어댑터를 위한 모델
```java
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
```

# 3. 프래그먼트
## SearchFragment
```java
package com.massivcode.weatherinfoexam.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.massivcode.weatherinfoexam.R;

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
public class SearchFragment extends Fragment implements View.OnClickListener {

    private Button mConnectButton;
    private EditText mSearchEditText;
    private SearchWordTransferListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        mSearchEditText = (EditText) view.findViewById(R.id.search_et);
        mConnectButton = (Button) view.findViewById(R.id.connect_btn);
        mConnectButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String keyWord = mSearchEditText.getText().toString();

        if(TextUtils.isEmpty(keyWord)) {
            Toast.makeText(getActivity(), "도시 이름을 입력해주세요!", Toast.LENGTH_SHORT).show();
        } else {
            if(mListener != null) {
                mListener.receivedSearchWord(keyWord);
            }
        }

    }

    public interface SearchWordTransferListener {
        void receivedSearchWord(String searchWord);
    }

    public void setOnSearchResultTransferListener(SearchWordTransferListener listener) {
        mListener = listener;
    }
}

```
## ForecastFragment
```java
public class ForecastFragment extends Fragment {

    private static final String TAG = ForecastFragment.class.getSimpleName();
    private List<String> mGroupData;
    private List<List<ForecastEachInfo>> mChildData;
    private ExpandableListView mListView;
    private ExpAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);

        mListView = (ExpandableListView) view.findViewById(R.id.expand_list);

        return view;
    }

    public void setData(List<String> groupList, List<List<ForecastEachInfo>> childList) {
        mGroupData = groupList;
        mChildData = childList;

        Log.d(TAG, "차일드리스트 : " + childList);

        if(mAdapter == null) {
            mAdapter = new ExpAdapter(mGroupData, mChildData, getActivity());
        } else {
            mAdapter.notifyDataSetChanged();
        }

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                mListView.setAdapter(mAdapter);
            }
        });

        Log.d(TAG, "현재 스레드 정보 : " + Thread.currentThread().getName());
    }
}
```
## CurrentWeatherInfoFragment
```java
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

    private WeatherInfo mData;
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
        mData = weatherInfo;
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

```

# 4. 어댑터
## ExpandableListView 를 위한 어댑터
```java
class ExpAdapter extends BaseExpandableListAdapter {

        private List<String> mGroupData;
        private List<List<ForecastEachInfo>> mChildData;
        private LayoutInflater mInflater;

        public ExpAdapter(List<String> mGroupData, List<List<ForecastEachInfo>> mChildData, Context context) {
            this.mGroupData = mGroupData;
            this.mChildData = mChildData;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getGroupCount() {
            return mGroupData.size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return mGroupData.get(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_group, parent, false);
                viewHolder.groupTv = (TextView) convertView.findViewById(R.id.group_tv);
                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            String groupString = (String) getGroup(groupPosition);
            viewHolder.groupTv.setText(groupString);

            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return mChildData.get(groupPosition).size();

        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return mChildData.get(groupPosition).get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_child, parent, false);
                viewHolder.childHumidityTv = (TextView) convertView.findViewById(R.id.child_humidity_tv);
                viewHolder.childPressureTv = (TextView) convertView.findViewById(R.id.child_pressure_tv);
                viewHolder.childTempTv = (TextView) convertView.findViewById(R.id.child_temp_tv);
                viewHolder.childWeatherTv = (TextView) convertView.findViewById(R.id.child_weather_tv);
                viewHolder.childWindDegTv = (TextView) convertView.findViewById(R.id.child_winddeg_tv);
                viewHolder.childWindSpeedTv = (TextView) convertView.findViewById(R.id.child_windspeed_tv);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            ForecastEachInfo eachInfo = (ForecastEachInfo) getChild(groupPosition, childPosition);

            viewHolder.childPressureTv.setText(eachInfo.getPressure());
            viewHolder.childTempTv.setText(eachInfo.getTemp());
            viewHolder.childWindSpeedTv.setText(eachInfo.getWindSpeed());
            viewHolder.childWindDegTv.setText(eachInfo.getWindDeg());
            viewHolder.childHumidityTv.setText(eachInfo.getHumidity());
            viewHolder.childWeatherTv.setText(eachInfo.getDescription());


            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        class ViewHolder {
            TextView groupTv;
            TextView childWeatherTv;
            TextView childTempTv;
            TextView childWindSpeedTv;
            TextView childWindDegTv;
            TextView childPressureTv;
            TextView childHumidityTv;
        }
    }
```

## ViewPager 를 위한 어댑터
```java
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
```

# 5. 유틸 클래스
## URL 으로부터 문자열을 읽고, JSON 을 파싱하는 클래스
```java
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

```

# 6. 메인 액티비티
```java
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

    private static final String TAG = MainActivity.class.getSimpleName();
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
}

```
