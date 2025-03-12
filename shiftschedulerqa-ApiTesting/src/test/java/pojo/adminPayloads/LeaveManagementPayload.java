package pojo.adminPayloads;

import lombok.Getter;

import java.util.List;

@Getter
public class LeaveManagementPayload
{
    private List<MonthlyPreference> monthlyPreferences;

    // Getter and Setter methods

    public void setMonthlyPreferences(List<MonthlyPreference> monthlyPreferences)
    {this.monthlyPreferences = monthlyPreferences;}
}
