package pojo.adminPayloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleConstrains
{
    @JsonProperty("role_id")
    private  int role_id;
    private  int max;
    private  int min;

    public void setRoleConstrains(int id, int max, int min)
    {
        this.role_id = id;
        this.max = max;
        this.min = min;
    }

//    public int getRole_id() {return role_id;}
//
//    public void setRole_id(int role_id) {this.role_id = role_id;}
//
//    public int getMax() {return max;}
//
//    public void setMax(int max) {this.max = max;}
//
//    public int getMin() {return min;}
//
//    public void setMin(int min) {this.min = min;}

    @Override
    public String toString() {
        return "{" +
                "\"role_id\":" + role_id +
                ", \"max\":" + max +
                ", \"min\":" + min +
                '}';
    }
}
