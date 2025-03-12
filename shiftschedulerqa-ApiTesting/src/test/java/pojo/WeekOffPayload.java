package pojo;

import lombok.Getter;

import java.util.List;

@Getter
public class WeekOffPayload
{
    private int id;
    private int employees_id;
    private List<String> days;

    public int getId() { return id; }

    public int getEmployees_id() { return employees_id; }

    public List<String> getDays() { return days; }

    public void setId(int id) { this.id = id; }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }

    public void setDays(List<String> days) { this.days = days; }
}
