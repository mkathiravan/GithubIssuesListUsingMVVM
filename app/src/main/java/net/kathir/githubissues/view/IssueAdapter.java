package net.kathir.githubissues.view;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.kathir.githubissues.R;
import net.kathir.githubissues.model.IssueModel;

import java.util.List;

public class IssueAdapter extends RecyclerView.Adapter<IssueAdapter.IssueViewHolder>{

    private List<IssueModel> issueModelList;


    @NonNull
    @Override
    public IssueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.issues_child,parent,false);
        return new IssueAdapter.IssueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IssueViewHolder holder, int position) {

        IssueModel issueModel = issueModelList.get(position);
        holder.issueTitle.setText(issueModel.getTitle());
        holder.issueNo.setText(issueModel.getNumber());
        holder.issueCreateAt.setText(issueModel.getCreateAt());
        holder.issueUser.setText(issueModel.getUserinfo().getLogin());
    }

    public void setListData(List<IssueModel> issueList)
    {
        issueModelList = issueList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return issueModelList.size();
    }

    class IssueViewHolder extends RecyclerView.ViewHolder
    {
        TextView issueTitle,issueNo,issueCreateAt,issueUser;

        public IssueViewHolder(@NonNull View itemView) {
            super(itemView);

            issueTitle = itemView.findViewById(R.id.issue_title);
            issueNo = itemView.findViewById(R.id.issue_no);
            issueCreateAt = itemView.findViewById(R.id.issue_createdAt);
            issueUser = itemView.findViewById(R.id.issue_user);
        }
    }
}
