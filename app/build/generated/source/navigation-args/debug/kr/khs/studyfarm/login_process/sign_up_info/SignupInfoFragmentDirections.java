package kr.khs.studyfarm.login_process.sign_up_info;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import kr.khs.studyfarm.R;
import kr.khs.studyfarm.login_process.select.SelectInfo;

public class SignupInfoFragmentDirections {
  private SignupInfoFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSignupInfoFragmentToLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_signupInfoFragment_to_loginFragment);
  }

  @NonNull
  public static ActionSignupInfoFragmentToSelectFragment actionSignupInfoFragmentToSelectFragment(
      int seq, boolean cityOrInterested, @Nullable SelectInfo[] cities,
      @Nullable SelectInfo[] interested) {
    return new ActionSignupInfoFragmentToSelectFragment(seq, cityOrInterested, cities, interested);
  }

  public static class ActionSignupInfoFragmentToSelectFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSignupInfoFragmentToSelectFragment(int seq, boolean cityOrInterested,
        @Nullable SelectInfo[] cities, @Nullable SelectInfo[] interested) {
      this.arguments.put("seq", seq);
      this.arguments.put("cityOrInterested", cityOrInterested);
      this.arguments.put("cities", cities);
      this.arguments.put("interested", interested);
    }

    @NonNull
    public ActionSignupInfoFragmentToSelectFragment setSeq(int seq) {
      this.arguments.put("seq", seq);
      return this;
    }

    @NonNull
    public ActionSignupInfoFragmentToSelectFragment setCityOrInterested(boolean cityOrInterested) {
      this.arguments.put("cityOrInterested", cityOrInterested);
      return this;
    }

    @NonNull
    public ActionSignupInfoFragmentToSelectFragment setCities(@Nullable SelectInfo[] cities) {
      this.arguments.put("cities", cities);
      return this;
    }

    @NonNull
    public ActionSignupInfoFragmentToSelectFragment setInterested(
        @Nullable SelectInfo[] interested) {
      this.arguments.put("interested", interested);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("seq")) {
        int seq = (int) arguments.get("seq");
        __result.putInt("seq", seq);
      }
      if (arguments.containsKey("cityOrInterested")) {
        boolean cityOrInterested = (boolean) arguments.get("cityOrInterested");
        __result.putBoolean("cityOrInterested", cityOrInterested);
      }
      if (arguments.containsKey("cities")) {
        SelectInfo[] cities = (SelectInfo[]) arguments.get("cities");
        __result.putParcelableArray("cities", cities);
      }
      if (arguments.containsKey("interested")) {
        SelectInfo[] interested = (SelectInfo[]) arguments.get("interested");
        __result.putParcelableArray("interested", interested);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_signupInfoFragment_to_selectFragment;
    }

    @SuppressWarnings("unchecked")
    public int getSeq() {
      return (int) arguments.get("seq");
    }

    @SuppressWarnings("unchecked")
    public boolean getCityOrInterested() {
      return (boolean) arguments.get("cityOrInterested");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public SelectInfo[] getCities() {
      return (SelectInfo[]) arguments.get("cities");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public SelectInfo[] getInterested() {
      return (SelectInfo[]) arguments.get("interested");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSignupInfoFragmentToSelectFragment that = (ActionSignupInfoFragmentToSelectFragment) object;
      if (arguments.containsKey("seq") != that.arguments.containsKey("seq")) {
        return false;
      }
      if (getSeq() != that.getSeq()) {
        return false;
      }
      if (arguments.containsKey("cityOrInterested") != that.arguments.containsKey("cityOrInterested")) {
        return false;
      }
      if (getCityOrInterested() != that.getCityOrInterested()) {
        return false;
      }
      if (arguments.containsKey("cities") != that.arguments.containsKey("cities")) {
        return false;
      }
      if (getCities() != null ? !getCities().equals(that.getCities()) : that.getCities() != null) {
        return false;
      }
      if (arguments.containsKey("interested") != that.arguments.containsKey("interested")) {
        return false;
      }
      if (getInterested() != null ? !getInterested().equals(that.getInterested()) : that.getInterested() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getSeq();
      result = 31 * result + (getCityOrInterested() ? 1 : 0);
      result = 31 * result + java.util.Arrays.hashCode(getCities());
      result = 31 * result + java.util.Arrays.hashCode(getInterested());
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSignupInfoFragmentToSelectFragment(actionId=" + getActionId() + "){"
          + "seq=" + getSeq()
          + ", cityOrInterested=" + getCityOrInterested()
          + ", cities=" + getCities()
          + ", interested=" + getInterested()
          + "}";
    }
  }
}
