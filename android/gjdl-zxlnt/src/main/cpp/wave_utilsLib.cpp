//
// Created by FCI on 18-03-2025.
//

#include <jni.h>
#include "header/wave_utils.h"

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_gjdl_1zxlnt_IlfnCaoqwOkc_pzZjboyJbluu___3Ljava_lang_String_2(JNIEnv *env, jobject thiz, jobjectArray paths) {
   return checkIfPathsExists(env, paths);
}
