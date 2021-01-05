package kr.khs.studyfarm.login_process.select;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\tJ\u0006\u0010?\u001a\u00020\"J\u0006\u0010@\u001a\u00020\"J\u0006\u0010A\u001a\u00020\"J\b\u0010B\u001a\u00020\"H\u0002J\u0006\u0010C\u001a\u00020\"J\u000e\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\u001eJ\u000e\u0010F\u001a\u00020\"2\u0006\u0010E\u001a\u00020\u001eR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001d0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198F\u00a2\u0006\u0006\u001a\u0004\b1\u0010\u001bR\u000e\u00102\u001a\u000203X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0015R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u00198F\u00a2\u0006\u0006\u001a\u0004\b7\u0010\u001bR\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\u00198F\u00a2\u0006\u0006\u001a\u0004\b9\u0010\u001bR\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F\u00a2\u0006\u0006\u001a\u0004\b;\u0010<R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00170\u00198F\u00a2\u0006\u0006\u001a\u0004\b>\u0010\u001b\u00a8\u0006G"}, d2 = {"Lkr/khs/studyfarm/login_process/select/SelectViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "cityOrInterested", "", "_dataInit", "", "Lkr/khs/studyfarm/login_process/select/SelectInfo;", "(Landroid/content/Context;Z[Lkr/khs/studyfarm/login_process/select/SelectInfo;)V", "_apiStatus", "Landroidx/lifecycle/MutableLiveData;", "Lkr/khs/studyfarm/network/ApiStatus;", "_error", "Lkr/khs/studyfarm/network/response/ResponseError;", "_response", "Lkr/khs/studyfarm/network/response/Response;", "_returnSignup", "_selectData", "Ljava/util/ArrayList;", "get_selectData", "()Landroidx/lifecycle/MutableLiveData;", "_toast", "", "apiStatus", "Landroidx/lifecycle/LiveData;", "getApiStatus", "()Landroidx/lifecycle/LiveData;", "childrenList", "", "Lkr/khs/studyfarm/login_process/sign_up_info/InfoData;", "getChildrenList", "chipUpdateListener", "Lkotlin/Function0;", "", "getChipUpdateListener", "()Lkotlin/jvm/functions/Function0;", "chipVisible", "getChipVisible", "getContext", "()Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "cur", "getCur", "()Lkr/khs/studyfarm/login_process/select/SelectInfo;", "setCur", "(Lkr/khs/studyfarm/login_process/select/SelectInfo;)V", "error", "getError", "job", "Lkotlinx/coroutines/CompletableJob;", "parentList", "getParentList", "response", "getResponse", "returnSignup", "getReturnSignup", "selectData", "getSelectData", "()[Lkr/khs/studyfarm/login_process/select/SelectInfo;", "toast", "getToast", "chipUpdate", "doneSignup", "doneToast", "getParent", "gotoSignup", "onChildrenSelect", "data", "onParentSelect", "app_debug"})
public final class SelectViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _returnSignup = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<kr.khs.studyfarm.login_process.sign_up_info.InfoData>> parentList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<kr.khs.studyfarm.login_process.sign_up_info.InfoData>> childrenList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<kr.khs.studyfarm.login_process.select.SelectInfo>> _selectData = null;
    @org.jetbrains.annotations.Nullable()
    private kr.khs.studyfarm.login_process.select.SelectInfo cur;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.Boolean>> chipVisible = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.response.Response> _response = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.response.ResponseError> _error = null;
    private final androidx.lifecycle.MutableLiveData<kr.khs.studyfarm.network.ApiStatus> _apiStatus = null;
    private final kotlinx.coroutines.CompletableJob job = null;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _toast = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<kotlin.Unit> chipUpdateListener = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final boolean cityOrInterested = false;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getReturnSignup() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<kr.khs.studyfarm.login_process.sign_up_info.InfoData>> getParentList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<kr.khs.studyfarm.login_process.sign_up_info.InfoData>> getChildrenList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<kr.khs.studyfarm.login_process.select.SelectInfo>> get_selectData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.khs.studyfarm.login_process.select.SelectInfo[] getSelectData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kr.khs.studyfarm.login_process.select.SelectInfo getCur() {
        return null;
    }
    
    public final void setCur(@org.jetbrains.annotations.Nullable()
    kr.khs.studyfarm.login_process.select.SelectInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.Boolean>> getChipVisible() {
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
    
    public final void gotoSignup() {
    }
    
    public final void doneSignup() {
    }
    
    private final void getParent() {
    }
    
    public final void onParentSelect(@org.jetbrains.annotations.NotNull()
    kr.khs.studyfarm.login_process.sign_up_info.InfoData data) {
    }
    
    public final void onChildrenSelect(@org.jetbrains.annotations.NotNull()
    kr.khs.studyfarm.login_process.sign_up_info.InfoData data) {
    }
    
    public final void doneToast() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getChipUpdateListener() {
        return null;
    }
    
    public final void chipUpdate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public SelectViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean cityOrInterested, @org.jetbrains.annotations.Nullable()
    kr.khs.studyfarm.login_process.select.SelectInfo[] _dataInit) {
        super();
    }
}