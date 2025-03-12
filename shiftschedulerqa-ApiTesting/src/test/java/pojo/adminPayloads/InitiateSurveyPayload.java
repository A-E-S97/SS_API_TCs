package pojo.adminPayloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InitiateSurveyPayload {
    public String StartDate;
    public String EndDate;
    public String MonthlyPreferenceDeadline;

    @JsonProperty("StartDate")
    public String getStartDate() { return StartDate; }

    public void setStartDate(String StartDate) { this.StartDate = StartDate; }

    @JsonProperty("EndDate")
    public String getEndDate() { return EndDate; }

    public void setEndDate(String EndDate) { this.EndDate = EndDate; }

    @JsonProperty("MonthlyPreferenceDeadline")
    public String getMonthlyPreferenceDeadline() { return MonthlyPreferenceDeadline; }

    public void setMonthlyPreferenceDeadline(String MonthlyPreferenceDeadline) { this.MonthlyPreferenceDeadline = MonthlyPreferenceDeadline; }
}
