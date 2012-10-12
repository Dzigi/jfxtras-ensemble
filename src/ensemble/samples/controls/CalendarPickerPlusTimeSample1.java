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
import javafx.scene.shape.Line;
import jfxtras.labs.scene.control.CalendarPicker;
import ensemble.Sample;

/**
 * CalendarPicker.
 * The coder is responsible for the background (in this way the picker does not enforce a certain styling).
 *
 * @see jfxtras.labs.scene.control.CalendarPicker
 */

public class CalendarPickerPlusTimeSample1 extends Sample {

    public CalendarPickerPlusTimeSample1() {
        super(300, 300);

        GridPane lGridPane = new GridPane();
        getChildren().add(lGridPane);
        int lRowIdx = 0;

        {
	        final CalendarPicker lCalendarPicker = new CalendarPicker();
                lCalendarPicker.showTimeProperty().set(Boolean.TRUE);
	        lGridPane.add(lCalendarPicker, 0, lRowIdx, 2, 1);
	        lRowIdx++;
	
//	        ComboBox<String> lComboBox = new ComboBox<String>(FXCollections.observableArrayList("Single", "Range", "Multiple"));
//	        lComboBox.valueProperty().addListener(new ChangeListener<String>()
//                {
//                    @Override
//                    public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue)
//                    {
//                            if (newValue.startsWith("S")) lCalendarPicker.setMode(CalendarPicker.Mode.SINGLE);
//                            if (newValue.startsWith("R")) lCalendarPicker.setMode(CalendarPicker.Mode.RANGE);
//                            if (newValue.startsWith("M")) lCalendarPicker.setMode(CalendarPicker.Mode.MULTIPLE);
//                    }
//                });
//	        lComboBox.setValue("Single");
//	        lComboBox.setPrefWidth(200); 
//	        lGridPane.add(new Label("Mode:"), 0, lRowIdx);
//	        lGridPane.add(lComboBox, 1, lRowIdx);
//	        lRowIdx++;
        }
    }
}
