package kr.khs.studyfarm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\r\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082D\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"seqKey", "", "spfJwt", "tokenKey", "addAccessToken", "", "context", "Landroid/content/Context;", "jwt", "addUserSeq", "seq", "", "clearAccessToken", "getAccessToken", "getUserSeq", "isEmailValidate", "", "str", "isPasswordValidate", "app_debug"})
public final class XKt {
    private static final java.lang.String spfJwt = "jwtTokens";
    private static final java.lang.String tokenKey = "jwt";
    private static final java.lang.String seqKey = "seq";
    
    public static final boolean isEmailValidate(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
        return false;
    }
    
    public static final boolean isPasswordValidate(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
        return false;
    }
    
    public static final void addUserSeq(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int seq) {
    }
    
    public static final int getUserSeq(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0;
    }
    
    public static final void addAccessToken(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String jwt) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getAccessToken(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public static final void clearAccessToken(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}