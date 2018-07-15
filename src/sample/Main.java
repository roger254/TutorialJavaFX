package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));//to load the .fxml file
        //title
        primaryStage.setTitle("JavaFx Tutorial");

        /*Load css to property
        Button button = new Button("Button 2");
        button.setStyle("-fx-background-color: #0000ff");
        */

        //ToggleButton
        ToggleButton toggleButton = new ToggleButton("Left");
        ToggleButton toggleButton1 = new ToggleButton("Right");
        ToggleButton toggleButton2 = new ToggleButton("Up");
        ToggleButton toggleButton3 = new ToggleButton("Down");
        //ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        //specify toggle group
        toggleButton.setToggleGroup(toggleGroup);
        toggleButton1.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton3.setToggleGroup(toggleGroup);

        //get selected toggle button


        //Choice box
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Choice 1");
        choiceBox.getItems().add("Choice 2");
        choiceBox.getItems().add("Choice 3");

        //ComboBox
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().add("combo1");
        comboBox.getItems().add("combo2");
        comboBox.getItems().add("combo3");
        comboBox.setEditable(true);

        //ListView
        ListView<String> listView = new ListView<>();
        //allowing multiple selections
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.getItems().add("Item 1");
        listView.getItems().add("Item 2");
        listView.getItems().add("Item 3");
        listView.setMaxHeight(100);
        //DatePicker
        DatePicker datePicker = new DatePicker();
        //Menu
        MenuItem menuItem = new MenuItem("Option 1");
        MenuItem menuItem1 = new MenuItem();
        menuItem1.setOnAction(event -> {
            Scene scene = displayImage();
            primaryStage.setTitle("Image Screen");
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        MenuItem menuItem2 = new MenuItem("Option 3");
        //Menu Button
        MenuButton menuButton = new MenuButton("Options", null, menuItem, menuItem1, menuItem2);

        //Text Field
        TextField textField = new TextField();
        textField.setText("Type text to print");

        Button button = new Button("Click me");
        button.setOnAction(event -> {
            //get selected toggle button
            ToggleButton selectedButton = (ToggleButton) toggleGroup.getSelectedToggle();
            if (selectedButton == null)
                System.out.println("No toggle button selected");
            else
                System.out.println(selectedButton);
            //print selected choice box
            if (choiceBox.getValue() == null)
                System.out.println("No choice box selected");
            else
                System.out.println(choiceBox.getValue());
            //print combo box item
            if (comboBox.getValue() == null)
                System.out.println("No combo value selected");
            else
                System.out.println(comboBox.getValue());

            //Reading from the listView
            ObservableList<String> observableList = listView.getSelectionModel().getSelectedItems();
            if (observableList == null)
                System.out.println("No List object selected");
            else {
                for (Object o : observableList)
                    System.out.println("o = " + " (" + o.toString() + ")");
            }
            //reading from date picker
            LocalDate localDate = datePicker.getValue();
            if (localDate == null)
                System.out.println("No date picked");
            else
                System.out.println(localDate);

            if (textField.getText() == null)
                System.out.println("No text entered");
            else
                System.out.println(textField.getText());
        });

        //File Chooser
        FileChooser fileChooser = new FileChooser();
        //ToolTip
        Tooltip tooltip = new Tooltip("Prints Selected Information");
        //can also a graphics
        //tooltip.setGraphic(new ImageView(""));//upload from file
        //set tooltip alignment
        tooltip.setTextAlignment(TextAlignment.RIGHT);
        Button button1 = new Button("File Chooser");
        //open dialog to choose file
        button1.setOnAction(e -> {
            fileChooser.setInitialDirectory(new File("/home/roger/Documents"));
            //add file filters
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt")
                    , new FileChooser.ExtensionFilter("PDF Files", "*.pdf")
            );
            fileChooser.showOpenDialog(primaryStage);
        });
        //set tooltip
        button.setTooltip(tooltip);
        ToolBar toolBar = new ToolBar();
        toolBar.getItems().add(button);
        //add separator
        toolBar.getItems().add(new Separator());
        toolBar.getItems().add(button1);
        toolBar.setOrientation(Orientation.HORIZONTAL);

        //adding flow pane
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(menuButton);
        flowPane.getChildren().add(toggleButton);
        flowPane.getChildren().add(toggleButton1);
        flowPane.getChildren().add(toggleButton2);
        flowPane.getChildren().add(toggleButton3);
        flowPane.getChildren().add(choiceBox);
        flowPane.setHgap(10);

        //adding flowPane to tilePane
        TilePane tilePane = new TilePane();
        tilePane.getChildren().add(flowPane);

        tilePane.setTileAlignment(Pos.TOP_LEFT);
        tilePane.setHgap(10);
        tilePane.setVgap(10);

        FlowPane bottomFlowPane = new FlowPane();
        bottomFlowPane.getChildren().add(datePicker);
        bottomFlowPane.getChildren().add(toolBar);
        bottomFlowPane.setHgap(10);
        bottomFlowPane.setOrientation(Orientation.VERTICAL); //set flow pane orientation

        //Adding GridPane
        Button button2 = new Button("Button 1");
        Button button3 = new Button("Button 2");
        Button button4 = new Button("Button 3");
        Button button5 = new Button("Button 4");
        Button button6 = new Button("Button 5");
        Button button7 = new Button("Button 6");

        GridPane gridPane = new GridPane();
        gridPane.add(button2,0,0,1,1);
        gridPane.add(button3,1,0,1,1);
        gridPane.add(button4,2,0,1,1);
        gridPane.add(button5,0,1,1,1);
        gridPane.add(button6,1,1,1,1);
        gridPane.add(button7,2,1,1,1);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //MenuBar
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu 1");
        //menu.setGraphic(new ImageView("")); //to put pics and graphics to menus
        //menu Events
        menu.setOnShowing(event -> System.out.println("Showing Menu 1"));
        menu.setOnShown(event -> System.out.println("Shown Menu 1"));
        menu.setOnHiding(event -> System.out.println("Hiding Menu 1"));
        menu.setOnHidden(event -> System.out.println("Hidden Menu 1"));

        //more menu items
        Menu subCheckMenu = new Menu("Sub Check Menu");
        //menuItem3.setGraphic(new ImageView(""));//add graphics to menu bar
        subCheckMenu.setOnAction(event -> System.out.println("Item 1 clicked"));

        //adding check menu
        CheckMenuItem checkMenuItem = new CheckMenuItem("Check this");
        subCheckMenu.getItems().add(checkMenuItem);
        MenuItem menuItem3 = new MenuItem("Extra");
        subCheckMenu.getItems().add(menuItem3);

       //adding sub menu
        Menu subMenu = new Menu("Menu 1.1");
        MenuItem menuItem11 = new MenuItem("Item 1.1.1");
        subMenu.getItems().add(menuItem11);

        menu.getItems().add(subCheckMenu);
        menu.getItems().add(new SeparatorMenuItem());//add menu separator
        menu.getItems().add(subMenu);
        menu.getItems().add(new SeparatorMenuItem());//add menu separator


        //radioMenuButtons
        RadioMenuItem radioMenuItem = new RadioMenuItem("Choice 1");
        RadioMenuItem radioMenuItem1 = new RadioMenuItem("Choice 2");
        RadioMenuItem radioMenuItem2 = new RadioMenuItem("Choice 3");
        //adding them to a toggle group
        ToggleGroup toggleGroup1 = new ToggleGroup();
        toggleGroup1.getToggles().add(radioMenuItem);
        toggleGroup1.getToggles().add(radioMenuItem1);
        toggleGroup1.getToggles().add(radioMenuItem2);
        //adding toggle group to menu
        Menu toggleMenu = new Menu("Toggle Menu");
        toggleMenu.getItems().add(radioMenuItem);
        toggleMenu.getItems().add(radioMenuItem1);
        toggleMenu.getItems().add(radioMenuItem2);
        //adding to menu
        menu.getItems().add(toggleMenu);
        menu.getItems().add(new SeparatorMenuItem());//add menu separator

        //adding custom menu item

        Menu customMenu = new Menu("Custom Item Menu");
        //custom item1  -> slider
        Slider slider = new Slider(0 ,100, 50);
        Button button8 = new Button("Custom Menu item Button");
        //add to as custom item
        CustomMenuItem customMenuItem = new CustomMenuItem();
        customMenuItem.setContent(slider);
        customMenuItem.setHideOnClick(false);
        CustomMenuItem customMenuItem1 = new CustomMenuItem();
        customMenuItem1.setContent(button8);
        customMenuItem1.setHideOnClick(false);
        // add to the custom menu
        customMenu.getItems().add(customMenuItem);
        customMenu.getItems().add(customMenuItem1);
        menu.getItems().add(customMenu);

        //new Menu
        Menu menu1 = new Menu("Charts");
        Menu pieChartMenu = new Menu("Pie Chart");
        Menu barChartMenu = new Menu("Bar Chart");
        Menu stackedBarChartMenu = new Menu("Stacked Bar Chart");
        Menu scatteredChartMenu = new Menu("Scattered Chart");
        Menu lineChartMenu = new Menu("Line Chart");
        Menu areaChartMenu = new Menu("Area Chart");
        Menu stackedAreaChartMenu = new Menu("Stacked Area Chart");
        
        CustomMenuItem pieChartButtonCMI = new CustomMenuItem();
        CustomMenuItem barChartCMI = new CustomMenuItem();
        CustomMenuItem stackedChartCMI = new CustomMenuItem();
        CustomMenuItem scatteredChartCMi = new CustomMenuItem();
        CustomMenuItem lineChartCMI = new CustomMenuItem();
        CustomMenuItem areChartCMI= new CustomMenuItem();
        CustomMenuItem stackedAreaChartCMI= new CustomMenuItem();
        
        Button openPieChart = new Button("Pie Chart");
        Button barChartBtn = new Button("Bar Chart");
        Button stackedChartBtn = new Button("Stacked Chart");
        Button scatteredChartBtn = new Button("Scattered Chart");
        Button lineChartBtn = new Button("Line Chart");
        Button areaChartBtn = new Button("Area Chart");
        Button stackedAreaChartBtn = new Button("Stacked Chart");
        
        pieChartButtonCMI.setContent(openPieChart);
        barChartCMI.setContent(barChartBtn);
        stackedChartCMI.setContent(stackedChartBtn);
        scatteredChartCMi.setContent(scatteredChartBtn);
        lineChartCMI.setContent(lineChartBtn);
        areChartCMI.setContent(areaChartBtn);
        stackedAreaChartCMI.setContent(stackedAreaChartBtn);

        pieChartMenu.getItems().add(pieChartButtonCMI);
        barChartMenu.getItems().add(barChartCMI);
        stackedBarChartMenu.getItems().add(stackedChartCMI);
        scatteredChartMenu.getItems().add(scatteredChartCMi);
        lineChartMenu.getItems().add(lineChartCMI);
        areaChartMenu.getItems().add(areChartCMI);
        stackedAreaChartMenu.getItems().add(stackedAreaChartCMI);

        menu1.getItems().add(pieChartMenu);
        menu1.getItems().add(barChartMenu);
        menu1.getItems().add(stackedBarChartMenu);
        menu1.getItems().add(scatteredChartMenu);
        menu1.getItems().add(lineChartMenu);
        menu1.getItems().add(areaChartMenu);
        menu1.getItems().add(stackedAreaChartMenu);

        openPieChart.setOnAction(event -> displayPieChart(primaryStage));
        barChartBtn.setOnAction(event -> displayBarChart(primaryStage));
        stackedChartBtn.setOnAction(event -> displayStackedChart(primaryStage));
        scatteredChartBtn.setOnAction(event -> displayScatteredChart(primaryStage));
        lineChartBtn.setOnAction(event -> displayLineChart(primaryStage));
        areaChartBtn.setOnAction(event -> displayAreaChart(primaryStage));
        stackedAreaChartBtn.setOnAction(event -> displayStackedAreaChart(primaryStage));

        //add all to menuBar
        menuBar.getMenus().add(menu);
        menuBar.getMenus().add(menu1);

        VBox defaultVBox = new VBox(menuBar, tilePane, comboBox, listView, textField, gridPane, bottomFlowPane);
        defaultVBox.getStylesheets().add("file:///home/roger/IdeaProjects/TutorialFX/src/styles/vBox.css"); //add vBox css
        flowPane.getStyleClass().add("myFlowPane");
        flowPane.setId("#myFlowPaneId");

        Scene scene = new Scene(defaultVBox, 720, 600);
        //scene.getStylesheets().add("file:///home/roger/IdeaProjects/TutorialFX/src/styles/buttonStyle.css");  //load css to scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayAreaChart(Stage primaryStage) {

        primaryStage.setTitle("Area Chart");

        //the axis
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("No of Employees");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue per employee");

        //the Area chart
        AreaChart<Number, Number> areaChart = new AreaChart<>(xAxis, yAxis);

        //adding data series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("2014");
        series.getData().add(new XYChart.Data<>(1,567));
        series.getData().add(new XYChart.Data<>(5,612));
        series.getData().add(new XYChart.Data<>(10,800));
        series.getData().add(new XYChart.Data<>(20,780));
        series.getData().add(new XYChart.Data<>(40,810));
        series.getData().add(new XYChart.Data<>(80,850));
        areaChart.getData().add(series);

        VBox vBox = new VBox(areaChart);
        Scene scene = new Scene(vBox, 400,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayScatteredChart(Stage primaryStage) {
        primaryStage.setTitle("Scattered Chart");

        //the axis
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("No of Employees");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue per employee");

        //the scattered chart
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);

        //adding data series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("2014");
        series.getData().add(new XYChart.Data<>(1,567));
        series.getData().add(new XYChart.Data<>(5,612));
        series.getData().add(new XYChart.Data<>(10,800));
        series.getData().add(new XYChart.Data<>(20,780));
        series.getData().add(new XYChart.Data<>(50,810));
        series.getData().add(new XYChart.Data<>(80,850));
        scatterChart.getData().add(series);

        VBox vBox = new VBox(scatterChart);
        Scene scene = new Scene(vBox, 400,200);
        primaryStage.setScene(scene);
    }

    private void displayBarChart(Stage primaryStage) {
        primaryStage.setTitle("Bar Chart");

        //create x axis and label it
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Devices");

        //create y axis and label it
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Visitors");

        //create bar chart and add the axis
        BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);

        //add data series and set name
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("2014");

        series.getData().add(new XYChart.Data<>("Desktop", 178));
        series.getData().add(new XYChart.Data<>("Phone", 65));
        series.getData().add(new XYChart.Data<>("Tablet", 23));

        //second data series
        XYChart.Series<String, Number>  series1 = new XYChart.Series<>();
        series1.setName("2015");

        series1.getData().add(new XYChart.Data<>("Desktop", 540));
        series1.getData().add(new XYChart.Data<>("Phone", 120));
        series1.getData().add(new XYChart.Data<>("Tablet", 36));

        //third data series
        XYChart.Series<String, Number>  series2 = new XYChart.Series<>();
        series2.setName("2016");

        series2.getData().add(new XYChart.Data<>("Desktop", 650));
        series2.getData().add(new XYChart.Data<>("Phone", 230));
        series2.getData().add(new XYChart.Data<>("Tablet", 54));

        //add to bar chart
        barChart.getData().add(series);
        barChart.getData().add(series1);
        barChart.getData().add(series2);

        VBox vBox = new VBox(barChart);
        Scene scene = new Scene(vBox, 400,200);

        primaryStage.setScene(scene);
    }

    private void displayStackedChart(Stage primaryStage){
        primaryStage.setTitle("Stacked Chart");

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Device");
        //set the x categories
        xAxis.getCategories().addAll("Desktop", "Phone", "Tablet");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Visits");

        //creating and setting the stacked bar chart
        StackedBarChart<String,Number> stackedBarChart = new StackedBarChart<>(xAxis, yAxis);

        //adding data series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Desktop");
        series.getData().add(new XYChart.Data<>("2014", 567));
        series.getData().add(new XYChart.Data<>("2015", 540));

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Phone");
        series1.getData().add(new XYChart.Data<>("2014", 65));
        series1.getData().add(new XYChart.Data<>("2015", 120));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Tablet");
        series2.getData().add(new XYChart.Data<>("2014", 23));
        series2.getData().add(new XYChart.Data<>("2015", 36));

        //add all to stacked bar chart
        stackedBarChart.getData().addAll(series);
        stackedBarChart.getData().addAll(series1);
        stackedBarChart.getData().addAll(series2);

        VBox vBox = new VBox(stackedBarChart);
        Scene scene = new Scene(vBox, 400,200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayLineChart(Stage primaryStage){

        primaryStage.setTitle("Line Chart");

        //the axis
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("No of Employees");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue per employee");

        //the Line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        //adding data series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("2014");
        series.getData().add(new XYChart.Data<>(1,567));
        series.getData().add(new XYChart.Data<>(5,612));
        series.getData().add(new XYChart.Data<>(10,800));
        series.getData().add(new XYChart.Data<>(20,780));
        series.getData().add(new XYChart.Data<>(40,810));
        series.getData().add(new XYChart.Data<>(80,850));
        lineChart.getData().add(series);

        VBox vBox = new VBox(lineChart);
        Scene scene = new Scene(vBox, 400,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayStackedAreaChart(Stage primaryStage){

        primaryStage.setTitle("Stacked Area Chart");

        //the axis
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("7 Day interval");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Visits");

        //the Stacked Area chart
        StackedAreaChart<Number, Number> stackedAreaChart = new StackedAreaChart<>(xAxis, yAxis);

        //adding data series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Desktop");

        series.getData().add(new XYChart.Data<>(0,567));
        series.getData().add(new XYChart.Data<>(1,612));
        series.getData().add(new XYChart.Data<>(2,800));
        series.getData().add(new XYChart.Data<>(3,780));
        series.getData().add(new XYChart.Data<>(4,650));
        series.getData().add(new XYChart.Data<>(5,610));
        series.getData().add(new XYChart.Data<>(6,590));
        stackedAreaChart.getData().add(series);

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("Mobile");

        series1.getData().add(new XYChart.Data<>(0,101));
        series1.getData().add(new XYChart.Data<>(1,110));
        series1.getData().add(new XYChart.Data<>(2,140));
        series1.getData().add(new XYChart.Data<>(3,132));
        series1.getData().add(new XYChart.Data<>(4,115));
        series1.getData().add(new XYChart.Data<>(5,109));
        series1.getData().add(new XYChart.Data<>(6,105));
        stackedAreaChart.getData().add(series1);

        VBox vBox = new VBox(stackedAreaChart);
        Scene scene = new Scene(vBox, 400,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayPieChart(Stage primaryStage) {

        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("Desktop", 213);
        PieChart.Data slice2 = new PieChart.Data("Phone", 67);
        PieChart.Data slice3 = new PieChart.Data("Tablet", 36);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);

        VBox vBox = new VBox(pieChart);

        Scene scene = new Scene(vBox, 400,200);

        primaryStage.setTitle("Pie Chart Page");
        primaryStage.setScene(scene);
      //  primaryStage.setHeight(300);
       // primaryStage.setWidth(1200);

        primaryStage.show();
    }

    private Scene displayImage() {
        //Load imageViewer
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("/home/roger/IdeaProjects/TutorialFX/src/resources/lamp.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(Objects.requireNonNull(inputStream));
        ImageView imageView = new ImageView(image);

        /* Image on a layout component
        HBox hBox = new HBox(imageView);
        Scene scene = new Scene(hBox, 720,720);
        */
        Label label = new Label("Image label", imageView);
        Button button = new Button();
        button.setMnemonicParsing(true);
        button.setText("_Show Name");
        final boolean[] change = {true};
        button.setOnAction(event -> {
            if (change[0]) {
                label.setText("DIY Lamp image");
                imageView.setVisible(true);
                button.getStylesheets().add("file:///home/roger/IdeaProjects/TutorialFX/src/styles/buttonStyle.css");
                change[0] = false;
            } else {
                label.setText("Image Label");
                imageView.setVisible(false);
                change[0] = true;
            }
        });
        HBox hBox = new HBox(20, button, label);
        return new Scene(hBox, 720, 600);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
