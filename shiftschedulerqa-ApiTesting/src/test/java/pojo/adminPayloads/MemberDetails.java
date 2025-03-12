package pojo.adminPayloads;

import java.util.ArrayList;
import java.util.List;

public class MemberDetails
{
    private int id;
    private String name;
    private String code;
    private int role_id;
    private String tier_code;
    private String location;
    private String designation;
    private List general_leave_preferences;
    private List general_shift_preferences;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "MemberDetails{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", role_id=" + role_id +
                ", tier_code='" + tier_code + '\'' +
                ", location='" + location + '\'' +
                ", designation='" + designation + '\'' +
                ", general_leave_preferences=" + general_leave_preferences +
                ", general_shift_preferences=" + general_shift_preferences +
                '}';
    }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getRole_id() { return role_id; }

    public void setRole_id(int role_id) { this.role_id = role_id; }

    public String getTier_code() { return tier_code; }

    public void setTier_code(String tier_code) { this.tier_code = tier_code; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getDesignation() { return designation; }

    public void setDesignation(String designation) { this.designation = designation; }

    public List getGeneral_leave_preferences() { return general_leave_preferences; }

    public void setGeneral_leave_preferences(List<String> general_leave_preferences) {
        //if(general_leave_preferences == null) this.general_leave_preferences = new ArrayList();
        /*else*/ this.general_leave_preferences = general_leave_preferences; }

    public List getGeneral_shift_preferences() { return general_shift_preferences; }

    public void setGeneral_shift_preferences(List<String> general_shift_preferences) {
        //if(general_shift_preferences == null) this.general_shift_preferences = new ArrayList();
        /*else*/ this.general_shift_preferences = general_shift_preferences; }
}
