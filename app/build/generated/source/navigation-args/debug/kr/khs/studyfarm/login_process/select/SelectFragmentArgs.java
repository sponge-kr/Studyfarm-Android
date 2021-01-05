package kr.khs.studyfarm.login_process.select;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.util.HashMap;

public class SelectFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SelectFragmentArgs() {
  }

  private SelectFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SelectFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SelectFragmentArgs __result = new SelectFragmentArgs();
    bundle.setClassLoader(SelectFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("seq")) {
      int seq;
      seq = bundle.getInt("seq");
      __result.arguments.put("seq", seq);
    } else {
      throw new IllegalArgumentException("Required argument \"seq\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("cityOrInterested")) {
      boolean cityOrInterested;
      cityOrInterested = bundle.getBoolean("cityOrInterested");
      __result.arguments.put("cityOrInterested", cityOrInterested);
    } else {
      throw new IllegalArgumentException("Required argument \"cityOrInterested\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("cities")) {
      SelectInfo[] cities;
      Parcelable[] __array = bundle.getParcelableArray("cities");
      if (__array != null) {
        cities = new SelectInfo[__array.length];
        System.arraycopy(__array, 0, cities, 0, __array.length);
      } else {
        cities = null;
      }
      __result.arguments.put("cities", cities);
    } else {
      throw new IllegalArgumentException("Required argument \"cities\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("interested")) {
      SelectInfo[] interested;
      Parcelable[] __array = bundle.getParcelableArray("interested");
      if (__array != null) {
        interested = new SelectInfo[__array.length];
        System.arraycopy(__array, 0, interested, 0, __array.length);
      } else {
        interested = null;
      }
      __result.arguments.put("interested", interested);
    } else {
      throw new IllegalArgumentException("Required argument \"interested\" is missing and does not have an android:defaultValue");
    }
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    SelectFragmentArgs that = (SelectFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getSeq();
    result = 31 * result + (getCityOrInterested() ? 1 : 0);
    result = 31 * result + java.util.Arrays.hashCode(getCities());
    result = 31 * result + java.util.Arrays.hashCode(getInterested());
    return result;
  }

  @Override
  public String toString() {
    return "SelectFragmentArgs{"
        + "seq=" + getSeq()
        + ", cityOrInterested=" + getCityOrInterested()
        + ", cities=" + getCities()
        + ", interested=" + getInterested()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SelectFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(int seq, boolean cityOrInterested, @Nullable SelectInfo[] cities,
        @Nullable SelectInfo[] interested) {
      this.arguments.put("seq", seq);
      this.arguments.put("cityOrInterested", cityOrInterested);
      this.arguments.put("cities", cities);
      this.arguments.put("interested", interested);
    }

    @NonNull
    public SelectFragmentArgs build() {
      SelectFragmentArgs result = new SelectFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setSeq(int seq) {
      this.arguments.put("seq", seq);
      return this;
    }

    @NonNull
    public Builder setCityOrInterested(boolean cityOrInterested) {
      this.arguments.put("cityOrInterested", cityOrInterested);
      return this;
    }

    @NonNull
    public Builder setCities(@Nullable SelectInfo[] cities) {
      this.arguments.put("cities", cities);
      return this;
    }

    @NonNull
    public Builder setInterested(@Nullable SelectInfo[] interested) {
      this.arguments.put("interested", interested);
      return this;
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
  }
}
