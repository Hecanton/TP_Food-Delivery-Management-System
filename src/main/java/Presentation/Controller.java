package Presentation;

import BusinessLogic.IDeliveryServicePeocessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class Controller {
    private ViewClient viewClient;
    private ViewAdministrator viewAdministrator;
    private ViewLogin viewLogin;
    IDeliveryServicePeocessing deliveryServiceProcessing;

    public Controller(ViewLogin viewLogin ,ViewAdministrator viewAdministrator, ViewClient viewClient,IDeliveryServicePeocessing deliveryServiceProcessing) {
        this.viewAdministrator=viewAdministrator;
        this.viewClient=viewClient;
        this.viewLogin=viewLogin;
        this.deliveryServiceProcessing=deliveryServiceProcessing;

        viewAdministrator.setVisible(false);
        viewLogin.setVisible(true);
        viewClient.setVisible(false);

        viewLogin.addLoginListener(new LoginListener());
        viewLogin.addRegisterListener(new RegisterListener());

        viewClient.addOrderListener(new OrderListener());
        viewClient.addSearchListener(new SearchListener());
        viewClient.addSearchByCalListener(new SearchCalListener());
        viewClient.addSearchByRateListener(new SearchRateListener());
        viewClient.addSearchByProtListener(new SearchProtListener());
        viewClient.addSearchByFatListener(new SearchFatListener());
        viewClient.addSearchBySodiumListener(new SearchSodiumListener());
        viewClient.addSearchByPriceListener(new SearchPriceListener());
        viewClient.addMenuListener(new MenuListener());

        viewAdministrator.addADDListener(new ADDListener());
        viewAdministrator.addModifyListener(new ModifyListener());
        viewAdministrator.addImportListener(new ImportListener());
        viewAdministrator.addDeleteListener(new DeleteListener());

        viewAdministrator.addInsertCompositeListener(new CompositeListener());

        viewAdministrator.addHourReportListener(new HourReportListener());

        viewAdministrator.addCountReportListener(new CountListener());

        viewAdministrator.addDateRaportListener(new DateRaportListener());

        viewAdministrator.addClientRaportListener(new ClientRaportListener());
    }

    class  LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(viewLogin.getUserNameInput().equals("Admin") && viewLogin.getPasswordInput().equals("Admin")){
                viewAdministrator.setVisible(true);
                return;
            }
            deliveryServiceProcessing.loginUser(viewLogin.getUserNameInput(),viewLogin.getPasswordInput());
            if(deliveryServiceProcessing.isLoggedIn()){
                viewClient.setVisible(true);
            }
        }
    }

    class  RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int id = parseInt(viewLogin.getIdInput());
            deliveryServiceProcessing.registerUser(id,viewLogin.getUserNameInput(),viewLogin.getPasswordInput());

        }
    }

    class  OrderListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int orderId = Integer.parseInt(viewClient.getOrderIdInput());
            int[] productsId=new int[viewClient.getProductDInput().split(" ").length];
            for(int i=0;i<productsId.length;i++){
                productsId[i]=Integer.parseInt(viewClient.getProductDInput().split(" ")[i]);
            }
            Date date = new Date(Integer.parseInt(viewClient.getDateInput().split("/")[0]),Integer.parseInt(viewClient.getDateInput().split("/")[1]),Integer.parseInt(viewClient.getDateInput().split("/")[2]));
            int hour = parseInt(viewClient.getHourInput());

            deliveryServiceProcessing.addOrder(orderId,deliveryServiceProcessing.getUserId(),date,hour,productsId);
        }
    }

    class MenuListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
                //deliveryServiceProcessing.importMenu();
                viewClient.setMenu(deliveryServiceProcessing.viewMenu());
        }
    }

    class SearchListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewClient.setMenu(deliveryServiceProcessing.searchItem(viewClient.getTitleInput(),0,0,0,0,0,0));
        }
    }

    class ADDListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id= Integer.parseInt(viewAdministrator.getId1Input());
            double rating= Double.parseDouble(viewAdministrator.getRatingInput());
            int calories= Integer.parseInt(viewAdministrator.getCaloriesInput());
            int protein= Integer.parseInt(viewAdministrator.getProteinInput());
            int fat= Integer.parseInt(viewAdministrator.getFatInput());
            int sodium= Integer.parseInt(viewAdministrator.getSodiumInput());
            int price= Integer.parseInt(viewAdministrator.getPriceInput());

            deliveryServiceProcessing.addInMenu(id,viewAdministrator.getTitleInput(),rating,calories,protein,fat,sodium,price);
        }
    }

    class ModifyListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id= Integer.parseInt(viewAdministrator.getId1Input());
            double rating= Double.parseDouble(viewAdministrator.getRatingInput());
            int calories= Integer.parseInt(viewAdministrator.getCaloriesInput());
            int protein= Integer.parseInt(viewAdministrator.getProteinInput());
            int fat= Integer.parseInt(viewAdministrator.getFatInput());
            int sodium= Integer.parseInt(viewAdministrator.getSodiumInput());
            int price= Integer.parseInt(viewAdministrator.getPriceInput());

            deliveryServiceProcessing.updateMenuItem(id,viewAdministrator.getTitleInput(),rating,calories,protein,fat,sodium,price);
        }
    }

    class DeleteListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id= Integer.parseInt(viewAdministrator.getId1Input());
            deliveryServiceProcessing.deleteFromMenu(id);
        }
    }
    class ImportListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            deliveryServiceProcessing.importMenu();
        }
    }

    class CompositeListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id= Integer.parseInt(viewAdministrator.getCompositeIdInput());

            int[] compositeIDs=new int[viewAdministrator.getALLIdInput().split(" ").length];
            for (int i=0;i<compositeIDs.length;i++) {
                compositeIDs[i]=Integer.parseInt(viewAdministrator.getALLIdInput().split(" ")[i]);
            }
            deliveryServiceProcessing.addToComposite(id,viewAdministrator.getCompositeTitleInput(),0,0,0,0,0,0,compositeIDs);
        }
    }

    class HourReportListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int startHour= Integer.parseInt(viewAdministrator.getStartHourInput());
            int endHour= Integer.parseInt(viewAdministrator.getEndHourInput());
            viewAdministrator.setMenu(deliveryServiceProcessing.timeIntervalReport(startHour,endHour));
        }
    }

    class CountListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int minCount= Integer.parseInt(viewAdministrator.getMinOrderCountInput());
            viewAdministrator.setMenu(deliveryServiceProcessing.numberOfOrders(minCount));
        }
    }

    class DateRaportListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Date date= new Date(Integer.parseInt(viewAdministrator.getDateRaportInput().split("/")[2],Integer.parseInt(viewAdministrator.getDateRaportInput().split("/")[1],Integer.parseInt(viewAdministrator.getDateRaportInput().split("/")[0]))));
            //viewAdministrator.setMenu(deliveryServiceProcessing.dateReport(date));

            viewAdministrator.setMenu(deliveryServiceProcessing.dateReport(new Date(Integer.parseInt(viewAdministrator.getDateRaportInput().split("/")[0]), Integer.parseInt(viewAdministrator.getDateRaportInput().split("/")[1]), Integer.parseInt(viewAdministrator.getDateRaportInput().split("/")[2]))));

        }
    }

    class ClientRaportListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int minCount= Integer.parseInt(viewAdministrator.getMinOrderCount2Input());
            int minvalue= Integer.parseInt(viewAdministrator.getMinOrderValueInput());
            viewAdministrator.setMenu(deliveryServiceProcessing.usersReport(minCount,minvalue));
        }
    }

    class SearchRateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewClient.setMenu(deliveryServiceProcessing.searchByRating(Double.parseDouble(viewClient.getRatingInput())));
        }
    }

    class SearchProtListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewClient.setMenu(deliveryServiceProcessing.searchByProtein(Integer.parseInt(viewClient.getProteinInput())));
        }
    }

    class SearchPriceListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewClient.setMenu(deliveryServiceProcessing.searchByPrice(Integer.parseInt(viewClient.getPriceInput())));
        }
    }

    class SearchFatListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewClient.setMenu(deliveryServiceProcessing.searchByFat(Integer.parseInt(viewClient.getFatInput())));
        }
    }
    class SearchSodiumListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewClient.setMenu(deliveryServiceProcessing.searchBySodium(Integer.parseInt(viewClient.getSodiumInput())));
        }
    }

    class SearchCalListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewClient.setMenu(deliveryServiceProcessing.searchByCalories(Integer.parseInt(viewClient.getCaloriesInput())));
        }
    }

}
