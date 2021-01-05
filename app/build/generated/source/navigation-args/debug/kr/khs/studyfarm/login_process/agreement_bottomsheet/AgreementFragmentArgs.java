package kr.khs.studyfarm.login_process.agreement_bottomsheet;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class AgreementFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private AgreementFragmentArgs() {
  }

  private AgreementFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static AgreementFragmentArgs fromBundle(@NonNull Bundle bundle) {
    AgreementFragmentArgs __result = new AgreementFragmentArgs();
    bundle.setClassLoader(AgreementFragmentArgs.class.getClassLoader());
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
    if (bundle.containsKey("password")) {
      String password;
      password = bundle.getString("password");
      if (password == null) {
        throw new IllegalArgumentException("Argument \"password\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("password", password);
    } else {
      throw new IllegalArgumentException("Required argument \"password\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("nickname")) {
      String nickname;
      nickname = bundle.getString("nickname");
      if (nickname == null) {
        throw new IllegalArgumentException("Argument \"nickname\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("nickname", nickname);
    } else {
      throw new IllegalArgumentException("Required argument \"nickname\" is missing and does not have an android:defaultValue");
    }
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    AgreementFragmentArgs that = (AgreementFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
    result = 31 * result + (getNickname() != null ? getNickname().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AgreementFragmentArgs{"
        + "email=" + getEmail()
        + ", password=" + getPassword()
        + ", nickname=" + getNickname()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(AgreementFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String email, @NonNull String password, @NonNull String nickname) {
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
    public AgreementFragmentArgs build() {
      AgreementFragmentArgs result = new AgreementFragmentArgs(arguments);
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
    public Builder setPassword(@NonNull String password) {
      if (password == null) {
        throw new IllegalArgumentException("Argument \"password\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("password", password);
      return this;
    }

    @NonNull
    public Builder setNickname(@NonNull String nickname) {
      if (nickname == null) {
        throw new IllegalArgumentException("Argument \"nickname\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("nickname", nickname);
      return this;
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
  }
}
