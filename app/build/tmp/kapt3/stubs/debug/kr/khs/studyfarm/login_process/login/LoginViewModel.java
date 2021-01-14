package kr.khs.studyfarm.login_process.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u000208J\u0006\u0010:\u001a\u000208J\u0006\u0010;\u001a\u000208J\u0006\u0010<\u001a\u000208J\u0006\u0010=\u001a\u000208J\u000e\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0011J\u000e\u0010@\u001a\u0002082\u0006\u0010?\u001a\u00020\u0011J\b\u0010A\u001a\u000208H\u0002J\u0006\u0010B\u001a\u000208J\b\u0010C\u001a\u000208H\u0014J\u0006\u0010D\u001a\u000208R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0015R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0015R\u000e\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138F\u00a2\u0006\u0006\u001a\u0004\b\'\u0010\u0015R\u001a\u0010(\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138F\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u0015R\u0011\u00101\u001a\u000202\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00110\u00138F\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u0015\u00a8\u0006E"}, d2 = {"Lkr/khs/studyfarm/login_process/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_apiStatus", "Landroidx/lifecycle/MutableLiveData;", "Lkr/khs/studyfarm/network/ApiStatus;", "_error", "Lkr/khs/studyfarm/network/response/ResponseError;", "_gotoFindPW", "", "_gotoSignUp", "_loginSuccess", "_response", "Lkr/khs/studyfarm/network/response/Response;", "_toast", "", "apiStatus", "Landroidx/lifecycle/LiveData;", "getApiStatus", "()Landroidx/lifecycle/LiveData;", "getContext", "()Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "email", "Landroidx/databinding/ObservableField;", "getEmail", "()Landroidx/databinding/ObservableField;", "error", "getError", "gotoFindPW", "getGotoFindPW", "gotoSignUp", "getGotoSignUp", "job", "Lkotlinx/coroutines/CompletableJob;", "loginSuccess", "getLoginSuccess", "nickname", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "password", "getPassword", "response", "getResponse", "rule", "Lkr/khs/studyfarm/Rule;", "getRule", "()Lkr/khs/studyfarm/Rule;", "toast", "getToast", "doGoToFindPW", "", "doGoToSignUp", "doneGoToFindPW", "doneGoToSignUp", "doneLogin", "doneToast", "kakaoIdCheck", "kakaoToken", "kakaoSignUp", "login", "loginByKakao", "onCleared", "onLoginBtnClick", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> email = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> password = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String nickname = "";
    @org.jetbrains.annotations.NotNull()
    private final kr.khs.studyfarm.Rule rule = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _gotoSignUp = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _gotoFindPW = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _loginSuccess = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.response.Response> _response = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.response.ResponseError> _error = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _toast = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.ApiStatus> _apiStatus = null;
    private final kotlinx.coroutines.CompletableJob job = null;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNickname() {
        return null;
    }
    
    public final void setNickname(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.khs.studyfarm.Rule getRule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getGotoSignUp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getGotoFindPW() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getLoginSuccess() {
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
    public final androidx.lifecycle.LiveData<java.lang.String> getToast() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kr.khs.studyfarm.network.ApiStatus> getApiStatus() {
        return null;
    }
    
    public final void loginByKakao() {
    }
    
    public final void kakaoIdCheck(@org.jetbrains.annotations.NotNull()
    java.lang.String kakaoToken) {
    }
    
    public final void kakaoSignUp(@org.jetbrains.annotations.NotNull()
    java.lang.String kakaoToken) {
    }
    
    public final void onLoginBtnClick() {
    }
    
    private final void login() {
    }
    
    public final void doGoToSignUp() {
    }
    
    public final void doneGoToSignUp() {
    }
    
    public final void doGoToFindPW() {
    }
    
    public final void doneGoToFindPW() {
    }
    
    public final void doneLogin() {
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
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}