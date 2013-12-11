package com.example.nativeegl;

import javax.microedition.khronos.opengles.GL10;

/**
 * TODO Put here a description of what this class does.
 *
 * @author b576.
 *         Created Dec 11, 2013.
 */
public class FlatColorRectangle extends Rectangle {
    
    /**
     * TODO Put here a description of what this constructor does.
     *
     */
    public FlatColorRectangle() {
        // TODO Auto-generated constructor stub.
        super();
    }
    
    public void draw(GL10 gl){
        gl.glColor4f(0.5f,0.5f,1.0f,1.0f);
        super.draw(gl);
    }

}
