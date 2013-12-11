
package com.example.nativeegl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author b576. Created Dec 11, 2013.
 */
public class SmoothColorRect extends Rectangle {
    private static float gColors[] = {
            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 1.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f,

            1.0f, 0.0f, 0.0f, 1.0f,
            /*
             * 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f,
             * 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f,
             * 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f,
             */
    };

    private FloatBuffer gColorBuffer;

    /**
     * TODO Put here a description of what this constructor does.
     */
    public SmoothColorRect() {
        // TODO Auto-generated constructor stub.
        super();
        ByteBuffer cbb = ByteBuffer.allocateDirect(this.gColors.length * 4);
        cbb.order(ByteOrder.nativeOrder());
        this.gColorBuffer = cbb.asFloatBuffer();
        this.gColorBuffer.put(this.gColors);
        this.gColorBuffer.position(0);
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(gl.GL_COLOR_ARRAY);
        gl.glColorPointer(4, gl.GL_FLOAT, 0, this.gColorBuffer);
        super.draw(gl);
        gl.glDisableClientState(gl.GL_COLOR_ARRAY);
    }
}
