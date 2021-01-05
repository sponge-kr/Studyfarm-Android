package kr.khs.studyfarm.databinding;
import kr.khs.studyfarm.R;
import kr.khs.studyfarm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayoutSignupStep2BindingImpl extends LayoutSignupStep2Binding implements kr.khs.studyfarm.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.signup_iv_profile, 4);
        sViewsWithIds.put(R.id.step3_1, 5);
        sViewsWithIds.put(R.id.step3_2, 6);
        sViewsWithIds.put(R.id.singup_radiogroup_sex, 7);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback8;
    @Nullable
    private final android.view.View.OnClickListener mCallback9;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutSignupStep2BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private LayoutSignupStep2BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.shawnlin.numberpicker.NumberPicker) bindings[1]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.RadioButton) bindings[2]
            , (android.widget.RadioButton) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.RadioGroup) bindings[7]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            );
        this.signupAgePicker.setTag(null);
        this.signupSexMan.setTag(null);
        this.signupSexWoman.setTag(null);
        this.signupStep3.setTag(null);
        setRootTag(root);
        // listeners
        mCallback8 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 1);
        mCallback9 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.gender == variableId) {
            setGender((kr.khs.studyfarm.Gender) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setGender(@Nullable kr.khs.studyfarm.Gender Gender) {
        this.mGender = Gender;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.gender);
        super.requestRebind();
    }
    public void setViewModel(@Nullable kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelAge((androidx.databinding.ObservableField<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeViewModelStepVisibility((androidx.databinding.ObservableField<int[]>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelAge(androidx.databinding.ObservableField<java.lang.Integer> ViewModelAge, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelStepVisibility(androidx.databinding.ObservableField<int[]> ViewModelStepVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        kr.khs.studyfarm.Gender viewModelGender = null;
        androidx.databinding.ObservableField<java.lang.Integer> viewModelAge = null;
        int[] viewModelStepVisibilityGet = null;
        boolean viewModelGenderEqualsGenderWoman = false;
        androidx.databinding.ObservableField<int[]> viewModelStepVisibility = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelAgeGet = 0;
        boolean viewModelGenderEqualsGenderMan = false;
        int viewModelStepVisibility1 = 0;
        java.lang.Integer viewModelAgeGet = null;
        kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x1bL) != 0) {


            if ((dirtyFlags & 0x18L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.gender
                        viewModelGender = viewModel.getGender();
                    }


                    if (viewModelGender != null) {
                        // read viewModel.gender.equals(Gender.Woman)
                        viewModelGenderEqualsGenderWoman = viewModelGender.equals(kr.khs.studyfarm.Gender.Woman);
                        // read viewModel.gender.equals(Gender.Man)
                        viewModelGenderEqualsGenderMan = viewModelGender.equals(kr.khs.studyfarm.Gender.Man);
                    }
            }
            if ((dirtyFlags & 0x19L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.age
                        viewModelAge = viewModel.getAge();
                    }
                    updateRegistration(0, viewModelAge);


                    if (viewModelAge != null) {
                        // read viewModel.age.get()
                        viewModelAgeGet = viewModelAge.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.age.get())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelAgeGet = androidx.databinding.ViewDataBinding.safeUnbox(viewModelAgeGet);
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.stepVisibility
                        viewModelStepVisibility = viewModel.getStepVisibility();
                    }
                    updateRegistration(1, viewModelStepVisibility);


                    if (viewModelStepVisibility != null) {
                        // read viewModel.stepVisibility.get()
                        viewModelStepVisibilityGet = viewModelStepVisibility.get();
                    }


                    if (viewModelStepVisibilityGet != null) {
                        // read viewModel.stepVisibility.get()[1]
                        viewModelStepVisibility1 = getFromArray(viewModelStepVisibilityGet, 1);
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            kr.khs.studyfarm.BindingUtilKt.numberPickerSetting(this.signupAgePicker, androidxDatabindingViewDataBindingSafeUnboxViewModelAgeGet);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.signupSexMan, viewModelGenderEqualsGenderMan);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.signupSexWoman, viewModelGenderEqualsGenderWoman);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.signupSexMan.setOnClickListener(mCallback8);
            this.signupSexWoman.setOnClickListener(mCallback9);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            this.signupStep3.setVisibility(viewModelStepVisibility1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // gender
                kr.khs.studyfarm.Gender gender = mGender;
                // viewModel
                kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {




                    viewModel.selectGender(kr.khs.studyfarm.Gender.Man);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // gender
                kr.khs.studyfarm.Gender gender = mGender;
                // viewModel
                kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {




                    viewModel.selectGender(kr.khs.studyfarm.Gender.Woman);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.age
        flag 1 (0x2L): viewModel.stepVisibility
        flag 2 (0x3L): gender
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}