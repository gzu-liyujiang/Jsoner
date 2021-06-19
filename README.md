# Jsoner

![Release APK](https://github.com/gzu-liyujiang/Jsoner/workflows/Release%20APK/badge.svg)
[![jitpack](https://jitpack.io/v/gzu-liyujiang/Jsoner.svg)](https://jitpack.io/#gzu-liyujiang/Jsoner)

自用的 Android JSON序列化/反序列化组件，面向接口编程，使用接口对各模块进行解耦，增强对第三方库的管控，底层可无缝切换底层的具体实现。默认实现了 GSON 及 FastJSON 。

```groovy
    allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
        }
    }
```

```groovy
    dependencies {
        implementation 'com.github.gzu-liyujiang:Jsoner:版本号'
        runtimeOnly 'com.google.code.gson:gson:2.8.6'
        //runtimeOnly 'com.alibaba:fastjson:1.2.70'
}
```
