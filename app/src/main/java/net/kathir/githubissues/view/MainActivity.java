package net.kathir.githubissues.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import net.kathir.githubissues.R;
import net.kathir.githubissues.model.IssueModel;
import net.kathir.githubissues.viewModel.MainViewModel;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView mRecyclerView;
    MainViewModel mainViewModel;
    IssueAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initalizeViews();

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getIssuesList();
    }

    private void getIssuesList()
    {
        mainViewModel.getAllIssues().observe(this, new Observer<List<IssueModel>>() {
            @Override
            public void onChanged(List<IssueModel> issueModels) {

                setRecyclerView(issueModels);
            }
        });
    }



    private void setRecyclerView(List<IssueModel> issueModelList) {
        mAdapter.setListData(issueModelList);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initalizeViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new IssueAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
