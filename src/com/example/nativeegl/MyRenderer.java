
package com.example.nativeegl;

import android.R.integer;
import android.R.layout;
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

    private Rectangle mRectangle;
    private FlatColorRectangle mFlatColorRectangle;
    private SmoothColorRect mSmoothColorRect;
    
    /**
     * TODO Put here a description of what this constructor does.
     * 
     * @param goNative
     */
    public MyRenderer() {
        mRectangle = new Rectangle();
        mFlatColorRectangle = new FlatColorRectangle();
        mSmoothColorRect = new SmoothColorRect();
        // TODO Auto-generated constructor stub.
    }

    private native String nativeGetHelloString();

    private native void nativeDrawFrame();

    private native void nativeSurfaceChanged(int width, int height);

    private native void nativeSurfaceCreated();

    @Override
    public void onDrawFrame(GL10 gl) {
        nativeDrawFrame();
        Log.d(TAG, "onDrawFrame " + nativeGetHelloString());
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-10.0f);
        
        //mRectangle.draw(gl); // ( NEW )
        //mFlatColorRectangle.draw(gl);
        mSmoothColorRect.draw(gl);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        nativeSurfaceChanged(width, height);
        Log.d(TAG, "onSurfaceChanged");
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100f);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        nativeSurfaceCreated();
        Log.d(TAG, "onSurfaceCreate");
        gl.glClearColor(0, 0, 0, 1);
        gl.glShadeModel(gl.GL_SMOOTH);

        gl.glClearDepthf(1.0f);
        gl.glEnable(gl.GL_DEPTH_TEST);
        gl.glDepthFunc(gl.GL_LEQUAL);
        gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);
    }

    public void setColor(float r, float g, float b) {
        _red = r;
        _green = g;
        _blue = b;
    }
}
