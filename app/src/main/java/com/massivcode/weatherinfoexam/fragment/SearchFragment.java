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
