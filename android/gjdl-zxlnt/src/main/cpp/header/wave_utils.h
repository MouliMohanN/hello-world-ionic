//
// Created by FCI on 18-03-2025.
//

#ifndef ANDROID_WAVE_UTILS_H
#define ANDROID_WAVE_UTILS_H

#include <jni.h>
#include <string>

std::string checkIfPathsExists(JNIEnv *env, jobjectArray paths);

#endif //ANDROID_WAVE_UTILS_H
