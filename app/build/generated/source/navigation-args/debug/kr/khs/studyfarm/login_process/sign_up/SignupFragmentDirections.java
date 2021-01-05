package kr.khs.studyfarm.login_process.sign_up;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import kr.khs.studyfarm.R;

public class SignupFragmentDirections {
  private SignupFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSignupFragmentToLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_signupFragment_to_loginFragment);
  }

  @NonNull
  public static ActionSignupFragmentToAgreementFragment actionSignupFragmentToAgreementFragment(
      @NonNull String email, @NonNull String password, @NonNull String nickname) {
    return new ActionSignupFragmentToAgreementFragment(email, password, nickname);
  }

  public static class ActionSignupFragmentToAgreementFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSignupFragmentToAgreementFragment(@NonNull String email, @NonNull String password,
        @NonNull String nickname) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      if (password == null) {
        throw new IllegalArgumentException("Argument \"password\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("password", password);
      if (nickname == null) {
        throw new IllegalArgumentException("Argument \"nickname\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("nickname", nickname);
    }

    @NonNull
    public ActionSignupFragmentToAgreementFragment setEmail(@NonNull String email) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public ActionSignupFragmentToAgreementFragment setPassword(@NonNull String password) {
      if (password == null) {
        throw new IllegalArgumentException("Argument \"password\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("password", password);
      return this;
    }

    @NonNull
    public ActionSignupFragmentToAgreementFragment setNickname(@NonNull String nickname) {
      if (nickname == null) {
        throw new IllegalArgumentException("Argument \"nickname\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("nickname", nickname);
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
      if (arguments.containsKey("password")) {
        String password = (String) arguments.get("password");
        __result.putString("password", password);
      }
      if (arguments.containsKey("nickname")) {
        String nickname = (String) arguments.get("nickname");
        __result.putString("nickname", nickname);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_signupFragment_to_agreementFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getEmail() {
      return (String) arguments.get("email");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPassword() {
      return (String) arguments.get("password");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getNickname() {
      return (String) arguments.get("nickname");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSignupFragmentToAgreementFragment that = (ActionSignupFragmentToAgreementFragment) object;
      if (arguments.containsKey("email") != that.arguments.containsKey("email")) {
        return false;
      }
      if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) {
        return false;
      }
      if (arguments.containsKey("password") != that.arguments.containsKey("password")) {
        return false;
      }
      if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null) {
        return false;
      }
      if (arguments.containsKey("nickname") != that.arguments.containsKey("nickname")) {
        return false;
      }
      if (getNickname() != null ? !getNickname().equals(that.getNickname()) : that.getNickname() != null) {
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
      result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
      result = 31 * result + (getNickname() != null ? getNickname().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSignupFragmentToAgreementFragment(actionId=" + getActionId() + "){"
          + "email=" + getEmail()
          + ", password=" + getPassword()
          + ", nickname=" + getNickname()
          + "}";
    }
  }
}
