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
package ensemble.samples.controls.radialmenu;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.FadeTransition;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.RotateEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.FontBuilder;
import javafx.util.Duration;
import jfxtras.labs.scene.control.radialmenu.RadialContainerMenuItem;
import jfxtras.labs.scene.control.radialmenu.RadialMenu;
import jfxtras.labs.scene.control.radialmenu.RadialMenuItem;
import ensemble.Sample;

/**
 * RadialMenu is a menu that presents its item in a radial layout. This type of
 * menu is indicated in case of contextual menu in a touch environment. Use
 * Right click to show the radial menu at the clicked position. Left click will
 * hide your radial menu.
 * 
 * @see jfxtras.labs.scene.control.RadialMenu
 * @see jfxtras.labs.scene.control.RadialMenuItem
 */
public class RadialMenuSample extends Sample {

    protected RadialMenu radialMenu;
    protected Label actionPerformedLabel = new Label();
    protected boolean show;
    protected double lastOffsetValue;
    protected double lastInitialAngleValue;
    private double gestureAngle = 0;
    private Slider initialAngleSlider;
    private FadeTransition textFadeTransition;

    public RadialMenuSample() {
	super(600, 600);
	this.setOnMouseClicked(new EventHandler<MouseEvent>() {

	    @Override
	    public void handle(final MouseEvent event) {
		if (event.getButton() == MouseButton.SECONDARY) {
		    RadialMenuSample.this.showRadialMenu(event.getX(),
			    event.getY());
		} else {
		    RadialMenuSample.this.lastInitialAngleValue = RadialMenuSample.this.radialMenu
			    .getInitialAngle();
		    RadialMenuSample.this.lastOffsetValue = RadialMenuSample.this.radialMenu
			    .getOffset();

		    if (!event.isConsumed()) {
			RadialMenuSample.this.hideRadialMenu();
		    }
		}
	    }

	});
	this.setOnRotationStarted(new EventHandler<RotateEvent>() {
	    @Override
	    public void handle(final RotateEvent event) {
		RadialMenuSample.this.gestureAngle = RadialMenuSample.this.initialAngleSlider
			.getValue();
	    }
	});

	this.setOnRotationFinished(new EventHandler<RotateEvent>() {
	    @Override
	    public void handle(final RotateEvent event) {
		RadialMenuSample.this.gestureAngle = RadialMenuSample.this.initialAngleSlider
			.getValue();
	    }
	});

	this.setOnRotate(new EventHandler<RotateEvent>() {
	    @Override
	    public void handle(final RotateEvent event) {
		final boolean clockwise = RadialMenuSample.this.radialMenu
			.isClockwise();
		RadialMenuSample.this.initialAngleSlider
			.setValue(RadialMenuSample.this.gestureAngle
				+ (clockwise ? event.getTotalAngle() : -event
					.getTotalAngle()));
	    }
	});

	this.actionPerformedLabel
		.setFont(FontBuilder.create().size(28).build());
	this.actionPerformedLabel.translateXProperty().bind(
		this.widthProperty()
			.multiply(0.5)
			.subtract(
				this.actionPerformedLabel.widthProperty()
					.multiply(0.5)));
	this.actionPerformedLabel.setTranslateY(50);

	this.getChildren().add(this.createRadialMenu());
	this.getChildren().add(this.actionPerformedLabel);
	// this.getChildren().add(this.createRadialMenuModifierControls());

    }

    // private void hideRadialMenu() {
    // this.lastInitialAngleValue = this.radialMenu.getInitialAngle();
    // this.lastOffsetValue = this.radialMenu.getOffset();
    //
    // final FadeTransition fade = FadeTransitionBuilder.create()
    // .node(this.radialMenu).fromValue(1).toValue(0)
    // .duration(Duration.millis(300))
    // .onFinished(new EventHandler<ActionEvent>() {
    //
    // @Override
    // public void handle(final ActionEvent arg0) {
    // RadialMenuSample.this.radialMenu.setVisible(false);
    // }
    // }).build();
    //
    // final ParallelTransition transition = ParallelTransitionBuilder
    // .create().children(fade).build();
    //
    // transition.play();
    // }

    private void hideRadialMenu() {
	final FadeTransition fade = FadeTransitionBuilder.create()
		.node(RadialMenuSample.this.radialMenu).fromValue(1).toValue(0)
		.duration(Duration.millis(300))
		.onFinished(new EventHandler<ActionEvent>() {

		    @Override
		    public void handle(final ActionEvent arg0) {
			RadialMenuSample.this.radialMenu.setVisible(false);
		    }
		}).build();

	final ParallelTransition transition = ParallelTransitionBuilder
		.create().children(fade).build();

	transition.play();
    }

    private void showRadialMenu(final double x, final double y) {
	if (this.radialMenu.isVisible()) {
	    this.lastInitialAngleValue = this.radialMenu.getInitialAngle();
	    this.lastOffsetValue = this.radialMenu.getOffset();
	    this.radialMenu.setVisible(false);
	}
	this.radialMenu.setTranslateX(x);
	this.radialMenu.setTranslateY(y);
	this.radialMenu.setVisible(true);

	final FadeTransition fade = FadeTransitionBuilder.create()
		.node(this.radialMenu).duration(Duration.millis(400))
		.fromValue(0).toValue(1.0).build();

	final Animation offset = new Timeline(new KeyFrame(Duration.ZERO,
		new KeyValue(this.radialMenu.offsetProperty(), 0)),
		new KeyFrame(Duration.millis(300), new KeyValue(this.radialMenu
			.offsetProperty(), this.lastOffsetValue)));

	final Animation angle = new Timeline(new KeyFrame(Duration.ZERO,
		new KeyValue(this.radialMenu.initialAngleProperty(),
			this.lastInitialAngleValue + 20)), new KeyFrame(
		Duration.millis(300), new KeyValue(
			this.radialMenu.initialAngleProperty(),
			this.lastInitialAngleValue)));

	final ParallelTransition transition = ParallelTransitionBuilder
		.create().children(fade, offset, angle).build();

	transition.play();
    }

    // public Node createControlNodes() {
    //
    // final GridPane controls = new GridPane();
    // controls.setVgap(15);
    //
    // this.initialAngleSlider = SliderBuilder.create().min(-360).max(360)
    // .value(-23).minWidth(200).majorTickUnit(30)
    // .showTickLabels(true).build();
    //
    // this.radialMenu.initialAngleProperty().bindBidirectional(
    // this.initialAngleSlider.valueProperty());
    //
    // controls.add(LabelBuilder.create().text("initial angle ").build(), 0, 1);
    // controls.add(this.initialAngleSlider, 1, 1);
    //
    // final Slider innerRadiusSlider = SliderBuilder.create().min(0).max(300)
    // .value(30).minWidth(200).majorTickUnit(30).showTickLabels(true)
    // .build();
    //
    // this.radialMenu.innerRadiusProperty().bindBidirectional(
    // innerRadiusSlider.valueProperty());
    //
    // controls.add(LabelBuilder.create().text("inner radius ").build(), 0, 3);
    // controls.add(innerRadiusSlider, 1, 3);
    //
    // final Slider radiusSlider = SliderBuilder.create().min(100).max(500)
    // .value(100).minWidth(200).majorTickUnit(30)
    // .showTickLabels(true).build();
    //
    // this.radialMenu.radiusProperty().bind(radiusSlider.valueProperty());
    //
    // controls.add(LabelBuilder.create().text("radius ").build(), 0, 4);
    // controls.add(radiusSlider, 1, 4);
    //
    // final Slider offsetSlider = SliderBuilder.create().min(0).max(100)
    // .value(10).minWidth(200).majorTickUnit(30).showTickLabels(true)
    // .build();
    //
    // this.radialMenu.offsetProperty().bindBidirectional(
    // offsetSlider.valueProperty());
    //
    // controls.add(LabelBuilder.create().text("offset ").build(), 0, 5);
    // controls.add(offsetSlider, 1, 5);
    //
    // final ColorPicker colorPicker = ColorPickerBuilder.create()
    // .value(Color.LIGHTBLUE).build();
    //
    // colorPicker.setOnAction(new EventHandler<ActionEvent>() {
    // @Override
    // public void handle(final ActionEvent t) {
    // RadialMenuSample.this.radialMenu.setBackgroundColor(colorPicker
    // .getValue());
    // }
    // });
    //
    // controls.add(LabelBuilder.create().text("backgroundColor ").build(), 0,
    // 6);
    // controls.add(colorPicker, 1, 6);
    //
    // final ColorPicker backgroundMouseOnPicker = ColorPickerBuilder.create()
    // .value(Color.LIGHTBLUE.darker()).build();
    //
    // backgroundMouseOnPicker.setOnAction(new EventHandler<ActionEvent>() {
    // @Override
    // public void handle(final ActionEvent t) {
    // RadialMenuSample.this.radialMenu
    // .setBackgroundMouseOnColor(backgroundMouseOnPicker
    // .getValue());
    // }
    // });
    //
    // controls.add(LabelBuilder.create().text("background mouse on Color ")
    // .build(), 0, 7);
    // controls.add(backgroundMouseOnPicker, 1, 7);
    //
    // final ColorPicker strokePicker = ColorPickerBuilder.create()
    // .value(Color.DARKBLUE).build();
    //
    // strokePicker.setOnAction(new EventHandler<ActionEvent>() {
    // @Override
    // public void handle(final ActionEvent t) {
    // RadialMenuSample.this.radialMenu.setStrokeColor(strokePicker
    // .getValue());
    // }
    // });
    //
    // controls.add(LabelBuilder.create().text("stroke Color ").build(), 0, 8);
    // controls.add(strokePicker, 1, 8);
    //
    // final CheckBox clockwiseCheckBox = CheckBoxBuilder.create()
    // .selected(false).build();
    //
    // this.radialMenu.clockwiseProperty().bindBidirectional(
    // clockwiseCheckBox.selectedProperty());
    //
    // controls.add(LabelBuilder.create().text("clockwise ").build(), 0, 9);
    // controls.add(clockwiseCheckBox, 1, 9);
    //
    // final CheckBox backgroundVisibleCheckBox = CheckBoxBuilder.create()
    // .selected(true).build();
    //
    // this.radialMenu.backgroundVisibleProperty().bindBidirectional(
    // backgroundVisibleCheckBox.selectedProperty());
    //
    // controls.add(LabelBuilder.create().text("background visible ").build(),
    // 0, 10);
    // controls.add(backgroundVisibleCheckBox, 1, 10);
    //
    // final CheckBox strokeVisibleCheckBox = CheckBoxBuilder.create()
    // .selected(true).build();
    //
    // this.radialMenu.strokeVisibleProperty().bindBidirectional(
    // strokeVisibleCheckBox.selectedProperty());
    //
    // controls.add(LabelBuilder.create().text("stroke visible ").build(), 0,
    // 11);
    // controls.add(strokeVisibleCheckBox, 1, 11);
    //
    // controls.translateXProperty().set(400);
    // controls.translateYProperty().set(0);
    //
    // return controls;
    // }

    public Node createRadialMenu() {
	this.radialMenu = new RadialMenu(-23, 30, 100, 10, Color.LIGHTBLUE,
		Color.LIGHTBLUE.darker(), Color.DARKBLUE, false);

	this.radialMenu.setTranslateX(200);
	this.radialMenu.setTranslateY(200);

	final ImageView play = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSamplePlayIcon.png"))).build();

	final ImageView stop = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSampleStopIcon.png"))).build();
	final ImageView pause = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSamplePauseIcon.png"))).build();

	final ImageView forward = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSampleForwardIcon.png"))).build();

	final ImageView backward = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSampleBackwardIcon.png"))).build();

	final EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {

	    @Override
	    public synchronized void handle(final ActionEvent paramT) {
		final RadialMenuItem item = (RadialMenuItem) paramT.getSource();
		if (RadialMenuSample.this.textFadeTransition != null
			&& RadialMenuSample.this.textFadeTransition.getStatus() != Status.STOPPED) {
		    RadialMenuSample.this.textFadeTransition.stop();
		    RadialMenuSample.this.actionPerformedLabel.setOpacity(1.0);
		}
		RadialMenuSample.this.actionPerformedLabel.setText(item
			.getText());
		RadialMenuSample.this.actionPerformedLabel.setVisible(true);
		RadialMenuSample.this.textFadeTransition = FadeTransitionBuilder
			.create()
			.node(RadialMenuSample.this.actionPerformedLabel)
			.delay(Duration.seconds(1))
			.duration(Duration.millis(400)).fromValue(1.0)
			.toValue(0).onFinished(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(final ActionEvent paramT) {
				RadialMenuSample.this.actionPerformedLabel
					.setVisible(false);
				RadialMenuSample.this.actionPerformedLabel
					.setOpacity(1.0);
			    }
			}).build();
		RadialMenuSample.this.textFadeTransition.play();
	    }

	};

	final ImageView fiveSec = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSample5SecIcon.png"))).build();
	final ImageView tenSec = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSample10SecIcon.png"))).build();
	final ImageView twentySec = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSample20SecIcon.png"))).build();
	final RadialContainerMenuItem forwardItem = new RadialContainerMenuItem(
		45, "forward", forward);
	forwardItem.addMenuItem(new RadialMenuItem(30, "forward 5'", fiveSec,
		handler));
	forwardItem.addMenuItem(new RadialMenuItem(30, "forward 10'", tenSec,
		handler));
	forwardItem.addMenuItem(new RadialMenuItem(30, "forward 20'",
		twentySec, handler));

	this.radialMenu.addMenuItem(forwardItem);

	this.radialMenu.addMenuItem(new RadialMenuItem(45, "pause", pause,
		handler));

	this.radialMenu.addMenuItem(new RadialMenuItem(45, "play", play,
		handler));

	this.radialMenu.addMenuItem(new RadialMenuItem(45, "stop", stop,
		handler));

	final RadialContainerMenuItem backwardItem = new RadialContainerMenuItem(
		45, "backward", backward);
	final ImageView fiveSecBack = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSample5SecIcon.png"))).build();
	final ImageView tenSecBack = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSample10SecIcon.png"))).build();
	final ImageView twentySecBack = ImageViewBuilder
		.create()
		.image(new Image(this.getClass().getResourceAsStream(
			"RadialMenuSample20SecIcon.png"))).build();
	backwardItem.addMenuItem(new RadialMenuItem(30, "backward 5'",
		fiveSecBack, handler));
	backwardItem.addMenuItem(new RadialMenuItem(30, "bacward 10'",
		tenSecBack, handler));
	backwardItem.addMenuItem(new RadialMenuItem(30, "bacward 20'",
		twentySecBack, handler));

	this.radialMenu.addMenuItem(backwardItem);

	return this.radialMenu;
    }
}
