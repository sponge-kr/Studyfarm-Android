package kr.khs.studyfarm.login_process.select;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\tJ\u0006\u0010L\u001a\u00020*J\u0006\u0010M\u001a\u00020*J\u0006\u0010N\u001a\u00020*J\b\u0010O\u001a\u00020*H\u0002J\u0006\u0010P\u001a\u00020*J\u000e\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020&J\u000e\u0010S\u001a\u00020*2\u0006\u0010R\u001a\u00020&R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00160\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0018R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001d\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050%0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c8F\u00a2\u0006\u0006\u001a\u0004\b9\u0010\u001eR\u0011\u0010:\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010!R\u000e\u0010<\u001a\u00020=X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0018R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c8F\u00a2\u0006\u0006\u001a\u0004\bA\u0010\u001eR\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c8F\u00a2\u0006\u0006\u001a\u0004\bC\u0010\u001eR\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u001f\u0010G\u001a\u0010\u0012\f\u0012\n H*\u0004\u0018\u00010\u001a0\u001a0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010\u001eR\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c8F\u00a2\u0006\u0006\u001a\u0004\bK\u0010\u001e\u00a8\u0006T"}, d2 = {"Lkr/khs/studyfarm/login_process/select/SelectViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "cityOrInterested", "", "_dataInit", "", "Lkr/khs/studyfarm/login_process/select/SelectInfo;", "(Landroid/content/Context;Z[Lkr/khs/studyfarm/login_process/select/SelectInfo;)V", "MAX_CITY_SIZE", "", "MAX_STUDY_SIZE", "_apiStatus", "Landroidx/lifecycle/MutableLiveData;", "Lkr/khs/studyfarm/network/ApiStatus;", "_error", "Lkr/khs/studyfarm/network/response/ResponseError;", "_response", "Lkr/khs/studyfarm/network/response/Response;", "_returnSignup", "_selectData", "Ljava/util/ArrayList;", "get_selectData", "()Landroidx/lifecycle/MutableLiveData;", "_toast", "", "apiStatus", "Landroidx/lifecycle/LiveData;", "getApiStatus", "()Landroidx/lifecycle/LiveData;", "categoryChild", "getCategoryChild", "()Ljava/lang/String;", "categoryParent", "getCategoryParent", "childrenList", "", "Lkr/khs/studyfarm/login_process/sign_up_info/InfoData;", "getChildrenList", "chipUpdateListener", "Lkotlin/Function0;", "", "getChipUpdateListener", "()Lkotlin/jvm/functions/Function0;", "chipVisible", "getChipVisible", "getContext", "()Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "cur", "getCur", "()Lkr/khs/studyfarm/login_process/select/SelectInfo;", "setCur", "(Lkr/khs/studyfarm/login_process/select/SelectInfo;)V", "error", "getError", "hint", "getHint", "job", "Lkotlinx/coroutines/CompletableJob;", "parentList", "getParentList", "response", "getResponse", "returnSignup", "getReturnSignup", "selectData", "getSelectData", "()[Lkr/khs/studyfarm/login_process/select/SelectInfo;", "title", "kotlin.jvm.PlatformType", "getTitle", "toast", "getToast", "chipUpdate", "doneSignup", "doneToast", "getParent", "gotoSignup", "onChildrenSelect", "data", "onParentSelect", "app_debug"})
public final class SelectViewModel extends androidx.lifecycle.ViewModel {
    private final int MAX_CITY_SIZE = 2;
    private final int MAX_STUDY_SIZE = 3;
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
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String categoryParent = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String categoryChild = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String hint = null;
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
    public final androidx.lifecycle.LiveData<java.lang.String> getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategoryParent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategoryChild() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHint() {
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