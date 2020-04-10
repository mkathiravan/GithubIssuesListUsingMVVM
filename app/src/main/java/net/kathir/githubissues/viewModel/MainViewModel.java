package net.kathir.githubissues.viewModel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import net.kathir.githubissues.model.IssueModel;
import net.kathir.githubissues.repository.IssueRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private IssueRepository issueRepository;


    public MainViewModel(@NonNull Application application) {
        super(application);
        issueRepository = new IssueRepository();
    }

    public LiveData<List<IssueModel>> getAllIssues()
    {
        return issueRepository.getIssueDataList();
    }

}
