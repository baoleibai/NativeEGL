#include "com_example_nativeegl_MyRenderer.h"

extern "C" {
/*
 * Class:     com_example_nativeegl_MyRenderer
 * Method:    nativeGetHelloString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_example_nativeegl_MyRenderer_nativeGetHelloString
  (JNIEnv *env, jobject obj) {
      return env->NewStringUTF((char*)" This is calling from JNI suckers!");
  }
/*
 * Class:     com_example_nativeegl_MyRenderer
 * Method:    nativeDrawFrame
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_example_nativeegl_MyRenderer_nativeDrawFrame
  (JNIEnv *env, jobject obj) {

}

/*
 * Class:     com_example_nativeegl_MyRenderer
 * Method:    nativeSurfaceChanged
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_example_nativeegl_MyRenderer_nativeSurfaceChanged
  (JNIEnv *env, jobject obj, jint width, jint height){

}

/*
 * Class:     com_example_nativeegl_MyRenderer
 * Method:    nativeSurfaceCreated
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_example_nativeegl_MyRenderer_nativeSurfaceCreated
(JNIEnv *env, jobject obj) {

}
}
