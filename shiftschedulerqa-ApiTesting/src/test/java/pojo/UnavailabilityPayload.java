package pojo;

import lombok.Getter;

@Getter
public class UnavailabilityPayload
{
    private int current_shift_id;
    private String date;
    private String reason;
    private int shift_id;

    public int getCurrent_shift_id() { return current_shift_id; }

    public String getDate() { return date; }

    public String getReason() { return reason; }

    public int getShift_id() { return shift_id; }

    public void setCurrent_shift_id(int current_shift_id) { this.current_shift_id = current_shift_id; }

    public void setDate(String date) {
        this.date = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setShift_id(int shift_id) {
        this.shift_id = shift_id;
    }
}
