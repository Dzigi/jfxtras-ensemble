/*
 * Copyright (c) 2012, JFXtras
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *       * Redistributions of source code must retain the above copyright
 *         notice, this list of conditions and the following disclaimer.
 *       * Redistributions in binary form must reproduce the above copyright
 *         notice, this list of conditions and the following disclaimer in the
 *         documentation and/or other materials provided with the distribution.
 *       * Neither the name of the <organization> nor the
 *         names of its contributors may be used to endorse or promote products
 *         derived from this software without specific prior written permission.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 *   DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
 * BigDecimalField is TextField that holds arbitrary formatted BigDecimal
 * values. The value can either be edited by hand or increased/decreased with
 * the two buttons or the arrow up/down keys. The control can be stlyled with
 * CSS like a normal TextField.
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

        final ChoiceBox styles = new ChoiceBox(FXCollections.observableArrayList("rectangular corners - small font", "rounded corners - medium font", "leaf corners - large font"));
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
