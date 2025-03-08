//
// Created by FCI on 05-03-2025.
//

#include "header/util.h"
#include <string>
#include <vector>
#include <android/log.h>
#include <iostream>
// #include <stdexcept>

std::string getBase64StringFromAscii(const std::vector<int> &asciiValues) {
    std::string base64String;
    for (int value: asciiValues) {
        base64String += static_cast<char>(value);
    }
    return base64String;
}

std::string getStringFromBase64(const std::string &base64) {
    static const std::string base64_chars =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            "abcdefghijklmnopqrstuvwxyz"
            "0123456789+/";

    auto is_base64 = [](unsigned char c) {
        return (isalnum(c) || (c == '+') || (c == '/'));
    };

    std::string tempBase64 = base64;
    size_t padding = 0;
    if (!tempBase64.empty()) {
        if (tempBase64[tempBase64.length() - 1] == '=') {
            padding++;
            if (tempBase64.length() > 1 && tempBase64[tempBase64.length() - 2] == '=') {
                padding++;
            }
        }
    }
    tempBase64.erase(tempBase64.length() - padding, padding);

    for (char c: tempBase64) {
        if (!is_base64(c)) {
            throw std::runtime_error("Invalid Base64 string");
        }
    }

    std::string decodedString;
    int i = 0;
    int j = 0;
    unsigned char char_array_4[4], char_array_3[3];

    for (char c: tempBase64) {
        char_array_4[i++] = c;
        if (i == 4) {
            for (i = 0; i < 4; i++) {
                char_array_4[i] = base64_chars.find(char_array_4[i]);
            }

            char_array_3[0] = (char_array_4[0] << 2) + ((char_array_4[1] & 0x30) >> 4);
            char_array_3[1] = ((char_array_4[1] & 0xf) << 4) + ((char_array_4[2] & 0x3c) >> 2);
            char_array_3[2] = ((char_array_4[2] & 0x3) << 6) + char_array_4[3];

            for (i = 0; (i < 3); i++) {
                decodedString += char_array_3[i];
            }
            i = 0;
        }
    }

    if (i) {
        for (j = i; j < 4; j++) {
            char_array_4[j] = 0;
        }

        for (j = 0; j < 4; j++) {
            char_array_4[j] = base64_chars.find(char_array_4[j]);
        }

        char_array_3[0] = (char_array_4[0] << 2) + ((char_array_4[1] & 0x30) >> 4);
        char_array_3[1] = ((char_array_4[1] & 0xf) << 4) + ((char_array_4[2] & 0x3c) >> 2);
        char_array_3[2] = ((char_array_4[2] & 0x3) << 6) + char_array_4[3];

        for (j = 0; (j < i - 1); j++) {
            decodedString += char_array_3[j];
        }
    }

    return decodedString;
}

std::string getStringFromAscii(const std::vector<int> &asciiValues) {
    std::string base64String = getBase64StringFromAscii(asciiValues);
    std::string result = getStringFromBase64(base64String);
    return result;
}
