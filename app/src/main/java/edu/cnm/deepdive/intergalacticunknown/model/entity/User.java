package edu.cnm.deepdive.intergalacticunknown.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = {
        @Index(value = {"oauth_key"}, unique = true)
    }
)
public class User {

  @PrimaryKey (autoGenerate = true)
  @ColumnInfo (name = "user_id")
  private long id;

  @NonNull
  @ColumnInfo (name = "oauth_key")
  private String oauthKey;

//  @NonNull
//  @ColumnInfo (name = "user_name")
//  private String userName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getOauthKey() {
    return oauthKey;
  }

  public void setOauthKey(@NonNull String oauthKey) {
    this.oauthKey = oauthKey;
  }

//  @NonNull
//  public String getUserName() {
//    return userName;
//  }
//
//  public void setUserName(@NonNull String userName) {
//    this.userName = userName;
//  }
}
