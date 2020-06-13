package et.com.synctech.mobileappexam;


import com.google.gson.annotations.SerializedName;

import java.util.List;
import et.com.synctech.mobileappexam.model.Employee;

public class EmployeeResponse {
    private int page;

    private List<Employee> results;

    private int totalResults;

    private int totalPages;



    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Employee> getResults() {
        return results;
    }

    public void setResults(List<Employee> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
