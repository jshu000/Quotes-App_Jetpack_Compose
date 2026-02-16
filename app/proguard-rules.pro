# Gson keep rules
-keep class com.google.gson.** { *; }
-keep class * extends com.google.gson.** { *; }

# Keep model classes (your app package)
-keep class com.andha_coder.firstcompose.** { *; }

# Keep annotations and generic types
-keepattributes Signature
-keepattributes *Annotation*