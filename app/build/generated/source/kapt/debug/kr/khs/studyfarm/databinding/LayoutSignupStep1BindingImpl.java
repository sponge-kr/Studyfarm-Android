package kr.khs.studyfarm.databinding;
import kr.khs.studyfarm.R;
import kr.khs.studyfarm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayoutSignupStep1BindingImpl extends LayoutSignupStep1Binding implements kr.khs.studyfarm.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.step2_1, 15);
        sViewsWithIds.put(R.id.signup_horizonscroll_city, 16);
        sViewsWithIds.put(R.id.step2_2, 17);
        sViewsWithIds.put(R.id.linearLayout2, 18);
    }
    // views
    @NonNull
    private final kr.khs.studyfarm.view.custom.LevelSelectButton mboundView11;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView12;
    @NonNull
    private final kr.khs.studyfarm.view.custom.LevelSelectButton mboundView14;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView6;
    @NonNull
    private final kr.khs.studyfarm.view.custom.LevelSelectButton mboundView8;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView9;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback8;
    @Nullable
    private final android.view.View.OnClickListener mCallback7;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutSignupStep1BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private LayoutSignupStep1BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.TextView) bindings[1]
            , (com.google.android.material.chip.Chip) bindings[2]
            , (com.google.android.material.chip.Chip) bindings[3]
            , (com.google.android.material.chip.Chip) bindings[4]
            , (com.google.android.material.chip.Chip) bindings[7]
            , (com.google.android.material.chip.Chip) bindings[10]
            , (com.google.android.material.chip.Chip) bindings[13]
            , (android.widget.HorizontalScrollView) bindings[16]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[17]
            );
        this.mboundView11 = (kr.khs.studyfarm.view.custom.LevelSelectButton) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView12 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[12];
        this.mboundView12.setTag(null);
        this.mboundView14 = (kr.khs.studyfarm.view.custom.LevelSelectButton) bindings[14];
        this.mboundView14.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView8 = (kr.khs.studyfarm.view.custom.LevelSelectButton) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[9];
        this.mboundView9.setTag(null);
        this.signupBtnAddcity.setTag(null);
        this.signupChipCity1.setTag(null);
        this.signupChipCity2.setTag(null);
        this.signupChipCity3.setTag(null);
        this.signupChipStudy1.setTag(null);
        this.signupChipStudy2.setTag(null);
        this.signupChipStudy3.setTag(null);
        this.signupStep2.setTag(null);
        setRootTag(root);
        // listeners
        mCallback8 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 2);
        mCallback7 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
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
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelCityVisiblities((androidx.lifecycle.LiveData<java.lang.Integer[]>) object, fieldId);
            case 1 :
                return onChangeViewModelInterestingRating((androidx.databinding.ObservableField<java.lang.Integer[]>) object, fieldId);
            case 2 :
                return onChangeViewModelStudyTexts((androidx.lifecycle.LiveData<java.lang.String[]>) object, fieldId);
            case 3 :
                return onChangeViewModelCityTexts((androidx.lifecycle.LiveData<java.lang.String[]>) object, fieldId);
            case 4 :
                return onChangeViewModelStepVisibility((androidx.databinding.ObservableField<int[]>) object, fieldId);
            case 5 :
                return onChangeViewModelStudyVisiblities((androidx.lifecycle.LiveData<java.lang.Integer[]>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelCityVisiblities(androidx.lifecycle.LiveData<java.lang.Integer[]> ViewModelCityVisiblities, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelInterestingRating(androidx.databinding.ObservableField<java.lang.Integer[]> ViewModelInterestingRating, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelStudyTexts(androidx.lifecycle.LiveData<java.lang.String[]> ViewModelStudyTexts, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelCityTexts(androidx.lifecycle.LiveData<java.lang.String[]> ViewModelCityTexts, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelStepVisibility(androidx.databinding.ObservableField<int[]> ViewModelStepVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelStudyVisiblities(androidx.lifecycle.LiveData<java.lang.Integer[]> ViewModelStudyVisiblities, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
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
        java.lang.Integer viewModelInterestingRating1 = null;
        int viewModelStepVisibility0 = 0;
        int[] viewModelStepVisibilityGet = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelInterestingRating0 = 0;
        java.lang.Integer viewModelCityVisiblities1 = null;
        java.lang.String viewModelStudyTexts2 = null;
        java.lang.Integer viewModelStudyVisiblities1 = null;
        java.lang.String[] viewModelCityTextsGetValue = null;
        java.lang.String[] viewModelStudyTextsGetValue = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities0 = 0;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities0 = 0;
        java.lang.String viewModelCityTexts0 = null;
        java.lang.Integer viewModelInterestingRating2 = null;
        androidx.lifecycle.LiveData<java.lang.Integer[]> viewModelCityVisiblities = null;
        java.lang.Integer[] viewModelCityVisiblitiesGetValue = null;
        java.lang.Integer[] viewModelInterestingRatingGet = null;
        java.lang.Integer viewModelCityVisiblities2 = null;
        java.lang.String viewModelStudyTexts1 = null;
        androidx.databinding.ObservableField<java.lang.Integer[]> viewModelInterestingRating = null;
        java.lang.String viewModelCityTexts1 = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities1 = 0;
        java.lang.Integer viewModelStudyVisiblities0 = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelInterestingRating2 = 0;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities2 = 0;
        androidx.lifecycle.LiveData<java.lang.String[]> viewModelStudyTexts = null;
        java.lang.Integer[] viewModelStudyVisiblitiesGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String[]> viewModelCityTexts = null;
        java.lang.String viewModelStudyTexts0 = null;
        androidx.databinding.ObservableField<int[]> viewModelStepVisibility = null;
        androidx.lifecycle.LiveData<java.lang.Integer[]> viewModelStudyVisiblities = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities1 = 0;
        java.lang.String viewModelCityTexts2 = null;
        java.lang.Integer viewModelInterestingRating0 = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities2 = 0;
        java.lang.Integer viewModelCityVisiblities0 = null;
        java.lang.Integer viewModelStudyVisiblities2 = null;
        kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel viewModel = mViewModel;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelInterestingRating1 = 0;

        if ((dirtyFlags & 0xffL) != 0) {


            if ((dirtyFlags & 0xc1L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.cityVisiblities
                        viewModelCityVisiblities = viewModel.getCityVisiblities();
                    }
                    updateLiveDataRegistration(0, viewModelCityVisiblities);


                    if (viewModelCityVisiblities != null) {
                        // read viewModel.cityVisiblities.getValue()
                        viewModelCityVisiblitiesGetValue = viewModelCityVisiblities.getValue();
                    }


                    if (viewModelCityVisiblitiesGetValue != null) {
                        // read viewModel.cityVisiblities.getValue()[1]
                        viewModelCityVisiblities1 = getFromArray(viewModelCityVisiblitiesGetValue, 1);
                        // read viewModel.cityVisiblities.getValue()[2]
                        viewModelCityVisiblities2 = getFromArray(viewModelCityVisiblitiesGetValue, 2);
                        // read viewModel.cityVisiblities.getValue()[0]
                        viewModelCityVisiblities0 = getFromArray(viewModelCityVisiblitiesGetValue, 0);
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.cityVisiblities.getValue()[1])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities1 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelCityVisiblities1);
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.cityVisiblities.getValue()[2])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities2 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelCityVisiblities2);
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.cityVisiblities.getValue()[0])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities0 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelCityVisiblities0);
            }
            if ((dirtyFlags & 0xc2L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.interestingRating
                        viewModelInterestingRating = viewModel.getInterestingRating();
                    }
                    updateRegistration(1, viewModelInterestingRating);


                    if (viewModelInterestingRating != null) {
                        // read viewModel.interestingRating.get()
                        viewModelInterestingRatingGet = viewModelInterestingRating.get();
                    }


                    if (viewModelInterestingRatingGet != null) {
                        // read viewModel.interestingRating.get()[1]
                        viewModelInterestingRating1 = getFromArray(viewModelInterestingRatingGet, 1);
                        // read viewModel.interestingRating.get()[2]
                        viewModelInterestingRating2 = getFromArray(viewModelInterestingRatingGet, 2);
                        // read viewModel.interestingRating.get()[0]
                        viewModelInterestingRating0 = getFromArray(viewModelInterestingRatingGet, 0);
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.interestingRating.get()[1])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelInterestingRating1 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelInterestingRating1);
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.interestingRating.get()[2])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelInterestingRating2 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelInterestingRating2);
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.interestingRating.get()[0])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelInterestingRating0 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelInterestingRating0);
            }
            if ((dirtyFlags & 0xc4L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.studyTexts
                        viewModelStudyTexts = viewModel.getStudyTexts();
                    }
                    updateLiveDataRegistration(2, viewModelStudyTexts);


                    if (viewModelStudyTexts != null) {
                        // read viewModel.studyTexts.getValue()
                        viewModelStudyTextsGetValue = viewModelStudyTexts.getValue();
                    }


                    if (viewModelStudyTextsGetValue != null) {
                        // read viewModel.studyTexts.getValue()[2]
                        viewModelStudyTexts2 = getFromArray(viewModelStudyTextsGetValue, 2);
                        // read viewModel.studyTexts.getValue()[1]
                        viewModelStudyTexts1 = getFromArray(viewModelStudyTextsGetValue, 1);
                        // read viewModel.studyTexts.getValue()[0]
                        viewModelStudyTexts0 = getFromArray(viewModelStudyTextsGetValue, 0);
                    }
            }
            if ((dirtyFlags & 0xc8L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.cityTexts
                        viewModelCityTexts = viewModel.getCityTexts();
                    }
                    updateLiveDataRegistration(3, viewModelCityTexts);


                    if (viewModelCityTexts != null) {
                        // read viewModel.cityTexts.getValue()
                        viewModelCityTextsGetValue = viewModelCityTexts.getValue();
                    }


                    if (viewModelCityTextsGetValue != null) {
                        // read viewModel.cityTexts.getValue()[0]
                        viewModelCityTexts0 = getFromArray(viewModelCityTextsGetValue, 0);
                        // read viewModel.cityTexts.getValue()[1]
                        viewModelCityTexts1 = getFromArray(viewModelCityTextsGetValue, 1);
                        // read viewModel.cityTexts.getValue()[2]
                        viewModelCityTexts2 = getFromArray(viewModelCityTextsGetValue, 2);
                    }
            }
            if ((dirtyFlags & 0xd0L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.stepVisibility
                        viewModelStepVisibility = viewModel.getStepVisibility();
                    }
                    updateRegistration(4, viewModelStepVisibility);


                    if (viewModelStepVisibility != null) {
                        // read viewModel.stepVisibility.get()
                        viewModelStepVisibilityGet = viewModelStepVisibility.get();
                    }


                    if (viewModelStepVisibilityGet != null) {
                        // read viewModel.stepVisibility.get()[0]
                        viewModelStepVisibility0 = getFromArray(viewModelStepVisibilityGet, 0);
                    }
            }
            if ((dirtyFlags & 0xe0L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.studyVisiblities
                        viewModelStudyVisiblities = viewModel.getStudyVisiblities();
                    }
                    updateLiveDataRegistration(5, viewModelStudyVisiblities);


                    if (viewModelStudyVisiblities != null) {
                        // read viewModel.studyVisiblities.getValue()
                        viewModelStudyVisiblitiesGetValue = viewModelStudyVisiblities.getValue();
                    }


                    if (viewModelStudyVisiblitiesGetValue != null) {
                        // read viewModel.studyVisiblities.getValue()[1]
                        viewModelStudyVisiblities1 = getFromArray(viewModelStudyVisiblitiesGetValue, 1);
                        // read viewModel.studyVisiblities.getValue()[0]
                        viewModelStudyVisiblities0 = getFromArray(viewModelStudyVisiblitiesGetValue, 0);
                        // read viewModel.studyVisiblities.getValue()[2]
                        viewModelStudyVisiblities2 = getFromArray(viewModelStudyVisiblitiesGetValue, 2);
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.studyVisiblities.getValue()[1])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities1 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelStudyVisiblities1);
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.studyVisiblities.getValue()[0])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities0 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelStudyVisiblities0);
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.studyVisiblities.getValue()[2])
                    androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities2 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelStudyVisiblities2);
            }
        }
        // batch finished
        if ((dirtyFlags & 0xc2L) != 0) {
            // api target 1

            kr.khs.studyfarm.BindingUtilKt.setting(this.mboundView11, androidxDatabindingViewDataBindingSafeUnboxViewModelInterestingRating1);
            kr.khs.studyfarm.BindingUtilKt.setting(this.mboundView14, androidxDatabindingViewDataBindingSafeUnboxViewModelInterestingRating2);
            kr.khs.studyfarm.BindingUtilKt.setting(this.mboundView8, androidxDatabindingViewDataBindingSafeUnboxViewModelInterestingRating0);
        }
        if ((dirtyFlags & 0xe0L) != 0) {
            // api target 1

            this.mboundView12.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities2);
            this.mboundView6.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities0);
            this.mboundView9.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelStudyVisiblities1);
        }
        if ((dirtyFlags & 0x80L) != 0) {
            // api target 1

            this.mboundView5.setOnClickListener(mCallback8);
            this.signupBtnAddcity.setOnClickListener(mCallback7);
        }
        if ((dirtyFlags & 0xc1L) != 0) {
            // api target 1

            this.signupChipCity1.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities0);
            this.signupChipCity2.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities1);
            this.signupChipCity3.setVisibility(androidxDatabindingViewDataBindingSafeUnboxViewModelCityVisiblities2);
        }
        if ((dirtyFlags & 0xc8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupChipCity1, viewModelCityTexts0);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupChipCity2, viewModelCityTexts1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupChipCity3, viewModelCityTexts2);
        }
        if ((dirtyFlags & 0xc4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupChipStudy1, viewModelStudyTexts0);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupChipStudy2, viewModelStudyTexts1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupChipStudy3, viewModelStudyTexts2);
        }
        if ((dirtyFlags & 0xd0L) != 0) {
            // api target 1

            this.signupStep2.setVisibility(viewModelStepVisibility0);
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
        flag 0 (0x1L): viewModel.cityVisiblities
        flag 1 (0x2L): viewModel.interestingRating
        flag 2 (0x3L): viewModel.studyTexts
        flag 3 (0x4L): viewModel.cityTexts
        flag 4 (0x5L): viewModel.stepVisibility
        flag 5 (0x6L): viewModel.studyVisiblities
        flag 6 (0x7L): viewModel
        flag 7 (0x8L): null
    flag mapping end*/
    //end
}