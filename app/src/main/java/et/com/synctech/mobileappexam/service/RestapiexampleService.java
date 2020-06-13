package et.com.synctech.mobileappexam.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import et.com.synctech.mobileappexam.model.Employee;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestapiexampleService {

   @GET("Employee")
   Call<List<Employee>> loadEmployees();


}
