package com.seanpont.grandRounds;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.google.common.collect.Lists;
import com.seanpont.grandRounds.api.Case;
import com.seanpont.grandRounds.utils.SimpleTextWatcher;

import java.util.List;

public class PreparePresentationActivity extends BaseActivity {

    private CaseAdapter  _adapter;
    private List<Case>   _cases;

    @Override protected void onCreate(Bundle savedInstanceState) {
        hideActionBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prepare);

        final ListView cases = findListViewById(R.id.prepare_cases);
        _adapter = new CaseAdapter();
        cases.setAdapter(_adapter);

        _cases = Lists.newArrayList();

        findButtonById(R.id.prepare_add_case).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                _cases.add(new Case());
                _adapter.notifyDataSetChanged();
            }
        });
    }

    private class CaseAdapter extends BaseAdapter {

        @Override public int getCount() { return _cases.size(); }
        @Override public Case getItem(int position) { return _cases.get(position); }
        @Override public long getItemId(int position) { return 0; }

        @Override public View getView(int position, View view, ViewGroup parent) {
            view = view == null ? getLayoutInflater().inflate(R.layout.item_prepare_case, parent, false) : view;
            final Case aCase = getItem(position);
            final EditText desc = (EditText) view.findViewById(R.id.prepare_case_desc);
            desc.setText(aCase.getDescription());
            desc.addTextChangedListener(new SimpleTextWatcher() {
                @Override protected void onChange(String s) {
                    aCase.setDescription(s);
                }
            });
            final EditText diagnosis = (EditText) view.findViewById(R.id.prepare_case_diagnosis);
            diagnosis.setText(aCase.getDiagnosis());
            diagnosis.addTextChangedListener(new SimpleTextWatcher() {
                @Override protected void onChange(String s) {
                    aCase.setDiagnosis(s);
                }
            });
            return view;
        }
    }
}
