package Main;

import BusinessLogic.DeliveryService;
import BusinessLogic.IDeliveryServicePeocessing;
import Presentation.Controller;
import Presentation.ViewAdministrator;
import Presentation.ViewClient;
import Presentation.ViewLogin;

/**
 * Main function
 */
public class App 
{
    public static void main( String[] args )
    {
        ViewLogin view = new ViewLogin();
        ViewClient view1 =new ViewClient();
        ViewAdministrator view2 = new ViewAdministrator();
        IDeliveryServicePeocessing deliveryServiceProcessing=new DeliveryService();
        Controller controller = new Controller(view,view2,view1,deliveryServiceProcessing);
    }

}
