package et.com.synctech.mobileappexam.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import et.com.synctech.mobileappexam.R;
import et.com.synctech.mobileappexam.model.Employee;
public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {
    private List<Employee> dataSet;

    public EmployeeAdapter(List<Employee> data) {
        this.dataSet = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.layout_single_employee_card, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView textViewName=holder.textViewName;
        TextView textViewAge=holder.textViewAge;
        TextView textViewId=holder.textViewId;
        TextView textViewSalary=holder.textViewSalary;
        ImageView imageViewProfilePicture=holder.imageViewProfilePicture;

        textViewName.setText(dataSet.get(position).getName());
        textViewAge.setText(dataSet.get(position).getAge());
        textViewId.setText(dataSet.get(position).getEmpId());
        textViewSalary.setText(dataSet.get(position).getSalary());
    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textViewName;
            TextView textViewAge;
            TextView textViewId;
            TextView textViewSalary;
            ImageView imageViewProfilePicture;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.textViewName = (TextView) itemView.findViewById( R.id.textViewPersonName);
                this.textViewAge = (TextView) itemView.findViewById( R.id.textViewAge);
                this.textViewSalary = (TextView) itemView.findViewById(R.id.textViewSalary);
                this.textViewId = (TextView) itemView.findViewById(R.id.textViewId);
                this.imageViewProfilePicture = (ImageView) itemView.findViewById(R.id.imageViewProfilePicture);
            }
        }
}
