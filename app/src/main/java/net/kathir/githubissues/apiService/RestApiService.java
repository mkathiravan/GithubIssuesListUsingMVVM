package net.kathir.githubissues.apiService;

import net.kathir.githubissues.model.IssueModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApiService {

    @GET("/repos/{ownername}/{repo}/issues")
    Call<List<IssueModel>> getIssues(@Path("ownername") String ownername, @Path("repo") String repo);



}
