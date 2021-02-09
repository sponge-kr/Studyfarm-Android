package kr.khs.studyfarm;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kr.khs.studyfarm.databinding.ActivityTestBindingImpl;
import kr.khs.studyfarm.databinding.BottomsheetAgreementBindingImpl;
import kr.khs.studyfarm.databinding.ButtonLevelSelectBindingImpl;
import kr.khs.studyfarm.databinding.FragmentFindPwBindingImpl;
import kr.khs.studyfarm.databinding.FragmentFindStudyCafeBindingImpl;
import kr.khs.studyfarm.databinding.FragmentLoginBindingImpl;
import kr.khs.studyfarm.databinding.FragmentMainBindingImpl;
import kr.khs.studyfarm.databinding.FragmentMakeStudyBindingImpl;
import kr.khs.studyfarm.databinding.FragmentNotificationBindingImpl;
import kr.khs.studyfarm.databinding.FragmentProfileBindingImpl;
import kr.khs.studyfarm.databinding.FragmentSelectBindingImpl;
import kr.khs.studyfarm.databinding.FragmentSetPwBindingImpl;
import kr.khs.studyfarm.databinding.FragmentSignupAuthBindingImpl;
import kr.khs.studyfarm.databinding.FragmentSignupBindingImpl;
import kr.khs.studyfarm.databinding.FragmentSignupInfoBindingImpl;
import kr.khs.studyfarm.databinding.FragmentStudyInfoBindingImpl;
import kr.khs.studyfarm.databinding.FragmentVpInterestingBindingImpl;
import kr.khs.studyfarm.databinding.LayoutFindpwStep1BindingImpl;
import kr.khs.studyfarm.databinding.LayoutFindpwStep2BindingImpl;
import kr.khs.studyfarm.databinding.LayoutMakestudyDetailBindingImpl;
import kr.khs.studyfarm.databinding.LayoutMakestudyRecruitBindingImpl;
import kr.khs.studyfarm.databinding.LayoutSignupStep1BindingImpl;
import kr.khs.studyfarm.databinding.LayoutSignupStep2BindingImpl;
import kr.khs.studyfarm.databinding.ListItemAgreementBindingImpl;
import kr.khs.studyfarm.databinding.ListItemInterestingstudyBindingImpl;
import kr.khs.studyfarm.databinding.ListItemSelectBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYTEST = 1;

  private static final int LAYOUT_BOTTOMSHEETAGREEMENT = 2;

  private static final int LAYOUT_BUTTONLEVELSELECT = 3;

  private static final int LAYOUT_FRAGMENTFINDPW = 4;

  private static final int LAYOUT_FRAGMENTFINDSTUDYCAFE = 5;

  private static final int LAYOUT_FRAGMENTLOGIN = 6;

  private static final int LAYOUT_FRAGMENTMAIN = 7;

  private static final int LAYOUT_FRAGMENTMAKESTUDY = 8;

  private static final int LAYOUT_FRAGMENTNOTIFICATION = 9;

  private static final int LAYOUT_FRAGMENTPROFILE = 10;

  private static final int LAYOUT_FRAGMENTSELECT = 11;

  private static final int LAYOUT_FRAGMENTSETPW = 12;

  private static final int LAYOUT_FRAGMENTSIGNUP = 13;

  private static final int LAYOUT_FRAGMENTSIGNUPAUTH = 14;

  private static final int LAYOUT_FRAGMENTSIGNUPINFO = 15;

  private static final int LAYOUT_FRAGMENTSTUDYINFO = 16;

  private static final int LAYOUT_FRAGMENTVPINTERESTING = 17;

  private static final int LAYOUT_LAYOUTFINDPWSTEP1 = 18;

  private static final int LAYOUT_LAYOUTFINDPWSTEP2 = 19;

  private static final int LAYOUT_LAYOUTMAKESTUDYDETAIL = 20;

  private static final int LAYOUT_LAYOUTMAKESTUDYRECRUIT = 21;

  private static final int LAYOUT_LAYOUTSIGNUPSTEP1 = 22;

  private static final int LAYOUT_LAYOUTSIGNUPSTEP2 = 23;

  private static final int LAYOUT_LISTITEMAGREEMENT = 24;

  private static final int LAYOUT_LISTITEMINTERESTINGSTUDY = 25;

  private static final int LAYOUT_LISTITEMSELECT = 26;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(26);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.activity_test, LAYOUT_ACTIVITYTEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.bottomsheet_agreement, LAYOUT_BOTTOMSHEETAGREEMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.button_level_select, LAYOUT_BUTTONLEVELSELECT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_find_pw, LAYOUT_FRAGMENTFINDPW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_find_study_cafe, LAYOUT_FRAGMENTFINDSTUDYCAFE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_main, LAYOUT_FRAGMENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_make_study, LAYOUT_FRAGMENTMAKESTUDY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_notification, LAYOUT_FRAGMENTNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_select, LAYOUT_FRAGMENTSELECT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_set_pw, LAYOUT_FRAGMENTSETPW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_signup, LAYOUT_FRAGMENTSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_signup_auth, LAYOUT_FRAGMENTSIGNUPAUTH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_signup_info, LAYOUT_FRAGMENTSIGNUPINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_study_info, LAYOUT_FRAGMENTSTUDYINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.fragment_vp_interesting, LAYOUT_FRAGMENTVPINTERESTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.layout_findpw_step1, LAYOUT_LAYOUTFINDPWSTEP1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.layout_findpw_step2, LAYOUT_LAYOUTFINDPWSTEP2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.layout_makestudy_detail, LAYOUT_LAYOUTMAKESTUDYDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.layout_makestudy_recruit, LAYOUT_LAYOUTMAKESTUDYRECRUIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.layout_signup_step1, LAYOUT_LAYOUTSIGNUPSTEP1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.layout_signup_step2, LAYOUT_LAYOUTSIGNUPSTEP2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.list_item_agreement, LAYOUT_LISTITEMAGREEMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.list_item_interestingstudy, LAYOUT_LISTITEMINTERESTINGSTUDY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.khs.studyfarm.R.layout.list_item_select, LAYOUT_LISTITEMSELECT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYTEST: {
          if ("layout/activity_test_0".equals(tag)) {
            return new ActivityTestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_test is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETAGREEMENT: {
          if ("layout/bottomsheet_agreement_0".equals(tag)) {
            return new BottomsheetAgreementBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottomsheet_agreement is invalid. Received: " + tag);
        }
        case  LAYOUT_BUTTONLEVELSELECT: {
          if ("layout/button_level_select_0".equals(tag)) {
            return new ButtonLevelSelectBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for button_level_select is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFINDPW: {
          if ("layout/fragment_find_pw_0".equals(tag)) {
            return new FragmentFindPwBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_find_pw is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFINDSTUDYCAFE: {
          if ("layout/fragment_find_study_cafe_0".equals(tag)) {
            return new FragmentFindStudyCafeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_find_study_cafe is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAIN: {
          if ("layout/fragment_main_0".equals(tag)) {
            return new FragmentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAKESTUDY: {
          if ("layout/fragment_make_study_0".equals(tag)) {
            return new FragmentMakeStudyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_make_study is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNOTIFICATION: {
          if ("layout/fragment_notification_0".equals(tag)) {
            return new FragmentNotificationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_notification is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSELECT: {
          if ("layout/fragment_select_0".equals(tag)) {
            return new FragmentSelectBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_select is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSETPW: {
          if ("layout/fragment_set_pw_0".equals(tag)) {
            return new FragmentSetPwBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_set_pw is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNUP: {
          if ("layout/fragment_signup_0".equals(tag)) {
            return new FragmentSignupBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_signup is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNUPAUTH: {
          if ("layout/fragment_signup_auth_0".equals(tag)) {
            return new FragmentSignupAuthBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_signup_auth is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNUPINFO: {
          if ("layout/fragment_signup_info_0".equals(tag)) {
            return new FragmentSignupInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_signup_info is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSTUDYINFO: {
          if ("layout/fragment_study_info_0".equals(tag)) {
            return new FragmentStudyInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_study_info is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTVPINTERESTING: {
          if ("layout/fragment_vp_interesting_0".equals(tag)) {
            return new FragmentVpInterestingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_vp_interesting is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTFINDPWSTEP1: {
          if ("layout/layout_findpw_step1_0".equals(tag)) {
            return new LayoutFindpwStep1BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_findpw_step1 is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTFINDPWSTEP2: {
          if ("layout/layout_findpw_step2_0".equals(tag)) {
            return new LayoutFindpwStep2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_findpw_step2 is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTMAKESTUDYDETAIL: {
          if ("layout/layout_makestudy_detail_0".equals(tag)) {
            return new LayoutMakestudyDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_makestudy_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTMAKESTUDYRECRUIT: {
          if ("layout/layout_makestudy_recruit_0".equals(tag)) {
            return new LayoutMakestudyRecruitBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_makestudy_recruit is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSIGNUPSTEP1: {
          if ("layout/layout_signup_step1_0".equals(tag)) {
            return new LayoutSignupStep1BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_signup_step1 is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSIGNUPSTEP2: {
          if ("layout/layout_signup_step2_0".equals(tag)) {
            return new LayoutSignupStep2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_signup_step2 is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMAGREEMENT: {
          if ("layout/list_item_agreement_0".equals(tag)) {
            return new ListItemAgreementBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_agreement is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMINTERESTINGSTUDY: {
          if ("layout/list_item_interestingstudy_0".equals(tag)) {
            return new ListItemInterestingstudyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_interestingstudy is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMSELECT: {
          if ("layout/list_item_select_0".equals(tag)) {
            return new ListItemSelectBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_select is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(7);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "clickListener");
      sKeys.put(2, "data");
      sKeys.put(3, "gender");
      sKeys.put(4, "termsData");
      sKeys.put(5, "view");
      sKeys.put(6, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(26);

    static {
      sKeys.put("layout/activity_test_0", kr.khs.studyfarm.R.layout.activity_test);
      sKeys.put("layout/bottomsheet_agreement_0", kr.khs.studyfarm.R.layout.bottomsheet_agreement);
      sKeys.put("layout/button_level_select_0", kr.khs.studyfarm.R.layout.button_level_select);
      sKeys.put("layout/fragment_find_pw_0", kr.khs.studyfarm.R.layout.fragment_find_pw);
      sKeys.put("layout/fragment_find_study_cafe_0", kr.khs.studyfarm.R.layout.fragment_find_study_cafe);
      sKeys.put("layout/fragment_login_0", kr.khs.studyfarm.R.layout.fragment_login);
      sKeys.put("layout/fragment_main_0", kr.khs.studyfarm.R.layout.fragment_main);
      sKeys.put("layout/fragment_make_study_0", kr.khs.studyfarm.R.layout.fragment_make_study);
      sKeys.put("layout/fragment_notification_0", kr.khs.studyfarm.R.layout.fragment_notification);
      sKeys.put("layout/fragment_profile_0", kr.khs.studyfarm.R.layout.fragment_profile);
      sKeys.put("layout/fragment_select_0", kr.khs.studyfarm.R.layout.fragment_select);
      sKeys.put("layout/fragment_set_pw_0", kr.khs.studyfarm.R.layout.fragment_set_pw);
      sKeys.put("layout/fragment_signup_0", kr.khs.studyfarm.R.layout.fragment_signup);
      sKeys.put("layout/fragment_signup_auth_0", kr.khs.studyfarm.R.layout.fragment_signup_auth);
      sKeys.put("layout/fragment_signup_info_0", kr.khs.studyfarm.R.layout.fragment_signup_info);
      sKeys.put("layout/fragment_study_info_0", kr.khs.studyfarm.R.layout.fragment_study_info);
      sKeys.put("layout/fragment_vp_interesting_0", kr.khs.studyfarm.R.layout.fragment_vp_interesting);
      sKeys.put("layout/layout_findpw_step1_0", kr.khs.studyfarm.R.layout.layout_findpw_step1);
      sKeys.put("layout/layout_findpw_step2_0", kr.khs.studyfarm.R.layout.layout_findpw_step2);
      sKeys.put("layout/layout_makestudy_detail_0", kr.khs.studyfarm.R.layout.layout_makestudy_detail);
      sKeys.put("layout/layout_makestudy_recruit_0", kr.khs.studyfarm.R.layout.layout_makestudy_recruit);
      sKeys.put("layout/layout_signup_step1_0", kr.khs.studyfarm.R.layout.layout_signup_step1);
      sKeys.put("layout/layout_signup_step2_0", kr.khs.studyfarm.R.layout.layout_signup_step2);
      sKeys.put("layout/list_item_agreement_0", kr.khs.studyfarm.R.layout.list_item_agreement);
      sKeys.put("layout/list_item_interestingstudy_0", kr.khs.studyfarm.R.layout.list_item_interestingstudy);
      sKeys.put("layout/list_item_select_0", kr.khs.studyfarm.R.layout.list_item_select);
    }
  }
}
