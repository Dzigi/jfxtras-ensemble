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
package ensemble.samples.gauges.clock;

import ensemble.Sample;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import jfxtras.labs.scene.control.gauge.Clock;
import jfxtras.labs.scene.control.gauge.ClockBuilder;


/**
 * Clock.
 *
 * @see jxftras.labs.scene.control.gauge.Clock
 */
public class ClockGaugesSample  extends Sample {

    public ClockGaugesSample() {
        super(600, 600);

        // Create some controls
        Clock clockPst = ClockBuilder.create().title("San Francisco").timeZone("US/Pacific").clockStyle(Clock.ClockStyle.IOS6).autoDimEnabled(true).running(true).build();
        Clock clockEst = ClockBuilder.create().title("New York").timeZone("EST").clockStyle(Clock.ClockStyle.IOS6).autoDimEnabled(true).running(true).build();
        Clock clockCet = ClockBuilder.create().title("Berlin").timeZone("CET").autoDimEnabled(true).running(true).build();
        Clock clockNz  = ClockBuilder.create().title("Wellington").timeZone("NZ").autoDimEnabled(true).running(true).build();

        // Layout
        HBox row1 = new HBox();
        row1.getChildren().addAll(clockPst, clockEst);
        HBox row2 = new HBox();
        row2.getChildren().addAll(clockCet, clockNz);


        VBox pane = new VBox();
        pane.getChildren().addAll(row1, row2);

        getChildren().add(pane);
    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }
}