# Reverse Engineering

## Prerequisits

1. Setup Android Env by following the doc => docs\FbWelcome.md
2. Install Mandatory => Adb, apktool, jadx
3. Install Optional => Dex2Jar, Jd-gui, Radare2, strings

### Adb commands

```bash
1. adb shell
2. pm list packages
3. grep <search-text>
4. pm path <path-of-the-package>
5. exit => will exit from shell
```

Go to the folder you want to copy the apk on the computer

```bash
6. adb pull <path-of-the-package> <destination-path-to-be-copied> => will copy the apk to the current folder the cmd is open
```

### Decompiling apk and exploring source code

#### Exploring Java/kotlin code

1. Decompile the apk with the below command

```bash
- apktool d <input-path.apk> <output-name>
- apktool b <decompiled-code-folder-path> -o <output-name.apk>
- keytool -genkey -v -keystore debug.keystore -alias androiddebugkey -storepass android -keypass android -keyalg RSA -validity 14000
- apksigner  sign --ks [your keystore name] --v1-signing-enabled true --v2-signing-enabled true [your zip aligned apk location]
```

2. Load the decompiled folder in Jadx tool to view smali & source code side by side

#### Exploring C++ code

- Check References section
- With Gidra Decompiler it is easy to read code. Refer #3 video in the Youtube playlist
- Cutter UI. Refer #6
- Rizin. Refer #7
- Iaito. Refer #8

#### Exploring Javscript code

- WIP

### Frida

- Know which ABI is your phone/emulator

```bash
- adb shell getprop ro.product.cpu.abilist
```

- Know if device is rooted

```bash
- adb shell whoami
- adb root
```

- Install Frida

```bash
- pip install frida-tools
- frida — version <or> pip show frida
- adb push frida-server /data/local/tmp/
- adb shell "chmod 755 /data/local/tmp/frida-server"
- adb shell "/data/local/tmp/frida-server &"
```

- Check running process

```bash
- frida-ps -U <or> frida-ps -D 127.0.0.1:62025
```

- Check Installed applications

```bash
- frida-ps -Uai
- frida-ps -Ua
```

- Active internet connections (only servers)

```bash
- adb shell netstat -tulpn
```

- Extract apk from bundle
```bash
java -jar C:/Users/FCI/Downloads/bundletool_all_1_18_1.jar build-apks --bundle=C:/mouli/ionic/hello-world-ionic/android/app/build/outputs/bundle/debug/app-debug.aab --output=C:/mouli/ionic/hello-world-ionic/android/app/build/outputs/bundle/debug/app-debug.apks
```

- Extract apk from bundle for connected device
```bash
java -jar C:/Users/FCI/Downloads/bundletool_all_1_18_1.jar build-apks --bundle=C:/mouli/ionic/hello-world-ionic/android/app/build/outputs/bundle/debug/app-debug.aab --output=C:/mouli/ionic/hello-world-ionic/android/app/build/outputs/bundle/debug/app-debug.apks --connected-device
```

- Install apk from bundle for connected device
```bash
java -jar C:/Users/FCI/Downloads/bundletool_all_1_18_1.jar install-apks --apks=C:/mouli/ionic/hello-world-ionic/android/app/build/outputs/bundle/debug/app-debug.apks --device-id=adb-RZCY11ND0CZ-B1DvSz._adb-tls-connect._tcp

// adb-RZCY11ND0CZ-B1DvSz._adb-tls-connect._tcp
// LGK5203fe0e917
```



## References

- [Youtube, Android Reversing #1](https://youtu.be/uc7eZGE07ps?si=cuH9eJsH1VEYbKN1) - Follow up #2, #3 and other videos on the channel
- [Blog, Intro to Android mobile Reverse Engineering](https://www.corellium.com/blog/android-mobile-reverse-engineering)
- [Youtube, C++ Reversing using Radare2](https://youtu.be/RbIxKM2QW8s?si=Bm0Bm8uS0mmurMW-)
- [GitHub, Radare2 official link](https://github.com/radareorg/radare2)
