package kr.khs.studyfarm.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ%\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0011\u0010\u001b\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ%\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010\u001a\u001a\u00020\u00102\b\b\u0001\u0010 \u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001b\u0010#\u001a\u00020\u00032\b\b\u0001\u0010$\u001a\u00020%H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J%\u0010\'\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00102\b\b\u0001\u0010(\u001a\u00020)H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J\u001b\u0010+\u001a\u00020\u00032\b\b\u0001\u0010\u000f\u001a\u00020,H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J%\u0010.\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00102\b\b\u0001\u0010/\u001a\u000200H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lkr/khs/studyfarm/network/StudyFarmApiService;", "", "addUser", "Lkr/khs/studyfarm/network/response/Response;", "user", "Lkr/khs/studyfarm/network/request/User;", "(Lkr/khs/studyfarm/network/request/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addUserInfo", "seq", "", "userInfo", "Lkr/khs/studyfarm/network/request/UserInfo;", "(ILkr/khs/studyfarm/network/request/UserInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCode", "Lkr/khs/studyfarm/network/response/GetCodeResponse;", "email", "", "code", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkEmail", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkEmailActive", "checkNickName", "param", "checkToken", "Lkr/khs/studyfarm/network/response/CheckTokenResponse;", "token", "getStates", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStudies", "getUserInfo", "Lkr/khs/studyfarm/network/response/GetUserResponse;", "userSeq", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginByKakao", "loginUser", "login", "Lkr/khs/studyfarm/network/request/LoginData;", "(Lkr/khs/studyfarm/network/request/LoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeStudy", "makeStudyData", "Lkr/khs/studyfarm/network/request/MakeStudyData;", "(Ljava/lang/String;Lkr/khs/studyfarm/network/request/MakeStudyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCode", "Lkr/khs/studyfarm/network/request/EmailData;", "(Lkr/khs/studyfarm/network/request/EmailData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signupByKakao", "kakaoSignup", "Lkr/khs/studyfarm/network/request/KakaoSignupData;", "(Ljava/lang/String;Lkr/khs/studyfarm/network/request/KakaoSignupData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface StudyFarmApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object addUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    kr.khs.studyfarm.network.request.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/info/{seq}")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object addUserInfo(@retrofit2.http.Path(value = "seq")
    int seq, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    kr.khs.studyfarm.network.request.UserInfo userInfo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "auth/login")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object loginUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    kr.khs.studyfarm.network.request.LoginData login, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/check-email/{email}")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object checkEmail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "email")
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/check-nickname")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object checkNickName(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "nickname")
    java.lang.String param, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "utils/states")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object getStates(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "utils/categories")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object getStudies(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/check-active")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object checkEmailActive(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/{userSeq}")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object getUserInfo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @retrofit2.http.Path(value = "userSeq")
    int userSeq, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.GetUserResponse> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "auth/login/kakao")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object loginByKakao(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "access_token")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/kakao")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object signupByKakao(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "access_token")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    kr.khs.studyfarm.network.request.KakaoSignupData kakaoSignup, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "auth/check-token")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object checkToken(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "check_token")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.CheckTokenResponse> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "utils/send-mail/code")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object sendCode(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    kr.khs.studyfarm.network.request.EmailData email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "auth/check-code")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object checkCode(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "code")
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.GetCodeResponse> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "study")
    @retrofit2.http.Headers(value = {"Content-Type: application/hal+json;charset=UTF-8", "Accept: application/hal+json"})
    public abstract java.lang.Object makeStudy(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    kr.khs.studyfarm.network.request.MakeStudyData makeStudyData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.khs.studyfarm.network.response.Response> p2);
}