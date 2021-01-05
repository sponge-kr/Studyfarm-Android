package kr.khs.studyfarm.login_process.sign_up_auth;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SignupAuthFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SignupAuthFragmentArgs() {
  }

  private SignupAuthFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SignupAuthFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SignupAuthFragmentArgs __result = new SignupAuthFragmentArgs();
    bundle.setClassLoader(SignupAuthFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("email")) {
      String email;
      email = bundle.getString("email");
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("email", email);
    } else {
      throw new IllegalArgumentException("Required argument \"email\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("seq")) {
      int seq;
      seq = bundle.getInt("seq");
      __result.arguments.put("seq", seq);
    } else {
      throw new IllegalArgumentException("Required argument \"seq\" is missing and does not have an android:defaultValue");
    }
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    SignupAuthFragmentArgs that = (SignupAuthFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + getSeq();
    return result;
  }

  @Override
  public String toString() {
    return "SignupAuthFragmentArgs{"
        + "email=" + getEmail()
        + ", seq=" + getSeq()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SignupAuthFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String email, int seq) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      this.arguments.put("seq", seq);
    }

    @NonNull
    public SignupAuthFragmentArgs build() {
      SignupAuthFragmentArgs result = new SignupAuthFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setEmail(@NonNull String email) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public Builder setSeq(int seq) {
      this.arguments.put("seq", seq);
      return this;
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
  }
}
