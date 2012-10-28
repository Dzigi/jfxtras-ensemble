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
import javafx.scene.control.Label;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.MinimizeIcon;
import jfxtras.labs.scene.control.window.Window;

/**
 * Internal Window node. This Control can be used to create MDI like
 * applications and is intended to be a replacement for Swings 
 * JInternalFrame.
 * 
 * @see jfxtras.labs.scene.control.window.Window
 * @see jfxtras.labs.scene.control.window.WindowIcon
 */
public class WindowSample1 extends Sample {

    public WindowSample1() {
	super(600, 500);
	
        // create a window with title "My Window"
        Window w = new Window("My Window");
        
        // set the window position to 10,10 (coordinates inside canvas)
        w.setLayoutX(10);
        w.setLayoutY(10);
        
        // define the initial window size
        w.setPrefSize(300, 200);
        
         // either to the left
        w.getLeftIcons().add(new CloseIcon(w));
        
        // .. or to the right
        w.getRightIcons().add(new MinimizeIcon(w));
        
        // add some content
        w.getContentPane().getChildren().add(new Label("Content"));

        // add the window to the canvas
        getChildren().add(w);
    }
  
}
