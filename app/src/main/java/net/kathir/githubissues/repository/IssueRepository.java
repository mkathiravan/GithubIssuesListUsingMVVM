package net.kathir.githubissues.repository;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import net.kathir.githubissues.apiService.RestApiService;
import net.kathir.githubissues.apiService.RetrofitInstance;
import net.kathir.githubissues.model.IssueModel;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IssueRepository {

    private static final String TAG = IssueRepository.class.getSimpleName();
    private MutableLiveData<List<IssueModel>> mutableLiveData = new MutableLiveData<>();


    public MutableLiveData<List<IssueModel>> getIssueDataList() {

        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<IssueModel>> call = apiService.getIssues("square","okhttp");
        call.enqueue(new Callback<List<IssueModel>>() {
            @Override
            public void onResponse(Call<List<IssueModel>> call, Response<List<IssueModel>> response) {

                if(response != null)
                {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<IssueModel>> call, Throwable t) {

                Log.d(TAG,"Failure_MSG " + t.getMessage());


            }
        });

        return mutableLiveData;
    }

}
