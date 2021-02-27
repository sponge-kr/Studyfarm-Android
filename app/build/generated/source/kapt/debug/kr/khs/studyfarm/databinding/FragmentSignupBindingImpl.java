package kr.khs.studyfarm.databinding;
import kr.khs.studyfarm.R;
import kr.khs.studyfarm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSignupBindingImpl extends FragmentSignupBinding implements kr.khs.studyfarm.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearLayout, 8);
        sViewsWithIds.put(R.id.signemail_maintitle, 9);
        sViewsWithIds.put(R.id.signemail_subtitle, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView2;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView4;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView6;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback23;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.email.get()
            //         is viewModel.email.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // viewModel.email.get()
            java.lang.String viewModelEmailGet = null;
            // viewModel.email
            androidx.databinding.ObservableField<java.lang.String> viewModelEmail = null;
            // viewModel
            kr.khs.studyfarm.login_process.sign_up.SignupViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.email != null
            boolean viewModelEmailJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelEmail = viewModel.getEmail();

                viewModelEmailJavaLangObjectNull = (viewModelEmail) != (null);
                if (viewModelEmailJavaLangObjectNull) {




                    viewModelEmail.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.password.get()
            //         is viewModel.password.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // viewModel.password != null
            boolean viewModelPasswordJavaLangObjectNull = false;
            // viewModel.password.get()
            java.lang.String viewModelPasswordGet = null;
            // viewModel
            kr.khs.studyfarm.login_process.sign_up.SignupViewModel viewModel = mViewModel;
            // viewModel.password
            androidx.databinding.ObservableField<java.lang.String> viewModelPassword = null;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelPassword = viewModel.getPassword();

                viewModelPasswordJavaLangObjectNull = (viewModelPassword) != (null);
                if (viewModelPasswordJavaLangObjectNull) {




                    viewModelPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView6androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.nickname.get()
            //         is viewModel.nickname.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView6);
            // localize variables for thread safety
            // viewModel.nickname != null
            boolean viewModelNicknameJavaLangObjectNull = false;
            // viewModel.nickname.get()
            java.lang.String viewModelNicknameGet = null;
            // viewModel
            kr.khs.studyfarm.login_process.sign_up.SignupViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.nickname
            androidx.databinding.ObservableField<java.lang.String> viewModelNickname = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelNickname = viewModel.getNickname();

                viewModelNicknameJavaLangObjectNull = (viewModelNickname) != (null);
                if (viewModelNicknameJavaLangObjectNull) {




                    viewModelNickname.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentSignupBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentSignupBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.Button) bindings[7]
            , (com.google.android.material.textfield.TextInputLayout) bindings[1]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[5]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (com.google.android.material.textfield.TextInputEditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView4 = (com.google.android.material.textfield.TextInputEditText) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView6 = (com.google.android.material.textfield.TextInputEditText) bindings[6];
        this.mboundView6.setTag(null);
        this.signemailBtnNext.setTag(null);
        this.signemailEtEmail.setTag(null);
        this.signpwPassword.setTag(null);
        this.signupEtNickname.setTag(null);
        setRootTag(root);
        // listeners
        mCallback23 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((kr.khs.studyfarm.login_process.sign_up.SignupViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable kr.khs.studyfarm.login_process.sign_up.SignupViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelNextBtnActivated((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
            case 1 :
                return onChangeViewModelEmail((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelDuplicateNickname((androidx.databinding.ObservableBoolean) object, fieldId);
            case 3 :
                return onChangeViewModelPassword((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeViewModelNickname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelNextBtnActivated(androidx.lifecycle.LiveData<java.lang.Boolean> ViewModelNextBtnActivated, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelEmail(androidx.databinding.ObservableField<java.lang.String> ViewModelEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelDuplicateNickname(androidx.databinding.ObservableBoolean ViewModelDuplicateNickname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelPassword(androidx.databinding.ObservableField<java.lang.String> ViewModelPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelNickname(androidx.databinding.ObservableField<java.lang.String> ViewModelNickname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        androidx.lifecycle.LiveData<java.lang.Boolean> viewModelNextBtnActivated = null;
        java.lang.String viewModelPasswordGet = null;
        java.lang.Boolean viewModelNextBtnActivatedGetValue = null;
        kr.khs.studyfarm.StringRule viewModelRuleEMAILRULE = null;
        java.lang.String viewModelNicknameGet = null;
        kr.khs.studyfarm.Rule viewModelRule = null;
        java.lang.String viewModelEmailGet = null;
        kr.khs.studyfarm.StringRule viewModelRulePASSWORDRULE = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelEmail = null;
        boolean viewModelDuplicateNicknameGet = false;
        android.view.View.OnFocusChangeListener viewModelNicknameFocusChangeListener = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelNextBtnActivatedGetValue = false;
        androidx.databinding.ObservableBoolean viewModelDuplicateNickname = null;
        kr.khs.studyfarm.login_process.sign_up.SignupViewModel viewModel = mViewModel;
        androidx.databinding.ObservableField<java.lang.String> viewModelPassword = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelNickname = null;

        if ((dirtyFlags & 0x7fL) != 0) {


            if ((dirtyFlags & 0x61L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.nextBtnActivated
                        viewModelNextBtnActivated = viewModel.getNextBtnActivated();
                    }
                    updateLiveDataRegistration(0, viewModelNextBtnActivated);


                    if (viewModelNextBtnActivated != null) {
                        // read viewModel.nextBtnActivated.getValue()
                        viewModelNextBtnActivatedGetValue = viewModelNextBtnActivated.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.nextBtnActivated.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelNextBtnActivatedGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelNextBtnActivatedGetValue);
            }
            if ((dirtyFlags & 0x60L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.rule
                        viewModelRule = viewModel.getRule();
                        // read viewModel.nicknameFocusChangeListener
                        viewModelNicknameFocusChangeListener = viewModel.getNicknameFocusChangeListener();
                    }


                    if (viewModelRule != null) {
                        // read viewModel.rule.EMAIL_RULE
                        viewModelRuleEMAILRULE = viewModelRule.getEMAIL_RULE();
                        // read viewModel.rule.PASSWORD_RULE
                        viewModelRulePASSWORDRULE = viewModelRule.getPASSWORD_RULE();
                    }
            }
            if ((dirtyFlags & 0x62L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.email
                        viewModelEmail = viewModel.getEmail();
                    }
                    updateRegistration(1, viewModelEmail);


                    if (viewModelEmail != null) {
                        // read viewModel.email.get()
                        viewModelEmailGet = viewModelEmail.get();
                    }
            }
            if ((dirtyFlags & 0x64L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.duplicateNickname
                        viewModelDuplicateNickname = viewModel.getDuplicateNickname();
                    }
                    updateRegistration(2, viewModelDuplicateNickname);


                    if (viewModelDuplicateNickname != null) {
                        // read viewModel.duplicateNickname.get()
                        viewModelDuplicateNicknameGet = viewModelDuplicateNickname.get();
                    }
            }
            if ((dirtyFlags & 0x68L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.password
                        viewModelPassword = viewModel.getPassword();
                    }
                    updateRegistration(3, viewModelPassword);


                    if (viewModelPassword != null) {
                        // read viewModel.password.get()
                        viewModelPasswordGet = viewModelPassword.get();
                    }
            }
            if ((dirtyFlags & 0x70L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.nickname
                        viewModelNickname = viewModel.getNickname();
                    }
                    updateRegistration(4, viewModelNickname);


                    if (viewModelNickname != null) {
                        // read viewModel.nickname.get()
                        viewModelNicknameGet = viewModelNickname.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x62L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, viewModelEmailGet);
        }
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView6, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView6androidTextAttrChanged);
            this.signemailBtnNext.setOnClickListener(mCallback23);
            kr.khs.studyfarm.BindingUtilKt.setPasswordVisibility(this.signpwPassword, true);
        }
        if ((dirtyFlags & 0x68L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, viewModelPasswordGet);
        }
        if ((dirtyFlags & 0x70L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, viewModelNicknameGet);
        }
        if ((dirtyFlags & 0x61L) != 0) {
            // api target 1

            kr.khs.studyfarm.BindingUtilKt.setActivate(this.signemailBtnNext, androidxDatabindingViewDataBindingSafeUnboxViewModelNextBtnActivatedGetValue);
        }
        if ((dirtyFlags & 0x60L) != 0) {
            // api target 1

            kr.khs.studyfarm.BindingUtilKt.setErrorEnable(this.signemailEtEmail, viewModelRuleEMAILRULE, "이메일 형식이 맞지 않습니다.");
            kr.khs.studyfarm.BindingUtilKt.setErrorEnable(this.signpwPassword, viewModelRulePASSWORDRULE, "비밀번호의 형식(8~15자, 특수문자 포함)이 맞지 않습니다.");
            kr.khs.studyfarm.BindingUtilKt.checkNickName(this.signupEtNickname, viewModelNicknameFocusChangeListener);
        }
        if ((dirtyFlags & 0x64L) != 0) {
            // api target 1

            kr.khs.studyfarm.BindingUtilKt.setErrorEnableBoolean(this.signupEtNickname, viewModelDuplicateNicknameGet, "중복된 닉네임입니다.");
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        kr.khs.studyfarm.login_process.sign_up.SignupViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.onNextBtnClicked();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.nextBtnActivated
        flag 1 (0x2L): viewModel.email
        flag 2 (0x3L): viewModel.duplicateNickname
        flag 3 (0x4L): viewModel.password
        flag 4 (0x5L): viewModel.nickname
        flag 5 (0x6L): viewModel
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}