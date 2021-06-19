# 本库模块专用的混淆规则

# gson && protob
-dontwarn com.google.**
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}
-keep class com.google.gson.stream.** { *; }

# FastJSON
-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.annotation.** { *; }
