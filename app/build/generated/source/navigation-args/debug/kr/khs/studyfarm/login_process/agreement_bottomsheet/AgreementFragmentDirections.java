package kr.khs.studyfarm.login_process.agreement_bottomsheet;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import kr.khs.studyfarm.R;

public class AgreementFragmentDirections {
  private AgreementFragmentDirections() {
  }

  @NonNull
  public static ActionAgreementFragmentToSignupAuthFragment actionAgreementFragmentToSignupAuthFragment(
      @NonNull String email, int seq) {
    return new ActionAgreementFragmentToSignupAuthFragment(email, seq);
  }

  public static class ActionAgreementFragmentToSignupAuthFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionAgreementFragmentToSignupAuthFragment(@NonNull String email, int seq) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      this.arguments.put("seq", seq);
    }

    @NonNull
    public ActionAgreementFragmentToSignupAuthFragment setEmail(@NonNull String email) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public ActionAgreementFragmentToSignupAuthFragment setSeq(int seq) {
      this.arguments.put("seq", seq);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("email")) {
        String email = (String) arguments.get("email");
        __result.putString("email", email);
      }
      if (arguments.containsKey("seq")) {
        int seq = (int) arguments.get("seq");
        __result.putInt("seq", seq);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_agreementFragment_to_signupAuthFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getEmail() {
      return (String) arguments.get("email");
    }

    @SuppressWarnings("unchecked")
    public int getSeq() {
      return (int) arguments.get("seq");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionAgreementFragmentToSignupAuthFragment that = (ActionAgreementFragmentToSignupAuthFragment) object;
      if (arguments.containsKey("email") != that.arguments.containsKey("email")) {
        return false;
      }
      if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) {
        return false;
      }
      if (arguments.containsKey("seq") != that.arguments.containsKey("seq")) {
        return false;
      }
      if (getSeq() != that.getSeq()) {
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
      result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
      result = 31 * result + getSeq();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionAgreementFragmentToSignupAuthFragment(actionId=" + getActionId() + "){"
          + "email=" + getEmail()
          + ", seq=" + getSeq()
          + "}";
    }
  }
}
