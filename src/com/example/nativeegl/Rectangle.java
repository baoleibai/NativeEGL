
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
    private FloatBuffer gVertexBuffer, gColorBuffer;
    private ShortBuffer gIndicesBuffer;
    private float gRotateAngle;

    /**
     * TODO Put here a description of what this constructor does.
     *
     */
    public Rectangle() {
        ByteBuffer vbb = ByteBuffer.allocateDirect(gVertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        gVertexBuffer = vbb.asFloatBuffer();
        gVertexBuffer.put(gVertices);
        gVertexBuffer.position(0);

        ByteBuffer cbb = ByteBuffer.allocateDirect(gColors.length * 4);
        cbb.order(ByteOrder.nativeOrder());
        gColorBuffer = cbb.asFloatBuffer();
        gColorBuffer.put(gColors);
        gColorBuffer.position(0);

        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
        ibb.order(ByteOrder.nativeOrder());
        gIndicesBuffer = ibb.asShortBuffer();
        gIndicesBuffer.put(indices);
        gIndicesBuffer.position(0);
    }

    private static float gVertices[] = {
            -1f, 1f, 0f,
            -1f, -1f, 0f,
            1f, -1f, 0f,
            1f, 1f, 0f,
    };

    private static float gColors[] = {
            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 1.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f,

            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f,
            0.0f, 1.0f, 0.0f, 1.0f,

            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 1.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f,

            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f,
            0.0f, 1.0f, 0.0f, 1.0f,
    };
    // The order we like to connect them.
    private short[] indices = {
            0, 1, 2,
            0, 2, 3
    };

    @SuppressWarnings("javadoc")
    public void draw(javax.microedition.khronos.opengles.GL10 gl) {
        // push the matrics into 5 depth of the screen.
        gl.glTranslatef(0, 0, -10);
        // Counter-clockwise winding.
        gl.glFrontFace(GL10.GL_CCW); // OpenGL docs
        // Enable face culling.
        gl.glEnable(GL10.GL_CULL_FACE); // OpenGL docs
        // What faces to remove with the face culling.
        gl.glCullFace(GL10.GL_BACK); // OpenGL docs
        
        gl.glPushMatrix();
        gl.glTranslatef(2,0,0);
        gl.glRotatef(50.0f,0,0,1);
        gl.glScalef(0.5f,0.5f,0.5f);
        this.drawRect(gl);
        gl.glPopMatrix();
        
        gl.glPushMatrix();  //duplicate the current top stack and push it into the stack.
        gl.glTranslatef(-2,0,0);
        gl.glRotatef(this.gRotateAngle,0,0,1);
        gl.glScalef(0.5f,0.5f,0.5f);
        this.drawRect(gl);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,0,0);
        gl.glRotatef(this.gRotateAngle,1,0,0);
        gl.glScalef(0.8f,0.8f,0.8f);
        this.drawRect(gl);
        gl.glPopMatrix();
        
        this.gRotateAngle +=1.0f;
    }

    private void drawRect(GL10 gl) {
        // Enabled the vertices buffer for writing and to be used during
        // rendering.
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// OpenGL docs.
        // Specifies the location and data format of an array of vertex
        // coordinates to use when rendering.
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, // OpenGL docs
                gVertexBuffer);

        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,// OpenGL docs
                GL10.GL_UNSIGNED_SHORT, gIndicesBuffer);

        // Disable the vertices buffer.
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY); // OpenGL docs
        // Disable face culling.
        gl.glDisable(GL10.GL_CULL_FACE); // OpenGL docs
    }
}
