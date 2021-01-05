package kr.khs.studyfarm.login_process.sign_up;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u00106\u001a\u0002072\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u00108\u001a\u000207H\u0002J\u0006\u00109\u001a\u000207J\u0006\u0010:\u001a\u000207J\b\u0010;\u001a\u000207H\u0014J\u0006\u0010<\u001a\u000207R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u00118F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010&\u001a\u00020\'\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118F\u00a2\u0006\u0006\u001a\u0004\b-\u0010\u0013R\u0011\u0010.\u001a\u00020/\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\r0\u00118F\u00a2\u0006\u0006\u001a\u0004\b3\u0010\u0013R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118F\u00a2\u0006\u0006\u001a\u0004\b5\u0010\u0013\u00a8\u0006="}, d2 = {"Lkr/khs/studyfarm/login_process/sign_up/SignupViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_apiStatus", "Landroidx/lifecycle/MutableLiveData;", "Lkr/khs/studyfarm/network/ApiStatus;", "_error", "Lkr/khs/studyfarm/network/response/ResponseError;", "_response", "Lkr/khs/studyfarm/network/response/Response;", "_status", "", "_toast", "", "apiStatus", "Landroidx/lifecycle/LiveData;", "getApiStatus", "()Landroidx/lifecycle/LiveData;", "getContext", "()Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "duplicateNickname", "Landroidx/databinding/ObservableBoolean;", "getDuplicateNickname", "()Landroidx/databinding/ObservableBoolean;", "email", "Landroidx/databinding/ObservableField;", "getEmail", "()Landroidx/databinding/ObservableField;", "error", "getError", "job", "Lkotlinx/coroutines/CompletableJob;", "nickname", "getNickname", "nicknameFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "getNicknameFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "password", "getPassword", "response", "getResponse", "rule", "Lkr/khs/studyfarm/Rule;", "getRule", "()Lkr/khs/studyfarm/Rule;", "status", "getStatus", "toast", "getToast", "checkEmail", "", "checkNickName", "defaultStatus", "doneToast", "onCleared", "onNextBtnClicked", "app_debug"})
public final class SignupViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kr.khs.studyfarm.Rule rule = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> email = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> password = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> nickname = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableBoolean duplicateNickname = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _status = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.response.Response> _response = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.response.ResponseError> _error = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.ApiStatus> _apiStatus = null;
    private final kotlinx.coroutines.CompletableJob job = null;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _toast = null;
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnFocusChangeListener nicknameFocusChangeListener = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kr.khs.studyfarm.Rule getRule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getNickname() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableBoolean getDuplicateNickname() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getStatus() {
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
    
    public final void onNextBtnClicked() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnFocusChangeListener getNicknameFocusChangeListener() {
        return null;
    }
    
    private final void checkNickName() {
    }
    
    private final void checkEmail(java.lang.String email) {
    }
    
    public final void defaultStatus() {
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
    
    public SignupViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}