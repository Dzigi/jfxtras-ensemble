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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import jfxtras.labs.scene.control.CalendarTimePicker;
import ensemble.Sample;

/**
 * A time picker which (to align with the CalendarPicker) set the value of the hours and minutes in a Calendar.
 *
 * @see jfxtras.labs.scene.control.CalendarTimerPicker
 */
public class CalendarTimePickerSample1 extends Sample {

    public CalendarTimePickerSample1() {
        super(300, 300);

        GridPane lGridPane = new GridPane();
        lGridPane.setVgap(10);
        getChildren().add(lGridPane);
        int lRowIdx = 0;

        {
	        final CalendarTimePicker lCalendarTimePicker = new CalendarTimePicker();
	        lGridPane.add(lCalendarTimePicker, 0, lRowIdx, 2, 1);
	        lRowIdx++;

	        ComboBox<String> lComboBox = new ComboBox<String>(FXCollections.observableArrayList("Hide", "Show"));
	        lComboBox.valueProperty().addListener(new ChangeListener<String>()
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue)
                    {
                            if (newValue.startsWith("S")) lCalendarTimePicker.setShowLabels(true);
                            if (newValue.startsWith("H")) lCalendarTimePicker.setShowLabels(false);
                    }
                });
	        lComboBox.setValue("Hide");
	        lComboBox.setPrefWidth(200); 
	        lGridPane.add(new Label("Labels:"), 0, lRowIdx);
	        lGridPane.add(lComboBox, 1, lRowIdx);
	        lRowIdx++;
        }
    }
}
