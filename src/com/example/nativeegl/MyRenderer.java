
package com.example.nativeegl;

import android.R.integer;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.util.Log;

import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author b576. Created Nov 18, 2013.
 */

public class MyRenderer implements GLSurfaceView.Renderer {

    private static final String TAG = "bbaiagl";
    private float _red = 0.9f;
    private float _green = 0.2f;
    private float _blue = 0.2f;

    private boolean goNative;

    /**
     * TODO Put here a description of what this constructor does.
     * 
     * @param goNative
     */
    public MyRenderer(boolean goNative) {
        // TODO Auto-generated constructor stub.
        goNative = goNative;
    }

    private native String nativeGetHelloString();

    private native void nativeDrawFrame();

    private native void nativeSurfaceChanged(int width, int height);

    private native void nativeSurfaceCreated();

    @Override
    public void onDrawFrame(GL10 gl) {
       nativeDrawFrame();

        Log.d(TAG, "onDrawFrame " + nativeGetHelloString());
        if (!goNative) {
            // define the color we want to be displayed as the "clipping wall"
            gl.glClearColor(_red, _green, _blue, 1.0f);
            // clear the color buffer to show the ClearColor we called above...
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        }
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        nativeSurfaceChanged(width,height);
        Log.d(TAG, "onSurfaceChanged");
        if (!goNative) {
            // Sets the current view port to the new size.
            gl.glViewport(0, 0, width, height);// OpenGL docs.

            // Select the projection matrix
            gl.glMatrixMode(GL10.GL_PROJECTION);// OpenGL docs.

            // Reset the projection matrix
            gl.glLoadIdentity();// OpenGL docs.]
            // gl.glOrthof(0, width,0,height,0,10);
            // Calculate the aspect ratio of the window
            GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100.0f);

            // Select the modelview matrix
            gl.glMatrixMode(GL10.GL_MODELVIEW);// OpenGL docs.

            // Reset the modelview matrix
            gl.glLoadIdentity();// OpenGL docs.
        }
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        nativeSurfaceCreated();
        Log.d(TAG, "onSurfaceCreate");
        if (!goNative) {
            // Set the background color to black ( rgba ).
            gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f); // OpenGL docs.

            // Enable Smooth Shading, default not really needed.
            gl.glShadeModel(GL10.GL_SMOOTH);// OpenGL docs.

            // Depth buffer setup.
            gl.glClearDepthf(1.0f);// OpenGL docs.

            // Enables depth testing.
            gl.glEnable(GL10.GL_DEPTH_TEST);// OpenGL docs.

            // The type of depth testing to do.
            gl.glDepthFunc(GL10.GL_LEQUAL);// OpenGL docs.

            // Really nice perspective calculations.
            gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        }
    }

    public void setColor(float r, float g, float b) {
        _red = r;
        _green = g;
        _blue = b;
    }
}
