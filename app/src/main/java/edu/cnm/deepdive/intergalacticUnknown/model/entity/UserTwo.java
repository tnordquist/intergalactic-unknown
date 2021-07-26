package edu.cnm.deepdive.intergalacticUnknown.model.entity;

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
public class UserTwo {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  @NonNull
  private long userId;

  @ColumnInfo(name = "user_name")
  private String userName;

  @ColumnInfo(name = "oath_key")
  private String oathKey;

}
