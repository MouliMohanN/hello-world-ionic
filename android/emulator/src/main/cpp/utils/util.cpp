//
// Created by FCI on 05-03-2025.
//

#include "string"
#include "header/util.h"



std::string getBase64StringFromAscii(const std::vector<int>& asciiValues) {
    std::string base64String;
    for (int value : asciiValues) {
        base64String += static_cast<char>(value);
    }
    return base64String;
}

std::string getStringFromBase64(const std::string& base64) {
// Base64 character set

    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    std::vector<int> capitalAtoZ = {81,85,74,68,82,69,86,71,82,48,104,74,83,107,116,77,84,85,53,80,85,70,70,83,85,49,82,86,86,108,100,89,87,86,111,61};
    // abcdefghijklmnopqrstuvwxyz
    std::vector<int> smallAtoZ = {89,87,74,106,90,71,86,109,90,50,104,112,97,109,116,115,98,87,53,118,99,72,70,121,99,51,82,49,100,110,100,52,101,88,111,61};
    // 0123456789+/
    std::vector<int> zeroToNine = {77,68,69,121,77,122,81,49,78,106,99,52,79,83,115,118};
    static const std::string base64_chars =
            getBase64StringFromAscii(capitalAtoZ) +
                    getBase64StringFromAscii(smallAtoZ) +
                    getBase64StringFromAscii(zeroToNine);

    // Check if a character is a valid Base64 character
    auto is_base64 = [&](unsigned char c) {
        return (isalnum(c) || (c == '+') || (c == '/'));
    };

    // Remove padding characters (=) from the end of the string
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

    // Check if the string is a valid Base64 string
    for (char c : tempBase64) {
        if (!is_base64(c)) {
            // Invalid Base64 string
            std::vector<int> invalidBase64String = {83,87,53,50,89,87,120,112,90,67,66,67,89,88,78,108,78,106,81,103,99,51,82,121,97,87,53,110};
            throw std::runtime_error(getStringFromAscii(invalidBase64String));
        }
    }

    // Decode the Base64 string
    std::string decodedString;
    int i = 0;
    int j = 0;
    unsigned char char_array_4[4], char_array_3[3];

    while (!tempBase64.empty() && tempBase64[i] != '=') {
        char_array_4[i++] = tempBase64[i];
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


std::string getStringFromAscii(const std::vector<int>& asciiValues) {
    std::string base64String = getBase64StringFromAscii(asciiValues);
    std::string result = getStringFromBase64(base64String);
    return result;
}
