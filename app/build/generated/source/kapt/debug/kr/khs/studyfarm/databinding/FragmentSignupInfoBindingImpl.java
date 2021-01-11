package kr.khs.studyfarm.databinding;
import kr.khs.studyfarm.R;
import kr.khs.studyfarm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSignupInfoBindingImpl extends FragmentSignupInfoBinding implements kr.khs.studyfarm.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(7);
        sIncludes.setIncludes(0, 
            new String[] {"layout_signup_step1", "layout_signup_step2"},
            new int[] {5, 6},
            new int[] {kr.khs.studyfarm.R.layout.layout_signup_step1,
                kr.khs.studyfarm.R.layout.layout_signup_step2});
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @Nullable
    private final kr.khs.studyfarm.databinding.LayoutSignupStep1Binding mboundView01;
    @Nullable
    private final kr.khs.studyfarm.databinding.LayoutSignupStep2Binding mboundView02;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback14;
    @Nullable
    private final android.view.View.OnClickListener mCallback13;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSignupInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentSignupInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.Button) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView01 = (kr.khs.studyfarm.databinding.LayoutSignupStep1Binding) bindings[5];
        setContainedBinding(this.mboundView01);
        this.mboundView02 = (kr.khs.studyfarm.databinding.LayoutSignupStep2Binding) bindings[6];
        setContainedBinding(this.mboundView02);
        this.signupBtnNext.setTag(null);
        this.signupBtnSkip.setTag(null);
        this.signupMaintitle.setTag(null);
        this.signupSubtitle.setTag(null);
        setRootTag(root);
        // listeners
        mCallback14 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 2);
        mCallback13 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        mboundView01.invalidateAll();
        mboundView02.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView01.hasPendingBindings()) {
            return true;
        }
        if (mboundView02.hasPendingBindings()) {
            return true;
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
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        mboundView01.setLifecycleOwner(lifecycleOwner);
        mboundView02.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelMainTitle((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelStepVisibility((androidx.databinding.ObservableField<int[]>) object, fieldId);
            case 2 :
                return onChangeViewModelSubTitle((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelMainTitle(androidx.lifecycle.LiveData<java.lang.String> ViewModelMainTitle, int fieldId) {
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
    private boolean onChangeViewModelSubTitle(androidx.lifecycle.LiveData<java.lang.String> ViewModelSubTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        java.lang.String viewModelSubTitleGetValue = null;
        java.lang.String viewModelMainTitleGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> viewModelMainTitle = null;
        int viewModelStepVisibility2 = 0;
        int[] viewModelStepVisibilityGet = null;
        kr.khs.studyfarm.login_process.sign_up_info.SignupInfoViewModel viewModel = mViewModel;
        androidx.databinding.ObservableField<int[]> viewModelStepVisibility = null;
        androidx.lifecycle.LiveData<java.lang.String> viewModelSubTitle = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.mainTitle
                        viewModelMainTitle = viewModel.getMainTitle();
                    }
                    updateLiveDataRegistration(0, viewModelMainTitle);


                    if (viewModelMainTitle != null) {
                        // read viewModel.mainTitle.getValue()
                        viewModelMainTitleGetValue = viewModelMainTitle.getValue();
                    }
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
                        // read viewModel.stepVisibility.get()[2]
                        viewModelStepVisibility2 = getFromArray(viewModelStepVisibilityGet, 2);
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.subTitle
                        viewModelSubTitle = viewModel.getSubTitle();
                    }
                    updateLiveDataRegistration(2, viewModelSubTitle);


                    if (viewModelSubTitle != null) {
                        // read viewModel.subTitle.getValue()
                        viewModelSubTitleGetValue = viewModelSubTitle.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            this.mboundView01.setViewModel(viewModel);
            this.mboundView02.setViewModel(viewModel);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.signupBtnNext.setOnClickListener(mCallback13);
            this.signupBtnSkip.setOnClickListener(mCallback14);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            this.signupBtnSkip.setVisibility(viewModelStepVisibility2);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupMaintitle, viewModelMainTitleGetValue);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.signupSubtitle, viewModelSubTitleGetValue);
        }
        executeBindingsOn(mboundView01);
        executeBindingsOn(mboundView02);
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


                    viewModel.onNextBtnClicked();
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


                    viewModel.onNextBtnClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.mainTitle
        flag 1 (0x2L): viewModel.stepVisibility
        flag 2 (0x3L): viewModel.subTitle
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}