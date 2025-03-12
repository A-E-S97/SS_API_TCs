package pojo.adminPayloads;

public class Roles
{
    int id;
    String code;
    String name;
    String description;
    int max_sl_per_day;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) {this.description = description;}

    public int getMax_sl_per_day() { return max_sl_per_day; }

    public void setMax_sl_per_day(int max_sl_per_day) { this.max_sl_per_day = max_sl_per_day; }
}
