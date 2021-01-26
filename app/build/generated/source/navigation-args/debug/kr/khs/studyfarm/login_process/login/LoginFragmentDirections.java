package kr.khs.studyfarm.login_process.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import kr.khs.studyfarm.R;

public class LoginFragmentDirections {
  private LoginFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLoginFragmentToSignupFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_signupFragment);
  }

  @NonNull
  public static NavDirections actionLoginFragmentToFindPWFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_findPWFragment);
  }
}
