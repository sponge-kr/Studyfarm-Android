package kr.khs.studyfarm.databinding;
import kr.khs.studyfarm.R;
import kr.khs.studyfarm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSelectBindingImpl extends FragmentSelectBinding implements kr.khs.studyfarm.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.select_rv_first, 5);
        sViewsWithIds.put(R.id.select_rv_second, 6);
        sViewsWithIds.put(R.id.select_scroll_chip, 7);
        sViewsWithIds.put(R.id.chipGroup, 8);
        sViewsWithIds.put(R.id.view, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final com.google.android.material.chip.Chip mboundView2;
    @NonNull
    private final com.google.android.material.chip.Chip mboundView3;
    @NonNull
    private final com.google.android.material.chip.Chip mboundView4;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback16;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSelectBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private FragmentSelectBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.Button) bindings[1]
            , (com.google.android.material.chip.ChipGroup) bindings[8]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (android.widget.HorizontalScrollView) bindings[7]
            , (android.view.View) bindings[9]
            );
        this.button2.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (com.google.android.material.chip.Chip) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (com.google.android.material.chip.Chip) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (com.google.android.material.chip.Chip) bindings[4];
        this.mboundView4.setTag(null);
        setRootTag(root);
        // listeners
        mCallback16 = new kr.khs.studyfarm.generated.callback.OnClickListener(this, 1);
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
            setViewModel((kr.khs.studyfarm.login_process.select.SelectViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable kr.khs.studyfarm.login_process.select.SelectViewModel ViewModel) {
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
                return onChangeViewModelChipVisible((androidx.lifecycle.MutableLiveData<java.util.List<java.lang.Boolean>>) object, fieldId);
            case 1 :
                return onChangeViewModelSelectData((androidx.lifecycle.MutableLiveData<java.util.ArrayList<kr.khs.studyfarm.login_process.select.SelectInfo>>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelChipVisible(androidx.lifecycle.MutableLiveData<java.util.List<java.lang.Boolean>> ViewModelChipVisible, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelSelectData(androidx.lifecycle.MutableLiveData<java.util.ArrayList<kr.khs.studyfarm.login_process.select.SelectInfo>> ViewModelSelectData, int fieldId) {
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
        java.lang.Boolean viewModelChipVisible1 = null;
        java.util.ArrayList<kr.khs.studyfarm.login_process.select.SelectInfo> viewModelSelectDataGetValue = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelChipVisible0 = false;
        kr.khs.studyfarm.login_process.select.SelectInfo viewModelSelectData1 = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelChipVisible2 = false;
        java.lang.Boolean viewModelChipVisible2 = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelChipVisible1 = false;
        java.lang.Boolean viewModelChipVisible0 = null;
        kr.khs.studyfarm.login_process.select.SelectInfo viewModelSelectData2 = null;
        kotlin.jvm.functions.Function0<kotlin.Unit> viewModelChipUpdateListener = null;
        java.util.List<java.lang.Boolean> viewModelChipVisibleGetValue = null;
        kr.khs.studyfarm.login_process.select.SelectInfo viewModelSelectData0 = null;
        androidx.lifecycle.MutableLiveData<java.util.List<java.lang.Boolean>> viewModelChipVisible = null;
        androidx.lifecycle.MutableLiveData<java.util.ArrayList<kr.khs.studyfarm.login_process.select.SelectInfo>> viewModelSelectData = null;
        kr.khs.studyfarm.login_process.select.SelectViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {



                if (viewModel != null) {
                    // read viewModel.chipUpdateListener
                    viewModelChipUpdateListener = viewModel.getChipUpdateListener();
                    // read viewModel.chipVisible
                    viewModelChipVisible = viewModel.getChipVisible();
                    // read viewModel._selectData
                    viewModelSelectData = viewModel.get_selectData();
                }
                updateLiveDataRegistration(0, viewModelChipVisible);
                updateLiveDataRegistration(1, viewModelSelectData);


                if (viewModelChipVisible != null) {
                    // read viewModel.chipVisible.getValue()
                    viewModelChipVisibleGetValue = viewModelChipVisible.getValue();
                }
                if (viewModelSelectData != null) {
                    // read viewModel._selectData.getValue()
                    viewModelSelectDataGetValue = viewModelSelectData.getValue();
                }


                if (viewModelChipVisibleGetValue != null) {
                    // read viewModel.chipVisible.getValue()[1]
                    viewModelChipVisible1 = getFromList(viewModelChipVisibleGetValue, 1);
                    // read viewModel.chipVisible.getValue()[2]
                    viewModelChipVisible2 = getFromList(viewModelChipVisibleGetValue, 2);
                    // read viewModel.chipVisible.getValue()[0]
                    viewModelChipVisible0 = getFromList(viewModelChipVisibleGetValue, 0);
                }
                if (viewModelSelectDataGetValue != null) {
                    // read viewModel._selectData.getValue()[1]
                    viewModelSelectData1 = getFromList(viewModelSelectDataGetValue, 1);
                    // read viewModel._selectData.getValue()[2]
                    viewModelSelectData2 = getFromList(viewModelSelectDataGetValue, 2);
                    // read viewModel._selectData.getValue()[0]
                    viewModelSelectData0 = getFromList(viewModelSelectDataGetValue, 0);
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.chipVisible.getValue()[1])
                androidxDatabindingViewDataBindingSafeUnboxViewModelChipVisible1 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelChipVisible1);
                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.chipVisible.getValue()[2])
                androidxDatabindingViewDataBindingSafeUnboxViewModelChipVisible2 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelChipVisible2);
                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.chipVisible.getValue()[0])
                androidxDatabindingViewDataBindingSafeUnboxViewModelChipVisible0 = androidx.databinding.ViewDataBinding.safeUnbox(viewModelChipVisible0);
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.button2.setOnClickListener(mCallback16);
        }
        if ((dirtyFlags & 0xfL) != 0) {
            // api target 1

            kr.khs.studyfarm.BindingUtilKt.setVisibility(this.mboundView2, androidxDatabindingViewDataBindingSafeUnboxViewModelChipVisible0, viewModelSelectData0, viewModelSelectDataGetValue, viewModelChipUpdateListener);
            kr.khs.studyfarm.BindingUtilKt.setVisibility(this.mboundView3, androidxDatabindingViewDataBindingSafeUnboxViewModelChipVisible1, viewModelSelectData1, viewModelSelectDataGetValue, viewModelChipUpdateListener);
            kr.khs.studyfarm.BindingUtilKt.setVisibility(this.mboundView4, androidxDatabindingViewDataBindingSafeUnboxViewModelChipVisible2, viewModelSelectData2, viewModelSelectDataGetValue, viewModelChipUpdateListener);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        kr.khs.studyfarm.login_process.select.SelectViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.gotoSignup();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.chipVisible
        flag 1 (0x2L): viewModel._selectData
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}