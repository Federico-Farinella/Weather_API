package com.example.weather_api;

import com.example.weather_api.bean.AvailabilityBeanIn;
import com.example.weather_api.bean.AvailabilityBeanTo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


public class ControlGUI {
    @FXML
    TextField textCity, textTemp;
    @FXML
    Button btnTemp;
    @FXML
    ImageView im_15_16 ;//= new ImageView();
    @FXML
    ImageView im_16_17;

    @FXML
    Button btnSearch;

    /*public void setImage(String image){
        im_15_16.setImage(image);
    }*/

    public void weatherByCity() throws IOException {
        String city = textCity.getText();
        System.out.println(city);
        Controller3 controller = new Controller3();
        AvailabilityBeanIn bean_from = new AvailabilityBeanIn();
        //bean_from.setDate(LocalDate.now());
        bean_from.setDate(LocalDate.now().plusDays(1));
        bean_from.setCity(city);
        AvailabilityBeanTo weather = controller.weitherByCity(bean_from);
        System.out.println(weather.getWeatherByHour().get(Integer.toString(15)));


        System.out.println(weather);
        //Image image;
        Stage window;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/daily_availability_weather.fxml"));
        //String text = btnSearch.getText();
        //System.out.println(text);
        Parent root = loader.load();
        //ControlGUI contr = loader.getController();
        AvailabilityControlGUI contr = loader.getController();
        contr.setAppController(controller);
        contr.setImages(weather.getWeatherByHour());
        //String text = contr.btnSearch.getText();
        //contr.btnSearch.setText("Ciao");
        //System.out.println(text);
        window = (Stage) textCity.getScene().getWindow();
        /*ArrayList<ImageView> images_list = new ArrayList<>();
        images_list.add(contr.im_15_16);
        images_list.add(contr.im_16_17);
        //ImageView image;
        int i=15;
        URL resource;
        for (ImageView im : images_list) {
            resource = null;
            System.out.println("Tempo ora " + i + ": " + weather.getWeatherByHour().get(Integer.toString(i)));
            //ImageView image_view;
            switch (weather.getWeatherByHour().get(Integer.toString(i))) {
                case "\"Sunny\"": { // Continua da qui bisogna sistemare le classi e metodi per ottenere un HashMap in weather e manipolare immagini da visualizzare
                    System.out.println("Ok");
                    //System.out.println("\"Clear\"");
                    //Image image = new Image("cloud.png");
                    //Image image = new Image("cloud.png");
                    resource = getClass().getResource("/images/HotSun.png");
                    //System.out.println(image);
                    //contr.im_15_16.setImage(image);;
                    //contr.im_16_17.setImage(image);
                    //contr.im_15_16.setVisible(true);
                    //Image im = contr.im_15_16.getImage();
                    //System.out.println(contr.im_15_16.getImage());
                    //contr.im_15_16.setImage(im);
                    //contr.im_16_17.setImage(im);
                    System.out.println("Yes");
                    break;
                }
                case ("\"Cloudy\""): {
                    resource = getClass().getResource("/images/C.png");
                    break;
                }
                case ("\"Overcast\""): {
                    resource = getClass().getResource("/images/C.png");
                }

            }
            if (resource != null) {
                Image image = new Image(resource.toString());
                im.setImage(image);
            }
            i++;
        }*/
        /*for (i=15; i<17; i++) {
            System.out.println("Tempo ora " + i + ": " + weather.getWeatherByHour().get(Integer.toString(i)));
            ImageView image_view;
            switch (weather.getWeatherByHour().get(Integer.toString(i))) {
                case "\"Sunny\"": // Continua da qui bisogna sistemare le classi e metodi per ottenere un HashMap in weather e manipolare immagini da visualizzare
                    image_view = images_list.get(i-15);
                    System.out.println("Ok");
                    //System.out.println("\"Clear\"");
                    //Image image = new Image("cloud.png");
                    //Image image = new Image("cloud.png");
                    Image image = new Image("HotSun.png");
                    //System.out.println(image);
                    //contr.im_15_16.setImage(image);
                    contr.
                    //contr.im_16_17.setImage(image);
                    //contr.im_15_16.setVisible(true);
                    Image im = contr.im_15_16.getImage();
                    //System.out.println(contr.im_15_16.getImage());
                    //contr.im_15_16.setImage(im);
                    contr.im_16_17.setImage(im);
                    System.out.println("Yes");
                    break;
            /*case "\"Clear\"":
                break;*/

            //}

        //Parent root = loader.load();
        window.setScene(new Scene(root));
        //String host = "http://api.openweathermap.org";
        //String charset = "UTF-8";
        //String openweather_host = "http://api.openweathermap.org";

        //String key = "5fe83f26b03e183f9c34c47056b43cfa";
        /*String configFilePath = "config.properties";
        FileInputStream propsInput = new FileInputStream(configFilePath);

        Properties prop = new Properties();
        prop.load(propsInput);


        String param = "London";
        //OkHttpClient client = new OkHttpClient();

        //Request request = new Request.Builder().url("http://apiu.oppenweather.org")... Continua
        OkHttpClient client = new OkHttpClient();

        //Request req = new Request.Builder().url("http://api.openweathermap.org").build();
        //Request req = new Request.Builder().url("https://api.openweathermap.org/data/2.5/weather?q=Rome&appid=5fe83f26b03e183f9c34c47056b43cfa").build();
        Request req = new Request.Builder().url("https://api.openweathermap.org/data/2.5/weather?q=Vatican City&appid=" + prop.getProperty("key")).build();
        try {
            Response resp = client.newCall(req).execute();
            ResponseBody body = resp.body();
            //Sostituito Response con HttpResponse
            //String json = resp.body.toString();
            //DataInputStream input = new DataInputStream(resp.getClass().)
            System.out.println("Eccomi");
            String jsonData = resp.body().string();
            System.out.println(jsonData);
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode node = mapper.readValue(jsonData, ObjectNode.class);
            //JsonNode weather = node.get("base");
            JsonNode weather = node.get("weather").get(0);
            String string = weather.get("main").toString();
            //Weather weath = mapper.treeToValue(weather.get(0), Weather.class);
            //System.out.println(weath.getMain());

            String str = weather.toString();
            System.out.println(string);

            //System.out.println(main);

            //System.out.println(body.string()); Equivalente a riga sopra
            //System.out.println(resp.getEntity().getContent().toString());
            //System.out.println(json);
        } catch (IOException e) {
            System.out.println("Error");
        }
        //ConnectionDelegate delegate = new ConnectionDelegate(new Connection());
        //JacksonAnnotation jack =
        //PaddingReadBehavior var =*/
    }
}
