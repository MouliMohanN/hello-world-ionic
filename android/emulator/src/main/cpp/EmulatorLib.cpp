#include <jni.h>
#include <string>
#include "utils/header/Emulator.h"

extern "C" JNIEXPORT jboolean JNICALL
Java_com_example_emulator_EmulatorLib_isDetected(
    JNIEnv *env,
    jobject /* this */)
{

    return Emulator().isDetected();
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_emulator_EmulatorLib_getResult(JNIEnv *env, jobject thiz)
{
    return env->NewStringUTF(Emulator().getResult().c_str());
}
