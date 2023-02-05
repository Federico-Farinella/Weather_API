package com.example.weather_api;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class AvailabilityControlGUI {
    @FXML
    ImageView im15to16;
    @FXML
    ImageView im16to17;
    @FXML
    ImageView im17to18;
    @FXML
    ImageView im18to19;
    @FXML
    ImageView im19to20;
    @FXML
    ImageView im20to21;
    @FXML
    ImageView im21to22;
    @FXML
    ImageView im22to23;

    private Controller3 appController;

    private ArrayList<ImageView> images ;

    @FXML
    Button btnSearch;

    //public void weatherByCity() throws IOException {

        //Image image;
        /*Stage window;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/daily_availability_weather.fxml"));
        //String text = btnSearch.getText();
        //System.out.println(text);
        Parent root = loader.load();
        AvailabilityControlGUI contr = loader.getController();
        String text = contr.btnSearch.getText();
        contr.btnSearch.setText("Ciao");
        System.out.println(text);
        window = (Stage) textCity.getScene().getWindow();

        switch (weither) {
            case "\"Clear\"":
                System.out.println("Ok");
                System.out.println("\"Clear\"");
                //Image image = new Image("cloud.png");
                Image image = new Image("cloud.png");
                System.out.println(image);
                contr.im_15_16.setImage(image);
                //contr.im_16_17.setImage(image);
                //contr.im_15_16.setVisible(true);
                Image im = contr.im_15_16.getImage();
                System.out.println(contr.im_15_16.getImage());
                //contr.im_15_16.setImage(im);
                contr.im_16_17.setImage(im);
                System.out.println("Yes");
                break;*/
            /*case "\"Clear\"":
                break;*/

        /*}
        //Parent root = loader.load();
        window.setScene(new Scene(root));
    //}*/
    //}

    public void setAppController(Controller3 control) {
        this.appController = control;
    }

    public void setImages(Map<String,ArrayList<String>> weatherResponse) {
        // Sonarcloud mi ha fatto sostituire hashMap con Map
        int i=15;
        URL resource;
        String condition;
        String is_day;
        for (ImageView im : images) {
            System.out.println(i);
            System.out.println(weatherResponse.get(Integer.toString(i)));
            //resource = null;
            condition = weatherResponse.get(Integer.toString(i)).get(0);
            is_day = weatherResponse.get(Integer.toString(i)).get(1);
            System.out.println("Tempo ora " + i + ": " + condition);
            switch (condition) {
                case ("\"Sunny\"") -> { // Continua da qui bisogna sistemare le classi e metodi per ottenere un HashMap in weather e manipolare immagini da visualizzare
                    System.out.println("Ok");
                    resource = getClass().getResource("/images/Sunny.png");
                    System.out.println("Yes");
                }
                case ("\"Clear\"") -> {
                    System.out.println("I'm in Clear case");
                    resource = getClass().getResource("/images/Moon_Other2.png");
                }
                case ("\"Partly cloudy\"") -> {
                    if (Objects.equals(is_day, "1")) {
                        resource = getClass().getResource("/images/Sun&&Clouds.png");
                    } else {
                        resource = getClass().getResource("/images/Moon_Clouds_Other.png");
                    }
                }
                case ("\"Overcast\"") ->
                    resource = getClass().getResource("/images/Overcast1.png");
                case ("\"Cloudy\"") ->
                    resource = getClass().getResource("/images/Clouds_Right.png");

                case ("\"Patchy rain possible\"") -> {
                    if (Objects.equals(is_day, "1")) {
                        resource = getClass().getResource("/images/Patchy_Rain_Day.png");
                    } else {
                        resource = getClass().getResource("/images/Moon_Rain.png");
                        //resource = getClass().getResource("/images/Rain_4.png");
                    }
                }
                case ("\"Patchy light drizzle\""), ("\"Light drizzle\"") ->  //|| ("\"Light drizzle\"")): {
                    resource = getClass().getResource("/images/Rain_4.png");

                default -> resource = null;
                // Mi manca , pioggia leggera da sostituire con quella che ho messo Rain_4 che sarà pioggia pesante?, temporale, neve
            }
            if (resource != null) {
                Image image = new Image(resource.toString());
                im.setImage(image);
            }
            i++;
        }
    }

    /*public void setImages(HashMap<String,String> weatherResponse) {
        int i=15;
        URL resource;
        for (ImageView im : images) {
            resource = null;
            System.out.println("Tempo ora " + i + ": " + weatherResponse.get(Integer.toString(i)));
            switch (weatherResponse.get(Integer.toString(i))) {
                case ("\"Sunny\"") : { // Continua da qui bisogna sistemare le classi e metodi per ottenere un HashMap in weather e manipolare immagini da visualizzare
                    System.out.println("Ok");
                    resource = getClass().getResource("/images/Sun_2.png");
                    System.out.println("Yes");
                    break;
                }
                case ("\"Partly cloudy\""): {
                    resource = getClass().getResource("/images/Cloud_Sun1.png");
                    break;
                }
                case ("\"Overcast\""): {
                    resource = getClass().getResource("/images/Cloud2.png");
                    break;
                }

            }
            if (resource != null) {
                Image image = new Image(resource.toString());
                im.setImage(image);
            }
            i++;
        }
    }*/

    public void initialize() {
        images = new ArrayList<>();
        images.add(im15to16);
        images.add(im16to17);
        images.add(im17to18);
        images.add(im18to19);
        images.add(im19to20);
        images.add(im20to21);
        images.add(im21to22);
        images.add(im22to23);
    }
}
