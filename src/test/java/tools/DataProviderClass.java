package tools;

import org.testng.annotations.DataProvider;

/**
 * Created by Maksymilian on 2017-05-23.
 */
public class DataProviderClass {
    @DataProvider(name = "dataProviderSignIn")
    public static Object[][] getLoginData() {
        return new Object[][] {
                {"roni_cost@example.com", "roni_cost3@example.com"},
        };
    }

    @DataProvider(name = "dataProviderSignInWithInvalidUser")
    public static Object[][] getLoginDataWithInvalidUser() {
        return new Object[][]{
                {"Rroni_cost@example.com", "roni_cost3@example.com"}
        };
    }

    @DataProvider(name = "dataProviderSignInWithInvalidPassword")
    public static Object[][] getLoginDataWithInvalidPassword() {
        return new Object[][]{
                {"roni_cost@example.com", "Rroni_cost3@example.com"}
        };
    }

    @DataProvider(name = "dataProviderSignInWithInvalidUserAndPassword")
    public static Object[][] getLoginDataWithInvalidUserAndPassword() {
        return new Object[][]{
                {"Rroni_cost@example.com", "Rroni_cost3@example.com"}
        };
    }

    @DataProvider(name = "dataProviderSignInWithoutData")
    public static Object[][] getLoginWithoutData() {
        return new Object[][]{
                {"" , ""}
        };
    }

}
