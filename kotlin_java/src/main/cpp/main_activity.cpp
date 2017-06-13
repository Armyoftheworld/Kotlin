#include <jni.h>

extern "C"

JNIEXPORT jint JNICALL Java_com_army_kotlin_Main2Activity_sum(JNIEnv *, jobject, jint x, jint y){
    return x + y;
}