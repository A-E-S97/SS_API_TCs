package pojo;

import lombok.Getter;
import java.util.List;

public class WeeklyShiftPreference {
    private List<ShiftPreference> weekly_shift_preferences;
    public List<ShiftPreference> getWeeklyShiftPreferences()
    {return weekly_shift_preferences;}

    public void setWeeklyShiftPreferences(List<ShiftPreference> weekly_shift_preferences)
    {this.weekly_shift_preferences = weekly_shift_preferences;}

//    public void addWeeklyShiftPreferences(List<ShiftPreference> weekly_shift_preferences) {
//
//        if (weekly_shift_preferences == null) {
//            weekly_shift_preferences = new ArrayList<>();
//        }
//        weekly_shift_preferences.add(Object);
//    }
}

@Getter
class ShiftPreference {
    private int id;
    private String shifts_id;
    private int max_count;
    private int min_count;

    public void setId(int id) { this.id = id; }

    public void setShifts_id(String shifts_id) {this.shifts_id = shifts_id;}

    public void setMax_count(int max_count) {this.max_count = max_count;}

    public void setMin_count(int min_count) {this.min_count = min_count;}
}

