package com.example.nativeegl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class ThreeDimentionMesh {
    private FloatBuffer gVerticesBuffer, gColorBuffer;
    private int indices;
    private ShortBuffer gIndicesBuffer;
    private float roatef[] = {0,0,0};
    private float translatef[] = {0,0,0};
    private float anglef = 0;
    private float rgb[]={0.5f,0.5f,0.5f,1.0f};
    private float scalef[] = {1.0f, 1.0f,1.0f};
	public ThreeDimentionMesh(){
		
	}
	
	protected void draw(GL10 gl) {
        gl.glFrontFace(gl.GL_CCW);
        gl.glEnable(gl.GL_CULL_FACE);
        gl.glCullFace(gl.GL_BACK);
        
        gl.glTranslatef(this.translatef[0], this.translatef[1], this.translatef[2]);
        
        gl.glRotatef(this.roatef[0], 1 , 0, 0);
        gl.glRotatef(this.roatef[1], 0 , 1, 0);
        gl.glRotatef(this.roatef[1], 0 , 0, 1);
        
        gl.glScalef(scalef[0], scalef[1], scalef[2]);
        //set the default color
        gl.glColor4f(rgb[0], rgb[1], rgb[2], rgb[3]);
        
        gl.glEnableClientState(gl.GL_VERTEX_ARRAY);
        gl.glEnableClientState(gl.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, gl.GL_FLOAT, 0, gVerticesBuffer);
        
        if(this.gColorBuffer != null) {
        	gl.glColorPointer(4, gl.GL_FLOAT, 0, gColorBuffer);
        }
        
        gl.glDrawElements(gl.GL_TRIANGLES, this.indices, gl.GL_UNSIGNED_SHORT, gIndicesBuffer);
        gl.glDisableClientState(gl.GL_COLOR_ARRAY);
        gl.glDisableClientState(gl.GL_VERTEX_ARRAY);
        gl.glDisable(gl.GL_CULL_FACE);
        this.roatef[0] += 0.5f;
	}
	
	protected void setFlatColor(float[] c) {
		rgb[0] = c[0];
		rgb[1] = c[1];
		rgb[2] = c[2];
		rgb[3] = c[3];
	}
	
	protected void setRotatef(float[] axis) {
		this.roatef[0] = axis[0];
		this.roatef[1] = axis[1];
		this.roatef[2] = axis[2];
	}
	
	protected void setScalef(float[] s) {
		this.scalef[0] = s[0];
		this.scalef[1] = s[1];
		this.scalef[2] = s[2];
	}
	
	protected void setTranslatef(float[] t) {
		this.translatef[0] = t[0];
		this.translatef[1] = t[1];
		this.translatef[2] = t[2];
	}
	protected void setVertices(float[] v){
		ByteBuffer vbb = ByteBuffer.allocateDirect(v.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		this.gVerticesBuffer = vbb.asFloatBuffer();
		this.gVerticesBuffer.put(v);
		this.gVerticesBuffer.position(0);
	}
	
	protected void setColors(float[] v){
		ByteBuffer vbb = ByteBuffer.allocateDirect(v.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		this.gColorBuffer = vbb.asFloatBuffer();
		this.gColorBuffer.put(v);
		this.gColorBuffer.position(0);

	}
	protected void setIndices(short[] v){
		ByteBuffer vbb = ByteBuffer.allocateDirect(v.length * 2);
		vbb.order(ByteOrder.nativeOrder());
		this.gIndicesBuffer = vbb.asShortBuffer();
		this.gIndicesBuffer.put(v);
		this.gIndicesBuffer.position(0);
		this.indices = v.length;
	}
}
