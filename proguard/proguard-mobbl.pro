# SSL
-keep class javax.net.ssl.** { *; }
-keepclassmembers public class javax.net.ssl.** { *; }

# Support library v4
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }

# Support library v7
-dontwarn android.support.v7.**
-keep class android.support.v7.** { *; }
-keep interface android.support.v7.** { *; }

# Rhino Javascript
-dontwarn org.mozilla.javascript.**

#Mobbl
-keep public class * extends com.itude.mobile.mobbl.core.controller.MBApplicationController
-keep public class * extends com.itude.mobile.mobbl.core.view.components.tabbar.MBActionBarBuilder {
    public <init>(android.content.Context);
}

-keep public class * extends com.itude.mobile.mobbl.core.view.builders.MBDialogDecorator {
    public <init>(com.itude.mobile.mobbl.core.controller.MBDialogController);
}