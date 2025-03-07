#include <jni.h>
#include <string>
#include "Emulator.cpp"

extern "C" JNIEXPORT jboolean JNICALL
Java_com_example_emulator_EmulatorLib_isDetected(
        JNIEnv* env,
        jobject /* this */) {

    return Emulator().isDetected();
}
