package com.example.nativeegl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * TODO Put here a description of what this class does.
 *
 * @author b576.
 *         Created Dec 6, 2013.
 */
public class Rectangle {
    static float gVertices[] = {
        -100, 100, 0,
        -100, -100, 0,
        100, -100, 0,
        100, 100, 0
};
    static float gColors[] = {
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
        0.0f, 1.0f, 0.0f, 1.0f
};
    public static FloatBuffer getRectPointBuffer() {
        ByteBuffer vbb = ByteBuffer.allocateDirect(gVertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(gVertices);
        vertexBuffer.position(0);
        return vertexBuffer;
    }
    
    public static FloatBuffer getRectColorBuffer() {
        ByteBuffer cbb = ByteBuffer.allocateDirect(gColors.length*4);
        cbb.order(ByteOrder.nativeOrder());
        FloatBuffer colorBuffer = cbb.asFloatBuffer();
        colorBuffer.put(gColors);
        colorBuffer.position(0);
        return colorBuffer;
    }
}
