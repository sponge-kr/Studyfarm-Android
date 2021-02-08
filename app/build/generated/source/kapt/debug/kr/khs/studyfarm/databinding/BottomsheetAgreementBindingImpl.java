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
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback17;
    @Nullable
    private final android.view.View.OnClickListener mCallback18;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener agreementCheck1androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.checked.get()[0]
            //         is androidx.databinding.ViewDataBinding.setTo(viewModel.checked.get(), 0, callbackArg_0)
            boolean callbackArg_0 = agreementCheck1.isChecked();
            // localize variables for thread safety
            // viewModel.checked.get()
            boolean[] viewModelCheckedGet = null;
            // viewModel.checked
            androidx.databinding.ObservableField<boolean[]> viewModelChecked = null;
            // viewModel.checked != null
            boolean viewModelCheckedJavaLangObjectNull = false;
            // viewModel.checked.get()[0]
            boolean viewModelChecked0 = false;
            // viewModel
            kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelChecked = viewModel.getChecked();

                viewModelCheckedJavaLangObjectNull = (viewModelChecked) != (null);
                if (viewModelCheckedJavaLangObjectNull) {


                    viewModelCheckedGet = viewModelChecked.get();



                    androidx.databinding.ViewDataBinding.setTo(viewModelCheckedGet, 0, callbackArg_0);
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener agreementCheck2androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.checked.get()[1]
            //         is androidx.databinding.ViewDataBinding.setTo(viewModel.checked.get(), 1, callbackArg_0)
            boolean callbackArg_0 = agreementCheck2.isChecked();
            // localize variables for thread safety
            // viewModel.checked.get()
            boolean[] viewModelCheckedGet = null;
            // viewModel.checked
            androidx.databinding.ObservableField<boolean[]> viewModelChecked = null;
            // viewModel.checked != null
            boolean viewModelCheckedJavaLangObjectNull = false;
            // viewModel.checked.get()[1]
            boolean viewModelChecked1 = false;
            // viewModel
            kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelChecked = viewModel.getChecked();

                viewModelCheckedJavaLangObjectNull = (viewModelChecked) != (null);
                if (viewModelCheckedJavaLangObjectNull) {


                    viewModelCheckedGet = viewModelChecked.get();



                    androidx.databinding.ViewDataBinding.setTo(viewModelCheckedGet, 1, callbackArg_0);
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener agreementCheck3androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.checked.get()[2]
            //         is androidx.databinding.ViewDataBinding.setTo(viewModel.checked.get(), 2, callbackArg_0)
            boolean callbackArg_0 = agreementCheck3.isChecked();
            // localize variables for thread safety
            // viewModel.checked.get()
            boolean[] viewModelCheckedGet = null;
            // viewModel.checked
            androidx.databinding.ObservableField<boolean[]> viewModelChecked = null;
            // viewModel.checked != null
            boolean viewModelCheckedJavaLangObjectNull = false;
            // viewModel.checked.get()[2]
            boolean viewModelChecked2 = false;
            // viewModel
            kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelChecked = viewModel.getChecked();

                viewModelCheckedJavaLangObjectNull = (viewModelChecked) != (null);
                if (viewModelCheckedJavaLangObjectNull) {


                    viewModelCheckedGet = viewModelChecked.get();



                    androidx.databinding.ViewDataBinding.setTo(viewModelCheckedGet, 2, callbackArg_0);
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener agreementCheck4androidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.checked.get()[3]
            //         is androidx.databinding.ViewDataBinding.setTo(viewModel.checked.get(), 3, callbackArg_0)
            boolean callbackArg_0 = agreementCheck4.isChecked();
            // localize variables for thread safety
            // viewModel.checked.get()
            boolean[] viewModelCheckedGet = null;
            // viewModel.checked
            androidx.databinding.ObservableField<boolean[]> viewModelChecked = null;
            // viewModel.checked != null
            boolean viewModelCheckedJavaLangObjectNull = false;
            // viewModel.checked.get()[3]
            boolean viewModelChecked3 = false;
            // viewModel
            kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelChecked = viewModel.getChecked();

                viewModelCheckedJavaLangObjectNull = (viewModelChecked) != (null);
                if (viewModelCheckedJavaLangObjectNull) {


                    viewModelCheckedGet = viewModelChecked.get();



                    androidx.databinding.ViewDataBinding.setTo(viewModelCheckedGet, 3, callbackArg_0);
                }
            }
        }
    };

    public BottomsheetAgreementBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private BottomsheetAgreementBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[6]
            , (android.widget.CheckBox) bindings[2]
            , (android.widget.CheckBox) bindings[3]
            , (android.widget.CheckBox) bindings[4]
            , (android.widget.CheckBox) bindings[5]
            , (android.widget.CheckBox) bindings[1]
            );
        this.agreementBtnNext.setTag(null);
        this.agreementCheck1.setTag(null);
        this.agreementCheck2.setTag(null);
        this.agreementCheck3.setTag(null);
        this.agreementCheck4.setTag(null);
        this.agreementCheckAll.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback17 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 1);
        mCallback18 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelChecked((androidx.databinding.ObservableField<boolean[]>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelChecked(androidx.databinding.ObservableField<boolean[]> ViewModelChecked, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        androidx.databinding.ObservableField<boolean[]> viewModelChecked = null;
        boolean viewModelChecked3 = false;
        boolean viewModelChecked0 = false;
        boolean viewModelChecked2 = false;
        boolean[] viewModelCheckedGet = null;
        boolean viewModelChecked1 = false;
        kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.checked
                    viewModelChecked = viewModel.getChecked();
                }
                updateRegistration(0, viewModelChecked);


                if (viewModelChecked != null) {
                    // read viewModel.checked.get()
                    viewModelCheckedGet = viewModelChecked.get();
                }


                if (viewModelCheckedGet != null) {
                    // read viewModel.checked.get()[3]
                    viewModelChecked3 = getFromArray(viewModelCheckedGet, 3);
                    // read viewModel.checked.get()[0]
                    viewModelChecked0 = getFromArray(viewModelCheckedGet, 0);
                    // read viewModel.checked.get()[2]
                    viewModelChecked2 = getFromArray(viewModelCheckedGet, 2);
                    // read viewModel.checked.get()[1]
                    viewModelChecked1 = getFromArray(viewModelCheckedGet, 1);
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.agreementBtnNext.setOnClickListener(mCallback18);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.agreementCheck1, (android.widget.CompoundButton.OnCheckedChangeListener)null, agreementCheck1androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.agreementCheck2, (android.widget.CompoundButton.OnCheckedChangeListener)null, agreementCheck2androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.agreementCheck3, (android.widget.CompoundButton.OnCheckedChangeListener)null, agreementCheck3androidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.agreementCheck4, (android.widget.CompoundButton.OnCheckedChangeListener)null, agreementCheck4androidCheckedAttrChanged);
            this.agreementCheckAll.setOnClickListener(mCallback17);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.agreementCheck1, viewModelChecked0);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.agreementCheck2, viewModelChecked1);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.agreementCheck3, viewModelChecked2);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.agreementCheck4, viewModelChecked3);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // viewModel
                kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.allCheck();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // viewModel
                kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.doNextBtnClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.checked
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}