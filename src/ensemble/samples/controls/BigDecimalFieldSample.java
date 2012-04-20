package ensemble.samples.controls;

import ensemble.Sample;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.layout.GridPane;
import jfxtras.labs.scene.control.BigDecimalField;

/**
 * BigDecimalField is a TextField that holds arbitrary formatted BigDecimal
 * values. The value can either be edited by hand or increased/decreased with
 * the two buttons or the arrow up/down keys.
 *
 * @see jfxtras.labs.scene.control.BigDecimalField
 */
public class BigDecimalFieldSample extends Sample {

    public BigDecimalFieldSample() {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        final BigDecimalField defaultSpinner = new BigDecimalField();
        defaultSpinner.getStyleClass().add("bigDecimalField");
        final BigDecimalField decimalFormat = new BigDecimalField(BigDecimal.ZERO, new BigDecimal("0.05"), new DecimalFormat("#,##0.00"));
        decimalFormat.getStyleClass().add("bigDecimalField");
        final BigDecimalField percent = new BigDecimalField(BigDecimal.ZERO, new BigDecimal("0.01"), NumberFormat.getPercentInstance());
        percent.getStyleClass().add("bigDecimalField");
        final BigDecimalField localizedCurrency = new BigDecimalField(BigDecimal.ZERO, new BigDecimal("0.01"), NumberFormat.getCurrencyInstance(Locale.UK));
        localizedCurrency.getStyleClass().add("bigDecimalField");
        root.addRow(1, new Label("default"), defaultSpinner);
        root.addRow(2, new Label("custom decimal format"), decimalFormat);
        root.addRow(3, new Label("percent"), percent);
        root.addRow(4, new Label("localized currency"), localizedCurrency);
        root.addRow(5, new Label("normal TextField"), TextFieldBuilder.create().text("1.000,12").styleClass("bigDecimalField").build());

        // TODO: Fix unwanted resizing behaviour.
        final ChoiceBox styles = new ChoiceBox(FXCollections.observableArrayList("squared", "rounded", "leaf"));
        styles.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                System.out.println("index" + arg2.intValue());
                Scene scene = styles.getScene();
                String pathSquared = BigDecimalFieldSample.class.getResource("BigDecimalField_squared.css").toExternalForm();
                String pathRounded = BigDecimalFieldSample.class.getResource("BigDecimalField_rounded.css").toExternalForm();
                String pathLeaf = BigDecimalFieldSample.class.getResource("BigDecimalField_leaf.css").toExternalForm();
                scene.getStylesheets().removeAll(pathSquared, pathRounded, pathLeaf);
                if (arg2.intValue() == 0) {
                    scene.getStylesheets().add(pathSquared);
                }
                if (arg2.intValue() == 1) {
                    scene.getStylesheets().add(pathRounded);
                }
                if (arg2.intValue() == 2) {
                    scene.getStylesheets().add(pathLeaf);
                }
            }
        });
        root.addRow(6, new Label("change css"), styles);
        
        Button button = new Button("Reset fields");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                defaultSpinner.setNumber(new BigDecimal(Math.random() * 1000));
                decimalFormat.setNumber(new BigDecimal(Math.random() * 1000));
                percent.setNumber(new BigDecimal(Math.random()));
                localizedCurrency.setNumber(new BigDecimal(Math.random() * 1000));
//                disabledField.setNumber(new BigDecimal(Math.random() * 1000));
            }
        });
        root.addRow(7, new Label(), button);

        getChildren().add(root);
    }
}
