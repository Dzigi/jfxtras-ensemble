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
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.FlowPaneBuilder;
import jfxtras.labs.scene.control.MiniIconButton;

/**
 * MiniIconButton is a standard button with an extra mini-icon. This icon
 * is used to catch the users attention. To increase the attention the
 * icon can be animated (jump up and down or blink).
 *
 * @see jfxtras.labs.scene.control.MiniIconButton
 */
public class MiniIconButtonSample extends Sample {

    final Image bigIcon = new Image(getClass().getResourceAsStream("/ensemble/images/icon-48x48.png"));
    final Image mediumIcon = new Image(getClass().getResourceAsStream("/ensemble/images/settings.png"));
    final Image smallIcon = new Image(getClass().getResourceAsStream("/ensemble/images/search-clear-over.png"));

    public MiniIconButtonSample() {


        // default values
        // ----------------------------
        // ratio: 0.25
        // Pos.TOP_RIGHT
        // animation duration: 500 ms
        final MiniIconButton b1 = new MiniIconButton(new ImageView(bigIcon), new ImageView(smallIcon));
        b1.setAnimationType(MiniIconButton.AnimationType.BLINK);


        // default values
        // ----------------------------
        // ratio: 0.25
        // Pos.TOP_RIGHT
        // animation duration: 500 ms
        final MiniIconButton b2 = new MiniIconButton("2. Button", new ImageView(bigIcon), new ImageView(smallIcon));
        b2.setAnimationType(MiniIconButton.AnimationType.JUMP);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // Pos.TOP_RIGHT
        final MiniIconButton b3 = new MiniIconButton("3. Button", new ImageView(bigIcon), new ImageView(smallIcon));
        b3.setMiniIconRatio(0.1);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // Pos.TOP_RIGHT
        final MiniIconButton b4 = new MiniIconButton("4. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b4.setMiniIconRatio(1.0);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // Pos.TOP_RIGHT
        final MiniIconButton b5 = new MiniIconButton("5. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b5.setMiniIconRatio(0.25); // default


        // default values
        // ----------------------------
        // AnimationType.NONE
        // Pos.TOP_RIGHT
        final MiniIconButton b6 = new MiniIconButton("6. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b6.setMiniIconRatio(0.1);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // ratio: 0.25
        final MiniIconButton b7 = new MiniIconButton("7. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b7.setMiniIconPosition(Pos.TOP_LEFT);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // ratio: 0.25
        final MiniIconButton b8 = new MiniIconButton("8. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b8.setMiniIconPosition(Pos.TOP_CENTER);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // ratio: 0.25
        final MiniIconButton b9 = new MiniIconButton("9. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b9.setMiniIconPosition(Pos.TOP_RIGHT);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // ratio: 0.25
        final MiniIconButton b10 = new MiniIconButton("10. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b10.setMiniIconPosition(Pos.CENTER_LEFT);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // ratio: 0.25
        final MiniIconButton b11 = new MiniIconButton("11. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b11.setMiniIconPosition(Pos.CENTER);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // ratio: 0.25
        final MiniIconButton b12 = new MiniIconButton("12. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b12.setMiniIconPosition(Pos.CENTER_RIGHT);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // ratio: 0.25
        final MiniIconButton b13 = new MiniIconButton("13. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b13.setMiniIconPosition(Pos.BOTTOM_LEFT);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // ratio: 0.25
        final MiniIconButton b14 = new MiniIconButton("14. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b14.setMiniIconPosition(Pos.BOTTOM_CENTER);


        // default values
        // ----------------------------
        // AnimationType.NONE
        // ratio: 0.25
        final MiniIconButton b15 = new MiniIconButton("14. Button", new ImageView(bigIcon), new ImageView(mediumIcon));
        b15.setMiniIconPosition(Pos.BOTTOM_RIGHT);


        // default values
        // ----------------------------
        // Pos.TOP_RIGHT
        // ratio: 0.25
        final MiniIconButton b16 = new MiniIconButton(new ImageView(bigIcon), new ImageView(mediumIcon));
        b16.setAnimationDuration(800);
        b16.setAnimationType(MiniIconButton.AnimationType.BLINK);

        // default values
        // ----------------------------
        // Pos.TOP_RIGHT
        // ratio: 0.25
        final MiniIconButton b17 = new MiniIconButton(new ImageView(bigIcon), new ImageView(mediumIcon));
        b17.setAnimationDuration(200);
        b17.setAnimationType(MiniIconButton.AnimationType.JUMP);


        final FlowPane rootPane = FlowPaneBuilder
                .create()
                .children(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17)
                .hgap(20).vgap(20)
                .build();
        this.getChildren().add(rootPane);
    }
}
