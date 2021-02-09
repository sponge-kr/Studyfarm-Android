package kr.khs.studyfarm.databinding;
import kr.khs.studyfarm.R;
import kr.khs.studyfarm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BottomsheetAgreementBindingImpl extends BottomsheetAgreementBinding implements kr.khs.studyfarm.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.agreement_cl_allAgree, 4);
        sViewsWithIds.put(R.id.agreement_tv_all, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback17;
    // values
    // listeners
    private OnClickListenerImpl mViewModelOnAllAgreeCheckBoxListenerAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener agreementCheckAllandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.allAgreeChecked.get()
            //         is viewModel.allAgreeChecked.set((boolean) callbackArg_0)
            boolean callbackArg_0 = agreementCheckAll.isChecked();
            // localize variables for thread safety
            // viewModel.allAgreeChecked
            androidx.databinding.ObservableBoolean viewModelAllAgreeChecked = null;
            // viewModel.allAgreeChecked.get()
            boolean viewModelAllAgreeCheckedGet = false;
            // viewModel
            kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.allAgreeChecked != null
            boolean viewModelAllAgreeCheckedJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelAllAgreeChecked = viewModel.getAllAgreeChecked();

                viewModelAllAgreeCheckedJavaLangObjectNull = (viewModelAllAgreeChecked) != (null);
                if (viewModelAllAgreeCheckedJavaLangObjectNull) {




                    viewModelAllAgreeChecked.set(((boolean) (callbackArg_0)));
                }
            }
        }
    };

    public BottomsheetAgreementBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private BottomsheetAgreementBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.Button) bindings[3]
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (android.widget.TextView) bindings[5]
            );
        this.agreementBtnNext.setTag(null);
        this.agreementCheckAll.setTag(null);
        this.agreementRv.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback17 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            setViewModel((kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelAllAgreeChecked((androidx.databinding.ObservableBoolean) object, fieldId);
            case 1 :
                return onChangeViewModelBtnEnable((androidx.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelAllAgreeChecked(androidx.databinding.ObservableBoolean ViewModelAllAgreeChecked, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelBtnEnable(androidx.databinding.ObservableBoolean ViewModelBtnEnable, int fieldId) {
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
        boolean viewModelBtnEnableGet = false;
        androidx.databinding.ObservableBoolean viewModelAllAgreeChecked = null;
        android.view.View.OnClickListener viewModelOnAllAgreeCheckBoxListenerAndroidViewViewOnClickListener = null;
        boolean viewModelAllAgreeCheckedGet = false;
        java.util.ArrayList<kr.khs.studyfarm.login_process.agreement_bottomsheet.TermsData> viewModelTermsList = null;
        androidx.databinding.ObservableBoolean viewModelBtnEnable = null;
        kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.allAgreeChecked
                        viewModelAllAgreeChecked = viewModel.getAllAgreeChecked();
                    }
                    updateRegistration(0, viewModelAllAgreeChecked);


                    if (viewModelAllAgreeChecked != null) {
                        // read viewModel.allAgreeChecked.get()
                        viewModelAllAgreeCheckedGet = viewModelAllAgreeChecked.get();
                    }
            }
            if ((dirtyFlags & 0xcL) != 0) {

                    if (viewModel != null) {
                        // read viewModel::onAllAgreeCheckBoxListener
                        viewModelOnAllAgreeCheckBoxListenerAndroidViewViewOnClickListener = (((mViewModelOnAllAgreeCheckBoxListenerAndroidViewViewOnClickListener == null) ? (mViewModelOnAllAgreeCheckBoxListenerAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewModelOnAllAgreeCheckBoxListenerAndroidViewViewOnClickListener).setValue(viewModel));
                        // read viewModel.termsList
                        viewModelTermsList = viewModel.getTermsList();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.btnEnable
                        viewModelBtnEnable = viewModel.getBtnEnable();
                    }
                    updateRegistration(1, viewModelBtnEnable);


                    if (viewModelBtnEnable != null) {
                        // read viewModel.btnEnable.get()
                        viewModelBtnEnableGet = viewModelBtnEnable.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            kr.khs.studyfarm.BindingUtilKt.setActivate(this.agreementBtnNext, viewModelBtnEnableGet);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.agreementBtnNext.setOnClickListener(mCallback17);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.agreementCheckAll, (android.widget.CompoundButton.OnCheckedChangeListener)null, agreementCheckAllandroidCheckedAttrChanged);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.agreementCheckAll, viewModelAllAgreeCheckedGet);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            this.agreementCheckAll.setOnClickListener(viewModelOnAllAgreeCheckBoxListenerAndroidViewViewOnClickListener);
            kr.khs.studyfarm.BindingUtilKt.bindTermsItem(this.agreementRv, viewModelTermsList);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel value;
        public OnClickListenerImpl setValue(kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onAllAgreeCheckBoxListener(arg0); 
        }
    }
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.doNextBtnClicked();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.allAgreeChecked
        flag 1 (0x2L): viewModel.btnEnable
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}