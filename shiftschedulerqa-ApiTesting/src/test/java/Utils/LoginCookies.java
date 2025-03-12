package Utils;

//import lombok.Getter;

public class LoginCookies {

//    @Getter
    private static String accessToken;
    private static String refreshToken;

    public static String getAccessToken() {
        return accessToken;
    }
    public static void setAccessToken(String accessToken) {
        LoginCookies.accessToken = accessToken;
    }

    public static String getRefreshToken() {
        return refreshToken;
    }

    public static void setRefreshToken(String refreshToken) {
        LoginCookies.refreshToken = refreshToken;
    }

}
