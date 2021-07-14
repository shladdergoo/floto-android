# floto-android

Native Android client for posting notes to the Floto back-end.

## Build

``` ./gradlew assembleDebug  ```

## Run unit tests

``` ./gradlew test ```

## Deploy

```
emulator -avd avd_name
adb install app/build/outputs/apk/debug/app-debug.apk
```
