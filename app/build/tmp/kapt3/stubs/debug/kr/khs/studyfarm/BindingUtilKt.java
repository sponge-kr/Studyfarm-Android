package kr.khs.studyfarm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u00a0\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000eH\u0007\u001a,\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0007\u001a \u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0007\u001a&\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0018\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007\u001a \u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bH\u0007\u001a \u0010%\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\r2\u0006\u0010&\u001a\u00020\'2\u0006\u0010$\u001a\u00020\bH\u0007\u001a\u0018\u0010(\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\r2\u0006\u0010)\u001a\u00020\'H\u0007\u001a>\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\'2\b\u0010,\u001a\u0004\u0018\u00010-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00072\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000100H\u0007\u001a\u001c\u00101\u001a\u00020\u0001*\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010\u001a\u001a\u000205H\u0007\u001a\u0014\u00106\u001a\u00020\u0001*\u0002072\u0006\u0010+\u001a\u00020\'H\u0007\u001a\u001a\u00108\u001a\u00020\u0001*\u0002022\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0007\u00a8\u0006<"}, d2 = {"addChip", "", "view", "Landroid/widget/Spinner;", "chipGroupId", "", "chips", "Ljava/util/ArrayList;", "", "addOnItemSelectedListener", "listener", "Landroid/widget/AdapterView$OnItemSelectedListener;", "checkNickName", "Lcom/google/android/material/textfield/TextInputLayout;", "Landroid/view/View$OnFocusChangeListener;", "cityChipEventListener", "Lcom/google/android/material/chip/Chip;", "chipList", "", "cityList", "greetingMessage", "Landroid/widget/TextView;", "res", "Landroid/content/res/Resources;", "nickname", "numberPickerSetting", "adapter", "Landroid/widget/ArrayAdapter;", "ratingBarSetting", "Landroid/widget/RatingBar;", "value", "", "setErrorEnable", "textInputLayout", "stringRule", "Lkr/khs/studyfarm/StringRule;", "errorMsg", "setErrorEnableBoolean", "boolean", "", "setPasswordVisibility", "enabled", "setVisibility", "visible", "city", "Lkr/khs/studyfarm/login_process/select/SelectInfo;", "arr", "update", "Lkotlin/Function0;", "addAdapterNTabLayout", "Landroidx/viewpager/widget/ViewPager;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "Lkr/khs/studyfarm/mainpage/vp/InterestingVPAdapter;", "setVisible", "Landroid/view/View;", "updateItems", "list", "", "Lkr/khs/studyfarm/network/response/UserInterestingInfo;", "app_debug"})
public final class BindingUtilKt {
    
    @androidx.databinding.BindingAdapter(value = {"app:validation", "app:errorMsg"})
    public static final void setErrorEnable(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout textInputLayout, @org.jetbrains.annotations.NotNull()
    kr.khs.studyfarm.StringRule stringRule, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMsg) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:validationBoolean", "app:errorMsgBoolean"})
    public static final void setErrorEnableBoolean(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout textInputLayout, boolean p1_32355860, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMsg) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"setPasswordVisibilityToggle"})
    public static final void setPasswordVisibility(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout textInputLayout, boolean enabled) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:cityChipList", "app:cityList"})
    public static final void cityChipEventListener(@org.jetbrains.annotations.NotNull()
    com.google.android.material.chip.Chip view, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> chipList, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Integer> cityList) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:connectChipGroup", "app:chipsLiveData"})
    public static final void addChip(@org.jetbrains.annotations.NotNull()
    android.widget.Spinner view, int chipGroupId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> chips) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:setOnItemSelectedListener"})
    public static final void addOnItemSelectedListener(@org.jetbrains.annotations.NotNull()
    android.widget.Spinner view, @org.jetbrains.annotations.NotNull()
    android.widget.AdapterView.OnItemSelectedListener listener) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:nicknameCheck"})
    public static final void checkNickName(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout view, @org.jetbrains.annotations.NotNull()
    android.view.View.OnFocusChangeListener listener) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:visibility", "app:chipText", "app:chipArray", "app:chipUpdate"})
    public static final void setVisibility(@org.jetbrains.annotations.NotNull()
    com.google.android.material.chip.Chip view, boolean visible, @org.jetbrains.annotations.Nullable()
    kr.khs.studyfarm.login_process.select.SelectInfo city, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<kr.khs.studyfarm.login_process.select.SelectInfo> arr, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> update) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:birthYearAdapter", "app:birthYearSelectedListener"})
    public static final void numberPickerSetting(@org.jetbrains.annotations.NotNull()
    android.widget.Spinner view, @org.jetbrains.annotations.NotNull()
    android.widget.ArrayAdapter<java.lang.Integer> adapter, @org.jetbrains.annotations.NotNull()
    android.widget.AdapterView.OnItemSelectedListener listener) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:ratingBarSetting"})
    public static final void ratingBarSetting(@org.jetbrains.annotations.NotNull()
    android.widget.RatingBar view, float value) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:resources", "app:whoLogined"})
    public static final void greetingMessage(@org.jetbrains.annotations.NotNull()
    android.widget.TextView view, @org.jetbrains.annotations.NotNull()
    android.content.res.Resources res, @org.jetbrains.annotations.NotNull()
    java.lang.String nickname) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:tabLayout", "app:vpAdapter"})
    public static final void addAdapterNTabLayout(@org.jetbrains.annotations.NotNull()
    androidx.viewpager.widget.ViewPager $this$addAdapterNTabLayout, @org.jetbrains.annotations.NotNull()
    com.google.android.material.tabs.TabLayout tabLayout, @org.jetbrains.annotations.NotNull()
    kr.khs.studyfarm.mainpage.vp.InterestingVPAdapter adapter) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:interestings"})
    public static final void updateItems(@org.jetbrains.annotations.NotNull()
    androidx.viewpager.widget.ViewPager $this$updateItems, @org.jetbrains.annotations.NotNull()
    java.util.List<kr.khs.studyfarm.network.response.UserInterestingInfo> list) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"app:layout_visibility"})
    public static final void setVisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$setVisible, boolean visible) {
    }
}