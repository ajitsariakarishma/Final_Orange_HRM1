package Final_Orange_HRM;

public class DashBoardPage extends Utils {
    LoadProperties props = new LoadProperties();

    public void validateurl(){
        validateUrl(props.getProperty("dashBoardUrl"));
    }

}
