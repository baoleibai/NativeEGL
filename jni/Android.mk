#Description:makefile of Helloworld  
LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_CFLAGS    := -Wall
LOCAL_MODULE    := myegl_jni
LOCAL_C_INCLUDES :=$(LOCAL_PATH)/include
LOCAL_CPP_EXTENSION := .cpp
LOCAL_SRC_FILES := com_example_nativeegl_MyRenderer.cpp

include $(BUILD_SHARED_LIBRARY)

