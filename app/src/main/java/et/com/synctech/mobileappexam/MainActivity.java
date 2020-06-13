package et.com.synctech.mobileappexam;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.orm.SugarConfig;

import java.util.ArrayList;
import java.util.List;

import et.com.synctech.mobileappexam.adapter.EmployeeAdapter;
import et.com.synctech.mobileappexam.db.DBbackUp;
import et.com.synctech.mobileappexam.model.Employee;
import et.com.synctech.mobileappexam.service.RestapiexampleService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RestapiexampleService apIinterface;
    LinearLayoutManager layoutManager;
    EmployeeAdapter adapter;
    String display="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(this);
        DBbackUp.copyDatabase(this);
        apIinterface= APIClient.getClient().create(RestapiexampleService.class);
        getEmployees();
        recyclerView=findViewById(R.id.recycler_view);

    }
    public void getEmployees(){
        Call<List<Employee>> call=apIinterface.loadEmployees();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                display=response.body().toString();
                List<Employee> empList= response.body();
                for( Employee emp :empList){
                    emp.save();
                }
            }
            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public List<String> getdata(){
        List<String> type = new ArrayList<String>();
        List<Employee> listEmployee=Employee.findWithQuery(Employee.class,"select * from Employee");

        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter=new EmployeeAdapter(listEmployee);
        recyclerView.setAdapter(adapter);

        return type;
    }
}
