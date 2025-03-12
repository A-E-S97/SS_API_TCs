package pojo.adminPayloads;

import java.util.ArrayList;
import java.util.List;

public class PutShift
{
    private String name;
    private String code;
    private String colour;
    private String start_time;
    private String end_time;
    private String shift_days;
//    private String description;
    private List<RoleConstrains> shift_role_constraints;// = new ArrayList<>();
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getColour() { return colour; }

    public void setColour(String colour) { this.colour = colour; }

    public String getStart_time() { return start_time; }

    public void setStart_time(String start_time) { this.start_time = start_time; }

    public String getEnd_time() { return end_time; }

    public void setEnd_time(String end_time) { this.end_time = end_time; }

    public String getShift_days() { return shift_days; }

//    public String getDescription() { return description; }

//    public void setDescription(String description) { this.description = description; }

    public void setShift_days(String shift_days) { this.shift_days = shift_days; }

    public List<RoleConstrains> getShift_role_constraints() { return shift_role_constraints; }

    public void setShift_role_constraints(List<RoleConstrains> shift_role_constraints) {
        this.shift_role_constraints = shift_role_constraints;
    }

    public void addShift_role_constraints(RoleConstrains role_constraints) {
        shift_role_constraints.add(role_constraints);
    }

    public void newShift_role_constraints()
    {this.shift_role_constraints = new ArrayList<>();}

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"code\": \"" + code + '\"' +
                ", \"colour\": \"" + colour + '\"' +
                ", \"start_time\": \"" + start_time + '\"' +
                ", \"end_time\": \"" + end_time + '\"' +
                ", \"shift_days\": " + shift_days +
             //   ", \"description\": " + description +
                ", \"shift_role_constraints\": " + shift_role_constraints +
                '}';
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "name='" + name + '\n' +
//                ", code='" + code + '\n' +
//                ", colour=" + colour + '\n' +
//                ", \"start_time\"=\""+ start_time + '\"\n' +
//                ", end_time='" + end_time + '\n' +
//                ", shift_days='" + shift_days + '\n' +
//                ", shift_role_constraints=" + shift_role_constraints +
//                '}';
//    }
}
