package com.massivcode.weatherinfoexam.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.massivcode.weatherinfoexam.R;
import com.massivcode.weatherinfoexam.models.ForecastEachInfo;

import java.util.List;

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

    }

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
}
