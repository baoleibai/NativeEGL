package com.example.nativeegl;

import javax.microedition.khronos.opengles.GL10;

public class ThreeDimentionRectangle extends ThreeDimentionMesh {
	private float[] vertex = { 
			-width, -height, -depth, // 0
			width, -height, -depth, // 1
			width, height, -depth, // 2
			-width, height, -depth, // 3
			-width, -height, depth, // 4
			width, -height, depth, // 5
			width, height, depth, // 6
			-width, height, depth, // 7
	};
	private short[] indices = {
			7, 4, 5,
			7, 5, 6,
			6, 5, 1, 
			6, 1, 2, 
			2, 1, 0,
			2, 0, 3, 
			3, 0, 4, 
			3, 4, 7,
			3, 7, 6, 
			3, 6, 2, 
			1, 5, 4,
			1, 4, 0,
			
			/*
			0, 4, 5,
			0, 5, 1,
			1, 5, 6,
			1, 6, 2,
			2, 6, 7,
			2, 7, 3,
			3, 7, 4,
			3, 4, 0,
			4, 7, 6,
			4, 6, 5,
			3, 0, 1,
			3, 1, 2, 
			*/
	};
	
	private static float gColors[] = {
         1.0f, 0.0f, 0.0f, 1.0f,
         0.0f, 1.0f, 0.0f, 1.0f,
         0.0f, 0.0f, 1.0f, 1.0f,
         0.0f, 0.0f, 1.0f, 1.0f, 
         1.0f, 0.0f, 0.0f, 1.0f, 
         0.0f, 1.0f, 0.0f, 1.0f, 
         0.0f, 1.0f, 0.0f, 1.0f, 
         1.0f, 0.0f, 0.0f, 1.0f,
        };
	
	private float angle;
	private float[] anglef = { 0.0f, 10.0f, 0.0f };
	private float[] translate = { 0, 0, -8.0f };
	private static float width = 1.0f;
	private static float height = 1.0f;
	private static float depth = 1.0f;

	public ThreeDimentionRectangle() {
		super();
		super.setRotatef(anglef);
		super.setTranslatef(translate);
		super.setColors(gColors);
		super.setIndices(indices);
		super.setVertices(vertex);
	}

	public void draw(GL10 gl) {

		super.draw(gl);
	}
}
