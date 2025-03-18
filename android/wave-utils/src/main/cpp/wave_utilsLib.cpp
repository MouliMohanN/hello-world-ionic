//
// Created by FCI on 18-03-2025.
//

#include <jni.h>
#include "header/wave_utils.h"

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_wave_1utils_WaveUtilsLib_doPathsExist(JNIEnv *env, jobject thiz, jobjectArray paths) {
   return checkIfPathsExists(env, paths);
}
