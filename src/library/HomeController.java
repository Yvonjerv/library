package library;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author YVON
 */
public class HomeController implements Initializable {

    @FXML
    private Label lbl_title;

    @FXML
    private Pane top_pane;

    @FXML
    private Label showTime;

    @FXML
    private GridPane gridBtn;
    @FXML
    private Button btn_close;
    @FXML
    private JFXButton btn1;

    @FXML
    private JFXButton btn2;

    @FXML
    private JFXButton btn3;

    @FXML
    private JFXButton btn4;

    @FXML
    private JFXButton btn5;

    @FXML
    private BarChart<Number, String> bar_chart;
    final NumberAxis xAxis = new NumberAxis();
    final CategoryAxis yAxis = new CategoryAxis();

    @FXML
    private PieChart pie_chart;

    @FXML
    public void TimeDisplay() {
        Date date = new Date();
        do {
            showTime.setText(date.toString());
        } while (0 == 0);

    }
    Connection connection;

    public HomeController() throws SQLException {
        connection = (Connection) ConnectDB.conDB();
    }

/// 
    ResultSet resultset = null;
    Double num1 = 0.0;

    PreparedStatement preparedStatement1;

    double[] numArray = new double[10];

    void CountCategories() {
        numArray[0] = 0.0;
        for (int i = 1; i <= 9; i++) {
            try {

                String query = "select COUNT(*) as numb from books where Category_id=" + i;

                resultset = connection.createStatement().executeQuery(query);
                //resultset = connection.dbExecuteQuery(query);

                while (resultset.next()) {
                    String numb1 = resultset.getString("numb");
                    numArray[i] = Double.valueOf(numb1.trim()).doubleValue();
                }

            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CountCategories();
      //  CountCategoriesNumb();
        //PIE CHART
        PieChart.Data slice1 = new PieChart.Data("Politics", numArray[1]);
        PieChart.Data slice2 = new PieChart.Data("Science", numArray[2]);
        PieChart.Data slice3 = new PieChart.Data("Design", numArray[3]);
        PieChart.Data slice4 = new PieChart.Data("Technology", numArray[4]);
        PieChart.Data slice5 = new PieChart.Data("Business", numArray[5]);
        PieChart.Data slice6 = new PieChart.Data("Literature", numArray[6]);
        PieChart.Data slice7 = new PieChart.Data("Demography", numArray[7]);
        PieChart.Data slice8 = new PieChart.Data("Administration", numArray[8]);
        PieChart.Data slice9 = new PieChart.Data("Education", numArray[9]);

        pie_chart.getData().add(slice1);
        pie_chart.getData().add(slice2);
        pie_chart.getData().add(slice3);
        pie_chart.getData().add(slice4);
        pie_chart.getData().add(slice5);
        pie_chart.getData().add(slice6);
        pie_chart.getData().add(slice7);
        pie_chart.getData().add(slice8);
        pie_chart.getData().add(slice9);

        //BAR CHART
        final String Politics = "Politics";
        final String Science = "Science";
        final String Design = "Design";
        final String Technology = "Technology";
        final String Business = "Business";
        final String Literature = "Literature";
        final String Demography = "Demography";
        final String Administration = "Administration";
        final String Education = "Education";

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Books");
        series1.getData().add(new XYChart.Data(Politics, numArray[1]));
        series1.getData().add(new XYChart.Data(Science, numArray[2]));
        series1.getData().add(new XYChart.Data(Design, numArray[3]));
        series1.getData().add(new XYChart.Data(Technology, numArray[4]));
        series1.getData().add(new XYChart.Data(Business, numArray[5]));
        series1.getData().add(new XYChart.Data(Literature, numArray[6]));
        series1.getData().add(new XYChart.Data(Demography, numArray[7]));
        series1.getData().add(new XYChart.Data(Administration, numArray[8]));
        series1.getData().add(new XYChart.Data(Education, numArray[9]));

        bar_chart.getData().addAll(series1);

        //CLOCK
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            int second = LocalDateTime.now().getSecond();
            int minute = LocalDateTime.now().getMinute();
            int hour = LocalDateTime.now().getHour();
            showTime.setText(hour + ":" + (minute) + ":" + second);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

///
    @FXML
    private void HomeAction(ActionEvent event) {

        if (event.getSource() == btn_close) {
            System.exit(0);
        }

        //Books
        if (event.getSource() == btn1) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Books.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        //Students
        if (event.getSource() == btn3) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Students.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        //Categories
        if (event.getSource() == btn2) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Categories.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        //Borrows
        if (event.getSource() == btn4) {

            try {
                //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Borrows.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

    }

}
