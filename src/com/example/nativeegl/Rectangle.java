
package com.example.nativeegl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author b576. Created Dec 6, 2013.
 */
public class Rectangle {
    private FloatBuffer gVerticesBuffer, gColorBuffer;
    private ShortBuffer gIndicesBuffer;
    private float roatef;

    /**
     * TODO Put here a description of what this constructor does.
     */
    public Rectangle() {
        ByteBuffer vbb = ByteBuffer.allocateDirect(this.gVertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        this.gVerticesBuffer = vbb.asFloatBuffer();
        this.gVerticesBuffer.put(this.gVertices);
        this.gVerticesBuffer.position(0);

        ByteBuffer ibb = ByteBuffer.allocateDirect(this.indices.length * 2);
        ibb.order(ByteOrder.nativeOrder());
        this.gIndicesBuffer = ibb.asShortBuffer();
        this.gIndicesBuffer.put(this.indices);
        this.gIndicesBuffer.position(0);
    }

    private static float gVertices[] = {
            -1f, 1f, 0f,
            -1f, -1f, 0f,
            1f, -1f, 0f,
            1f, 1f, 0f,
    };

    // The order we like to connect them.
    private short[] indices = {
            0, 1, 2,
            0, 2, 3
    };

    @SuppressWarnings("javadoc")
    public void draw(javax.microedition.khronos.opengles.GL10 gl) {
        gl.glFrontFace(gl.GL_CCW);
        gl.glEnable(gl.GL_CULL_FACE);
        gl.glCullFace(gl.GL_BACK);

        gl.glPushMatrix();
        gl.glTranslatef(2, 0, 0);
        gl.glScalef(0.5f, 0.5f, 0.5f);
        gl.glRotatef(this.roatef, 1, 0, 0);
        this.drawRect(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glScalef(0.5f, 0.5f, 0.5f);
        gl.glTranslatef(-2f,0,0);
        gl.glRotatef(this.roatef,0,1,0);
        this.drawRect(gl);
        gl.glPopMatrix();
        
        gl.glDisable(gl.GL_CULL_FACE);
        this.roatef += 1.5f;
    }

    private void drawRect(GL10 gl) {
        gl.glEnableClientState(gl.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, gl.GL_FLOAT, 0, this.gVerticesBuffer);
        gl.glDrawElements(gl.GL_TRIANGLES, this.indices.length, gl.GL_UNSIGNED_SHORT,
                this.gIndicesBuffer);

        gl.glDisableClientState(gl.GL_VERTEX_ARRAY);
    }
}
