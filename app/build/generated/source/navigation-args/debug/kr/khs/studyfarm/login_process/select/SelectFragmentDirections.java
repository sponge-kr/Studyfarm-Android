package kr.khs.studyfarm.login_process.select;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import kr.khs.studyfarm.R;

public class SelectFragmentDirections {
  private SelectFragmentDirections() {
  }

  @NonNull
  public static ActionSelectFragmentToSignupInfoFragment actionSelectFragmentToSignupInfoFragment(
      int seq, @Nullable SelectInfo[] cities, @Nullable SelectInfo[] interested) {
    return new ActionSelectFragmentToSignupInfoFragment(seq, cities, interested);
  }

  public static class ActionSelectFragmentToSignupInfoFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSelectFragmentToSignupInfoFragment(int seq, @Nullable SelectInfo[] cities,
        @Nullable SelectInfo[] interested) {
      this.arguments.put("seq", seq);
      this.arguments.put("cities", cities);
      this.arguments.put("interested", interested);
    }

    @NonNull
    public ActionSelectFragmentToSignupInfoFragment setSeq(int seq) {
      this.arguments.put("seq", seq);
      return this;
    }

    @NonNull
    public ActionSelectFragmentToSignupInfoFragment setCities(@Nullable SelectInfo[] cities) {
      this.arguments.put("cities", cities);
      return this;
    }

    @NonNull
    public ActionSelectFragmentToSignupInfoFragment setInterested(
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
      return R.id.action_selectFragment_to_signupInfoFragment;
    }

    @SuppressWarnings("unchecked")
    public int getSeq() {
      return (int) arguments.get("seq");
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
      ActionSelectFragmentToSignupInfoFragment that = (ActionSelectFragmentToSignupInfoFragment) object;
      if (arguments.containsKey("seq") != that.arguments.containsKey("seq")) {
        return false;
      }
      if (getSeq() != that.getSeq()) {
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
      result = 31 * result + java.util.Arrays.hashCode(getCities());
      result = 31 * result + java.util.Arrays.hashCode(getInterested());
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSelectFragmentToSignupInfoFragment(actionId=" + getActionId() + "){"
          + "seq=" + getSeq()
          + ", cities=" + getCities()
          + ", interested=" + getInterested()
          + "}";
    }
  }
}
