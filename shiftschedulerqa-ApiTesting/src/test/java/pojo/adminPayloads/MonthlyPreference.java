package pojo.adminPayloads;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MonthlyPreference
{
    private String status;
    private List<Object> monthly_preference_ids;

    // Getter and Setter methods

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMonthly_preference_ids(List<Object> monthly_preference_ids) {
        this.monthly_preference_ids = monthly_preference_ids;
    }

    public void addMonthlyPreferenceId(Integer id) {
        //if (monthly_preference_ids == null) {
            monthly_preference_ids = new ArrayList<>();
        //}
        monthly_preference_ids.add(id);
    }
}
