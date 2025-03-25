
#include <string>
#include <android/log.h>
#include "FileHelper.hpp"
#include "header/wave_utils.h"

bool checkIfPathsExists(JNIEnv *env, jobjectArray paths) {
    if (paths == nullptr) {
        return false;
    }
    int stringCount = (env)->GetArrayLength(paths);
    for (int i=0; i<stringCount; i++) {
        jstring string = (jstring) (env)->GetObjectArrayElement(paths, i);
        if (string == nullptr) {
            return false;
        }
        const char *pathString = (env)->GetStringUTFChars(string, 0);
        // __android_log_print(ANDROID_LOG_INFO, "mouliTesting", "doPathExists string: %s", pathString);
        if (pathString == nullptr || pathString[0] == '\0') {
            return false;
        }
        bool exists = FileHelper::fileExists(pathString);
        // __android_log_print(ANDROID_LOG_INFO, "mouliTesting", "doPathExists exists: %d, pathString: %s", exists, pathString);
        if (exists) {
            (env)->ReleaseStringUTFChars(string, pathString);
            return true;
        }
        (env)->ReleaseStringUTFChars(string, pathString);
    }
    return false;
}
