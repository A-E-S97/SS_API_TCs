package Utils;

public enum PageFactory
{
    //LoginPage
    //email field
    usernameField("//*[@id=\"root\"]/div/form/div[2]/div/input[1]")
    , passwordField("//*[@id=\"root\"]/div/form/div[2]/div/input[2]")

    //Dashboard
    //NavTab
    , today("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/a[1]")
    , monthly("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/a[2]")
    , markUnavailability("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/a[3]")
    , monthlyPreferences("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/a[4]")

    //Unavailability Page
    , addUnavailabilityButton("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/a")

    //Add Unavailability form
    , addUnavailabilityDate("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/div[2]/form/div[1]/input")
    , addUnavailabilityReason("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/div[2]/form/div[3]/textarea")
    ;
    private String webElement;
    PageFactory(String webElement) { this.webElement = webElement; }
    public String getEndpoint(){ return webElement; }
}
