package com.example.weather_api;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class AvailabilityControlGUI {
    @FXML
    ImageView im_15_16, im_16_17, im_17_18, im_18_19, im_19_20, im_20_21, im_21_22, im_22_23;
    private Controller3 app_controller;
    private ArrayList<ImageView> images ;

    @FXML
    Button btnSearch;

    public void weatherByCity() throws IOException {

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
    }

    public void setAppController(Controller3 control) {
        this.app_controller = control;
    }

    public void setImages(HashMap<String,ArrayList<String>> weather_res) {
        int i=15;
        URL resource;
        String condition;
        String is_day;
        for (ImageView im : images) {
            System.out.println(i);
            System.out.println(weather_res.get(Integer.toString(i)));
            resource = null;
            condition = weather_res.get(Integer.toString(i)).get(0);
            is_day = weather_res.get(Integer.toString(i)).get(1);
            System.out.println("Tempo ora " + i + ": " + condition);
            switch (condition) {
                case ("\"Sunny\"") : { // Continua da qui bisogna sistemare le classi e metodi per ottenere un HashMap in weather e manipolare immagini da visualizzare
                    System.out.println("Ok");
                    resource = getClass().getResource("/images/Sunny.png");
                    System.out.println("Yes");
                    break;
                }

                case ("\"Clear\"") : {
                    System.out.println("I'm in Clear case");
                    resource = getClass().getResource("/images/Moon_Other2.png");
                    break;
                }
                case ("\"Partly cloudy\""): {
                    if (Objects.equals(is_day, "1")) {
                        resource = getClass().getResource("/images/Sun&&Clouds.png");
                    } else {
                        resource = getClass().getResource("/images/Moon_Clouds_Other.png");
                    }
                    break;
                }
                case ("\"Overcast\""): {
                    resource = getClass().getResource("/images/Overcast1.png");
                    break;
                }
                case ("\"Cloudy\""): {
                    resource = getClass().getResource("/images/Clouds_Right.png");
                    break;
                }
                case ("\"Patchy rain possible\""): {
                    if (Objects.equals(is_day, "1")) {
                        resource = getClass().getResource("/images/Patchy_Rain_Day.png");
                    } else {
                        resource = getClass().getResource("/images/Moon_Rain.png");
                        //resource = getClass().getResource("/images/Rain_4.png");
                    }
                }
                case ("\"Patchy light drizzle\""): { //|| ("\"Light drizzle\"")): {
                    resource = getClass().getResource("/images/Rain_4.png");
                    break;
                }

                case ("\"Light drizzle\""): {
                    resource = getClass().getResource("/images/Rain_4.png");
                    break;
                }
            // Mi manca , pioggia leggera da sostituire con quella che ho messo Rain_4 che sarà pioggia pesante?, temporale, neve
            }
            if (resource != null) {
                Image image = new Image(resource.toString());
                im.setImage(image);
            }
            i++;
        }
    }

    /*public void setImages(HashMap<String,String> weather_res) {
        int i=15;
        URL resource;
        for (ImageView im : images) {
            resource = null;
            System.out.println("Tempo ora " + i + ": " + weather_res.get(Integer.toString(i)));
            switch (weather_res.get(Integer.toString(i))) {
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
        images.add(im_15_16);
        images.add(im_16_17);
        images.add(im_17_18);
        images.add(im_18_19);
        images.add(im_19_20);
        images.add(im_20_21);
        images.add(im_21_22);
        images.add(im_22_23);
    }
}
