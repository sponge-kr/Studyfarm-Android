package kr.khs.studyfarm.login_process.sign_up_auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020*J\u0006\u0010-\u001a\u00020*J\b\u0010.\u001a\u00020*H\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u00128F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0014R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00128F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0014R\u001f\u0010$\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010\u00050\u00050\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u0014\u00a8\u0006/"}, d2 = {"Lkr/khs/studyfarm/login_process/sign_up_auth/SignupAuthViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "_email", "", "(Landroid/content/Context;Ljava/lang/String;)V", "_apiStatus", "Landroidx/lifecycle/MutableLiveData;", "Lkr/khs/studyfarm/network/ApiStatus;", "_error", "Lkr/khs/studyfarm/network/response/ResponseError;", "_nextBtnClicked", "", "_response", "Lkr/khs/studyfarm/network/response/Response;", "_toast", "apiStatus", "Landroidx/lifecycle/LiveData;", "getApiStatus", "()Landroidx/lifecycle/LiveData;", "getContext", "()Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "email", "getEmail", "()Landroidx/lifecycle/MutableLiveData;", "error", "getError", "job", "Lkotlinx/coroutines/CompletableJob;", "nextBtnClicked", "getNextBtnClicked", "response", "getResponse", "subTitle", "kotlin.jvm.PlatformType", "getSubTitle", "toast", "getToast", "checkEmailActive", "", "doNextBtnClicked", "doneNextBtnClicked", "doneToast", "onCleared", "app_debug"})
public final class SignupAuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> email = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> subTitle = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _nextBtnClicked = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.response.Response> _response = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.response.ResponseError> _error = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.ApiStatus> _apiStatus = null;
    private final kotlinx.coroutines.CompletableJob job = null;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _toast = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getSubTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getNextBtnClicked() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kr.khs.studyfarm.network.response.Response> getResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kr.khs.studyfarm.network.response.ResponseError> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kr.khs.studyfarm.network.ApiStatus> getApiStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getToast() {
        return null;
    }
    
    public final void doNextBtnClicked() {
    }
    
    private final void checkEmailActive(java.lang.String email) {
    }
    
    public final void doneNextBtnClicked() {
    }
    
    public final void doneToast() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public SignupAuthViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String _email) {
        super();
    }
}