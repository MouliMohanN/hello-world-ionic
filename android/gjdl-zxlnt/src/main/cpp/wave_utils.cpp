
#include <string>
#include <android/log.h>
#include "FileHelper.hpp"
#include "header/wave_utils.h"

std::string checkIfPathsExists(JNIEnv *env, jobjectArray paths) {
    // pathsexist - zjboyjbluu
    std::vector <int> trueValue = {101, 109, 112, 105, 98, 51, 108, 113, 89, 109, 120, 49, 100, 81, 61, 61};
    std::string trueValueString = getStringFromAscii(trueValue);

    // pathsdoesnotexist - gqivfpzobvvzjbluu
    std::vector <int> falseValue = {90, 51, 70, 112, 100, 109, 90, 119, 101, 109, 57, 105, 100, 110, 90, 54, 97, 109, 74, 115, 100, 88, 85, 61};
    std::string falseValueString = getStringFromAscii(falseValue);

    if (paths == nullptr) {
        return falseValueString;
    }
    int stringCount = (env)->GetArrayLength(paths);
    for (int i=0; i<stringCount; i++) {
        jstring string = (jstring) (env)->GetObjectArrayElement(paths, i);
        if (string == nullptr) {
            return falseValueString;
        }
        const char *pathString = (env)->GetStringUTFChars(string, 0);
        // __android_log_print(ANDROID_LOG_INFO, "mouliTesting", "doPathExists string: %s", pathString);
        if (pathString == nullptr || pathString[0] == '\0') {
            return falseValueString;
        }
        bool exists = FileHelper::fileExists(pathString);
        // __android_log_print(ANDROID_LOG_INFO, "mouliTesting", "doPathExists exists: %d, pathString: %s", exists, pathString);
        if (exists) {
            (env)->ReleaseStringUTFChars(string, pathString);
            return trueValueString;
        }
        (env)->ReleaseStringUTFChars(string, pathString);
    }
    return falseValueString;
}
