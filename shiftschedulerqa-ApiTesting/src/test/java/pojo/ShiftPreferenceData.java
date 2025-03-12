package pojo;

import java.util.Arrays;
import lombok.Getter;

@Getter
public class ShiftPreferenceData
{
    String dates;

    public String getEndDate() { return endDate; }

    public String getReason() { return reason; }

    public String getType() { return type; }

    String endDate;
    String reason;
    String type;

//    public String[] getStartDate() { return startDate; }
//
//    public void setStartDate(String date) {
//        this.startDate = new String[]{date};
//    }
    public String[] getDates() {
        return new String[]{dates};
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

//    public String getReason() { return reason; }

    public void setReason(String reason) { this.reason = reason; }

//    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
