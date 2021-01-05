package kr.khs.studyfarm.login_process.agreement_bottomsheet;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0006\u0010<\u001a\u000209J\u0006\u0010=\u001a\u000209J\u0006\u0010>\u001a\u000209J\u0006\u0010?\u001a\u000209J\b\u0010@\u001a\u000209H\u0014R\u0014\u0010\t\u001a\u00020\nX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u001cR\u000e\u0010*\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150\u001a8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\'R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\'R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\u001a8F\u00a2\u0006\u0006\u001a\u0004\b1\u0010\u001cR\u001a\u00102\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u00105R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\b7\u0010\u001c\u00a8\u0006A"}, d2 = {"Lkr/khs/studyfarm/login_process/agreement_bottomsheet/AgreementViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "email", "", "password", "nickname", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "CHECK_BOX_SIZE", "", "getCHECK_BOX_SIZE", "()I", "NECESSARY", "getNECESSARY", "_apiStatus", "Landroidx/lifecycle/MutableLiveData;", "Lkr/khs/studyfarm/network/ApiStatus;", "_error", "Lkr/khs/studyfarm/network/response/ResponseError;", "_nextBtnClicked", "", "_response", "Lkr/khs/studyfarm/network/response/Response;", "_toast", "apiStatus", "Landroidx/lifecycle/LiveData;", "getApiStatus", "()Landroidx/lifecycle/LiveData;", "checked", "Landroidx/databinding/ObservableField;", "", "getChecked", "()Landroidx/databinding/ObservableField;", "getContext", "()Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getEmail", "()Ljava/lang/String;", "error", "getError", "job", "Lkotlinx/coroutines/CompletableJob;", "nextBtnClicked", "getNextBtnClicked", "getNickname", "getPassword", "response", "getResponse", "seq", "getSeq", "setSeq", "(I)V", "toast", "getToast", "addUser", "", "user", "Lkr/khs/studyfarm/network/request/User;", "allCheck", "doNextBtnClicked", "doneNextBtnClicked", "doneToast", "onCleared", "app_debug"})
public final class AgreementViewModel extends androidx.lifecycle.ViewModel {
    private final int CHECK_BOX_SIZE = 4;
    private final int NECESSARY = 2;
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<boolean[]> checked = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _toast = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _nextBtnClicked = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.response.Response> _response = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.response.ResponseError> _error = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.ApiStatus> _apiStatus = null;
    private final kotlinx.coroutines.CompletableJob job = null;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    private int seq = -1;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String email = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String password = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nickname = null;
    
    public final int getCHECK_BOX_SIZE() {
        return 0;
    }
    
    public final int getNECESSARY() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<boolean[]> getChecked() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getToast() {
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
    
    public final int getSeq() {
        return 0;
    }
    
    public final void setSeq(int p0) {
    }
    
    public final void allCheck() {
    }
    
    public final void doNextBtnClicked() {
    }
    
    public final void doneNextBtnClicked() {
    }
    
    public final void doneToast() {
    }
    
    private final void addUser(kr.khs.studyfarm.network.request.User user) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNickname() {
        return null;
    }
    
    public AgreementViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String nickname) {
        super();
    }
}