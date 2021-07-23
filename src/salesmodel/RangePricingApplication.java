package salesmodel;

import javax.swing.JFrame;
import salesmodel.Data.Data;

import ui.UserLoginJPanel;
import ui.UiControl;

public class RangePricingApplication {

    public static void main(String[] args) {

        //create fake data
        Data data = new Data();
        data.loadData();

        //load UI
        JFrame jf = new JFrame();
        UserLoginJPanel loginUI = new UserLoginJPanel(jf, data);
        UiControl.boot(jf, loginUI); 
        
        //create second jframe, just for demo purpose. So we can sign in with different roles on the same screen
        JFrame jf2 = new JFrame();
        UserLoginJPanel loginUI2 = new UserLoginJPanel(jf2, data);
        UiControl.boot(jf2, loginUI2); 

    }

}
