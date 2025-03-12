package Utils;

public enum AdminEndpoints
{
    shiftGenStatus("/project/generate-shift/status")
    ,initiateSurvey("/project/initiate-survey")
    ,leaveReq("/project/generate-shift/leave-requests")
    ,shiftList("/project/shifts") //Detailed list of all shifts
    ,shiftEdit("/shifts") //Add(post) and edit(put) shifts,
    ,members("/members")
    ,role("/role")
    ;

    private String endpoint;
    AdminEndpoints(String endpoint) { this.endpoint = endpoint; }
    public String getEndpoint(){ return endpoint; }
}
