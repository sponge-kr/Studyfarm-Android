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
        sViewsWithIds.put(R.id.step2_1, 10);
        sViewsWithIds.put(R.id.signup_horizonscroll_city, 11);
        sViewsWithIds.put(R.id.step2_2, 12);
        sViewsWithIds.put(R.id.linearLayout2, 13);
    }
    // views
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final kr.khs.studyfarm.view.custom.LevelSelectButton mboundView7;
    @NonNull
    private final kr.khs.studyfarm.view.custom.LevelSelectButton mboundView8;
    @NonNull
    private final kr.khs.studyfarm.view.custom.LevelSelectButton mboundView9;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutSignupStep2BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private LayoutSignupStep2BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.TextView) bindings[1]
            , (com.google.android.material.chip.Chip) bindings[2]
            , (com.google.android.material.chip.Chip) bindings[3]
            , (android.widget.HorizontalScrollView) bindings[11]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[12]
            );
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView7 = (kr.khs.studyfarm.view.custom.LevelSelectButton) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (kr.khs.studyfarm.view.custom.LevelSelectButton) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (kr.khs.studyfarm.view.custom.LevelSelectButton) bindings[9];
        this.mboundView9.setTag(null);
        this.signupBtnAddcity.setTag(null);
        this.signupChipCity1.setTag(null);
        this.signupChipCity2.setTag(null);
        this.signupStep2.setTag(null);
        this.signupTvCitycount.setTag(null);
        this.signupTvStudycount.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 2);
        mCallback3 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 1);
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
            setViewModel((kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel ViewModel) {
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
                return onChangeViewModelCityTexts((androidx.lifecycle.LiveData<java.lang.String[]>) object, fieldId);
            case 1 :
                return onChangeViewModelStudyCountText((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelStudyVisiblities((androidx.lifecycle.LiveData<java.lang.Integer[]>) object, fieldId);
            case 3 :
                return onChangeViewModelCityVisiblities((androidx.lifecycle.LiveData<java.lang.Integer[]>) object, fieldId);
            case 4 :
                return onChangeViewModelCityCountText((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelCityTexts(androidx.lifecycle.LiveData<java.lang.String[]> ViewModelCityTexts, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelStudyCountText(androidx.lifecycle.LiveData<java.lang.String> ViewModelStudyCountText, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelStudyVisiblities(androidx.lifecycle.LiveData<java.lang.Integer[]> ViewModelStudyVisiblities, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelCityVisiblities(androidx.lifecycle.LiveData<java.lang.Integer[]> ViewModelCityVisiblities, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelCityCountText(androidx.lifecycle.LiveData<java.lang.String> ViewModelCityCountText, int fieldId) {
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
        java.lang.String viewModelCityTexts1 = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities1 = 0;
        java.lang.Integer viewModelStudyVisiblities0 = null;
        java.lang.String viewModelCityCountTextGetValue = null;
        java.lang.Integer viewModelCityVisiblities1 = null;
        java.lang.Integer[] viewModelStudyVisiblitiesGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String[]> viewModelCityTexts = null;
        java.lang.Integer viewModelStudyVisiblities1 = null;
        java.lang.String[] viewModelCityTextsGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> viewModelStudyCountText = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities0 = 0;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities0 = 0;
        java.lang.String viewModelStudyCountTextGetValue = null;
        java.lang.String viewModelCityTexts0 = null;
        androidx.lifecycle.LiveData<java.lang.Integer[]> viewModelStudyVisiblities = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities1 = 0;
        androidx.lifecycle.LiveData<java.lang.Integer[]> viewModelCityVisiblities = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities2 = 0;
        java.lang.Integer[] viewModelCityVisiblitiesGetValue = null;
        java.lang.Integer viewModelCityVisiblities0 = null;
        androidx.lifecycle.LiveData<java.lang.String> viewModelCityCountText = null;
        java.lang.Integer viewModelStudyVisiblities2 = null;
        kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7fL) != 0) {


            if ((dirtyFlags & 0x61L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.cityTexts
                        viewModelCityTexts = viewModel.getCityTexts();
                    }
                    updateLiveDataRegistration(0, viewModelCityTexts);


                    if (viewModelCityTexts != null) {
                        // read viewModel.cityTexts.getValue()
                        viewModelCityTextsGetValue = viewModelCityTexts.getValue();
                    }


                    if (viewModelCityTextsGetValue != null) {
                        // read viewModel.cityTexts.getValue()[1]
                        viewModelCityTexts1 = getFromArray(viewModelCityTextsGetValue, 1);
                        // read viewModel.cityTexts.getValue()[0]
                        viewModelCityTexts0 = getFromArray(viewModelCityTextsGetValue, 0);
                    }
            }
            if ((dirtyFlags & 0x62L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.studyCountText
                        viewModelStudyCountText = viewModel.getStudyCountText();
                    }
                    updateLiveDataRegistration(1, viewModelStudyCountText);


                    if (viewModelStudyCountText != null) {
                        // read viewModel.studyCountText.getValue()
                        viewModelStudyCountTextGetValue = viewModelStudyCountText.getValue();
                    }
            }
            if ((dirtyFlags & 0x64L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.studyVisiblities
                        viewModelStudyVisiblities = viewModel.getStudyVisiblities();
                    }
                    updateLiveDataRegistration(2, viewModelStudyVisiblities);


                    if (viewModelStudyVisiblities != null) {
                        // read viewModel.studyVisiblities.getValue()
                        viewModelStudyVisiblitiesGetValue = viewModelStudyVisiblities.getValue();
                    }


                    if (viewModelStudyVisiblitiesGetValue != null) {
                        // read viewModel.studyVisiblities.getValue()[0]
                        viewModelStudyVisiblities0 = getFromArray(viewModelStudyVisiblitiesGetValue, 0);
                        // read viewModel.studyVisiblities.getValue()[1]
                        viewModelStudyVisiblities1 = getFromArray(viewModelStudyVisiblitiesGetValue, 1);
                        // read viewModel.studyVisiblities.getValue()[2]
                        viewModelStudyVisiblities2 = getFromArray(viewModelStudyVisiblitiesGetValue, 2);
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.studyVisiblities.getValue()[0])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities0 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelStudyVisiblities0);
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.studyVisiblities.getValue()[1])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities1 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelStudyVisiblities1);
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.studyVisiblities.getValue()[2])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities2 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelStudyVisiblities2);
            }
            if ((dirtyFlags & 0x68L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.cityVisiblities
                        viewModelCityVisiblities = viewModel.getCityVisiblities();
                    }
                    updateLiveDataRegistration(3, viewModelCityVisiblities);


                    if (viewModelCityVisiblities != null) {
                        // read viewModel.cityVisiblities.getValue()
                        viewModelCityVisiblitiesGetValue = viewModelCityVisiblities.getValue();
                    }


                    if (viewModelCityVisiblitiesGetValue != null) {
                        // read viewModel.cityVisiblities.getValue()[1]
                        viewModelCityVisiblities1 = getFromArray(viewModelCityVisiblitiesGetValue, 1);
                        // read viewModel.cityVisiblities.getValue()[0]
                        viewModelCityVisiblities0 = getFromArray(viewModelCityVisiblitiesGetValue, 0);
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.cityVisiblities.getValue()[1])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities1 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelCityVisiblities1);
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.cityVisiblities.getValue()[0])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities0 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelCityVisiblities0);
            }
            if ((dirtyFlags & 0x70L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.cityCountText
                        viewModelCityCountText = viewModel.getCityCountText();
                    }
                    updateLiveDataRegistration(4, viewModelCityCountText);


                    if (viewModelCityCountText != null) {
                        // read viewModel.cityCountText.getValue()
                        viewModelCityCountTextGetValue = viewModelCityCountText.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            this.mboundView4.setOnClickListener(mCallback4);
            this.signupBtnAddcity.setOnClickListener(mCallback3);
        }
        if ((dirtyFlags & 0x64L) != 0) {
            // api target 1

            this.mboundView7.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities0);
            this.mboundView8.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities1);
            this.mboundView9.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities2);
        }
        if ((dirtyFlags & 0x68L) != 0) {
            // api target 1

            this.signupChipCity1.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities0);
            this.signupChipCity2.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities1);
        }
        if ((dirtyFlags & 0x61L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupChipCity1, viewModelCityTexts0);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupChipCity2, viewModelCityTexts1);
        }
        if ((dirtyFlags & 0x70L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupTvCitycount, viewModelCityCountTextGetValue);
        }
        if ((dirtyFlags & 0x62L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupTvStudycount, viewModelStudyCountTextGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // viewModel
                kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.doSelectInteresting();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // viewModel
                kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.doSelectCity();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.cityTexts
        flag 1 (0x2L): viewModel.studyCountText
        flag 2 (0x3L): viewModel.studyVisiblities
        flag 3 (0x4L): viewModel.cityVisiblities
        flag 4 (0x5L): viewModel.cityCountText
        flag 5 (0x6L): viewModel
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}