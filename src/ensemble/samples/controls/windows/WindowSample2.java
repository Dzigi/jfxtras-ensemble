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
package ensemble.samples.controls.windows;

import ensemble.Sample;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.MinimizeIcon;
import jfxtras.labs.scene.control.window.RotateIcon;
import jfxtras.labs.scene.control.window.Window;
import jfxtras.labs.scene.control.window.WindowIcon;

/**
 * Internal Window node. This Control can be used to create MDI like
 * applications and is intended to be a replacement for Swings JInternalFrame.
 *
 * @see jfxtras.labs.scene.control.window.Window
 * @see jfxtras.labs.scene.control.window.WindowIcon
 */
public class WindowSample2 extends Sample {

    private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

    public WindowSample2() {
        super(600, 500);

        // create a window with title "My Window"
        final Window w = new Window("My Window");

        // set the window position to 10,10 (coordinates inside canvas)
        w.setLayoutX(10);
        w.setLayoutY(10);

        // define the initial window size
        w.setPrefSize(300, 200);

        // either to the left
        w.getLeftIcons().add(new CloseIcon(w));  
        w.getLeftIcons().add(new MinimizeIcon(w));
        
        // .. or to the right
        w.getRightIcons().add(new RotateIcon(w));

        // you can also add custom icons
        WindowIcon customIcon = new WindowIcon();
        customIcon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                // we add a nice scale transition
                // (it doesn't do anything useful but it is cool!)
                ScaleTransition st = new ScaleTransition(Duration.seconds(2), w);
                st.setFromX(w.getScaleX());
                st.setFromY(w.getScaleY());
                st.setToX(0.1);
                st.setToY(0.1);
                st.setAutoReverse(true);
                st.setCycleCount(2);
                st.play();
            }
        });

        // now we add our custom icon
        w.getRightIcons().add(customIcon);

        // create a media player & view
        mediaPlayer = new MediaPlayer(new Media(MEDIA_URL));
        MediaView mediaView = new MediaView(mediaPlayer);

        // volume
        Slider volumeSlider = new Slider(0.0, 1.0, 0.1);
        volumeSlider.orientationProperty().set(Orientation.VERTICAL);
        volumeSlider.tooltipProperty().set(new Tooltip("Volume"));
        volumeSlider.valueProperty().bindBidirectional(mediaPlayer.volumeProperty());
        volumeSlider.valueProperty().set(0.0);
        
        // add it as window content
        BorderPane borderPane = new BorderPane();
        w.getContentPane().getChildren().add(borderPane);
        borderPane.setCenter(mediaView);
        borderPane.setRight(volumeSlider);
        mediaView.fitWidthProperty().bind(borderPane.widthProperty().subtract(volumeSlider.widthProperty()));
        
        // add the window to the canvas
        getChildren().add(w);    
    }
    final MediaPlayer mediaPlayer;

    @Override
    public void play()
    {
        mediaPlayer.play();
    }

    @Override
    public void stop()
    {
        mediaPlayer.stop();
    }
}
